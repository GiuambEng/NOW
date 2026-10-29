package com.nttdata.tim.now.web.controller.offerta;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.offerta.LanManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.lan.CodiceVlanSVlanOutputBean;
import com.nttdata.tim.now.data.bean.lan.SVlanCVlanInOutBean;
import com.nttdata.tim.now.data.bean.lan.VerificaUnivocitaSVlanCVlanInputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lans")
public class LanController extends GenericController {

    @Autowired
    private LanManagerBL lanManagerBL;

    // Visualizzazione Codice VLAN - SVLAN -> Visualizzazione Codice VLAN -
    // SVLAN + VLAN SVLAN
    @JsonGetMapping
    public GenericListBean<CodiceVlanSVlanOutputBean> getVlanSVlan(
            @RequestParam(value = "service", required = false) String offerta,
            @RequestParam(value = "encapsulation", required = false) String encapsulation,
            @RequestParam(value = "codOloAgcom") String codOloAgcom, HttpSession session) throws BusinessLayerException {
        logger.info("get VLAN-SVLAN");
		UserBean user = getCurrentUser(session); 
        GenericListBean<CodiceVlanSVlanOutputBean> bean = lanManagerBL.getVlanSVlan(codOloAgcom, encapsulation, offerta, user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
    }

    // Amministrazione VLAN/SVLAN
    @JsonGetMapping("/admin")
    public GenericListBean<CodiceVlanSVlanOutputBean> getVlanSVlanAdmin(HttpSession session) throws BusinessLayerException {
        logger.info("get VLAN-SVLAN");
		UserBean user = getCurrentUser(session); 
        GenericListBean<CodiceVlanSVlanOutputBean> bean = lanManagerBL.getVlanSVlan(user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
    }

    // Ordine -> Verifica Univocità Codice SVlan CVlan Code
    @JsonPostMapping("/verify")
    public GenericListBean<SVlanCVlanInOutBean> verifySVlanCVlan(@RequestBody VerificaUnivocitaSVlanCVlanInputBean inputBean, HttpSession session) throws BusinessLayerException {
        logger.info("verify SVLAN-CVLAN");
		UserBean user = getCurrentUser(session); 
        GenericListBean<SVlanCVlanInOutBean> outbean = lanManagerBL.verifySVlanCVlan(inputBean, user.getCodiceProfilo());
        outbean = ensureListBeanResult(outbean);
        return outbean;
    }

    // Ricerca Avanzata
    @JsonPostMapping("/search")
    public GenericListBean<CodiceVlanSVlanOutputBean> search(@RequestBody RicercaAvanzataInputBean body, HttpSession session)
            throws BusinessLayerException {
		UserBean user = getCurrentUser(session); 
        GenericListBean<CodiceVlanSVlanOutputBean> bean = lanManagerBL.advancedSearch(body, user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
    }

    // Ricerca Avanzata VlanSvlan
    @JsonPostMapping("/searchVlanSvlan")
    public GenericListBean<CodiceVlanSVlanOutputBean> searchVlanSvlan(@RequestParam(value = "service", required = false) String offerta,
            @RequestParam(value = "codOloAgcom", required = false) String codOloAgcom,
            @RequestParam(value = "encapsulation", required = false) String encapsulation,
            @RequestParam(value = "idContratto", required = false) String idContratto, @RequestBody RicercaAvanzataInputBean body, HttpSession session)
            throws BusinessLayerException {
		UserBean user = getCurrentUser(session); 
        GenericListBean<CodiceVlanSVlanOutputBean> bean = lanManagerBL.advancedSearchVlanSvlan(body, codOloAgcom, offerta, encapsulation, idContratto, user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
    }

}
