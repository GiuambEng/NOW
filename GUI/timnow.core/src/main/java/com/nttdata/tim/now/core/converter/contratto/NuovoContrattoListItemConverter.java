package com.nttdata.tim.now.core.converter.contratto;

import com.nttdata.tim.now.data.bean.contratto.NuovoContrattoListItemBean;
import com.nttdata.tim.now.data.dto.contratto.NuovoContrattoListItemDTO;

import org.dozer.DozerConverter;

//RU_716
public class NuovoContrattoListItemConverter extends DozerConverter<NuovoContrattoListItemDTO, NuovoContrattoListItemBean> {

    public NuovoContrattoListItemConverter() {
        super(NuovoContrattoListItemDTO.class, NuovoContrattoListItemBean.class);
    }

    @Override
    public NuovoContrattoListItemDTO convertFrom(NuovoContrattoListItemBean source, NuovoContrattoListItemDTO destinationDTO) {
    	if (source == null) {
    		return null;
    	}
    	
    	NuovoContrattoListItemDTO destination = new NuovoContrattoListItemDTO();
    	
    	destination.setCodiceContratto(source.getCodiceContratto());
    	destination.setCodiceOloNumerico(source.getCodiceOloNumerico());
    	destination.setCodificaOloAgcom(source.getCodificaOloAgcom());
    	destination.setDataFineAssociazioneOffertaContratto(source.getDataFineAssociazioneOffertaContratto());
    	destination.setDataFineValiditaContratto(source.getDataFineValiditaContratto());
    	destination.setDataInizioAssociazioneOffertaContratto(source.getDataInizioAssociazioneOffertaContratto());
    	destination.setDataInizioValiditaContratto(source.getDataInizioValiditaContratto());
    	destination.setFlagAbilitato(source.getFlagAbilitato());
    	destination.setFlagFileNotify(source.getFlagFileNotify());
    	destination.setFlagValido(source.getFlagValido());
    	destination.setIdFamigliaOfferta(source.getIdFamigliaOfferta());
    	destination.setIdOfferta(source.getIdOfferta());
        destination.setIdSottofamigliaOfferta(source.getIdSottofamigliaOfferta());
        destination.setNomeContratto(source.getNomeContratto());
        destination.setOperatore(source.getOperatore());
        destination.setTipoProfilo(source.getTipoProfilo());
        destination.setIdTipologiaContratto(source.getIdTipologiaContratto());
    	
    	return destination;
    }

    @Override
    public NuovoContrattoListItemBean convertTo(NuovoContrattoListItemDTO source, NuovoContrattoListItemBean destinationBean) {
    	if (source == null) {
    		return null;
    	}
    	
    	NuovoContrattoListItemBean destination = new NuovoContrattoListItemBean();
    	
    	destination.setCodiceContratto(source.getCodiceContratto());
    	destination.setCodiceOloNumerico(source.getCodiceOloNumerico());
    	destination.setCodificaOloAgcom(source.getCodificaOloAgcom());
    	destination.setDataFineAssociazioneOffertaContratto(source.getDataFineAssociazioneOffertaContratto());
    	destination.setDataFineValiditaContratto(source.getDataFineValiditaContratto());
    	destination.setDataInizioAssociazioneOffertaContratto(source.getDataInizioAssociazioneOffertaContratto());
    	destination.setDataInizioValiditaContratto(source.getDataInizioValiditaContratto());
    	destination.setFlagAbilitato(source.getFlagAbilitato());
    	destination.setFlagFileNotify(source.getFlagFileNotify());
    	destination.setFlagValido(source.getFlagValido());
    	destination.setIdFamigliaOfferta(source.getIdFamigliaOfferta());
    	destination.setIdOfferta(source.getIdOfferta());
        destination.setIdSottofamigliaOfferta(source.getIdSottofamigliaOfferta());
        destination.setNomeContratto(source.getNomeContratto());
        destination.setOperatore(source.getOperatore());
        destination.setTipoProfilo(source.getTipoProfilo());
        destination.setIdTipologiaContratto(source.getIdTipologiaContratto());
    	
    	return destination;
    }

}
