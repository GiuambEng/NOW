package com.nttdata.tim.now.adapters.rest.filters;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.message.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class LoggingFilter implements ClientRequestFilter, ClientResponseFilter, WriterInterceptor {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected static final int MAX_ENTITY_SIZE = 8 * 1024;
	private static final String ENTITY_LOGGER_PROPERTY = LoggingFilter.class.getName() + ".entityLogger";

	@Override
	public void filter(final ClientRequestContext context) throws IOException {
		final StringBuilder b = new StringBuilder();
		b.append("Request: ");

		if (context.hasEntity()) {
			final LoggingStream stream = new LoggingStream(b, context.getEntityStream());
			context.setEntityStream(stream);
			context.setProperty(ENTITY_LOGGER_PROPERTY, stream);
		} else {
			logger.info("Request: No JSON");
		}
	}

	@Override
	public void filter(final ClientRequestContext requestContext, final ClientResponseContext responseContext) throws IOException {
		final StringBuilder b = new StringBuilder();
		b.append("(").append(responseContext.getStatus()).append(") Response: ");
		if (responseContext.hasEntity()) {
			final InputStream stream = logInboundEntity(b, responseContext.getEntityStream(), MessageUtils.getCharset(responseContext.getMediaType()));
			responseContext.setEntityStream(stream);
		} else {
			logger.info("Response: No JSON");
		}

		logger.info(b.toString());
	}

	private InputStream logInboundEntity(final StringBuilder b, InputStream stream, final Charset charset) throws IOException {
		if (!stream.markSupported()) {
			stream = new BufferedInputStream(stream);
		}
		stream.mark(MAX_ENTITY_SIZE + 1);
		final byte[] entity = new byte[MAX_ENTITY_SIZE + 1];
		final int entitySize = stream.read(entity);
		String entityString = new String(entity, 0, Math.min(entitySize, MAX_ENTITY_SIZE), charset);
		if (StringUtils.isNotEmpty(entityString)) {
			b.append(entityString.replaceAll("[\\t\\n\\r]+", ""));
		}
		if (entitySize > MAX_ENTITY_SIZE) {
			b.append("...more...");
		}
		stream.reset();
		return stream;
	}

	private class LoggingStream extends FilterOutputStream {
		private StringBuilder b;
		private ByteArrayOutputStream baos = new ByteArrayOutputStream();

		LoggingStream(final StringBuilder b, final OutputStream inner) {
			super(inner);
			this.b = b;
		}

		StringBuilder getStringBuilder(final Charset charset) {
			// write entity to the builder
			final byte[] entity = baos.toByteArray();
			String entityString = new String(entity, 0, Math.min(entity.length, MAX_ENTITY_SIZE), charset);
			if (StringUtils.isNotEmpty(entityString)) {
				b.append(entityString.replaceAll("[\\t\\n\\r]+", ""));
			}
			if (entity.length > MAX_ENTITY_SIZE) {
				b.append("...more...");
			}
			return b;
		}

		@Override
		public void write(final int i) throws IOException {
			if (baos.size() <= MAX_ENTITY_SIZE) {
				baos.write(i);
			}
			out.write(i);
		}
	}

	@Override
	public void aroundWriteTo(final WriterInterceptorContext writerInterceptorContext) throws WebApplicationException, IOException {
		final LoggingStream stream = (LoggingStream) writerInterceptorContext.getProperty(ENTITY_LOGGER_PROPERTY);
		writerInterceptorContext.proceed();
		if (stream != null) {
			logger.info(stream.getStringBuilder(MessageUtils.getCharset(writerInterceptorContext.getMediaType())).toString());
		}
	}

}