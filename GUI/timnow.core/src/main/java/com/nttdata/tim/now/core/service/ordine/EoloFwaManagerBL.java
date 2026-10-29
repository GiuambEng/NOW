package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.EoloFwaRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.indirizzo.CittaOutputBean;
import com.nttdata.tim.now.data.bean.indirizzo.IndirizzoOutputBean;
import com.nttdata.tim.now.data.bean.ordine.eolo.CodiceVlanEoloFwaInputBean;
import com.nttdata.tim.now.data.bean.ordine.eolo.CodiceVlanEoloFwaOutputBean;
import com.nttdata.tim.now.data.bean.ordine.eolo.VerificaCoppiaIdVlanCvlanInputBean;
import com.nttdata.tim.now.data.bean.ordine.eolo.VerificaCoppiaIdVlanCvlanOutputBean;
import com.nttdata.tim.now.data.dto.indirizzo.IndirizzoEoloFwaOutputDTO;
import com.nttdata.tim.now.data.dto.indirizzo.IndirizzoOutputDTO;
import com.nttdata.tim.now.data.dto.indirizzo.ListaCittaOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.eolo.CodiceVlanEoloFwaInputDTO;
import com.nttdata.tim.now.data.dto.ordine.eolo.ListaCodiceVlanEoloFwaOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.eolo.VerificaCoppiaIdVlanCvlanInputDTO;
import com.nttdata.tim.now.data.dto.ordine.eolo.VerificaCoppiaIdVlanCvlanOutputDTO;
import com.nttdata.tim.now.data.enumeration.ModesEnum;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//RU_1475
@Service
public class EoloFwaManagerBL extends AbstractBL {

	@Autowired
	private EoloFwaRESTClient eoloFwaRESTClient;


	public GenericListBean<CodiceVlanEoloFwaOutputBean> getVlanEoloFwa(CodiceVlanEoloFwaInputBean inputBean, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<CodiceVlanEoloFwaOutputBean> list = new GenericListBean<>();
		try {
			CodiceVlanEoloFwaInputDTO inputDto = mapper.translate(inputBean, CodiceVlanEoloFwaInputDTO.class);
			ListaCodiceVlanEoloFwaOutputDTO dto = eoloFwaRESTClient.getVlanEoloFwa(inputDto, tipoProfilo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getSvlanCodeList(), CodiceVlanEoloFwaOutputBean.class));

		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		return list;
	}	
	
	public IndirizzoOutputBean getMunicipalities(String selectedProvince, String query, String tipoProfilo) throws BusinessLayerException {
        IndirizzoOutputBean bean = new IndirizzoOutputBean();
        try {
            IndirizzoOutputDTO dto = eoloFwaRESTClient.getMunicipalities(selectedProvince, query, tipoProfilo);
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
            IndirizzoOutputDTO dto = eoloFwaRESTClient.getAddressParticle(selectedProvince, selectedMunicipality, query, tipoProfilo);
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
            IndirizzoOutputDTO dto = eoloFwaRESTClient.getAddresses(selectedProvince, selectedMunicipality, selectedParticle, query, tipoProfilo);
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
            IndirizzoEoloFwaOutputDTO dto = eoloFwaRESTClient.getNumber(selectedProvince, selectedMunicipality, selectedParticle, selectedAddress, query, tipoProfilo);
            validateResponseResult(dto);
            bean.setCivico(dto.getCivico());
            bean.setCodiceEgon(dto.getCodiceEgon());
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
            IndirizzoOutputDTO dto = eoloFwaRESTClient.getProvinces(tipoProfilo);
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
            ListaCittaOutputDTO dto = eoloFwaRESTClient.getCities(provincia, tipoProfilo);
            validateResponseResult(dto);
            list.setData(mapper.translateList(dto.getCities(), CittaOutputBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }

        return list;
    }
    
	public VerificaCoppiaIdVlanCvlanOutputBean verificaCoppiaIdVlanCvlan(VerificaCoppiaIdVlanCvlanInputBean inputBean ,String tipoProfilo)
			throws BusinessLayerException {
		VerificaCoppiaIdVlanCvlanOutputBean bean = null;
		try {
			VerificaCoppiaIdVlanCvlanInputDTO inputDto = mapper.translate(inputBean, VerificaCoppiaIdVlanCvlanInputDTO.class);
			VerificaCoppiaIdVlanCvlanOutputDTO dto = eoloFwaRESTClient.verificaCoppiaIdVlanCvlan(inputDto, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, VerificaCoppiaIdVlanCvlanOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
