package com.nttdata.tim.now.core.service.offerta;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.offerta.LanRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.lan.CodiceVlanSVlanOutputBean;
import com.nttdata.tim.now.data.bean.lan.SVlanCVlanInOutBean;
import com.nttdata.tim.now.data.bean.lan.VerificaUnivocitaSVlanCVlanInputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.lan.ListaCodiceVlanSVlanOutputDTO;
import com.nttdata.tim.now.data.dto.lan.VerificaUnivocitaSVlanCVlanInputDto;
import com.nttdata.tim.now.data.dto.lan.VerificaUnivocitaSvlanCvlanWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LanManagerBL extends AbstractBL {

	@Autowired
	private LanRESTClient lanRestClient;

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

	public GenericListBean<CodiceVlanSVlanOutputBean> getVlanSVlan(String codoloagcom, String encapsulation, String servizio, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<CodiceVlanSVlanOutputBean> list = new GenericListBean<>();
		try {
			ListaCodiceVlanSVlanOutputDTO dto = lanRestClient.getVlanSVlan(codoloagcom, encapsulation, servizio, tipoProfilo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getOrderVlanSvlans(), CodiceVlanSVlanOutputBean.class));

			for (CodiceVlanSVlanOutputBean bean : list.getData()) {
				bean.setTipobanda(StringUtils.lowerCase(bean.getTipobanda()));
			}

		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		return list;
	}

	public GenericListBean<CodiceVlanSVlanOutputBean> getVlanSVlan(String tipoProfilo) throws BusinessLayerException {
		GenericListBean<CodiceVlanSVlanOutputBean> list = new GenericListBean<>();
		try {
			ListaCodiceVlanSVlanOutputDTO dto = lanRestClient.getVlanSVlan(tipoProfilo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getVlansvlans(), CodiceVlanSVlanOutputBean.class));

			for (CodiceVlanSVlanOutputBean bean : list.getData()) {
				bean.setTipobanda(StringUtils.lowerCase(bean.getTipobanda()));
			}

		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		return list;
	}

	public GenericListBean<SVlanCVlanInOutBean> verifySVlanCVlan(VerificaUnivocitaSVlanCVlanInputBean inputBean, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<SVlanCVlanInOutBean> outbean = new GenericListBean<>();
		try {
		    VerificaUnivocitaSVlanCVlanInputDto inputDto = mapper.translate(inputBean, VerificaUnivocitaSVlanCVlanInputDto.class);
			VerificaUnivocitaSvlanCvlanWrapperOutputDTO dto = lanRestClient.verifySVlanCVlan(inputDto, tipoProfilo);
			validateResponseResult(dto);
			outbean.setData(mapper.translateList(dto.getSlanCVlanVerify(), SVlanCVlanInOutBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return outbean;
	}

	public GenericListBean<CodiceVlanSVlanOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String tipoProfilo) throws BusinessLayerException {
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata LanManager");
    	}

		GenericListBean<CodiceVlanSVlanOutputBean> list = new GenericListBean<>();
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			ListaCodiceVlanSVlanOutputDTO dto = lanRestClient.advancedSearch(inputDto, tipoProfilo);
			validateResponseResult(dto);
			if (dto.getVlansvlans() != null) {
				list.setData(mapper.translateList(dto.getVlansvlans(), CodiceVlanSVlanOutputBean.class));
			} else if (dto.getOrderVlanSvlans() != null) {
				list.setData(mapper.translateList(dto.getOrderVlanSvlans(), CodiceVlanSVlanOutputBean.class));
			}
			
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}

    public GenericListBean<CodiceVlanSVlanOutputBean> advancedSearchVlanSvlan(RicercaAvanzataInputBean inputBean, String codOloAgcom, 
    		String servizio, String encapsulation, String idContratto, String tipoProfilo) throws BusinessLayerException {
        GenericListBean<CodiceVlanSVlanOutputBean> list = new GenericListBean<>();
        try {
            AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
            ListaCodiceVlanSVlanOutputDTO dto = lanRestClient.advancedSearchVlanSvlan(inputDto,codOloAgcom, servizio, encapsulation, idContratto, tipoProfilo);
            validateResponseResult(dto);
            if (dto.getVlansvlans() != null) {
                list.setData(mapper.translateList(dto.getVlansvlans(), CodiceVlanSVlanOutputBean.class));
            } else if (dto.getOrderVlanSvlans() != null) {
                list.setData(mapper.translateList(dto.getOrderVlanSvlans(), CodiceVlanSVlanOutputBean.class));
            }
            
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }
	
}
