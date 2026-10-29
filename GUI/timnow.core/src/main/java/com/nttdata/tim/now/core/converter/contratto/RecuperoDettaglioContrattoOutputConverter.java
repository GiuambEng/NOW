package com.nttdata.tim.now.core.converter.contratto;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.tim.now.data.bean.contratto.DatiSospensioneServizioOutputBean;
import com.nttdata.tim.now.data.bean.contratto.FileMulticastSimpleOutputBean;
import com.nttdata.tim.now.data.bean.contratto.RecuperoDettaglioContrattoOutputBean;
import com.nttdata.tim.now.data.bean.contratto.RecuperoDettaglioContrattoOutputItemBean;
import com.nttdata.tim.now.data.dto.contratto.DatiSospensioneServizioOutputDTO;
import com.nttdata.tim.now.data.dto.contratto.FileMulticastOutputDTO;
import com.nttdata.tim.now.data.dto.contratto.RecuperoDettaglioContrattoOutputDTO;
import com.nttdata.tim.now.data.dto.contratto.RecuperoDettaglioContrattoOutputItemDTO;
import com.nttdata.tim.now.util.data.DozerHelper;
import com.nttdata.tim.now.util.date.DateHelper;

import org.dozer.DozerConverter;

//RU_716_Nuovo_Contratto
public class RecuperoDettaglioContrattoOutputConverter extends DozerConverter<RecuperoDettaglioContrattoOutputDTO, RecuperoDettaglioContrattoOutputBean>{
	
	private DozerHelper mapper;
	
	public RecuperoDettaglioContrattoOutputConverter() {
        super(RecuperoDettaglioContrattoOutputDTO.class, RecuperoDettaglioContrattoOutputBean.class);
    }

    @Override
    public RecuperoDettaglioContrattoOutputDTO convertFrom(RecuperoDettaglioContrattoOutputBean source, RecuperoDettaglioContrattoOutputDTO destinationDTO) {
    	if (source == null) {
    		return null;
    	}
        
        RecuperoDettaglioContrattoOutputDTO destination = new RecuperoDettaglioContrattoOutputDTO();
        RecuperoDettaglioContrattoOutputItemDTO dto = new RecuperoDettaglioContrattoOutputItemDTO();
		
        dto.setCodiceContratto(source.getDettaglioContratto().getCodiceContratto());
        dto.setCodiceOloNumerico(source.getDettaglioContratto().getCodiceOloNumerico());
        dto.setCodificaOloAgcom(source.getDettaglioContratto().getCodificaOloAgcom());
		dto.setDataFineAssociazioneOffertaContratto(DateHelper.convertFromFE(source.getDettaglioContratto().getDataFineAssociazioneOffertaContratto()));
		dto.setDataFineValiditaContratto(DateHelper.convertFromFE(source.getDettaglioContratto().getDataFineValiditaContratto()));
		dto.setDataInizioAssociazioneOffertaContratto(DateHelper.convertFromFE(source.getDettaglioContratto().getDataInizioAssociazioneOffertaContratto()));
		dto.setDataInizioValiditaContratto(DateHelper.convertFromFE(source.getDettaglioContratto().getDataInizioValiditaContratto()));
		dto.setFlagAbilitato(source.getDettaglioContratto().getFlagAbilitato());
		dto.setFlagFileNotify(source.getDettaglioContratto().getFlagFileNotify());
		dto.setFlagValido(source.getDettaglioContratto().getFlagValido());
		dto.setIdContrattoOffertaCatalogo(source.getDettaglioContratto().getIdContrattoOffertaCatalogo());
		dto.setNomeContratto(source.getDettaglioContratto().getNomeContratto());
		dto.setOfferta(source.getDettaglioContratto().getOfferta());
		dto.setTipoContratto(source.getDettaglioContratto().getTipoContratto());
		dto.setTipoProdotti(source.getDettaglioContratto().getTipoProdotti());
		dto.setTipoServizio(source.getDettaglioContratto().getTipoServizio());
		
		//SM_9996
		dto.setContrattoFwaDecommissioning(source.getDettaglioContratto().getContrattoFwaDecommissioning());
		dto.setContrattoFwaInfratel(source.getDettaglioContratto().getContrattoFwaInfratel());
		dto.setContrattoFwaPlus(source.getDettaglioContratto().getContrattoFwaPlus());
		
		//RU_1164
		dto.setDataInizioCoinvestimento(DateHelper.convertFromFE(source.getDettaglioContratto().getDataInizioCoinvestimento()));
		dto.setDataFineCoinvestimento(DateHelper.convertFromFE(source.getDettaglioContratto().getDataFineCoinvestimento()));

		//RU_1180
		dto.setBouquet(source.getDettaglioContratto().getBouquet());
		dto.setFlagMulticast(source.getDettaglioContratto().getFlagMulticast());
		dto.setListaFileCsv(buildListaFileCsvMulticastToDto(source.getDettaglioContratto().getListaFileCsv()));
		
		//SM_10292
		dto.setDatiSospensioneServizio(buildDatiSospensioneServizioToDTO(source.getDettaglioContratto().getDatiSospensioneServizio()));
		
		//SM_11399
		dto.setEmailOffertaFwa1GigaSardegna(source.getDettaglioContratto().getEmailOffertaFwa1GigaSardegna());
		
		destination.setDettaglioContratto(dto);
		
    	return destination;
    }

