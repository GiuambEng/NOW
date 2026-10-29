package com.nttdata.tim.now.web.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.util.logging.MdcHelper;
import com.nttdata.tim.now.web.utils.RequestHelper;

public class MdcEnhancerFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		try {
			HttpServletRequest request = (HttpServletRequest) servletRequest;
			HttpServletResponse response = (HttpServletResponse) servletResponse;
			
			String tid = UUID.randomUUID().toString().replaceAll("-", "");
			String sid = request.getSession().getId();
			String username = RequestHelper.getAuthUsername(request);
			
			MdcHelper.put(Constants.MDC_LOG_PARAMETER_SID, sid);
			MdcHelper.put(Constants.MDC_LOG_PARAMETER_TID, tid);
			MdcHelper.put(Constants.MDC_LOG_PARAMETER_UID, username);
			
			filterChain.doFilter(request, response);
			
		} finally {
			MdcHelper.remove(Constants.MDC_LOG_PARAMETER_SID);
			MdcHelper.remove(Constants.MDC_LOG_PARAMETER_TID);
			MdcHelper.remove(Constants.MDC_LOG_PARAMETER_UID);
		}		
	}
	
	@Override
	public void destroy() {
	}
}
