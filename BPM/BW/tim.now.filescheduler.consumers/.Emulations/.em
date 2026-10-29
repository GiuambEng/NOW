<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.filemanager">
  <ProcessNode Id="tim.now.filemanager.acquisition.SystemLocator" Name="tim.now.filemanager.acquisition.SystemLocator" ModelType="BW" moduleName="tim.now.filemanager">
    <Operation Name="GetSystem" serviceName="SystemLocatorPortType">
      <Inputs Id="tim.now.filemanager_tim.now.filemanager.acquisition.SystemLocator_GetSystem_Request" Name="Request" isDefault="true">
        <informations Name="RichiestaLocalizzatore" tnsName="xs:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/SystemLocator/" nameSpace="xmlns:xs" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/SystemLocator/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tim.com/NOW/xsd/SystemLocator/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/CommonSchema/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:RichiestaLocalizzatore" Value="&#xA;  ">
            <parameters Name="tns0:Testata" Value="&#xA;    ">
              <parameters Name="tns0:Transaction_id" Value="ID" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="testataType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Transaction_date" Value="2001-12-17T09:30:47.0Z" type="dateTime" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="testataType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Sistema_origine" Value="NOW" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="testataType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
            </parameters>
            <parameters Name="tns0:Richiesta" Value="&#xA;    ">
              <parameters Name="tns0:DataRichiesta" Value="2000-10-06T09:30:47.0Z" type="dateTime" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:CodiceOLOAGCOM" Value="WIN" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:CodiceISP" Value="100" type="int" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:ModalitaAcq" Value="F" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Comune" Value="ROMA" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Localita" Value="LAZIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Servizio" Value="ULLLineaNonAttiva" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <enumList>WLRLineaAttiva</enumList>
                <enumList>WLRLineaNonAttiva</enumList>
                <enumList>ULLLineaAttiva</enumList>
                <enumList>ULLLineaNonAttiva</enumList>
                <enumList>ULLLineaAttivaNP</enumList>
                <enumList>ULLDatiLineaAttiva</enumList>
                <enumList>ULLDatiLineaAttivaNP</enumList>
                <enumList>ULLDatiLineaNonAttiva</enumList>
                <enumList>VULL</enumList>
                <enumList>SHASenzaManoDopera</enumList>
                <enumList>SHAConManoDopera</enumList>
                <enumList>ProlungamentoAccesso</enumList>
                <enumList>CPS</enumList>
                <enumList>Colocazione</enumList>
                <enumList>SLULineaAttiva</enumList>
                <enumList>SLULineaNonAttiva</enumList>
                <enumList>SLULineaAttivaNP</enumList>
                <enumList>ValorizzazioneWLR</enumList>
                <enumList>ValorizzazioneULL</enumList>
                <enumList>AmpliamentoPA</enumList>
                <enumList>AmpliamentoColocazione</enumList>
                <enumList>ValorizzazioneSLU</enumList>
                <enumList>CessazioneWLRLineaAttiva</enumList>
                <enumList>CessazioneWLRLineaNonAttiva</enumList>
                <enumList>CessazioneULL</enumList>
                <enumList>CessazionePA</enumList>
                <enumList>CessazioneColocazione</enumList>
                <enumList>CessazioneCPS</enumList>
                <enumList>CessazioneSLU</enumList>
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Richiesta" Value="ANNULLAMENTO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <enumList>ATTIVAZIONE</enumList>
                <enumList>CESSAZIONE</enumList>
                <enumList>VARIAZIONE</enumList>
                <enumList>MIGRAZIONE</enumList>
                <enumList>INTERRUZIONESOSPENSIONE</enumList>
                <enumList>RIMODULAZIONEDAD</enumList>
                <enumList>ANNULLAMENTO</enumList>
                <enumList>CANCELLAZIONEACCODAMENTO</enumList>
                <enumList>STATOAVANZAMENTO</enumList>
                <enumList>INTERRUZIONEMIGRAZIONE</enumList>
                <enumList>COMUNICAZIONE</enumList>
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:CodiceOrdineRiferimentoTI" Value="A" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:CodiceOrdineRiferimentoOLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:IdRisorsa" Value="AAA" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:IdCorrelazione" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.filemanager_tim.now.filemanager.acquisition.SystemLocator_GetSystem_NewRequest" Name="NewRequest">
        <informations Name="RichiestaLocalizzatore" tnsName="xs:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/SystemLocator/" nameSpace="xmlns:xs" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/SystemLocator/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tim.com/NOW/xsd/SystemLocator/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/CommonSchema/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:RichiestaLocalizzatore" Value="&#xA;  ">
            <parameters Name="tns0:Testata" Value="&#xA;    ">
              <parameters Name="tns0:Transaction_id" Value="ID" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="testataType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Transaction_date" Value="2016-05-04T13:05:00.000" type="dateTime" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="testataType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Sistema_origine" Value="NOW" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="testataType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
            </parameters>
            <parameters Name="tns0:Richiesta" Value="&#xA;    ">
              <parameters Name="tns0:DataRichiesta" Value="2016-05-14T13:05:00.000" type="dateTime" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:CodiceOLO" Value="REX" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:CodiceISP" Value="100" type="int" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:ModalitaAcq" Value="F" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Comune" Value="1" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Localita" Value="ROMA" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Servizio" Value="ULLLineaAttiva" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:FlagNaked" Value="S" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Richiesta" Value="ATTIVAZIONE" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <enumList>ATTIVAZIONE</enumList>
                <enumList>CESSAZIONE</enumList>
                <enumList>VARIAZIONE</enumList>
                <enumList>MIGRAZIONE</enumList>
                <enumList>INTERRUZIONESOSPENSIONE</enumList>
                <enumList>RIMODULAZIONEDAD</enumList>
                <enumList>ANNULLAMENTO</enumList>
                <enumList>CANCELLAZIONEACCODAMENTO</enumList>
                <enumList>STATOAVANZAMENTO</enumList>
                <enumList>INTERRUZIONEMIGRAZIONE</enumList>
                <enumList>COMUNICAZIONE</enumList>
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:CodiceOrdineRiferimentoTI" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:CodiceOrdineRiferimentoOLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:IdRisorsa" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:IdCorrelazione" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.filemanager.acquisition.SystemLocatorTLC" Name="tim.now.filemanager.acquisition.SystemLocatorTLC" ModelType="BW" moduleName="tim.now.filemanager">
    <Operation Name="GetSystem" serviceName="SystemLocatorPortType">
      <Inputs Id="tim.now.filemanager_tim.now.filemanager.acquisition.SystemLocatorTLC_GetSystem_Request" Name="Request" isDefault="true">
        <informations Name="RichiestaLocalizzatore" tnsName="xs:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/SystemLocator/" nameSpace="xmlns:xs" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/SystemLocator/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tim.com/NOW/xsd/SystemLocator/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/CommonSchema/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:RichiestaLocalizzatore" Value="&#xA;  ">
            <parameters Name="tns0:Testata" Value="&#xA;    ">
              <parameters Name="tns0:Transaction_id" Value="ID" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="testataType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Transaction_date" Value="2001-12-17T09:30:47.0Z" type="dateTime" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="testataType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Sistema_origine" Value="NOW" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="testataType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
            </parameters>
            <parameters Name="tns0:Richiesta" Value="&#xA;    ">
              <parameters Name="tns0:DataRichiesta" Value="2000-10-06T09:30:47.0Z" type="dateTime" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:CodiceOLOAGCOM" Value="WIN" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:CodiceISP" Value="100" type="int" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:ModalitaAcq" Value="F" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Comune" Value="ROMA" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Localita" Value="LAZIO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Servizio" Value="ULLLineaNonAttiva" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <enumList>WLRLineaAttiva</enumList>
                <enumList>WLRLineaNonAttiva</enumList>
                <enumList>ULLLineaAttiva</enumList>
                <enumList>ULLLineaNonAttiva</enumList>
                <enumList>ULLLineaAttivaNP</enumList>
                <enumList>ULLDatiLineaAttiva</enumList>
                <enumList>ULLDatiLineaAttivaNP</enumList>
                <enumList>ULLDatiLineaNonAttiva</enumList>
                <enumList>VULL</enumList>
                <enumList>SHASenzaManoDopera</enumList>
                <enumList>SHAConManoDopera</enumList>
                <enumList>ProlungamentoAccesso</enumList>
                <enumList>CPS</enumList>
                <enumList>Colocazione</enumList>
                <enumList>SLULineaAttiva</enumList>
                <enumList>SLULineaNonAttiva</enumList>
                <enumList>SLULineaAttivaNP</enumList>
                <enumList>ValorizzazioneWLR</enumList>
                <enumList>ValorizzazioneULL</enumList>
                <enumList>AmpliamentoPA</enumList>
                <enumList>AmpliamentoColocazione</enumList>
                <enumList>ValorizzazioneSLU</enumList>
                <enumList>CessazioneWLRLineaAttiva</enumList>
                <enumList>CessazioneWLRLineaNonAttiva</enumList>
                <enumList>CessazioneULL</enumList>
                <enumList>CessazionePA</enumList>
                <enumList>CessazioneColocazione</enumList>
                <enumList>CessazioneCPS</enumList>
                <enumList>CessazioneSLU</enumList>
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Richiesta" Value="ANNULLAMENTO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <enumList>ATTIVAZIONE</enumList>
                <enumList>CESSAZIONE</enumList>
                <enumList>VARIAZIONE</enumList>
                <enumList>MIGRAZIONE</enumList>
                <enumList>INTERRUZIONESOSPENSIONE</enumList>
                <enumList>RIMODULAZIONEDAD</enumList>
                <enumList>ANNULLAMENTO</enumList>
                <enumList>CANCELLAZIONEACCODAMENTO</enumList>
                <enumList>STATOAVANZAMENTO</enumList>
                <enumList>INTERRUZIONEMIGRAZIONE</enumList>
                <enumList>COMUNICAZIONE</enumList>
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:CodiceOrdineRiferimentoTI" Value="A" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:CodiceOrdineRiferimentoOLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:IdRisorsa" Value="AAA" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:IdCorrelazione" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.filemanager_tim.now.filemanager.acquisition.SystemLocatorTLC_GetSystem_NewRequest" Name="NewRequest">
        <informations Name="RichiestaLocalizzatore" tnsName="xs:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/SystemLocator/" nameSpace="xmlns:xs" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/SystemLocator/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tim.com/NOW/xsd/SystemLocator/"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/xsd/CommonSchema/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:RichiestaLocalizzatore" Value="&#xA;  ">
            <parameters Name="tns0:Testata" Value="&#xA;    ">
              <parameters Name="tns0:Transaction_id" Value="ID" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="testataType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Transaction_date" Value="2016-05-04T13:05:00.000" type="dateTime" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="testataType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Sistema_origine" Value="NOW" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="testataType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
            </parameters>
            <parameters Name="tns0:Richiesta" Value="&#xA;    ">
              <parameters Name="tns0:DataRichiesta" Value="2016-05-14T13:05:00.000" type="dateTime" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:CodiceOLO" Value="REX" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:CodiceISP" Value="100" type="int" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:ModalitaAcq" Value="F" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Comune" Value="1" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Localita" Value="ROMA" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Servizio" Value="ULLLineaAttiva" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:FlagNaked" Value="S" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:Richiesta" Value="ATTIVAZIONE" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/">
                <enumList>ATTIVAZIONE</enumList>
                <enumList>CESSAZIONE</enumList>
                <enumList>VARIAZIONE</enumList>
                <enumList>MIGRAZIONE</enumList>
                <enumList>INTERRUZIONESOSPENSIONE</enumList>
                <enumList>RIMODULAZIONEDAD</enumList>
                <enumList>ANNULLAMENTO</enumList>
                <enumList>CANCELLAZIONEACCODAMENTO</enumList>
                <enumList>STATOAVANZAMENTO</enumList>
                <enumList>INTERRUZIONEMIGRAZIONE</enumList>
                <enumList>COMUNICAZIONE</enumList>
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:CodiceOrdineRiferimentoTI" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:CodiceOrdineRiferimentoOLO" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:IdRisorsa" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
              <parameters Name="tns0:IdCorrelazione" type="string" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/" canDelete="true">
                <parent Name="richiestaType" nameSpace="http://www.tim.com/NOW/xsd/SystemLocator/"/>
              </parameters>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.filemanager.crmws.NOWtoCRMWS_CheckConsistenza" Name="tim.now.filemanager.crmws.NOWtoCRMWS_CheckConsistenza" ModelType="BW" moduleName="tim.now.filemanager">
    <Operation Name="NOWtoCRMWS_CheckConsistenza" serviceName="NOWtoCRMWS_CheckConsistenzaPortType">
      <Inputs Id="tim.now.filemanager_tim.now.filemanager.crmws.NOWtoCRMWS_CheckConsistenza_NOWtoCRMWS_CheckConsistenza_Request" Name="Request" isDefault="true">
        <informations Name="CheckConsistenzaRequest" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/NOWtoCRMWS_CheckConsistenza/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/NOWtoCRMWS_CheckConsistenza/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tim.com/NOW/xsd/NOWtoCRMWS_CheckConsistenza/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:REQUEST">
            <parameters Name="tns0:REQUEST">
              <parameters Name="tns0:DATA_RICHIESTA" Value="2016-04-30T10:03:00.000" type="dateTime" nameSpace="http://www.tim.com/NOW/xsd/NOWtoCRMWS_CheckConsistenza/">
                <parent Name="requestType" nameSpace="http://www.tim.com/NOW/xsd/NOWtoCRMWS_CheckConsistenza/"/>
              </parameters>
              <parameters Name="tns0:CODICE_OLO" Value="bbb" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOWtoCRMWS_CheckConsistenza/">
                <parent Name="requestType" nameSpace="http://www.tim.com/NOW/xsd/NOWtoCRMWS_CheckConsistenza/"/>
              </parameters>
              <parameters Name="tns0:ID_RISORSA" Value="prova" type="string" nameSpace="http://www.tim.com/NOW/xsd/NOWtoCRMWS_CheckConsistenza/">
                <parent Name="requestType" nameSpace="http://www.tim.com/NOW/xsd/NOWtoCRMWS_CheckConsistenza/"/>
              </parameters>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
