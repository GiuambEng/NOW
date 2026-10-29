package com.nttdata.tim.now.core.service.anagrafica;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.anagrafica.ClienteRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.cliente.ClienteOutputBean;
import com.nttdata.tim.now.data.bean.export.ExportableDataOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.cliente.ListaClienteOutputDTO;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ClienteManagerBL extends AbstractBL {

    @Autowired
    private ClienteRESTClient clienteRestIL;

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

    
    @Cacheable(value = "customers", key = "#codOloAgcom + '-' + #tipoProfilo")
    public GenericListBean<ClienteOutputBean> getCustomers(String codOloAgcom, String tipoProfilo, String userId) throws BusinessLayerException {
        GenericListBean<ClienteOutputBean> list = new GenericListBean<>();
        boolean isLimited;
		//Gestione lista limitata
        try {
            ListaClienteOutputDTO dto = clienteRestIL.getCustomers(codOloAgcom, tipoProfilo, userId);
            isLimited = validateResponseResult(dto);
            list.setData(mapper.translateList(dto.getCustomers(), ClienteOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            logger.error("Error reading customers", e);
            throw new BusinessLayerException(e);
        }
        return list;
    }

    public GenericListBean<ClienteOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String codOloAgcom, String tipoProfilo, String userId)
            throws BusinessLayerException {
        GenericListBean<ClienteOutputBean> list = new GenericListBean<>();
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata Cliente");
    	}

        boolean isLimited;
		//Gestione lista limitata
        try {
            AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
            ListaClienteOutputDTO dto = clienteRestIL.advancedSearch(inputDto, codOloAgcom, tipoProfilo, userId);
            isLimited = validateResponseResult(dto);
            list.setData(mapper.translateList(dto.getCustomers(), ClienteOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }

    public ExportableDataOutputBean requestExport(RicercaAvanzataInputBean inputBean, String codOloAgcom, String tipoProfilo, String userId) throws BusinessLayerException {
        ExportableDataOutputBean bean = new ExportableDataOutputBean();
        try {
            AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
            ExportableDataOutputDTO dto = clienteRestIL.advancedSearch(inputDto, codOloAgcom, tipoProfilo, userId);
            validateResponseResult(dto);
            bean = mapper.translate(dto, ExportableDataOutputBean.class);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }
}
