package com.nttdata.tim.now.core.converter.ordine;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.tim.now.data.bean.monitoring.rimodulazionedac.MonitoraggioRimodulazioniDACOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.rimodulazionedac.RimodulazioneDACInfoOutputBean;
import com.nttdata.tim.now.data.dto.monitoring.rimodulazionedac.MonitoraggioRimodulazioniDACOutputDTO;
import com.nttdata.tim.now.util.date.DateHelper;

import org.dozer.DozerConverter;

public class MonitoraggioRimodulazioniDACConverter extends DozerConverter<MonitoraggioRimodulazioniDACOutputDTO, MonitoraggioRimodulazioniDACOutputBean> {

    public MonitoraggioRimodulazioniDACConverter() {
        super(MonitoraggioRimodulazioniDACOutputDTO.class, MonitoraggioRimodulazioniDACOutputBean.class);
      
    }

    @Override
    public MonitoraggioRimodulazioniDACOutputDTO convertFrom(MonitoraggioRimodulazioniDACOutputBean bean, MonitoraggioRimodulazioniDACOutputDTO dto) {
        return null;
    }

    @Override
    public MonitoraggioRimodulazioniDACOutputBean convertTo(MonitoraggioRimodulazioniDACOutputDTO dto, MonitoraggioRimodulazioniDACOutputBean destinationBean) {
        if (dto!= null){
            MonitoraggioRimodulazioniDACOutputBean destination = new MonitoraggioRimodulazioniDACOutputBean();
            List<RimodulazioneDACInfoOutputBean> dacInfo = new ArrayList<>();
 
            RimodulazioneDACInfoOutputBean bean1 = new RimodulazioneDACInfoOutputBean();
            bean1.setDataScadenza(dto.getDataScadenza());
            bean1.setRichiesteInScadenza(dto.getRichiesteInScadenza1());
            dacInfo.add(bean1);
            
            RimodulazioneDACInfoOutputBean bean2 = new RimodulazioneDACInfoOutputBean();
            bean2.setDataScadenza(DateHelper.getNextSelectedDay(dto.getDataScadenza(),1));
            bean2.setRichiesteInScadenza(dto.getRichiesteInScadenza2());
            dacInfo.add(bean2);

            RimodulazioneDACInfoOutputBean bean3 = new RimodulazioneDACInfoOutputBean();
            bean3.setDataScadenza(DateHelper.getNextSelectedDay(dto.getDataScadenza(),2));
            bean3.setRichiesteInScadenza(dto.getRichiesteInScadenza3());
            dacInfo.add(bean3);

            RimodulazioneDACInfoOutputBean bean4 = new RimodulazioneDACInfoOutputBean();
            bean4.setDataScadenza(DateHelper.getNextSelectedDay(dto.getDataScadenza(),3));
            bean4.setRichiesteInScadenza(dto.getRichiesteInScadenza4());
            dacInfo.add(bean4);

            RimodulazioneDACInfoOutputBean bean5 = new RimodulazioneDACInfoOutputBean();
            bean5.setDataScadenza(DateHelper.getNextSelectedDay(dto.getDataScadenza(),4));
            bean5.setRichiesteInScadenza(dto.getRichiesteInScadenza5());
            dacInfo.add(bean5);

            RimodulazioneDACInfoOutputBean bean6 = new RimodulazioneDACInfoOutputBean();
            bean6.setDataScadenza(DateHelper.getNextSelectedDay(dto.getDataScadenza(),5));
            bean6.setRichiesteInScadenza(dto.getRichiesteInScadenza6());
            dacInfo.add(bean6);

            RimodulazioneDACInfoOutputBean bean7 = new RimodulazioneDACInfoOutputBean();
            bean7.setDataScadenza(DateHelper.getNextSelectedDay(dto.getDataScadenza(),6));
            bean7.setRichiesteInScadenza(dto.getRichiesteInScadenza7());
            dacInfo.add(bean7);

            RimodulazioneDACInfoOutputBean bean8 = new RimodulazioneDACInfoOutputBean();
            bean8.setDataScadenza(DateHelper.getNextSelectedDay(dto.getDataScadenza(),7));
            bean8.setRichiesteInScadenza(dto.getRichiesteInScadenza8());
            dacInfo.add(bean8);

            destination.setDescStatoRefresh(dto.getDescStatoRefresh());
            destination.setOperatore(dto.getOperatore());
            destination.setStatoRefresh("Y".equals(dto.getStatoRefresh()));
            destination.setDacInfo(dacInfo);
            destination.setDataScadenza(dto.getDataScadenza());
            return destination;
        }
        
        return null;
    }

}
