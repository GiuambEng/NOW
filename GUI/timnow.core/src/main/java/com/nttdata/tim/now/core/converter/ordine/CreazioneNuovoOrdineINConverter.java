package com.nttdata.tim.now.core.converter.ordine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.nttdata.tim.now.data.bean.ordine.ClliFeederSuccessivoInputBean;
import com.nttdata.tim.now.data.bean.ordine.CreazioneNuovoOrdineInputBean;
import com.nttdata.tim.now.data.bean.ordine.DatiClienteFinaleInputBean;
import com.nttdata.tim.now.data.bean.ordine.DatiDisaggregazioneInputBean;
import com.nttdata.tim.now.data.bean.ordine.DatiGestioneAutonomaInputBean;
import com.nttdata.tim.now.data.bean.ordine.DatiOfferteMulticastInputBean;
import com.nttdata.tim.now.data.bean.ordine.DatiPresaAppuntamentoInputBean;
import com.nttdata.tim.now.data.bean.ordine.DatiPrestazioniAggiuntiveInputBean;
import com.nttdata.tim.now.data.bean.ordine.DatiReferentiInputBean;
import com.nttdata.tim.now.data.bean.ordine.DatiServiziOpzionaliAlternativiInputBean;
import com.nttdata.tim.now.data.bean.ordine.DatiServiziOpzionaliInputBean;
import com.nttdata.tim.now.data.bean.ordine.DatiSlaPlusSuInputBean;
import com.nttdata.tim.now.data.bean.ordine.DettaglioOffertaOrdineBean;
import com.nttdata.tim.now.data.bean.ordine.IndirizzoDatiClienteFinaleInputBean;
import com.nttdata.tim.now.data.bean.ordine.fiberstream.ApparatoFiberstreamInputBean;
import com.nttdata.tim.now.data.bean.ordine.fiberstream.DatiServiziAggiuntiviInputBean;
import com.nttdata.tim.now.data.dto.ordine.AttributiOffertaInputDTO;
import com.nttdata.tim.now.data.dto.ordine.ClliFeederSuccessivoInputDTO;
import com.nttdata.tim.now.data.dto.ordine.CreazioneNuovoOrdineInputDTO;
import com.nttdata.tim.now.data.dto.ordine.DatiClienteFinaleInputDTO;
import com.nttdata.tim.now.data.dto.ordine.DatiDisaggregazioneInputDTO;
import com.nttdata.tim.now.data.dto.ordine.DatiGestioneAutonomaInputDTO;
import com.nttdata.tim.now.data.dto.ordine.DatiOfferteMulticastInputDTO;
import com.nttdata.tim.now.data.dto.ordine.DatiPresaAppuntamentoInputDTO;
import com.nttdata.tim.now.data.dto.ordine.DatiPrestazioniAggiuntiveInputDTO;
import com.nttdata.tim.now.data.dto.ordine.DatiReferentiInputDTO;
import com.nttdata.tim.now.data.dto.ordine.DatiReferentiOnFieldInputDTO;
import com.nttdata.tim.now.data.dto.ordine.DatiServiziOpzionaliAlternativiInputDTO;
import com.nttdata.tim.now.data.dto.ordine.DatiServiziOpzionaliInputDTO;
import com.nttdata.tim.now.data.dto.ordine.DatiSlaPlusSuInputDTO;
import com.nttdata.tim.now.data.dto.ordine.IndirizzoDatiClienteFinaleInputDTO;
import com.nttdata.tim.now.data.dto.ordine.SezioneOffertaInputDTO;
import com.nttdata.tim.now.data.dto.ordine.fiberstream.ApparatoFiberstreamInputDTO;
import com.nttdata.tim.now.data.dto.ordine.fiberstream.DatiServiziAggiuntiviInputDTO;
import com.nttdata.tim.now.data.enumeration.TipoOfferta;
import com.nttdata.tim.now.util.FlagHelper;
import com.nttdata.tim.now.util.data.DozerHelper;
import com.nttdata.tim.now.util.date.DateHelper;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

public class CreazioneNuovoOrdineINConverter extends DozerConverter<CreazioneNuovoOrdineInputDTO, CreazioneNuovoOrdineInputBean> implements MapperAware {

    private DozerHelper mapper;
    
    public CreazioneNuovoOrdineINConverter() {
        super(CreazioneNuovoOrdineInputDTO.class, CreazioneNuovoOrdineInputBean.class);
    }

    

