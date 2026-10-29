package com.nttdata.tim.now.web.controller.tracking;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.utente.TrackManagerBL;
import com.nttdata.tim.now.data.bean.esito.EsitoOutputBean;
import com.nttdata.tim.now.data.bean.track.TrackBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tracking")
public class TrackingController extends GenericController {

	@Autowired
	private TrackManagerBL trackManagerBL;

	@JsonPostMapping("/file")
	public EsitoOutputBean trackingExport(@RequestBody TrackBean body, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session); 
		EsitoOutputBean result = trackManagerBL.trackFileOperation(body, user);
		return result;
	}
}
