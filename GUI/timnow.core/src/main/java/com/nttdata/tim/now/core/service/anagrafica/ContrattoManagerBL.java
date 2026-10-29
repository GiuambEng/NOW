package com.nttdata.tim.now.core.service.anagrafica;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.anagrafica.ContrattoRESTClient;
import com.nttdata.tim.now.core.exception.AccessDeniedException;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.NotFoundException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.contratto.ContrattoOutputBean;
import com.nttdata.tim.now.data.bean.contratto.ModificaContrattoInputBean;
import com.nttdata.tim.now.data.bean.contratto.NuovoContrattoInputBean;
import com.nttdata.tim.now.data.bean.contratto.NuovoContrattoWrapperOutputBean;
import com.nttdata.tim.now.data.bean.contratto.RecuperoContrattiOutputBean;
import com.nttdata.tim.now.data.bean.contratto.RecuperoDatiContrattoOutputBean;
import com.nttdata.tim.now.data.bean.contratto.RecuperoDettaglioContrattoOutputBean;
import com.nttdata.tim.now.data.bean.contratto.RecuperoFlagMulticastOutputBean;
import com.nttdata.tim.now.data.bean.contratto.VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputBean;
import com.nttdata.tim.now.data.bean.esito.EsitoOutputBean;
import com.nttdata.tim.now.data.bean.export.ExportableDataOutputBean;
import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;
import com.nttdata.tim.now.data.bean.result.Result;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.contratto.ListaContrattiOutputDTO;
import com.nttdata.tim.now.data.dto.contratto.ModificaContrattoInputDTO;
import com.nttdata.tim.now.data.dto.contratto.NuovoContrattoInputDTO;
import com.nttdata.tim.now.data.dto.contratto.NuovoContrattoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.contratto.RecuperoContrattiOutputDTO;
import com.nttdata.tim.now.data.dto.contratto.RecuperoDatiContrattoOutputDTO;
import com.nttdata.tim.now.data.dto.contratto.RecuperoDettaglioContrattoOutputDTO;
import com.nttdata.tim.now.data.dto.contratto.RecuperoFlagMulticastOutputDTO;
import com.nttdata.tim.now.data.dto.contratto.VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;
import com.nttdata.tim.now.data.dto.file.FileMulticastToUploadDTO;
import com.nttdata.tim.now.data.dto.file.FileWrapperDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.enumeration.BackEndResultCode;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ContrattoManagerBL extends AbstractBL {

	@Autowired
	private ContrattoRESTClient contrattoRestIL;

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

	
	@Cacheable(value = "contract", key = "#codiceOlo")
	public GenericListBean<ContrattoOutputBean> getAllContracts(String codiceOlo, String tipoProfilo, String flagMulticast) throws BusinessLayerException {
		GenericListBean<ContrattoOutputBean> list = new GenericListBean<>();
		try {
			ListaContrattiOutputDTO dto = contrattoRestIL.getAllContracts(codiceOlo, tipoProfilo, flagMulticast);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getContracts(), ContrattoOutputBean.class));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessLayerException(e);
		}
		return list;
	}

	@Cacheable(value = "contracts", key = "#codOloAgicom + '-' + #tipoProfilo")
	public GenericListBean<ContrattoOutputBean> getContracts(String codOloAgicom, String tipoProfilo, String userId) throws BusinessLayerException {
		GenericListBean<ContrattoOutputBean> list = new GenericListBean<>();
		boolean isLimited;
		//Gestione lista limitata
		try {
			ListaContrattiOutputDTO dto = contrattoRestIL.getContracts(codOloAgicom, tipoProfilo, userId);
			isLimited = validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getContracts(), ContrattoOutputBean.class));
			list.setIsLimitedList(isLimited);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public GenericListBean<ContrattoOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String codOloAgcom, String tipoProfilo, String userId) throws BusinessLayerException {
		GenericListBean<ContrattoOutputBean> list = new GenericListBean<>();
		boolean isLimited;
    	logger.debug("*******INSIDEMANAGER= "+ patterRegex);
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata Contratto");
    	}

		//Gestione lista limitata
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			ListaContrattiOutputDTO dto = contrattoRestIL.advancedSearch(inputDto, codOloAgcom, tipoProfilo, userId);
			isLimited = validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getContracts(), ContrattoOutputBean.class));
			list.setIsLimitedList(isLimited);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public ExportableDataOutputBean requestExport(RicercaAvanzataInputBean inputBean, String codOloAgcom, String tipoProfilo, String userId) throws BusinessLayerException {
		ExportableDataOutputBean bean = new ExportableDataOutputBean();
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			ExportableDataOutputDTO dto = contrattoRestIL.advancedSearch(inputDto, codOloAgcom, tipoProfilo, userId);
			validateResponseResult(dto);
			bean = mapper.translate(dto, ExportableDataOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	//RU_716_Nuovo Contratto
	public NuovoContrattoWrapperOutputBean nuovoContratto(NuovoContrattoInputBean inputBean, String profilo) throws BusinessLayerException {
		logger.info("Crea nuovo contratto contratto manager");
		NuovoContrattoWrapperOutputBean bean = null;
		try {
			NuovoContrattoInputDTO inputDto = mapper.translate(inputBean, NuovoContrattoInputDTO.class);
			NuovoContrattoWrapperOutputDTO dto = contrattoRestIL.insert(inputDto, profilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, NuovoContrattoWrapperOutputBean.class);
		} catch (Exception e) {
			logger.error("Error insert nuovo contratto", e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	//RU_716_Nuovo Contratto
	public RecuperoDatiContrattoOutputBean recuperoDatiContratto(String idFamigliaOfferta) throws BusinessLayerException {
		logger.info("Recupera dati contratto manager");
		RecuperoDatiContrattoOutputBean bean = new RecuperoDatiContrattoOutputBean();
		try {
			RecuperoDatiContrattoOutputDTO dto = contrattoRestIL.recuperoDatiContratto(idFamigliaOfferta);
			validateResponseResult(dto);
			bean = mapper.translate(dto, RecuperoDatiContrattoOutputBean.class);
		} catch (Exception e) {
			logger.error("Error insert recupero dati contratto", e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	//RU_716_Nuovo Contratto
	public RecuperoContrattiOutputBean recuperoTipoContratti(String tipoServizio) throws BusinessLayerException {
		logger.info("Recupera tipo contratti manager");
		RecuperoContrattiOutputBean bean = new RecuperoContrattiOutputBean();
		try {
			RecuperoContrattiOutputDTO dto = contrattoRestIL.recuperoTipoContratti(tipoServizio);
			validateResponseResult(dto.getRecuperoContrattoOutput());
			bean = mapper.translate(dto, RecuperoContrattiOutputBean.class);
		} catch (Exception e) {
			logger.error("Error recupero dati contratto", e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	//RU_716_Nuovo Contratto
		public RecuperoDettaglioContrattoOutputBean recuperoDettaglioContratto(String idContratto) throws BusinessLayerException {
			logger.info("Recupera dettaglio contratto manager");
			RecuperoDettaglioContrattoOutputBean bean = new RecuperoDettaglioContrattoOutputBean();
			try {
				RecuperoDettaglioContrattoOutputDTO dto = contrattoRestIL.recuperoDettaglioContratto(idContratto);
				validateResponseResult(dto);
				bean = mapper.translate(dto, RecuperoDettaglioContrattoOutputBean.class);
			} catch (Exception e) {
				logger.error("Error recupero dettaglio contratto", e);
				throw new BusinessLayerException(e);
			}
			return bean;
		}
		
	//RU_716_Nuovo Contratto
       public EsitoOutputBean modificaContratto(ModificaContrattoInputBean inputBean, String profilo) throws BusinessLayerException {
             logger.info("Modifica contratto contratto manager");
             EsitoOutputBean bean = new EsitoOutputBean();
             try {
                    ModificaContrattoInputDTO inputDto = mapper.translate(inputBean, ModificaContrattoInputDTO.class);
                    EsitoDTO dto = contrattoRestIL.modify(inputDto, profilo);
                    validateResponseResult(dto);
                    bean = mapper.translate(dto, EsitoOutputBean.class);
             } catch (Exception e) {
                    logger.error("Error insert nuovo contratto", e);
                    throw new BusinessLayerException(e);
             }
             return bean;
       }
       
   		//RU_1164
       public EsitoOutputBean recuperaComuniCoinvestiti(ModificaContrattoInputBean inputBean, String profilo) throws BusinessLayerException {
             logger.info("Recupera Comuni coinvestiti contratto manager");
             EsitoOutputBean bean = new EsitoOutputBean();
             try {
                    ModificaContrattoInputDTO inputDto = mapper.translate(inputBean, ModificaContrattoInputDTO.class);
                    EsitoDTO dto = contrattoRestIL.modify(inputDto, profilo);
                    validateResponseResult(dto);
                    bean = mapper.translate(dto, EsitoOutputBean.class);
             } catch (Exception e) {
                    logger.error("Error insert nuovo contratto", e);
                    throw new BusinessLayerException(e);
             }
             return bean;
       }
       
    //RU_1180
   	public void uploadFileMulticast(FileScaricatoBean uploadedFile, String idContratto) throws BusinessLayerException, AccessDeniedException {
		ESBResultDTO result;
		try {
			FileMulticastToUploadDTO fileDTO = new FileMulticastToUploadDTO();			
			fileDTO.setIdContratto(idContratto);
			fileDTO.setNomeFile(uploadedFile.getName());
			fileDTO.setContenutoFile(uploadedFile.getFileData());
			result = contrattoRestIL.uploadFileMulticast(fileDTO);
			validateResponseResult(result);
		} catch (IntegrationLayerException e) {
			throw new BusinessLayerException("Impossibile completare l'upload del file " + uploadedFile.getName(), e);
		}
		
		if (result != null && result.getResult() != null) {
			String code = result.getResult().getCode();
			if (BackEndResultCode.USER_NOT_ENABLED.getCode().equals(code)) {
				String detail = result.getResult().getDetails();
				throw new AccessDeniedException(detail);
			}
		}
	}
   	
   	//RU_1180
	public FileScaricatoBean downloadFileEsitiMulticast(String idFile, String fileName, UserBean user)throws BusinessLayerException {
		FileWrapperDTO wrapper;
		try {
			wrapper = contrattoRestIL.downloadFileEsitiMulticast(idFile, fileName, user);
			validateResponseResult(wrapper);
		} catch (IntegrationLayerException e) {
			logger.error("Error downloading file", e);
			throw new BusinessLayerException(e);
		}
		FileScaricatoBean bean = null;
		if (wrapper != null && wrapper.getFile() != null) {
			bean = new FileScaricatoBean();
			byte[] fileData = new Base64().decode(wrapper.getFile().getContenutoFile().getBytes());
			bean.setFileData(fileData);
			bean.setName(wrapper.getFile().getNomeFile());
			bean.setSize(fileData.length);
		} else {
			throw new NotFoundException("Not found file with id " + idFile);
		}
		return bean;
	}
	
	//RU_1184
	public VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputBean verificaStatoContrattoAbilitazioneDisabilitazione(String idContratto, String tipoProfilo) throws BusinessLayerException {
		VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputBean bean = new VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputBean();
		try {
			VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputDTO dto = contrattoRestIL.verificaStatoContrattoAbilitazioneDisabilitazione(idContratto, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputBean.class);
			bean.setResult(mapper.translate(dto.getResult(), Result.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	//SM_10433
	public RecuperoFlagMulticastOutputBean recuperaFlagMulticast(String idOfferta, String codOloAgcom, String tipoProfilo) throws BusinessLayerException {
		RecuperoFlagMulticastOutputBean bean = new RecuperoFlagMulticastOutputBean();
		try {
			RecuperoFlagMulticastOutputDTO dto = contrattoRestIL.recuperaFlagMulticast(idOfferta, codOloAgcom, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, RecuperoFlagMulticastOutputBean.class);
			bean.setResult(mapper.translate(dto.getResult(), Result.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	//SM_11367
    public EsitoOutputBean verificaContrattoFwaEolo(String codOloAgcom, String profilo) throws BusinessLayerException {        
        EsitoOutputBean bean = new EsitoOutputBean();
        try {
               EsitoDTO dto = contrattoRestIL.verificaContrattoFwaEolo(codOloAgcom, profilo);
               validateResponseResult(dto);
               bean = mapper.translate(dto, EsitoOutputBean.class);
        } catch (Exception e) {
               logger.error("Error Verifica contratto FWA EOLO ", e);
               throw new BusinessLayerException(e);
        }
        return bean;
  }
}