    @Override
    public void setMapper(Mapper mapper) {
        DozerHelper dozerHelper = new DozerHelper();
        dozerHelper.setMapper(mapper);
        this.mapper = dozerHelper; 
    }

    
    @Override
    public CreazioneNuovoOrdineInputDTO convertFrom(CreazioneNuovoOrdineInputBean bean, CreazioneNuovoOrdineInputDTO destinationDto) {
        CreazioneNuovoOrdineInputDTO destination = null;

        if (bean != null) {
            destination = new CreazioneNuovoOrdineInputDTO();

            destination.setIdOfferta(bean.getIdOfferta());
            
            destination.setAttributiOfferta(extractAttributiOfferta(bean));
            
            if(StringUtils.isNotEmpty(bean.getBorchiaNT1Plus())){
            	destination.setBorchiaNT1Plus(bean.getBorchiaNT1Plus());
            }
            
            destination.setCausaleOrdine(bean.getCausaleOrdine().toUpperCase());
            if(bean.getIdullco()!=null && bean.getIdullco().getNomeCentrale()!=null && StringUtils.isNotEmpty(bean.getIdullco().getNomeCentrale())){
            	destination.setCentrale(bean.getIdullco().getNomeCentrale());
            }
            
            destination.setClirPermanente(bean.getClirPermanente());
            
            destination.setCodiceDelivery(bean.getCodiceDelivery());
            
            if(bean.getIdullco()!=null && bean.getIdullco().getCodiceGat()!=null && StringUtils.isNotEmpty(bean.getIdullco().getCodiceGat())){
            	destination.setCodiceGAT(bean.getIdullco().getCodiceGat());
            }
            
            destination.setCodiceIdentificativoLotto(bean.getCodiceIdentificativoLotto());
            
            destination.setCodiceOrdine(bean.getCodiceOrdine());
            
            destination.setCodiceOrdinePadre(bean.getCodiceOrdinePadre());
            
            destination.setCodiceProgetto(bean.getCodiceProgetto());
            
            destination.setCodiceQualita(bean.getCodiceQualita());
            
            destination.setCodiceSessione1(bean.getCodiceSessione1());
            
            destination.setCodiceSessione2(bean.getCodiceSessione2());
            
            if (StringUtils.isNotEmpty(bean.getDac())) {
              destination.setDac(DateHelper.convertFromFE(bean.getDac()));
            }
            
            if (StringUtils.isNotEmpty(bean.getDad())) {
                destination.setDad(DateHelper.convertFromFE(bean.getDad()));
              }
            
            destination.setDataCreazione(DateHelper.getESBDate(new Date()));
            
            if (StringUtils.isNotEmpty(bean.getDataRicezioneRichiesta())) {
                destination.setDataRicezioneRichiesta(DateHelper.convertFromFE(bean.getDataRicezioneRichiesta()));
              }
            
            if (StringUtils.isNotEmpty(bean.getDataRichiestaColocazione())) {
                destination.setDataRichiestaColocazione(DateHelper.convertFromFE(bean.getDataRichiestaColocazione()));
              }
            
            if (StringUtils.isNotEmpty(bean.getDataSottoscrizioneContratto())) {
                destination.setDataSottoscrizioneContratto(DateHelper.convertFromFE(bean.getDataSottoscrizioneContratto()));
              }
            
            destination.setDataUltimaModifica(DateHelper.getESBDate(new Date()));
            
            destination.setDatiClienteFinale(extractAnagraficaDatiClienteFinaleDTO(bean.getDatiClienteFinale()));
            
            destination.setDatiReferenti(extractReferents(bean));
            
            destination.setDatiReferentiOnField(mapper.translate(bean.getDatiReferentiOnField(), DatiReferentiOnFieldInputDTO.class));
            
            destination.setDn(bean.getDn());
            
            destination.setDnOperatoreCollaudo(bean.getDnOperatoreCollaudo());
            
            destination.setFasciaOraria(bean.getFasciaOraria());
            
            destination.setFlagAggiuntivi(FlagHelper.convertFromFE(bean.isFlagAggiuntivi()));
            
            destination.setFlagFob(FlagHelper.convertFromFE(bean.isFlagFob()));
            
            destination.setFlagMonitoraggio(FlagHelper.convertFromFE(bean.isFlagMonitoraggio()));
            
            destination.setFlagMantenimentoSTS(FlagHelper.convertFromFE(bean.isFlagMantenimentoSTS()));
            
            destination.setFlagNp(FlagHelper.convertFromFE(bean.isFlagNp()));
            
            destination.setFlagRientroVeloce(FlagHelper.convertFromFE(bean.isFlagRientroVeloce()));
            
            destination.setFlagRientro(FlagHelper.convertFromFE(bean.isFlagRientro()));
            
            if(bean.getContratto() != null){
            	destination.setIdContratto(bean.getContratto().getIdContratto());
            }
                        
            destination.setIdContrattoOfferta(bean.getIdContrattoOfferta());
            
            destination.setIdOfferta(bean.getIdOfferta());
            
            destination.setIdRisorsa(bean.getIdRisorsa());
            
            destination.setIdRisorsa2(bean.getIdRisorsa2());
            
            destination.setIdRisorsaBTSNaked(bean.getIdRisorsaBTSNaked());
            
            if ( bean.getIdsluco()!=null && bean.getIdsluco().getIdsluco()!=null && StringUtils.isNotEmpty(bean.getIdsluco().getIdsluco())){
                destination.setIdsluco(bean.getIdsluco().getIdsluco());
            }
            destination.setIdTicketTTM(bean.getIdTicketTTM());
            
            if ( bean.getIdullco()!=null && bean.getIdullco().getIdullco()!=null && StringUtils.isNotEmpty(bean.getIdullco().getIdullco())){
                destination.setIdullco(bean.getIdullco().getIdullco());
            }
            
            //indicatore di scaffale e' boolean sul bean perche' associato a checkbox
            destination.setIndicatoreDiScaffale(FlagHelper.convertFromFE(bean.isIndicatoreDiScaffale()));
            
            destination.setIndicatoreFob(bean.getIndicatoreFob());
            
            //RU_915
            if(!bean.getOffertaCatalogo().equals(TipoOfferta.CPS.getOfferName())) {
            	destination.setIndirizzoDatiClienteFinale(extractAnagraficaIndirizzoClienteFinaleDTO(bean.getIndirizzoDatiClienteFinale()));
            }else {
            	destination.setIndirizzoDatiClienteFinale(extractAnagraficaIndirizzoClienteFinaleDTOForCPS(bean.getIndirizzoDatiClienteFinale()));
            }
                        
            destination.setMantenimentoProdotti(bean.getMantenimentoProdotti());
            
            destination.setNoteDaOperatore(bean.getNoteDaOperatore());
            
            destination.setOao(bean.getOperatore());
                        
            destination.setNumeroLinea(bean.getNumeroLinea());
            
            destination.setNumeroRichiestaColocazione(bean.getNumeroRichiestaColocazione());
            
            destination.setNumeroVerdeOperatoreCollaudo(bean.getNumeroVerdeOperatoreCollaudo());
            
            destination.setNumeroVerdeOperatorePT(bean.getNumeroVerdeOperatorePT());
            
            //da rivedere associazione codifica oao
            // sistemato al volo per tutte le offerte 
            // perche' passava il valore della codifica oao dentro il contratto e non quello della select FE
            
            destination.setOffertaCatalogo(bean.getOffertaCatalogo());
            
            destination.setOperatore(bean.getOperatore());
            
            destination.setRecapitoTelefonicoCliente(bean.getRecapitoTelefonicoCliente());
            
            destination.setRoutingNumber(bean.getRoutingNumber());
            
            destination.setStsDaAttivare(bean.getStsDaAttivare());
            
            destination.setStsDaCessare(bean.getStsDaCessare());
            
            destination.setTipologiaAccesso(bean.getTipologiaAccesso());
            
            destination.setTipoModifica(bean.getTipoModifica());
            
            destination.setTipoRientro(bean.getTipoRientro());
            
            destination.setTipoVariazione(bean.getTipoVariazione());
            
            destination.setOpzioneVariazione(bean.getOpzioneVariazione());
            
            destination.setVariazione(bean.getVariazione());
            
            destination.setFlagNumerazioniAggiuntive(bean.getFlagNumerazioniAggiuntive());
            
            destination.setAggiuntiviISDN(bean.getAggiuntiviISDN());
            
            destination.setNumerazioneAggiuntiva(bean.getNumerazioneAggiuntiva());//rimosso translate perche inseriva stringhe vuote
            
            destination.setDnAggiuntive(bean.getDnAggiuntive());
            
            destination.setFlagOrdineUnico(FlagHelper.convertFromFE(bean.isFlagOrdineUnico()));
            
            destination.setCodiceTrasloco(bean.getCodiceTrasloco());
            
            destination.setPrestazione(bean.getPrestazione());
            
            destination.setOaoDonating1(bean.getOaoDonating1());
            
            destination.setOaoDonating2(bean.getOaoDonating2());
            
            destination.setFlagModem(FlagHelper.convertFromFE(bean.isFlagModem()));
            
            destination.setDataDisponibilitaSede(DateHelper.convertFromFE(bean.getDataDisponibilitaSede()));
            
            destination.setTipoMigrazione(bean.getTipoMigrazione());
            
            destination.setIdAsset(bean.getIdAsset());
            
            destination.setOpzioneDinamica(FlagHelper.convertFromFE(bean.isOpzioneDinamica()));
            
            //RU_886
            destination.setQualifica(bean.getQualifica());
            
            destination.setTest2(bean.getTest2());
            
            //RU_915
            destination.setDataOrdine(bean.getDataOrdine());
            destination.setOpzioneTraffico(bean.getOpzioneTraffico()); 
            destination.setCodiceCarrierOlo(bean.getCodiceCarrierOlo());
            destination.setFlagReclamo(FlagHelper.convertFromFE(bean.isFlagReclamo()));
            destination.setTipoLinea(bean.getTipoLinea());
            destination.setStrutturaLinea(bean.getStrutturaLinea());
            destination.setRadicale(bean.getRadicale());
            destination.setQuantitaLinee(bean.getQuantitaLinee());
            
            //R1C-19-1212
            destination.setToken(bean.getToken());
            
            //RU_980
            destination.setDatiServiziOpzionali(extractDatiServiziOpzionali(bean.getDatiServiziOpzionali()));
            destination.setDatiDisaggregazione(extractDatiDisaggregazione(bean.getDatiDisaggregazione()));
            destination.setDatiPresaAppuntamento(extractDatiPresaAppuntamento(bean.getDatiPresaAppuntamento()));
            destination.setDatiPrestazioniAggiuntive(extractDatiPrestazioniAggiuntive(bean.getDatiPrestazioniAggiuntive()));
            destination.setDatiSlaPlusSu(extractDatiSlaPlusSu(bean.getDatiSlaPlusSu()));
            
            //RU_1393
            destination.setDatiGestioneAutonoma(extractDatiGestioneAutonoma(bean.getDatiGestioneAutonoma()));
            
            //RU_1485
            destination.setDatiServiziOpzionaliAlternativi(extractDatiServiziOpzionaliAlternativi(bean.getDatiServiziOpzionaliAlternativi()));
            
            //RU_1058
            destination.setCodiceOrdineTIVlan(bean.getCodiceOrdineTIVlan());
            destination.setCodiceOrdineOloVlan(bean.getCodiceOrdineOloVlan());
            if (StringUtils.isNotEmpty(bean.getDrc())) {
                destination.setDrc(DateHelper.convertFromFE(bean.getDrc()));
            }
            
            //RU_1150
            destination.setCoinvestimento(bean.getCoinvestimento());
            destination.setIdGpon(bean.getIdGpon());
            
            //SM_10013
            destination.setProfiloTecnicoLineaAsset(bean.getProfiloTecnicoLineaAsset());
            
            //RU_1164
            destination.setFlagOffertaSemi(bean.getFlagOffertaSemi());
            destination.setIdReteSecondariaOao(bean.getIdReteSecondariaOao());
            
            //RU_1180
            destination.setDatiOfferteMulticast(extractDatiOfferteMulticast(bean.getDatiOfferteMulticast()));
            
            //SM_10116
            destination.setWhiteList(bean.getWhiteList());
            
            //RU_1181
            destination.setStatoRestituzioneProdotti(bean.getStatoRestituzioneProdotti());
            
            //R1F-20-0236.B
            destination.setRefOaoProgettiSpeciali(bean.getRefOaoProgettiSpeciali());
            
            //RU_1462
            destination.setDataPrevistaAttivazione(DateHelper.convertFromFE(bean.getDataPrevistaAttivazione()));
            destination.setDatiServiziAggiuntivi(extractDatiServiziAggiuntivi(bean.getDatiServiziAggiuntivi()));
            
            // RU_1560
            destination.setCodOperatoreSecondario(bean.getCodOperatoreSecondario());  
            
            // RU_1598
            destination.setClusterAccesso(bean.getClusterAccesso()); 
        }

        return destination;
    }

