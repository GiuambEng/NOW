<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.batch.alignment.module.JIVE">
  <ProcessNode Id="CreaFileScarto" Name="CreaFileScarto" ModelType="BW" moduleName="tim.now.batch.alignment.module.JIVE">
    <Operation Name="callProcess" serviceName="CreaFileScarto">
      <Inputs Id="tim.now.batch.alignment.module.JIVE_CreaFileScarto_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.batch.alignment.module.JIVE.AllineamentoAnagraficaCivici" Name="tim.now.batch.alignment.module.JIVE.AllineamentoAnagraficaCivici" ModelType="BW" moduleName="tim.now.batch.alignment.module.JIVE">
    <Operation Name="Invoke" serviceName="InterProcess_NumeriCivici">
      <Inputs Id="tim.now.batch.alignment.module.JIVE_tim.now.batch.alignment.module.JIVE.AllineamentoAnagraficaCivici_Invoke_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.batch.alignment.module.JIVE.AllineamentoAnagraficaComuneLocalita" Name="tim.now.batch.alignment.module.JIVE.AllineamentoAnagraficaComuneLocalita" ModelType="BW" moduleName="tim.now.batch.alignment.module.JIVE">
    <Operation Name="Invoke" serviceName="InterProcess_Comune">
      <Inputs Id="tim.now.batch.alignment.module.JIVE_tim.now.batch.alignment.module.JIVE.AllineamentoAnagraficaComuneLocalita_Invoke_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.batch.alignment.module.JIVE.AllineamentoAnagraficaPToponomastica" Name="tim.now.batch.alignment.module.JIVE.AllineamentoAnagraficaPToponomastica" ModelType="BW" moduleName="tim.now.batch.alignment.module.JIVE">
    <Operation Name="Invoke" serviceName="InterPorcess_PTopon">
      <Inputs Id="tim.now.batch.alignment.module.JIVE_tim.now.batch.alignment.module.JIVE.AllineamentoAnagraficaPToponomastica_Invoke_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.batch.alignment.module.JIVE.AllineamentoAnagraficaVariazAmm" Name="tim.now.batch.alignment.module.JIVE.AllineamentoAnagraficaVariazAmm" ModelType="BW" moduleName="tim.now.batch.alignment.module.JIVE">
    <Operation Name="Inovoke" serviceName="InterProcess_VarAmmnistrative">
      <Inputs Id="tim.now.batch.alignment.module.JIVE_tim.now.batch.alignment.module.JIVE.AllineamentoAnagraficaVariazAmm_Inovoke_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.ti.now.Jive.Interprocess.VarAmministrative/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.ti.now.Jive.Interprocess.VarAmministrative/"/>
          <nameSpaces prefix="tns0" nameSapce="www.tim.now.interprocess.jive.varamministrative"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:Input">
            <parameters Name="tns0:ProcessIstance" type="integer" nameSpace="www.tim.now.interprocess.jive.varamministrative"/>
            <parameters Name="tns0:COD_PROCSO_FILE" type="string" nameSpace="www.tim.now.interprocess.jive.varamministrative"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.batch.alignment.module.JIVE.AllineamentoAnagraficaVie" Name="tim.now.batch.alignment.module.JIVE.AllineamentoAnagraficaVie" ModelType="BW" moduleName="tim.now.batch.alignment.module.JIVE">
    <Operation Name="Invoke" serviceName="InterProcess_Vie">
      <Inputs Id="tim.now.batch.alignment.module.JIVE_tim.now.batch.alignment.module.JIVE.AllineamentoAnagraficaVie_Invoke_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.batch.alignment.module.JIVE.WaitForFileChange" Name="tim.now.batch.alignment.module.JIVE.WaitForFileChange" ModelType="BW" moduleName="tim.now.batch.alignment.module.JIVE">
    <Operation Name="callProcess" serviceName="tim.now.batch.alignment.module.JIVE.WaitForFileChange">
      <Inputs Id="tim.now.batch.alignment.module.JIVE_tim.now.batch.alignment.module.JIVE.WaitForFileChange_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaComuneLocalita" Name="tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaComuneLocalita" ModelType="BW" moduleName="tim.now.batch.alignment.module.JIVE">
    <Operation Name="Invoke" serviceName="ComuneLocalita">
      <Inputs Id="tim.now.batch.alignment.module.JIVE_tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaComuneLocalita_Invoke_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaNumeriCivici" Name="tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaNumeriCivici" ModelType="BW" moduleName="tim.now.batch.alignment.module.JIVE">
    <Operation Name="Invoke" serviceName="NumeriCivici">
      <Inputs Id="tim.now.batch.alignment.module.JIVE_tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaNumeriCivici_Invoke_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaPToponomastica" Name="tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaPToponomastica" ModelType="BW" moduleName="tim.now.batch.alignment.module.JIVE">
    <Operation Name="Invoke" serviceName="Ptoponomastica">
      <Inputs Id="tim.now.batch.alignment.module.JIVE_tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaPToponomastica_Invoke_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaProvince" Name="tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaProvince" ModelType="BW" moduleName="tim.now.batch.alignment.module.JIVE">
    <Operation Name="Invoke" serviceName="Province">
      <Inputs Id="tim.now.batch.alignment.module.JIVE_tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaProvince_Invoke_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaVariazioniAmministrative" Name="tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaVariazioniAmministrative" ModelType="BW" moduleName="tim.now.batch.alignment.module.JIVE">
    <Operation Name="Invoke" serviceName="VarAmm">
      <Inputs Id="tim.now.batch.alignment.module.JIVE_tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaVariazioniAmministrative_Invoke_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaVie" Name="tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaVie" ModelType="BW" moduleName="tim.now.batch.alignment.module.JIVE">
    <Operation Name="Invoke" serviceName="Vie">
      <Inputs Id="tim.now.batch.alignment.module.JIVE_tim.now.batch.alignment.module.JIVE.sub_AllineamentoAnagraficaVie_Invoke_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
