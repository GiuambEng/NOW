package com.nttdata.tim.now.core.converter.ordine;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.tim.now.data.bean.ordine.CompatibilitaProfiloTecnicoLineaProfiloVCBean;
import com.nttdata.tim.now.data.bean.vc.VCBean;
import com.nttdata.tim.now.data.dto.ordine.CompatibilitaProfiloTecnicoLineaProfiloVC_DTO;
import com.nttdata.tim.now.data.dto.vc.VC_DTO;

import org.dozer.DozerConverter;

public class CompatibilitaProfiloTecnicoLineaProfiloVCConverter extends DozerConverter<CompatibilitaProfiloTecnicoLineaProfiloVC_DTO, CompatibilitaProfiloTecnicoLineaProfiloVCBean> {
	public CompatibilitaProfiloTecnicoLineaProfiloVCConverter() {
        super(CompatibilitaProfiloTecnicoLineaProfiloVC_DTO.class, CompatibilitaProfiloTecnicoLineaProfiloVCBean.class);
    }

    @Override
    public CompatibilitaProfiloTecnicoLineaProfiloVC_DTO convertFrom(CompatibilitaProfiloTecnicoLineaProfiloVCBean source, CompatibilitaProfiloTecnicoLineaProfiloVC_DTO destinationDTO) {
    	if (source == null) {
    		return null;
    	}
    	
    	CompatibilitaProfiloTecnicoLineaProfiloVC_DTO destination = new CompatibilitaProfiloTecnicoLineaProfiloVC_DTO();
    	
		
    	destination.setCaratteristica(source.getCaratteristica());
		destination.setIdAsset(source.getIdAsset());
		destination.setIdOfferta(source.getIdOfferta());
		destination.setLavorazione(source.getLavorazione());
		destination.setProfiloTecnicoLinea(source.getProfiloTecnicoLinea());
		
		List<VC_DTO> list = new ArrayList<>();
		
		for(VCBean b : source.getVc()) {
			
			VC_DTO dto = new VC_DTO();
			
			dto.setTipoProfilo(b.getTipoProfilo());
			dto.setVci(b.getVci());
			dto.setVpi(b.getVpi());
			
			list.add(dto);
		}
	
		destination.setVc(list);
		
    	return destination;
    }

    @Override
    public CompatibilitaProfiloTecnicoLineaProfiloVCBean convertTo(CompatibilitaProfiloTecnicoLineaProfiloVC_DTO source, CompatibilitaProfiloTecnicoLineaProfiloVCBean destinationBean) {
    	if (source == null) {
    		return null;
    	}
    	
    	CompatibilitaProfiloTecnicoLineaProfiloVCBean destination = new CompatibilitaProfiloTecnicoLineaProfiloVCBean();
    	
		
    	destination.setCaratteristica(source.getCaratteristica());
		destination.setIdAsset(source.getIdAsset());
		destination.setIdOfferta(source.getIdOfferta());
		destination.setLavorazione(source.getLavorazione());
		destination.setProfiloTecnicoLinea(source.getProfiloTecnicoLinea());
		
		List<VCBean> list = new ArrayList<>();
		
		for(VC_DTO b : source.getVc()) {
			
			VCBean bean = new VCBean();
			
			bean.setTipoProfilo(b.getTipoProfilo());
			bean.setVci(b.getVci());
			bean.setVpi(b.getVpi());
			
			list.add(bean);
		}
	
		destination.setVc(list);
		
    	return destination;
    }
}
