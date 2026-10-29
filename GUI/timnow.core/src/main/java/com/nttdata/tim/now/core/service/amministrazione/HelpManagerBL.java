package com.nttdata.tim.now.core.service.amministrazione;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.nttdata.tim.now.adapters.esb.amministrazione.HelpRESTClient;
import com.nttdata.tim.now.core.comparators.IHelpComparator;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.help.HelpBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.help.HelpDTO;
import com.nttdata.tim.now.data.dto.help.ListaHelpDTO;
import com.nttdata.tim.now.util.FlagHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelpManagerBL extends AbstractBL {

    @Autowired
    private HelpRESTClient helpRestIL;

    public GenericListBean<HelpBean> getIhelp(String tipoProfilo) throws BusinessLayerException {
        GenericListBean<HelpBean> bean = new GenericListBean<>();
        try {
            ListaHelpDTO dto = helpRestIL.getIhelp(tipoProfilo);
            validateResponseResult(dto);
            List<HelpDTO> helps = dto.getHelps();
            List<HelpBean> list = new ArrayList<>();
            if (helps != null) {
                Collections.sort(helps, new IHelpComparator());

                for (HelpDTO element : helps) {
                    list.add(mapper.translate(element, HelpBean.class));
                }
            }
            bean.setData(list);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }

        return bean;
    }

    public GenericListBean<HelpBean> getVisibleIhelpByAmbito(String ambito, String tipoProfilo) throws BusinessLayerException {
        GenericListBean<HelpBean> bean = new GenericListBean<>();
        try {
            ListaHelpDTO dto = helpRestIL.getIhelp(tipoProfilo);
            validateResponseResult(dto);
            List<HelpDTO> helps = dto.getHelps();
            List<HelpBean> list = new ArrayList<>();
            if (helps != null) {
                Collections.sort(helps, new IHelpComparator());

                for (HelpDTO element : helps) {
                    if (FlagHelper.convertFromBE(element.getVisibile()) && ambito.equalsIgnoreCase(element.getAmbito())) {
                        list.add(mapper.translate(element, HelpBean.class));
                    }
                }
            }
            bean.setData(list);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }

        return bean;
    }

    public GenericListBean<HelpBean> createIhelp(HelpBean help, UserBean user) throws BusinessLayerException {
        GenericListBean<HelpBean> bean = new GenericListBean<>();
        try {
            HelpDTO inputDto = mapper.translate(help, HelpDTO.class);
            Date today = Calendar.getInstance().getTime();
            inputDto.setDataInserimento(today);
            inputDto.setDataAggiornamento(today);
            inputDto.setOperatore(user.getUserId());
            inputDto.setOperatoreAggiornamento(user.getUserId());
            ListaHelpDTO outputDto = helpRestIL.createIhelp(inputDto, user.getCodiceProfilo());
            validateResponseResult(outputDto);
            bean.setData(mapper.translateList(outputDto.getHelps(), HelpBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }

    public GenericListBean<HelpBean> updateIhelp(HelpBean help, UserBean user) throws BusinessLayerException {
        GenericListBean<HelpBean> bean = new GenericListBean<>();
        try {
            HelpDTO inputDto = mapper.translate(help, HelpDTO.class);
            Date today = Calendar.getInstance().getTime();
            inputDto.setDataAggiornamento(today);
            inputDto.setOperatoreAggiornamento(user.getUserId());
            ListaHelpDTO outputDto = helpRestIL.updateIhelp(inputDto, user.getCodiceProfilo());
            validateResponseResult(outputDto);
            bean.setData(mapper.translateList(outputDto.getHelps(), HelpBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }

    public GenericListBean<HelpBean> deleteIhelp(String idHelp, String tipoProfilo) throws BusinessLayerException {
        GenericListBean<HelpBean> bean = new GenericListBean<>();
        try {
            ListaHelpDTO dto = helpRestIL.deleteIhelp(idHelp, tipoProfilo);
            validateResponseResult(dto);
            bean.setData(mapper.translateList(dto.getHelps(), HelpBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }

}
