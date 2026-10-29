package com.nttdata.tim.now.core.service.monitoraggio;

import java.util.Date;

import com.nttdata.tim.now.adapters.esb.monitoraggio.MonitoraggioRimodulazioniDACRESTClient;
import com.nttdata.tim.now.adapters.esb.utente.TrackAccessRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.NotReadyException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;
import com.nttdata.tim.now.data.bean.monitoring.rimodulazionedac.MonitoraggioRimodulazioniDACOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.monitoring.rimodulazionedac.MonitoraggioRimodulazioniDACOutputWrapperDTO;
import com.nttdata.tim.now.data.dto.track.TrackDTO;
import com.nttdata.tim.now.data.enumeration.TrackingEvent;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoraggioRimodulazioniDACManagerBL extends AbstractBL {

    @Autowired
    private MonitoraggioRimodulazioniDACRESTClient monitoraggioRimodulazioniDACRESTClient;
    
    //SM_8906
    @Autowired
    private TrackAccessRESTClient trackAccessRestClient;

    public MonitoraggioRimodulazioniDACOutputBean getLista(String tipoProfilo) throws BusinessLayerException {
        MonitoraggioRimodulazioniDACOutputBean bean = new MonitoraggioRimodulazioniDACOutputBean();
        try {
            MonitoraggioRimodulazioniDACOutputWrapperDTO dto = monitoraggioRimodulazioniDACRESTClient.getLista(tipoProfilo);
            validateResponseResult(dto);
            bean = mapper.translate(dto.getMonitoraggioRimodulazioniDAC(), MonitoraggioRimodulazioniDACOutputBean.class);
        } catch (IntegrationLayerException e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }

    //SM_8906
    public FileScaricatoBean getContatoreSingolo(int contatoreSingolo, String tipoProfilo, String vista, UserBean user) throws BusinessLayerException {
        FileScaricatoBean fileBean = null;
        try {        	
			//SM_8906
			Date startRequest = new Date();			
            MonitoraggioRimodulazioniDACOutputWrapperDTO dto = monitoraggioRimodulazioniDACRESTClient.getContatoreSingolo(contatoreSingolo, tipoProfilo);
            Date endRequest = new Date();
            validateResponseResult(dto);

            if (dto.getMonitoraggioRimodulazioniDAC() != null && dto.getMonitoraggioRimodulazioniDAC().getExportData() != null) {
                fileBean = new FileScaricatoBean();
                byte[] fileData = new Base64().decode(dto.getMonitoraggioRimodulazioniDAC().getExportData().getBytes());
                fileBean.setFileData(fileData);
                fileBean.setName(dto.getMonitoraggioRimodulazioniDAC().getNomeFileToExport());
                fileBean.setSize(Long.parseLong(dto.getMonitoraggioRimodulazioniDAC().getSizeFile()));
            } else {
                throw new NotReadyException("Not ready export data with id "+contatoreSingolo);
            }
            
			TrackDTO trackDto = buildRequestTrackRestService(user, TrackingEvent.DOWNLOAD, vista, dto);
			trackDto.setTimestampInizio(startRequest);
			trackDto.setTimestampFine(endRequest);
			trackDto.setTimestampInserimento(startRequest);
			trackAccessRestClient.trackAccess(trackDto);
            
        } catch (IntegrationLayerException e) {
            throw new BusinessLayerException(e);
        }

        return fileBean;
    }

    public MonitoraggioRimodulazioniDACOutputBean refresh(String tipoProfilo) throws BusinessLayerException {
        MonitoraggioRimodulazioniDACOutputBean bean = new MonitoraggioRimodulazioniDACOutputBean();
        try {
            MonitoraggioRimodulazioniDACOutputWrapperDTO dto = monitoraggioRimodulazioniDACRESTClient.refresh(tipoProfilo);
            validateResponseResult(dto);
            bean.setDescStatoRefresh(dto.getMonitoraggioRimodulazioniDAC().getDescStatoRefresh());
            bean.setStatoRefresh("Y".equals(dto.getMonitoraggioRimodulazioniDAC().getStatoRefresh()));
        } catch (IntegrationLayerException e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }

}
