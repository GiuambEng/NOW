<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.timedRequestExposedService">
  <ProcessNode Id="ServiceTimedRequest.CreateRequestRicarica" Name="ServiceTimedRequest.CreateRequestRicarica" ModelType="BW" moduleName="tim.now.timedRequestExposedService">
    <Operation Name="callProcess" serviceName="ServiceTimedRequest.CreateRequestRicarica">
      <Inputs Id="2699d602-6a20-417d-9cd1-23abd2be37f3tim.now.timedRequestExposedService_ServiceTimedRequest.CreateRequestRicarica_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="ServiceTimedRequest.GestioneSospesoAppuntamento" Name="ServiceTimedRequest.GestioneSospesoAppuntamento" ModelType="BW" moduleName="tim.now.timedRequestExposedService">
    <Operation Name="callProcess" serviceName="ServiceTimedRequest.GestioneSospesoAppuntamento">
      <Inputs Id="ef49b6c0-b2e9-4d71-bff6-c14cda81287btim.now.timedRequestExposedService_ServiceTimedRequest.GestioneSospesoAppuntamento_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="ServiceTimedRequest.ServiceMainReceiver" Name="ServiceTimedRequest.ServiceMainReceiver" ModelType="BW" moduleName="tim.now.timedRequestExposedService">
    <Operation Name="GestioneSospesoAppuntamento" serviceName="ServiceTimedRequest">
      <Inputs Id="fc193138-9995-467a-9d66-23ac8a510c67tim.now.timedRequestExposedService_ServiceTimedRequest.ServiceMainReceiver_GestioneSospesoAppuntamento_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="CreateRequestRicarica" serviceName="ServiceTimedRequest">
      <Inputs Id="5db57284-e33b-4f08-99fe-b603ca2e84b2tim.now.timedRequestExposedService_ServiceTimedRequest.ServiceMainReceiver_CreateRequestRicarica_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
