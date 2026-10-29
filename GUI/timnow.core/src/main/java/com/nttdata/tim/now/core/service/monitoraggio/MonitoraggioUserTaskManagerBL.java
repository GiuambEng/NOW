package com.nttdata.tim.now.core.service.monitoraggio;

import com.nttdata.tim.now.adapters.esb.monitoraggio.MonitoraggioUserTaskRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.monitoring.usertask.CausaliBean;
import com.nttdata.tim.now.data.bean.monitoring.usertask.ModUserTaskCausaliInputBean;
import com.nttdata.tim.now.data.bean.monitoring.usertask.ModUserTaskCausaliOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.usertask.UserTaskOutputBean;
import com.nttdata.tim.now.data.dto.monitoring.usertask.ModUserTaskCausaliInputDTO;
import com.nttdata.tim.now.data.dto.monitoring.usertask.ModUserTaskCausaliOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.usertask.UserTaskListaCausaliDTO;
import com.nttdata.tim.now.data.dto.monitoring.usertask.UserTaskOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoraggioUserTaskManagerBL extends AbstractBL {

    @Autowired
    private MonitoraggioUserTaskRESTClient monitoringUserTaskRESTClient;

    public UserTaskOutputBean getUserTask(String tipoUserTask, String tipoProfilo) throws BusinessLayerException {
        UserTaskOutputBean bean = null;
        try {
            UserTaskOutputDTO outputDto = monitoringUserTaskRESTClient.getUserTask(tipoUserTask, tipoProfilo);
            validateResponseResult(outputDto);
            bean = mapper.translate(outputDto, UserTaskOutputBean.class);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }

    public ModUserTaskCausaliOutputBean userTaskCausali(ModUserTaskCausaliInputBean inputBean, String tipoProfilo) throws BusinessLayerException {
        ModUserTaskCausaliOutputBean bean = null;
        try {
            ModUserTaskCausaliInputDTO inputDto = mapper.translate(inputBean, ModUserTaskCausaliInputDTO.class);
            ModUserTaskCausaliOutputDTO outputDto = monitoringUserTaskRESTClient.userTaskCausali(inputDto, tipoProfilo);
           validateResponseResult(outputDto);
            bean = mapper.translate(outputDto, ModUserTaskCausaliOutputBean.class);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }

    public GenericListBean<CausaliBean> getListaCausali(String idWorkItem, String idRichiestaOlo, String tipoProfilo) throws BusinessLayerException  {
        GenericListBean<CausaliBean> bean = new GenericListBean<>();
        try {
            UserTaskListaCausaliDTO outputDto = monitoringUserTaskRESTClient.getListaCausali(idWorkItem, idRichiestaOlo, tipoProfilo);
            validateResponseResult(outputDto);
            bean.setData(mapper.translateList(outputDto.getCausali(), CausaliBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }
}
