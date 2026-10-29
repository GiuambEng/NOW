package com.nttdata.tim.now.core.service.filenotifiche;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.filenotifiche.SemaforoRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.export.ExportableDataOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.semaforo.RisottomissioneOutputBean;
import com.nttdata.tim.now.data.bean.semaforo.SemaforoOutputBean;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.dto.semaforo.ListaSemaforiOutputDTO;
import com.nttdata.tim.now.data.dto.semaforo.RisottomissioneOutputWrapperDTO;
import com.nttdata.tim.now.data.dto.semaforo.SemaforoOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StatoFileManagerBL extends AbstractBL {

    @Autowired
    private SemaforoRESTClient semaforoRestIL;

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

    public GenericListBean<SemaforoOutputBean> getOrderRequestFileState(String oloCodeAgcom, String userProfile, String userId)
            throws BusinessLayerException {
        GenericListBean<SemaforoOutputBean> bean = new GenericListBean<>();
        try {
            ListaSemaforiOutputDTO dto = semaforoRestIL.getOrderRequestFileState(oloCodeAgcom, userProfile, userId);
            boolean isLimited = validateResponseResult(dto);

            if(dto !=null && dto.getLista() != null){
                List<SemaforoOutputBean> semaforiBean = new ArrayList<>();
                for (SemaforoOutputDTO semaforo : dto.getLista()) {
                    SemaforoOutputBean semaforoBean = mapper.translate(semaforo, SemaforoOutputBean.class);
                    semaforiBean.add(semaforoBean);
                }   
                bean.setData(semaforiBean);
            }
            bean.setIsLimitedList(isLimited);

        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }

        return bean;
    }


    public ExportableDataOutputBean requestExport(RicercaAvanzataInputBean inputBean, String codOloAgcom,
            String tipoProfilo, String userId) throws BusinessLayerException {
        ExportableDataOutputBean bean = new ExportableDataOutputBean();
        try {
            AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
            ExportableDataOutputDTO dto = semaforoRestIL.advancedSearch(inputDto, codOloAgcom, tipoProfilo, userId);
            validateResponseResult(dto);

            bean = mapper.translate(dto, ExportableDataOutputBean.class);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }

    public GenericListBean<SemaforoOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String codOloAgcom,
            String tipoProfilo, String userId) throws BusinessLayerException {
        GenericListBean<SemaforoOutputBean> bean = new GenericListBean<>();
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata StatoFileManager");
    	}
        
        try {
            AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
            ListaSemaforiOutputDTO dto = semaforoRestIL.advancedSearch(inputDto, codOloAgcom, tipoProfilo, userId);
            boolean isLimited = validateResponseResult(dto);
            bean.setIsLimitedList(isLimited); 
            bean.setData(mapper.translateList(dto.getLista(), SemaforoOutputBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }

    public RisottomissioneOutputBean risottomissione(String idFile, String tipoProfilo) throws BusinessLayerException{
        RisottomissioneOutputBean bean = new RisottomissioneOutputBean();
        try {
            RisottomissioneOutputWrapperDTO dto = semaforoRestIL.risottomissione(idFile, tipoProfilo);
            validateResponseResult(dto);
            bean.setEsito(dto.getRisottomissione().getEsito());
            bean.setDescrizione(dto.getRisottomissione().getDescrizione());
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }

}
