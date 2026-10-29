package com.nttdata.tim.now.core.converter.offerta;

import com.nttdata.tim.now.data.bean.ordine.DettaglioOffertaOrdineBean;
import com.nttdata.tim.now.data.dto.offerta.OfferDetailDTO;
import com.nttdata.tim.now.util.FlagHelper;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerConverter;

public class DettaglioOffertaOrdineConverter extends DozerConverter<DettaglioOffertaOrdineBean, OfferDetailDTO> {

    private static final String FLAG = "flag";

    public DettaglioOffertaOrdineConverter() {
        super(DettaglioOffertaOrdineBean.class, OfferDetailDTO.class);
    }

    @Override
    public DettaglioOffertaOrdineBean convertFrom(OfferDetailDTO source, DettaglioOffertaOrdineBean destinationBean) {
    	if (source == null) {
    		return null;
    	}
    	
    	DettaglioOffertaOrdineBean destination = new DettaglioOffertaOrdineBean();
    	destination.setComponente(source.getComponente());
    	destination.setDft(source.getDft());
    	destination.setDomain(source.getDomain());
    	destination.setKey(source.getKey());
    	destination.setLabel(source.getLabel());
    	destination.setMandatory(source.getMandatory());
    	destination.setProgressivo(source.getProgressivo());
    	destination.setTipologiaDato(source.getTipologiaDato());
        return destination;
    }

    @Override
    public OfferDetailDTO convertTo(DettaglioOffertaOrdineBean source, OfferDetailDTO destinationDto) {
    	if (source == null || StringUtils.isNotEmpty(source.getDft())) {
    		return null;
    	}
    	
    	OfferDetailDTO destination = new OfferDetailDTO();
    	destination.setKey(source.getKey());
    	destination.setComponente(source.getComponente());
    	destination.setTipologiaDato(source.getTipologiaDato());
    	destination.setProgressivo(source.getProgressivo());
        if (FLAG.equalsIgnoreCase(source.getDomain())) {
        	boolean booleanDefault = Boolean.TRUE.toString().equalsIgnoreCase(source.getDft());
        	destination.setDft(FlagHelper.convertFromFE(booleanDefault));
        } else {
        	destination.setDft(source.getDft());
        }

        return destination;
    }

}
