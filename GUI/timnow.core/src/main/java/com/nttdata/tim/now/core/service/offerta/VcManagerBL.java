package com.nttdata.tim.now.core.service.offerta;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.offerta.VcRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.vc.MaxVcKitInputBean;
import com.nttdata.tim.now.data.bean.vc.ProfiloVcOutputBean;
import com.nttdata.tim.now.data.bean.vp.MaxVCVPOutputBean;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.dto.vc.ListaProfiliVcOutputDTO;
import com.nttdata.tim.now.data.dto.vc.MaxVcKitInputDTO;
import com.nttdata.tim.now.data.dto.vc.VcProfileOutputDTO;
import com.nttdata.tim.now.data.dto.vp.MaxVCVPOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VcManagerBL extends AbstractBL {

    @Autowired
    private VcRESTClient vcRestIL;

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

    public GenericListBean<ProfiloVcOutputBean> getProfilesVc(String tipoProfilo) throws BusinessLayerException {
        GenericListBean<ProfiloVcOutputBean> list = new GenericListBean<>();
        try {
            ListaProfiliVcOutputDTO dto = vcRestIL.getProfilesVc(tipoProfilo);
            validateResponseResult(dto);

            list.setData(mapper.translateList(dto.getProfilesVc(), ProfiloVcOutputBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }

    public GenericListBean<ProfiloVcOutputBean> viewProfilesVC(String tipoProfilo, String idOfferta, String codiceProfilo, String protocollo, String profilotecnicolinea, String caratteristica) throws BusinessLayerException {
        GenericListBean<ProfiloVcOutputBean> list = new GenericListBean<>();
        try {
            VcProfileOutputDTO dto = vcRestIL.viewProfilesVC(tipoProfilo, idOfferta, codiceProfilo, protocollo, profilotecnicolinea, caratteristica);
            validateResponseResult(dto);

            list.setData(mapper.translateList(dto.getProfiliVC(), ProfiloVcOutputBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }

    public GenericListBean<ProfiloVcOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String tipoProfilo) throws BusinessLayerException {
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata VcManager");
    	}

    	GenericListBean<ProfiloVcOutputBean> list = new GenericListBean<>();
        try {
            AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
            ListaProfiliVcOutputDTO dto = vcRestIL.advancedSearch(inputDto, tipoProfilo);
            validateResponseResult(dto);

            list.setData(mapper.translateList(dto.getProfilesVc(), ProfiloVcOutputBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }

    public MaxVCVPOutputBean checkMaxVcPerKit(MaxVcKitInputBean body, String tipoProfilo) throws BusinessLayerException {
        try {
            MaxVcKitInputDTO input = mapper.translate(body, MaxVcKitInputDTO.class);
            MaxVCVPOutputDTO output = vcRestIL.checkMaxVcPerKit(input, tipoProfilo);
            validateResponseResult(output);
            return mapper.translate(output, MaxVCVPOutputBean.class);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
    }

}
