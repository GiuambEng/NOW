package com.nttdata.tim.now.core.converter.ordine;

import com.nttdata.tim.now.data.bean.ordine.dettaglio.DettagliDettaglioOrdineBean;
import com.nttdata.tim.now.data.dto.ordine.dettaglio.DettagliDettaglioOrdineDTO;
import com.nttdata.tim.now.util.FlagHelper;
import com.nttdata.tim.now.util.date.DateHelper;

import org.dozer.DozerConverter;

public class DettagliDettaglioOrdineConverter extends DozerConverter<DettagliDettaglioOrdineDTO, DettagliDettaglioOrdineBean> {

	public DettagliDettaglioOrdineConverter() {
		super(DettagliDettaglioOrdineDTO.class, DettagliDettaglioOrdineBean.class);
	}

	@Override
	public DettagliDettaglioOrdineDTO convertFrom(DettagliDettaglioOrdineBean source, DettagliDettaglioOrdineDTO destinationDTO) {
		if (source == null) {
			return null;
		}
		
		DettagliDettaglioOrdineDTO destination = new DettagliDettaglioOrdineDTO();
		destination.setCodiceCausaleNOW(source.getCodiceCausaleNOW());
		destination.setCodiceCausaleOLO(source.getCodiceCausaleOLO());
		destination.setCodiceDelivery(source.getCodiceDelivery());
		destination.setCodiceOLO(source.getCodiceOLO());
		destination.setCodiceOLOOrdinePadre(source.getCodiceOLOOrdinePadre());
		destination.setCodiceOrdineOlo(source.getCodiceOrdineOlo());
		destination.setCodiceOrdineTI(source.getCodiceOrdineTI());
		destination.setCodiceQualita(source.getCodiceQualita());
		destination.setCodiceTTM(source.getCodiceTTM());
		destination.setContratto(source.getContratto());
		destination.setDescrizioneCausaleNOW(source.getDescrizioneCausaleNOW());
		destination.setDescrizioneCausaleOLO(source.getDescrizioneCausaleOLO());
		destination.setIdentificativoCorrelazioni(source.getIdentificativoCorrelazioni());
		destination.setIdRisorsa(source.getIdRisorsa());
		destination.setModalitaFatturazione(source.getModalitaFatturazione());
		destination.setNoteDaCliente(source.getNoteDaCliente());
		destination.setNoteDaSistema(source.getNoteDaSistema());
		destination.setProgetto(source.getProgetto());
		destination.setSottolavorazione(source.getSottolavorazione());
		destination.setStatoNOW(source.getStatoNOW());
		destination.setStatoOLO(source.getStatoOLO());
		destination.setTipoLavorazione(source.getTipoLavorazione());
		destination.setTipoPacchetto(source.getTipoPacchetto());
		destination.setTotaleOrdiniPacchetto(source.getTotaleOrdiniPacchetto());
		destination.setOfferta(source.getOfferta());
		destination.setFasciaOraria(source.getFasciaOraria());
		destination.setIdullco(source.getIdullco());
		destination.setNumeroVerdeOLOCollaudo(source.getNumeroVerdeOLOCollaudo());
		destination.setNumeroVerdeOLOPT(source.getNumeroVerdeOLOPT());
		destination.setCentrale(source.getCentrale());
		destination.setCodiceGAT(source.getCodiceGAT());
		destination.setDnOloCollaudo(source.getDnOloCollaudo());
		destination.setIdsluco(source.getIdsluco());
		destination.setRo(source.getRo());
		destination.setContenutoXml(source.getContenutoXml());
		destination.setDataChiusuraOrdine(DateHelper.convertFromFE(source.getDataChiusuraOrdine()));
		destination.setDataCreazioneOrdine(DateHelper.convertFromFE(source.getDataCreazioneOrdine()));
		destination.setDpp(DateHelper.convertFromFE(source.getDpp()));
		destination.setDuvo(DateHelper.convertFromFE(source.getDuvo()));
		destination.setDro(DateHelper.convertFromFE(source.getDro()));
		destination.setDac(DateHelper.convertFromFE(source.getDac()));
		destination.setDacRimodulata(DateHelper.convertFromFE(source.getDacRimodulata()));
		destination.setDataEspletamentoCommerciale(DateHelper.convertFromFE(source.getDataEspletamentoCommerciale()));
		destination.setDataEspletamentoTecnico(DateHelper.convertFromFE(source.getDataEspletamentoTecnico()));
		destination.setDad(DateHelper.convertFromFE(source.getDad()));
		destination.setDataInvioOrdineDelivery(DateHelper.convertFromFE(source.getDataInvioOrdineDelivery()));
		destination.setDataInvioCommercializzazione(DateHelper.convertFromFE(source.getDataInvioCommercializzazione()));
		destination.setDadRimodulata(DateHelper.convertFromFE(source.getDadRimodulata()));
		destination.setFlagLavorazioneManuale(FlagHelper.convertFromFE(source.isFlagLavorazioneManuale()));
		destination.setFlagMonitoraggio(FlagHelper.convertFromFE(source.isFlagMonitoraggio()));
		destination.setFlagPreventivo(FlagHelper.convertFromFE(source.isFlagPreventivo()));
		destination.setFlagOpereSpeciali(FlagHelper.convertFromFE(source.isFlagOpereSpeciali()));
		destination.setIdOfferta(source.getIdOfferta());
		destination.setDataPrevistaSoluzione(DateHelper.convertFromFE(source.getDataPrevistaSoluzione()));
		destination.setNomeFile(source.getNomeFile());
		destination.setInAttesaDesospensioneDaOao(source.getInAttesaDesospensioneDaOao());
		destination.setDataUltimoAppuntamento(source.getDataUltimoAppuntamento());
		destination.setOraUltimoAppuntamento(source.getOraUltimoAppuntamento());
		destination.setIdRisorsaOperatoreRete(source.getIdRisorsaOperatoreRete()); //RU_737
		//RU_628
		destination.setCodiceRisorsaDonating1(source.getCodiceRisorsaDonating1());
		destination.setCodiceRisorsaDonating2(source.getCodiceRisorsaDonating2());
		destination.setCodiceSessione1(source.getCodiceSessione1());
		destination.setCodiceSessione2(source.getCodiceSessione2());
		destination.setOpzioneDinamica(source.getOpzioneDinamica());
		destination.setRendezVous(source.getRendezVous());
		destination.setDettagliAltroOperatoreRete(source.getDettagliAltroOperatoreRete());
		
		destination.setOperatoreRete(source.getOperatoreRete());
		destination.setIntermediateAgentFull(source.getIntermediateAgentFull());
		return destination;
	}

