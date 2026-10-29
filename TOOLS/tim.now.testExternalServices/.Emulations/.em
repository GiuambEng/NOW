<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.testExternalServices">
  <ProcessNode Id="tim.now.testexternalservices.MainProcess" Name="tim.now.testexternalservices.MainProcess" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="Launch_Test" serviceName="Test_External_Services">
      <Inputs Id="tim.now.testExternalServices_tim.now.testexternalservices.MainProcess_Launch_Test_Request" Name="Request" isDefault="true">
        <informations Name="input" tnsName="xs:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_Test_Extenal_Servervices" nameSpace="xmlns:xs" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_Test_Extenal_Servervices"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tim.com/NOW/xsd/NOW_Test_Extenal_Servervices/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:Request" Value="&#xA;  ">
            <parameters Name="tns0:SYSTEM_TO_TEST" Value="JIVE" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_Test_Extenal_Servervices/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.CCC" Name="tim.now.testexternalservices.sub_processes.CCC" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.CCC">
      <Inputs Id="18796807-0610-49d2-8baa-dcde090e1fectim.now.testExternalServices_tim.now.testexternalservices.sub_processes.CCC_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.CRMB" Name="tim.now.testexternalservices.sub_processes.CRMB" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.CRMB">
      <Inputs Id="75410c9e-c8cd-4f45-b00b-11a57f727a42tim.now.testExternalServices_tim.now.testexternalservices.sub_processes.CRMB_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.CRMWS" Name="tim.now.testexternalservices.sub_processes.CRMWS" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.CRMWS">
      <Inputs Id="3e9cb57c-4dc9-4256-9e00-178d263b08d7tim.now.testExternalServices_tim.now.testexternalservices.sub_processes.CRMWS_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.DBCFX" Name="tim.now.testexternalservices.sub_processes.DBCFX" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.DBCFX">
      <Inputs Id="5ce0b509-6718-41d8-99ab-d77cc7087784tim.now.testExternalServices_tim.now.testexternalservices.sub_processes.DBCFX_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.DYNAMICINVENTORY" Name="tim.now.testexternalservices.sub_processes.DYNAMICINVENTORY" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.DYNAMICINVENTORY">
      <Inputs Id="6b8d7ba5-b362-4c6f-ae02-de8ca6765e73tim.now.testExternalServices_tim.now.testexternalservices.sub_processes.DYNAMICINVENTORY_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.DynamicSub_Process" Name="tim.now.testexternalservices.sub_processes.DynamicSub_Process" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.DynamicSub_Process">
      <Inputs Id="d4a087c9-d196-4866-ace5-055e6b2da406tim.now.testExternalServices_tim.now.testexternalservices.sub_processes.DynamicSub_Process_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.ESB-FASTDATA" Name="tim.now.testexternalservices.sub_processes.ESB-FASTDATA" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.ESB-FASTDATA">
      <Inputs Id="08534c52-99be-4279-95bb-2592d7b6f5cdtim.now.testExternalServices_tim.now.testexternalservices.sub_processes.ESB-FASTDATA_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.FIBERCOP" Name="tim.now.testexternalservices.sub_processes.FIBERCOP" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.FIBERCOP">
      <Inputs Id="a7a56d64-92a4-47c6-a178-7ad6b5d8d4c8tim.now.testExternalServices_tim.now.testexternalservices.sub_processes.FIBERCOP_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.JIVE" Name="tim.now.testexternalservices.sub_processes.JIVE" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.JIVE">
      <Inputs Id="556020cc-a1fa-4c5b-bc53-6e9c64660ca7tim.now.testExternalServices_tim.now.testexternalservices.sub_processes.JIVE_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.JPUB" Name="tim.now.testexternalservices.sub_processes.JPUB" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.JPUB">
      <Inputs Id="eb5e4f0f-a131-4ece-9450-7e75e47c6d2etim.now.testExternalServices_tim.now.testexternalservices.sub_processes.JPUB_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.NNI" Name="tim.now.testexternalservices.sub_processes.NNI" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.NNI">
      <Inputs Id="db75bf61-16de-437c-ac12-e9129a7c9915tim.now.testExternalServices_tim.now.testexternalservices.sub_processes.NNI_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.PATROCLO" Name="tim.now.testexternalservices.sub_processes.PATROCLO" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.PATROCLO">
      <Inputs Id="45990d11-71d6-4986-819f-90f89f3fadd9tim.now.testExternalServices_tim.now.testexternalservices.sub_processes.PATROCLO_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.Processp" Name="tim.now.testexternalservices.sub_processes.Processp" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.Processp">
      <Inputs Id="f1dd8a06-2f79-48c8-9ce6-57c3a2978855tim.now.testExternalServices_tim.now.testexternalservices.sub_processes.Processp_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
      <Inputs Id="8123dc20-9c26-41f8-be91-4af9251dd84b" Name="NewRequest" type="CALLPROCESS">
        <informations Name="input" nameSpace="http://www.tim.com/NOW/xsd/NOW_Test_Extenal_Servervices/">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/xsd/NOW_Test_Extenal_Servervices/"/>
          <Parameter Name="tns:Request">
            <parameters Name="tns:SYSTEM_TO_TEST" Value="sd" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_Test_Extenal_Servervices/"/>
          </Parameter>
        </informations>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.RAC" Name="tim.now.testexternalservices.sub_processes.RAC" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.RAC">
      <Inputs Id="f244d0a2-a85c-4950-92df-bd80cfcc7cf2tim.now.testExternalServices_tim.now.testexternalservices.sub_processes.RAC_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.SECOLO" Name="tim.now.testexternalservices.sub_processes.SECOLO" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.SECOLO">
      <Inputs Id="75d73bd3-67c4-436e-9190-1d2e5bbf5746tim.now.testExternalServices_tim.now.testexternalservices.sub_processes.SECOLO_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.TTM" Name="tim.now.testexternalservices.sub_processes.TTM" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.TTM">
      <Inputs Id="1163dc95-c539-4e2f-bf0e-1f06e7715c3ftim.now.testExternalServices_tim.now.testexternalservices.sub_processes.TTM_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.testexternalservices.sub_processes.UNICAC" Name="tim.now.testexternalservices.sub_processes.UNICAC" ModelType="BW" moduleName="tim.now.testExternalServices">
    <Operation Name="callProcess" serviceName="tim.now.testexternalservices.sub_processes.UNICAC">
      <Inputs Id="f510bccb-89c8-426e-a7db-631570dc14cbtim.now.testExternalServices_tim.now.testexternalservices.sub_processes.UNICAC_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
