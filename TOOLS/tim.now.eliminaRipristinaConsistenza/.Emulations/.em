<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.eliminaRipristinaConsistenza">
  <ProcessNode Id="eliminaripristinaconsistenza.MovimentazioneConsistenza" Name="eliminaripristinaconsistenza.MovimentazioneConsistenza" ModelType="BW" moduleName="tim.now.eliminaRipristinaConsistenza">
    <Operation Name="callProcess" serviceName="eliminaripristinaconsistenza.MovimentazioneConsistenza">
      <Inputs Id="1d5cf40f-5950-402a-a36f-37418b6a88c2tim.now.eliminaRipristinaConsistenza_eliminaripristinaconsistenza.MovimentazioneConsistenza_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="eliminaripristinaconsistenza.ValidazioneDatiInStaging" Name="eliminaripristinaconsistenza.ValidazioneDatiInStaging" ModelType="BW" moduleName="tim.now.eliminaRipristinaConsistenza">
    <Operation Name="callProcess" serviceName="eliminaripristinaconsistenza.ValidazioneDatiInStaging">
      <Inputs Id="f850f44f-db8c-4d48-bf3e-86d0cec31272tim.now.eliminaRipristinaConsistenza_eliminaripristinaconsistenza.ValidazioneDatiInStaging_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
