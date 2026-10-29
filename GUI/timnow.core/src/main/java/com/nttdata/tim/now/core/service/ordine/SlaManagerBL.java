package com.nttdata.tim.now.core.service.ordine;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.ordine.SlaRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.sla.SlaTimeOutputBean;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.dto.sla.ListaSlaTimeOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SlaManagerBL extends AbstractBL {

    @Autowired
    private SlaRESTClient slaRestIL;

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

    public GenericListBean<SlaTimeOutputBean> getSlaTime(String tipoProfilo) throws BusinessLayerException {
        GenericListBean<SlaTimeOutputBean> list = new GenericListBean<>();
        try {
            ListaSlaTimeOutputDTO dto = slaRestIL.getSlaTime(tipoProfilo);
            validateResponseResult(dto);

            list.setData(mapper.translateList(dto.getSlaTimes(), SlaTimeOutputBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }

    public GenericListBean<SlaTimeOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String tipoProfilo) throws BusinessLayerException {
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata SlaManager");
    	}

    	GenericListBean<SlaTimeOutputBean> result = new GenericListBean<>();
        try {
            AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
            ListaSlaTimeOutputDTO list = slaRestIL.advancedSearch(inputDto, tipoProfilo);
            validateResponseResult(list);

            result.setData(mapper.translateList(list.getSlaTimes(), SlaTimeOutputBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return result;
    }

}