	@Override
	public DettagliDettaglioOrdineBean convertTo(DettagliDettaglioOrdineDTO source, DettagliDettaglioOrdineBean destinationBean) {
		if (source == null) {
			return null;
		}
		
		DettagliDettaglioOrdineBean destination = new DettagliDettaglioOrdineBean();
		destination.setCodiceCausaleNOW(source.getCodiceCausaleNOW());
		destination.setCodiceCausaleOLO(source.getCodiceCausaleOLO());
		destination.setCodiceDelivery(source.getCodiceDelivery());
		destination.setCodiceOLO(source.getCodiceOLO());
		destination.setCodiceOLOOrdinePadre(source.getCodiceOLOOrdinePadre());
		destination.setCodiceOrdineOlo(source.getCodiceOrdineOlo());
		destination.setCodiceOrdineTI(source.getCodiceOrdineTI());
		destination.setCodiceQualita(source.getCodiceQualita());
		destination.setCodiceTTM(source.getCodiceTTM());
		destination.setContratto(source.getContratto());
		destination.setDescrizioneCausaleNOW(source.getDescrizioneCausaleNOW());
		destination.setDescrizioneCausaleOLO(source.getDescrizioneCausaleOLO());
		destination.setIdentificativoCorrelazioni(source.getIdentificativoCorrelazioni());
		destination.setIdRisorsa(source.getIdRisorsa());
		destination.setModalitaFatturazione(source.getModalitaFatturazione());
		destination.setNoteDaCliente(source.getNoteDaCliente());
		destination.setNoteDaSistema(source.getNoteDaSistema());
		destination.setProgetto(source.getProgetto());
		destination.setSottolavorazione(source.getSottolavorazione());
		destination.setStatoNOW(source.getStatoNOW());
		destination.setStatoOLO(source.getStatoOLO());
		destination.setTipoLavorazione(source.getTipoLavorazione());
		destination.setTipoPacchetto(source.getTipoPacchetto());
		destination.setTotaleOrdiniPacchetto(source.getTotaleOrdiniPacchetto());
		destination.setOfferta(source.getOfferta());
		destination.setFasciaOraria(source.getFasciaOraria());
		destination.setIdullco(source.getIdullco());
		destination.setNumeroVerdeOLOCollaudo(source.getNumeroVerdeOLOCollaudo());
		destination.setNumeroVerdeOLOPT(source.getNumeroVerdeOLOPT());
		destination.setCentrale(source.getCentrale());
		destination.setCodiceGAT(source.getCodiceGAT());
		destination.setDnOloCollaudo(source.getDnOloCollaudo());
		destination.setIdsluco(source.getIdsluco());
		destination.setRo(source.getRo());
		destination.setContenutoXml(source.getContenutoXml());
		destination.setDataChiusuraOrdine(DateHelper.convertFromBE(source.getDataChiusuraOrdine()));
		destination.setDataCreazioneOrdine(DateHelper.convertFromBE(source.getDataCreazioneOrdine()));
		destination.setDpp(DateHelper.convertFromBE(source.getDpp()));
		destination.setDuvo(DateHelper.convertFromBE(source.getDuvo()));
		destination.setDro(DateHelper.convertFromBE(source.getDro()));
		destination.setDac(DateHelper.convertFromBE(source.getDac()));
		destination.setDacRimodulata(DateHelper.convertFromBE(source.getDacRimodulata()));
		destination.setDataEspletamentoCommerciale(DateHelper.convertFromBE(source.getDataEspletamentoCommerciale()));
		destination.setDataEspletamentoTecnico(DateHelper.convertFromBE(source.getDataEspletamentoTecnico()));
		destination.setDad(DateHelper.convertFromBE(source.getDad()));
		destination.setDataInvioOrdineDelivery(DateHelper.convertFromBE(source.getDataInvioOrdineDelivery()));
		destination.setDataInvioCommercializzazione(DateHelper.convertFromBE(source.getDataInvioCommercializzazione()));
		destination.setDadRimodulata(DateHelper.convertFromBE(source.getDadRimodulata()));
		destination.setFlagLavorazioneManuale(FlagHelper.convertFromBE(source.getFlagLavorazioneManuale()));
		destination.setFlagMonitoraggio(FlagHelper.convertFromBE(source.getFlagMonitoraggio()));
		destination.setFlagPreventivo(FlagHelper.convertFromBE(source.getFlagPreventivo()));
		destination.setFlagOpereSpeciali(FlagHelper.convertFromBE(source.getFlagOpereSpeciali()));
		destination.setIdOfferta(source.getIdOfferta());
		destination.setDataPrevistaSoluzione(DateHelper.convertFromBE(source.getDataPrevistaSoluzione()));
		destination.setNomeFile(source.getNomeFile());
		destination.setInAttesaDesospensioneDaOao(source.getInAttesaDesospensioneDaOao());
		destination.setDataUltimoAppuntamento(source.getDataUltimoAppuntamento());
		destination.setOraUltimoAppuntamento(source.getOraUltimoAppuntamento());
		destination.setIdRisorsaOperatoreRete(source.getIdRisorsaOperatoreRete()); //RU_737
		//RU_628
		destination.setCodiceRisorsaDonating1(source.getCodiceRisorsaDonating1());
		destination.setCodiceRisorsaDonating2(source.getCodiceRisorsaDonating2());
		destination.setCodiceSessione1(source.getCodiceSessione1());
		destination.setCodiceSessione2(source.getCodiceSessione2());
		destination.setOpzioneDinamica(source.getOpzioneDinamica());
		//RU_817-/RU_823
		destination.setRendezVous(source.getRendezVous());
		destination.setDettagliAltroOperatoreRete(source.getDettagliAltroOperatoreRete());	
		
		destination.setOperatoreRete(source.getOperatoreRete());
		destination.setIntermediateAgentFull(source.getIntermediateAgentFull());
		
		return destination;
	}

}
