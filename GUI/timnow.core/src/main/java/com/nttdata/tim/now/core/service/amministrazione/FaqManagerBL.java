package com.nttdata.tim.now.core.service.amministrazione;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.nttdata.tim.now.adapters.esb.amministrazione.FaqRESTClient;
import com.nttdata.tim.now.core.comparators.FAQComparator;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.faq.FaqBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.faq.FaqDTO;
import com.nttdata.tim.now.data.dto.faq.ListaFaqDTO;
import com.nttdata.tim.now.util.FlagHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaqManagerBL extends AbstractBL {

    @Autowired
    private FaqRESTClient faqRestIL;

    public GenericListBean<FaqBean> getFaq(boolean onlyVisible, String tipoProfilo) throws BusinessLayerException {
        GenericListBean<FaqBean> bean = new GenericListBean<>();
        try {
            ListaFaqDTO dto = faqRestIL.getFaq(tipoProfilo);
            validateResponseResult(dto);
            List<FaqDTO> faqs = dto.getFaqs();
            List<FaqBean> list = new ArrayList<>();

            if (faqs != null) {
                Collections.sort(dto.getFaqs(), new FAQComparator());
                for (FaqDTO element : faqs) {
                    if (!onlyVisible || FlagHelper.convertFromBE(element.getVisibile())) {
                        list.add(mapper.translate(element, FaqBean.class));
                    }
                }
            }
            bean.setData(list);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }

    public GenericListBean<FaqBean> createUpdateFaq(FaqBean faq, UserBean user) throws BusinessLayerException {
        GenericListBean<FaqBean> bean = new GenericListBean<>();
        try {
        	 Locale.setDefault(Locale.ENGLISH);
        	if (faq.getOperationType()!= null && ("UPDATE").equals(faq.getOperationType().toUpperCase())){
                FaqDTO inputDto = mapper.translate(faq, FaqDTO.class);
                Date today = Calendar.getInstance().getTime();
                inputDto.setDataAggiornamento(today);
                inputDto.setOperatoreAggiornamento(user.getUserId());
                ListaFaqDTO outputDto = faqRestIL.updateFaq(inputDto, user.getCodiceProfilo());
                validateResponseResult(outputDto);
                bean.setData(mapper.translateList(outputDto.getFaqs(), FaqBean.class));
        	}else{ //case Create
              FaqDTO inputDto = mapper.translate(faq, FaqDTO.class);
              Date today = Calendar.getInstance().getTime();
              inputDto.setDataInserimento(today);
              inputDto.setDataAggiornamento(today);
              inputDto.setOperatore(user.getUserId());
              inputDto.setOperatoreAggiornamento(user.getUserId());
              ListaFaqDTO outputDto = faqRestIL.createFaq(inputDto, user.getCodiceProfilo());
              validateResponseResult(outputDto);
              bean.setData(mapper.translateList(outputDto.getFaqs(), FaqBean.class));
       		
        	}
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }

    public GenericListBean<FaqBean> deleteFaq(String idfaq, String tipoProfilo) throws BusinessLayerException {
        GenericListBean<FaqBean> bean = new GenericListBean<>();
        try {
            ListaFaqDTO dto = faqRestIL.deleteFaq(idfaq, tipoProfilo);
            validateResponseResult(dto);
            bean.setData(mapper.translateList(dto.getFaqs(), FaqBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }
}
