package com.nttdata.tim.now.web.controller.anagrafica;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.anagrafica.DisaggregazioneManagerBL;
import com.nttdata.tim.now.data.bean.anagraficadisaggregazione.AnagraficaDisaggregazioneOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anagraficadisaggregazione")
public class AnagraficaDisaggregazioneController extends GenericController {

    @Autowired
    private DisaggregazioneManagerBL anagDisaggregazioneManagerBL;
    

	// Ricerca Avanzata
	@JsonGetMapping
	//R1I_20_0131
	public GenericListBean<AnagraficaDisaggregazioneOutputBean> getAnagraficaDisaggregazione(@RequestParam(name = "sezione") String sezione, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<AnagraficaDisaggregazioneOutputBean> bean = anagDisaggregazioneManagerBL.getAnagraficaDisaggregazione(user.getCodificaOloAgcom(), user.getCodiceProfilo(), sezione);
		bean = ensureListBeanResult(bean);
		return bean;
	}

	

}
