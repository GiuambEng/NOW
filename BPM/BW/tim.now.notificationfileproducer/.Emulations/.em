<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.notificationscheduler">
  <ProcessNode Id="tim.now.notificationscheduler.SchedulerNGA" Name="tim.now.notificationscheduler.SchedulerNGA" ModelType="BW" moduleName="tim.now.notificationscheduler">
    <Operation Name="NGAScheduler" serviceName="NGASchedulerPortType">
      <Inputs Id="tim.now.notificationscheduler_tim.now.notificationscheduler.SchedulerNGA_NGAScheduler_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationscheduler.SchedulerNPG" Name="tim.now.notificationscheduler.SchedulerNPG" ModelType="BW" moduleName="tim.now.notificationscheduler">
    <Operation Name="NPScheduler" serviceName="NPSchedulerPortType">
      <Inputs Id="tim.now.notificationscheduler_tim.now.notificationscheduler.SchedulerNPG_NPScheduler_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationscheduler.SchedulerRegolatorio" Name="tim.now.notificationscheduler.SchedulerRegolatorio" ModelType="BW" moduleName="tim.now.notificationscheduler">
    <Operation Name="RegolatorioScheduler" serviceName="RegolatorioSchedulerPortType">
      <Inputs Id="tim.now.notificationscheduler_tim.now.notificationscheduler.SchedulerRegolatorio_RegolatorioScheduler_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationscheduler.SchedulerXDSL" Name="tim.now.notificationscheduler.SchedulerXDSL" ModelType="BW" moduleName="tim.now.notificationscheduler">
    <Operation Name="XDSLScheduler" serviceName="XDSLSchedulerPortType">
      <Inputs Id="tim.now.notificationscheduler_tim.now.notificationscheduler.SchedulerXDSL_XDSLScheduler_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationscheduler.util.FileName" Name="tim.now.notificationscheduler.util.FileName" ModelType="BW" moduleName="tim.now.notificationscheduler">
    <Operation Name="FileName" serviceName="FileNamePortType">
      <Inputs Id="tim.now.notificationscheduler_tim.now.notificationscheduler.util.FileName_FileName_Request" Name="Request" isDefault="true">
        <informations Name="FileNameInput" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/FileName/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/FileName/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tim.com/NOW/xsd/FileName"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:FileNameRequest">
            <parameters Name="tns0:TempoNotifica" Value="ORARIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/FileName"/>
            <parameters Name="tns0:StrutturaRichiesta" Value="NPR" type="string" nameSpace="http://www.tim.com/NOW/xsd/FileName"/>
            <parameters Name="tns0:CodiceOLO" Value="100" type="string" nameSpace="http://www.tim.com/NOW/xsd/FileName" canDelete="true"/>
            <parameters Name="tns0:CodiceOLOAGCOM" Value="WIN" type="string" nameSpace="http://www.tim.com/NOW/xsd/FileName" canDelete="true"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationscheduler.util.SendFile" Name="tim.now.notificationscheduler.util.SendFile" ModelType="BW" moduleName="tim.now.notificationscheduler">
    <Operation Name="SendFile" serviceName="SendFilePortType">
      <Inputs Id="tim.now.notificationscheduler_tim.now.notificationscheduler.util.SendFile_SendFile_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationscheduler.util.WriteFile" Name="tim.now.notificationscheduler.util.WriteFile" ModelType="BW" moduleName="tim.now.notificationscheduler">
    <Operation Name="WriteFile" serviceName="WriteFilePortType">
      <Inputs Id="tim.now.notificationscheduler_tim.now.notificationscheduler.util.WriteFile_WriteFile_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
