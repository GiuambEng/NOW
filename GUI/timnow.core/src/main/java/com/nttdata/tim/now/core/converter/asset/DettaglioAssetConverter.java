package com.nttdata.tim.now.core.converter.asset;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.tim.now.data.bean.asset.DatiMulticastOutputBean;
import com.nttdata.tim.now.data.bean.asset.DettaglioAssetOutputBean;
import com.nttdata.tim.now.data.bean.asset.ServizioAssetBean;
import com.nttdata.tim.now.data.dto.asset.DatiMulticastOutputDTO;
import com.nttdata.tim.now.data.dto.asset.DettaglioAssetOutputDTO;
import com.nttdata.tim.now.data.dto.asset.ServizioAssetDTO;
import com.nttdata.tim.now.util.FlagHelper;
import com.nttdata.tim.now.util.data.DozerHelper;
import com.nttdata.tim.now.util.date.DateHelper;

import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

public class DettaglioAssetConverter extends DozerConverter<DettaglioAssetOutputDTO, DettaglioAssetOutputBean>
		implements MapperAware {

	private DozerHelper mapper;

	public DettaglioAssetConverter() {
		super(DettaglioAssetOutputDTO.class, DettaglioAssetOutputBean.class);
	}

	@Override
	public void setMapper(Mapper mapper) {
		DozerHelper dozerHelper = new DozerHelper();
		dozerHelper.setMapper(mapper);
		this.mapper = dozerHelper;
	}

	@Override
	public DettaglioAssetOutputDTO convertFrom(DettaglioAssetOutputBean source,
			DettaglioAssetOutputDTO destinationDTO) {
		if (source == null) {
			return null;
		}
		DettaglioAssetOutputDTO destination = new DettaglioAssetOutputDTO();
		destination.setCap(source.getCap());
		destination.setCaratteristicaNP(source.getCaratteristicaNP() ? "Y" : "N");
		destination.setCentrale(source.getCentrale());
		destination.setCf(source.getCf());
		destination.setCodcontratto(source.getCodcontratto());
		destination.setCodiceOrdineOaoPrimoOrdine(source.getCodiceOrdineOaoPrimoOrdine());
//        destination.setCodiceProgetto(source.getCodiceProgetto()); SM_8255
		destination.setCodicetoponomastica(source.getCodicetoponomastica());
		destination.setCodIstatComune(source.getCodIstatComune());
		destination.setCodOAOAgcom(source.getCodOAOAgcom());
		destination.setCodSlaAssurance(source.getCodSlaAssurance());
		destination.setCognomeRagSociale(source.getCognomeRagSociale());
		destination.setComplesso(source.getComplesso());
		destination.setComune(source.getComune());
		destination.setDec(DateHelper.convertFromFE(source.getDec()));
		destination.setDes(DateHelper.convertFromFE(source.getDes()));
		destination.setDescParticellaToponomastica(source.getDescParticellaToponomastica());
		destination.setDesPrimoOrdine(DateHelper.convertFromFE(source.getDesPrimoOrdine()));
		destination.setDettaglioAsset(source.getDettaglioAsset());
		destination.setIdAsset(source.getIdAsset());
		destination.setIdAssetCRMWS(source.getIdAssetCRMWS());
		destination.setIdentificativoAssetDa(source.getIdentificativoAssetDa());
		destination.setIdentificativoContratto(source.getIdentificativoContratto());
		destination.setIdOfferta(source.getIdOfferta());
		destination.setIdRisorsa(source.getIdRisorsa());
		destination.setIdRisorsaNow(source.getIdRisorsaNow());
		destination.setInterno(source.getInterno());
//        destination.setInvariante(source.getInvariante()); RU_628
//        destination.setIsLimitedList(s);
		destination.setLineariferimento(source.getLineariferimento());
		destination.setLnaLa(source.getLnaLa());
		destination.setLocalita(source.getLocalita());
		destination.setModalitaFatturazione(source.getModalitaFatturazione());
		destination.setNome(source.getNome());
		destination.setNomecontratto(source.getNomecontratto());
		destination.setNomeOffertaCatalogo(source.getNomeOffertaCatalogo());
		destination.setNumero(source.getNumero());
		destination.setNumeroFittizio(source.getNumeroFittizio());
		destination.setNumeroTelefonica(source.getNumeroTelefonica());
		destination.setOaoDonating(source.getOaoDonating());
		destination.setOaoDonor(source.getOaoDonor());
		destination.setOperatore(source.getOperatore());
		destination.setOraDes(source.getOraDes());
		destination.setPiano(source.getPiano());
		destination.setPiva(source.getPiva());
		destination.setPrimoOrdineTi(source.getPrimoOrdineTi());
		destination.setProvincia(source.getProvincia());
		destination.setRo(source.getRo());
		destination.setScala(source.getScala());
		destination.setServizi(getListServiziDTO(source.getServizi()));
		destination.setStatoAsset(source.getStatoAsset());
		destination.setTimeInserimentoAsset(DateHelper.convertFromFE(source.getTimeInserimentoAsset()));
		destination.setTimeStampAggiornamentoAsset(DateHelper.convertFromFE(source.getTimeStampAggiornamentoAsset()));
		destination.setTipoServizio(source.getTipoServizio());
		destination.setVia(source.getVia());
		destination.setOpzioneDinamica(source.getOpzioneDinamica());
		destination.setStatoServizioDinamico(source.getStatoServizioDinamico());
		destination.setStatoContratto(source.getStatoContratto());

		// RU_628
		destination.setOrdineOao(source.getOrdineOao());
		destination.setOrdineTI(source.getOrdineTI());
		destination.setIdRisorsaOperatoreRete(source.getIdRisorsaOperatoreRete());
		// SM_9839
		destination.setOperatoreRete(source.getOperatoreRete());

		// RU_1180
		if (source.getDatiMulticast() != null) {
			destination.setDatiMulticast(getListDatiMulticastDTO(source.getDatiMulticast()));
		}

		// SM_10116
		destination.setWhiteList(source.getWhiteList());

		// SM_10278
		destination.setStatoDisabilitazioneAsset(source.getStatoDisabilitazioneAsset());

		// SM_11536
		destination.setCaratterizzazioneArea(source.getCaratterizzazioneArea());
		
		destination.setOntOperatore(source.getOntOperatore());
		
		destination.setModelloServizioPerValidazioni(source.getModelloServizioPerValidazioni());
		destination.setCodiceOperatoreSecondario(source.getCodiceOperatoreSecondario());
		destination.setDescrizioneOperatoreSecondario(source.getDescrizioneOperatoreSecondario());
		
		return new DettaglioAssetOutputDTO();
	}

	@Override
	public DettaglioAssetOutputBean convertTo(DettaglioAssetOutputDTO source,
			DettaglioAssetOutputBean destinationBean) {
		if (source == null) {
			return null;
		}

		DettaglioAssetOutputBean destination = new DettaglioAssetOutputBean();
		destination.setCap(source.getCap());
		destination.setCaratteristicaNP(FlagHelper.convertFromBE(source.getCaratteristicaNP()));
		destination.setCentrale(source.getCentrale());
		destination.setCf(source.getCf());
		destination.setCodcontratto(source.getCodcontratto());
		destination.setCodiceOrdineOaoPrimoOrdine(source.getCodiceOrdineOaoPrimoOrdine());
//        destination.setCodiceProgetto(source.getCodiceProgetto()); SM_8255
		destination.setCodicetoponomastica(source.getCodicetoponomastica());
		destination.setCodIstatComune(source.getCodIstatComune());
		destination.setCodOAOAgcom(source.getCodOAOAgcom());
		destination.setCodSlaAssurance(source.getCodSlaAssurance());
		destination.setCognomeRagSociale(source.getCognomeRagSociale());
		destination.setComplesso(source.getComplesso());
		destination.setComune(source.getComune());
		destination.setDec(DateHelper.convertFromBE(source.getDec()));
		destination.setDes(DateHelper.convertFromBE(source.getDes()));
		destination.setDescParticellaToponomastica(source.getDescParticellaToponomastica());
		destination.setDesPrimoOrdine(DateHelper.convertFromBE(source.getDesPrimoOrdine()));
		destination.setDettaglioAsset(source.getDettaglioAsset());
		destination.setIdAsset(source.getIdAsset());
		destination.setIdAssetCRMWS(source.getIdAssetCRMWS());
		destination.setIdentificativoAssetDa(source.getIdentificativoAssetDa());
		destination.setIdentificativoContratto(source.getIdentificativoContratto());
		destination.setIdOfferta(source.getIdOfferta());
		destination.setIdRisorsa(source.getIdRisorsa());
		destination.setIdRisorsaNow(source.getIdRisorsaNow());
		destination.setInterno(source.getInterno());
//        destination.setInvariante(source.getInvariante()); RU_628
//        destination.setIsLimitedList(s);
		destination.setLineariferimento(source.getLineariferimento());
		destination.setLnaLa(source.getLnaLa());
		destination.setLocalita(source.getLocalita());
		destination.setModalitaFatturazione(source.getModalitaFatturazione());
		destination.setNome(source.getNome());
		destination.setNomecontratto(source.getNomecontratto());
		destination.setNomeOffertaCatalogo(source.getNomeOffertaCatalogo());
		destination.setNumero(source.getNumero());
		destination.setNumeroFittizio(source.getNumeroFittizio());
		destination.setNumeroTelefonica(source.getNumeroTelefonica());
		destination.setOaoDonating(source.getOaoDonating());
		destination.setOaoDonor(source.getOaoDonor());
		destination.setOperatore(source.getOperatore());
		destination.setOraDes(source.getOraDes());
		destination.setPiano(source.getPiano());
		destination.setPiva(source.getPiva());
		destination.setPrimoOrdineTi(source.getPrimoOrdineTi());
		destination.setProvincia(source.getProvincia());
		destination.setRo(source.getRo());
		destination.setScala(source.getScala());
		destination.setServizi(getListServiziBean(source.getServizi()));
		destination.setStatoAsset(source.getStatoAsset());
		destination.setTimeInserimentoAsset(DateHelper.convertFromBE(source.getTimeInserimentoAsset()));
		destination.setTimeStampAggiornamentoAsset(DateHelper.convertFromBE(source.getTimeStampAggiornamentoAsset()));
		destination.setTipoServizio(source.getTipoServizio());
		destination.setVia(source.getVia());
		destination.setOpzioneDinamica(source.getOpzioneDinamica());
		destination.setStatoServizioDinamico(source.getStatoServizioDinamico());
		destination.setStatoContratto(source.getStatoContratto());

		destination.setOperatoreRete(source.getOperatoreRete());

		// RU_628
		destination.setOrdineOao(source.getOrdineOao());
		destination.setOrdineTI(source.getOrdineTI());
		destination.setIdRisorsaOperatoreRete(source.getIdRisorsaOperatoreRete());

		// RU_1180
		if (source.getDatiMulticast() != null) {
			destination.setDatiMulticast(getListDatiMulticastBean(source.getDatiMulticast()));
		}

		// SM_10116
		destination.setWhiteList(source.getWhiteList());

		// SM_10278
		destination.setStatoDisabilitazioneAsset(source.getStatoDisabilitazioneAsset());

		// SM_11536
		destination.setCaratterizzazioneArea(source.getCaratterizzazioneArea());
		
		destination.setOntOperatore(source.getOntOperatore());
		
		destination.setModelloServizioPerValidazioni(source.getModelloServizioPerValidazioni());
		destination.setCodiceOperatoreSecondario(source.getCodiceOperatoreSecondario());
		destination.setDescrizioneOperatoreSecondario(source.getDescrizioneOperatoreSecondario());

		return destination;
	}

	private List<ServizioAssetBean> getListServiziBean(List<ServizioAssetDTO> dto) {
		List<ServizioAssetBean> beanList = new ArrayList<>();
		if (dto != null && !dto.isEmpty()) {
			for (int i = 0; i < dto.size(); i++) {
				ServizioAssetBean beanInfo = mapper.translate(dto.get(i), ServizioAssetBean.class);
				beanList.add(beanInfo);
			}
		}
		return beanList;
	}

	private List<ServizioAssetDTO> getListServiziDTO(List<ServizioAssetBean> bean) {
		List<ServizioAssetDTO> dtoList = new ArrayList<>();
		if (bean != null && !bean.isEmpty()) {
			for (int i = 0; i < bean.size(); i++) {
				ServizioAssetDTO dtoInfo = mapper.translate(bean.get(i), ServizioAssetDTO.class);
				dtoList.add(dtoInfo);
			}
		}
		return dtoList;
	}

	// RU_1180
	private List<DatiMulticastOutputDTO> getListDatiMulticastDTO(List<DatiMulticastOutputBean> bean) {
		List<DatiMulticastOutputDTO> dtoList = new ArrayList<>();
		if (bean != null && !bean.isEmpty()) {
			for (int i = 0; i < bean.size(); i++) {
				DatiMulticastOutputDTO dtoInfo = mapper.translate(bean.get(i), DatiMulticastOutputDTO.class);
				dtoList.add(dtoInfo);
			}
		}
		return dtoList;
	}

	private List<DatiMulticastOutputBean> getListDatiMulticastBean(List<DatiMulticastOutputDTO> list) {
		List<DatiMulticastOutputBean> beanList = new ArrayList<>();
		if (list != null && !list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				DatiMulticastOutputBean beanInfo = mapper.translate(list.get(i), DatiMulticastOutputBean.class);
				beanList.add(beanInfo);
			}
		}
		return beanList;
	}
}
