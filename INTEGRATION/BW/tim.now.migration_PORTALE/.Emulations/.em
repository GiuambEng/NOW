<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.migration_PORTALE">
  <ProcessNode Id="Common.ContaRecord" Name="Common.ContaRecord" ModelType="BW" moduleName="tim.now.migration_PORTALE">
    <Operation Name="ContaRecord" serviceName="ContaRecord">
      <Inputs Id="tim.now.migration_PORTALE_Common.ContaRecord_ContaRecord_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Portale.DetailsAcronimiMapping" Name="Portale.DetailsAcronimiMapping" ModelType="BW" moduleName="tim.now.migration_PORTALE">
    <Operation Name="AcronimiMapping" serviceName="AcronimiMapping">
      <Inputs Id="tim.now.migration_PORTALE_Portale.DetailsAcronimiMapping_AcronimiMapping_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Portale.ManagementErrorAcronimiMapping" Name="Portale.ManagementErrorAcronimiMapping" ModelType="BW" moduleName="tim.now.migration_PORTALE">
    <Operation Name="NOW_PORTALE_AcronimiMapping" serviceName="NOW_PORTALE_AcronimiMapping">
      <Inputs Id="tim.now.migration_PORTALE_Portale.ManagementErrorAcronimiMapping_NOW_PORTALE_AcronimiMapping_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Portale_Codici.ControlloDettagliCodiciProgetto" Name="Portale_Codici.ControlloDettagliCodiciProgetto" ModelType="BW" moduleName="tim.now.migration_PORTALE">
    <Operation Name="DetailControl" serviceName="DetailControl_MigrazioneCodiciProgetto">
      <Inputs Id="tim.now.migration_PORTALE_Portale_Codici.ControlloDettagliCodiciProgetto_DetailControl_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Portale_Codici.ManagementErroreCodiciProgetto" Name="Portale_Codici.ManagementErroreCodiciProgetto" ModelType="BW" moduleName="tim.now.migration_PORTALE">
    <Operation Name="ManagementeErrorDBMigrazioneCodiciProgetto" serviceName="ManagementeErrorDBMigrazioneCodiciProgetto">
      <Inputs Id="tim.now.migration_PORTALE_Portale_Codici.ManagementErroreCodiciProgetto_ManagementeErrorDBMigrazioneCodiciProgetto_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
