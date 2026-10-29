package com.nttdata.tim.now.core.converter.ricerca.avanzata;

import java.util.ArrayList;

import com.nttdata.tim.now.data.bean.ricerca.RicercaCampiOutputBean;
import com.nttdata.tim.now.data.dto.ricerca.FieldsResearchDTO;

import org.dozer.DozerConverter;

public class FieldsResearchDTOToRicercaCampiOutputBeanConverter extends DozerConverter<FieldsResearchDTO, RicercaCampiOutputBean> {

    public FieldsResearchDTOToRicercaCampiOutputBeanConverter() {
        super(FieldsResearchDTO.class, RicercaCampiOutputBean.class);
      
    }

    @Override
    public FieldsResearchDTO convertFrom(RicercaCampiOutputBean bean, FieldsResearchDTO dto) {
        return null;
    }

    @Override
    public RicercaCampiOutputBean convertTo(FieldsResearchDTO dto, RicercaCampiOutputBean destinationBean) {
        if (dto!= null){
        	RicercaCampiOutputBean destination = new RicercaCampiOutputBean();
        	destination.setNomeDB(dto.getNomeDB());
        	destination.setTipoDato(dto.getTipoDato());
        	destination.setLabel(dto.getLabel());
        	ArrayList<String> listaValori = new ArrayList<>();
        	
        	if(dto.getDefaultValue() != null){
        		String[] tokens = dto.getDefaultValue().split(";");
        		if(tokens.length >= 2){
        			int size = tokens.length;
        			for(int i=0; i< size; i++){
        				String item = tokens[i];
        				listaValori.add(item);
        			}
        		}
        	}

    		destination.setDefaultValue(listaValori);
            return destination;
        }
        
        return null;
    }

}
