package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.ExternalDataRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.externaldata.DbcfxOutputBean;
import com.nttdata.tim.now.data.dto.dtu.ListaDBCFXOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExternalDataManagerBL extends AbstractBL {


	@Autowired
	private ExternalDataRESTClient dbcfx;

	public GenericListBean<DbcfxOutputBean> getDbcfx(String tipoprofilo, String idrichiestaolo) throws BusinessLayerException {
		GenericListBean<DbcfxOutputBean> list = new GenericListBean<>();
		try {
			ListaDBCFXOutputDTO dto = dbcfx.getDBCFX(tipoprofilo, idrichiestaolo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getDbcfx(), DbcfxOutputBean.class));
		} catch (Exception e) {
			logger.error("Error reading dbcfx", e);
			throw new BusinessLayerException(e);
		}
		return list;
	}

}
