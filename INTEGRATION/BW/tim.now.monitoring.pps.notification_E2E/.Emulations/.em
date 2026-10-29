<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.monitoring.pps.notification">
  <ProcessNode Id="tim.now.MonitoraggioAllineamentoConsistenzeNativeNOW.Sub_AllineamentoMonitoraggioConsistenzeNativeNOW" Name="tim.now.MonitoraggioAllineamentoConsistenzeNativeNOW.Sub_AllineamentoMonitoraggioConsistenzeNativeNOW" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.MonitoraggioAllineamentoConsistenzeNativeNOW.Sub_AllineamentoMonitoraggioConsistenzeNativeNOW">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.MonitoraggioAllineamentoConsistenzeNativeNOW.Sub_AllineamentoMonitoraggioConsistenzeNativeNOW_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.ConfigurazioneEstrazioniPPS.SubGetWorkingDate" Name="tim.now.monitoring.ConfigurazioneEstrazioniPPS.SubGetWorkingDate" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.ConfigurazioneEstrazioniPPS.SubGetWorkingDate">
      <Inputs Id="c9418da2-db94-4a15-8b65-801f0f55285etim.now.monitoring.pps.notification_tim.now.monitoring.ConfigurazioneEstrazioniPPS.SubGetWorkingDate_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.Timer.PPS.CallProcedurePPS" Name="tim.now.monitoring.Timer.PPS.CallProcedurePPS" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.Timer.PPS.CallProcedurePPS">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.monitoring.Timer.PPS.CallProcedurePPS_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.Timer.PPS.ControlloJobAttivi" Name="tim.now.monitoring.Timer.PPS.ControlloJobAttivi" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.Timer.PPS.ControlloJobAttivi">
      <Inputs Id="54fc4e9f-44b5-42fd-8d57-e99458c90c2ctim.now.monitoring.pps.notification_tim.now.monitoring.Timer.PPS.ControlloJobAttivi_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.notification.Monitoraggi.FocusAGICOM" Name="tim.now.monitoring.pps.notification.Monitoraggi.FocusAGICOM" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.notification.Monitoraggi.FocusAGICOM">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.monitoring.pps.notification.Monitoraggi.FocusAGICOM_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioKO" Name="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioKO" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioKO">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioKO_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.Monitoraggi.MonitoraggioArchiAggiuntivo" Name="tim.now.monitoring.pps.Monitoraggi.MonitoraggioArchiAggiuntivo" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.Monitoraggi.MonitoraggioArchiAggiuntivo">
      <Inputs Id="b5e5cf0f-86f2-46f4-9c46-85d98c1ae9bbtim.now.monitoring.pps.notification_tim.now.monitoring.pps.Monitoraggi.MonitoraggioArchiAggiuntivo_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.Monitoraggi.MonitoraggioConsistenze" Name="tim.now.monitoring.pps.Monitoraggi.MonitoraggioConsistenze" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.Monitoraggi.MonitoraggioConsistenze">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.monitoring.pps.Monitoraggi.MonitoraggioConsistenze_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.Monitoraggi.MonitoraggioFatturazione" Name="tim.now.monitoring.pps.Monitoraggi.MonitoraggioFatturazione" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.Monitoraggi.MonitoraggioFatturazione">
      <Inputs Id="540c55d8-b7f3-42cb-a7cc-181998a63a65tim.now.monitoring.pps.notification_tim.now.monitoring.pps.Monitoraggi.MonitoraggioFatturazione_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.Monitoraggi.MonitoraggioFile" Name="tim.now.monitoring.pps.Monitoraggi.MonitoraggioFile" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.Monitoraggi.MonitoraggioFile">
      <Inputs Id="d3f858c7-6f1c-4dc4-8ad8-3d668c905aa0tim.now.monitoring.pps.notification_tim.now.monitoring.pps.Monitoraggi.MonitoraggioFile_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioNotifiche" Name="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioNotifiche" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioNotifiche">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioNotifiche_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioODV" Name="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioODV" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioODV">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioODV_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioRimodulazioni" Name="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioRimodulazioni" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioRimodulazioni">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioRimodulazioni_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.Monitoraggi.MonitoraggioRimodulazioniDaDelivery" Name="tim.now.monitoring.pps.Monitoraggi.MonitoraggioRimodulazioniDaDelivery" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.Monitoraggi.MonitoraggioRimodulazioniDaDelivery">
      <Inputs Id="9ebcd2f5-4da2-4e1c-bd58-01ec5420db1btim.now.monitoring.pps.notification_tim.now.monitoring.pps.Monitoraggi.MonitoraggioRimodulazioniDaDelivery_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioRisalite" Name="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioRisalite" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioRisalite">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioRisalite_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioTempiAttraversamento" Name="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioTempiAttraversamento" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioTempiAttraversamento">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.monitoring.pps.notification.Monitoraggi.MonitoraggioTempiAttraversamento_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.Monitoraggi.MontoraggioNotificheE2E" Name="tim.now.monitoring.pps.Monitoraggi.MontoraggioNotificheE2E" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.Monitoraggi.MontoraggioNotificheE2E">
      <Inputs Id="1bcd73ba-1ab5-4853-840d-e8c1fcbb2fd8tim.now.monitoring.pps.notification_tim.now.monitoring.pps.Monitoraggi.MontoraggioNotificheE2E_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.Monitoraggi.PopolamentoPPSPREVISTARIMODULAZIONE" Name="tim.now.monitoring.pps.Monitoraggi.PopolamentoPPSPREVISTARIMODULAZIONE" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.Monitoraggi.PopolamentoPPSPREVISTARIMODULAZIONE">
      <Inputs Id="eeaf13a4-a3f0-441b-80c3-e3b95fa28b3ftim.now.monitoring.pps.notification_tim.now.monitoring.pps.Monitoraggi.PopolamentoPPSPREVISTARIMODULAZIONE_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.Monitoraggi.ReportBacklogGiacenza" Name="tim.now.monitoring.pps.Monitoraggi.ReportBacklogGiacenza" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.Monitoraggi.ReportBacklogGiacenza">
      <Inputs Id="66e157d9-2a57-45cf-adeb-25118dff5f5ctim.now.monitoring.pps.notification_tim.now.monitoring.pps.Monitoraggi.ReportBacklogGiacenza_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.Monitoraggi.Sub_InsStatoPPS" Name="tim.now.monitoring.pps.Monitoraggi.Sub_InsStatoPPS" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.Monitoraggi.Sub_InsStatoPPS">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.monitoring.pps.Monitoraggi.Sub_InsStatoPPS_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.notification.SendMail.CheckAllegato" Name="tim.now.monitoring.pps.notification.SendMail.CheckAllegato" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.notification.SendMail.CheckAllegato">
      <Inputs Id="282ead89-1595-4a3e-bf88-3f545218aafbtim.now.monitoring.pps.notification_tim.now.monitoring.pps.notification.SendMail.CheckAllegato_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.notification.SendMail.Main_CreazioneMail" Name="tim.now.monitoring.pps.notification.SendMail.Main_CreazioneMail" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.notification.SendMail.Main_CreazioneMail">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.monitoring.pps.notification.SendMail.Main_CreazioneMail_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.pps.notification.SendMail.Sub_SendMail" Name="tim.now.monitoring.pps.notification.SendMail.Sub_SendMail" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.notification.SendMail.Sub_SendMail">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.monitoring.pps.notification.SendMail.Sub_SendMail_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
