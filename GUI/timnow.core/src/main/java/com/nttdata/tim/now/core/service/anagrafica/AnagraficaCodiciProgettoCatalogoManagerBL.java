package com.nttdata.tim.now.core.service.anagrafica;

import com.nttdata.tim.now.adapters.esb.anagrafica.AnagraficaCodiciProgettoCatalogoRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.anagraficacodiciprogettocatalogo.AnagraficaCodiciProgettoCatalogoWrapperOutputBean;
import com.nttdata.tim.now.data.dto.anagraficacodiciprogettocatalogo.AnagraficaCodiciProgettoCatalogoWrapperOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1485
@Service
public class AnagraficaCodiciProgettoCatalogoManagerBL extends AbstractBL {

	@Autowired
	private AnagraficaCodiciProgettoCatalogoRESTClient anagraficaCodiciProgettoCatalogoRESTClient;

    public AnagraficaCodiciProgettoCatalogoWrapperOutputBean listaCodiciProgettoCatalogo( String tipoProfilo)
            throws BusinessLayerException {

    	AnagraficaCodiciProgettoCatalogoWrapperOutputDTO resultDto = null;
    	AnagraficaCodiciProgettoCatalogoWrapperOutputBean resultBean = null;
        try {        	
        	resultDto = anagraficaCodiciProgettoCatalogoRESTClient.listaCodiciProgettoCatalogo(tipoProfilo);            
            validateResponseResult(resultDto);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        
        if(resultDto != null) {
        	resultBean = mapper.translate(resultDto, AnagraficaCodiciProgettoCatalogoWrapperOutputBean.class);
        }
        return resultBean;
    }
    
	
}
