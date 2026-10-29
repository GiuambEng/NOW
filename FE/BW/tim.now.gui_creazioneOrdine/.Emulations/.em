<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.gui_creazioneOrdine">
  <ProcessNode Id="tim.now.fc_integration.Catalogo" Name="tim.now.fc_integration.Catalogo" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="get" serviceName="offerta">
      <Inputs Id="tim.now.fc_integration.Catalogo_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="get" serviceName="sceltaOfferta">
      <Inputs Id="tim.now.fc_integration.Catalogo_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.db.AssetDB" Name="tim.now.gui_creazioneOrdine.db.AssetDB" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="AssetListOperation" serviceName="AssetPort">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.AssetDB_AssetListOperation_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="AssetDetailsOperation" serviceName="AssetPort">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.AssetDB_AssetDetailsOperation_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.db.AutocompletamentoDatiSedeDB" Name="tim.now.gui_creazioneOrdine.db.AutocompletamentoDatiSedeDB" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="AutocompletamentoDatiSedeOperation" serviceName="AutocompletamentoDatiSedePortType">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.AutocompletamentoDatiSedeDB_AutocompletamentoDatiSedeOperation_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.db.ClienteDB" Name="tim.now.gui_creazioneOrdine.db.ClienteDB" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="getListaOloPerOrdine" serviceName="Cliente">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.ClienteDB_getListaOloPerOrdine_operationInput" Name="operationInput" isDefault="true"/>
    </Operation>
    <Operation Name="isOloAccorpante" serviceName="Cliente">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.ClienteDB_isOloAccorpante_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.db.CodiceProgettoDB" Name="tim.now.gui_creazioneOrdine.db.CodiceProgettoDB" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="CodiceProgettoOperation" serviceName="codiceProgetto">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.CodiceProgettoDB_CodiceProgettoOperation_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.db.ContattiDB" Name="tim.now.gui_creazioneOrdine.db.ContattiDB" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="getListaContattiOLO" serviceName="Contacts">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.ContattiDB_getListaContattiOLO_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="getDettaglioContatto" serviceName="Contacts">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.ContattiDB_getDettaglioContatto_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="getListaContattiOther" serviceName="Contacts">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.ContattiDB_getListaContattiOther_operationInput" Name="operationInput" isDefault="true"/>
    </Operation>
    <Operation Name="getRiferimentiContatto" serviceName="Contacts">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.ContattiDB_getRiferimentiContatto_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.db.ContrattoDB" Name="tim.now.gui_creazioneOrdine.db.ContrattoDB" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="getContrattiPerAttivazione" serviceName="ContrattoDB">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.ContrattoDB_getContrattiPerAttivazione_operationInput" Name="operationInput" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/ContrattoDB/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/ContrattoDB/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tim.com/NOW/cmf/contratti"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:ListaContrattiAttivazioneInput">
            <parameters Name="tns0:codiceAgcom" Value="OLO" type="string" nameSpace="http://www.tim.com/NOW/cmf/contratti">
              <parent Name="listaAttivazioneInput" nameSpace="http://www.tim.com/NOW/cmf/contratti"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
    <Operation Name="getDettaglioContratto" serviceName="ContrattoDB">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.ContrattoDB_getDettaglioContratto_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.db.FileDB" Name="tim.now.gui_creazioneOrdine.db.FileDB" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="getFileList" serviceName="FileService">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.FileDB_getFileList_operationInput" Name="operationInput" isDefault="true"/>
    </Operation>
    <Operation Name="downloadFile" serviceName="FileService">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.FileDB_downloadFile_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="SEMAFORO" serviceName="FileService">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.FileDB_SEMAFORO_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.db.OfferteDB" Name="tim.now.gui_creazioneOrdine.db.OfferteDB" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="getSceltaOfferteOperation" serviceName="sceltaOffertePortType">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.OfferteDB_getSceltaOfferteOperation_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.db.OrdiniDB" Name="tim.now.gui_creazioneOrdine.db.OrdiniDB" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="OrdersList" serviceName="OrderPort">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.OrdiniDB_OrdersList_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="OrdersData" serviceName="OrderPort">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.OrdiniDB_OrdersData_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="Service" serviceName="OrderPort">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.OrdiniDB_Service_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="Referents" serviceName="OrderPort">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.OrdiniDB_Referents_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="OrdersDetails" serviceName="OrderPort">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.OrdiniDB_OrdersDetails_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="OrdersListNoOlo" serviceName="OrderPort">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.OrdiniDB_OrdersListNoOlo_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="VisualizzazioneEsitiRichieste" serviceName="OrderPort">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.OrdiniDB_VisualizzazioneEsitiRichieste_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="Customization" serviceName="OrderPort">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.OrdiniDB_Customization_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.db.RecuperoOpId" Name="tim.now.gui_creazioneOrdine.db.RecuperoOpId" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="Recupero" serviceName="Service">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.RecuperoOpId_Recupero_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.db.VisualizzaIDSLUCODB" Name="tim.now.gui_creazioneOrdine.db.VisualizzaIDSLUCODB" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="visualizzaIDSLUCO" serviceName="VisualizzaIDSLUCO">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.VisualizzaIDSLUCODB_visualizzaIDSLUCO_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.db.VisualizzaIDULLCODB" Name="tim.now.gui_creazioneOrdine.db.VisualizzaIDULLCODB" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="visualizzaIDULLCO" serviceName="VisualizzaIDULLCO">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.VisualizzaIDULLCODB_visualizzaIDULLCO_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.db.VisualizzazioneEsitiRichieste" Name="tim.now.gui_creazioneOrdine.db.VisualizzazioneEsitiRichieste" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="VisualizzazioneEsitiRichieste" serviceName="VisualizzazioneEsitiRichieste">
      <Inputs Id="tim.now.gui_creazioneOrdine.db.VisualizzazioneEsitiRichieste_VisualizzazioneEsitiRichieste_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.rest.Asset" Name="tim.now.gui_creazioneOrdine.rest.Asset" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="get" serviceName="ListaAsset">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Asset_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="get" serviceName="DettaglioAsset">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Asset_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.rest.Contatto" Name="tim.now.gui_creazioneOrdine.rest.Contatto" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="get" serviceName="ListaContatti" isError="true">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Contatto_get_getInput" Name="getInput" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://xmlns.example.com/20160422093851PLT" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://xmlns.example.com/20160422093851PLT"/>
          <nameSpaces prefix="tns0" nameSapce="http://xmlns.example.com/20160417123217"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/cmf/cliente"/>
          <nameSpaces prefix="tns2" nameSapce="http://www.tim.com/NOW/cmf/contacts/"/>
          <nameSpaces prefix="tns3" nameSapce="http://tns.tibco.com/bw/REST"/>
          <nameSpaces prefix="tns4" nameSapce="http://xmlns.example.com/20160422093851PLT/ConceptSchema"/>
          <nameSpaces prefix="tns5" nameSapce="http://www.tim.com/NOW/wsdl/abstract/Contatti/"/>
          <nameSpaces prefix="tns6" nameSapce="http://www.tim.com/NOW/wsdl/abstract/Contacts/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns4:contattoParameters">
            <parameters Name="idContatto" Value="2" type="string"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Contatto_get_getInput" Name="getInput" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://xmlns.example.com/20160422093851PLT" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://xmlns.example.com/20160422093851PLT"/>
          <nameSpaces prefix="tns0" nameSapce="http://xmlns.example.com/20160417123217"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/cmf/cliente"/>
          <nameSpaces prefix="tns2" nameSapce="http://www.tim.com/NOW/cmf/contacts/"/>
          <nameSpaces prefix="tns3" nameSapce="http://tns.tibco.com/bw/REST"/>
          <nameSpaces prefix="tns4" nameSapce="http://xmlns.example.com/20160422093851PLT/ConceptSchema"/>
          <nameSpaces prefix="tns5" nameSapce="http://www.tim.com/NOW/wsdl/abstract/Contatti/"/>
          <nameSpaces prefix="tns6" nameSapce="http://www.tim.com/NOW/wsdl/abstract/Contacts/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns4:nuovordine-contatto1-ListaContattiGetParameters">
            <parameters Name="codOlo" type="string" canDelete="true"/>
            <parameters Name="tipoProfilo" type="string" canDelete="true"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
    <Operation Name="get" serviceName="DettaglioContatto">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Contatto_get_getInput" Name="getInput" isDefault="true"/>
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Contatto_get_getInput" Name="getInput" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://xmlns.example.com/20160422093851PLT" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://xmlns.example.com/20160422093851PLT"/>
          <nameSpaces prefix="tns0" nameSapce="http://xmlns.example.com/20160417123217"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/cmf/cliente"/>
          <nameSpaces prefix="tns2" nameSapce="http://www.tim.com/NOW/cmf/contacts/"/>
          <nameSpaces prefix="tns3" nameSapce="http://tns.tibco.com/bw/REST"/>
          <nameSpaces prefix="tns4" nameSapce="http://xmlns.example.com/20160422093851PLT/ConceptSchema"/>
          <nameSpaces prefix="tns5" nameSapce="http://www.tim.com/NOW/wsdl/abstract/Contatti/"/>
          <nameSpaces prefix="tns6" nameSapce="http://www.tim.com/NOW/wsdl/abstract/Contacts/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns4:contatto1Parameters">
            <parameters Name="idContatto" type="string"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
    <Operation Name="get" serviceName="RiferimentiContatto">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Contatto_get_getInput" Name="getInput" isDefault="true"/>
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Contatto_get_getInput" Name="getInput" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://xmlns.example.com/20160422093851PLT" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://xmlns.example.com/20160422093851PLT"/>
          <nameSpaces prefix="tns0" nameSapce="http://xmlns.example.com/20160417123217"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/cmf/cliente"/>
          <nameSpaces prefix="tns2" nameSapce="http://www.tim.com/NOW/cmf/contacts/"/>
          <nameSpaces prefix="tns3" nameSapce="http://tns.tibco.com/bw/REST"/>
          <nameSpaces prefix="tns4" nameSapce="http://xmlns.example.com/20160422093851PLT/ConceptSchema"/>
          <nameSpaces prefix="tns5" nameSapce="http://www.tim.com/NOW/wsdl/abstract/Contatti/"/>
          <nameSpaces prefix="tns6" nameSapce="http://www.tim.com/NOW/wsdl/abstract/Contacts/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns4:contattoParameters">
            <parameters Name="idContatto" type="string"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.rest.Contratto" Name="tim.now.gui_creazioneOrdine.rest.Contratto" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="get" serviceName="VisualizzaContrattoOlo">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Contratto_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="get" serviceName="VerificaContrattoDiffidato">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Contratto_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.rest.NuovoOrdine" Name="tim.now.gui_creazioneOrdine.rest.NuovoOrdine" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="post" serviceName="nuovoordine">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.NuovoOrdine_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.rest.Profilatura" Name="tim.now.gui_creazioneOrdine.rest.Profilatura" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="get" serviceName="CaricamentoAreeFunzionalita">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Profilatura_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.rest.RecuperoOpId" Name="tim.now.gui_creazioneOrdine.rest.RecuperoOpId" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="get" serviceName="recupero">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.RecuperoOpId_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.rest.Richiesta" Name="tim.now.gui_creazioneOrdine.rest.Richiesta" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="post" serviceName="NuovaRichiesta">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Richiesta_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.rest.UploadFileOrdiniERichieste" Name="tim.now.gui_creazioneOrdine.rest.UploadFileOrdiniERichieste" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="get" serviceName="VerificaAbilitazioneUpload">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.UploadFileOrdiniERichieste_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.rest.Utility" Name="tim.now.gui_creazioneOrdine.rest.Utility" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="get" serviceName="autocompletamentoDatiSede">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Utility_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="get" serviceName="VisualizzaIdullco">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Utility_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="get" serviceName="VisualizzaIdsluco">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Utility_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="get" serviceName="CodiceProgetto">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Utility_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="get" serviceName="VerificaDAClavorativo">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Utility_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="get" serviceName="VerificaDACSLA">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Utility_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.rest.VisualizzaAnagraficaOlo" Name="tim.now.gui_creazioneOrdine.rest.VisualizzaAnagraficaOlo" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="get" serviceName="VisualizzaAnagraficaOlo">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Cliente_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.rest.VisualizzaOrdini" Name="tim.now.gui_creazioneOrdine.rest.VisualizzaOrdini" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="get" serviceName="ListaOrdini">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.VisualizzaOrdini_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="get" serviceName="DataOrdini">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.VisualizzaOrdini_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.rest.Visualizzazione_Semaforo" Name="tim.now.gui_creazioneOrdine.rest.Visualizzazione_Semaforo" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="get" serviceName="visualizzazione_semaforo">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.Visualizzazione_Semaforo_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_creazioneOrdine.rest.visualizzazioneEsitiRichieste" Name="tim.now.gui_creazioneOrdine.rest.visualizzazioneEsitiRichieste" ModelType="BW" moduleName="tim.now.gui_creazioneOrdine">
    <Operation Name="get" serviceName="visualizzazioneEsitiRichieste">
      <Inputs Id="tim.now.gui_creazioneOrdine.rest.visualizzazioneEsitiRichieste_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
