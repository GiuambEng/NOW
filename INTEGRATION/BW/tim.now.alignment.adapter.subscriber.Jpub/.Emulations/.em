<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.alignment.adapter.subscriber.Jpub">
  <ProcessNode Id="tim.now.alignment.adapter.subscriber.Jpub.AllineamentoContratto" Name="tim.now.alignment.adapter.subscriber.Jpub.AllineamentoContratto" ModelType="BW" moduleName="tim.now.alignment.adapter.subscriber.Jpub">
    <Operation Name="SendVariazione" serviceName="AllineamentoContratto">
      <Inputs Id="tim.now.alignment.adapter.subscriber.Jpub_tim.now.alignment.adapter.subscriber.Jpub.AllineamentoContratto_SendVariazione_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="xs:" nameSpaceValue="http://www.tim.now/wsdl/abstract/allineamentoContrattoJpub" nameSpace="xmlns:xs" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.now/wsdl/abstract/allineamentoContrattoJpub"/>
          <nameSpaces prefix="tns0" nameSapce="http://tim.now.alignement.Jpub.adapter.Contratto"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:root" Value="&#xA;  ">
            <parameters Name="tns0:Contratto" isList="true">
              <parameters Name="tns0:COD_CONTRATTO" Value="11111" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:COD_OLO_NUMERICO_INTERNO_NOW" Value="147" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:CODFC_OLO_AGCOM" Value="INF" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:DATAFI_VALID" Value="2001-12-17T09:30:47.0Z" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:DATAINZ_VALID" Value="2001-12-17T09:30:47.0Z" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:FLAG_ABILITATO" Value="N" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:FLAG_ANFIBIO" Value="N" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:FLAG_DIFFIDATO" Value="N" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:FLAG_FILE_NOTIFY" Value="N" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:FLAG_NPD" Value="Y" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:FLAG_STANDARD" Value="N" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:FLAG_VALIDO" Value="Y" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:ID_COD_CONTRATTO_PADRE" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:ID_CONTRATTO" Value="4283" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:ID_CONTRATTO_CRMWS" Value="1-3WE92V" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:ID_FAMIG_OFFERTA" Value="2" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:ID_SOTTOFAMIG_OFFERTA" Value="4" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:ID_STATO_CONTRATTO" Value="6" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:IDTPLG_CONTRATTO" Value="7" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:NOME_CONTRATTO" Value="INFOSTRADA-BITSTREAM-ATM" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:NOME_STANDARD" Value="INFOSTRADA-BITSTREAM-ATM" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:OPERATORE" Value="AUTOMATICI" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:STATO_STANDARD" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:TIMSTP_AGGTO" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:TIMSTP_INSMTO" Value="2001-12-17T09:30:47.0Z" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:TIPO" Value="Service Level Agreement" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
              <parameters Name="tns0:ADB_TRACKING_ID" Value="I" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.Contratto" canDelete="true"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.alignment.adapter.subscriber.Jpub.AllineamentoOLO" Name="tim.now.alignment.adapter.subscriber.Jpub.AllineamentoOLO" ModelType="BW" moduleName="tim.now.alignment.adapter.subscriber.Jpub">
    <Operation Name="SendVariazione" serviceName="AllineamentoOlo">
      <Inputs Id="tim.now.alignment.adapter.subscriber.Jpub_tim.now.alignment.adapter.subscriber.Jpub.AllineamentoOLO_SendVariazione_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="xs:" nameSpaceValue="http://xmlns.example.com/1461575829766" nameSpace="xmlns:xs" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://xmlns.example.com/1461575829766"/>
          <nameSpaces prefix="tns0" nameSapce="http://tim.now.alignement.Jpub.adapter.OLO"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:root" Value="&#xA;  ">
            <parameters Name="tns0:AnagraficaOLO" isList="true">
              <parameters Name="tns0:COD_OLO_NUMERICO_INTERNO_NOW" Value="String" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:COD_OLO_ACCORPANTE" Value="String" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:CODFC_OLO_AGCOM" Value="FAS" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:CODFC_OLO_RETE" Value="String" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:DATA_ACCORPTO" Value="String" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:DATA_AGGTO" Value="String" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:FLAG_OLO_ACCORPANTE" Value="String" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:FLAG_OLO_TRANSITORIO" Value="String" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:FLAG_SAN_MARINO" Value="String" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:IDTPLG_OLO" Value="String" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:INDIRIZZO_EMAIL" Value="String" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:MOROSO" Value="String" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:NOME" Value="Nico" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:OPERATORE" Value="String" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:PARTITA_IVA" Value="11111111451" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:RAGIONE_SOCIALE" Value="METROWEB GENOVA" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:STATO_ACCORPTO" Value="String" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:TIMSTP_INSMTO" Value="String" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:ADB_TRACKING_ID" Value="String" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.alignment.adapter.subscriber.Jpub_tim.now.alignment.adapter.subscriber.Jpub.AllineamentoOLO_SendVariazione_Request" Name="Request" isDefault="true">
        <informations Name="part1" tnsName="tns:" nameSpaceValue="http://xmlns.example.com/1461575829766" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://xmlns.example.com/1461575829766"/>
          <nameSpaces prefix="tns0" nameSapce="http://tim.now.alignement.Jpub.adapter.OLO"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:root">
            <parameters Name="tns0:AnagraficaOLO" isList="true">
              <parameters Name="tns0:COD_OLO_NUMERICO_INTERNO_NOW" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:COD_OLO_ACCORPANTE" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:CODFC_OLO_AGCOM" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:CODFC_OLO_RETE" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:DATA_ACCORPTO" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:DATA_AGGTO" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:FLAG_OLO_ACCORPANTE" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:FLAG_OLO_TRANSITORIO" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:FLAG_SAN_MARINO" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:IDTPLG_OLO" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:INDIRIZZO_EMAIL" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:MOROSO" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:NOME" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:OPERATORE" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:PARTITA_IVA" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:RAGIONE_SOCIALE" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:STATO_ACCORPTO" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:TIMSTP_INSMTO" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
              <parameters Name="tns0:ADB_TRACKING_ID" type="string" nameSpace="http://tim.now.alignement.Jpub.adapter.OLO" canDelete="true"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.alignment.adapter.subscriber.Jpub.Staging" Name="tim.now.alignment.adapter.subscriber.Jpub.Staging" ModelType="BW" moduleName="tim.now.alignment.adapter.subscriber.Jpub">
    <Operation Name="callProcess" serviceName="tim.now.alignment.adapter.subscriber.Jpub.Staging">
      <Inputs Id="tim.now.alignment.adapter.subscriber.Jpub_tim.now.alignment.adapter.subscriber.Jpub.Staging_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
