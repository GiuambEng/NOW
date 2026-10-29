package com.nttdata.tim.now.core.converter.contratto;

import com.nttdata.tim.now.data.bean.contratto.RecuperoDatiContrattoOutputBean;
import com.nttdata.tim.now.data.dto.contratto.RecuperoDatiContrattoOutputDTO;

import org.dozer.DozerConverter;

//RU_716
public class RecuperoDatiContrattoOutputConverter extends DozerConverter<RecuperoDatiContrattoOutputDTO, RecuperoDatiContrattoOutputBean> {


    public RecuperoDatiContrattoOutputConverter() {
        super(RecuperoDatiContrattoOutputDTO.class, RecuperoDatiContrattoOutputBean.class);
    }

    @Override
    public RecuperoDatiContrattoOutputDTO convertFrom(RecuperoDatiContrattoOutputBean source, RecuperoDatiContrattoOutputDTO destinationDTO) {
    	if (source == null) {
    		return null;
    	}
    	
    	RecuperoDatiContrattoOutputDTO destination = new RecuperoDatiContrattoOutputDTO();
    	
    	destination.setIdFamigliaOfferta(source.getIdFamigliaOfferta());
    	destination.setIdOfferta(source.getIdOfferta());
    	destination.setIdSottofamigliaOfferta(source.getIdSottofamigliaOfferta());
    	destination.setOfferta(source.getOfferta());
    	destination.setTipoProdotti(source.getTipoProdotti());
    	destination.setTipoServizio(source.getTipoServizio());
    	
        return destination;
    }

    @Override
    public RecuperoDatiContrattoOutputBean convertTo(RecuperoDatiContrattoOutputDTO source, RecuperoDatiContrattoOutputBean destinationBean) {
    	if (source == null) {
    		return null;
    	}
    	
        RecuperoDatiContrattoOutputBean destination = new RecuperoDatiContrattoOutputBean();
        
        destination.setIdFamigliaOfferta(source.getIdFamigliaOfferta());
    	destination.setIdOfferta(source.getIdOfferta());
    	destination.setIdSottofamigliaOfferta(source.getIdSottofamigliaOfferta());
    	destination.setOfferta(source.getOfferta());
    	destination.setTipoProdotti(source.getTipoProdotti());
    	destination.setTipoServizio(source.getTipoServizio());
        
        return destination;
    }


}
