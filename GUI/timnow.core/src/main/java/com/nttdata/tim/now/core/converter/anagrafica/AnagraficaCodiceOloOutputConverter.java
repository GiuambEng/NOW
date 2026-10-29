package com.nttdata.tim.now.core.converter.anagrafica;

import com.nttdata.tim.now.data.bean.anagraficaolo.AnagraficaCodiceOloOutputBean;
import com.nttdata.tim.now.data.dto.anagraficaolo.AnagraficaCodiceOloOutputDTO;

import org.dozer.DozerConverter;

//RU_716
public class AnagraficaCodiceOloOutputConverter extends DozerConverter<AnagraficaCodiceOloOutputDTO, AnagraficaCodiceOloOutputBean> {

    public AnagraficaCodiceOloOutputConverter() {
        super(AnagraficaCodiceOloOutputDTO.class, AnagraficaCodiceOloOutputBean.class);
    }

    @Override
    public AnagraficaCodiceOloOutputDTO convertFrom(AnagraficaCodiceOloOutputBean source, AnagraficaCodiceOloOutputDTO destinationDTO) {
    	if (source == null) {
    		return null;
    	}
    	
    	AnagraficaCodiceOloOutputDTO destination = new AnagraficaCodiceOloOutputDTO();
    	destination.setCodOloNumerico(source.getCodOloNumerico());
        return destination;
    }

    @Override
    public AnagraficaCodiceOloOutputBean convertTo(AnagraficaCodiceOloOutputDTO source, AnagraficaCodiceOloOutputBean destinationBean) {
    	if (source == null) {
    		return null;
    	}
        AnagraficaCodiceOloOutputBean destination = new AnagraficaCodiceOloOutputBean();
        destination.setCodOloNumerico(source.getCodOloNumerico());
        return destination;
    }

}
