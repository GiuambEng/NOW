package com.nttdata.tim.now.core.service.asset;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.asset.AssetRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.asset.AssetOutputBean;
import com.nttdata.tim.now.data.bean.asset.DettaglioAssetOutputBean;
import com.nttdata.tim.now.data.bean.asset.FeederOutputBean;
import com.nttdata.tim.now.data.bean.asset.ListaFeederOutputBean;
import com.nttdata.tim.now.data.bean.asset.ListaSediOltOutputBean;
import com.nttdata.tim.now.data.bean.asset.RecuperoAssetListOutputBean;
import com.nttdata.tim.now.data.bean.asset.RecuperoAssetOutputBean;
import com.nttdata.tim.now.data.bean.asset.SedeOltOutputBean;
import com.nttdata.tim.now.data.bean.asset.VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.export.ExportableDataOutputBean;
import com.nttdata.tim.now.data.bean.result.Result;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.asset.DettaglioAssetWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.asset.ListaAssetOutputDTO;
import com.nttdata.tim.now.data.dto.asset.ListaFeederOutputDTO;
import com.nttdata.tim.now.data.dto.asset.ListaSediOltOutputDTO;
import com.nttdata.tim.now.data.dto.asset.RecuperoAssetWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.asset.VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AssetManagerBL extends AbstractBL {

	private static final String ID_RISORSA_PATH = "idRisorsa";
	private static final String ID_ASSET_PATH = "idAsset";
	private static final String NUMERO_FITTIZIO_PATH = "numeroFittizio";
	private static final String NUMERO_TELEFONICO_PATH = "numeroTelefonico";

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

	@Autowired
	private AssetRESTClient assetRestIL;

	public DettaglioAssetOutputBean getAsset(String paramName, String value, String flagConsistenza, String codDonating, String tipoProfilo)
			throws BusinessLayerException {
		DettaglioAssetOutputBean bean = null;
		DettaglioAssetWrapperOutputDTO dto = null;

		// conversione sicura del flag in valore Y/N
		Boolean flag = mapper.translate(flagConsistenza, Boolean.class);
		flag.booleanValue();
		String flagConsistenzaToSend = mapper.translate(flag, String.class);

		try {
			// quando flagConsistenza == Y
			if (Boolean.TRUE == flag.booleanValue()) {
				// chiamata per id risorsa
				if (StringUtils.isNotBlank(paramName) && ID_RISORSA_PATH.equals(paramName)) {
					dto = assetRestIL.getAssetByParametro(flagConsistenzaToSend, ID_RISORSA_PATH, value, codDonating, tipoProfilo);
				}
				// chiamata per numero telefonico
				else if (StringUtils.isNotBlank(paramName) && NUMERO_TELEFONICO_PATH.equals(paramName)) {
					dto = assetRestIL.getAssetByParametro(flagConsistenzaToSend, NUMERO_TELEFONICO_PATH, value, codDonating, tipoProfilo);
				}
				// chiamata per numero fittizio
				else if (StringUtils.isNotBlank(paramName) && NUMERO_FITTIZIO_PATH.equals(paramName)) {
					dto = assetRestIL.getAssetByParametro(flagConsistenzaToSend, NUMERO_FITTIZIO_PATH, value, codDonating, tipoProfilo);
				} else {
					logger.error("Combinazione di flagConsistenza+ paramName non permessa= flagConsistenza: "
							+ flagConsistenzaToSend + " paramName: " + paramName);
				}
			}
			// quando flagConsistenza == N
			else {
				// chiamata per id asset
				if (StringUtils.isNotBlank(paramName) && ID_ASSET_PATH.equals(paramName)) {
					dto = assetRestIL.getAssetByParametro(flagConsistenzaToSend, ID_ASSET_PATH, value, codDonating, tipoProfilo);
				}
				// chiamata per id risorsa
				else if (StringUtils.isNotBlank(paramName) && ID_RISORSA_PATH.equals(paramName)) {
					dto = assetRestIL.getAssetByParametro(flagConsistenzaToSend, ID_RISORSA_PATH, value, codDonating, tipoProfilo);
				} else {
					logger.error("Combinazione di flagConsistenza+ paramName non permessa= flagConsistenza: "
							+ flagConsistenzaToSend + " paramName: " + paramName);
				}
			}

			validateResponseResult(dto);
		} catch (Exception e) {
			logger.error("Error reading asset", e);
			throw new BusinessLayerException(e);
		}
		if (dto != null && dto.getAsset() != null) {
			bean = mapper.translate(dto.getAsset(), DettaglioAssetOutputBean.class);
		}
		return bean;
	}

	public GenericListBean<AssetOutputBean> getAssets(String codOloAgcom, String tipoProfilo, String userId)
			throws BusinessLayerException {
		GenericListBean<AssetOutputBean> list = new GenericListBean<>();
		boolean isLimited;
		//Gestione lista limitata
		try {
			ListaAssetOutputDTO dto = assetRestIL.getAssets(codOloAgcom, tipoProfilo, userId);
			isLimited = validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getOutputAsset(), AssetOutputBean.class));
			list.setIsLimitedList(isLimited);
		} catch (Exception e) {
			logger.error("Error reading assets", e);
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public ExportableDataOutputBean requestExport(RicercaAvanzataInputBean inputBean, String codOloAgcom,
			String tipoProfilo, String userId) throws BusinessLayerException {
		ExportableDataOutputBean bean = new ExportableDataOutputBean();
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			ExportableDataOutputDTO dto = assetRestIL.advancedSearch(inputDto, codOloAgcom, tipoProfilo, userId);
			validateResponseResult(dto);
			bean = mapper.translate(dto, ExportableDataOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListBean<AssetOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String codOloAgcom,
			String tipoProfilo, String userId) throws BusinessLayerException {
		GenericListBean<AssetOutputBean> bean = new GenericListBean<>();
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata Asset");
    	}

		boolean isLimited;
		//Gestione lista limitata
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			ListaAssetOutputDTO dto = assetRestIL.advancedSearch(inputDto, codOloAgcom, tipoProfilo, userId);
			isLimited = validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getOutputAsset(), AssetOutputBean.class));
			bean.setIsLimitedList(isLimited);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	//RU_1058
	public RecuperoAssetListOutputBean recuperoasset(String codAgcom, String idRisorsa, String tipoLavorazione, String tipoProfilo) throws BusinessLayerException {
		RecuperoAssetListOutputBean bean = new RecuperoAssetListOutputBean();
		try {
			RecuperoAssetWrapperOutputDTO dto = assetRestIL.recuperoasset(codAgcom, idRisorsa, tipoLavorazione, tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getRecuperoAssetDTO(), RecuperoAssetOutputBean.class));
			bean.setEsito(dto.getEsito());
			bean.setResult(mapper.translate(dto.getResult(), Result.class));//RU_833 FIX CESSAZIONE PER MESSAGGIO RECUPERO ASSETT
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	//RU_1184
	public VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputBean verificaStatoAssetAbilitazioneDisabilitazione(String idAsset, String disabilitazione, String tipoProfilo) throws BusinessLayerException {
		VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputBean bean = new VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputBean();
		try {
			VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputDTO dto = assetRestIL.verificaStatoAssetAbilitazioneDisabilitazione(idAsset, disabilitazione, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputBean.class);
			bean.setResult(mapper.translate(dto.getResult(), Result.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	//R1I-21-0203
	public ListaSediOltOutputBean listaSediOlt(String idAsset, String tipoProfilo) throws BusinessLayerException {
		ListaSediOltOutputBean bean = new ListaSediOltOutputBean();
		try {
			ListaSediOltOutputDTO dto = assetRestIL.listaSediOlt(idAsset, tipoProfilo);
			validateResponseResult(dto);
			bean.setSediOlt(mapper.translateList(dto.getSediOlt(), SedeOltOutputBean.class));
			bean = mapper.translate(dto, ListaSediOltOutputBean.class);
			bean.setResult(mapper.translate(dto.getResult(), Result.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	//R1I-21-0203
	public ListaFeederOutputBean listaFeeder(String idAsset, String tipoProfilo) throws BusinessLayerException {
		ListaFeederOutputBean bean = new ListaFeederOutputBean();
		try {
			ListaFeederOutputDTO dto = assetRestIL.listaFeeder(idAsset, tipoProfilo);
			validateResponseResult(dto);
			bean.setFeeders(mapper.translateList(dto.getFeeders(), FeederOutputBean.class));
			bean = mapper.translate(dto, ListaFeederOutputBean.class);
			bean.setResult(mapper.translate(dto.getResult(), Result.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
