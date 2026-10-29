package com.nttdata.tim.now.core.service.asset;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.asset.AssetRaccoltaRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.asset.AssetRaccoltaWrapperOutputBean;
import com.nttdata.tim.now.data.bean.asset.DettaglioAssetRaccoltaWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.asset.AssetRaccoltaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.asset.DettaglioAssetRaccoltaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//RU_1188
@Service
public class AssetRaccoltaManagerBL extends AbstractBL {

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

	@Autowired
	private AssetRaccoltaRESTClient assetRaccoltaRestIL;
	
	public DettaglioAssetRaccoltaWrapperOutputBean getAsset(String idAsset, String tipoProfilo)
			throws BusinessLayerException {
		DettaglioAssetRaccoltaWrapperOutputBean bean = null;
		DettaglioAssetRaccoltaWrapperOutputDTO dto = null;

		try {
			
			dto = assetRaccoltaRestIL.getAsset(idAsset, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, DettaglioAssetRaccoltaWrapperOutputBean.class);
		} catch (Exception e) {
			logger.error("Error reading asset", e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public AssetRaccoltaWrapperOutputBean getAssetsRaccolta(String codOloAgcom, String tipoProfilo, String userId)
			throws BusinessLayerException {
		AssetRaccoltaWrapperOutputBean bean = new AssetRaccoltaWrapperOutputBean();
		try {
			AssetRaccoltaWrapperOutputDTO dto = assetRaccoltaRestIL.getAssetsRaccolta(codOloAgcom, tipoProfilo, userId);
			bean = mapper.translate(dto, AssetRaccoltaWrapperOutputBean.class);
		} catch (Exception e) {
			logger.error("Error reading assets", e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public AssetRaccoltaWrapperOutputBean requestExport(RicercaAvanzataInputBean inputBean, String codOloAgcom,
			String tipoProfilo, String userId) throws BusinessLayerException {
		AssetRaccoltaWrapperOutputBean bean = new AssetRaccoltaWrapperOutputBean();
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			if(inputDto != null) {
				inputDto.setExportRequest("Y");
			}
			AssetRaccoltaWrapperOutputDTO dto = assetRaccoltaRestIL.advancedSearch(inputDto, codOloAgcom, tipoProfilo, userId);
			validateResponseResult(dto);
			bean = mapper.translate(dto, AssetRaccoltaWrapperOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public AssetRaccoltaWrapperOutputBean advancedSearch(RicercaAvanzataInputBean inputBean, String codOloAgcom,
			String tipoProfilo, String userId) throws BusinessLayerException {
		AssetRaccoltaWrapperOutputBean bean = new AssetRaccoltaWrapperOutputBean();
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata Asset");
    	}  	
    	
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			if(inputDto != null) {
				inputDto.setExportRequest("N");
			}
			AssetRaccoltaWrapperOutputDTO dto = assetRaccoltaRestIL.advancedSearch(inputDto, codOloAgcom, tipoProfilo, userId);
			bean = mapper.translate(dto, AssetRaccoltaWrapperOutputBean.class);
			
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
