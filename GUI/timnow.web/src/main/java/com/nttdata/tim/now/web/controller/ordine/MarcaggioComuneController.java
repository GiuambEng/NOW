package com.nttdata.tim.now.web.controller.ordine;


import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.anagrafica.MarcaggioComuneManagerBL;
import com.nttdata.tim.now.data.bean.anagraficamarcaggio.AnagraficaMarcaggioComuneOutputBean;
import com.nttdata.tim.now.data.bean.anagraficamarcaggio.export.RichiestaExportMarcaggioComuniOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.result.Result;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.enumeration.ResultCodeEnum;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marcaggioComuni")
public class MarcaggioComuneController extends GenericController {

    @Autowired
    private MarcaggioComuneManagerBL marcaggioComuniManagerBL;
    
    // Ricerca Avanzata
    @JsonPostMapping("/search")
    public GenericListBean<AnagraficaMarcaggioComuneOutputBean> search(@RequestBody RicercaAvanzataInputBean body, HttpSession session) throws BusinessLayerException {

        UserBean user = getCurrentUser(session);
        GenericListBean<AnagraficaMarcaggioComuneOutputBean> bean = marcaggioComuniManagerBL.advancedSearch(body, user.getUserId(), user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
    }    
    
    // Export Data Start
    @JsonPostMapping("/export")
    public RichiestaExportMarcaggioComuniOutputBean requestOrderExport(@RequestBody RicercaAvanzataInputBean body, HttpSession session) throws BusinessLayerException {
    	RichiestaExportMarcaggioComuniOutputBean bean = null;
        try {
            UserBean user = getCurrentUser(session);

            bean = marcaggioComuniManagerBL.requestExport(body, user.getUserId(), user.getCodiceProfilo());

            if (bean != null && bean.getIdFile() != null) {
                bean.setResult(getSuccessResult());
            } else {
                bean = new RichiestaExportMarcaggioComuniOutputBean();
                bean.setResult(new Result(ResultCodeEnum.GENERIC_ERROR.getCode(), "Errore Generico", ResultCodeEnum.GENERIC_ERROR.getMessage()));
            }
        } catch (Exception e) {
            logger.info("Richiesta di export ordine fallita", e);
            throw e;
        }
        return bean;
    }
}
