package com.nttdata.tim.now.core.service.anagrafica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nttdata.tim.now.adapters.esb.anagrafica.RadiusRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.radius.ListaRadiusOutputBean;
import com.nttdata.tim.now.data.bean.radius.RadiusOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.radius.ListaRadiusOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

@Service
public class RadiusManagerBL extends AbstractBL {

    @Autowired
    private RadiusRESTClient radiusRestIL;
	
	@Cacheable(value = "radiusList", key = "#codOlo + '-' + #tipoProfilo")
	public GenericListBean<RadiusOutputBean> getRadiusList(String codOlo, String tipoProfilo, String userId) throws BusinessLayerException {
		GenericListBean<RadiusOutputBean> list = new GenericListBean<>();
		boolean isLimited;
		//Gestione lista limitata
		try {
			ListaRadiusOutputDTO dto = radiusRestIL.getRadiusList(codOlo, tipoProfilo, userId);
			isLimited = validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getListaAnagraficaRadius(), RadiusOutputBean.class));
			list.setIsLimitedList(isLimited);
		} catch (Exception e) {
			logger.error("Error reading radius list", e);
			throw new BusinessLayerException(e);
		}
		return list;
	}
	
	public ListaRadiusOutputBean requestExport(RicercaAvanzataInputBean inputBean, String codOloAgcom, String tipoProfilo, String userId) throws BusinessLayerException {
		ListaRadiusOutputBean bean = new ListaRadiusOutputBean();
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			ListaRadiusOutputDTO dto = radiusRestIL.advancedSearch(inputDto, codOloAgcom, tipoProfilo, userId);
			validateResponseResult(dto);
			bean = mapper.translate(dto, ListaRadiusOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
}
