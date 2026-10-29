package com.nttdata.tim.now.core.converter.ordine;

import com.nttdata.tim.now.data.bean.cliente.ClienteFinaleBean;
import com.nttdata.tim.now.data.bean.ordine.dettaglio.AttributoDettaglioOrdineBean;
import com.nttdata.tim.now.data.bean.ordine.dettaglio.CambioTecnologiaBean;
import com.nttdata.tim.now.data.bean.ordine.dettaglio.CodiceOrdineTiBean;
import com.nttdata.tim.now.data.bean.ordine.dettaglio.DettagliDettaglioOrdineBean;
import com.nttdata.tim.now.data.bean.ordine.dettaglio.DettaglioOrdineOutputBean;
import com.nttdata.tim.now.data.bean.ordine.dettaglio.RichiestaOutputBean;
import com.nttdata.tim.now.data.bean.ordine.dettaglio.ServizioBean;
import com.nttdata.tim.now.data.bean.referente.ReferenteBean;
import com.nttdata.tim.now.data.dto.cliente.ClienteFinaleDTO;
import com.nttdata.tim.now.data.dto.ordine.code.CodiceOrdineTiDTO;
import com.nttdata.tim.now.data.dto.ordine.dettaglio.AttributoDettaglioOrdineDTO;
import com.nttdata.tim.now.data.dto.ordine.dettaglio.CambioTecnologiaDTO;
import com.nttdata.tim.now.data.dto.ordine.dettaglio.DettagliDettaglioOrdineDTO;
import com.nttdata.tim.now.data.dto.ordine.dettaglio.DettaglioOrdineOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.dettaglio.RichiestaOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.dettaglio.ServizioDTO;
import com.nttdata.tim.now.data.dto.referente.ReferenteDTO;
import com.nttdata.tim.now.util.FlagHelper;
import com.nttdata.tim.now.util.data.DozerHelper;
import com.nttdata.tim.now.util.date.DateHelper;

import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

