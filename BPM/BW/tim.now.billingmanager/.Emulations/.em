<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.billingmanager">
  <ProcessNode Id="tim.now.bpmintegration.jpub.CODE_CAUSALE" Name="tim.now.bpmintegration.jpub.CODE_CAUSALE" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="callProcess" serviceName="tim.now.bpmintegration.jpub.CODE_CAUSALE">
      <Inputs Id="f9284bde-8bc9-4acc-9bc2-0067a8412054tim.now.billingmanager_tim.now.bpmintegration.jpub.CODE_CAUSALE_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.DeleteRecord" Name="tim.now.bpmintegration.jpub.DeleteRecord" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="DeleteRecord" serviceName="DeleteRecordPortType">
      <Inputs Id="0f359f0b-7c5e-4036-b80c-4f32ff0a42betim.now.billingmanager_tim.now.bpmintegration.jpub.DeleteRecord_DeleteRecord_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.DynamicProcess.Mapping_Interfaccia" Name="tim.now.bpmintegration.jpub.DynamicProcess.Mapping_Interfaccia" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="callProcess" serviceName="tim.now.bpmintegration.jpub.DynamicProcess.Mapping_Interfaccia">
      <Inputs Id="c928f02a-c33b-4601-bdc6-07bf551da9e8tim.now.billingmanager_tim.now.bpmintegration.jpub.DynamicProcess.Mapping_Interfaccia_callProcess_StartMapping_Interfaccia" Name="StartMapping_Interfaccia" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.DynamicProcess.Mapping_NGAXDSL" Name="tim.now.bpmintegration.jpub.DynamicProcess.Mapping_NGAXDSL" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="callProcess" serviceName="tim.now.bpmintegration.jpub.DynamicProcess.Mapping_NGAXDSL">
      <Inputs Id="fd92e31d-b733-4ee3-bc98-906d7182c2dctim.now.billingmanager_tim.now.bpmintegration.jpub.DynamicProcess.Mapping_NGAXDSL_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.DynamicProcess.Mapping_REGNP" Name="tim.now.bpmintegration.jpub.DynamicProcess.Mapping_REGNP" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="callProcess" serviceName="tim.now.bpmintegration.jpub.DynamicProcess.Mapping_REGNP">
      <Inputs Id="9bd86cd7-4107-41e8-96bb-f92cf2262855tim.now.billingmanager_tim.now.bpmintegration.jpub.DynamicProcess.Mapping_REGNP_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.ErrorJPUB.ErrorJPUBREG" Name="tim.now.bpmintegration.jpub.ErrorJPUB.ErrorJPUBREG" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="ErrorSchema" serviceName="ErrorSchemaPortType">
      <Inputs Id="tim.now.billingmanager_tim.now.bpmintegration.jpub.ErrorJPUB.ErrorJPUBREG_ErrorSchema_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.ErrorJPUB.ErrorJPUBXDSL" Name="tim.now.bpmintegration.jpub.ErrorJPUB.ErrorJPUBXDSL" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="ErrorSchema" serviceName="ErrorSchemaPortType">
      <Inputs Id="tim.now.billingmanager_tim.now.bpmintegration.jpub.ErrorJPUB.ErrorJPUBXDSL_ErrorSchema_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.ErrorJPUB.ErrorJPUB_ValorizzaPreventivo" Name="tim.now.bpmintegration.jpub.ErrorJPUB.ErrorJPUB_ValorizzaPreventivo" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="ErrorSchema" serviceName="ErrorSchemaPortType">
      <Inputs Id="tim.now.billingmanager_tim.now.bpmintegration.jpub.ErrorJPUB.ErrorJPUB_ValorizzaPreventivo_ErrorSchema_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.ErrorJPUB.ErrorOpereSpeciali" Name="tim.now.bpmintegration.jpub.ErrorJPUB.ErrorOpereSpeciali" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="ErrorSchema" serviceName="ErrorSchemaPortType">
      <Inputs Id="tim.now.billingmanager_tim.now.bpmintegration.jpub.ErrorJPUB.ErrorOpereSpeciali_ErrorSchema_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.InvokeJPUBNP" Name="tim.now.bpmintegration.jpub.InvokeJPUBNP" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="callProcess" serviceName="tim.now.bpmintegration.jpub.InvokeJPUBNP">
      <Inputs Id="6762c32b-9b41-4a97-88a0-34789254889ctim.now.billingmanager_tim.now.bpmintegration.jpub.InvokeJPUBNP_callProcess_StartInvokeJPUBNP" Name="StartInvokeJPUBNP" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.InvokeJPUB_WLR" Name="tim.now.bpmintegration.jpub.InvokeJPUB_WLR" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="callProcess" serviceName="tim.now.bpmintegration.jpub.InvokeJPUB_WLR">
      <Inputs Id="6e829bf3-4960-45d8-9535-dfa29408b25ftim.now.billingmanager_tim.now.bpmintegration.jpub.InvokeJPUB_WLR_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.JDBCQuery" Name="tim.now.bpmintegration.jpub.JDBCQuery" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="JDBCQuery" serviceName="JDBCQueryPortType">
      <Inputs Id="dac94dfd-0d43-4e4e-994f-43265f102fcftim.now.billingmanager_tim.now.bpmintegration.jpub.JDBCQuery_JDBCQuery_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.JPUB_Fatturazione" Name="tim.now.bpmintegration.jpub.JPUB_Fatturazione" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="BPM_Fatturazione" serviceName="BPM_callJPub">
      <Inputs Id="955615f5-33c8-4f14-8de3-db6298f1ff7dtim.now.billingmanager_tim.now.bpmintegration.jpub.JPUB_Fatturazione_BPM_Fatturazione_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="Invio_Fatturazione" serviceName="BPM_callJPub">
      <Inputs Id="261b549a-7430-41db-96db-6107a117ec4btim.now.billingmanager_tim.now.bpmintegration.jpub.JPUB_Fatturazione_Invio_Fatturazione_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.LavorazioniIndotte" Name="tim.now.bpmintegration.jpub.LavorazioniIndotte" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="LavorazioniIndotte" serviceName="LavorazioniIndottePortType">
      <Inputs Id="787b3a1e-4ad6-4599-85f9-6f9341aab6a8tim.now.billingmanager_tim.now.bpmintegration.jpub.LavorazioniIndotte_LavorazioniIndotte_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.MappingNGA_XDSL" Name="tim.now.bpmintegration.jpub.MappingNGA_XDSL" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="MappingNGA_XDSL" serviceName="MappingNGA_XDSLPortType">
      <Inputs Id="e648f309-fabc-4c76-b50d-6b4ccdc5687ctim.now.billingmanager_tim.now.bpmintegration.jpub.MappingNGA_XDSL_MappingNGA_XDSL_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.MappingREG_NP" Name="tim.now.bpmintegration.jpub.MappingREG_NP" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="MappingREG_NP" serviceName="MappingREG_NPPortType">
      <Inputs Id="5248c44f-dc37-40bb-bb66-be432304f4c2tim.now.billingmanager_tim.now.bpmintegration.jpub.MappingREG_NP_MappingREG_NP_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.MappingWLR" Name="tim.now.bpmintegration.jpub.MappingWLR" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="callProcess" serviceName="tim.now.bpmintegration.jpub.MappingWLR">
      <Inputs Id="16f0b56e-5217-48a1-80f6-5a3fd9b41459tim.now.billingmanager_tim.now.bpmintegration.jpub.MappingWLR_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.MigrazioneJPUB" Name="tim.now.bpmintegration.jpub.MigrazioneJPUB" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="callProcess" serviceName="tim.now.bpmintegration.jpub.MigrazioneJPUB">
      <Inputs Id="c882e8c7-3a6d-4d88-a4dc-1e14b2db7f12tim.now.billingmanager_tim.now.bpmintegration.jpub.MigrazioneJPUB_callProcess_StartMigrazioneJPUB" Name="StartMigrazioneJPUB" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.MigrazioneSubProcess" Name="tim.now.bpmintegration.jpub.MigrazioneSubProcess" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="callProcess" serviceName="tim.now.bpmintegration.jpub.MigrazioneSubProcess">
      <Inputs Id="030fdf47-6c40-4d6e-ab0f-6c02d144efa6tim.now.billingmanager_tim.now.bpmintegration.jpub.MigrazioneSubProcess_callProcess_StartSubProcessMigrazione" Name="StartSubProcessMigrazione" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.NomeOfferta" Name="tim.now.bpmintegration.jpub.NomeOfferta" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="NomeOfferta" serviceName="NomeOffertaPortType">
      <Inputs Id="2f1c4553-f099-4afa-a34d-e255c5a65c09tim.now.billingmanager_tim.now.bpmintegration.jpub.NomeOfferta_NomeOfferta_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.OpereSpeciali" Name="tim.now.bpmintegration.jpub.OpereSpeciali" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="OpereSpeciali" serviceName="OpereSpecialiPortType">
      <Inputs Id="f8e9641f-9956-4b19-bfbc-77516c1f67b1tim.now.billingmanager_tim.now.bpmintegration.jpub.OpereSpeciali_OpereSpeciali_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.OrderBilling" Name="tim.now.bpmintegration.jpub.OrderBilling" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="InvioEsitiRegolatorio" serviceName="NOW_JPUB_FatturazioneOrdini">
      <Inputs Id="tim.now.billingmanager_tim.now.bpmintegration.jpub.OrderBilling_InvioEsitiRegolatorio_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="InvioEsitiXDSL" serviceName="NOW_JPUB_FatturazioneOrdini">
      <Inputs Id="tim.now.billingmanager_tim.now.bpmintegration.jpub.OrderBilling_InvioEsitiXDSL_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.RecuperaAreaRaccolta" Name="tim.now.bpmintegration.jpub.RecuperaAreaRaccolta" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="RecuperaAreaRaccolta" serviceName="RecuperaAreaRaccoltaPortType">
      <Inputs Id="tim.now.billingmanager_tim.now.bpmintegration.jpub.RecuperaAreaRaccolta_RecuperaAreaRaccolta_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.SendMessageJPUB" Name="tim.now.bpmintegration.jpub.SendMessageJPUB" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="SendJPUB" serviceName="SendJPUB">
      <Inputs Id="tim.now.billingmanager_tim.now.bpmintegration.jpub.SendMessageJPUB_SendJPUB_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.SubProcess.MappingNGAXDSLMigrazione" Name="tim.now.bpmintegration.jpub.SubProcess.MappingNGAXDSLMigrazione" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="MappingNGA_XDSL" serviceName="MappingNGA_XDSLPortType">
      <Inputs Id="03aede53-90ec-4e87-86fe-0b415bf3f01ftim.now.billingmanager_tim.now.bpmintegration.jpub.SubProcess.MappingNGAXDSLMigrazione_MappingNGA_XDSL_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.SubProcess.MappingREG_NPMigrazione" Name="tim.now.bpmintegration.jpub.SubProcess.MappingREG_NPMigrazione" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="MappingREG_NP" serviceName="MappingREG_NPPortType">
      <Inputs Id="3f366371-c8fb-4276-9b69-bab1b9b17d29tim.now.billingmanager_tim.now.bpmintegration.jpub.SubProcess.MappingREG_NPMigrazione_MappingREG_NP_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.SubProcess.MappingWLRMigrazione" Name="tim.now.bpmintegration.jpub.SubProcess.MappingWLRMigrazione" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="callProcess" serviceName="tim.now.bpmintegration.jpub.SubProcess.MappingWLRMigrazione">
      <Inputs Id="26d8e74a-867c-44a5-9acf-732703fb3dc3tim.now.billingmanager_tim.now.bpmintegration.jpub.SubProcess.MappingWLRMigrazione_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.SubProcess.MigrationJDBC" Name="tim.now.bpmintegration.jpub.SubProcess.MigrationJDBC" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="JDBCQuery" serviceName="JDBCQueryPortType">
      <Inputs Id="97504c8a-d0e7-49f0-8815-7802582fbb96tim.now.billingmanager_tim.now.bpmintegration.jpub.SubProcess.MigrationJDBC_JDBCQuery_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.SubProcess.StatoFatturazioneMigrazione" Name="tim.now.bpmintegration.jpub.SubProcess.StatoFatturazioneMigrazione" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="callProcess" serviceName="tim.now.bpmintegration.jpub.SubProcess.StatoFatturazioneMigrazione">
      <Inputs Id="e4aaa124-d8b2-471e-9598-bcd4d11ec29atim.now.billingmanager_tim.now.bpmintegration.jpub.SubProcess.StatoFatturazioneMigrazione_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.SubProcess.StatoFatturazioneMigrazioneAttivazione" Name="tim.now.bpmintegration.jpub.SubProcess.StatoFatturazioneMigrazioneAttivazione" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="callProcess" serviceName="tim.now.bpmintegration.jpub.SubProcess.StatoFatturazioneMigrazioneAttivazione">
      <Inputs Id="15647e78-1845-4cfb-ab5f-9ea9b612d4a0tim.now.billingmanager_tim.now.bpmintegration.jpub.SubProcess.StatoFatturazioneMigrazioneAttivazione_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.SubProcessMigrazione" Name="tim.now.bpmintegration.jpub.SubProcessMigrazione" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="SubProcessMigrazione" serviceName="SubProcessMigrazionePortType">
      <Inputs Id="82f6d860-1318-4bbf-9df2-a727c09f8f95tim.now.billingmanager_tim.now.bpmintegration.jpub.SubProcessMigrazione_SubProcessMigrazione_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.UPDATEGestioneFatturazione" Name="tim.now.bpmintegration.jpub.UPDATEGestioneFatturazione" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="UPDATEGestioneFatturazione" serviceName="UPDATEGestioneFatturazionePortType">
      <Inputs Id="f13aa39d-72a9-42f0-9e4f-74065ba266b6tim.now.billingmanager_tim.now.bpmintegration.jpub.UPDATEGestioneFatturazione_UPDATEGestioneFatturazione_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.UpdateGestioneFatturazioneMigrazione" Name="tim.now.bpmintegration.jpub.UpdateGestioneFatturazioneMigrazione" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="callProcess" serviceName="tim.now.bpmintegration.jpub.UpdateGestioneFatturazioneMigrazione">
      <Inputs Id="f8be9df2-9ee9-4dde-9a71-cb78408e8cb1tim.now.billingmanager_tim.now.bpmintegration.jpub.UpdateGestioneFatturazioneMigrazione_callProcess_StartUPDATEGestioneFatturazioneMigrazione" Name="StartUPDATEGestioneFatturazioneMigrazione" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.bpmintegration.jpub.ValorizzaPreventivo" Name="tim.now.bpmintegration.jpub.ValorizzaPreventivo" ModelType="BW" moduleName="tim.now.billingmanager">
    <Operation Name="ValorizzaPreventivo" serviceName="ValorizzaPreventivoPortType">
      <Inputs Id="4f363110-837a-4562-ae19-25a927ac7aa9tim.now.billingmanager_tim.now.bpmintegration.jpub.ValorizzaPreventivo_ValorizzaPreventivo_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
