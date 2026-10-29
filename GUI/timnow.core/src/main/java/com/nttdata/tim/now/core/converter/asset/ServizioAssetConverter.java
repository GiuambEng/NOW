package com.nttdata.tim.now.core.converter.asset;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.tim.now.data.bean.asset.CustomizzazioneServizioAssetBean;
import com.nttdata.tim.now.data.bean.asset.ServizioAssetBean;
import com.nttdata.tim.now.data.dto.asset.CustomizzazioneServizioAssetDTO;
import com.nttdata.tim.now.data.dto.asset.ServizioAssetDTO;
import com.nttdata.tim.now.util.data.DozerHelper;

import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

public class ServizioAssetConverter extends DozerConverter<ServizioAssetDTO, ServizioAssetBean> implements MapperAware {

    private DozerHelper mapper;
    
    public ServizioAssetConverter() {
        super(ServizioAssetDTO.class, ServizioAssetBean.class);
    }

    @Override
    public void setMapper(Mapper mapper) {
        DozerHelper dozerHelper = new DozerHelper();
        dozerHelper.setMapper(mapper);
        this.mapper = dozerHelper;
    }
    
    @Override
    public ServizioAssetDTO convertFrom(ServizioAssetBean source, ServizioAssetDTO destinationDTO) {
    	if (source == null) {
    		return null;
    	}
    	ServizioAssetDTO destination = new ServizioAssetDTO();
        destination.setProdotto(source.getProdotto());
        List<CustomizzazioneServizioAssetDTO> listDto = new ArrayList<CustomizzazioneServizioAssetDTO>(); 
        List<CustomizzazioneServizioAssetBean> listBean = source.getCustomizzazione();
        if (listBean!= null && !listBean.isEmpty()){
            for (int i=0;i<listBean.size(); i++){
            	CustomizzazioneServizioAssetDTO dto = new CustomizzazioneServizioAssetDTO();
            	dto.setAttributoCustomizzazione(listBean.get(i).getAttributoCustomizzazione());
            	dto.setValoreCustomizzazione(listBean.get(i).getValoreCustomizzazione());
            	listDto.add(dto);
            }
        }
        destination.setCustomizzazione(listDto);
        return destination;
    }

    @Override
    public ServizioAssetBean convertTo(ServizioAssetDTO source, ServizioAssetBean destinationBean) {
    	if (source == null) {
    		return null;
    	}
        	
    	ServizioAssetBean destination = new ServizioAssetBean();
        destination.setProdotto(source.getProdotto());
        List<CustomizzazioneServizioAssetBean> listBean = new ArrayList<CustomizzazioneServizioAssetBean>(); 
        List<CustomizzazioneServizioAssetDTO> listDto = source.getCustomizzazione();
        if (listDto!= null && !listDto.isEmpty()){
            for (int i=0;i<listDto.size(); i++){
            	CustomizzazioneServizioAssetBean bean = new CustomizzazioneServizioAssetBean();
            	bean.setAttributoCustomizzazione(listDto.get(i).getAttributoCustomizzazione());
            	bean.setValoreCustomizzazione(listDto.get(i).getValoreCustomizzazione());
            	listBean.add(bean);
            }
        }
        destination.setCustomizzazione(listBean);
        return destination;
    }

}
