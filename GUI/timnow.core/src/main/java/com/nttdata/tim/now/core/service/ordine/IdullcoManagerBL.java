package com.nttdata.tim.now.core.service.ordine;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.ordine.IdullcoRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.anagraficaidullco.AnagraficaIdullcoOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.idullco.IdullcoOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.anagraficaidullco.AnagraficaIdullcoListOutputDTO;
import com.nttdata.tim.now.data.dto.idullco.ListaIdullcoOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IdullcoManagerBL extends AbstractBL {

	@Autowired
	private IdullcoRESTClient idullcoRestClient;

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

	public GenericListBean<IdullcoOutputBean> getIdullcos(String codiceAgcom, String valoreRicerca, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<IdullcoOutputBean> list = new GenericListBean<>();
		try {
			ListaIdullcoOutputDTO dto = idullcoRestClient.getIdullcos(codiceAgcom, valoreRicerca, tipoProfilo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getVisulizzaIDULLCO(), IdullcoOutputBean.class));
		} catch (Exception e) {
			logger.error("Error reading idullcos", e);
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public GenericListBean<AnagraficaIdullcoOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String codOloAgcom, String tipoProfilo)
            throws BusinessLayerException {
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata IdullcoManager");
    	}

		GenericListBean<AnagraficaIdullcoOutputBean> list = new GenericListBean<>();
        AnagraficaIdullcoListOutputDTO result = null;
        boolean isLimited;
        // Gestione lista limitata
        try {
            AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
            result = idullcoRestClient.advancedSearch(inputDto, codOloAgcom, tipoProfilo);
            isLimited = validateResponseResult(result);
            list.setData(mapper.translateList(result.getList(), AnagraficaIdullcoOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
	}


}
