package com.nttdata.tim.now.core.converter.offerta;

import com.nttdata.tim.now.data.bean.offerta.OffertaOutputBean;
import com.nttdata.tim.now.data.dto.offerta.OffertaOutputDTO;
import com.nttdata.tim.now.data.enumeration.TipoOfferta;

import org.dozer.DozerConverter;

public class OffertaConverter extends DozerConverter<OffertaOutputDTO, OffertaOutputBean> {

    public OffertaConverter() {
        super(OffertaOutputDTO.class, OffertaOutputBean.class);
    }

    @Override
    public OffertaOutputDTO convertFrom(OffertaOutputBean source, OffertaOutputDTO destinationDTO) {
    	if (source == null) {
    		return null;
    	}
    	
    	OffertaOutputDTO destination = new OffertaOutputDTO();
    	destination.setIdOfferta(source.getIdOfferta());
    	destination.setNomeOfferta(source.getNomeOfferta());
    	destination.setNomeOffertaCatalogo(source.getNomeOffertaCatalogo());
        return destination;
    }

    @Override
    public OffertaOutputBean convertTo(OffertaOutputDTO source, OffertaOutputBean destinationBean) {
    	if (source == null) {
    		return null;
    	}
        String tipoOrdine = TipoOfferta.getFamilyFromString(source.getNomeOffertaCatalogo());
        OffertaOutputBean destination = new OffertaOutputBean();
        destination.setNomeOfferta(source.getNomeOfferta());
        destination.setNomeOffertaCatalogo(source.getNomeOffertaCatalogo());
        destination.setIdOfferta(source.getIdOfferta());
        destination.setTipoOrdine(tipoOrdine);
        return destination;
    }

}