    @Override
    public CreazioneNuovoOrdineInputBean convertTo(CreazioneNuovoOrdineInputDTO dto, CreazioneNuovoOrdineInputBean bean) {
        return null;
    }

    /*
     * La traduzione da AttributiOffertaInputBean a AttributiOffertaInputDTO
     * (contenenti 2 liste di tipo SezioneOffertaInputBean)  non puo' avvenire,
     * perche' i dati dal frontend provengono da una get al catalogo, che li esporta in oggetti di tipo
     * OffertaInputBean (contenente 2 mappe di tipo DettaglioOffertaOrdineBean).
     * Per far andare bene la traduzione, la stringa con JsonProperty("valore") dovrebbe chiamarsi valore,
     * invece e' stata sistemata in dft, a parita' di JsonProperty.
     * Tale modifica e' stata usata sia in  SezioneOffertaInputBean che in SezioneOffertaInputDTO
     * 
     * */
    private AttributiOffertaInputDTO extractAttributiOfferta(CreazioneNuovoOrdineInputBean bean) {
        AttributiOffertaInputDTO dto = null;

        if (bean != null) {
            dto = new AttributiOffertaInputDTO();

            List<SezioneOffertaInputDTO> sezioneOfferTopDetails = null;
            if (bean.getOfferDetails() != null && bean.getOfferDetails().getOfferTopDetails() != null) {

                sezioneOfferTopDetails = new ArrayList<>();
                
                for (Entry<String, DettaglioOffertaOrdineBean> key : bean.getOfferDetails().getOfferTopDetails().entrySet()) {
                     
                    SezioneOffertaInputDTO dtoFromBean = getSezioneOffertaInputDTO(key);
                    if (dtoFromBean != null) {
                        sezioneOfferTopDetails.add(dtoFromBean);
                    }
                }
            }

            dto.setSezioneSuperiore(sezioneOfferTopDetails);

            List<SezioneOffertaInputDTO> sezioneOfferBotDetails = null;
            if (bean.getOfferDetails() != null && bean.getOfferDetails().getOfferBotDetails() != null) {

                sezioneOfferBotDetails = new ArrayList<>();
                
                SezioneOffertaInputDTO dtoFromBean;
                for (DettaglioOffertaOrdineBean offer : bean.getOfferDetails().getOfferBotDetails()) {
                	
                    dtoFromBean = getSezioneOffertaInputDTO(offer);
                    if (dtoFromBean != null) {
                        sezioneOfferBotDetails.add(dtoFromBean);
                    }
                }
            }

            dto.setSezioneInferiore(sezioneOfferBotDetails);
        }

        return dto;
    }
// da verificare quello che arriva da FE
    private  List<DatiReferentiInputDTO> extractReferents(CreazioneNuovoOrdineInputBean bean) {
        List<DatiReferentiInputDTO> referentDTOs = null;

        if (bean != null) {
            referentDTOs = new ArrayList<>();
            if (bean.getDatiReferenti()!=null && bean.getDatiReferenti().size()!=0){
                Collection<DatiReferentiInputBean> valuebean = bean.getDatiReferenti().values();
                int i=1;
                for (DatiReferentiInputBean datiReferentiInputBean : valuebean) {
                    DatiReferentiInputDTO referentiDTO = mapper.translate(datiReferentiInputBean, DatiReferentiInputDTO.class);
                    referentiDTO.setProgressivoReferente(i);
                    referentDTOs.add(referentiDTO);
                    i++;
                }
            }
        }

        return referentDTOs;
    }

    
    // metodo non necessario per non propagare (ILARIO) stringa vuota
    public  IndirizzoDatiClienteFinaleInputDTO extractAnagraficaIndirizzoClienteFinaleDTO(IndirizzoDatiClienteFinaleInputBean bean) {
        IndirizzoDatiClienteFinaleInputDTO dto = null;

        if (bean != null && StringUtils.isNotEmpty(bean.getProvincia()) && StringUtils.isNotEmpty(bean.getComune())) {
            dto = new IndirizzoDatiClienteFinaleInputDTO();
            dto.setProvincia(bean.getProvincia());
            dto.setComune(bean.getComune());
            dto.setLocalita(bean.getComune());
            dto.setPartToponomastica(bean.getPartToponomastica());
            dto.setIndirizzo(bean.getIndirizzo());
            dto.setCivico(bean.getCivico());
            dto.setCap(StringUtils.defaultIfBlank(bean.getCap(), null));
            dto.setComplesso(StringUtils.defaultIfEmpty(bean.getComplesso(), null));
            dto.setScala(StringUtils.defaultIfEmpty(bean.getScala(), null));
            dto.setPiano(StringUtils.defaultIfEmpty(bean.getPiano(), null));
            dto.setInterno(StringUtils.defaultIfEmpty(bean.getInterno(), null));
            //RU_915
            dto.setCodiceComune(StringUtils.defaultIfEmpty(bean.getCodiceComune(), null));
            //SM_10007
            dto.setCodiceEgon(StringUtils.defaultIfEmpty(bean.getCodiceEgon(), null));
            //RU_1452
            dto.setIdentificativoDelPop(StringUtils.defaultIfEmpty(bean.getIdentificativoDelPop(), null));
        }

        return dto;
    }
    
