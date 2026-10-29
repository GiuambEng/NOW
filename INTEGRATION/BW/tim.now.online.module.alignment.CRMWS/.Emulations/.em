<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.online.module.alignment.CRMWS">
  <ProcessNode Id="tim.now.online.module.CheckOrdineInCorso.NOWCheckOrdineInCorso" Name="tim.now.online.module.CheckOrdineInCorso.NOWCheckOrdineInCorso" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="NOWCheckOrdineInCorsoDNRisorsa" serviceName="NOWCheckOrdineInCorso">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.CheckOrdineInCorso.NOWCheckOrdineInCorso_NOWCheckOrdineInCorsoDNRisorsa_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.common.GestioneErrore" Name="tim.now.online.module.alignment.common.GestioneErrore" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="Invoke" serviceName="GenericError">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.common.GestioneErrore_Invoke_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.common.SubProcess_StagingConsistenze_In" Name="tim.now.online.module.alignment.common.SubProcess_StagingConsistenze_In" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.common.SubProcess_StagingConsistenze_In">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.common.SubProcess_StagingConsistenze_In_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.common.SubProcess_StagingConsistenze_Out" Name="tim.now.online.module.alignment.common.SubProcess_StagingConsistenze_Out" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.common.SubProcess_StagingConsistenze_Out">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.common.SubProcess_StagingConsistenze_Out_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.common.Sub_AllineamentoConsistenze_Input_Error" Name="tim.now.online.module.alignment.common.Sub_AllineamentoConsistenze_Input_Error" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.common.Sub_AllineamentoConsistenze_Input_Error">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.common.Sub_AllineamentoConsistenze_Input_Error_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.common.Sub_AllineamentoConsistenze_Output_Error" Name="tim.now.online.module.alignment.common.Sub_AllineamentoConsistenze_Output_Error" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.common.Sub_AllineamentoConsistenze_Output_Error">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.common.Sub_AllineamentoConsistenze_Output_Error_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.common.Sub_VerificaLav_Vlan_Error" Name="tim.now.online.module.alignment.common.Sub_VerificaLav_Vlan_Error" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.common.Sub_VerificaLav_Vlan_Error">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.common.Sub_VerificaLav_Vlan_Error_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.common.Sub_VerificaUnivocitaCVLAN_Error" Name="tim.now.online.module.alignment.common.Sub_VerificaUnivocitaCVLAN_Error" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.common.Sub_VerificaUnivocitaCVLAN_Error">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.common.Sub_VerificaUnivocitaCVLAN_Error_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.crmws.AllineamentoConsistenze" Name="tim.now.online.module.alignment.crmws.AllineamentoConsistenze" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="SendVariazioneULLLNA" serviceName="NOWSendConsistenza">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.crmws.AllineamentoConsistenze_SendVariazioneULLLNA_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="xs:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOW_CRMWS_AllineamentoConsistenze/" nameSpace="xmlns:xs" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOW_CRMWS_AllineamentoConsistenze/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tim.com/NOW/xsd/AllineamentoConsistenza/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:Send_Variazione_Ullna_Request" Value="&#xA;  ">
            <parameters Name="tns0:Transaction_id" Value="A" type="string" nameSpace="http://www.tim.com/NOW/xsd/AllineamentoConsistenza/"/>
            <parameters Name="tns0:Transaction_date" Value="2016-11-30T11:47:00.000" type="dateTime" nameSpace="http://www.tim.com/NOW/xsd/AllineamentoConsistenza/"/>
            <parameters Name="tns0:SERVIZIO" Value="&#xA;    ">
              <parameters Name="tns0:CodiceOlo" Value="11" type="string" nameSpace="http://www.tim.com/NOW/xsd/AllineamentoConsistenza/"/>
              <parameters Name="tns0:DescOLO" Value="AA" type="string" nameSpace="http://www.tim.com/NOW/xsd/AllineamentoConsistenza/"/>
              <parameters Name="tns0:ULLLNA" Value="&#xA;      ">
                <parameters Name="tns0:Servizio" Value="01" type="string" nameSpace="http://www.tim.com/NOW/xsd/AllineamentoConsistenza/"/>
                <parameters Name="tns0:VARIAZIONE" Value="&#xA;        ">
                  <parameters Name="tns0:REFERENTE" isList="true">
                    <parameters Name="tns0:QualificaReferente" Value="a" type="string" nameSpace="http://www.tim.com/NOW/xsd/AllineamentoConsistenza/"/>
                    <parameters Name="tns0:CognomeReferente" Value="a" type="string" nameSpace="http://www.tim.com/NOW/xsd/AllineamentoConsistenza/"/>
                    <parameters Name="tns0:NomeReferente" type="string" nameSpace="http://www.tim.com/NOW/xsd/AllineamentoConsistenza/" canDelete="true"/>
                    <parameters Name="tns0:TelefonoMobileReferente" type="string" nameSpace="http://www.tim.com/NOW/xsd/AllineamentoConsistenza/" canDelete="true"/>
                    <parameters Name="tns0:TelefonoFissoReferente" type="string" nameSpace="http://www.tim.com/NOW/xsd/AllineamentoConsistenza/" canDelete="true"/>
                  </parameters>
                </parameters>
              </parameters>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
    <Operation Name="SendCessazioneULLNA" serviceName="NOWSendConsistenza">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.crmws.AllineamentoConsistenze_SendCessazioneULLNA_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="SendCessazioneSLU" serviceName="NOWSendConsistenza">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.crmws.AllineamentoConsistenze_SendCessazioneSLU_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="SendCessazioneNP" serviceName="NOWSendConsistenza">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.crmws.AllineamentoConsistenze_SendCessazioneNP_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.crmws.Invoke_CRMWS_Error" Name="tim.now.online.module.alignment.crmws.Invoke_CRMWS_Error" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="Operation_1" serviceName="InvokeCRMWS_SubProcess">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.crmws.Invoke_CRMWS_Error_Operation_1_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.crmws.SubProcess_invokeCRMWS" Name="tim.now.online.module.alignment.crmws.SubProcess_invokeCRMWS" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="Operation_1" serviceName="InvokeCRMWS_SubProcess">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.crmws.SubProcess_invokeCRMWS_Operation_1_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.crmws.subAllineaServizio01" Name="tim.now.online.module.alignment.crmws.subAllineaServizio01" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.crmws.subAllineaServizio01">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.crmws.subAllineaServizio01_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.crmws.subAllineaServizio02" Name="tim.now.online.module.alignment.crmws.subAllineaServizio02" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="callProcess" serviceName="tim.now.online.module.alignment.crmws.subAllineaServizio02">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.crmws.subAllineaServizio02_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.alignment.crmws.sub_AllinemanetoConsistenzeJMS" Name="tim.now.online.module.alignment.crmws.sub_AllinemanetoConsistenzeJMS" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="SendVariazioneULLNA" serviceName="NowSendConsistenza_JMS">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.crmws.sub_AllinemanetoConsistenzeJMS_SendVariazioneULLNA_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="SendCessazioneULLNA" serviceName="NowSendConsistenza_JMS">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.crmws.sub_AllinemanetoConsistenzeJMS_SendCessazioneULLNA_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="SendCessazioneSLU" serviceName="NowSendConsistenza_JMS">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.crmws.sub_AllinemanetoConsistenzeJMS_SendCessazioneSLU_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="SendCessazioneNP" serviceName="NowSendConsistenza_JMS">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.alignment.crmws.sub_AllinemanetoConsistenzeJMS_SendCessazioneNP_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.checklavorabilita.NowCheckLavorabilitaVLAN" Name="tim.now.online.module.checklavorabilita.NowCheckLavorabilitaVLAN" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="NowCheckLavorabilitaVLAN" serviceName="NOWCheckLavorabilitaRaccolta">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.checklavorabilita.NowCheckLavorabilitaVLAN_NowCheckLavorabilitaVLAN_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.checklavorabilita.Sub_VerificaLavorabilita" Name="tim.now.online.module.checklavorabilita.Sub_VerificaLavorabilita" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="callProcess" serviceName="tim.now.online.module.checklavorabilita.Sub_VerificaLavorabilita">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.checklavorabilita.Sub_VerificaLavorabilita_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.checklavorabilita.sub_Staging" Name="tim.now.online.module.checklavorabilita.sub_Staging" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="callProcess" serviceName="tim.now.online.module.checklavorabilita.sub_Staging">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.checklavorabilita.sub_Staging_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.consistenzadati.NowSendConsistenzaDati" Name="tim.now.online.module.consistenzadati.NowSendConsistenzaDati" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="SendVariazioneNGA" serviceName="NOWSendConsistenzaDati">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.consistenzadati.NowSendConsistenzaDati_SendVariazioneNGA_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="SendVariazioneXDSL" serviceName="NOWSendConsistenzaDati">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.consistenzadati.NowSendConsistenzaDati_SendVariazioneXDSL_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="SendCessazioneDati" serviceName="NOWSendConsistenzaDati">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.consistenzadati.NowSendConsistenzaDati_SendCessazioneDati_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.consistenzadati.NowSendConsistenzaDati_JMS" Name="tim.now.online.module.consistenzadati.NowSendConsistenzaDati_JMS" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="SendVariazioneNGA" serviceName="NOWSendConsistenzaDati_JMS">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.consistenzadati.NowSendConsistenzaDati_JMS_SendVariazioneNGA_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="SendVariazioneXDSL" serviceName="NOWSendConsistenzaDati_JMS">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.consistenzadati.NowSendConsistenzaDati_JMS_SendVariazioneXDSL_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="SendCessazioneDati" serviceName="NOWSendConsistenzaDati_JMS">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.consistenzadati.NowSendConsistenzaDati_JMS_SendCessazioneDati_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.consistenzadati.SubAllineaAsset_SendVariazioneNGA" Name="tim.now.online.module.consistenzadati.SubAllineaAsset_SendVariazioneNGA" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="callProcess" serviceName="tim.now.online.module.consistenzadati.SubAllineaAsset_SendVariazioneNGA">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.consistenzadati.SubAllineaAsset_SendVariazioneNGA_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.consistenzadati.SubAllineaAsset_SendVariazioneXDSL" Name="tim.now.online.module.consistenzadati.SubAllineaAsset_SendVariazioneXDSL" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="callProcess" serviceName="tim.now.online.module.consistenzadati.SubAllineaAsset_SendVariazioneXDSL">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.consistenzadati.SubAllineaAsset_SendVariazioneXDSL_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.verificaunivocita.Sub_Staging" Name="tim.now.online.module.verificaunivocita.Sub_Staging" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="callProcess" serviceName="tim.now.online.module.verificaunivocita.Sub_Staging">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.verificaunivocita.Sub_Staging_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.verificaunivocita.Sub_VerificaUnivocita" Name="tim.now.online.module.verificaunivocita.Sub_VerificaUnivocita" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="callProcess" serviceName="tim.now.online.module.verificaunivocita.Sub_VerificaUnivocita">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.verificaunivocita.Sub_VerificaUnivocita_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.online.module.verificaunivocita.VerificaUnivocitaCVLAN_ID" Name="tim.now.online.module.verificaunivocita.VerificaUnivocitaCVLAN_ID" ModelType="BW" moduleName="tim.now.online.module.alignment.CRMWS">
    <Operation Name="NowCheckRaccoltaVLAN" serviceName="NOWCheckRaccolta">
      <Inputs Id="tim.now.online.module.alignment.CRMWS_tim.now.online.module.verificaunivocita.VerificaUnivocitaCVLAN_ID_NowCheckRaccoltaVLAN_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
