<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.StopNGo">
  <ProcessNode Id="Core.MainLogicTool" Name="Core.MainLogicTool" ModelType="BW" moduleName="tim.now.StopNGo">
    <Operation Name="callProcess" serviceName="Core.MainLogicTool">
      <Inputs Id="5083c24f-c192-411e-bc6d-0487963e27batim.now.StopNGo_Core.MainLogicTool_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Servizi.BonificaOLOUnicaC" Name="Servizi.BonificaOLOUnicaC" ModelType="BW" moduleName="tim.now.StopNGo">
    <Operation Name="callProcess" serviceName="Servizi.BonificaOLOUnicaC">
      <Inputs Id="2cfcc20c-7664-4722-8333-3b86a6d7e023tim.now.StopNGo_Servizi.BonificaOLOUnicaC_callProcess_StartBonifica_OloUnicaC" Name="StartBonifica_OloUnicaC" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Servizi.BonificaUnicaC" Name="Servizi.BonificaUnicaC" ModelType="BW" moduleName="tim.now.StopNGo">
    <Operation Name="callProcess" serviceName="Servizi.BonificaUnicaC">
      <Inputs Id="0062a197-021c-44e1-b1af-adee330f3150tim.now.StopNGo_Servizi.BonificaUnicaC_callProcess_StartBonifica_UnicaC" Name="StartBonifica_UnicaC" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Servizi.RichiestaCRM_Online" Name="Servizi.RichiestaCRM_Online" ModelType="BW" moduleName="tim.now.StopNGo">
    <Operation Name="callProcess" serviceName="Servizi.RichiestaCRM_Online">
      <Inputs Id="9e1b26db-22be-410b-8eb6-7bd98c1fff67tim.now.StopNGo_Servizi.RichiestaCRM_Online_callProcess_StartRichiestaCRM_Online" Name="StartRichiestaCRM_Online" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Servizi.RichiestaUnicaC" Name="Servizi.RichiestaUnicaC" ModelType="BW" moduleName="tim.now.StopNGo">
    <Operation Name="callProcess" serviceName="Servizi.RichiestaUnicaC">
      <Inputs Id="b4ade7db-4555-4b6b-9fee-fb2b0d62b498tim.now.StopNGo_Servizi.RichiestaUnicaC_callProcess_StartRichiestaUnicaC" Name="StartRichiestaUnicaC" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Staging.Staging_STAG_DATI_LINEA_CRM_RETAIL" Name="Staging.Staging_STAG_DATI_LINEA_CRM_RETAIL" ModelType="BW" moduleName="tim.now.StopNGo">
    <Operation Name="callProcess" serviceName="Staging.Staging_STAG_DATI_LINEA_CRM_RETAIL">
      <Inputs Id="652178b5-7cd9-4f4f-856a-dbc800add404tim.now.StopNGo_Staging.Staging_STAG_DATI_LINEA_CRM_RETAIL_callProcess_StartSTAG_DATI_LINEA_CRM_RETAIL" Name="StartSTAG_DATI_LINEA_CRM_RETAIL" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Staging.Staging_STAG_DATI_LINEA_UNICAC" Name="Staging.Staging_STAG_DATI_LINEA_UNICAC" ModelType="BW" moduleName="tim.now.StopNGo">
    <Operation Name="callProcess" serviceName="Staging.Staging_STAG_DATI_LINEA_UNICAC">
      <Inputs Id="506bbdeb-f8db-4ceb-b01a-dee4c41e82aftim.now.StopNGo_Staging.Staging_STAG_DATI_LINEA_UNICAC_callProcess_StartSTAG_DATI_LINEA_UNICAC" Name="StartSTAG_DATI_LINEA_UNICAC" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Tracking.ProcessoNoFile" Name="Tracking.ProcessoNoFile" ModelType="BW" moduleName="tim.now.StopNGo">
    <Operation Name="callProcess" serviceName="Tracking.ProcessoNoFile">
      <Inputs Id="5eba6547-b38f-4bb2-8d04-688d9577d422tim.now.StopNGo_Tracking.ProcessoNoFile_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Utils.RecuperaDistretto" Name="Utils.RecuperaDistretto" ModelType="BW" moduleName="tim.now.StopNGo">
    <Operation Name="callProcess" serviceName="Utils.RecuperaDistretto">
      <Inputs Id="60abead6-f501-4a0a-90df-5fa78b78ca2atim.now.StopNGo_Utils.RecuperaDistretto_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Utils.RetryBonificaUnicaC" Name="Utils.RetryBonificaUnicaC" ModelType="BW" moduleName="tim.now.StopNGo">
    <Operation Name="callProcess" serviceName="Utils.RetryBonificaUnicaC">
      <Inputs Id="9b3e6156-b93c-426a-b813-83a352317729tim.now.StopNGo_Utils.RetryBonificaUnicaC_callProcess_StartRetryBonificaUnicaC" Name="StartRetryBonificaUnicaC" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Utils.RetryCRM_Online" Name="Utils.RetryCRM_Online" ModelType="BW" moduleName="tim.now.StopNGo">
    <Operation Name="callProcess" serviceName="Utils.RetryCRM_Online">
      <Inputs Id="18340255-42b9-4103-b585-2edd24a516fatim.now.StopNGo_Utils.RetryCRM_Online_callProcess_StartRetryCRM_Online" Name="StartRetryCRM_Online" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Utils.RetryRichiestaUnicaC" Name="Utils.RetryRichiestaUnicaC" ModelType="BW" moduleName="tim.now.StopNGo">
    <Operation Name="callProcess" serviceName="Utils.RetryRichiestaUnicaC">
      <Inputs Id="edf1c413-31f6-4bb9-8815-a6692e455f6atim.now.StopNGo_Utils.RetryRichiestaUnicaC_callProcess_StartRetryRichiestaUnicaC" Name="StartRetryRichiestaUnicaC" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Utils.RunWorkItem" Name="Utils.RunWorkItem" ModelType="BW" moduleName="tim.now.StopNGo">
    <Operation Name="callProcess" serviceName="Utils.RunWorkItem">
      <Inputs Id="303bbbc8-39e7-47b0-ba01-d0bb69ea3b8ctim.now.StopNGo_Utils.RunWorkItem_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
