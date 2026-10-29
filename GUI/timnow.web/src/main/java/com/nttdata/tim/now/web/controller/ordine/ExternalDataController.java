package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.DtuManagerBL;
import com.nttdata.tim.now.core.service.ordine.ExternalDataManagerBL;
import com.nttdata.tim.now.core.service.ordine.JpubManagerBL;
import com.nttdata.tim.now.core.service.ordine.OpenFiberManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.dtu.DettaglioDtuOutputBean;
import com.nttdata.tim.now.data.bean.dtu.DtuOutputBean;
import com.nttdata.tim.now.data.bean.eventiopenfiber.EventoOpenFiberOutputBean;
import com.nttdata.tim.now.data.bean.externaldata.DbcfxOutputBean;
import com.nttdata.tim.now.data.bean.jpub.JpubOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/externaldata")
public class ExternalDataController extends GenericController {

	@Autowired
	private ExternalDataManagerBL dbcfxManagerBL;

	@Autowired
	private DtuManagerBL dtuManagerBL;

	@Autowired
	private JpubManagerBL jpubManagerBL;
	
	//RU_1492
	@Autowired
	private OpenFiberManagerBL openFiberManagerBL;

	// Visualizzazione External Data -> Lista Dbcfx
	@JsonGetMapping("/dbcfx/{idRichiesta:[A-Za-z0-9:_]+}")
	public GenericListBean<DbcfxOutputBean> getDbcfx(@PathVariable String idRichiesta, HttpSession session)
			throws BusinessLayerException {
		logger.debug("get dbcfx list");
		UserBean user = getCurrentUser(session);
		GenericListBean<DbcfxOutputBean> bean = dbcfxManagerBL.getDbcfx(user.getCodiceProfilo(), idRichiesta);
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Visualizzazione External Data -> Dettaglio Dtu
	@JsonGetMapping("/dtus/detail/{idEventoNow:[A-Za-z0-9:_]+}/{progressivoEventoDtu:[A-Za-z0-9:_]+}/{idRichiestaOlo:[A-Za-z0-9:_]+}")
	public DettaglioDtuOutputBean getDtu(@PathVariable String idEventoNow, HttpSession session,
			@PathVariable String progressivoEventoDtu, @PathVariable String idRichiestaOlo)
			throws BusinessLayerException {
		logger.info("get dtu by id Richiesta");
		UserBean user = getCurrentUser(session);
		DettaglioDtuOutputBean bean = dtuManagerBL.getDtu(idEventoNow, user.getCodiceProfilo(), progressivoEventoDtu,
				idRichiestaOlo);

		if (bean != null) {
			logger.debug("Dtu found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("Dtu NOT found");
			bean = new DettaglioDtuOutputBean();
			bean.setResult(getResultNotFound());
		}

		return bean;
	}

	// Visualizzazione External Data -> Lista Dtu
	@JsonGetMapping("/dtus/{idRichiesta:[A-Za-z0-9:_]+}")
	public GenericListBean<DtuOutputBean> getDtus(@PathVariable String idRichiesta, HttpSession session)
			throws BusinessLayerException {
		logger.debug("get dtu list");
		UserBean user = getCurrentUser(session);
		GenericListBean<DtuOutputBean> bean = dtuManagerBL.getDtus(user.getCodiceProfilo(), idRichiesta);
		bean = ensureListBeanResult(bean);
		return bean;
	}

	
	// Visualizzazione External Data -> Lista JPUB e Dettaglio JPUB
	@JsonGetMapping("/jpubs/{idRichiesta:[A-Za-z0-9:_]+}")
	public GenericListBean<JpubOutputBean> getJpubs(@PathVariable String idRichiesta, HttpSession session)
			throws BusinessLayerException {
		logger.info("get JPUBs");
		UserBean user = getCurrentUser(session);
		GenericListBean<JpubOutputBean> bean = jpubManagerBL.getJpubs(user.getCodiceProfilo(), idRichiesta);
		bean = ensureListBeanResult(bean);
		return bean;
	}
	
	//RU_1492
	// Visualizzazione External Data -> Lista eventi OpenFiber
	@JsonGetMapping("/openFiber/{idRichiesta:[A-Za-z0-9:_]+}")
	public GenericListBean<EventoOpenFiberOutputBean> getEventiOpenFiber(@PathVariable String idRichiesta, HttpSession session)
			throws BusinessLayerException {
		logger.info("get Eventi OpenFiber");
		UserBean user = getCurrentUser(session);
		GenericListBean<EventoOpenFiberOutputBean> bean = openFiberManagerBL.getEventi(user.getCodiceProfilo(), idRichiesta);
		bean = ensureListBeanResult(bean);
		return bean;
	}

}
