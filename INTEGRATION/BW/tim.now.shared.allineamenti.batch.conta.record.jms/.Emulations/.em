<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.shared.allineamenti.batch.conta.record">
  <ProcessNode Id="tim.now.shared.allineamenti.batch.conta.record.AllineamentoContaRecord" Name="tim.now.shared.allineamenti.batch.conta.record.AllineamentoContaRecord" ModelType="BW" moduleName="tim.now.shared.allineamenti.batch.conta.record">
    <Operation Name="ContaRecord" serviceName="Conta">
      <Inputs Id="tim.now.shared.allineamenti.batch.conta.record_tim.now.shared.allineamenti.batch.conta.record.AllineamentoContaRecord_ContaRecord_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tibco.com/AllineamentoBatch/ContaRecord/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tibco.com/AllineamentoBatch/ContaRecord/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tim.com/NOW/AllineamentiBatch/contaRecord/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:contaRecord_Input">
            <parameters Name="tns0:in" Value="C:\Users\Integris\Desktop\Diogene_File\RgN_TO_NOW_20000105.txt" type="string" nameSpace="http://www.tim.com/NOW/AllineamentiBatch/contaRecord/">
              <parent Name="contaRecordInput_type" nameSpace="http://www.tim.com/NOW/AllineamentiBatch/contaRecord/"/>
            </parameters>
            <parameters Name="tns0:TipoSeparatore" Value="ContaRecord_PipeCancelletto_Retail" type="string" nameSpace="http://www.tim.com/NOW/AllineamentiBatch/contaRecord/">
              <parent Name="contaRecordInput_type" nameSpace="http://www.tim.com/NOW/AllineamentiBatch/contaRecord/"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.shared.allineamenti.batch.conta.record.ContaRecord_DoppioPipe" Name="tim.now.shared.allineamenti.batch.conta.record.ContaRecord_DoppioPipe" ModelType="BW" moduleName="tim.now.shared.allineamenti.batch.conta.record">
    <Operation Name="Atomic" serviceName="ContaRecord_DoppioPipe">
      <Inputs Id="tim.now.shared.allineamenti.batch.conta.record_tim.now.shared.allineamenti.batch.conta.record.ContaRecord_DoppioPipe_Atomic_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.shared.allineamenti.batch.conta.record.ContaRecord_PipeCancelletto" Name="tim.now.shared.allineamenti.batch.conta.record.ContaRecord_PipeCancelletto" ModelType="BW" moduleName="tim.now.shared.allineamenti.batch.conta.record">
    <Operation Name="Atomic" serviceName="ContaRecord_PipeCancelletto">
      <Inputs Id="tim.now.shared.allineamenti.batch.conta.record_tim.now.shared.allineamenti.batch.conta.record.ContaRecord_PipeCancelletto_Atomic_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.shared.allineamenti.batch.conta.record.ContaRecord_PipeCancelletto_Retail" Name="tim.now.shared.allineamenti.batch.conta.record.ContaRecord_PipeCancelletto_Retail" ModelType="BW" moduleName="tim.now.shared.allineamenti.batch.conta.record">
    <Operation Name="Atomic" serviceName="ContaRecord_PipeCancelletto_Retail">
      <Inputs Id="tim.now.shared.allineamenti.batch.conta.record_tim.now.shared.allineamenti.batch.conta.record.ContaRecord_PipeCancelletto_Retail_Atomic_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.shared.allineamenti.batch.conta.record.ContaRecord_Virgola" Name="tim.now.shared.allineamenti.batch.conta.record.ContaRecord_Virgola" ModelType="BW" moduleName="tim.now.shared.allineamenti.batch.conta.record">
    <Operation Name="Atomic" serviceName="ContaRecord_Virgola">
      <Inputs Id="tim.now.shared.allineamenti.batch.conta.record_tim.now.shared.allineamenti.batch.conta.record.ContaRecord_Virgola_Atomic_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.shared.allineamenti.batch.conta.record.DinamicConta" Name="tim.now.shared.allineamenti.batch.conta.record.DinamicConta" ModelType="BW" moduleName="tim.now.shared.allineamenti.batch.conta.record">
    <Operation Name="Atomic" serviceName="Dinamic_Conta">
      <Inputs Id="tim.now.shared.allineamenti.batch.conta.record_tim.now.shared.allineamenti.batch.conta.record.DinamicConta_Atomic_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.shared.allineamenti.batch.conta.record.ContaRecord_Interrogativo" Name="tim.now.shared.allineamenti.batch.conta.record.ContaRecord_Interrogativo" ModelType="BW" moduleName="tim.now.shared.allineamenti.batch.conta.record">
    <Operation Name="operation" serviceName="Service">
      <Inputs Id="tim.now.shared.allineamenti.batch.conta.record_tim.now.shared.allineamenti.batch.conta.record.ContaRecord_Interrogativo_operation_operationInput" Name="operationInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
