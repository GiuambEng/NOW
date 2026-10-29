package com.nttdata.tim.now.adapters.rest.filters;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;

import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.util.logging.MdcHelper;

@Provider
public class RequestEnhancerFilter implements ClientRequestFilter {

	@Override
	public void filter(final ClientRequestContext requestContext) throws IOException {
		requestContext.getHeaders().putSingle("GUI-SID", MdcHelper.get(Constants.MDC_LOG_PARAMETER_SID));
		requestContext.getHeaders().putSingle("GUI-TID", MdcHelper.get(Constants.MDC_LOG_PARAMETER_TID));
		requestContext.getHeaders().putSingle("GUI-UID", MdcHelper.get(Constants.MDC_LOG_PARAMETER_UID));
	}

}
