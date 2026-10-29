<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.migration_Unica-RA">
  <ProcessNode Id="tim.now.migration_unica-ra.ContaRecordDoublePipe" Name="tim.now.migration_unica-ra.ContaRecordDoublePipe" ModelType="BW" moduleName="tim.now.migration_Unica-RA">
    <Operation Name="ContaRecord" serviceName="ContaRecord">
      <Inputs Id="tim.now.migration_unica-ra.ContaRecordDoublePipe_ContaRecord_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.migration_unica-ra.DetailsControlMigrazioneIDSLUCO_TIM" Name="tim.now.migration_unica-ra.DetailsControlMigrazioneIDSLUCO_TIM" ModelType="BW" moduleName="tim.now.migration_Unica-RA">
    <Operation Name="ControlDetailIDSLUCO_TIM" serviceName="IDSLUCO_TIM">
      <Inputs Id="tim.now.migration_unica-ra.DetailsControlMigrazioneIDSLUCO_TIM_ControlDetailIDSLUCO_TIM_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.migration_unica-ra.DetailsControlMigrazioneIDULLCO_TIM" Name="tim.now.migration_unica-ra.DetailsControlMigrazioneIDULLCO_TIM" ModelType="BW" moduleName="tim.now.migration_Unica-RA">
    <Operation Name="ControlDetailIDULLCO_TIM" serviceName="IDULLCO_TIM">
      <Inputs Id="tim.now.migration_unica-ra.DetailsControlMigrazioneIDULLCO_TIM_ControlDetailIDULLCO_TIM_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.migration_unica-ra.ManagementErrorMigrazioneIDSLUCO_TIM" Name="tim.now.migration_unica-ra.ManagementErrorMigrazioneIDSLUCO_TIM" ModelType="BW" moduleName="tim.now.migration_Unica-RA">
    <Operation Name="ManagementErrorMigrazioneIDSLUCO_TIM" serviceName="ManagementErrorMigrazioneIDSLUCO_TIM">
      <Inputs Id="tim.now.migration_unica-ra.ManagementErrorMigrazioneIDSLUCO_TIM_ManagementErrorMigrazioneIDSLUCO_TIM_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.migration_unica-ra.ManagementErrorMigrazioneIDULLCO_TIM" Name="tim.now.migration_unica-ra.ManagementErrorMigrazioneIDULLCO_TIM" ModelType="BW" moduleName="tim.now.migration_Unica-RA">
    <Operation Name="ManagementErrorMigrazioneIDULLCO_TIM" serviceName="ManagementErrorMigrazioneIDULLCO_TIM">
      <Inputs Id="tim.now.migration_unica-ra.ManagementErrorMigrazioneIDULLCO_TIM_ManagementErrorMigrazioneIDULLCO_TIM_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
