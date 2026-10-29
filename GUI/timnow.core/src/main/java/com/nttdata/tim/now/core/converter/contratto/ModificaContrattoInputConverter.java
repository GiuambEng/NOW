package com.nttdata.tim.now.core.converter.contratto;

import com.nttdata.tim.now.data.bean.contratto.DatiSospensioneServizioInputBean;
import com.nttdata.tim.now.data.bean.contratto.ModificaContrattoInputBean;
import com.nttdata.tim.now.data.bean.contratto.ModificaContrattoItemInputBean;
import com.nttdata.tim.now.data.dto.contratto.DatiSospensioneServizioInputDTO;
import com.nttdata.tim.now.data.dto.contratto.ModificaContrattoInputDTO;
import com.nttdata.tim.now.data.dto.contratto.ModificaContrattoItemInputDTO;
import com.nttdata.tim.now.util.data.DozerHelper;

import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

//RU_716
public class ModificaContrattoInputConverter extends DozerConverter<ModificaContrattoInputDTO, ModificaContrattoInputBean> implements MapperAware{

	private DozerHelper mapper;

	public ModificaContrattoInputConverter() {
		super(ModificaContrattoInputDTO.class, ModificaContrattoInputBean.class);
	}

	@Override
	public void setMapper(Mapper mapper) {
		DozerHelper dozerHelper = new DozerHelper();
		dozerHelper.setMapper(mapper);
		this.mapper = dozerHelper; 
	}


	@Override
	public ModificaContrattoInputDTO convertFrom(ModificaContrattoInputBean source, ModificaContrattoInputDTO destinationDTO) {
		if (source == null) {
			return null;
		}

		ModificaContrattoInputDTO destination = new ModificaContrattoInputDTO();
		ModificaContrattoItemInputDTO dto = new ModificaContrattoItemInputDTO();

		dto.setDataFineAssociazioneOffertaContratto(source.getModificaContrattoInput().getDataFineAssociazioneOffertaContratto());
		dto.setDataFineValiditaContratto(source.getModificaContrattoInput().getDataFineValiditaContratto());
		dto.setFlagAbilitato(source.getModificaContrattoInput().getFlagAbilitato());
		dto.setFlagFileNotify(source.getModificaContrattoInput().getFlagFileNotify());
		dto.setFlagValido(source.getModificaContrattoInput().getFlagValido());
		dto.setIdContratto(source.getModificaContrattoInput().getIdContratto());
		dto.setIdContrattoOffertaCatalogo(source.getModificaContrattoInput().getIdContrattoOffertaCatalogo());
		dto.setOperatore(source.getModificaContrattoInput().getOperatore());
		dto.setTipoProfilo(source.getModificaContrattoInput().getTipoProfilo());

		//SM_9996
		dto.setContrattoFwaDecommissioning(source.getModificaContrattoInput().getContrattoFwaDecommissioning());
		dto.setContrattoFwaInfratel(source.getModificaContrattoInput().getContrattoFwaInfratel());
		dto.setContrattoFwaPlus(source.getModificaContrattoInput().getContrattoFwaPlus());
		dto.setDataInizioValiditaContratto(source.getModificaContrattoInput().getDataInizioValiditaContratto());    	

		//RU_1164
		dto.setDataInizioCoinvestimento(source.getModificaContrattoInput().getDataInizioCoinvestimento());
		dto.setDataFineCoinvestimento(source.getModificaContrattoInput().getDataFineCoinvestimento());

		//RU_1180
		dto.setBouquet(source.getModificaContrattoInput().getBouquet());

		//SM_10433
		dto.setFlagMulticast(source.getModificaContrattoInput().getFlagMulticast());
		
		//SM_10486
		dto.setDatiSospensioneServizio(this.convertDatiSospensioneServizioToDTO(source.getModificaContrattoInput().getDatiSospensioneServizio()));
		
		//SM_11396
		dto.setEmailOffertaFwa1GigaSardegna(source.getModificaContrattoInput().getEmailOffertaFwa1GigaSardegna());

		destination.setModificaContrattoInput(dto);

		return destination;
	}

