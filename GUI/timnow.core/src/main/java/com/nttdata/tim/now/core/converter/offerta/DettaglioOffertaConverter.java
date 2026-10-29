package com.nttdata.tim.now.core.converter.offerta;

import java.util.HashMap;
import java.util.Map;

import com.nttdata.tim.now.data.bean.offerta.DettaglioOffertaOutputBean;
import com.nttdata.tim.now.data.bean.ordine.DettaglioOffertaOrdineBean;
import com.nttdata.tim.now.data.dto.offerta.DettaglioOffertaOutputDTO;
import com.nttdata.tim.now.data.dto.offerta.OfferDetailDTO;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

public class DettaglioOffertaConverter extends DozerConverter<DettaglioOffertaOutputBean, DettaglioOffertaOutputDTO>
		implements MapperAware {

	private Mapper mapper;

	public DettaglioOffertaConverter() {
		super(DettaglioOffertaOutputBean.class, DettaglioOffertaOutputDTO.class);
	}

	@Override
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public DettaglioOffertaOutputBean convertFrom(DettaglioOffertaOutputDTO dto, DettaglioOffertaOutputBean beanDest) {

		if (dto!=null){
			DettaglioOffertaOutputBean destination = new DettaglioOffertaOutputBean();

			destination.setOfferta(dto.getOfferta());

			Map<String, DettaglioOffertaOrdineBean> readonlyDetails = new HashMap<>();
			Map<String, DettaglioOffertaOrdineBean> offerDetailTopList = new HashMap<>();
			if (dto.getOfferTopDetails() != null) {
				for (OfferDetailDTO offer : dto.getOfferTopDetails()) {
					DettaglioOffertaOrdineBean beanFromDTO = mapper.map(offer, DettaglioOffertaOrdineBean.class);
					if (StringUtils.isNotEmpty(beanFromDTO.getKey())) {
						offerDetailTopList.put(beanFromDTO.getKey(), beanFromDTO);
					} else {
						readonlyDetails.put(generateKeyFromLabel(beanFromDTO.getLabel()), beanFromDTO);
					}
				}
			}
			destination.setOfferTopDetails(offerDetailTopList);

			Map<String, DettaglioOffertaOrdineBean> offerDetailBotList = new HashMap<>();
			if (dto.getOfferBotDetails() != null) {
				for (OfferDetailDTO offer : dto.getOfferBotDetails()) {
					DettaglioOffertaOrdineBean beanFromDTO = mapper.map(offer, DettaglioOffertaOrdineBean.class);
					if (StringUtils.isNotEmpty(beanFromDTO.getKey())) {
						offerDetailBotList.put(beanFromDTO.getKey(), beanFromDTO);
					} else {
						readonlyDetails.put(generateKeyFromLabel(beanFromDTO.getLabel()), beanFromDTO);
					}
				}
			}
			destination.setOfferBotDetails(offerDetailBotList);
			destination.setReadonlyDetails(readonlyDetails);

			return destination;
		}
		return null;
	}

	@Override
	public DettaglioOffertaOutputDTO convertTo(DettaglioOffertaOutputBean arg0, DettaglioOffertaOutputDTO arg1) {
		return null;
	}

	private static String generateKeyFromLabel(String label) {
		if (StringUtils.isNotEmpty(label)) {
			return StringUtils.remove(label, ' ').toUpperCase();
		}
		return null;
	}

}
