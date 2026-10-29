package com.nttdata.tim.now.core.service.generic;

import com.nttdata.tim.now.adapters.esb.generic.RicercaAvanzataRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.DuplicateEntryException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaCampiOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.SalvaRicercaBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.ricerca.FieldsResearchListDTO;
import com.nttdata.tim.now.data.dto.save.SaveResearchDTO;
import com.nttdata.tim.now.data.dto.save.SaveResearchGetOutputDTO;
import com.nttdata.tim.now.data.dto.save.SaveResearchListDTO;
import com.nttdata.tim.now.data.dto.save.SaveResearchPostInputDTO;
import com.nttdata.tim.now.data.enumeration.BackEndResultCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RicercaAvanzataManagerBL extends AbstractBL {

    @Autowired
    private RicercaAvanzataRESTClient ricercaAvanzataRestIL;

    //R1F-21-0411
    public GenericListBean<RicercaCampiOutputBean> getFieldsResearch(String tipoLista, String codiceProfilo, String flagHashing) throws BusinessLayerException {
        GenericListBean<RicercaCampiOutputBean> list = new GenericListBean<>();
        try {
            FieldsResearchListDTO dto = ricercaAvanzataRestIL.getFieldsResearch(tipoLista, codiceProfilo, flagHashing);
            validateResponseResult(dto);
            list.setData(mapper.translateList(dto.getFieldsResearch(), RicercaCampiOutputBean.class));
        } catch (Exception e) {
            logger.error("Error fields research", e);
            throw new BusinessLayerException(e);
        }
        return list;
    }

    public GenericListBean<SalvaRicercaBean> getSaveResearch(String userId, String codFunzione) throws BusinessLayerException {
        GenericListBean<SalvaRicercaBean> list = new GenericListBean<>();
        try {
            SaveResearchGetOutputDTO dto = ricercaAvanzataRestIL.getSaveResearch(userId, codFunzione);
            validateResponseResult(dto);
            list.setData(mapper.translateList(dto.getSalvaRicercaOutput(), SalvaRicercaBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }

    public void createSaveResearch(GenericListBean<SalvaRicercaBean> body, String userId, String codFunzione) throws BusinessLayerException {
        GenericListBean<SaveResearchDTO> list = new GenericListBean<>();
        try {
            list.setData(mapper.translateList(body.getData(), SaveResearchDTO.class));
            SaveResearchListDTO dto = new SaveResearchListDTO();
            validateResponseResult(dto);
            dto.setSaveResearches(list.getData());
            ricercaAvanzataRestIL.createSaveResearch(dto, userId, codFunzione);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
    }

    public void createSaveResearch(SalvaRicercaBean body, String userId, String codFunzione) throws BusinessLayerException, DuplicateEntryException {
        ESBResultDTO result;
        try {
            SaveResearchPostInputDTO dto = mapper.translate(body, SaveResearchPostInputDTO.class);
            result = ricercaAvanzataRestIL.createSaveResearch(dto, userId, codFunzione);
            validateResponseResult(result);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }

        if (BackEndResultCode.ALREADY_EXISTS.getCode().equals(result.getResult().getCode())) {
            throw new DuplicateEntryException();
        }
    }

    public void deleteSaveResearch(String userId, String codFunzione, String nomeFiltro) throws BusinessLayerException {
        try {
            ESBResultDTO dto = ricercaAvanzataRestIL.deleteSaveResearch(userId, codFunzione, nomeFiltro);
            validateResponseResult(dto);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
    }

}
