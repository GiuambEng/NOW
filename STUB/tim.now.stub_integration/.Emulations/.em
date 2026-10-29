<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.stub_integration">
  <ProcessNode Id="Crmws.CRMWStoNOW_CheckConsistenza" Name="Crmws.CRMWStoNOW_CheckConsistenza" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="CRMWSCheckConsistenza" serviceName="PortType">
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNOW_CheckConsistenza_CRMWSCheckConsistenza_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Crmws.CRMWStoNOW_CheckLavorabilitaDN" Name="Crmws.CRMWStoNOW_CheckLavorabilitaDN" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="CRMWSCheckLavorabilitaDN" serviceName="CRMWSCheckLavorabilitaDN">
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNOW_CheckLavorabilitaDN_CRMWSCheckLavorabilitaDN_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Crmws.CRMWStoNOW_CheckLavorabilitaIDRisorsa" Name="Crmws.CRMWStoNOW_CheckLavorabilitaIDRisorsa" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="CRMWSCheckLavorabilitaIDRISORSA" serviceName="PortType">
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNOW_CheckLavorabilitaIDRisorsa_CRMWSCheckLavorabilitaIDRISORSA_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Crmws.CRMWStoNOW_CheckNP" Name="Crmws.CRMWStoNOW_CheckNP" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="CRMWSCheckNP" serviceName="CRMWSCheckNP">
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNOW_CheckNP_CRMWSCheckNP_Request" Name="Request" isDefault="true">
        <informations Name="HEADER" tnsName="tns:" nameSpaceValue="http://xmlns.example.com/1470142071397" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://xmlns.example.com/1470142071397"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd2"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:HEADER">
            <parameters Name="tns0:TRANSACTION_ID" Value="0000000000" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            <parameters Name="tns0:TRANSACTION_DATE" Value="2016-10-03T17:37:00.000" type="dateTime" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            <parameters Name="tns0:SISTEMA_ORIGINE" Value="NOW" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            <parameters Name="tns0:REQUEST">
              <parameters Name="tns0:DATA_RICHIESTA" Value="2016-10-03T17:39:00.000" type="dateTime" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
              <parameters Name="tns0:DN" Value="9999999999" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNOW_CheckNP_CRMWSCheckNP_Request" Name="Request" isDefault="true">
        <informations Name="HEADER" tnsName="tns:" nameSpaceValue="http://xmlns.example.com/1470142071397" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://xmlns.example.com/1470142071397"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd2"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:HEADER">
            <parameters Name="tns0:TRANSACTION_ID" Value="0000000000" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            <parameters Name="tns0:TRANSACTION_DATE" Value="2016-10-03T17:39:00.000" type="dateTime" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            <parameters Name="tns0:SISTEMA_ORIGINE" Value="NOW" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            <parameters Name="tns0:REQUEST">
              <parameters Name="tns0:DATA_RICHIESTA" Value="2016-10-03T17:40:00.000" type="dateTime" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
              <parameters Name="tns0:DN" Value="2345678901" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNOW_CheckNP_CRMWSCheckNP_Request" Name="Request" isDefault="true">
        <informations Name="HEADER" tnsName="tns:" nameSpaceValue="http://xmlns.example.com/1470142071397" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://xmlns.example.com/1470142071397"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd2"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:HEADER">
            <parameters Name="tns0:TRANSACTION_ID" Value="0000000000" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            <parameters Name="tns0:TRANSACTION_DATE" Value="2016-10-03T17:42:00.000" type="dateTime" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            <parameters Name="tns0:SISTEMA_ORIGINE" Value="NOW" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            <parameters Name="tns0:REQUEST">
              <parameters Name="tns0:DATA_RICHIESTA" Value="2016-10-03T17:43:00.000" type="dateTime" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
              <parameters Name="tns0:DN" Value="1234123456" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNOW_CheckNP_CRMWSCheckNP_Request" Name="Request" isDefault="true">
        <informations Name="HEADER" tnsName="tns:" nameSpaceValue="http://xmlns.example.com/1470142071397" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://xmlns.example.com/1470142071397"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd2"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:HEADER">
            <parameters Name="tns0:TRANSACTION_ID" Value="0000000000" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            <parameters Name="tns0:TRANSACTION_DATE" Value="2016-10-03T17:48:00.000" type="dateTime" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            <parameters Name="tns0:SISTEMA_ORIGINE" Value="NOW" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            <parameters Name="tns0:REQUEST">
              <parameters Name="tns0:DATA_RICHIESTA" Value="2016-10-03T17:49:00.000" type="dateTime" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
              <parameters Name="tns0:DN" Value="3333333333" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNOW_CheckNP_CRMWSCheckNP_Request" Name="Request" isDefault="true">
        <informations Name="HEADER" tnsName="tns:" nameSpaceValue="http://xmlns.example.com/1470142071397" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://xmlns.example.com/1470142071397"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd2"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:HEADER">
            <parameters Name="tns0:TRANSACTION_ID" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            <parameters Name="tns0:TRANSACTION_DATE" type="dateTime" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            <parameters Name="tns0:SISTEMA_ORIGINE" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            <parameters Name="tns0:REQUEST">
              <parameters Name="tns0:DATA_RICHIESTA" type="dateTime" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
              <parameters Name="tns0:DN" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSCheckNP/Schema.xsd"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Crmws.CRMWStoNOW_CheckRaccoltaVLAN" Name="Crmws.CRMWStoNOW_CheckRaccoltaVLAN" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="CRMWSCheckRaccoltaVLAN" serviceName="PortType">
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNOW_CheckRaccoltaVLAN_CRMWSCheckRaccoltaVLAN_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Crmws.CRMWStoNOW_GetConsistenzaReg" Name="Crmws.CRMWStoNOW_GetConsistenzaReg" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="AttivazioneULLLNA" serviceName="CRMWSGetConsistenzaReg">
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNOW_GetConsistenzaReg_AttivazioneULLLNA_Request" Name="Request" isDefault="true">
        <informations Name="REQUEST" tnsName="tns:" nameSpaceValue="http://xmlns.example.com/1460476602492" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://xmlns.example.com/1460476602492"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd2"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:REQUEST_ATTIVAZIONE_ULLLNA">
            <parameters Name="tns1:TRANSACTION_ID" Value="0000000000" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
            <parameters Name="tns1:TRANSACTION_DATE" Value="2016-10-05T14:23:00.000" type="dateTime" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
            <parameters Name="tns1:SERVIZIO">
              <parameters Name="tns1:CODICEOLO" Value="370" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
              <parameters Name="tns1:DESCOLO" Value="TLC" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
              <parameters Name="tns1:ULLLNA">
                <parameters Name="tns1:CRMWS_SERVICE" Value="01" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                <parameters Name="tns1:ATTIVAZIONE">
                  <parameters Name="tns1:CODICEORDINEOLO" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:CODICE_ORDINE_TI" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:CONTRATTO" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:RISORSA" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:ID_NOW" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:DAC" type="date" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:DEC" type="date" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:IDULLCO" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:POSIZIONEPERMUTATORE1" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:POSIZIONEPERMUTATORE2" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                  <parameters Name="tns1:INDICATOREDIASSURANCE" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                  <parameters Name="tns1:DISTR_TELEFONICO" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:CLLI_CENTRALE" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:CIVICO_EFD" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                  <parameters Name="tns1:IDARLTI" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                  <parameters Name="tns1:DATA_PERMUTA_ARMADIO" type="date" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                  <parameters Name="tns1:PERMUTA_ARMADIO" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                  <parameters Name="tns1:CODICE_CENTRALE_ACLRR" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                  <parameters Name="tns1:DESTINAZIONEUSO">
                    <parameters Name="tns1:FONIA" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parameters Name="tns1:DATI">
                      <parameters Name="tns1:TIPODATI" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                      <parameters Name="tns1:BITRATE" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                      <parent Name="DESTINAZIONEUSOType" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    </parameters>
                    <parent Name="ATTIVAZIONEType" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  </parameters>
                  <parameters Name="tns1:DATICLIENTE">
                    <parameters Name="tns1:COGNOMERAGSOC" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parameters Name="tns1:NOME" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parameters Name="tns1:CF" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parameters Name="tns1:PIVA" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parent Name="ATTIVAZIONEType" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  </parameters>
                  <parameters Name="tns1:SEDE">
                    <parameters Name="tns1:PARTICELLATOPONOMASTICA" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parameters Name="tns1:VIA" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parameters Name="tns1:CIVICO" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parameters Name="tns1:LOCALITA" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parameters Name="tns1:CAP" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parameters Name="tns1:COMPLESSO" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parameters Name="tns1:SCALA" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parameters Name="tns1:PIANO" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parameters Name="tns1:INTERNO" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parameters Name="tns1:CODICEINDIRIZZO" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parameters Name="tns1:CODICECOMUNE" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parameters Name="tns1:CODESTRADA" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parameters Name="tns1:PROVINCIA" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parameters Name="tns1:SIGLAPROVINCIA" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parameters Name="tns1:DR" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parameters Name="tns1:ISTATPROV" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parent Name="ATTIVAZIONEType" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  </parameters>
                  <parameters Name="tns1:REFERENTE" isList="true">
                    <parameters Name="tns1:QUALIFICAREFERENTE" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parameters Name="tns1:COGNOMEREFERENTE" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parameters Name="tns1:NOMEREFERENTE" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parameters Name="tns1:TELEFONOMOBILEREFERENTE" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parameters Name="tns1:TELEFONOFISSOREFERENTE" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parent Name="ATTIVAZIONEType" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  </parameters>
                  <parameters Name="tns1:REFERENTEONFIELD">
                    <parameters Name="tns1:NOMEREFERENTE" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parameters Name="tns1:COGNOMEREFERENTE" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parameters Name="tns1:TELEFONOMOBILEREFERENTE" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parameters Name="tns1:TELEFONOFISSOREFERENTE" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parent Name="ATTIVAZIONEType" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  </parameters>
                  <parent Name="ULLLNA_ATTIVAZIONEType" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                </parameters>
                <parent Name="SERVIZIO_ULLLNA_ATTIVAZIONEType" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
              </parameters>
              <parent Name="CRMWSGetConsistenzaREGAttivazioneULLLNAREQUESTType" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
    <Operation Name="CessazioneULLLNA" serviceName="CRMWSGetConsistenzaReg">
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNOW_GetConsistenzaReg_CessazioneULLLNA_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="AttivazioneSLULNA" serviceName="CRMWSGetConsistenzaReg">
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNOW_GetConsistenzaReg_AttivazioneSLULNA_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="CessazioneSLULNA" serviceName="CRMWSGetConsistenzaReg">
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNOW_GetConsistenzaReg_CessazioneSLULNA_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="CessazioneNP" serviceName="CRMWSGetConsistenzaReg">
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNOW_GetConsistenzaReg_CessazioneNP_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="AttivazioneNP" serviceName="CRMWSGetConsistenzaReg">
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNOW_GetConsistenzaReg_AttivazioneNP_Request" Name="Request" isDefault="true">
        <informations Name="REQUEST" tnsName="xs:" nameSpaceValue="http://xmlns.example.com/1460476602492" nameSpace="xmlns:xs" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://xmlns.example.com/1460476602492"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd2"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns1:REQUEST_ATTIVAZIONE_NP" Value="&#xA;  ">
            <parameters Name="tns1:TRANSACTION_ID" Value="0000000000" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
            <parameters Name="tns1:TRANSACTION_DATE" Value="2016-09-30T09:14:00.000" type="dateTime" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
            <parameters Name="tns1:SERVIZIO" Value="&#xA;    ">
              <parameters Name="tns1:CODICEOLO" Value="370" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
              <parameters Name="tns1:DESCOLO" Value="TLC" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
              <parameters Name="tns1:NPG" Value="&#xA;      ">
                <parameters Name="tns1:CRMWS_SERVICE" Value="01" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                <parameters Name="tns1:ATTIVAZIONE" Value="&#xA;        ">
                  <parameters Name="tns1:CODICEORDINEOLO" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:CODICE_ORDINE_TI" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:CONTRATTO" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:RISORSA" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:ID_NOW" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:DAC" type="date" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:DEC" type="date" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:DISTR_TELEFONICO" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:ROUTING_NUMBER" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:CODICE_OLO_DONATING" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:PRIMARY_NUMBER" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                  <parameters Name="tns1:TIPO_DN" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:TIPO_LINEA" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:RADICE_GNR" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                  <parameters Name="tns1:NUMERO_LINEE" type="int" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                  <parameters Name="tns1:CODICE_RO" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                  <parameters Name="tns1:CAPOSTIPITE" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                  <parameters Name="tns1:PIATTAFORMA_COMMERCIALE" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  <parameters Name="tns1:DATICLIENTE" Value="&#xA;          ">
                    <parameters Name="tns1:COGNOMERAGSOC" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                    <parameters Name="tns1:NOME" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parameters Name="tns1:CF" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parameters Name="tns1:PIVA" type="string" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd" canDelete="true"/>
                    <parent Name="NP_ATTIVAZIONEType" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                  </parameters>
                  <parent Name="NPG_ATTIVAZIONEType" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
                </parameters>
                <parent Name="SERVIZIO_NP_ATTIVAZIONEType" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
              </parameters>
              <parent Name="CRMWSGetConsistenzaREGAttivazioneNPREQUESTType" nameSpace="http://www.tibco.com/schemas/NOW/SharedResources/XSD/CRMWSGetConsistenzaREG/Schema.xsd"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Crmws.CRMWStoNOW_GetContract" Name="Crmws.CRMWStoNOW_GetContract" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="CRMWSGetContract" serviceName="PortType">
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNOW_GetContract_CRMWSGetContract_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Crmws.CRMWStoNow_IDULLCOolo" Name="Crmws.CRMWStoNow_IDULLCOolo" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="CRMWSIDULLCOolo" serviceName="CRMWSIDULLCOoloPortType">
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWStoNow_IDULLCOolo_CRMWSIDULLCOolo_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Crmws.CRMWsToNOW_GEtRiscontroConsistenza" Name="Crmws.CRMWsToNOW_GEtRiscontroConsistenza" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="CRMWSGetRiscontroConsistenza" serviceName="PortType">
      <Inputs Id="tim.now.stub_integration_Crmws.CRMWsToNOW_GEtRiscontroConsistenza_CRMWSGetRiscontroConsistenza_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Crmws.CrmwsToNow_CRMWSCheckATMVPKIT" Name="Crmws.CrmwsToNow_CRMWSCheckATMVPKIT" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="CRMWSCheckVPKIT" serviceName="PortType">
      <Inputs Id="tim.now.stub_integration_Crmws.CrmwsToNow_CRMWSCheckATMVPKIT_CRMWSCheckVPKIT_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="CRMWSGestVCNum" serviceName="PortType">
      <Inputs Id="tim.now.stub_integration_Crmws.CrmwsToNow_CRMWSCheckATMVPKIT_CRMWSGestVCNum_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Crmws.CrmwsToNow_CRMWSGetConsistenzaNGA" Name="Crmws.CrmwsToNow_CRMWSGetConsistenzaNGA" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="CessazioneAcessoNGAVULA" serviceName="PortType">
      <Inputs Id="tim.now.stub_integration_Crmws.CrmwsToNow_CRMWSGetConsistenzaNGA_CessazioneAcessoNGAVULA_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="AttivazioneAccessoNGAVULA" serviceName="PortType">
      <Inputs Id="tim.now.stub_integration_Crmws.CrmwsToNow_CRMWSGetConsistenzaNGA_AttivazioneAccessoNGAVULA_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Crmws.CrmwsToNow_CRMWSGetConsistenzaXDSL" Name="Crmws.CrmwsToNow_CRMWSGetConsistenzaXDSL" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="AttivazioneAccessoATM" serviceName="PortType">
      <Inputs Id="tim.now.stub_integration_Crmws.CrmwsToNow_CRMWSGetConsistenzaXDSL_AttivazioneAccessoATM_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="CessazioneAcessoDatiDSL" serviceName="PortType">
      <Inputs Id="tim.now.stub_integration_Crmws.CrmwsToNow_CRMWSGetConsistenzaXDSL_CessazioneAcessoDatiDSL_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="AttivazioneAccessoGBE" serviceName="PortType">
      <Inputs Id="tim.now.stub_integration_Crmws.CrmwsToNow_CRMWSGetConsistenzaXDSL_AttivazioneAccessoGBE_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Crmws.CrmwsToNow_CRMWSGetEsitoConsistenzaDati" Name="Crmws.CrmwsToNow_CRMWSGetEsitoConsistenzaDati" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="CRMWSGetEsitoConsistenzaDati" serviceName="PortType">
      <Inputs Id="tim.now.stub_integration_Crmws.CrmwsToNow_CRMWSGetEsitoConsistenzaDati_CRMWSGetEsitoConsistenzaDati_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Dtu.DTURequestReceiver" Name="Dtu.DTURequestReceiver" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="Richiesta_Evento" serviceName="PortType">
      <Inputs Id="tim.now.stub_integration_Dtu.DTURequestReceiver_Richiesta_Evento_Richiesta_Evento" Name="Richiesta_Evento" isDefault="true"/>
    </Operation>
    <Operation Name="Richiesta_ACK" serviceName="PortType">
      <Inputs Id="tim.now.stub_integration_Dtu.DTURequestReceiver_Richiesta_ACK_Richiesta_ACK" Name="Richiesta_ACK" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="JPub.JPubAnagraficaContratto" Name="JPub.JPubAnagraficaContratto" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="ricezione" serviceName="AnagraficaContrattoCRMNOW">
      <Inputs Id="tim.now.stub_integration_JPub.JPubAnagraficaContratto_ricezione_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="JPub.JPubAnagraficaGestore" Name="JPub.JPubAnagraficaGestore" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="ricezione" serviceName="AnagraficaGestoreCRMNOW">
      <Inputs Id="tim.now.stub_integration_JPub.JPubAnagraficaGestore_ricezione_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="JPub.JPubRicezioneOrdini" Name="JPub.JPubRicezioneOrdini" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="ricezione" serviceName="OrdineRegolatorioCRMNOW">
      <Inputs Id="tim.now.stub_integration_JPub.JPubRicezioneOrdini_ricezione_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="JPub.JPubRicezioneOrdiniXDSL" Name="JPub.JPubRicezioneOrdiniXDSL" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="ricezione" serviceName="OrdineXDSLCRMNOW">
      <Inputs Id="tim.now.stub_integration_JPub.JPubRicezioneOrdiniXDSL_ricezione_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Jive.JiveAddressVerification" Name="Jive.JiveAddressVerification" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="getAddressVerifyRequest" serviceName="WirelineAddressCertificationQueryPortType">
      <Inputs Id="tim.now.stub_integration_Jive.JiveAddressVerification_getAddressVerifyRequest_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="Unica-C.UNICAC_GetDatiInventory" Name="Unica-C.UNICAC_GetDatiInventory" ModelType="BW" moduleName="tim.now.stub_integration">
    <Operation Name="ReperimentoServizio" serviceName="ServiceUnicacGetDatiInventory">
      <Inputs Id="tim.now.stub_integration_Unica-C.UNICAC_GetDatiInventory_ReperimentoServizio_ReperimentoServizioRequest" Name="ReperimentoServizioRequest" isDefault="true">
        <informations Name="parameters" tnsName="impl:" nameSpaceValue="http://getdatiinventory.unicac.telecomitalia.it" nameSpace="xmlns:impl" partType="Element">
          <nameSpaces prefix="impl" nameSapce="http://getdatiinventory.unicac.telecomitalia.it"/>
          <nameSpaces prefix="tns1" nameSapce="http://types.getdatiinventory.unicac.telecomitalia.it"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="impl:ReperimentoServizio">
            <parameters Name="impl:request">
              <parameters Name="tns1:body">
                <parameters Name="tns1:DN" Value="12348765" type="string" nameSpace="http://types.getdatiinventory.unicac.telecomitalia.it">
                  <parent Name="BodyRequest" nameSpace="http://types.getdatiinventory.unicac.telecomitalia.it"/>
                </parameters>
                <parameters Name="tns1:distretto" Value="06" type="string" nameSpace="http://types.getdatiinventory.unicac.telecomitalia.it">
                  <parent Name="BodyRequest" nameSpace="http://types.getdatiinventory.unicac.telecomitalia.it"/>
                </parameters>
                <parent Name="DatiInventoryRequest" nameSpace="http://types.getdatiinventory.unicac.telecomitalia.it"/>
              </parameters>
              <parameters Name="tns1:header">
                <parameters Name="tns1:transaction_date" Value="2016-11-03T10:17:00.000" type="dateTime" nameSpace="http://types.getdatiinventory.unicac.telecomitalia.it">
                  <parent Name="HeaderRequest" nameSpace="http://types.getdatiinventory.unicac.telecomitalia.it"/>
                </parameters>
                <parameters Name="tns1:transaction_id" Value="provaprova" type="string" nameSpace="http://types.getdatiinventory.unicac.telecomitalia.it">
                  <parent Name="HeaderRequest" nameSpace="http://types.getdatiinventory.unicac.telecomitalia.it"/>
                </parameters>
                <parent Name="DatiInventoryRequest" nameSpace="http://types.getdatiinventory.unicac.telecomitalia.it"/>
              </parameters>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
