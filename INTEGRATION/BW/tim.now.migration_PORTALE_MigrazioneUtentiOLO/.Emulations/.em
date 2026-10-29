<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.migration_PORTALE_MigrazioneUtentiOLO">
  <ProcessNode Id="tim.now.migration_Common.ContaRecordDoublePipe" Name="tim.now.migration_Common.ContaRecordDoublePipe" ModelType="BW" moduleName="tim.now.migration_PORTALE_MigrazioneUtentiOLO">
    <Operation Name="ContaRecord" serviceName="ContaRecord">
      <Inputs Id="tim.now.migration_Common.ContaRecordDoublePipe_ContaRecord_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.migration_Portale.DetailsControlMigrazionePortafoglioAM" Name="tim.now.migration_Portale.DetailsControlMigrazionePortafoglioAM" ModelType="BW" moduleName="tim.now.migration_PORTALE_MigrazioneUtentiOLO">
    <Operation Name="MigrazionePortafoglioAM" serviceName="MigrazionePortafoglioAM">
      <Inputs Id="tim.now.migration_Portale.DetailsControlMigrazionePortafoglioAM_MigrazionePortafoglioAM_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.migration_Portale.DetailsControlMigrazioneUtentiOLO" Name="tim.now.migration_Portale.DetailsControlMigrazioneUtentiOLO" ModelType="BW" moduleName="tim.now.migration_PORTALE_MigrazioneUtentiOLO">
    <Operation Name="UtentiOLO" serviceName="UtentiOLO">
      <Inputs Id="tim.now.migration_Portale.DetailsControlMigrazioneUtentiOLO_UtentiOLO_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.migration_Portale.DetailsControlMigrazioneUtentiTI" Name="tim.now.migration_Portale.DetailsControlMigrazioneUtentiTI" ModelType="BW" moduleName="tim.now.migration_PORTALE_MigrazioneUtentiOLO">
    <Operation Name="UtentiTI" serviceName="UtentiTI">
      <Inputs Id="tim.now.migration_Portale.DetailsControlMigrazioneUtentiTI_UtentiTI_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.migration_Portale.ManagementErrorPortafoglioAM" Name="tim.now.migration_Portale.ManagementErrorPortafoglioAM" ModelType="BW" moduleName="tim.now.migration_PORTALE_MigrazioneUtentiOLO">
    <Operation Name="ManagementErrorDBPortafoglioAM" serviceName="ManagementErrorDBPortafoglioAM">
      <Inputs Id="tim.now.migration_Portale.ManagementErrorPortafoglioAM_ManagementErrorDBPortafoglioAM_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.migration_Portale.ManagementErrorUtentiOLO" Name="tim.now.migration_Portale.ManagementErrorUtentiOLO" ModelType="BW" moduleName="tim.now.migration_PORTALE_MigrazioneUtentiOLO">
    <Operation Name="ManagementErrorDBUtentiOLO" serviceName="ManagementErrorDBUtentiOLO">
      <Inputs Id="tim.now.migration_Portale.ManagementErrorUtentiOLO_ManagementErrorDBUtentiOLO_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.migration_Portale.ManagementErrorUtentiTI" Name="tim.now.migration_Portale.ManagementErrorUtentiTI" ModelType="BW" moduleName="tim.now.migration_PORTALE_MigrazioneUtentiOLO">
    <Operation Name="ManagementErrorDBUtentiTI" serviceName="ManagementErrorDBUtentiTI">
      <Inputs Id="tim.now.migration_Portale.ManagementErrorUtentiTI_ManagementErrorDBUtentiTI_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
