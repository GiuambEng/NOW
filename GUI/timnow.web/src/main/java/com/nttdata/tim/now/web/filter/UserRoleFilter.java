package com.nttdata.tim.now.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.util.properties.PropertiesHelper;
import com.nttdata.tim.now.web.utils.HeaderMapRequestWrapper;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserRoleFilter implements Filter {

	private static final String TEST_UID = "testUID";
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		// nothing to do
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain next) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		if (PropertiesHelper.isTEST()) {
			String forcedUsername = null;
			Cookie[] cookies = request.getCookies();
	        if (cookies != null){
	          for (Cookie ck : cookies) {
	            if (TEST_UID.equals(ck.getName())) {
	            	forcedUsername = ck.getValue();
	            	logger.debug("Forced username by cookie: " + forcedUsername);
	            }
	          }
	        }
	        
			if (StringUtils.isNotEmpty(forcedUsername)) {
				HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(request);
				requestWrapper.addHeader(PropertiesHelper.getStringProperty(Constants.HEADER_USERNAME_VAR_PROPERTY), forcedUsername);
				request = requestWrapper;
			}
			}
			next.doFilter(request, response);
		}

	@Override
	public void destroy() {
		// nothing to do
	}
}
