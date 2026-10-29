package com.nttdata.tim.now.adapters.rest.filters;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;

import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.util.logging.MdcHelper;

@Provider
public class MdcFilter implements ClientRequestFilter, ClientResponseFilter {

	@Override
	public void filter(final ClientRequestContext requestContext, final ClientResponseContext responseContext) throws IOException {
		MdcHelper.put(Constants.MDC_LOG_PARAMETER_SRVC_URL, requestContext.getUri().toString());
		MdcHelper.put(Constants.MDC_LOG_PARAMETER_METHOD, requestContext.getMethod());
		MdcHelper.put(Constants.MDC_LOG_PARAMETER_STATUS, String.valueOf(responseContext.getStatus()));
	}

	@Override
	public void filter(final ClientRequestContext requestContext) throws IOException {
		MdcHelper.put(Constants.MDC_LOG_PARAMETER_SRVC_URL, requestContext.getUri().toString());
		MdcHelper.put(Constants.MDC_LOG_PARAMETER_METHOD, requestContext.getMethod());
	}

}
