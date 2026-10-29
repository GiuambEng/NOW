package com.nttdata.tim.now.core.service.utente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nttdata.tim.now.adapters.esb.utente.ProfiledFunctionsRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.InvalidFilenameException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.dto.profiledfunctions.ProfiledFunctionsDTO;
import com.nttdata.tim.now.data.dto.profiledfunctions.ProfiledFunctionsListDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileManagerBL extends AbstractBL implements InitializingBean {

    private List<ProfiledFunctionsDTO> profiledFunctions;

	@Autowired
	private ProfiledFunctionsRESTClient profiledFunctionsRestIL;

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("Starting ProfileManagerBL...");
		try {
			loadMapping();
		} catch (Exception e) {
			logger.error("impossibile caricare il mapping profili-funzioni!", e);
		}
	}

	public Map<String, List<String>> getFunctionsAuthorizationByProfile(String profile) throws BusinessLayerException {
		logger.info("Loading Profile-Functions mapping by profile " + profile);
		Map<String, List<String>> authorizations = new HashMap<>();
		if (profiledFunctions == null) {
			try {
				loadMapping();
			} catch (Exception e) {
				logger.error("Impossibile leggere mapping profili funzioni");
				throw new BusinessLayerException(e);
			}
		}
		for (ProfiledFunctionsDTO profiledFunctionsDTO : profiledFunctions) {
			boolean isAuthorized = profiledFunctionsDTO.getEnabledProfiles() != null && profiledFunctionsDTO.getEnabledProfiles().contains(profile);
			logger.debug(profile + " is auth " + isAuthorized + " " + profiledFunctionsDTO.getIdArea() + "-" + profiledFunctionsDTO.getIdFunction());
			if (isAuthorized) {
				List<String> authorizationsPerArea = authorizations.get(profiledFunctionsDTO.getIdArea());
				if (authorizationsPerArea == null) {
					authorizationsPerArea = new ArrayList<>();
				}
				authorizationsPerArea.add(profiledFunctionsDTO.getIdFunction());
				authorizations.put(profiledFunctionsDTO.getIdArea(), authorizationsPerArea);
			}
		}
		return authorizations;
	}

	private synchronized void loadMapping() throws IntegrationLayerException, InvalidFilenameException {
		ProfiledFunctionsListDTO profiledFunctionsListDTO = profiledFunctionsRestIL.getMapping();
        validateResponseResult(profiledFunctionsListDTO);
		this.profiledFunctions = profiledFunctionsListDTO.getProfiledFunctionsDTOs();
		logger.info("Loaded Profile-Functions mapping: items cardinality=" + this.profiledFunctions.size());
	}

}
