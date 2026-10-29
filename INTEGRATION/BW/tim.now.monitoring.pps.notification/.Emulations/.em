<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.monitoring.pps.notification">
  <ProcessNode Id="tim.now.MonitoraggioAllineamentoConsistenzeNativeNOW.Sub_AllineamentoMonitoraggioConsistenzeNativeNOW" Name="tim.now.MonitoraggioAllineamentoConsistenzeNativeNOW.Sub_AllineamentoMonitoraggioConsistenzeNativeNOW" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.MonitoraggioAllineamentoConsistenzeNativeNOW.Sub_AllineamentoMonitoraggioConsistenzeNativeNOW">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.MonitoraggioAllineamentoConsistenzeNativeNOW.Sub_AllineamentoMonitoraggioConsistenzeNativeNOW_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.monitoring.Timer.PPS.CallProcedurePPS" Name="tim.now.monitoring.Timer.PPS.CallProcedurePPS" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.Timer.PPS.CallProcedurePPS">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.monitoring.Timer.PPS.CallProcedurePPS_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
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
  <ProcessNode Id="tim.now.monitoring.pps.Monitoraggi.MonitoraggioConsistenze" Name="tim.now.monitoring.pps.Monitoraggi.MonitoraggioConsistenze" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.Monitoraggi.MonitoraggioConsistenze">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.monitoring.pps.Monitoraggi.MonitoraggioConsistenze_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
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
  <ProcessNode Id="tim.now.monitoring.pps.Monitoraggi.Sub_InsStatoPPS" Name="tim.now.monitoring.pps.Monitoraggi.Sub_InsStatoPPS" ModelType="BW" moduleName="tim.now.monitoring.pps.notification">
    <Operation Name="callProcess" serviceName="tim.now.monitoring.pps.Monitoraggi.Sub_InsStatoPPS">
      <Inputs Id="tim.now.monitoring.pps.notification_tim.now.monitoring.pps.Monitoraggi.Sub_InsStatoPPS_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
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
