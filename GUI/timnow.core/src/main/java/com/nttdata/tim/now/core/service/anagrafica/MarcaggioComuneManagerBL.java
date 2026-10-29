package com.nttdata.tim.now.core.service.anagrafica;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.anagrafica.MarcaggioComuneRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.anagraficamarcaggio.AnagraficaMarcaggioComuneOutputBean;
import com.nttdata.tim.now.data.bean.anagraficamarcaggio.export.RichiestaExportMarcaggioComuniOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.anagraficamarcaggio.ListaAnagraficaMarcaggioComuneOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//RU_963
@Service
public class MarcaggioComuneManagerBL extends AbstractBL {

	@Autowired
	private MarcaggioComuneRESTClient marcaggioComuniRestIL;

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

    public GenericListBean<AnagraficaMarcaggioComuneOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String userId, String tipoProfilo)
            throws BusinessLayerException {
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata Ordine");
    	}

        GenericListBean<AnagraficaMarcaggioComuneOutputBean> list = new GenericListBean<>();
        ListaAnagraficaMarcaggioComuneOutputDTO result = null;
        boolean isLimited;
        try {
            AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
            result = marcaggioComuniRestIL.advancedSearch(inputDto, userId, tipoProfilo);
            isLimited = validateResponseResult(result);
            list.setData(mapper.translateList(result.getListaAnagraficaMarcaggioComuni(), AnagraficaMarcaggioComuneOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }
    
    public RichiestaExportMarcaggioComuniOutputBean requestExport(RicercaAvanzataInputBean inputBean, String userId, String tipoProfilo) throws BusinessLayerException {
        try {
        	RichiestaExportMarcaggioComuniOutputBean output = new RichiestaExportMarcaggioComuniOutputBean();
            ListaAnagraficaMarcaggioComuneOutputDTO result = null;
            try {
                AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
                result = marcaggioComuniRestIL.advancedSearch(inputDto, userId, tipoProfilo);
                if(result.getIdExportFile() != null && !result.getIdExportFile().equals("")) 
                {
                	output.setIdFile(result.getIdExportFile());
                }
            } catch (Exception e) {
                throw new BusinessLayerException(e);
            }
            return output;
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
    }

}