    //RU_915
    // metodo non necessario per non propagare (ILARIO) stringa vuota
    public  IndirizzoDatiClienteFinaleInputDTO extractAnagraficaIndirizzoClienteFinaleDTOForCPS(IndirizzoDatiClienteFinaleInputBean bean) {
        IndirizzoDatiClienteFinaleInputDTO dto = null;

        if (bean != null) {
            dto = new IndirizzoDatiClienteFinaleInputDTO();
            dto.setCap(StringUtils.defaultIfBlank(bean.getCap(), null));
            dto.setIndirizzo(StringUtils.defaultIfEmpty(bean.getIndirizzo(), null));
            dto.setCodiceComune(StringUtils.defaultIfEmpty(bean.getCodiceComune(), null));
            //SM_10007
            dto.setCodiceEgon(StringUtils.defaultIfEmpty(bean.getCodiceEgon(), null));
            //RU_1452
            dto.setIdentificativoDelPop(StringUtils.defaultIfEmpty(bean.getIdentificativoDelPop(), null));
        }

        return dto;
    }

    // metodo non necessario per non propagare (ILARIO) stringa vuota
    public  DatiClienteFinaleInputDTO extractAnagraficaDatiClienteFinaleDTO(DatiClienteFinaleInputBean bean) {
        DatiClienteFinaleInputDTO dto = null;

        if (bean != null && StringUtils.isNotEmpty(bean.getCognomeRagioneSociale())) {
            dto = new DatiClienteFinaleInputDTO();
            dto.setNome(bean.getNome());
            dto.setCognomeRagioneSociale(bean.getCognomeRagioneSociale());

            if (StringUtils.isNotEmpty(bean.getCf())) {
                dto.setCf(bean.getCf());
            }

            if (StringUtils.isNotEmpty(bean.getpIva())) {
                dto.setpIva(bean.getpIva());
            }
            
            //RU_915
            dto.setNumeroBolletta(bean.getNumeroBolletta());
            dto.setBimestreRiferimento(bean.getBimestreRiferimento());
            dto.setTipoDocumento(bean.getTipoDocumento());
            dto.setNumeroDocumento(bean.getNumeroDocumento());
            dto.setAutoritaEmittente(bean.getAutoritaEmittente());
            dto.setDataEmissione(bean.getDataEmissione());
            dto.setCodiceRipensamentoMaiRichiesto(bean.getCodiceRipensamentoMaiRichiesto());
            dto.setDataSottoscrizioneNuovoContratto(bean.getDataSottoscrizioneNuovoContratto());
            dto.setDataRichiestaCessazione(bean.getDataRichiestaCessazione());
            dto.setCodiceOloCessazione(bean.getCodiceOloCessazione());
            
        }

        return dto;
    }


    
    private SezioneOffertaInputDTO getSezioneOffertaInputDTO(Entry<String, DettaglioOffertaOrdineBean> key){
        SezioneOffertaInputDTO dtoBean;
        
        if  ((key.getValue().getDft()==null)|| StringUtils.isBlank(key.getValue().getDft())){
            dtoBean =null;
        }else{
            // per settare a "Y" tutti i valori che pervengono valorizzati a "true"
            if ( "true".equals(key.getValue().getDft()) ){
                key.getValue().setDft("Y");
            }else if ("false".equals(key.getValue().getDft()) ){
                key.getValue().setDft("N");
            }
            dtoBean = mapper.translate(key.getValue(), SezioneOffertaInputDTO.class);
        }

        return dtoBean;
    }

    
    private SezioneOffertaInputDTO getSezioneOffertaInputDTO(DettaglioOffertaOrdineBean offer){
        SezioneOffertaInputDTO dtoFromBean;
        if(offer.getDft() == null || StringUtils.isBlank(offer.getDft())){
            dtoFromBean = null;
        }else{
            // per settare a "Y" tutti i valori che pervengono valorizzati a "true"
            if ( "true".equals(offer.getDft()) ){
                offer.setDft("Y");
            }else if ("false".equals(offer.getDft()) ){
                offer.setDft("N");
            }
            dtoFromBean = mapper.translate(offer, SezioneOffertaInputDTO.class);
        }
       return dtoFromBean; 
    }
    