    @Override
    public RecuperoDettaglioContrattoOutputBean convertTo(RecuperoDettaglioContrattoOutputDTO source, RecuperoDettaglioContrattoOutputBean destinationBean) {
    	if (source == null) {
    		return null;
    	}
        
    	RecuperoDettaglioContrattoOutputBean destination = new RecuperoDettaglioContrattoOutputBean();
        RecuperoDettaglioContrattoOutputItemBean bean = new RecuperoDettaglioContrattoOutputItemBean();
		
        bean.setCodiceContratto(source.getDettaglioContratto().getCodiceContratto());
        bean.setCodiceOloNumerico(source.getDettaglioContratto().getCodiceOloNumerico());
        bean.setCodificaOloAgcom(source.getDettaglioContratto().getCodificaOloAgcom());
        bean.setDataFineAssociazioneOffertaContratto(DateHelper.convertFromBE(source.getDettaglioContratto().getDataFineAssociazioneOffertaContratto()));
        bean.setDataFineValiditaContratto(DateHelper.convertFromBE(source.getDettaglioContratto().getDataFineValiditaContratto()));
        bean.setDataInizioAssociazioneOffertaContratto(DateHelper.convertFromBE(source.getDettaglioContratto().getDataInizioAssociazioneOffertaContratto()));
        bean.setDataInizioValiditaContratto(DateHelper.convertFromBE(source.getDettaglioContratto().getDataInizioValiditaContratto()));
        bean.setFlagAbilitato(source.getDettaglioContratto().getFlagAbilitato());
        bean.setFlagFileNotify(source.getDettaglioContratto().getFlagFileNotify());
        bean.setFlagValido(source.getDettaglioContratto().getFlagValido());
        bean.setIdContrattoOffertaCatalogo(source.getDettaglioContratto().getIdContrattoOffertaCatalogo());
		bean.setNomeContratto(source.getDettaglioContratto().getNomeContratto());
		bean.setOfferta(source.getDettaglioContratto().getOfferta());
		bean.setTipoContratto(source.getDettaglioContratto().getTipoContratto());
		bean.setTipoProdotti(source.getDettaglioContratto().getTipoProdotti());
		bean.setTipoServizio(source.getDettaglioContratto().getTipoServizio());
		
		//SM_9996
		bean.setContrattoFwaDecommissioning(source.getDettaglioContratto().getContrattoFwaDecommissioning());
		bean.setContrattoFwaInfratel(source.getDettaglioContratto().getContrattoFwaInfratel());
		bean.setContrattoFwaPlus(source.getDettaglioContratto().getContrattoFwaPlus());
		
		//RU_1164
		bean.setDataInizioCoinvestimento(DateHelper.convertFromBE(source.getDettaglioContratto().getDataInizioCoinvestimento()));
		bean.setDataFineCoinvestimento(DateHelper.convertFromBE(source.getDettaglioContratto().getDataFineCoinvestimento()));
		
		//RU_1180
		bean.setBouquet(source.getDettaglioContratto().getBouquet());
		bean.setFlagMulticast(source.getDettaglioContratto().getFlagMulticast());
		bean.setListaFileCsv(buildListaFileCsvMulticastToBean(source.getDettaglioContratto().getListaFileCsv()));
		
		//SM_10292
		bean.setDatiSospensioneServizio(buildDatiSospensioneServizioToBean(source.getDettaglioContratto().getDatiSospensioneServizio()));
		
		//SM_11399
		bean.setEmailOffertaFwa1GigaSardegna(source.getDettaglioContratto().getEmailOffertaFwa1GigaSardegna());

		destination.setDettaglioContratto(bean);
		
    	return destination;
    }
    
    
    private List<FileMulticastOutputDTO> buildListaFileCsvMulticastToDto(List<FileMulticastSimpleOutputBean> fileList){
    	
    	List<FileMulticastOutputDTO> list = new ArrayList<FileMulticastOutputDTO>();
    	if(fileList != null && !fileList.isEmpty()) {
    		for(FileMulticastSimpleOutputBean csvBean : fileList) {
    			FileMulticastOutputDTO csvDto = new FileMulticastOutputDTO();
    			csvDto.setIdFile(csvBean.getIdFile());
    			csvDto.setNomeFile(csvBean.getNomeFile());
    			csvDto.setPosition(csvBean.getPosition());
    			csvDto.setStatoFile(csvBean.getStatoFile());
    			list.add(csvDto);
    		}
    	}   	
    	return list;    	
    }
    
    
    private List<FileMulticastSimpleOutputBean> buildListaFileCsvMulticastToBean(List<FileMulticastOutputDTO> fileList){
    	
    	List<FileMulticastSimpleOutputBean> list = new ArrayList<FileMulticastSimpleOutputBean>();
    	if(fileList != null && !fileList.isEmpty()) {
    		for(FileMulticastOutputDTO csvDto : fileList) {
    			FileMulticastSimpleOutputBean csvBean = new FileMulticastSimpleOutputBean();
    			csvBean.setIdFile(csvDto.getIdFile());
    			csvBean.setNomeFile(csvDto.getNomeFile());
    			csvBean.setPosition(csvDto.getPosition());
    			csvBean.setStatoFile(csvDto.getStatoFile());
    			list.add(csvBean);
    		}
    	}   	
    	return list;    	
    }
    
    private DatiSospensioneServizioOutputBean buildDatiSospensioneServizioToBean(DatiSospensioneServizioOutputDTO dto) {
    	DatiSospensioneServizioOutputBean bean = null;
    	if(dto != null) {
    		bean = new DatiSospensioneServizioOutputBean();
    		bean = mapper.translate(dto, DatiSospensioneServizioOutputBean.class);
    	}
    	return bean;
    }
    
    private DatiSospensioneServizioOutputDTO buildDatiSospensioneServizioToDTO(DatiSospensioneServizioOutputBean bean) {
    	DatiSospensioneServizioOutputDTO dto = null;
    	if(bean != null) {
    		dto = new DatiSospensioneServizioOutputDTO();
    		dto = mapper.translate(bean, DatiSospensioneServizioOutputDTO.class);
    	}
    	return dto;
    }
}
