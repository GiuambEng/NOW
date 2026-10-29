package com.nttdata.tim.now.web.controller.monitoraggio;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.monitoraggio.MonitoraggioUserTaskManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.monitoring.usertask.CausaliBean;
import com.nttdata.tim.now.data.bean.monitoring.usertask.ModUserTaskCausaliInputBean;
import com.nttdata.tim.now.data.bean.monitoring.usertask.ModUserTaskCausaliOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.usertask.UserTaskOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitorings/userTask")
public class UserTaskController extends GenericController {

    @Autowired
    private MonitoraggioUserTaskManagerBL monitoringUserTaskManagerBL;

    // MonitoraggioUserTask GET
	@JsonGetMapping
	public UserTaskOutputBean getUserTask(
			@RequestParam(value = "tipoUserTask", required = false) String tipoUserTask, HttpSession session) throws BusinessLayerException {

		UserBean user = getCurrentUser(session);
	    UserTaskOutputBean bean = monitoringUserTaskManagerBL.getUserTask(tipoUserTask, user.getCodiceProfilo());
        bean = ensureBeanResult(bean, UserTaskOutputBean.class);
        return bean;
	}

	//MonitoraggioUserTask POST
    @JsonPostMapping
    public ModUserTaskCausaliOutputBean monitoraggiousertaskComplete(@RequestBody ModUserTaskCausaliInputBean inputBean, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
        ModUserTaskCausaliOutputBean bean = monitoringUserTaskManagerBL.userTaskCausali(inputBean, user.getCodiceProfilo());
        bean = ensureBeanResult(bean,ModUserTaskCausaliOutputBean.class);
        return bean;
    }

    // MonitoraggioUserTask Lista Causali
    @JsonGetMapping("/{idWorkItem}/{idRichiestaOlo}")
    public GenericListBean<CausaliBean> getListaCausali(@PathVariable String idWorkItem, @PathVariable String idRichiestaOlo, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
        GenericListBean<CausaliBean> bean = monitoringUserTaskManagerBL.getListaCausali(idWorkItem, idRichiestaOlo, user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
    }

}