    //RU_980
    private List<DatiServiziOpzionaliInputDTO> extractDatiServiziOpzionali(List<DatiServiziOpzionaliInputBean> inputList){
    	List<DatiServiziOpzionaliInputDTO> list = new ArrayList<DatiServiziOpzionaliInputDTO>();
    	if(inputList != null && inputList.size() > 0) {    		
    		Iterator<DatiServiziOpzionaliInputBean> iteratorList = inputList.iterator();
    		while(iteratorList.hasNext()) {
    			DatiServiziOpzionaliInputDTO out = new DatiServiziOpzionaliInputDTO();
    			DatiServiziOpzionaliInputBean in = iteratorList.next();    			
    			out = mapper.translate(in, DatiServiziOpzionaliInputDTO.class);    			
    			list.add(out);    			
    		}      		
    	}    	
    	return list;    	
    }
    
    private DatiDisaggregazioneInputDTO extractDatiDisaggregazione(DatiDisaggregazioneInputBean input){
    	DatiDisaggregazioneInputDTO output = new DatiDisaggregazioneInputDTO();
    	if(input != null) {    		   		
    		output = mapper.translate(input, DatiDisaggregazioneInputDTO.class);
    	}    	
    	return output;    	
    }
    
    private DatiPresaAppuntamentoInputDTO extractDatiPresaAppuntamento(DatiPresaAppuntamentoInputBean input){
    	DatiPresaAppuntamentoInputDTO output = new DatiPresaAppuntamentoInputDTO();
    	if(input != null) {    
    		if (StringUtils.isNotEmpty(input.getDataAppuntamento())) {
    			output.setDataAppuntamento(DateHelper.convertFromFE(input.getDataAppuntamento()));
    		}
    		output.setFasciaOraria(input.getFasciaOraria());
    		output.setOwnerPresaAppuntamento(input.getOwnerPresaAppuntamento());
    	}    	
    	return output;    	
    }
    
