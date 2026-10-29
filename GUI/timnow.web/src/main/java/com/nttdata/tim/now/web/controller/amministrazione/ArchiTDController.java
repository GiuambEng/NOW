package com.nttdata.tim.now.web.controller.amministrazione;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.amministrazione.ArchiTDManagerBL;
import com.nttdata.tim.now.data.bean.architd.GestioneArchiNumerazioniTDEditInputBean;
import com.nttdata.tim.now.data.bean.architd.GestioneArchiNumerazioniTDListOutputBean;
import com.nttdata.tim.now.data.bean.esito.EsitoOutputBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPutMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gestionearchinumerazionitd")
public class ArchiTDController extends GenericController {
	
	private final String INSERT_OPERATION="INSERT";
	private final String UPDATE_OPERATION="UPDATE";
	

	@Autowired
	private ArchiTDManagerBL archiTDManagerBL;

	@JsonGetMapping()
	public GestioneArchiNumerazioniTDListOutputBean getLista(HttpSession session)
			throws BusinessLayerException {
		String profilo= getCurrentUser(session).getCodiceProfilo();
		GestioneArchiNumerazioniTDListOutputBean bean = new GestioneArchiNumerazioniTDListOutputBean();
		try {
			bean = archiTDManagerBL.gestionearchinumerazionitd(profilo);
		} catch (Exception e) {
			logger.info("Richiesta get lista Archi Numerazioni TD fallita", e);
			throw e;
		}
		return ensureBeanResult(bean, GestioneArchiNumerazioniTDListOutputBean.class);
	}


	@JsonPutMapping()
	public EsitoOutputBean update(@RequestBody GestioneArchiNumerazioniTDEditInputBean inputBean, HttpSession session)
			throws BusinessLayerException {
		EsitoOutputBean bean = new EsitoOutputBean();
		String operatore = getCurrentUser(session).getUserId();
		try {
			inputBean.setAction(UPDATE_OPERATION);
			inputBean.setOperatore(operatore);
			bean = archiTDManagerBL.update(inputBean, getCurrentUser(session).getCodiceProfilo() );
		} catch (Exception e) {
			logger.info("Richiesta di update gestione Archi Numerazioni TD fallita", e);
			throw e;
		}
		return ensureBeanResult(bean, EsitoOutputBean.class);
	}

	
	@JsonPostMapping()
	public EsitoOutputBean insert(@RequestBody GestioneArchiNumerazioniTDEditInputBean inputBean, HttpSession session)
			throws BusinessLayerException {
		EsitoOutputBean bean = new EsitoOutputBean();
		String operatore = getCurrentUser(session).getUserId();
		try {
			inputBean.setAction(INSERT_OPERATION);
			inputBean.setOperatore(operatore);
			bean = archiTDManagerBL.insert(inputBean, getCurrentUser(session).getCodiceProfilo() );
		} catch (Exception e) {
			logger.info("Richiesta di insert gestione Archi Numerazioni TD fallita", e);
			throw e;
		}
		return ensureBeanResult(bean, EsitoOutputBean.class);
	}

}
