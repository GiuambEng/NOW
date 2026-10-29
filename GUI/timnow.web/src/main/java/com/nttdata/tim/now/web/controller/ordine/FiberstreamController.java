package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.FiberstreamManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ordine.fiberstream.CodiceVlanFiberstreamInputBean;
import com.nttdata.tim.now.data.bean.ordine.fiberstream.CodiceVlanFiberstreamOutputBean;
import com.nttdata.tim.now.data.bean.ordine.fiberstream.NomeServizioAggiuntivoFiberstreamOutputBean;
import com.nttdata.tim.now.data.bean.ordine.fiberstream.TipologiaApparatoFiberstreamOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//RU_1452
@RestController
@RequestMapping("/fiberstream")
public class FiberstreamController extends GenericController {

    @Autowired
    private FiberstreamManagerBL fiberstreamManagerBL;

    // Visualizzazione Codice VLAN
    @JsonPostMapping("/searchVlan")
    public GenericListBean<CodiceVlanFiberstreamOutputBean> getVlanFiberstream(@RequestBody CodiceVlanFiberstreamInputBean inputBean, HttpSession session) throws BusinessLayerException {
        logger.info("get Fiberstream VLAN");
		UserBean user = getCurrentUser(session); 
        GenericListBean<CodiceVlanFiberstreamOutputBean> bean = fiberstreamManagerBL.getVlanFiberstream(inputBean, user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
    }
    
    // Visualizzazione Nome Servizio aggiuntivo
    @JsonGetMapping("/nomiServiziAggiuntivi")
    public GenericListBean<NomeServizioAggiuntivoFiberstreamOutputBean> getNomeServizioAggiuntivoFiberstream(HttpSession session) throws BusinessLayerException {
        logger.info("get Nomi servizi aggiuntivi Fiberstream");
		UserBean user = getCurrentUser(session); 
        GenericListBean<NomeServizioAggiuntivoFiberstreamOutputBean> bean = fiberstreamManagerBL.getNomeServizioAggiuntivoFiberstream(user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
    }
    
    // Visualizzazione Tipologia apparato
    @JsonGetMapping("/tipologiaApparato")
    public TipologiaApparatoFiberstreamOutputBean getTipologiaApparatoFiberstream(@RequestParam(value = "codiceNMU", required = true ) String codiceNMU, HttpSession session) throws BusinessLayerException {
        logger.info("get Tipologia Apparato Fiberstream");
		UserBean user = getCurrentUser(session); 
		TipologiaApparatoFiberstreamOutputBean bean = fiberstreamManagerBL.getTipologiaApparatoFiberstream(codiceNMU, user.getCodiceProfilo());
        return bean;
    }
    
    // Visualizzazione Apparati Fiberstream
    @JsonGetMapping("/apparati")
    public GenericListBean<String> getApparatiFiberstream(@RequestParam(value = "codiceNMULight", required = true ) String codiceNMULight, HttpSession session) throws BusinessLayerException {
        logger.info("get Lista Apparati Fiberstream");
		UserBean user = getCurrentUser(session); 
		GenericListBean<String> bean = fiberstreamManagerBL.getApparatiFiberstream(codiceNMULight, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
        return bean;
    }
}
