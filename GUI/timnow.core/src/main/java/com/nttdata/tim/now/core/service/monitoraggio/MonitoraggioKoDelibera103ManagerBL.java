package com.nttdata.tim.now.core.service.monitoraggio;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.monitoraggio.MonitoraggioKoDelibera103RESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.monitoring.kodel103.MonitoraggioKoDel103OutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.monitoring.kodel103.MonitoraggioKoDelibera103ListDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//Change Request #42013
@Service
public class MonitoraggioKoDelibera103ManagerBL extends AbstractBL {
	
	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex; 

    @Autowired
    private MonitoraggioKoDelibera103RESTClient monitoringKoDelibera103RESTClient;
    
    public GenericListBean<MonitoraggioKoDel103OutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String tipoProfilo)
            throws BusinessLayerException {
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(), pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata Ordine");
    	}

        GenericListBean<MonitoraggioKoDel103OutputBean> list = new GenericListBean<>();
        MonitoraggioKoDelibera103ListDTO result = null;
        boolean isLimited;
        // Gestione lista limitata
        try {
            AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
            result = monitoringKoDelibera103RESTClient.advancedSearch(inputDto, tipoProfilo);
            isLimited = validateResponseResult(result);
            list.setData(mapper.translateList(result.getListaMonitoraggioKo(), MonitoraggioKoDel103OutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }

}