public class DettaglioOrdineConverter extends DozerConverter<DettaglioOrdineOutputDTO, DettaglioOrdineOutputBean>
		implements MapperAware {

	private DozerHelper mapper;

	public DettaglioOrdineConverter() {
		super(DettaglioOrdineOutputDTO.class, DettaglioOrdineOutputBean.class);
	}

	@Override
	public void setMapper(Mapper mapper) {
		DozerHelper dozerHelper = new DozerHelper();
		dozerHelper.setMapper(mapper);
		this.mapper = dozerHelper;
	}

	@Override
	public DettaglioOrdineOutputDTO convertFrom(DettaglioOrdineOutputBean source,
			DettaglioOrdineOutputDTO destinationDTO) {
		if (source == null) {
			return null;
		}

		DettaglioOrdineOutputDTO destination = new DettaglioOrdineOutputDTO();
		destination.setCanaleRichiesta(source.getCanaleRichiesta());
		destination.setCausaleOao(source.getCausaleOao());
		destination.setCodiceCausaleNow(source.getCodiceCausaleNow());
		destination.setCodiceCausaleOao(source.getCodiceCausaleOao());
		destination.setCodiceOloNow(source.getCodiceOloNow());
		destination.setCodiceOrdineOLO(source.getCodiceOrdineOLO());
		destination.setCodiceOrdineOloPadre(source.getCodiceOrdineOloPadre());
		destination.setCodiceOrdineOloTarget(source.getCodiceOrdineOloTarget());
		destination.setCodiceOrdineTI(source.getCodiceOrdineTI());
		destination.setCodiceProgetto(source.getCodiceProgetto());
		destination.setCodificaOloAgcom(source.getCodificaOloAgcom());
		destination.setDescrizioneCausaleNow(source.getDescrizioneCausaleNow());
		destination.setIdrichiestaolo(source.getIdrichiestaolo());
		destination.setIdRisorsa(source.getIdRisorsa());
		destination.setLavorazioneRichiesta(source.getLavorazioneRichiesta());
		destination.setNote(source.getNote());
		destination.setOao(source.getOao());
		destination.setStatoRichiestaNow(source.getStatoRichiestaNow());
		destination.setStatoRichiestaOlo(source.getStatoRichiestaOlo());
		destination.setTestMode(source.getTestMode());
		destination.setTipoRichiesta(source.getTipoRichiesta());
		destination.setOaoDonating(source.getOaoDonating());
		destination.setOaoDonor(source.getOaoDonor());
		destination.setRichiestaXml(source.getRichiestaXml());
		destination.setTimestampAggiornamento(DateHelper.convertFromFE(source.getTimestampAggiornamento()));
		destination.setTimestampInserimento(DateHelper.convertFromFE(source.getTimestampInserimento()));
		destination.setDac(DateHelper.convertFromFE(source.getDac()));
		destination.setDes(DateHelper.convertFromFE(source.getDes()));
		destination.setDescrizioneScenario(source.getDescrizioneScenario());// RU_749
		destination.setDataInvioRichiesta(DateHelper.convertFromFE(source.getDataInvioRichiesta()));
		destination.setDro(DateHelper.convertFromFE(source.getDro()));
		destination.setFlagNaked(FlagHelper.convertFromFE(source.isFlagNaked()));
		destination.setClienteFinale(mapper.translate(source.getCliente(), ClienteFinaleDTO.class));
		destination.setOrderDetails(mapper.translate(source.getOrderDetails(), DettagliDettaglioOrdineDTO.class));
		destination.setReferenti(mapper.translateList(source.getReferenti(), ReferenteDTO.class));
		destination.setServizi(mapper.translateList(source.getServizi(), ServizioDTO.class));
		destination.setOrderCodeTi(mapper.translateList(source.getOrderCodeTi(), CodiceOrdineTiDTO.class));
		destination.setAttributes(mapper.translateList(source.getAttributes(), AttributoDettaglioOrdineDTO.class));
		destination.setRichiesta(mapper.translate(source.getRichiesta(), RichiestaOutputDTO.class));
		destination.setIdOfferta(source.getIdOfferta());
		destination.setNumeroTelefonicoAggiuntivo(source.getNumeroTelefonicoAggiuntivo());// RU_752
		destination.setCambioTecnologia(mapper.translateList(source.getCambioTecnologia(), CambioTecnologiaDTO.class));// RU_918
		destination.setIdRisorsaNow(source.getIdRisorsaNow());// SM_8952
		destination.setDisaggregato(source.getDisaggregato());// SM_9277
		destination.setExDisaggregato(source.getExDisaggregato());// SM_9277

		// R1E-21-0325
		destination.setOrdineAssetWhiteList(source.getOrdineAssetWhiteList());

		// SM_10493
		destination.setRefOaoProgettiSpeciali(source.getRefOaoProgettiSpeciali());
		// SM_11433
		destination.setNoteOF(source.getNoteOF());
		destination.setIdRisorsaOF(source.getIdRisorsaOF());
		destination.setCodiceOrdineOF(source.getCodiceOrdineOF());
		destination.setStatoOF(source.getStatoOF());
		destination.setFlagAbilitazioneGuiManualOF(source.getFlagAbilitazioneGuiManualOF());

		// SM_11536
		destination.setCaratterizzazioneArea(source.getCaratterizzazioneArea());

		return destination;
	}

	@Override
	public DettaglioOrdineOutputBean convertTo(DettaglioOrdineOutputDTO source,
			DettaglioOrdineOutputBean destinationBean) {
		if (source == null) {
			return null;
		}

		DettaglioOrdineOutputBean destination = new DettaglioOrdineOutputBean();
		destination.setCanaleRichiesta(source.getCanaleRichiesta());
		destination.setCausaleOao(source.getCausaleOao());
		destination.setCodiceCausaleNow(source.getCodiceCausaleNow());
		destination.setCodiceCausaleOao(source.getCodiceCausaleOao());
		destination.setCodiceOloNow(source.getCodiceOloNow());
		destination.setCodiceOrdineOLO(source.getCodiceOrdineOLO());
		destination.setCodiceOrdineOloPadre(source.getCodiceOrdineOloPadre());
		destination.setCodiceOrdineOloTarget(source.getCodiceOrdineOloTarget());
		destination.setCodiceOrdineTI(source.getCodiceOrdineTI());
		destination.setCodiceProgetto(source.getCodiceProgetto());
		destination.setCodificaOloAgcom(source.getCodificaOloAgcom());
		destination.setDescrizioneCausaleNow(source.getDescrizioneCausaleNow());
		destination.setIdrichiestaolo(source.getIdrichiestaolo());
		destination.setIdRisorsa(source.getIdRisorsa());
		destination.setLavorazioneRichiesta(source.getLavorazioneRichiesta());
		destination.setNote(source.getNote());
		destination.setOao(source.getOao());
		destination.setStatoRichiestaNow(source.getStatoRichiestaNow());
		destination.setStatoRichiestaOlo(source.getStatoRichiestaOlo());
		destination.setTestMode(source.getTestMode());
		destination.setTipoRichiesta(source.getTipoRichiesta());
		destination.setOaoDonating(source.getOaoDonating());
		destination.setOaoDonor(source.getOaoDonor());
		destination.setRichiestaXml(source.getRichiestaXml());
		destination.setTimestampAggiornamento(DateHelper.convertFromBELong(source.getTimestampAggiornamento()));
		destination.setTimestampInserimento(DateHelper.convertFromBE(source.getTimestampInserimento()));
		destination.setDac(DateHelper.convertFromBE(source.getDac()));
		destination.setDes(DateHelper.convertFromBE(source.getDes()));
		destination.setDescrizioneScenario(source.getDescrizioneScenario());// RU_749
		destination.setDataInvioRichiesta(DateHelper.convertFromBE(source.getDataInvioRichiesta()));
		destination.setDro(DateHelper.convertFromBE(source.getDro()));
		destination.setFlagNaked(FlagHelper.convertFromBE(source.getFlagNaked()));
		destination.setCliente(mapper.translate(source.getClienteFinale(), ClienteFinaleBean.class));
		destination.setOrderDetails(mapper.translate(source.getOrderDetails(), DettagliDettaglioOrdineBean.class));
		destination.setReferenti(mapper.translateList(source.getReferenti(), ReferenteBean.class));
		destination.setServizi(mapper.translateList(source.getServizi(), ServizioBean.class));
		destination.setOrderCodeTi(mapper.translateList(source.getOrderCodeTi(), CodiceOrdineTiBean.class));
		destination.setAttributes(mapper.translateList(source.getAttributes(), AttributoDettaglioOrdineBean.class));
		destination.setRichiesta(mapper.translate(source.getRichiesta(), RichiestaOutputBean.class));
		destination.setIdOfferta(source.getIdOfferta());
		destination.setNumeroTelefonicoAggiuntivo(source.getNumeroTelefonicoAggiuntivo());// RU_752
		destination.setCambioTecnologia(mapper.translateList(source.getCambioTecnologia(), CambioTecnologiaBean.class));// RU_918
		destination.setIdRisorsaNow(source.getIdRisorsaNow());// SM_8952
		destination.setDisaggregato(source.getDisaggregato());// SM_9277
		destination.setExDisaggregato(source.getExDisaggregato());// SM_9277

		// R1E-21-0325
		destination.setOrdineAssetWhiteList(source.getOrdineAssetWhiteList());

		// SM_10493
		destination.setRefOaoProgettiSpeciali(source.getRefOaoProgettiSpeciali());
		// SM_11433
		destination.setNoteOF(source.getNoteOF());
		destination.setIdRisorsaOF(source.getIdRisorsaOF());
		destination.setCodiceOrdineOF(source.getCodiceOrdineOF());
		destination.setStatoOF(source.getStatoOF());
		destination.setFlagAbilitazioneGuiManualOF(source.getFlagAbilitazioneGuiManualOF());

		// SM_11536
		destination.setCaratterizzazioneArea(source.getCaratterizzazioneArea());

		return destination;
	}

}