    private DatiPrestazioniAggiuntiveInputDTO extractDatiPrestazioniAggiuntive(DatiPrestazioniAggiuntiveInputBean input){
    	DatiPrestazioniAggiuntiveInputDTO output = new DatiPrestazioniAggiuntiveInputDTO();
    	//SM_9216
    	if(input != null && input.getFlagPrestazioneAggiuntiva() != null) {    		
    		output.setFlagPrestazioneAggiuntiva(FlagHelper.convertFromFE(input.getFlagPrestazioneAggiuntiva().booleanValue()));
    		output.setPrestazioneAggiuntiva(input.getPrestazioneAggiuntiva());
    	}    	
    	return output;    	
    }
    
    private DatiSlaPlusSuInputDTO extractDatiSlaPlusSu(DatiSlaPlusSuInputBean input){
    	DatiSlaPlusSuInputDTO output = new DatiSlaPlusSuInputDTO();
    	//SM_9216
    	if(input != null && input.getFlagSlaPlusSu() != null) {    		
    		output.setFlagSlaPlusSu(FlagHelper.convertFromFE(input.getFlagSlaPlusSu().booleanValue()));
    		output.setValoreSla(input.getValoreSla());
    	}    	
    	return output;    	
    }
    
    //RU_1393
    private DatiGestioneAutonomaInputDTO extractDatiGestioneAutonoma(DatiGestioneAutonomaInputBean input){
    	DatiGestioneAutonomaInputDTO output = new DatiGestioneAutonomaInputDTO();
    	//SM_9216
    	if(input != null && input.getSystemUnico() != null) {    		
    		output.setImpresaSystem(input.getImpresaSystem());
    		output.setNoteSu(input.getNoteSu());
    		output.setOperatoreSystem(input.getOperatoreSystem());
    		output.setSubAppalto(input.getSubAppalto());
    		output.setSystemUnico(input.getSystemUnico());
    	}    	
    	return output;    	
    }
    
