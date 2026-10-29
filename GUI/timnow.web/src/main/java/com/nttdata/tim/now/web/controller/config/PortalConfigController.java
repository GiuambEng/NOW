package com.nttdata.tim.now.web.controller.config;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.config.PortalConfigManagerBL;
import com.nttdata.tim.now.core.service.utente.ProfileManagerBL;
import com.nttdata.tim.now.data.bean.fe.FEInitBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;
import com.nttdata.tim.now.web.utils.WebAttributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class PortalConfigController extends GenericController {
    
    @Autowired
    private PortalConfigManagerBL portalConfigManagerBL;
    
    @Autowired
    private ProfileManagerBL profileManagerBL;

    
	@JsonGetMapping("/fe")
	public Map<String, Object> getFEConfigurationMap() throws BusinessLayerException {
		logger.info("get FE config");
		return portalConfigManagerBL.getFEConfiguration();
	}

	@JsonGetMapping
	public FEInitBean getConfigAndUser(HttpSession session) throws BusinessLayerException {
		logger.info("get FE config and user details");
		UserBean user = getCurrentUser(session);
		FEInitBean feInitBean = new FEInitBean();

		feInitBean.setUser(user);
		Map<String, Object> configMap = portalConfigManagerBL.getFEConfiguration();
		feInitBean.setConfig(configMap);
		@SuppressWarnings("unchecked")
		Map<String, List<String>> authorizationByRole = (Map<String, List<String>>) session.getAttribute(WebAttributes.SESSION_USER_AUTHORIZATIONS);
        if (authorizationByRole == null) {
            logger.debug("authorizations mapping not in session: calculating");
        }
		Map<String, List<String>> authorizationsMap = profileManagerBL.getFunctionsAuthorizationByProfile(user.getCodiceProfilo());
		session.setAttribute(WebAttributes.SESSION_USER_AUTHORIZATIONS, authorizationsMap);
		feInitBean.setAuthorizations(authorizationsMap);
		feInitBean.setResult(getSuccessResult());
		return feInitBean;
	}

}