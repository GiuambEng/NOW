package com.nttdata.tim.now.core.service.offerta;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.nttdata.tim.now.adapters.esb.offerta.OffertaRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.offerta.DettaglioOffertaWrapperOutputBean;
import com.nttdata.tim.now.data.bean.offerta.DisambiguazioneOffertaOutputBean;
import com.nttdata.tim.now.data.bean.offerta.OffertaOutputBean;
import com.nttdata.tim.now.data.dto.offerta.DettaglioOffertaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.offerta.DisambiguazioneOffertaListDTO;
import com.nttdata.tim.now.data.dto.offerta.ListaOfferteOutputDTO;
import com.nttdata.tim.now.data.dto.offerta.OffertaOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffertaManagerBL extends AbstractBL {

    @Autowired
    private OffertaRESTClient offerRESTClient;
    
	public DettaglioOffertaWrapperOutputBean getOffer(String idOfferta, String tipoProfilo) throws BusinessLayerException {
		DettaglioOffertaWrapperOutputBean offerBean = null;
		DettaglioOffertaWrapperOutputDTO offerDTO = null;
		try {
			offerDTO = offerRESTClient.getOffer(idOfferta, tipoProfilo);
			validateResponseResult(offerDTO);
		} catch (Exception e) {
			logger.error("Error reading offer", e);
			throw new BusinessLayerException(e);
		}
		if (offerDTO != null) {
		    // must call doozer ***********
			offerBean = mapper.translate(offerDTO, DettaglioOffertaWrapperOutputBean.class);
		}
		return offerBean;
	}

	public GenericListBean<OffertaOutputBean> getOffers(String contratto, String azione, String tipoProfilo, String flagMulticast) throws BusinessLayerException {
		ListaOfferteOutputDTO result = null;
		GenericListBean<OffertaOutputBean> list = new GenericListBean<>();
		try {
			result = offerRESTClient.getOffers(contratto, azione, tipoProfilo,flagMulticast);
			validateResponseResult(result);
			// aggiunta per gestire la non visualizzazione degli NP per le migrazioni
			 Locale.setDefault(Locale.ENGLISH);
			if (azione.toLowerCase().equals(("migrazione"))&& result.getOffers()!=null) {
				List<OffertaOutputDTO> tmp_src = result.getOffers();
				List<OffertaOutputBean> tmp_dest = new ArrayList<OffertaOutputBean>();
				for (int i=0; i< tmp_src.size(); i++){
				   if (tmp_src.get(i).getNomeOfferta().indexOf("NP")== -1){
                      tmp_dest.add(mapper.translate(tmp_src.get(i), OffertaOutputBean.class)); 
				   }
				}
				list.setData(tmp_dest);
			}else{
				list.setData(mapper.translateList(result.getOffers(), OffertaOutputBean.class));
			}
		} catch (Exception e) {
			logger.error("Error reading offers by contract", e);
			throw new BusinessLayerException(e);
		}
		if (list.getData()==null){
		    throw new BusinessLayerException("Impossibile ricavare la tipologia per l'offerta");
		}
		return list;
	}

	public GenericListBean<DisambiguazioneOffertaOutputBean> getDisambiguationOffers(String tplgLavrz, String tipoProfilo) throws BusinessLayerException {
        GenericListBean<DisambiguazioneOffertaOutputBean> bean = new GenericListBean<>();
	    DisambiguazioneOffertaListDTO result = null;
		try {
			result = offerRESTClient.getOffersDisamb(tplgLavrz, tipoProfilo);
			validateResponseResult(result);
			bean.setData(mapper.translateList(result.getOffers(), DisambiguazioneOffertaOutputBean.class));
		} catch (Exception e) {
			logger.error("Error reading offers for disambiguation", e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
