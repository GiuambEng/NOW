package com.nttdata.tim.now.web.controller.monitoraggio;

import javax.servlet.http.HttpSession;
import javax.ws.rs.NotFoundException;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.NotReadyException;
import com.nttdata.tim.now.core.service.monitoraggio.MonitoraggioRimodulazioniDACManagerBL;
import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;
import com.nttdata.tim.now.data.bean.monitoring.rimodulazionedac.MonitoraggioRimodulazioniDACOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.FileDownloadController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitorings/rimodulazionidac")
public class MonitoraggioRimodulazioniDACController extends FileDownloadController {

    @Autowired
    private MonitoraggioRimodulazioniDACManagerBL monitoraggioRimodulazioniDACManagerBL;

    @JsonGetMapping
    public MonitoraggioRimodulazioniDACOutputBean getLista(HttpSession session) throws BusinessLayerException {
    	UserBean user = getCurrentUser(session);
        MonitoraggioRimodulazioniDACOutputBean bean = monitoraggioRimodulazioniDACManagerBL.getLista(user.getCodiceProfilo());
        bean = ensureBeanResult(bean, MonitoraggioRimodulazioniDACOutputBean.class);
        return bean;
    }

    @JsonGetMapping("/export/{contatoreSingolo:[1-8]{1}}")
    public ResponseEntity<byte[]> getContatori(
    		@PathVariable int contatoreSingolo,
    		@RequestParam(value = "vista", required = false) String vista,	//SM_8906
    		HttpSession session) throws BusinessLayerException {
        logger.info("Inside export");
    	UserBean user = getCurrentUser(session);
        try {
            logger.info("Before BL export");
            FileScaricatoBean fileBean = monitoraggioRimodulazioniDACManagerBL.getContatoreSingolo(contatoreSingolo, user.getCodiceProfilo(), vista, user);
            logger.info("After BL export");
            return getFileResponseEntity(fileBean);
        } catch (NotReadyException e) {
            logger.info("Recupero Export fallito: file ancora non pronto o non esistente");
            throw new NotFoundException(e);
        }
    }

    @JsonGetMapping("/refresh")
    public MonitoraggioRimodulazioniDACOutputBean refresh(HttpSession session) throws BusinessLayerException {
    	UserBean user = getCurrentUser(session);
        MonitoraggioRimodulazioniDACOutputBean bean = monitoraggioRimodulazioniDACManagerBL.refresh(user.getCodiceProfilo());
        bean = ensureBeanResult(bean, MonitoraggioRimodulazioniDACOutputBean.class);
        return bean;
    }

}