    //RU_1485
    private List<DatiServiziOpzionaliAlternativiInputDTO> extractDatiServiziOpzionaliAlternativi(List<DatiServiziOpzionaliAlternativiInputBean> inputList){
    	List<DatiServiziOpzionaliAlternativiInputDTO> list = new ArrayList<DatiServiziOpzionaliAlternativiInputDTO>();
    	if(inputList != null && inputList.size() > 0) {    		
    		Iterator<DatiServiziOpzionaliAlternativiInputBean> iteratorList = inputList.iterator();
    		while(iteratorList.hasNext()) {
    			DatiServiziOpzionaliAlternativiInputDTO out = new DatiServiziOpzionaliAlternativiInputDTO();
    			DatiServiziOpzionaliAlternativiInputBean in = iteratorList.next();    			
    			out = mapper.translate(in, DatiServiziOpzionaliAlternativiInputDTO.class);    			
    			list.add(out);    			
    		}      		
    	}    	
    	return list;    	
    }
    
    //RU_1180
    private DatiOfferteMulticastInputDTO extractDatiOfferteMulticast(DatiOfferteMulticastInputBean input){
    	DatiOfferteMulticastInputDTO output = new DatiOfferteMulticastInputDTO();
    	if(input != null) {    		
    		output.setAsNumber(input.getAsNumber());
    		output.setBandaFeeder(input.getBandaFeeder());
    		output.setClliFeeder(input.getClliFeeder());
    		output.setCodiceTdKit(input.getCodiceTdKit());
    		output.setIdVlanOlo(input.getIdVlanOlo());
    		output.setIpSessione(input.getIpSessione());
    		output.setMacroArea(input.getMacroArea());
    		output.setPrimoFeeder(input.getPrimoFeeder());
    		//RU_1205
    		output.setClliFeederSuccessivi(extractClliFeederSuccessivi(input.getClliFeederSuccessivi()));
    	}    	
    	return output;    	
    }
    
