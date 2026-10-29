package com.nttdata.tim.now.core.converter.contratto;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.tim.now.data.bean.contratto.DatiSospensioneServizioInputBean;
import com.nttdata.tim.now.data.bean.contratto.NuovoContrattoInputBean;
import com.nttdata.tim.now.data.bean.contratto.NuovoContrattoListItemBean;
import com.nttdata.tim.now.data.dto.contratto.DatiSospensioneServizioInputDTO;
import com.nttdata.tim.now.data.dto.contratto.NuovoContrattoInputDTO;
import com.nttdata.tim.now.data.dto.contratto.NuovoContrattoListItemDTO;
import com.nttdata.tim.now.util.data.DozerHelper;

import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

//RU_716
public class NuovoContrattoInputConverter extends DozerConverter<NuovoContrattoInputDTO, NuovoContrattoInputBean> implements MapperAware {

	private DozerHelper mapper;

	public NuovoContrattoInputConverter() {
		super(NuovoContrattoInputDTO.class, NuovoContrattoInputBean.class);
	}

	@Override
	public void setMapper(Mapper mapper) {
		DozerHelper dozerHelper = new DozerHelper();
		dozerHelper.setMapper(mapper);
		this.mapper = dozerHelper; 
	}

	@Override
	public NuovoContrattoInputDTO convertFrom(NuovoContrattoInputBean source, NuovoContrattoInputDTO destinationDTO) {
		if (source == null) {
			return null;
		}

		List<NuovoContrattoListItemDTO> list = new ArrayList<>();
		NuovoContrattoInputDTO destination = new NuovoContrattoInputDTO();

		List<NuovoContrattoListItemBean> listInputItemBean = source.getNuovoContratto();

		for(NuovoContrattoListItemBean b : listInputItemBean) {

			NuovoContrattoListItemDTO dto = new NuovoContrattoListItemDTO();

			dto.setCodiceContratto(b.getCodiceContratto());
			dto.setCodiceOloNumerico(b.getCodiceOloNumerico());
			dto.setCodificaOloAgcom(b.getCodificaOloAgcom());
			dto.setDataFineAssociazioneOffertaContratto(b.getDataFineAssociazioneOffertaContratto());	    		
			dto.setDataFineValiditaContratto(b.getDataFineValiditaContratto());
			dto.setDataInizioAssociazioneOffertaContratto(b.getDataInizioAssociazioneOffertaContratto());
			dto.setDataInizioValiditaContratto(b.getDataInizioValiditaContratto());
			dto.setFlagAbilitato(b.getFlagAbilitato());
			dto.setFlagFileNotify(b.getFlagFileNotify());
			dto.setFlagValido(b.getFlagValido());
			dto.setIdFamigliaOfferta(b.getIdFamigliaOfferta());
			dto.setIdOfferta(b.getIdOfferta());
			dto.setIdSottofamigliaOfferta(b.getIdSottofamigliaOfferta());
			dto.setNomeContratto(b.getNomeContratto());
			dto.setOperatore(b.getOperatore());
			dto.setTipoProfilo(b.getTipoProfilo());
			dto.setIdTipologiaContratto(b.getIdTipologiaContratto());

			//SM_9996
			dto.setContrattoFwaDecommissioning(b.getContrattoFwaDecommissioning());
			dto.setContrattoFwaInfratel(b.getContrattoFwaInfratel());
			dto.setContrattoFwaPlus(b.getContrattoFwaPlus());

			//RU_1164
			dto.setDataInizioCoinvestimento(b.getDataInizioCoinvestimento());
			dto.setDataFineCoinvestimento(b.getDataFineCoinvestimento());

			//SM_10433
			dto.setFlagMulticast(b.getFlagMulticast());
			
			//SM_10486
			dto.setDatiSospensioneServizio(this.convertDatiSospensioneServizioToDTO(b.getDatiSospensioneServizio()));
			
			//SM_11396
			dto.setEmailOffertaFwa1GigaSardegna(b.getEmailOffertaFwa1GigaSardegna());

			list.add(dto);
		}

		destination.setNuovoContratto(list);

		return destination;
	}

	@Override
	public NuovoContrattoInputBean convertTo(NuovoContrattoInputDTO source, NuovoContrattoInputBean destinationBean) {
		if (source == null) {
			return null;
		}

		List<NuovoContrattoListItemBean> list = new ArrayList<>();
		NuovoContrattoInputBean destination = new NuovoContrattoInputBean();

		List<NuovoContrattoListItemDTO> listInputItemDTO = source.getNuovoContratto();

		for(NuovoContrattoListItemDTO dto : listInputItemDTO) {

			NuovoContrattoListItemBean bean = new NuovoContrattoListItemBean();

			bean.setCodiceContratto(dto.getCodiceContratto());
			bean.setCodiceOloNumerico(dto.getCodiceOloNumerico());
			bean.setCodificaOloAgcom(dto.getCodificaOloAgcom());
			bean.setDataFineAssociazioneOffertaContratto(dto.getDataFineAssociazioneOffertaContratto());
			bean.setDataFineValiditaContratto(dto.getDataFineValiditaContratto());
			bean.setDataInizioAssociazioneOffertaContratto(dto.getDataInizioAssociazioneOffertaContratto());
			bean.setDataInizioValiditaContratto(dto.getDataInizioValiditaContratto());
			bean.setFlagAbilitato(dto.getFlagAbilitato());
			bean.setFlagFileNotify(dto.getFlagFileNotify());
			bean.setFlagValido(dto.getFlagValido());
			bean.setIdFamigliaOfferta(dto.getIdFamigliaOfferta());
			bean.setIdOfferta(dto.getIdOfferta());
			bean.setIdSottofamigliaOfferta(dto.getIdSottofamigliaOfferta());
			bean.setNomeContratto(dto.getNomeContratto());
			bean.setOperatore(dto.getOperatore());
			bean.setTipoProfilo(dto.getTipoProfilo());
			bean.setIdTipologiaContratto(dto.getIdTipologiaContratto());

			//SM_9996
			bean.setContrattoFwaDecommissioning(dto.getContrattoFwaDecommissioning());
			bean.setContrattoFwaInfratel(dto.getContrattoFwaInfratel());
			bean.setContrattoFwaPlus(dto.getContrattoFwaPlus());

			//RU_1164
			bean.setDataInizioCoinvestimento(dto.getDataInizioCoinvestimento());
			bean.setDataFineCoinvestimento(dto.getDataFineCoinvestimento());

			//SM_10433
			bean.setFlagMulticast(dto.getFlagMulticast());
			
			//SM_10486
			bean.setDatiSospensioneServizio(this.convertDatiSospensioneServizioToBean(dto.getDatiSospensioneServizio()));
			
			//SM_11396
			bean.setEmailOffertaFwa1GigaSardegna(dto.getEmailOffertaFwa1GigaSardegna());

			list.add(bean);
		}

		destination.setNuovoContratto(list);

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
