<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.gui_integration">
  <ProcessNode Id="tim.now.gui_integration.db.ClienteDB" Name="tim.now.gui_integration.db.ClienteDB" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="getListaOloPerOrdine" serviceName="Cliente">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.ClienteDB_getListaOloPerOrdine_operationInput" Name="operationInput" isDefault="true"/>
    </Operation>
    <Operation Name="isOloAccorpante" serviceName="Cliente">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.ClienteDB_isOloAccorpante_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="recuperoOloNonUnivoco" serviceName="Cliente">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.ClienteDB_recuperoOloNonUnivoco_Request" Name="Request" isDefault="true">
        <informations Name="input" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/Cliente/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/Cliente/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tim.com/NOW/cmf/RecuperoOloConCodiceOloNumericoNonUnivoco"/>
          <nameSpaces prefix="tns1" nameSapce="http://www.tim.com/NOW/cmf/cliente"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:recuperoOloInput">
            <parameters Name="tns0:codiceAgcom" Value="WIN" type="string" nameSpace="http://www.tim.com/NOW/cmf/RecuperoOloConCodiceOloNumericoNonUnivoco" canDelete="true">
              <parent Name="recuperoOloInputType" nameSpace="http://www.tim.com/NOW/cmf/RecuperoOloConCodiceOloNumericoNonUnivoco"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.db.DatiSedeNuovoOrdineDB" Name="tim.now.gui_integration.db.DatiSedeNuovoOrdineDB" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="DatiSedeNuovoOrdineOperation" serviceName="DatiSedeNuovoOrdine">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.DatiSedeNuovoOrdineDB_DatiSedeNuovoOrdineOperation_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.db.FAQ_DB" Name="tim.now.gui_integration.db.FAQ_DB" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="listaFAQ" serviceName="FAQ">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.FAQ_DB_listaFAQ_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="addFAQ" serviceName="FAQ">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.FAQ_DB_addFAQ_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="eliminaFAQ" serviceName="FAQ">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.FAQ_DB_eliminaFAQ_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="modificaFAQ" serviceName="FAQ">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.FAQ_DB_modificaFAQ_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.db.FileDB" Name="tim.now.gui_integration.db.FileDB" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="getFileList" serviceName="FileService">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.FileDB_getFileList_operationInput" Name="operationInput" isDefault="true"/>
    </Operation>
    <Operation Name="downloadFile" serviceName="FileService">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.FileDB_downloadFile_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="SEMAFORO" serviceName="FileService">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.FileDB_SEMAFORO_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="Visualizza" serviceName="FileService">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.FileDB_Visualizza_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="getOloList" serviceName="FileService">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.FileDB_getOloList_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="Accorpante" serviceName="FileService">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.FileDB_Accorpante_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.db.IHelp_DB" Name="tim.now.gui_integration.db.IHelp_DB" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="aggiungiIHelp" serviceName="IHelp">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.IHelp_DB_aggiungiIHelp_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="modificaIHelp" serviceName="IHelp">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.IHelp_DB_modificaIHelp_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="listaIHelp" serviceName="IHelp">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.IHelp_DB_listaIHelp_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="eliminaIHelp" serviceName="IHelp">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.IHelp_DB_eliminaIHelp_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.db.LoginLogoutInsert" Name="tim.now.gui_integration.db.LoginLogoutInsert" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="callProcess" serviceName="tim.now.gui_integration.db.LoginLogoutInsert">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.LoginLogoutInsert_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.db.NewVisualizzazione" Name="tim.now.gui_integration.db.NewVisualizzazione" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="getListaFile" serviceName="DbRecuperoServizi">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.NewVisualizzazione_getListaFile_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="getListaOlo" serviceName="DbRecuperoServizi">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.NewVisualizzazione_getListaOlo_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="getStatoSemaforo" serviceName="DbRecuperoServizi">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.NewVisualizzazione_getStatoSemaforo_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="visualizzazione" serviceName="DbRecuperoServizi">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.NewVisualizzazione_visualizzazione_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="getAccorpante" serviceName="DbRecuperoServizi">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.NewVisualizzazione_getAccorpante_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="getNonOlo" serviceName="DbRecuperoServizi">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.NewVisualizzazione_getNonOlo_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.db.NewsInformativeMigrazioneDB" Name="tim.now.gui_integration.db.NewsInformativeMigrazioneDB" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="ListaNewsEInfoMig" serviceName="ListaNewsInfoMig">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.NewsInformativeMigrazioneDB_ListaNewsEInfoMig_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="AggiungiNewsEInfoMig" serviceName="ListaNewsInfoMig">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.NewsInformativeMigrazioneDB_AggiungiNewsEInfoMig_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="ModificaNewsEInfoMig" serviceName="ListaNewsInfoMig">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.NewsInformativeMigrazioneDB_ModificaNewsEInfoMig_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="EliminiNewsEInfoMig" serviceName="ListaNewsInfoMig">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.NewsInformativeMigrazioneDB_EliminiNewsEInfoMig_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.db.OrdiniDB" Name="tim.now.gui_integration.db.OrdiniDB" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="OrdersList" serviceName="OrderPort">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.OrdiniDB_OrdersList_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="OrdersData" serviceName="OrderPort">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.OrdiniDB_OrdersData_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="Service" serviceName="OrderPort">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.OrdiniDB_Service_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="Referents" serviceName="OrderPort">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.OrdiniDB_Referents_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="OrdersDetails" serviceName="OrderPort">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.OrdiniDB_OrdersDetails_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="OrdersListNoOlo" serviceName="OrderPort">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.OrdiniDB_OrdersListNoOlo_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="VisualizzazioneEsitiRichieste" serviceName="OrderPort">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.OrdiniDB_VisualizzazioneEsitiRichieste_Request" Name="Request" isDefault="true"/>
    </Operation>
    <Operation Name="Customization" serviceName="OrderPort">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.OrdiniDB_Customization_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.db.listedettaglio" Name="tim.now.gui_integration.db.listedettaglio" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="listadettaglioAsset" serviceName="listedettaglio">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.db.listedettaglio_listadettaglioAsset_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.AnagraficaContratti" Name="tim.now.gui_integration.rest.AnagraficaContratti" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="ListaAnagraficaContratti">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.AnagraficaContratti_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="post" serviceName="ListaAnagraficaContratti">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.AnagraficaContratti_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.CalendarioFestivita" Name="tim.now.gui_integration.rest.CalendarioFestivita" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="calendariofestivita-get">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.CalendarioFestivita_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="post" serviceName="calendariofestivita-post">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.CalendarioFestivita_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
    <Operation Name="delete" serviceName="calendariofestivita-delete-dataFestivita">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.CalendarioFestivita_delete_deleteInput" Name="deleteInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.Caricamentodafilegui" Name="tim.now.gui_integration.rest.Caricamentodafilegui" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="post" serviceName="caricamentodafilegui">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.Caricamentodafilegui_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.Check_COD_OLO_UNIVOCO" Name="tim.now.gui_integration.rest.Check_COD_OLO_UNIVOCO" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="check_cod_olo_uniuoco">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.Check_COD_OLO_UNIVOCO_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.ClienteAnagrafiche" Name="tim.now.gui_integration.rest.ClienteAnagrafiche" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="clienteanagrafiche">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.ClienteAnagrafiche_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="post" serviceName="clienteanagrafiche">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.ClienteAnagrafiche_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.DettaglioUtente" Name="tim.now.gui_integration.rest.DettaglioUtente" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="dettaglioutente">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.DettaglioUtente_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.Download" Name="tim.now.gui_integration.rest.Download" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="download">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.Download_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.ExportData" Name="tim.now.gui_integration.rest.ExportData" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="exportdata-listadettaglioasset">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.ExportData_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.ExportListaOrdini" Name="tim.now.gui_integration.rest.ExportListaOrdini" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="post" serviceName="exportlistaordini">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.ExportListaOrdini_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.FAQ" Name="tim.now.gui_integration.rest.FAQ" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="faq-get">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.FAQ_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="post" serviceName="faq-post">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.FAQ_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
    <Operation Name="put" serviceName="faq-put">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.FAQ_put_putInput" Name="putInput" isDefault="true"/>
    </Operation>
    <Operation Name="delete" serviceName="faq-delete">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.FAQ_delete_deleteInput" Name="deleteInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.FileDiNotifiche" Name="tim.now.gui_integration.rest.FileDiNotifiche" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="filedinotifiche">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.FileDiNotifiche_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.GetMenuHelp" Name="tim.now.gui_integration.rest.GetMenuHelp" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="getmenuhelp">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.GetMenuHelp_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.IHelp" Name="tim.now.gui_integration.rest.IHelp" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="post" serviceName="ihelp-post">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.IHelp_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
    <Operation Name="get" serviceName="ihelp-get">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.IHelp_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="put" serviceName="ihelp-put">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.IHelp_put_putInput" Name="putInput" isDefault="true"/>
    </Operation>
    <Operation Name="delete" serviceName="ihelp1">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.IHelp_delete_deleteInput" Name="deleteInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.LoggerService" Name="tim.now.gui_integration.rest.LoggerService" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="post" serviceName="loggerservice">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.LoggerService_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.NewsInformativeMigrazione" Name="tim.now.gui_integration.rest.NewsInformativeMigrazione" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="NewsInformativeMigrazione">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.NewsInformativeMigrazione_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="post" serviceName="newsinformativemigrazione-post">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.NewsInformativeMigrazione_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
    <Operation Name="put" serviceName="newsinformativemigrazione-put">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.NewsInformativeMigrazione_put_putInput" Name="putInput" isDefault="true"/>
    </Operation>
    <Operation Name="delete" serviceName="newsinformativemigrazione-delete">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.NewsInformativeMigrazione_delete_deleteInput" Name="deleteInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.OrdiniDonating" Name="tim.now.gui_integration.rest.OrdiniDonating" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="ricercaordinidonating">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.OrdiniDonating_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="get" serviceName="dettaglioordinidonating">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.OrdiniDonating_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.PaginaDiDisambiguazione" Name="tim.now.gui_integration.rest.PaginaDiDisambiguazione" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="paginadidisambiguazione">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.PaginaDiDisambiguazione_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.Profilatura" Name="tim.now.gui_integration.rest.Profilatura" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="CaricamentoAreeFunzionalita">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.Profilatura_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.ProfiliLinea" Name="tim.now.gui_integration.rest.ProfiliLinea" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="profililinea">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.ProfiliLinea_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="post" serviceName="profililinea">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.ProfiliLinea_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.ProfiliVc" Name="tim.now.gui_integration.rest.ProfiliVc" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="profilivc">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.ProfiliVc_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="post" serviceName="profilivc">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.ProfiliVc_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.RecuperoDatiOTDBNOW" Name="tim.now.gui_integration.rest.RecuperoDatiOTDBNOW" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="post" serviceName="recuperodatiotdbnow">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.RecuperoDatiOTDBNOW_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.RecuperoExportDati" Name="tim.now.gui_integration.rest.RecuperoExportDati" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="recuperoexportdati">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.RecuperoExportDati_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.RicercaCampi" Name="tim.now.gui_integration.rest.RicercaCampi" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="ricercacampi">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.RicercaCampi_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.Salvaricerca" Name="tim.now.gui_integration.rest.Salvaricerca" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="post" serviceName="salvaricerca">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.Salvaricerca_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
    <Operation Name="get" serviceName="salvaricerca">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.Salvaricerca_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="delete" serviceName="salvaricerca">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.Salvaricerca_delete_deleteInput" Name="deleteInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.SystemLocator" Name="tim.now.gui_integration.rest.SystemLocator" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="post" serviceName="systemlocator1">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.SystemLocator_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.VerificaCodice_OLO_numerico" Name="tim.now.gui_integration.rest.VerificaCodice_OLO_numerico" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="verificacodice_olo_numerico">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.VerificaCodice_OLO_numerico_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.VerificaRichiesta" Name="tim.now.gui_integration.rest.VerificaRichiesta" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="verificarichiesta">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.VerificaRichiesta_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.VisualizzaExternalData" Name="tim.now.gui_integration.rest.VisualizzaExternalData" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="visualizzaexternaldata-eventidtu">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.VisualizzaExternalData_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="get" serviceName="visualizzaexternaldata-eventijpub">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.VisualizzaExternalData_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="get" serviceName="visualizzaexternaldata-dettagliodtu">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.VisualizzaExternalData_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.VisualizzaFileNotifiche" Name="tim.now.gui_integration.rest.VisualizzaFileNotifiche" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="visualizzafilenotifiche">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.VisualizzaFileNotifiche_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.VisualizzaOrdini" Name="tim.now.gui_integration.rest.VisualizzaOrdini" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="ListaOrdini">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.VisualizzaOrdini_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="get" serviceName="DataOrdini">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.VisualizzaOrdini_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="post" serviceName="ListaOrdini">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.VisualizzaOrdini_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.rest.VisualizzaSemaforofile" Name="tim.now.gui_integration.rest.VisualizzaSemaforofile" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="get" serviceName="visualizzasemaforofile">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.VisualizzaSemaforofile_get_getInput" Name="getInput" isDefault="true"/>
    </Operation>
    <Operation Name="post" serviceName="visualizzasemaforofile">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.rest.VisualizzaSemaforofile_post_postInput" Name="postInput" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.sub.CalendarioFestivita" Name="tim.now.gui_integration.sub.CalendarioFestivita" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="callProcess" serviceName="tim.now.gui_integration.sub.CalendarioFestivita">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.sub.CalendarioFestivita_callProcess_CalendarioFestivita" Name="CalendarioFestivita" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.sub.Call_Http_UNICARA" Name="tim.now.gui_integration.sub.Call_Http_UNICARA" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="callProcess" serviceName="tim.now.gui_integration.sub.Call_Http_UNICARA">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.sub.Call_Http_UNICARA_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.sub.ExportToExcelListaOrdineSub" Name="tim.now.gui_integration.sub.ExportToExcelListaOrdineSub" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="callProcess" serviceName="tim.now.gui_integration.sub.ExportToExcelListaOrdineSub">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.sub.ExportToExcelListaOrdineSub_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.sub.GenericLogger" Name="tim.now.gui_integration.sub.GenericLogger" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="callProcess" serviceName="tim.now.gui_integration.sub.GenericLogger">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.sub.GenericLogger_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.sub.GenericXmlToExcel" Name="tim.now.gui_integration.sub.GenericXmlToExcel" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="callProcess" serviceName="tim.now.gui_integration.sub.GenericXmlToExcel">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.sub.GenericXmlToExcel_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.sub.ListaOrdiniRicercaAvanzataSub" Name="tim.now.gui_integration.sub.ListaOrdiniRicercaAvanzataSub" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="callProcess" serviceName="tim.now.gui_integration.sub.ListaOrdiniRicercaAvanzataSub">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.sub.ListaOrdiniRicercaAvanzataSub_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.sub.ListaOrdiniSub" Name="tim.now.gui_integration.sub.ListaOrdiniSub" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="callProcess" serviceName="tim.now.gui_integration.sub.ListaOrdiniSub">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.sub.ListaOrdiniSub_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.sub.RecuperoDatiOTDBNOW" Name="tim.now.gui_integration.sub.RecuperoDatiOTDBNOW" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="callProcess" serviceName="tim.now.gui_integration.sub.RecuperoDatiOTDBNOW">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.sub.RecuperoDatiOTDBNOW_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.sub.RicercaAvanzataConditions" Name="tim.now.gui_integration.sub.RicercaAvanzataConditions" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="callProcess" serviceName="tim.now.gui_integration.sub.RicercaAvanzataConditions">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.sub.RicercaAvanzataConditions_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.sub.RicercaCampi" Name="tim.now.gui_integration.sub.RicercaCampi" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="callProcess" serviceName="tim.now.gui_integration.sub.RicercaCampi">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.sub.RicercaCampi_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.sub.VerificaOLO" Name="tim.now.gui_integration.sub.VerificaOLO" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="callProcess" serviceName="tim.now.gui_integration.sub.VerificaOLO">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.sub.VerificaOLO_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.gui_integration.sub.XmlToExcel" Name="tim.now.gui_integration.sub.XmlToExcel" ModelType="BW" moduleName="tim.now.gui_integration">
    <Operation Name="callProcess" serviceName="tim.now.gui_integration.sub.XmlToExcel">
      <Inputs Id="tim.now.gui_integration_tim.now.gui_integration.sub.XmlToExcel_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
