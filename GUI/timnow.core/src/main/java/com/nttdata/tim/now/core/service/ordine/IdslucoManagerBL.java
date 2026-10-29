package com.nttdata.tim.now.core.service.ordine;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.ordine.IdslucoRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.anagraficaidsluco.AnagraficaIdslucoOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.idsluco.IdslucoOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.anagraficaidsluco.AnagraficaIdslucoListOutputDTO;
import com.nttdata.tim.now.data.dto.idsluco.ListaIdslucoOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IdslucoManagerBL extends AbstractBL {

    @Autowired
    private IdslucoRESTClient idslucoRESTClient;

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

	public GenericListBean<IdslucoOutputBean> getIdslucos(String codiceAgcom, String valoreRicerca, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<IdslucoOutputBean> list = new GenericListBean<>();
		try {
			ListaIdslucoOutputDTO dto = idslucoRESTClient.getIdslucos(codiceAgcom, valoreRicerca, tipoProfilo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getIdullcos(), IdslucoOutputBean.class));
		} catch (Exception e) {
			logger.error("Error reading idslucos", e);
			throw new BusinessLayerException(e);
		}
		return list;
	}

    public GenericListBean<AnagraficaIdslucoOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String codOloAgcom, String tipoProfilo)
            throws BusinessLayerException {
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata IdslucoManager");
    	}

    	GenericListBean<AnagraficaIdslucoOutputBean> list = new GenericListBean<>();
        AnagraficaIdslucoListOutputDTO result = null;
        boolean isLimited;
        // Gestione lista limitata
        try {
            AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
            result = idslucoRESTClient.advancedSearch(inputDto, codOloAgcom, tipoProfilo);
            isLimited = validateResponseResult(result);
            list.setData(mapper.translateList(result.getList(), AnagraficaIdslucoOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }

}
