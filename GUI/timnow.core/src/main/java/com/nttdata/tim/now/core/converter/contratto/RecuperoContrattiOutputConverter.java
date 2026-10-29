package com.nttdata.tim.now.core.converter.contratto;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.tim.now.data.bean.contratto.RecuperoContrattiOutputBean;
import com.nttdata.tim.now.data.bean.contratto.RecuperoContrattiOutputItemBean;
import com.nttdata.tim.now.data.bean.contratto.TipologiaContrattoOutputBean;
import com.nttdata.tim.now.data.dto.contratto.RecuperoContrattiOutputDTO;
import com.nttdata.tim.now.data.dto.contratto.RecuperoContrattiOutputItemDTO;
import com.nttdata.tim.now.data.dto.contratto.TipologiaContrattoOutputDTO;

import org.dozer.DozerConverter;

//RU_716
public class RecuperoContrattiOutputConverter extends DozerConverter<RecuperoContrattiOutputDTO, RecuperoContrattiOutputBean> {

    public RecuperoContrattiOutputConverter() {
        super(RecuperoContrattiOutputDTO.class, RecuperoContrattiOutputBean.class);
    }

    @Override
    public RecuperoContrattiOutputDTO convertFrom(RecuperoContrattiOutputBean source, RecuperoContrattiOutputDTO destinationDTO) {
    	if (source == null) {
    		return null;
    	}
    	
    	RecuperoContrattiOutputDTO destination = new RecuperoContrattiOutputDTO();
    	
    	List<TipologiaContrattoOutputDTO> list = new ArrayList<>();
    	RecuperoContrattiOutputItemDTO dto = new RecuperoContrattiOutputItemDTO();
    	
    	for(TipologiaContrattoOutputBean s : source.getRecuperoContrattoOutput().getTipologiaContrattoOutput()) {
    		TipologiaContrattoOutputDTO tempDTO = new TipologiaContrattoOutputDTO();
    		tempDTO.setIdTipologiaContratto(s.getIdTipologiaContratto());
    		tempDTO.setTipologiaContratto(s.getTipologiaContratto());
    		list.add(tempDTO);
    	}
  	
    	dto.setTipologiaContrattoOutput(list);
    	
    	destination.setRecuperoContrattoOutput(dto);
    	
        return destination;
    }

    @Override
    public RecuperoContrattiOutputBean convertTo(RecuperoContrattiOutputDTO source, RecuperoContrattiOutputBean destinationBean) {
    	if (source == null) {
    		return null;
    	}

    	RecuperoContrattiOutputBean destination = new RecuperoContrattiOutputBean();
    	
    	List<TipologiaContrattoOutputBean> list = new ArrayList<>();
    	RecuperoContrattiOutputItemBean bean = new RecuperoContrattiOutputItemBean();
    	
    	for(TipologiaContrattoOutputDTO s : source.getRecuperoContrattoOutput().getTipologiaContrattoOutput()) {
    		TipologiaContrattoOutputBean tempBean = new TipologiaContrattoOutputBean();
    		tempBean.setIdTipologiaContratto(s.getIdTipologiaContratto());
    		tempBean.setTipologiaContratto(s.getTipologiaContratto());
    		list.add(tempBean);
    	}
    	
    	bean.setTipologiaContrattoOutput(list);
    	
    	destination.setRecuperoContrattoOutput(bean);
    	
        return destination;
    }

}
