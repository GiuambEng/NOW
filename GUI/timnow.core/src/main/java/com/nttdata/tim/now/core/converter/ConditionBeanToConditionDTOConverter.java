package com.nttdata.tim.now.core.converter;

import com.nttdata.tim.now.data.bean.ricerca.ConditionBean;
import com.nttdata.tim.now.data.dto.ricerca.ConditionDTO;
import com.nttdata.tim.now.data.enumeration.ConditionType;
import com.nttdata.tim.now.util.date.DateHelper;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerConverter;

public class ConditionBeanToConditionDTOConverter extends DozerConverter<ConditionBean, ConditionDTO> {

    public ConditionBeanToConditionDTOConverter() {
		super(ConditionBean.class, ConditionDTO.class);
	}

	@Override
	public ConditionDTO convertTo(ConditionBean source, ConditionDTO destinationDTO) {
		if (source == null) {
			return null;
		}
		
		ConditionDTO destination = new ConditionDTO();
		destination.setNome(source.getNome());
		destination.setOperazione(source.getOperazione());
		destination.setTipo(source.getTipo());
		
		if (StringUtils.isNotBlank(source.getValore()) && ConditionType.DATE.name().equals(source.getTipo())) {
			String normalizedDate = DateHelper.convertFromFE(source.getValore());
			destination.setValore(normalizedDate);
		} else {
			destination.setValore(source.getValore());
		}
		
		return destination;
	}

	@Override
	public ConditionBean convertFrom(ConditionDTO source, ConditionBean destinationBean) {
		if (source == null) {
			return null;
		}
		
		ConditionBean destination = new ConditionBean();
		destination.setNome(source.getNome());
		destination.setOperazione(source.getOperazione());
		destination.setTipo(source.getTipo());
		destination.setValore(source.getValore());
		
		return destination;
	}

}
