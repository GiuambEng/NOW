<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.online.module.alignment">
  <ProcessNode Id="tim.now.online.module.aligment.RETAIL.AllineamentRetail" Name="tim.now.online.module.aligment.RETAIL.AllineamentRetail" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="AllineamentoRetail" serviceName="NOWAllineamentiRetail">
      <Inputs Id="5300f837-b14b-4245-b951-d0fe7ec1f51ctim.now.online.module.alignment_tim.now.online.module.aligment.RETAIL.AllineamentRetail_AllineamentoRetail_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.aligment.RETAIL.SubStagingRetail" Name="tim.now.online.module.aligment.RETAIL.SubStagingRetail" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.aligment.RETAIL.SubStagingRetail">
      <Inputs Id="366a3518-32d1-4ce5-8f10-ebe17408e717tim.now.online.module.alignment_tim.now.online.module.aligment.RETAIL.SubStagingRetail_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.aligment.RETAIL.Sub_AllineamentRetail" Name="tim.now.online.module.aligment.RETAIL.Sub_AllineamentRetail" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="AllineamentoRetail" serviceName="NOWAllineamentiRetail">
      <Inputs Id="f7eb38a8-d215-4066-877f-af8489398de1tim.now.online.module.alignment_tim.now.online.module.aligment.RETAIL.Sub_AllineamentRetail_AllineamentoRetail_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.aligment.RETAIL.Sub_AssetRisorsa" Name="tim.now.online.module.aligment.RETAIL.Sub_AssetRisorsa" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.aligment.RETAIL.Sub_AssetRisorsa">
      <Inputs Id="5edba2a6-b074-44b6-819c-4a9626a905f7tim.now.online.module.alignment_tim.now.online.module.aligment.RETAIL.Sub_AssetRisorsa_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.aligment.RETAIL.Sub_GetInfoTopo_OffertaDati_InfoReferente" Name="tim.now.online.module.aligment.RETAIL.Sub_GetInfoTopo_OffertaDati_InfoReferente" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.aligment.RETAIL.Sub_GetInfoTopo_OffertaDati_InfoReferente">
      <Inputs Id="6edb91da-afbd-498e-b68a-5e488fa8dc74tim.now.online.module.alignment_tim.now.online.module.aligment.RETAIL.Sub_GetInfoTopo_OffertaDati_InfoReferente_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.aligment.RETAIL.Sub_TipoLineaNP_VariatoN" Name="tim.now.online.module.aligment.RETAIL.Sub_TipoLineaNP_VariatoN" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.aligment.RETAIL.Sub_TipoLineaNP_VariatoN">
      <Inputs Id="fc881668-d240-4f27-94f4-5a1d74c48c2btim.now.online.module.alignment_tim.now.online.module.aligment.RETAIL.Sub_TipoLineaNP_VariatoN_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.aligment.RETAIL.Sub_TipoLineaNP_VariatoY" Name="tim.now.online.module.aligment.RETAIL.Sub_TipoLineaNP_VariatoY" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.aligment.RETAIL.Sub_TipoLineaNP_VariatoY">
      <Inputs Id="7e2685e2-6e91-4a32-962c-e4b1da08bcedtim.now.online.module.alignment_tim.now.online.module.aligment.RETAIL.Sub_TipoLineaNP_VariatoY_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.aligment.RETAIL.Sub_VerificaRisorsa" Name="tim.now.online.module.aligment.RETAIL.Sub_VerificaRisorsa" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.aligment.RETAIL.Sub_VerificaRisorsa">
      <Inputs Id="d4aa9af5-f99e-47f6-88e6-f65198d7dd7atim.now.online.module.alignment_tim.now.online.module.aligment.RETAIL.Sub_VerificaRisorsa_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.aligment.RETAIL.Sub_VerificaRisorsaDIN" Name="tim.now.online.module.aligment.RETAIL.Sub_VerificaRisorsaDIN" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.aligment.RETAIL.Sub_VerificaRisorsaDIN">
      <Inputs Id="68be589d-9053-4bb8-8956-907407fb5c7atim.now.online.module.alignment_tim.now.online.module.aligment.RETAIL.Sub_VerificaRisorsaDIN_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Common.GestioneErrore" Name="tim.now.online.module.alignment.Common.GestioneErrore" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="Invoke" serviceName="GenericError">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Common.GestioneErrore_Invoke_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Common.ProcessIstance" Name="tim.now.online.module.alignment.Common.ProcessIstance" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Common.ProcessIstance">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Common.ProcessIstance_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Common.Sub_AllineamentiRetail" Name="tim.now.online.module.alignment.Common.Sub_AllineamentiRetail" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Common.Sub_AllineamentiRetail">
      <Inputs Id="dee9b31c-978f-4cef-9df9-d9ca294bc44btim.now.online.module.alignment_tim.now.online.module.alignment.Common.Sub_AllineamentiRetail_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Common.Sub_AllineamentoPortale" Name="tim.now.online.module.alignment.Common.Sub_AllineamentoPortale" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Common.Sub_AllineamentoPortale">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Common.Sub_AllineamentoPortale_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Common.Sub_DBSSError_AggiornamentoConsistenza" Name="tim.now.online.module.alignment.Common.Sub_DBSSError_AggiornamentoConsistenza" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Common.Sub_DBSSError_AggiornamentoConsistenza">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Common.Sub_DBSSError_AggiornamentoConsistenza_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Common.Sub_Hal_Error" Name="tim.now.online.module.alignment.Common.Sub_Hal_Error" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Common.Sub_Hal_Error">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Common.Sub_Hal_Error_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Common.Sub_JpubError_AllineamentoMassivoAnag" Name="tim.now.online.module.alignment.Common.Sub_JpubError_AllineamentoMassivoAnag" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Common.Sub_JpubError_AllineamentoMassivoAnag">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Common.Sub_JpubError_AllineamentoMassivoAnag_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Common.Sub_JpubError_AllineamentoMassivoAnagJMS" Name="tim.now.online.module.alignment.Common.Sub_JpubError_AllineamentoMassivoAnagJMS" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Common.Sub_JpubError_AllineamentoMassivoAnagJMS">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Common.Sub_JpubError_AllineamentoMassivoAnagJMS_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Common.Sub_PatrocloError" Name="tim.now.online.module.alignment.Common.Sub_PatrocloError" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Common.Sub_PatrocloError">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Common.Sub_PatrocloError_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Common.Sub_PortaleError_GestioneSegnalazione" Name="tim.now.online.module.alignment.Common.Sub_PortaleError_GestioneSegnalazione" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Common.Sub_PortaleError_GestioneSegnalazione">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Common.Sub_PortaleError_GestioneSegnalazione_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Common.Sub_SDRError_VerificaRisorsa" Name="tim.now.online.module.alignment.Common.Sub_SDRError_VerificaRisorsa" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Common.Sub_SDRError_VerificaRisorsa">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Common.Sub_SDRError_VerificaRisorsa_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.DBSS.Consistenza_DBSS" Name="tim.now.online.module.alignment.DBSS.Consistenza_DBSS" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="AggiornamentoConsistenza" serviceName="NOWConsistenzaDBSS">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.DBSS.Consistenza_DBSS_AggiornamentoConsistenza_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="xs:" nameSpaceValue="http://www.tibco.com/NOWConsistenzaDBSS/" nameSpace="xmlns:xs" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tibco.com/NOWConsistenzaDBSS/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:NOWConsistenzaDBSS_Request" Value="&#xA;  ">
            <parameters Name="tns0:TRANSACTION_ID" Value="123456" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS"/>
            <parameters Name="tns0:TRANSACTION_DATE" Value="2016-08-29T16:38:00.000" type="dateTime" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS"/>
            <parameters Name="tns0:Sistema_Competenza" Value="DBSS" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS"/>
            <parameters Name="tns0:ACCESSO" Value="&#xA;    ">
              <parameters Name="tns0:Data_dec" Value="2016-08-29" type="date" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS"/>
              <parameters Name="tns0:Ora_dec" Value="16:38:00.000" type="time" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS"/>
              <parameters Name="tns0:ID_Risorsa" Value="testRetail01" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS"/>
              <parameters Name="tns0:Numero_Telefonico" Value="327123456" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS"/>
              <parameters Name="tns0:ID_Risorsa_OLD" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
              <parameters Name="tns0:Numero_Telefonico_OLD" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
              <parameters Name="tns0:Stato_Asset" Value="ATTIVO" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS"/>
              <parameters Name="tns0:Flag_FTTH" Value="Y" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS"/>
              <parameters Name="tns0:Destinazione_Uso" Value="3" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
              <parameters Name="tns0:Famiglia_Tecnica" Value="UltraBroadband" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
              <parameters Name="tns0:Numero_nativo_olo" Value="12345" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
              <parameters Name="tns0:Distretto_Telefonico" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS"/>
            </parameters>
            <parameters Name="tns0:CLIENTE" Value="&#xA;    ">
              <parameters Name="tns0:CognomeRagioneSociale" Value="test" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS"/>
            </parameters>
            <parameters Name="tns0:SEDE" Value="&#xA;    ">
              <parameters Name="tns0:Particella_Toponomastica" Value="VIA" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
              <parameters Name="tns0:Indirizzo" Value="DEI LAUREI" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
              <parameters Name="tns0:Civico" Value="3" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
              <parameters Name="tns0:Localita" Value="ROMA" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
              <parameters Name="tns0:Complesso" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
              <parameters Name="tns0:Scala" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
              <parameters Name="tns0:Piano" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
              <parameters Name="tns0:Interno" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
              <parameters Name="tns0:Codice_Comune" Value="1" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
              <parameters Name="tns0:Codice_Via" Value="12" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
              <parameters Name="tns0:Codice_Provincia" Value="RM" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
              <parameters Name="tns0:Indirizzo_non_certificato" type="string" nameSpace="http://www.example.org/tim.now.xsd.NOWConsistenzaDBSS" canDelete="true"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.DBSS.Sub_Staging" Name="tim.now.online.module.alignment.DBSS.Sub_Staging" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.DBSS.Sub_Staging">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.DBSS.Sub_Staging_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.DBSS.Sub_ValorizzazioneAttributoOfferta" Name="tim.now.online.module.alignment.DBSS.Sub_ValorizzazioneAttributoOfferta" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.DBSS.Sub_ValorizzazioneAttributoOfferta">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.DBSS.Sub_ValorizzazioneAttributoOfferta_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.DBSS.Update_Asset" Name="tim.now.online.module.alignment.DBSS.Update_Asset" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.DBSS.Update_Asset">
      <Inputs Id="667c8ada-45f6-42af-ad73-9f7325847cc3tim.now.online.module.alignment_tim.now.online.module.alignment.DBSS.Update_Asset_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.DTU.VerificaIdRisorsaMetroweb" Name="tim.now.online.module.alignment.DTU.VerificaIdRisorsaMetroweb" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="VerificaRisorsaDTUNOW" serviceName="Tracciati_Verifica_Risorsa_DTU_NOWType">
      <Inputs Id="816672e9-a830-4d66-9110-44b2328cfd99tim.now.online.module.alignment_tim.now.online.module.alignment.DTU.VerificaIdRisorsaMetroweb_VerificaRisorsaDTUNOW_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.DTU.sub_Staging" Name="tim.now.online.module.alignment.DTU.sub_Staging" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.DTU.sub_Staging">
      <Inputs Id="cd74feb2-7c65-46c6-bcd3-fb8cd8e2e3d9tim.now.online.module.alignment_tim.now.online.module.alignment.DTU.sub_Staging_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Hal.RichiestaOL" Name="tim.now.online.module.alignment.Hal.RichiestaOL" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="NOW_HAL_OL" serviceName="NOW_HAL_OLincorso">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Hal.RichiestaOL_NOW_HAL_OL_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="xs:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_OL_RichiestaOLincorso/" nameSpace="xmlns:xs" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_OL_RichiestaOLincorso/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_HAL_OL_RichiestaOLincorso/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/NOW_HAL_OL/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_HAL_OL_Request" Value="&#xA;  ">
            <parameters Name="tns1:Distretto" Value="0144" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL_OL/" canDelete="true"/>
            <parameters Name="tns1:ID_RISORSA" Value="321" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL_OL/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Hal.RichiestaOL_NOW_HAL_OL_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_OL_RichiestaOLincorso/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_OL_RichiestaOLincorso/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_HAL_OL_RichiestaOLincorso/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/NOW_HAL_OL/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_HAL_OL_Request">
            <parameters Name="tns1:Distretto" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL_OL/" canDelete="true"/>
            <parameters Name="tns1:ID_RISORSA" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL_OL/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Hal.RichiestaOL_NOW_HAL_OL_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_OL_RichiestaOLincorso/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_OL_RichiestaOLincorso/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_HAL_OL_RichiestaOLincorso/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/NOW_HAL_OL/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_HAL_OL_Request">
            <parameters Name="tns1:Distretto" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL_OL/" canDelete="true"/>
            <parameters Name="tns1:ID_RISORSA" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL_OL/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Hal.RichiestaOL_NOW_HAL_OL_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_OL_RichiestaOLincorso/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_OL_RichiestaOLincorso/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_HAL_OL_RichiestaOLincorso/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/NOW_HAL_OL/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_HAL_OL_Request">
            <parameters Name="tns1:Distretto" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL_OL/" canDelete="true"/>
            <parameters Name="tns1:ID_RISORSA" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL_OL/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Hal.RichiestaQuadratura" Name="tim.now.online.module.alignment.Hal.RichiestaQuadratura" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="NOW_HAL_QUADRATURA" serviceName="NOW_HAL_RichiestaQuadratura">
      <Inputs Id="0cc8fa38-0672-4214-ad9c-57da3a89749btim.now.online.module.alignment_tim.now.online.module.alignment.Hal.RichiestaQuadratura_NOW_HAL_QUADRATURA_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Hal.RishiestaDatiTecniciConsistenza" Name="tim.now.online.module.alignment.Hal.RishiestaDatiTecniciConsistenza" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="NOW_HAL" serviceName="NOW_HAL_RichiestaDatiTecniciConsistenza">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Hal.RishiestaDatiTecniciConsistenza_NOW_HAL_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_RichiestaDatiTecniciConsistenza/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_RichiestaDatiTecniciConsistenza/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_HAL_RichiestaDatiTecniciConsistenza/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/NOW_HAL/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_HAL_Request">
            <parameters Name="tns1:Distretto" Value="0144" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL/" canDelete="true"/>
            <parameters Name="tns1:ID_RISORSA" Value="123" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Hal.RishiestaDatiTecniciConsistenza_NOW_HAL_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_RichiestaDatiTecniciConsistenza/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_RichiestaDatiTecniciConsistenza/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_HAL_RichiestaDatiTecniciConsistenza/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/NOW_HAL/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_HAL_Request">
            <parameters Name="tns1:Distretto" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL/" canDelete="true"/>
            <parameters Name="tns1:ID_RISORSA" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Hal.Sub_FindCaseAsset" Name="tim.now.online.module.alignment.Hal.Sub_FindCaseAsset" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Hal.Sub_FindCaseAsset">
      <Inputs Id="1bd3eb53-4e7a-43ef-82a9-864e19e63cf1tim.now.online.module.alignment_tim.now.online.module.alignment.Hal.Sub_FindCaseAsset_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Hal.Sub_OLInCorso" Name="tim.now.online.module.alignment.Hal.Sub_OLInCorso" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="NOW_HAL_OL" serviceName="NOW_HAL_OLincorso">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Hal.Sub_OLInCorso_NOW_HAL_OL_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="xs:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_OL_RichiestaOLincorso/" nameSpace="xmlns:xs" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_OL_RichiestaOLincorso/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_HAL_OL_RichiestaOLincorso/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/NOW_HAL_OL/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_HAL_OL_Request" Value="&#xA;  ">
            <parameters Name="tns1:Distretto" Value="0144" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL_OL/" canDelete="true"/>
            <parameters Name="tns1:ID_RISORSA" Value="321" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL_OL/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Hal.Sub_OLInCorso_NOW_HAL_OL_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_OL_RichiestaOLincorso/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_OL_RichiestaOLincorso/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_HAL_OL_RichiestaOLincorso/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/NOW_HAL_OL/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_HAL_OL_Request">
            <parameters Name="tns1:Distretto" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL_OL/" canDelete="true"/>
            <parameters Name="tns1:ID_RISORSA" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL_OL/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Hal.Sub_OLInCorso_NOW_HAL_OL_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_OL_RichiestaOLincorso/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_OL_RichiestaOLincorso/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_HAL_OL_RichiestaOLincorso/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/NOW_HAL_OL/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_HAL_OL_Request">
            <parameters Name="tns1:Distretto" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL_OL/" canDelete="true"/>
            <parameters Name="tns1:ID_RISORSA" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL_OL/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Hal.Sub_OLInCorso_NOW_HAL_OL_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_OL_RichiestaOLincorso/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_OL_RichiestaOLincorso/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_HAL_OL_RichiestaOLincorso/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/NOW_HAL_OL/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_HAL_OL_Request">
            <parameters Name="tns1:Distretto" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL_OL/" canDelete="true"/>
            <parameters Name="tns1:ID_RISORSA" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL_OL/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Hal.Sub_RichiestaQuadratura" Name="tim.now.online.module.alignment.Hal.Sub_RichiestaQuadratura" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="NOW_HAL_QUADRATURA" serviceName="NOW_HAL_RichiestaQuadratura">
      <Inputs Id="46265aea-3db9-4264-aada-c8b3f1644ca2tim.now.online.module.alignment_tim.now.online.module.alignment.Hal.Sub_RichiestaQuadratura_NOW_HAL_QUADRATURA_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Hal.Sub_VerificaRichiestaDati" Name="tim.now.online.module.alignment.Hal.Sub_VerificaRichiestaDati" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="NOW_HAL" serviceName="NOW_HAL_RichiestaDatiTecniciConsistenza">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Hal.Sub_VerificaRichiestaDati_NOW_HAL_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_RichiestaDatiTecniciConsistenza/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_RichiestaDatiTecniciConsistenza/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_HAL_RichiestaDatiTecniciConsistenza/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/NOW_HAL/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_HAL_Request">
            <parameters Name="tns1:Distretto" Value="0144" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL/" canDelete="true"/>
            <parameters Name="tns1:ID_RISORSA" Value="123" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Hal.Sub_VerificaRichiestaDati_NOW_HAL_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_RichiestaDatiTecniciConsistenza/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_HAL_RichiestaDatiTecniciConsistenza/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_HAL_RichiestaDatiTecniciConsistenza/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/NOW_HAL/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_HAL_Request">
            <parameters Name="tns1:Distretto" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL/" canDelete="true"/>
            <parameters Name="tns1:ID_RISORSA" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOW_HAL/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Hal.sub_Staging" Name="tim.now.online.module.alignment.Hal.sub_Staging" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Hal.sub_Staging">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Hal.sub_Staging_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Jpub.AllinAnagMass" Name="tim.now.online.module.alignment.Jpub.AllinAnagMass" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="AggiornamentoMassivoAnagrafiche" serviceName="NOW_JPUB_Anagrafiche" isError="true">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_AggiornamentoMassivoAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:REQUEST">
            <parameters Name="TIPO_RICHIESTA" Value="1" type="int"/>
            <parameters Name="Passo" Value="10" type="integer"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_AggiornamentoMassivoAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:REQUEST">
            <parameters Name="TIPO_RICHIESTA" type="int"/>
            <parameters Name="Passo" type="integer"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_AggiornamentoMassivoAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:REQUEST">
            <parameters Name="TIPO_RICHIESTA" type="int"/>
            <parameters Name="Passo" type="integer"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_AggiornamentoMassivoAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:REQUEST">
            <parameters Name="TIPO_RICHIESTA" type="int"/>
            <parameters Name="Passo" type="integer"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_AggiornamentoMassivoAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:REQUEST">
            <parameters Name="TIPO_RICHIESTA" type="int"/>
            <parameters Name="Passo" type="integer"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_AggiornamentoMassivoAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:REQUEST">
            <parameters Name="TIPO_RICHIESTA" Value="3" type="int"/>
            <parameters Name="Passo" Value="1" type="integer"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_AggiornamentoMassivoAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:REQUEST">
            <parameters Name="TIPO_RICHIESTA" Value="3" type="int"/>
            <parameters Name="Passo" Value="1" type="integer"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
    <Operation Name="InvioEsitiAnagrafiche" serviceName="NOW_JPUB_Anagrafiche" isError="true">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_InvioEsitiAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:ESITI">
            <parameters Name="tns0:TESTATA" type="anySimpleType">
              <attributes Name="IDORDCRMWS" Value="tlc" type="string"/>
              <attributes Name="DATADRO" Value="12-11-1987" type="string"/>
              <attributes Name="DATAMSG" type="string"/>
              <attributes Name="DATADES" type="string"/>
              <attributes Name="CODICEORDINEISP" type="string"/>
              <attributes Name="CODICEPROGETTO" type="string"/>
              <attributes Name="IDTRANSAZIONE" Value="31" type="string"/>
            </parameters>
            <parameters Name="tns0:NOTIFICA" type="anySimpleType">
              <attributes Name="CODESCARTO" Value="2" type="string"/>
              <attributes Name="CODEDETTSCARTO" type="string"/>
              <attributes Name="TAGINERRORE" type="string"/>
              <attributes Name="NOMEATTRIBINERRORE" type="string"/>
              <attributes Name="IDRISORSA" Value="321" type="string"/>
              <attributes Name="OLELABOK" Value="OK" type="string"/>
              <attributes Name="CATEGORIA" Value="CONT" type="string"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_InvioEsitiAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:ESITI">
            <parameters Name="tns0:TESTATA" type="anySimpleType">
              <attributes Name="IDORDCRMWS" type="string"/>
              <attributes Name="DATADRO" type="string"/>
              <attributes Name="DATAMSG" type="string"/>
              <attributes Name="DATADES" type="string"/>
              <attributes Name="CODICEORDINEISP" type="string"/>
              <attributes Name="CODICEPROGETTO" type="string"/>
              <attributes Name="IDTRANSAZIONE" type="string"/>
            </parameters>
            <parameters Name="tns0:NOTIFICA" type="anySimpleType">
              <attributes Name="CODESCARTO" type="string"/>
              <attributes Name="CODEDETTSCARTO" type="string"/>
              <attributes Name="TAGINERRORE" type="string"/>
              <attributes Name="NOMEATTRIBINERRORE" type="string"/>
              <attributes Name="IDRISORSA" type="string"/>
              <attributes Name="OLELABOK" type="string"/>
              <attributes Name="CATEGORIA" type="string"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_InvioEsitiAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:ESITI">
            <parameters Name="tns0:TESTATA" type="anySimpleType">
              <attributes Name="IDORDCRMWS" type="string"/>
              <attributes Name="DATADRO" type="string"/>
              <attributes Name="DATAMSG" type="string"/>
              <attributes Name="DATADES" type="string"/>
              <attributes Name="CODICEORDINEISP" type="string"/>
              <attributes Name="CODICEPROGETTO" type="string"/>
              <attributes Name="IDTRANSAZIONE" type="string"/>
            </parameters>
            <parameters Name="tns0:NOTIFICA" type="anySimpleType">
              <attributes Name="CODESCARTO" type="string"/>
              <attributes Name="CODEDETTSCARTO" type="string"/>
              <attributes Name="TAGINERRORE" type="string"/>
              <attributes Name="NOMEATTRIBINERRORE" type="string"/>
              <attributes Name="IDRISORSA" type="string"/>
              <attributes Name="OLELABOK" type="string"/>
              <attributes Name="CATEGORIA" type="string"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_InvioEsitiAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:ESITI">
            <parameters Name="tns0:TESTATA" type="anySimpleType">
              <attributes Name="IDORDCRMWS" type="string"/>
              <attributes Name="DATADRO" type="string"/>
              <attributes Name="DATAMSG" type="string"/>
              <attributes Name="DATADES" type="string"/>
              <attributes Name="CODICEORDINEISP" type="string"/>
              <attributes Name="CODICEPROGETTO" type="string"/>
              <attributes Name="IDTRANSAZIONE" type="string"/>
            </parameters>
            <parameters Name="tns0:NOTIFICA" type="anySimpleType">
              <attributes Name="CODESCARTO" type="string"/>
              <attributes Name="CODEDETTSCARTO" type="string"/>
              <attributes Name="TAGINERRORE" type="string"/>
              <attributes Name="NOMEATTRIBINERRORE" type="string"/>
              <attributes Name="IDRISORSA" type="string"/>
              <attributes Name="OLELABOK" type="string"/>
              <attributes Name="CATEGORIA" type="string"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_InvioEsitiAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:ESITI">
            <parameters Name="tns0:TESTATA" type="anySimpleType">
              <attributes Name="IDORDCRMWS" type="string"/>
              <attributes Name="DATADRO" type="string"/>
              <attributes Name="DATAMSG" type="string"/>
              <attributes Name="DATADES" type="string"/>
              <attributes Name="CODICEORDINEISP" type="string"/>
              <attributes Name="CODICEPROGETTO" type="string"/>
              <attributes Name="IDTRANSAZIONE" type="string"/>
            </parameters>
            <parameters Name="tns0:NOTIFICA" type="anySimpleType">
              <attributes Name="CODESCARTO" type="string"/>
              <attributes Name="CODEDETTSCARTO" type="string"/>
              <attributes Name="TAGINERRORE" type="string"/>
              <attributes Name="NOMEATTRIBINERRORE" type="string"/>
              <attributes Name="IDRISORSA" type="string"/>
              <attributes Name="OLELABOK" type="string"/>
              <attributes Name="CATEGORIA" type="string"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_InvioEsitiAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:ESITI">
            <parameters Name="tns0:TESTATA" type="anySimpleType">
              <attributes Name="IDORDCRMWS" type="string"/>
              <attributes Name="DATADRO" type="string"/>
              <attributes Name="DATAMSG" type="string"/>
              <attributes Name="DATADES" type="string"/>
              <attributes Name="CODICEORDINEISP" type="string"/>
              <attributes Name="CODICEPROGETTO" type="string"/>
              <attributes Name="IDTRANSAZIONE" type="string"/>
            </parameters>
            <parameters Name="tns0:NOTIFICA" type="anySimpleType">
              <attributes Name="CODESCARTO" type="string"/>
              <attributes Name="CODEDETTSCARTO" type="string"/>
              <attributes Name="TAGINERRORE" type="string"/>
              <attributes Name="NOMEATTRIBINERRORE" type="string"/>
              <attributes Name="IDRISORSA" type="string"/>
              <attributes Name="OLELABOK" type="string"/>
              <attributes Name="CATEGORIA" type="string"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_InvioEsitiAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:ESITI">
            <parameters Name="tns0:TESTATA" type="anySimpleType">
              <attributes Name="IDORDCRMWS" type="string"/>
              <attributes Name="DATADRO" type="string"/>
              <attributes Name="DATAMSG" type="string"/>
              <attributes Name="DATADES" type="string"/>
              <attributes Name="CODICEORDINEISP" type="string"/>
              <attributes Name="CODICEPROGETTO" type="string"/>
              <attributes Name="IDTRANSAZIONE" type="string"/>
            </parameters>
            <parameters Name="tns0:NOTIFICA" type="anySimpleType">
              <attributes Name="CODESCARTO" type="string"/>
              <attributes Name="CODEDETTSCARTO" type="string"/>
              <attributes Name="TAGINERRORE" type="string"/>
              <attributes Name="NOMEATTRIBINERRORE" type="string"/>
              <attributes Name="IDRISORSA" type="string"/>
              <attributes Name="OLELABOK" type="string"/>
              <attributes Name="CATEGORIA" type="string"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_InvioEsitiAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:ESITI">
            <parameters Name="tns0:TESTATA" type="anySimpleType">
              <attributes Name="IDORDCRMWS" type="string"/>
              <attributes Name="DATADRO" type="string"/>
              <attributes Name="DATAMSG" type="string"/>
              <attributes Name="DATADES" type="string"/>
              <attributes Name="CODICEORDINEISP" type="string"/>
              <attributes Name="CODICEPROGETTO" type="string"/>
              <attributes Name="IDTRANSAZIONE" type="string"/>
            </parameters>
            <parameters Name="tns0:NOTIFICA" type="anySimpleType">
              <attributes Name="CODESCARTO" type="string"/>
              <attributes Name="CODEDETTSCARTO" type="string"/>
              <attributes Name="TAGINERRORE" type="string"/>
              <attributes Name="NOMEATTRIBINERRORE" type="string"/>
              <attributes Name="IDRISORSA" type="string"/>
              <attributes Name="OLELABOK" type="string"/>
              <attributes Name="CATEGORIA" type="string"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_InvioEsitiAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:ESITI">
            <parameters Name="tns0:TESTATA" type="anySimpleType">
              <attributes Name="IDORDCRMWS" type="string"/>
              <attributes Name="DATADRO" type="string"/>
              <attributes Name="DATAMSG" type="string"/>
              <attributes Name="DATADES" type="string"/>
              <attributes Name="CODICEORDINEISP" type="string"/>
              <attributes Name="CODICEPROGETTO" type="string"/>
              <attributes Name="IDTRANSAZIONE" type="string"/>
            </parameters>
            <parameters Name="tns0:NOTIFICA" type="anySimpleType">
              <attributes Name="CODESCARTO" type="string"/>
              <attributes Name="CODEDETTSCARTO" type="string"/>
              <attributes Name="TAGINERRORE" type="string"/>
              <attributes Name="NOMEATTRIBINERRORE" type="string"/>
              <attributes Name="IDRISORSA" type="string"/>
              <attributes Name="OLELABOK" type="string"/>
              <attributes Name="CATEGORIA" type="string"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_InvioEsitiAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:ESITI">
            <parameters Name="tns0:TESTATA" type="anySimpleType">
              <attributes Name="IDORDCRMWS" type="string"/>
              <attributes Name="DATADRO" type="string"/>
              <attributes Name="DATAMSG" type="string"/>
              <attributes Name="DATADES" type="string"/>
              <attributes Name="CODICEORDINEISP" type="string"/>
              <attributes Name="CODICEPROGETTO" type="string"/>
              <attributes Name="IDTRANSAZIONE" type="string"/>
            </parameters>
            <parameters Name="tns0:NOTIFICA" type="anySimpleType">
              <attributes Name="CODESCARTO" type="string"/>
              <attributes Name="CODEDETTSCARTO" type="string"/>
              <attributes Name="TAGINERRORE" type="string"/>
              <attributes Name="NOMEATTRIBINERRORE" type="string"/>
              <attributes Name="IDRISORSA" type="string"/>
              <attributes Name="OLELABOK" type="string"/>
              <attributes Name="CATEGORIA" type="string"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_InvioEsitiAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:ESITI">
            <parameters Name="tns0:TESTATA" type="anySimpleType">
              <attributes Name="IDORDCRMWS" type="string"/>
              <attributes Name="DATADRO" type="string"/>
              <attributes Name="DATAMSG" type="string"/>
              <attributes Name="DATADES" type="string"/>
              <attributes Name="CODICEORDINEISP" type="string"/>
              <attributes Name="CODICEPROGETTO" type="string"/>
              <attributes Name="IDTRANSAZIONE" type="string"/>
            </parameters>
            <parameters Name="tns0:NOTIFICA" type="anySimpleType">
              <attributes Name="CODESCARTO" type="string"/>
              <attributes Name="CODEDETTSCARTO" type="string"/>
              <attributes Name="TAGINERRORE" type="string"/>
              <attributes Name="NOMEATTRIBINERRORE" type="string"/>
              <attributes Name="IDRISORSA" type="string"/>
              <attributes Name="OLELABOK" type="string"/>
              <attributes Name="CATEGORIA" type="string"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_InvioEsitiAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:ESITI">
            <parameters Name="tns0:TESTATA" type="anySimpleType">
              <attributes Name="IDORDCRMWS" type="string"/>
              <attributes Name="DATADRO" type="string"/>
              <attributes Name="DATAMSG" type="string"/>
              <attributes Name="DATADES" type="string"/>
              <attributes Name="CODICEORDINEISP" type="string"/>
              <attributes Name="CODICEPROGETTO" type="string"/>
              <attributes Name="IDTRANSAZIONE" type="string"/>
            </parameters>
            <parameters Name="tns0:NOTIFICA" type="anySimpleType">
              <attributes Name="CODESCARTO" type="string"/>
              <attributes Name="CODEDETTSCARTO" type="string"/>
              <attributes Name="TAGINERRORE" type="string"/>
              <attributes Name="NOMEATTRIBINERRORE" type="string"/>
              <attributes Name="IDRISORSA" type="string"/>
              <attributes Name="OLELABOK" type="string"/>
              <attributes Name="CATEGORIA" type="string"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.AllinAnagMass_InvioEsitiAnagrafiche_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_JPUB_Anagrafiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.openaccess.it/wholesale/manager/billingEsiti/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoMassiveAnagrafiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:ESITI">
            <parameters Name="tns0:TESTATA" type="anySimpleType">
              <attributes Name="IDORDCRMWS" type="string"/>
              <attributes Name="DATADRO" type="string"/>
              <attributes Name="DATAMSG" type="string"/>
              <attributes Name="DATADES" type="string"/>
              <attributes Name="CODICEORDINEISP" type="string"/>
              <attributes Name="CODICEPROGETTO" type="string"/>
              <attributes Name="IDTRANSAZIONE" type="string"/>
            </parameters>
            <parameters Name="tns0:NOTIFICA" type="anySimpleType">
              <attributes Name="CODESCARTO" type="string"/>
              <attributes Name="CODEDETTSCARTO" type="string"/>
              <attributes Name="TAGINERRORE" type="string"/>
              <attributes Name="NOMEATTRIBINERRORE" type="string"/>
              <attributes Name="IDRISORSA" type="string"/>
              <attributes Name="OLELABOK" type="string"/>
              <attributes Name="CATEGORIA" type="string"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Jpub.CheckInsertCluster" Name="tim.now.online.module.alignment.Jpub.CheckInsertCluster" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Jpub.CheckInsertCluster">
      <Inputs Id="3f535baf-f230-429b-acd8-03536dd91dc3tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.CheckInsertCluster_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Jpub.CheckInsertContratto" Name="tim.now.online.module.alignment.Jpub.CheckInsertContratto" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Jpub.CheckInsertContratto">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.CheckInsertContratto_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Jpub.CheckInsertOLO" Name="tim.now.online.module.alignment.Jpub.CheckInsertOLO" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Jpub.CheckInsertOLO">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.CheckInsertOLO_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Jpub.subAsinc" Name="tim.now.online.module.alignment.Jpub.subAsinc" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Jpub.subAsinc">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.subAsinc_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Jpub.subStaging_In" Name="tim.now.online.module.alignment.Jpub.subStaging_In" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Jpub.subStaging_In">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.subStaging_In_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Jpub.subStaging_Out" Name="tim.now.online.module.alignment.Jpub.subStaging_Out" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Jpub.subStaging_Out">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.subStaging_Out_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Jpub.sub_AllineamentoMassivoJpub" Name="tim.now.online.module.alignment.Jpub.sub_AllineamentoMassivoJpub" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="Invoke" serviceName="JpubAllinementoMassivoAsinc">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Jpub.sub_AllineamentoMassivoJpub_Invoke_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://www.tim.now.AllineamentoMAssivoAnagraficheasinc" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.now.AllineamentoMAssivoAnagraficheasinc"/>
          <nameSpaces prefix="tns0" nameSapce="www.tim.now.aggiornamentomassivo.Jpub.tim.now.schema.xsd.AsincJpub.xsd"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:Input">
            <parameters Name="tns0:Passo" type="string" nameSpace="www.tim.now.aggiornamentomassivo.Jpub.tim.now.schema.xsd.AsincJpub.xsd"/>
            <parameters Name="tns0:TipoRichiesta" type="string" nameSpace="www.tim.now.aggiornamentomassivo.Jpub.tim.now.schema.xsd.AsincJpub.xsd"/>
            <parameters Name="tns0:ProcessIstance" type="integer" nameSpace="www.tim.now.aggiornamentomassivo.Jpub.tim.now.schema.xsd.AsincJpub.xsd"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Patroclo.AllineamentoIdSluco" Name="tim.now.online.module.alignment.Patroclo.AllineamentoIdSluco" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="SendIDSLUCOolo" serviceName="NOW_PATROCLO_SendIDSLUCOolo">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Patroclo.AllineamentoIdSluco_SendIDSLUCOolo_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="xs:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_Patroclo_SendIDSLUCOolo/" nameSpace="xmlns:xs" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_Patroclo_SendIDSLUCOolo/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_Patroclo_SendIDSLUCOolo/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOWSendIDSLUCOolo_input" Value="&#xA;  ">
            <parameters Name="tns1:Transaction_id" Value="fff" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Transaction_date" Value="08-07-2015 10:22:29" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Sistema_origine" Value="PATROCLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Azione" Value="V" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:IDSLUCO" Value="58600I_54_MTW" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:OPERATORE" Value="MTW" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:CLLI" Value="LIVOITAF" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:DATA_CONSEGNA_OLO" Value="08-07-2015 10:22:29" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:ID_RICHESTA" Value="246145" type="int" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:COPPIA_DA" Value="041" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:COPPIA_A" Value="060" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:DATA_INVIO" Value="08-07-2015 10:22:29" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:TESTARMADIO" Value="O1" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:PROGRESSIVO" Value="1" type="int" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Patroclo.AllineamentoIdSluco_SendIDSLUCOolo_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_Patroclo_SendIDSLUCOolo/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_Patroclo_SendIDSLUCOolo/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_Patroclo_SendIDSLUCOolo/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOWSendIDSLUCOolo_input">
            <parameters Name="tns1:Transaction_id" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Transaction_date" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Sistema_origine" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Azione" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:IDSLUCO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:OPERATORE" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:CLLI" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:DATA_CONSEGNA_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:ID_RICHESTA" type="int" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:COPPIA_DA" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:COPPIA_A" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:DATA_INVIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:TESTARMADIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:PROGRESSIVO" type="int" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Patroclo.AllineamentoIdSluco_SendIDSLUCOolo_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_Patroclo_SendIDSLUCOolo/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_Patroclo_SendIDSLUCOolo/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_Patroclo_SendIDSLUCOolo/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOWSendIDSLUCOolo_input">
            <parameters Name="tns1:Transaction_id" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Transaction_date" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Sistema_origine" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Azione" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:IDSLUCO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:OPERATORE" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:CLLI" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:DATA_CONSEGNA_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:ID_RICHESTA" type="int" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:COPPIA_DA" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:COPPIA_A" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:DATA_INVIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:TESTARMADIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:PROGRESSIVO" type="int" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Patroclo.AllineamentoIdSluco_SendIDSLUCOolo_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_Patroclo_SendIDSLUCOolo/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_Patroclo_SendIDSLUCOolo/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_Patroclo_SendIDSLUCOolo/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOWSendIDSLUCOolo_input">
            <parameters Name="tns1:Transaction_id" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Transaction_date" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Sistema_origine" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Azione" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:IDSLUCO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:OPERATORE" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:CLLI" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:DATA_CONSEGNA_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:ID_RICHESTA" type="int" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:COPPIA_DA" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:COPPIA_A" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:DATA_INVIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:TESTARMADIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:PROGRESSIVO" type="int" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Patroclo.AllineamentoIdSluco_SendIDSLUCOolo_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_Patroclo_SendIDSLUCOolo/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_Patroclo_SendIDSLUCOolo/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_Patroclo_SendIDSLUCOolo/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOWSendIDSLUCOolo_input">
            <parameters Name="tns1:Transaction_id" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Transaction_date" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Sistema_origine" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Azione" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:IDSLUCO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:OPERATORE" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:CLLI" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:DATA_CONSEGNA_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:ID_RICHESTA" type="int" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:COPPIA_DA" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:COPPIA_A" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:DATA_INVIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:TESTARMADIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:PROGRESSIVO" type="int" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Patroclo.AllineamentoIdSluco_SendIDSLUCOolo_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_Patroclo_SendIDSLUCOolo/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_Patroclo_SendIDSLUCOolo/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_Patroclo_SendIDSLUCOolo/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOWSendIDSLUCOolo_input">
            <parameters Name="tns1:Transaction_id" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Transaction_date" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Sistema_origine" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Azione" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:IDSLUCO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:OPERATORE" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:CLLI" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:DATA_CONSEGNA_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:ID_RICHESTA" type="int" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:COPPIA_DA" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:COPPIA_A" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:DATA_INVIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:TESTARMADIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:PROGRESSIVO" type="int" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Patroclo.AllineamentoIdSluco_SendIDSLUCOolo_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_Patroclo_SendIDSLUCOolo/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_Patroclo_SendIDSLUCOolo/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_Patroclo_SendIDSLUCOolo/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOWSendIDSLUCOolo_input">
            <parameters Name="tns1:Transaction_id" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Transaction_date" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Sistema_origine" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Azione" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:IDSLUCO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:OPERATORE" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:CLLI" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:DATA_CONSEGNA_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:ID_RICHESTA" type="int" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:COPPIA_DA" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:COPPIA_A" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:DATA_INVIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:TESTARMADIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:PROGRESSIVO" type="int" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Patroclo.AllineamentoIdSluco_SendIDSLUCOolo_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_Patroclo_SendIDSLUCOolo/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_Patroclo_SendIDSLUCOolo/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_Patroclo_SendIDSLUCOolo/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOWSendIDSLUCOolo_input">
            <parameters Name="tns1:Transaction_id" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Transaction_date" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Sistema_origine" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:Azione" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:IDSLUCO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:OPERATORE" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:CLLI" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:DATA_CONSEGNA_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:ID_RICHESTA" type="int" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:COPPIA_DA" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:COPPIA_A" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:DATA_INVIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:TESTARMADIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
            <parameters Name="tns1:PROGRESSIVO" type="int" nameSpace="http://www.tim.com/NOW/xsd/SendIDSLUCOolo"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Patroclo.Sub_AllineamentoIdSluco" Name="tim.now.online.module.alignment.Patroclo.Sub_AllineamentoIdSluco" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Patroclo.Sub_AllineamentoIdSluco">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Patroclo.Sub_AllineamentoIdSluco_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Patroclo.sub_Staging" Name="tim.now.online.module.alignment.Patroclo.sub_Staging" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Patroclo.sub_Staging">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Patroclo.sub_Staging_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Portale.AllineamentoCodiciProgetto" Name="tim.now.online.module.alignment.Portale.AllineamentoCodiciProgetto" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="NowSendCodiciProgetto" serviceName="NOW_AGGIORNAMENTOCODICIPROGETTO">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.AllineamentoCodiciProgetto_NowSendCodiciProgetto_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="xs:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/AggiornamentoCodiciProgetto/" nameSpace="xmlns:xs" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/AggiornamentoCodiciProgetto/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_AggiornamentoCodiciProgetto/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:Input_NowSendCodiciProgetto" Value="&#xA;  ">
            <parameters Name="tns1:Transaction_id" Value="789" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:Transaction_date" Value="2016-07-14T15:39:00.000" type="dateTime" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:CODICE_PROGETTO" Value="----FWALPI" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:CODE_OPERATORE" Value="119" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:DATA_INIZIO_PROV" Value="2016-07-11" type="date" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:DATA_FINE_PROV" Value="2016-07-23" type="date" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:FITTIZIO" Value="SI" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:REPORT" Value="NO" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.AllineamentoCodiciProgetto_NowSendCodiciProgetto_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/AggiornamentoCodiciProgetto/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/AggiornamentoCodiciProgetto/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_AggiornamentoCodiciProgetto/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:Input_NowSendCodiciProgetto">
            <parameters Name="tns1:Transaction_id" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:Transaction_date" type="dateTime" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:CODICE_PROGETTO" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:CODE_OPERATORE" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:DATA_INIZIO_PROV" type="date" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:DATA_FINE_PROV" type="date" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:FITTIZIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:REPORT" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.AllineamentoCodiciProgetto_NowSendCodiciProgetto_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/AggiornamentoCodiciProgetto/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/AggiornamentoCodiciProgetto/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_AggiornamentoCodiciProgetto/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:Input_NowSendCodiciProgetto">
            <parameters Name="tns1:Transaction_id" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:Transaction_date" type="dateTime" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:CODICE_PROGETTO" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:CODE_OPERATORE" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:DATA_INIZIO_PROV" type="date" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:DATA_FINE_PROV" type="date" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:FITTIZIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
            <parameters Name="tns1:REPORT" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/" canDelete="true"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.AllineamentoCodiciProgetto_NowSendCodiciProgetto_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/AggiornamentoCodiciProgetto/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/AggiornamentoCodiciProgetto/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_AggiornamentoCodiciProgetto/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:Input_NowSendCodiciProgetto">
            <parameters Name="tns1:Transaction_id" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
            <parameters Name="tns1:Transaction_date" type="dateTime" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
            <parameters Name="tns1:CODICE_PROGETTO" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
            <parameters Name="tns1:CODE_OPERATORE" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
            <parameters Name="tns1:DATA_INIZIO_PROV" type="date" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
            <parameters Name="tns1:DATA_FINE_PROV" type="date" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
            <parameters Name="tns1:FITTIZIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
            <parameters Name="tns1:REPORT" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.AllineamentoCodiciProgetto_NowSendCodiciProgetto_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/AggiornamentoCodiciProgetto/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/AggiornamentoCodiciProgetto/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_AggiornamentoCodiciProgetto/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:Input_NowSendCodiciProgetto">
            <parameters Name="tns1:Transaction_id" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
            <parameters Name="tns1:Transaction_date" type="dateTime" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
            <parameters Name="tns1:CODICE_PROGETTO" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
            <parameters Name="tns1:CODE_OPERATORE" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
            <parameters Name="tns1:DATA_INIZIO_PROV" type="date" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
            <parameters Name="tns1:DATA_FINE_PROV" type="date" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
            <parameters Name="tns1:FITTIZIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
            <parameters Name="tns1:REPORT" type="string" nameSpace="http://www.tim.com/NOW/xsd/AggiornamentoCodiciProgetto/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Portale.GestioneSegnalazioni" Name="tim.now.online.module.alignment.Portale.GestioneSegnalazioni" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="AperturaSegnalazioni" serviceName="NOW_PORTALE_GestioneSegnalazioni" isError="true">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.GestioneSegnalazioni_AperturaSegnalazioni_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="xs:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:xs" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_AperturaSegnalazione_Input" Value="&#xA;  ">
            <parameters Name="tns1:COD_ORD_TI" Value="123" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" Value="725" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" Value="956" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.GestioneSegnalazioni_AperturaSegnalazioni_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_AperturaSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.GestioneSegnalazioni_AperturaSegnalazioni_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_AperturaSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.GestioneSegnalazioni_AperturaSegnalazioni_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_AperturaSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.GestioneSegnalazioni_AperturaSegnalazioni_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_AperturaSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
    <Operation Name="SollecitoSegnalazione" serviceName="NOW_PORTALE_GestioneSegnalazioni">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.GestioneSegnalazioni_SollecitoSegnalazione_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_SollecitoSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" Value="789" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" Value="987" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" Value="456" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.GestioneSegnalazioni_SollecitoSegnalazione_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_SollecitoSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.GestioneSegnalazioni_SollecitoSegnalazione_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_SollecitoSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.GestioneSegnalazioni_SollecitoSegnalazione_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_SollecitoSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.GestioneSegnalazioni_SollecitoSegnalazione_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_SollecitoSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
    <Operation Name="CodiceProgetto" serviceName="NOW_PORTALE_GestioneSegnalazioni">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.GestioneSegnalazioni_CodiceProgetto_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_CodiceProgetto_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.GestioneSegnalazioni_CodiceProgetto_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_CodiceProgetto_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.GestioneSegnalazioni_CodiceProgetto_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_CodiceProgetto_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.GestioneSegnalazioni_CodiceProgetto_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_CodiceProgetto_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.GestioneSegnalazioni_CodiceProgetto_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_CodiceProgetto_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Portale.Sub_AllineamentoCodiceProdotto" Name="tim.now.online.module.alignment.Portale.Sub_AllineamentoCodiceProdotto" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Portale.Sub_AllineamentoCodiceProdotto">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_AllineamentoCodiceProdotto_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni" Name="tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="AperturaSegnalazioni" serviceName="NOW_PORTALE_GestioneSegnalazioni" isError="true">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni_AperturaSegnalazioni_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="xs:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:xs" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_AperturaSegnalazione_Input" Value="&#xA;  ">
            <parameters Name="tns1:COD_ORD_TI" Value="123" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" Value="725" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" Value="956" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni_AperturaSegnalazioni_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_AperturaSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni_AperturaSegnalazioni_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_AperturaSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni_AperturaSegnalazioni_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_AperturaSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni_AperturaSegnalazioni_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_AperturaSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
    <Operation Name="SollecitoSegnalazione" serviceName="NOW_PORTALE_GestioneSegnalazioni">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni_SollecitoSegnalazione_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_SollecitoSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" Value="789" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" Value="987" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" Value="456" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni_SollecitoSegnalazione_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_SollecitoSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni_SollecitoSegnalazione_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_SollecitoSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni_SollecitoSegnalazione_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_SollecitoSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni_SollecitoSegnalazione_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_SollecitoSegnalazione_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
    <Operation Name="CodiceProgetto" serviceName="NOW_PORTALE_GestioneSegnalazioni">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni_CodiceProgetto_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_CodiceProgetto_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni_CodiceProgetto_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_CodiceProgetto_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni_CodiceProgetto_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_CodiceProgetto_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni_CodiceProgetto_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_CodiceProgetto_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_GestioneSegnalazioni_CodiceProgetto_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/NOW_PORTALE_GestioneSegnalazioni/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:NOW_CodiceProgetto_Input">
            <parameters Name="tns1:COD_ORD_TI" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/" canDelete="true"/>
            <parameters Name="tns1:COD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
            <parameters Name="tns1:COD_ORD_OLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/GestioneSegnalazioni/"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Portale.Sub_StagingAperturaSegnalazione" Name="tim.now.online.module.alignment.Portale.Sub_StagingAperturaSegnalazione" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Portale.Sub_StagingAperturaSegnalazione">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_StagingAperturaSegnalazione_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Portale.Sub_StagingCodiceProgetto" Name="tim.now.online.module.alignment.Portale.Sub_StagingCodiceProgetto" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Portale.Sub_StagingCodiceProgetto">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_StagingCodiceProgetto_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Portale.Sub_StagingSollecitoSegnalazione" Name="tim.now.online.module.alignment.Portale.Sub_StagingSollecitoSegnalazione" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Portale.Sub_StagingSollecitoSegnalazione">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.Sub_StagingSollecitoSegnalazione_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.Portale.sub_Staging" Name="tim.now.online.module.alignment.Portale.sub_Staging" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.Portale.sub_Staging">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.Portale.sub_Staging_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.SDR.Sub_StagingVerificaRisorsaSDR" Name="tim.now.online.module.alignment.SDR.Sub_StagingVerificaRisorsaSDR" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.SDR.Sub_StagingVerificaRisorsaSDR">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.SDR.Sub_StagingVerificaRisorsaSDR_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.SDR.Sub_TranscodificaOfferta" Name="tim.now.online.module.alignment.SDR.Sub_TranscodificaOfferta" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.SDR.Sub_TranscodificaOfferta">
      <Inputs Id="11c4475d-5269-4881-b771-af623d404f84tim.now.online.module.alignment_tim.now.online.module.alignment.SDR.Sub_TranscodificaOfferta_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.SDR.VerificaRisorsa" Name="tim.now.online.module.alignment.SDR.VerificaRisorsa" ModelType="BW" moduleName="tim.now.online.module.alignment">
    <Operation Name="Invoke" serviceName="VerificaRisorsa">
      <Inputs Id="tim.now.online.module.alignment_tim.now.online.module.alignment.SDR.VerificaRisorsa_Invoke_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
