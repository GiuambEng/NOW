package com.nttdata.tim.now.web.controller.anagrafica;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.AccessDeniedException;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.InvalidFilenameException;
import com.nttdata.tim.now.core.service.anagrafica.ContrattoManagerBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.contratto.ContrattoOutputBean;
import com.nttdata.tim.now.data.bean.contratto.ModificaContrattoInputBean;
import com.nttdata.tim.now.data.bean.contratto.NuovoContrattoInputBean;
import com.nttdata.tim.now.data.bean.contratto.NuovoContrattoListItemBean;
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
import com.nttdata.tim.now.data.enumeration.ResultCodeEnum;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.FileDownloadController;
import com.nttdata.tim.now.web.exception.FileNotFoundHttpException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/contracts")
public class ContrattoController extends FileDownloadController {
	
	private static final String FILE_EMPTY_ERROR_MESSAGE = "Selezionare un file non vuoto!";

    @Autowired
    private ContrattoManagerBL contrattoManagerBL;
    
	// Contratto -> Visualizza Contratto Olo
	@JsonGetMapping("/olo/{codOLO:[A-Za-z0-9_]+}")
	public GenericListBean<ContrattoOutputBean> getAllContracts(@RequestParam(required = false) String flagMulticast, @PathVariable String codOLO, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<ContrattoOutputBean> bean = contrattoManagerBL.getAllContracts(codOLO, user.getCodiceProfilo(), flagMulticast);
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Contratto -> Lista Contratti Anagrafica
	@JsonGetMapping("/profiled")
	public GenericListBean<ContrattoOutputBean> getContracts(HttpSession session) throws BusinessLayerException {
		logger.info("get contracts");
		UserBean user = getCurrentUser(session);
		GenericListBean<ContrattoOutputBean> bean = contrattoManagerBL.getContracts(user.getCodificaOloAgcom(), user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Ricerca Avanzata export
	@JsonPostMapping("/export")
	public ExportableDataOutputBean requestExport(@RequestBody RicercaAvanzataInputBean body, HttpSession session) throws BusinessLayerException {

		UserBean user = getCurrentUser(session);

		ExportableDataOutputBean bean = contrattoManagerBL.requestExport(body, user.getCodificaOloAgcom(),
				user.getCodiceProfilo(), user.getUserId());

		if (bean != null) {
			logger.debug("Research found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("Research NOT found");
			bean = new ExportableDataOutputBean();
			bean.setResult(getResultNotFound());
		}

		return bean;
	}

	// Ricerca Avanzata
	@JsonPostMapping("/search")
	public GenericListBean<ContrattoOutputBean> search(@RequestBody RicercaAvanzataInputBean body, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<ContrattoOutputBean> bean = contrattoManagerBL.advancedSearch(body, user.getCodificaOloAgcom(), user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}
	
	//RU_716_Nuovo Contratto
	@JsonPostMapping("/nuovoContratto")
	public NuovoContrattoWrapperOutputBean nuovoContratto(@RequestBody List<NuovoContrattoListItemBean> inputBeanList, HttpSession session) throws BusinessLayerException {
		logger.info("Crea nuovo contratto spring controller");
		NuovoContrattoWrapperOutputBean bean = null;
		UserBean user = getCurrentUser(session);
		String operatore = user.getUserId();
		String tipoProfilo = user.getCodiceProfilo();
		try {
			
			NuovoContrattoInputBean inputBean = new NuovoContrattoInputBean();
			
			for(NuovoContrattoListItemBean b : inputBeanList) {
				b.setOperatore(operatore);
				b.setTipoProfilo(tipoProfilo);
				
			}
			
			inputBean.setNuovoContratto(inputBeanList);
			
			bean = contrattoManagerBL.nuovoContratto(inputBean, user.getCodiceProfilo());
		} catch (Exception e) {
			logger.info("Richiesta di insert nuovo contratto fallita", e);
			throw e;
		}
		//return ensureBeanResult(bean, EsitoOutputBean.class); //SM_8049
		return bean;
	}
	
	//RU_716_Nuovo Contratto
	@JsonGetMapping("/recuperoDatiContratto")
	public RecuperoDatiContrattoOutputBean recuperoDatiContratto(@RequestParam(value = "idFamigliaOfferta", required = false) String idFamigliaOfferta) throws BusinessLayerException {
		logger.info("get contracts's data");
		RecuperoDatiContrattoOutputBean bean = contrattoManagerBL.recuperoDatiContratto(idFamigliaOfferta);
		bean = ensureBeanResult(bean, RecuperoDatiContrattoOutputBean.class);
		return bean;
	}
	
	//RU_716_Nuovo Contratto
	@JsonGetMapping("/recuperoContratti")
	public RecuperoContrattiOutputBean recuperoTipoContratti(@RequestParam(value = "tipoServizio") String tipoServizio) throws BusinessLayerException {
		logger.info("get tipo contratti");
		RecuperoContrattiOutputBean bean = contrattoManagerBL.recuperoTipoContratti(tipoServizio);
		bean = ensureBeanResult(bean, RecuperoContrattiOutputBean.class);
		return bean;
	}
	
	//RU_716_Nuovo Contratto
    @JsonPostMapping("/modificaContratto")
    public EsitoOutputBean modificaContratto(@RequestBody ModificaContrattoInputBean inputBean, HttpSession session) throws BusinessLayerException {
          logger.info("Modifica contratto spring controller");
          EsitoOutputBean bean= new EsitoOutputBean();
          UserBean user = getCurrentUser(session);
          String operatore = user.getUserId();
          String tipoProfilo = user.getCodiceProfilo();
          try {
                 inputBean.getModificaContrattoInput().setOperatore(operatore);
                 inputBean.getModificaContrattoInput().setTipoProfilo(tipoProfilo);
                 bean = contrattoManagerBL.modificaContratto(inputBean, user.getCodiceProfilo());
          } catch (Exception e) {
                 logger.info("Richiesta di modifica nuovo contratto fallita", e);
                 throw e;
          }
          return ensureBeanResult(bean, EsitoOutputBean.class);
    }
    
  //RU_716_Nuovo Contratto
    @JsonGetMapping("/recuperoDettaglioContratto")
    public RecuperoDettaglioContrattoOutputBean recuperoDettaglioContratto(@RequestParam(value = "idContratto", required = false) String idContratto) throws BusinessLayerException {
          logger.info("get dettaglio contratto fwa");
          RecuperoDettaglioContrattoOutputBean bean = contrattoManagerBL.recuperoDettaglioContratto(idContratto);
          bean = ensureBeanResult(bean, RecuperoDettaglioContrattoOutputBean.class);
          return bean;
    }
    
    //RU_1180 -> Upload file Multicast
	@JsonPostMapping("/uploadFileMulticast")
	public EmptyBean uploadFileMulticast(
			@RequestParam(value = "file") MultipartFile file,
			@RequestParam(value = "idContratto", required = false) String idContratto, 
			HttpSession session) throws IOException, BusinessLayerException {
		if (!file.isEmpty()) {
			logger.info("uploading file");
			try {
				FileScaricatoBean uploadedFile = new FileScaricatoBean();
				uploadedFile.setName(file.getOriginalFilename());
				uploadedFile.setSize(file.getSize());
				uploadedFile.setMime(file.getContentType());
				uploadedFile.setFileData(file.getBytes());

				contrattoManagerBL.uploadFileMulticast(uploadedFile, idContratto);
				
			} catch (IOException e) {
				logger.warn("Error file not uploaded correctly!", e);
				throw e;
			} catch (InvalidFilenameException ifne) {
				logger.warn("Invalid filename: file not uploaded!", ifne);
				ResultCodeEnum code = ResultCodeEnum.VALIDATION_ERROR;
				return getEmptyBean(new Result(code.getCode(), ifne.getMessage(), code.getMessage()));
			} catch (AccessDeniedException e) {
				logger.warn("Access denied to the file!", e);
				ResultCodeEnum code = ResultCodeEnum.VALIDATION_ERROR;
				return getEmptyBean(new Result(code.getCode(), e.getMessage(), code.getMessage()));
			}
		} else {
			logger.info("uploading an empty file");
			ResultCodeEnum code = ResultCodeEnum.VALIDATION_ERROR;
			return getEmptyBean(new Result(code.getCode(), FILE_EMPTY_ERROR_MESSAGE, FILE_EMPTY_ERROR_MESSAGE));
		}
		return getSuccessEmptyBean();
	}
	
	//RU_1180 -> Download file esiti Multicast
	@JsonGetMapping("/downloadFileEsiti")
	public ResponseEntity<byte[]> downloadFileEsitiMulticast(
			@RequestParam(value = "idFile") String idFile, 
			@RequestParam(value = "fileName", required = false) String fileName,
			HttpSession session) throws FileNotFoundHttpException {
		UserBean user = getCurrentUser(session);
		try {
			FileScaricatoBean fileBean = contrattoManagerBL.downloadFileEsitiMulticast(idFile, fileName, user);			
			return getFileResponseEntity(fileBean);
		} catch (Exception e) {
			logger.info("Impossibile effettuare il download del file", e);
			throw new FileNotFoundHttpException();
		}
	}

	// Verifica Stato Contratto per Abilitazione/Disabilitazione (C11M08F86)
	//RU_1184
	@JsonGetMapping("/verificaStatoContrattoAbilitazioneDisabilitazione")
	public VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputBean verificaStatoContrattoAbilitazioneDisabilitazione(
													 @RequestParam String idContratto, 
													 HttpSession session ) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputBean bean = contrattoManagerBL.verificaStatoContrattoAbilitazioneDisabilitazione(idContratto, user.getCodiceProfilo());
		return bean;
	}
	
	//SM_10433 - Recupera Flag Multicast
	@JsonGetMapping("/recuperaFlagMulticast")
	public RecuperoFlagMulticastOutputBean recuperaFlagMulticast(
			@RequestParam(value = "idOfferta") String idOfferta,
			@RequestParam(value = "codOloAgcom") String codOloAgcom,
			HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		String tipoProfilo = user.getCodiceProfilo();
		RecuperoFlagMulticastOutputBean bean = contrattoManagerBL.recuperaFlagMulticast(idOfferta, codOloAgcom, tipoProfilo);
		bean = ensureBeanResult(bean, RecuperoFlagMulticastOutputBean.class);
		return bean;
	}
	
	//SM_11367
	//Verifica contratto FWA EOLO
	@JsonGetMapping("/verificaContrattoFwaEolo")
    public EsitoOutputBean verificaContrattoFwaEolo(@RequestParam(value = "codOloAgcom") String codOloAgcom, HttpSession session) throws BusinessLayerException {
        logger.info("Verifica contratto FWA EOLO");
        EsitoOutputBean bean= new EsitoOutputBean();
        UserBean user = getCurrentUser(session);
        String tipoProfilo = user.getCodiceProfilo();
        bean = contrattoManagerBL.verificaContrattoFwaEolo(codOloAgcom, user.getCodiceProfilo());
        return ensureBeanResult(bean, EsitoOutputBean.class);
  }
	
}
