package com.nttdata.tim.now.adapters.rest.filters.statistic;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;

import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.util.logging.MdcHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class StatisticFilter implements ClientRequestFilter, ClientResponseFilter {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String REQUEST_START_TIME = "request.statistic.start.time";
	
	@Override
	public void filter(final ClientRequestContext requestContext) throws IOException {
		requestContext.setProperty(REQUEST_START_TIME, System.currentTimeMillis());
	}
	
	@Override
	public void filter(final ClientRequestContext requestContext, final ClientResponseContext responseContext) throws IOException {
		long start = (long) requestContext.getProperty(REQUEST_START_TIME);
		long total = System.currentTimeMillis() - start;
		MdcHelper.put(Constants.MDC_LOG_PARAMETER_ELAPSED_TIME, String.valueOf(total));
		logger.info("Rest execution for {} {} completed in {} ms.", requestContext.getUri(), requestContext.getMethod(), total);
	}

}
