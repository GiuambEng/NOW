package com.nttdata.tim.now.core.service.monitoraggio;

import com.nttdata.tim.now.adapters.esb.monitoraggio.AllarmiKoGiornalieriRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListExportBean;
import com.nttdata.tim.now.data.bean.monitoring.kogiornalieri.AllarmeKoGiornalieroOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.kogiornalieri.RichiestaAllarmiKoGiornalieriOutputBean;
import com.nttdata.tim.now.data.dto.monitoring.kogiornalieri.ListaAllarmiKoGiornalieriOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.kogiornalieri.ListaRichiesteAllarmiKoGiornalieriDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllarmiKoGiornalieriManagerBL extends AbstractBL {

	@Autowired
	private AllarmiKoGiornalieriRESTClient allarmiKoGiornalieriRestIL;

	public GenericListExportBean<AllarmeKoGiornalieroOutputBean> getAlarmsLevel0(boolean flagExport, String tipoProfilo, String userId) throws BusinessLayerException {
		GenericListExportBean<AllarmeKoGiornalieroOutputBean> bean = new GenericListExportBean<>();
		try {
			ListaAllarmiKoGiornalieriOutputDTO dto = allarmiKoGiornalieriRestIL.getAlarmsLevel0(flagExport, tipoProfilo, userId);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getAlarms(), AllarmeKoGiornalieroOutputBean.class));
			bean.setEsitoExport(dto.getEsitoExport());
			bean.setIdFile(dto.getIdFile());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListExportBean<RichiestaAllarmiKoGiornalieriOutputBean> getAlarmsLevel1(String ambito, String codCausaleOlo, String tipoProfilo)
			throws BusinessLayerException {
		GenericListExportBean<RichiestaAllarmiKoGiornalieriOutputBean> bean = new GenericListExportBean<>();
		try {
			ListaRichiesteAllarmiKoGiornalieriDTO dto = allarmiKoGiornalieriRestIL.getAlarmsLevel1(ambito, codCausaleOlo, tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getMonitorings(), RichiestaAllarmiKoGiornalieriOutputBean.class));
			bean.setEsitoExport(dto.getEsitoExport());
			bean.setIdFile(dto.getIdFile());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}

}
