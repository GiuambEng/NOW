package com.nttdata.tim.now.web.controller.reporthashing;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.reporthashing.ReportHashingManagerBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.ordine.hashing.CreazioneReportInputBean;
import com.nttdata.tim.now.data.bean.ordine.hashing.DettaglioReportOutputBean;
import com.nttdata.tim.now.data.bean.ordine.hashing.ReportWrapperOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//R1F-21-0411
@RestController
@RequestMapping("/report")
public class ReportHashingController extends GenericController {

	@Autowired
	private ReportHashingManagerBL reportHashingManagerBL;

	// Creazione Report
	@JsonPostMapping("/crea")
	public EmptyBean creazioneReport(@RequestBody CreazioneReportInputBean request, HttpSession session)
			throws BusinessLayerException {
		EmptyBean result;
		UserBean user = getCurrentUser(session);
		request.setOperatore(user.getUserId());
		request.setCodOloAgcom(user.getCodificaOloAgcom());
		request.setIpClient(user.getRequestInfo().getIpClient());
		result = reportHashingManagerBL.creazioneReport(request, user.getCodiceProfilo());
		//SM_10700
		return result;
	}
	
	// Lista Report
	@JsonGetMapping("/lista")
	public ReportWrapperOutputBean listaReport(HttpSession session)
			throws BusinessLayerException {
		ReportWrapperOutputBean result;
		UserBean user = getCurrentUser(session);
		result = reportHashingManagerBL.listaReport(user.getCodiceProfilo());
		return ensureBeanResult(result, ReportWrapperOutputBean.class);
	}
	
	// Lista Report
	@JsonGetMapping("/dettaglio")
	public DettaglioReportOutputBean dettaglioReport(@RequestParam String idReport, @RequestParam String tipoLista, HttpSession session)
			throws BusinessLayerException {
		DettaglioReportOutputBean result;
		UserBean user = getCurrentUser(session);
		result = reportHashingManagerBL.dettaglioReport(idReport, tipoLista, user.getCodiceProfilo());
		return ensureBeanResult(result, DettaglioReportOutputBean.class);
	}

}