	@Override
	public ModificaContrattoInputBean convertTo(ModificaContrattoInputDTO source, ModificaContrattoInputBean destinationBean) {
		if (source == null) {
			return null;
		}

		ModificaContrattoInputBean destination = new ModificaContrattoInputBean();
		ModificaContrattoItemInputBean bean = new ModificaContrattoItemInputBean();

		bean.setDataFineAssociazioneOffertaContratto(source.getModificaContrattoInput().getDataFineAssociazioneOffertaContratto());
		bean.setDataFineValiditaContratto(source.getModificaContrattoInput().getDataFineValiditaContratto());
		bean.setFlagAbilitato(source.getModificaContrattoInput().getFlagAbilitato());
		bean.setFlagFileNotify(source.getModificaContrattoInput().getFlagFileNotify());
		bean.setFlagValido(source.getModificaContrattoInput().getFlagValido());
		bean.setIdContratto(source.getModificaContrattoInput().getIdContratto());
		bean.setIdContrattoOffertaCatalogo(source.getModificaContrattoInput().getIdContrattoOffertaCatalogo());
		bean.setOperatore(source.getModificaContrattoInput().getOperatore());
		bean.setTipoProfilo(source.getModificaContrattoInput().getTipoProfilo());

		//SM_9996
		bean.setContrattoFwaDecommissioning(source.getModificaContrattoInput().getContrattoFwaDecommissioning());
		bean.setContrattoFwaInfratel(source.getModificaContrattoInput().getContrattoFwaInfratel());
		bean.setContrattoFwaPlus(source.getModificaContrattoInput().getContrattoFwaPlus());
		bean.setDataInizioValiditaContratto(source.getModificaContrattoInput().getDataInizioValiditaContratto());

		//RU_1164
		bean.setDataInizioCoinvestimento(source.getModificaContrattoInput().getDataInizioCoinvestimento());
		bean.setDataFineCoinvestimento(source.getModificaContrattoInput().getDataFineCoinvestimento());

		//RU_1180
		bean.setBouquet(source.getModificaContrattoInput().getBouquet());

		//SM_10433
		bean.setFlagMulticast(source.getModificaContrattoInput().getFlagMulticast());
		
		//SM_10486
		bean.setDatiSospensioneServizio(this.convertDatiSospensioneServizioToBean(source.getModificaContrattoInput().getDatiSospensioneServizio()));
		
		//SM_11396
		bean.setEmailOffertaFwa1GigaSardegna(source.getModificaContrattoInput().getEmailOffertaFwa1GigaSardegna());

		destination.setModificaContrattoInput(bean);

		return destination;
	}
	
	private DatiSospensioneServizioInputDTO convertDatiSospensioneServizioToDTO(DatiSospensioneServizioInputBean b) {
		DatiSospensioneServizioInputDTO dto = null;
		if(b != null) {
			dto = new DatiSospensioneServizioInputDTO();
			dto.setDataInizioDisabil(b.getDataInizioDisabil());
			dto.setDataFineDisabil(b.getDataFineDisabil());
			dto.setFlagDisabil(b.getFlagDisabil());
		}
		return dto;		
	}
	
	private DatiSospensioneServizioInputBean convertDatiSospensioneServizioToBean(DatiSospensioneServizioInputDTO dto) {
		DatiSospensioneServizioInputBean bean = null;
		if(dto != null) {
			bean = new DatiSospensioneServizioInputBean();
			bean.setDataInizioDisabil(dto.getDataInizioDisabil());
			bean.setDataFineDisabil(dto.getDataFineDisabil());
			bean.setFlagDisabil(dto.getFlagDisabil());
		}
		return bean;		
	}
}