    //RU_1205
    private List<ClliFeederSuccessivoInputDTO> extractClliFeederSuccessivi(List<ClliFeederSuccessivoInputBean> inputList){
    	List<ClliFeederSuccessivoInputDTO> list = new ArrayList<ClliFeederSuccessivoInputDTO>();
    	if(inputList != null && inputList.size() > 0) {    		
    		Iterator<ClliFeederSuccessivoInputBean> iteratorList = inputList.iterator();
    		while(iteratorList.hasNext()) {
    			ClliFeederSuccessivoInputDTO out = new ClliFeederSuccessivoInputDTO();
    			ClliFeederSuccessivoInputBean in = iteratorList.next();    			
    			out = mapper.translate(in, ClliFeederSuccessivoInputDTO.class);    			
    			list.add(out);    			
    		}      		
    	}    	
    	return list;    	
    }
    
    //RU_1462
    private List<ApparatoFiberstreamInputDTO> extractApparatiFiberStream(List<ApparatoFiberstreamInputBean> input){
    	List<ApparatoFiberstreamInputDTO> list = new ArrayList<ApparatoFiberstreamInputDTO>();
    	if(input != null && input.size() > 0) {
    		Iterator<ApparatoFiberstreamInputBean> iteratorList = input.iterator();
    		while(iteratorList.hasNext()) {
    			ApparatoFiberstreamInputDTO out = new ApparatoFiberstreamInputDTO();
    			ApparatoFiberstreamInputBean in = iteratorList.next();    			
    			out.setAzioneApparato(in.getAzioneApparato());
    			out.setCausale(in.getCausale());
    			out.setCodiceApparato(in.getCodiceApparato());
    			out.setIdServizioAggiuntivo(in.getIdServizioAggiuntivo());
    			out.setPasswordApparato(in.getPasswordApparato());
    			out.setQtaApparato(in.getQtaApparato());
    			out.setTipologiaApparato(in.getTipologiaApparato());
    			list.add(out);    			
    		}
    	}
    	return list;    	
    }
    
    private List<DatiServiziAggiuntiviInputDTO> extractDatiServiziAggiuntivi(List<DatiServiziAggiuntiviInputBean> inputList){
    	List<DatiServiziAggiuntiviInputDTO> list = new ArrayList<DatiServiziAggiuntiviInputDTO>();
    	if(inputList != null && inputList.size() > 0) {    		
    		Iterator<DatiServiziAggiuntiviInputBean> iteratorList = inputList.iterator();
    		while(iteratorList.hasNext()) {
    			DatiServiziAggiuntiviInputDTO out = new DatiServiziAggiuntiviInputDTO();
    			DatiServiziAggiuntiviInputBean in = iteratorList.next();    			
    			out.setInformazioniServizio(in.getInformazioniServizio());
    			out.setNomeServizio(in.getNomeServizio());
    			out.setVincoloServizio(in.getVincoloServizio());
    			out.setApparati(extractApparatiFiberStream(in.getApparati()));
    			list.add(out);    			
    		}      		
    	}    	
    	return list;    	
    }
}
