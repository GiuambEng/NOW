package com.nttdata.tim.now.core.service.offerta;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.offerta.VpRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.vp.CodiceVpOutputBean;
import com.nttdata.tim.now.data.bean.vp.MaxVCVPInputBean;
import com.nttdata.tim.now.data.bean.vp.MaxVCVPOutputBean;
import com.nttdata.tim.now.data.bean.vp.VpOutputBean;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.dto.vp.ListaCodiciVpOutputDTO;
import com.nttdata.tim.now.data.dto.vp.ListaVpOutputDTO;
import com.nttdata.tim.now.data.dto.vp.MaxVCVPInputDTO;
import com.nttdata.tim.now.data.dto.vp.MaxVCVPOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VpManagerBL extends AbstractBL {

    @Autowired
    private VpRESTClient vpRestIL;

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

    public GenericListBean<VpOutputBean> getVps(String tipoProfilo) throws BusinessLayerException {
        GenericListBean<VpOutputBean> list = new GenericListBean<>();
        try {
            ListaVpOutputDTO dto = vpRestIL.getVps(tipoProfilo);
            validateResponseResult(dto);
            list.setData(mapper.translateList(dto.getVps(), VpOutputBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }

    public GenericListBean<CodiceVpOutputBean> getVpCodeList(String codOlo, String idOfferta, String tipoProfilo) throws BusinessLayerException {
        GenericListBean<CodiceVpOutputBean> list = new GenericListBean<>();
        try {
            ListaCodiciVpOutputDTO dto = vpRestIL.getVpCodeList(codOlo, idOfferta, tipoProfilo);
            validateResponseResult(dto);
            list.setData(mapper.translateList(dto.getVpCodeDTOList(), CodiceVpOutputBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }

    public MaxVCVPOutputBean getMaxVcVp(MaxVCVPInputBean body, String tipoProfilo) throws BusinessLayerException {
        try {
            MaxVCVPInputDTO input = mapper.translate(body, MaxVCVPInputDTO.class);
            MaxVCVPOutputDTO output = vpRestIL.getMaxVcVp(input, tipoProfilo);
            validateResponseResult(output);
            return mapper.translate(output, MaxVCVPOutputBean.class);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
    }

    public GenericListBean<VpOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String tipoProfilo) throws BusinessLayerException {
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata VpManager");
    	}

    	GenericListBean<VpOutputBean> list = new GenericListBean<>();
        try {
            AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
            ListaVpOutputDTO vpListDTO = vpRestIL.advancedSearch(inputDto, tipoProfilo);
            validateResponseResult(vpListDTO);
            list.setData(mapper.translateList(vpListDTO.getVps(), VpOutputBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }

}
