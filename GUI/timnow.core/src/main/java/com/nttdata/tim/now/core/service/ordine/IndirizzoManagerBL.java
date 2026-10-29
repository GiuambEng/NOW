package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.IndirizzoRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.esito.EsitoOutputBean;
import com.nttdata.tim.now.data.bean.indirizzo.CittaOutputBean;
import com.nttdata.tim.now.data.bean.indirizzo.IndirizzoOutputBean;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;
import com.nttdata.tim.now.data.dto.indirizzo.IndirizzoOutputDTO;
import com.nttdata.tim.now.data.dto.indirizzo.ListaCittaOutputDTO;
import com.nttdata.tim.now.data.enumeration.ModesEnum;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndirizzoManagerBL extends AbstractBL {

    @Autowired
    private IndirizzoRESTClient provinceRESTClient;

    public IndirizzoOutputBean getMunicipalities(String selectedProvince, String query, String tipoProfilo) throws BusinessLayerException {
        IndirizzoOutputBean bean = new IndirizzoOutputBean();
        try {
            IndirizzoOutputDTO dto = provinceRESTClient.getMunicipalities(selectedProvince, query, tipoProfilo);
            validateResponseResult(dto);
            bean.setItems(dto.getItems());
            bean.setType(ModesEnum.COMUNE.toString());
        } catch (Exception e) {
            logger.error("Error reading municipalities", e);
            throw new BusinessLayerException(e);
        }
        return bean;
    }

    public IndirizzoOutputBean getAddressParticles(String selectedProvince, String selectedMunicipality, String query, String tipoProfilo) throws BusinessLayerException {
        IndirizzoOutputBean bean = new IndirizzoOutputBean();
        try {
            IndirizzoOutputDTO dto = provinceRESTClient.getAddressParticle(selectedProvince, selectedMunicipality, query, tipoProfilo);
            validateResponseResult(dto);
            bean.setItems(dto.getItems());
            bean.setType(ModesEnum.PARTICELLATOPONOMASTICA.toString());
        } catch (Exception e) {
            logger.error("Error reading address particles", e);
            throw new BusinessLayerException(e);
        }
        return bean;
    }

    public IndirizzoOutputBean getAddresses(String selectedProvince, String selectedMunicipality, String selectedParticle, String query, String tipoProfilo)
            throws BusinessLayerException {
        IndirizzoOutputBean bean = new IndirizzoOutputBean();
        try {
            IndirizzoOutputDTO dto = provinceRESTClient.getAddresses(selectedProvince, selectedMunicipality, selectedParticle, query, tipoProfilo);
            validateResponseResult(dto);
            bean.setItems(dto.getItems());
            bean.setType(ModesEnum.INDIRIZZO.toString());
        } catch (Exception e) {
            logger.error("Error reading addresses", e);
            throw new BusinessLayerException(e);
        }
        return bean;
    }

    public IndirizzoOutputBean getAddressNumber(String selectedProvince, String selectedMunicipality, String selectedParticle, String selectedAddress,
            String query, String tipoProfilo) throws BusinessLayerException {
        IndirizzoOutputBean bean = new IndirizzoOutputBean();
        try {
            IndirizzoOutputDTO dto = provinceRESTClient.getNumber(selectedProvince, selectedMunicipality, selectedParticle, selectedAddress, query, tipoProfilo);
            validateResponseResult(dto);
            bean.setItems(dto.getItems());
            bean.setType(ModesEnum.CIVICO.toString());
        } catch (IntegrationLayerException e) {
            logger.error("Error reading address number", e);
            throw new BusinessLayerException(e);
        }
        return bean;
    }

    public IndirizzoOutputBean getProvinces(String tipoProfilo) throws BusinessLayerException {
        IndirizzoOutputBean bean = new IndirizzoOutputBean();
        try {
            IndirizzoOutputDTO dto = provinceRESTClient.getProvinces(tipoProfilo);
            validateResponseResult(dto);
            bean.setItems(dto.getItems());
            bean.setType(ModesEnum.PROVINCIA.toString());
        } catch (Exception e) {
            logger.error("Error reading provinces", e);
            throw new BusinessLayerException(e);
        }
        return bean;
    }

    public IndirizzoOutputBean getAddressItems(String selectedProvince, String selectedCity, String selectedParticle, String selectedAddress, String query, String tipoProfilo)
            throws BusinessLayerException {
        if (StringUtils.isNotEmpty(selectedProvince) && StringUtils.isEmpty(selectedCity) && StringUtils.isEmpty(selectedParticle)
                && StringUtils.isEmpty(selectedAddress)) {
            return getMunicipalities(selectedProvince, query, tipoProfilo);
        } else if (StringUtils.isNotEmpty(selectedProvince) && StringUtils.isNotEmpty(selectedCity) && StringUtils.isEmpty(selectedParticle)
                && StringUtils.isEmpty(selectedAddress)) {
            return getAddressParticles(selectedProvince, selectedCity, query, tipoProfilo);
        } else if (StringUtils.isNotEmpty(selectedProvince) && StringUtils.isNotEmpty(selectedCity) && StringUtils.isNotEmpty(selectedParticle)
                && StringUtils.isEmpty(selectedAddress)) {
            return getAddresses(selectedProvince, selectedCity, selectedParticle, query, tipoProfilo);
        } else if (StringUtils.isNotEmpty(selectedProvince) && StringUtils.isNotEmpty(selectedCity) && StringUtils.isNotEmpty(selectedParticle)
                && StringUtils.isNotEmpty(selectedAddress)) {
            return getAddressNumber(selectedProvince, selectedCity, selectedParticle, selectedAddress, query, tipoProfilo);
        } else {
            return getProvinces(tipoProfilo);
        }
    }

    public GenericListBean<CittaOutputBean> getCities(String provincia, String tipoProfilo) throws BusinessLayerException {
        GenericListBean<CittaOutputBean> list = new GenericListBean<>();
        try {
            ListaCittaOutputDTO dto = provinceRESTClient.getCities(provincia, tipoProfilo);
            validateResponseResult(dto);
            list.setData(mapper.translateList(dto.getCities(), CittaOutputBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }

        return list;
    }
   
   //RU_716
   public EsitoOutputBean controlloRecuperaDistretto(String provincia, String comune, String toponomastica, String indirizzo, String civico, String lavorazione) throws BusinessLayerException {
       try {
    	   EsitoDTO dto = provinceRESTClient.controlloRecuperaDistretto(provincia, comune, toponomastica, indirizzo, civico, lavorazione);
           validateResponseResult(dto);
           return mapper.translate(dto, EsitoOutputBean.class);
       } catch (Exception e) {
           throw new BusinessLayerException(e);
       }
   }
}
