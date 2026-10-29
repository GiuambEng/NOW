package com.nttdata.tim.now.web.controller.anagrafica;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.anagrafica.RisorseFwaWillDecoManagerBL;
import com.nttdata.tim.now.data.bean.anagraficafwawilldeco.DettaglioRisorsaFwaWillDecoWrapperOutputBean;
import com.nttdata.tim.now.data.bean.anagraficafwawilldeco.ModificaRisorsaFwaWillDecoInputBean;
import com.nttdata.tim.now.data.bean.anagraficafwawilldeco.NuovaRisorsaFwaWillDecoInputBean;
import com.nttdata.tim.now.data.bean.anagraficafwawilldeco.RisorseFwaWillDecoWrapperOutputBean;
import com.nttdata.tim.now.data.bean.esito.EsitoOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.FileDownloadController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RU_1335
@RestController
@RequestMapping("/risorseFwaWillDeco")
public class RisorseFwaWillDecoController extends FileDownloadController  {

    @Autowired
    private RisorseFwaWillDecoManagerBL risorseFwaWillDecoManagerBL;
       
    @JsonGetMapping("/list")
    public RisorseFwaWillDecoWrapperOutputBean list(HttpSession session) throws BusinessLayerException {
    	logger.debug("Anagrafica Risorse FWA Will Deco");
        UserBean user = getCurrentUser(session);
        RisorseFwaWillDecoWrapperOutputBean bean = risorseFwaWillDecoManagerBL.list(user.getCodiceProfilo());
        return bean;
    }
    
    @JsonGetMapping("/details/{idRisorsa}")
    public DettaglioRisorsaFwaWillDecoWrapperOutputBean details(@PathVariable String idRisorsa, HttpSession session) throws BusinessLayerException {
    	logger.debug("Dettaglio Risorse FWA Will Deco");
        UserBean user = getCurrentUser(session);
        DettaglioRisorsaFwaWillDecoWrapperOutputBean bean = risorseFwaWillDecoManagerBL.details(idRisorsa, user.getCodiceProfilo());
        return bean;
    }
    
    @JsonPostMapping("/create")
    public EsitoOutputBean create(@RequestBody NuovaRisorsaFwaWillDecoInputBean inputBean, HttpSession session) throws BusinessLayerException {
          logger.info("Creazione Risorsa FWA Will Deco");
          EsitoOutputBean bean= new EsitoOutputBean();
          UserBean user = getCurrentUser(session);
          String operatore = user.getUserId();
          try {
                 inputBean.setOperatore(operatore);
                 bean = risorseFwaWillDecoManagerBL.create(inputBean, user.getCodiceProfilo());
          } catch (Exception e) {
                 logger.info("Richiesta di creazione nuova risorsa FWA Will Deco fallita", e);
                 throw e;
          }
          return bean;
    }
    
    @JsonPostMapping("/edit")
    public EsitoOutputBean edit(@RequestBody ModificaRisorsaFwaWillDecoInputBean inputBean, HttpSession session) throws BusinessLayerException {
          logger.info("Modifica Risorsa FWA Will Deco");
          EsitoOutputBean bean= new EsitoOutputBean();
          UserBean user = getCurrentUser(session);
          String operatore = user.getUserId();
          try {
                 inputBean.setOperatore(operatore);
                 bean = risorseFwaWillDecoManagerBL.edit(inputBean, user.getCodiceProfilo());
          } catch (Exception e) {
                 logger.info("Richiesta di modifica risorsa FWA Will Deco fallita", e);
                 throw e;
          }
          return bean;
    }
    
	 
}
