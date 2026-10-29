package com.nttdata.tim.now.core.service.olo;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.tim.now.adapters.esb.anagrafica.ContrattoRESTClient;
import com.nttdata.tim.now.adapters.esb.olo.AnagraficaOloRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.anagraficaolo.AnagraficaCodiceOloOutputBean;
import com.nttdata.tim.now.data.bean.anagraficaolo.AnagraficaOloOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.dto.anagraficaolo.AnagraficaCodiceOloOutputDTO;
import com.nttdata.tim.now.data.dto.anagraficaolo.AnagraficaOloOutputDTO;
import com.nttdata.tim.now.data.dto.anagraficaolo.AnagraficaOloWrapperOutputDTO;
import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.util.FlagHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaOloManagerBL extends AbstractBL {


	@Autowired
	private AnagraficaOloRESTClient anagraficaOloRestIL;
	
	//RU_716 NUOVO CONTRATTO
	@Autowired
	private ContrattoRESTClient contrattoCodiceOloRestIL;
	
	public GenericListBean<AnagraficaOloOutputBean> getRegistryOloList(String tipoProfilo, String codiceAgcom,
			boolean noDiffida) throws BusinessLayerException {
		logger.info("Loading Olo Registry " + codiceAgcom);
		List<AnagraficaOloOutputBean> result = new ArrayList<>();
		AnagraficaOloWrapperOutputDTO srOLODTOs;
		try {
			srOLODTOs = anagraficaOloRestIL.getSROLOs(tipoProfilo, codiceAgcom, noDiffida);
	        validateResponseResult(srOLODTOs);

		} catch (Exception e) {
			logger.error("Error reading registry olo list", e);
			throw new BusinessLayerException(e);
		}

		if (srOLODTOs != null && srOLODTOs.getProfiloOlo() != null
				&& srOLODTOs.getProfiloOlo().getAnagraficaOlo() != null) {
			boolean checkOlo = false;
			for (AnagraficaOloOutputDTO registry : srOLODTOs.getProfiloOlo().getAnagraficaOlo()) {
				if (codiceAgcom.equals(registry.getCodiceAgcom())) {
					checkOlo = true;
				}
				AnagraficaOloOutputBean bean = new AnagraficaOloOutputBean();
				bean.setId(registry.getCodiceAgcom());
				bean.setCodiceOLO(registry.getCodiceAgcom());
				bean.setNome(registry.getNome());
				bean.setAccorpante(FlagHelper.convertFromBE(registry.getFlagAccorpante()));
				//RU_1180
				bean.setCodiceOLONumerico(registry.getCodiceAgcomNumerico());
				result.add(bean);
			}
			if (!Constants.DEFAULT_OLO.equals(codiceAgcom) && noDiffida && !checkOlo) {
				result = new ArrayList<>();
			}

		} else {
			logger.debug("No registry found for the user" + codiceAgcom);
		}
		GenericListBean<AnagraficaOloOutputBean> registries = new GenericListBean<>();
		registries.setData(result);

		return registries;
	}
	
	//RU_716 NUOVO CONTRATTO
	public AnagraficaCodiceOloOutputBean getCodiceNumericoOlo(String codiceAgcom) throws BusinessLayerException{
		AnagraficaCodiceOloOutputBean bean = new AnagraficaCodiceOloOutputBean();	
		try {
		    AnagraficaCodiceOloOutputDTO codiceNumericoOlo = contrattoCodiceOloRestIL.getCodiceNumericoOlo(codiceAgcom);
			validateResponseResult(codiceNumericoOlo);
			bean=mapper.translate(codiceNumericoOlo, AnagraficaCodiceOloOutputBean.class);
		} catch(Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
