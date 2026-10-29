<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="tim.now.notificationmanager">
  <ProcessNode Id="tim.now.notificationmanager.NotificationManager" Name="tim.now.notificationmanager.NotificationManager" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="CreateNotification" serviceName="NotificationManagerPortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.NotificationManager_CreateNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.Notification_Interfaccia" Name="tim.now.notificationmanager.Notification_Interfaccia" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_Interfaccia">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.Notification_Interfaccia_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.nga.Notification_nga" Name="tim.now.notificationmanager.nga.Notification_nga" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_nga">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.nga.Notification_nga_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.np.JDBCQuery" Name="tim.now.notificationmanager.np.JDBCQuery" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="JDBCQuery" serviceName="JDBCQueryPortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.np.JDBCQuery_JDBCQuery_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.np.Notification_np_Annullamento" Name="tim.now.notificationmanager.np.Notification_np_Annullamento" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_np_Annullamento">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.np.Notification_np_Annullamento_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.np.Notification_np_ComEsitoDonorRecipient" Name="tim.now.notificationmanager.np.Notification_np_ComEsitoDonorRecipient" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_np_ComEsitoDonorRecipient">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.np.Notification_np_ComEsitoDonorRecipient_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.np.Notification_np_EspletamentoCessazione" Name="tim.now.notificationmanager.np.Notification_np_EspletamentoCessazione" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_np_EspletamentoCessazione">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.np.Notification_np_EspletamentoCessazione_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.np.Notification_np_EspletamentoDonorRecipientDonating" Name="tim.now.notificationmanager.np.Notification_np_EspletamentoDonorRecipientDonating" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_np_EspletamentoDonorRecipientDonating">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.np.Notification_np_EspletamentoDonorRecipientDonating_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.np.Notification_np_PrenotificaDonating" Name="tim.now.notificationmanager.np.Notification_np_PrenotificaDonating" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_np_PrenotificaDonating">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.np.Notification_np_PrenotificaDonating_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.np.Notification_np_RimodulazioneDAC" Name="tim.now.notificationmanager.np.Notification_np_RimodulazioneDAC" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_np_RimodulazioneDAC">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.np.Notification_np_RimodulazioneDAC_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.np.Notification_np_ValidFormaleCessazione" Name="tim.now.notificationmanager.np.Notification_np_ValidFormaleCessazione" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_np_ValidFormaleCessazione">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.np.Notification_np_ValidFormaleCessazione_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.np.Notification_np_ValidFormaleDonatingDonor" Name="tim.now.notificationmanager.np.Notification_np_ValidFormaleDonatingDonor" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_np_ValidFormaleDonatingDonor">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.np.Notification_np_ValidFormaleDonatingDonor_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.np.Notification_np_ValidFormaleDonorRecipient" Name="tim.now.notificationmanager.np.Notification_np_ValidFormaleDonorRecipient" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_np_ValidFormaleDonorRecipient">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.np.Notification_np_ValidFormaleDonorRecipient_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.np.Notification_np_ValidTecnicaCessazione" Name="tim.now.notificationmanager.np.Notification_np_ValidTecnicaCessazione" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_np_ValidTecnicaCessazione">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.np.Notification_np_ValidTecnicaCessazione_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.np.Notification_np_ValidTecnicaDonatingDonor" Name="tim.now.notificationmanager.np.Notification_np_ValidTecnicaDonatingDonor" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_np_ValidTecnicaDonatingDonor">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.np.Notification_np_ValidTecnicaDonatingDonor_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_Accettazione" Name="tim.now.notificationmanager.regolatorio.Notification_reg_Accettazione" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_Accettazione">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_Accettazione_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_Accodamento" Name="tim.now.notificationmanager.regolatorio.Notification_reg_Accodamento" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_Accodamento">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_Accodamento_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_Acquisizione" Name="tim.now.notificationmanager.regolatorio.Notification_reg_Acquisizione" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_Acquisizione">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_Acquisizione_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_Annullamento" Name="tim.now.notificationmanager.regolatorio.Notification_reg_Annullamento" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_Annullamento">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_Annullamento_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_CessazionePerNP" Name="tim.now.notificationmanager.regolatorio.Notification_reg_CessazionePerNP" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_CessazionePerNP">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_CessazionePerNP_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_DataAppuntamento" Name="tim.now.notificationmanager.regolatorio.Notification_reg_DataAppuntamento" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_DataAppuntamento">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_DataAppuntamento_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_Espletamento" Name="tim.now.notificationmanager.regolatorio.Notification_reg_Espletamento" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_Espletamento">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_Espletamento_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_InCaricoADelivery" Name="tim.now.notificationmanager.regolatorio.Notification_reg_InCaricoADelivery" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_InCaricoADelivery">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_InCaricoADelivery_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_InizioAttivita" Name="tim.now.notificationmanager.regolatorio.Notification_reg_InizioAttivita" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_InizioAttivita">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_InizioAttivita_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_InterruzioneSospensione" Name="tim.now.notificationmanager.regolatorio.Notification_reg_InterruzioneSospensione" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_InterruzioneSospensione">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_InterruzioneSospensione_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_PreventivoOpereSpeciali" Name="tim.now.notificationmanager.regolatorio.Notification_reg_PreventivoOpereSpeciali" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_PreventivoOpereSpeciali">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_PreventivoOpereSpeciali_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_RagioneSocialeSU" Name="tim.now.notificationmanager.regolatorio.Notification_reg_RagioneSocialeSU" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_RagioneSocialeSU">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_RagioneSocialeSU_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_RifiutoAnnullamento" Name="tim.now.notificationmanager.regolatorio.Notification_reg_RifiutoAnnullamento" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_RifiutoAnnullamento">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_RifiutoAnnullamento_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_RifiutoRimodulazioneDACdaRecipient" Name="tim.now.notificationmanager.regolatorio.Notification_reg_RifiutoRimodulazioneDACdaRecipient" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_RifiutoRimodulazioneDACdaRecipient">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_RifiutoRimodulazioneDACdaRecipient_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_RimodulazioneAppuntamento" Name="tim.now.notificationmanager.regolatorio.Notification_reg_RimodulazioneAppuntamento" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_RimodulazioneAppuntamento">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_RimodulazioneAppuntamento_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_RimodulazioneDAC" Name="tim.now.notificationmanager.regolatorio.Notification_reg_RimodulazioneDAC" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_RimodulazioneDAC">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_RimodulazioneDAC_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_RimodulazioneDPS" Name="tim.now.notificationmanager.regolatorio.Notification_reg_RimodulazioneDPS" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_RimodulazioneDPS">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_RimodulazioneDPS_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_Sospensione" Name="tim.now.notificationmanager.regolatorio.Notification_reg_Sospensione" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_Sospensione">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_Sospensione_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_StatoAvanzamento" Name="tim.now.notificationmanager.regolatorio.Notification_reg_StatoAvanzamento" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_StatoAvanzamento">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_StatoAvanzamento_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.Notification_reg_TentativiContatto" Name="tim.now.notificationmanager.regolatorio.Notification_reg_TentativiContatto" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_TentativiContatto">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.Notification_reg_TentativiContatto_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.cps.Notification_cps_EsitoEspletamento" Name="tim.now.notificationmanager.regolatorio.cps.Notification_cps_EsitoEspletamento" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_cps_EsitoEspletamento">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.cps.Notification_cps_EsitoEspletamento_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.cps.Notification_cps_EsitoValidazione" Name="tim.now.notificationmanager.regolatorio.cps.Notification_cps_EsitoValidazione" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_cps_EsitoValidazione">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.cps.Notification_cps_EsitoValidazione_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.cps.Notification_cps_EsitoVerifiche" Name="tim.now.notificationmanager.regolatorio.cps.Notification_cps_EsitoVerifiche" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_cps_EsitoVerifiche">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.cps.Notification_cps_EsitoVerifiche_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.cps.Notification_cps_NotificaCessazione" Name="tim.now.notificationmanager.regolatorio.cps.Notification_cps_NotificaCessazione" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_cps_NotificaCessazione">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.cps.Notification_cps_NotificaCessazione_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.cps.Notification_cps_PreavvisoCessazione" Name="tim.now.notificationmanager.regolatorio.cps.Notification_cps_PreavvisoCessazione" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_cps_PreavvisoCessazione">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.cps.Notification_cps_PreavvisoCessazione_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.cps.Notification_cps_StatoAvanzamento" Name="tim.now.notificationmanager.regolatorio.cps.Notification_cps_StatoAvanzamento" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_cps_StatoAvanzamento">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.cps.Notification_cps_StatoAvanzamento_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsDonorDonating_Accettazione" Name="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsDonorDonating_Accettazione" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_VsDonorDonating_Accettazione">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsDonorDonating_Accettazione_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsDonorDonating_Annullamento" Name="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsDonorDonating_Annullamento" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_VsDonorDonating_Annullamento">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsDonorDonating_Annullamento_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsDonorDonating_CessazioneVsDonating" Name="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsDonorDonating_CessazioneVsDonating" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_VsDonorDonating_CessazioneVsDonating">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsDonorDonating_CessazioneVsDonating_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsDonorDonating_Espletamento" Name="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsDonorDonating_Espletamento" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_VsDonorDonating_Espletamento">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsDonorDonating_Espletamento_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsDonorDonating_RimodulazioneDAC" Name="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsDonorDonating_RimodulazioneDAC" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_VsDonorDonating_RimodulazioneDAC">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsDonorDonating_RimodulazioneDAC_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_Accettazione" Name="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_Accettazione" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_VsRecipient_Accettazione">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_Accettazione_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_Acquisizione" Name="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_Acquisizione" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_VsRecipient_Acquisizione">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_Acquisizione_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_Annullamento" Name="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_Annullamento" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_VsRecipient_Annullamento">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_Annullamento_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_Espletamento" Name="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_Espletamento" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_VsRecipient_Espletamento">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_Espletamento_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_InizioAttivita" Name="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_InizioAttivita" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_VsRecipient_InizioAttivita">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_InizioAttivita_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_RagioneSocialeSU" Name="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_RagioneSocialeSU" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_VsRecipient_RagioneSocialeSU">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_RagioneSocialeSU_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_RimodulazioneDAC" Name="tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_RimodulazioneDAC" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_VsRecipient_RimodulazioneDAC">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.migrazione.Notification_reg_VsRecipient_RimodulazioneDAC_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.trasformazione.Notification_reg_CessSLU-NPperSLU" Name="tim.now.notificationmanager.regolatorio.trasformazione.Notification_reg_CessSLU-NPperSLU" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_CessSLU-NPperSLU">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.trasformazione.Notification_reg_CessSLU-NPperSLU_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.trasformazione.Notification_reg_CessULL-NPperULL" Name="tim.now.notificationmanager.regolatorio.trasformazione.Notification_reg_CessULL-NPperULL" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_CessULL-NPperULL">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.trasformazione.Notification_reg_CessULL-NPperULL_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.trasformazione.Notification_reg_CessULLD-NPperULLD" Name="tim.now.notificationmanager.regolatorio.trasformazione.Notification_reg_CessULLD-NPperULLD" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_CessULLD-NPperULLD">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.trasformazione.Notification_reg_CessULLD-NPperULLD_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.trasformazione.Notification_reg_CessazioneFonia" Name="tim.now.notificationmanager.regolatorio.trasformazione.Notification_reg_CessazioneFonia" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_CessazioneFonia">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.trasformazione.Notification_reg_CessazioneFonia_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.regolatorio.trasformazione.Notification_reg_CessazioneSHAperULL" Name="tim.now.notificationmanager.regolatorio.trasformazione.Notification_reg_CessazioneSHAperULL" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_reg_CessazioneSHAperULL">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.regolatorio.trasformazione.Notification_reg_CessazioneSHAperULL_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.reinvio.ReinvioEmail" Name="tim.now.notificationmanager.reinvio.ReinvioEmail" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="ReinvioEmail" serviceName="ReinvioEmailPortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.reinvio.ReinvioEmail_ReinvioEmail_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.reinvio.ReinvioFile" Name="tim.now.notificationmanager.reinvio.ReinvioFile" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="ReinvioFile" serviceName="ReinvioFilePortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.reinvio.ReinvioFile_ReinvioFile_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.reinvio.ReinvioNotifiche" Name="tim.now.notificationmanager.reinvio.ReinvioNotifiche" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="ReinvioNotifiche" serviceName="ReinvioNotifichePortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.reinvio.ReinvioNotifiche_ReinvioNotifiche_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.reinvio.ReinvioScheduler" Name="tim.now.notificationmanager.reinvio.ReinvioScheduler" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="ReinvioScheduler" serviceName="ReinvioSchedulerPortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.reinvio.ReinvioScheduler_ReinvioScheduler_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.ricarica.Notification_ricarica_OnOff" Name="tim.now.notificationmanager.ricarica.Notification_ricarica_OnOff" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_ricarica_OnOff">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.ricarica.Notification_ricarica_OnOff_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.rigenerazione.email.ParseRigenerazioneEmail" Name="tim.now.notificationmanager.rigenerazione.email.ParseRigenerazioneEmail" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="callProcess" serviceName="tim.now.notificationmanager.rigenerazione.email.ParseRigenerazioneEmail">
      <Inputs Id="8e849b5f-2028-4796-8633-985190fb9b73tim.now.notificationmanager_tim.now.notificationmanager.rigenerazione.email.ParseRigenerazioneEmail_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.rigenerazione.email.RigenerazioneEmail" Name="tim.now.notificationmanager.rigenerazione.email.RigenerazioneEmail" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="RigenerazioneEmail" serviceName="RigenerazioneEmailPortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.rigenerazione.email.RigenerazioneEmail_RigenerazioneEmail_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.tool.scarto.ToolScarto" Name="tim.now.notificationmanager.tool.scarto.ToolScarto" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="ToolScarto" serviceName="ToolScartoPortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.tool.scarto.ToolScarto_ToolScarto_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.tool.scarto.ToolScartoAggiornamentoDB" Name="tim.now.notificationmanager.tool.scarto.ToolScartoAggiornamentoDB" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="callProcess" serviceName="tim.now.notificationmanager.tool.scarto.ToolScartoAggiornamentoDB">
      <Inputs Id="347626d6-cccd-4ad8-9d3b-a16ce486abc0tim.now.notificationmanager_tim.now.notificationmanager.tool.scarto.ToolScartoAggiornamentoDB_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.tool.scarto.ToolScartoCalcoloNotifiche" Name="tim.now.notificationmanager.tool.scarto.ToolScartoCalcoloNotifiche" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="callProcess" serviceName="tim.now.notificationmanager.tool.scarto.ToolScartoCalcoloNotifiche">
      <Inputs Id="785536d3-06fa-4293-a0c4-105306657518tim.now.notificationmanager_tim.now.notificationmanager.tool.scarto.ToolScartoCalcoloNotifiche_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.tool.scarto.ToolScartoRecuperoTracciato" Name="tim.now.notificationmanager.tool.scarto.ToolScartoRecuperoTracciato" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="callProcess" serviceName="tim.now.notificationmanager.tool.scarto.ToolScartoRecuperoTracciato">
      <Inputs Id="f4b9fe1b-582e-4c1a-a138-bb0bda90ba24tim.now.notificationmanager_tim.now.notificationmanager.tool.scarto.ToolScartoRecuperoTracciato_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.tool.scarto.ToolScartoSubProcess" Name="tim.now.notificationmanager.tool.scarto.ToolScartoSubProcess" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="callProcess" serviceName="tim.now.notificationmanager.tool.scarto.ToolScartoSubProcess">
      <Inputs Id="0b732b6f-e6cb-4729-ae92-bc2a9c00a315tim.now.notificationmanager_tim.now.notificationmanager.tool.scarto.ToolScartoSubProcess_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.CalcoloReferente" Name="tim.now.notificationmanager.util.CalcoloReferente" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="CalcoloReferente" serviceName="CalcoloReferentePortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.util.CalcoloReferente_CalcoloReferente_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.NGA_XDSL_Migrazioni" Name="tim.now.notificationmanager.util.NGA_XDSL_Migrazioni" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="NGA_XDSL_Migrazioni" serviceName="NGA_XDSL_MigrazioniPortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.util.NGA_XDSL_Migrazioni_NGA_XDSL_Migrazioni_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.Parse" Name="tim.now.notificationmanager.util.Parse" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="callProcess" serviceName="tim.now.notificationmanager.util.Parse">
      <Inputs Id="dca8c7b3-b697-4283-8f24-7542f513d772tim.now.notificationmanager_tim.now.notificationmanager.util.Parse_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.Parse_NPN" Name="tim.now.notificationmanager.util.Parse_NPN" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="callProcess" serviceName="tim.now.notificationmanager.util.Parse_NPN">
      <Inputs Id="43bca018-6222-456c-81da-1f34104293b7tim.now.notificationmanager_tim.now.notificationmanager.util.Parse_NPN_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.Parse_NPR" Name="tim.now.notificationmanager.util.Parse_NPR" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="callProcess" serviceName="tim.now.notificationmanager.util.Parse_NPR">
      <Inputs Id="1a8b7e9a-b363-4cca-b1eb-fa7c5a7cc309tim.now.notificationmanager_tim.now.notificationmanager.util.Parse_NPR_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.Precondizioni" Name="tim.now.notificationmanager.util.Precondizioni" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="callProcess" serviceName="tim.now.notificationmanager.util.Precondizioni">
      <Inputs Id="66732262-5692-4670-881f-3e5264954f51tim.now.notificationmanager_tim.now.notificationmanager.util.Precondizioni_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.PreventivoOpereSpeciali" Name="tim.now.notificationmanager.util.PreventivoOpereSpeciali" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="PreventivoOpereSpeciali" serviceName="PreventivoOpereSpecialiPortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.util.PreventivoOpereSpeciali_PreventivoOpereSpeciali_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.RemoveNamespace" Name="tim.now.notificationmanager.util.RemoveNamespace" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="RemoveNamespace" serviceName="RemoveNamespacePortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.util.RemoveNamespace_RemoveNamespace_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.RemoveNamespaceNPN" Name="tim.now.notificationmanager.util.RemoveNamespaceNPN" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="RemoveNamespaceNPN" serviceName="RemoveNamespaceNPNPortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.util.RemoveNamespaceNPN_RemoveNamespaceNPN_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.RemoveNamespaceNPR" Name="tim.now.notificationmanager.util.RemoveNamespaceNPR" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="RemoveNamespaceNPR" serviceName="RemoveNamespaceNPRPortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.util.RemoveNamespaceNPR_RemoveNamespaceNPR_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.RemoveNamespaceREG" Name="tim.now.notificationmanager.util.RemoveNamespaceREG" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="RemoveNamespaceREG" serviceName="RemoveNamespaceREGPortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.util.RemoveNamespaceREG_RemoveNamespaceREG_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.SendEmail" Name="tim.now.notificationmanager.util.SendEmail" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="SendEmailOperation" serviceName="SendEmailPortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.util.SendEmail_SendEmailOperation_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.SendEmailNew" Name="tim.now.notificationmanager.util.SendEmailNew" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="callProcess" serviceName="tim.now.notificationmanager.util.SendEmailNew">
      <Inputs Id="8c021835-8a71-419a-aa0c-c961a7d6bea5tim.now.notificationmanager_tim.now.notificationmanager.util.SendEmailNew_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.ServiceName" Name="tim.now.notificationmanager.util.ServiceName" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="ServiceName" serviceName="ServiceNamePortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.util.ServiceName_ServiceName_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.ServiceNameSubProcess" Name="tim.now.notificationmanager.util.ServiceNameSubProcess" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="callProcess" serviceName="tim.now.notificationmanager.util.ServiceNameSubProcess">
      <Inputs Id="4b7a69f8-50d4-4c8a-a572-36a90c3a7247tim.now.notificationmanager_tim.now.notificationmanager.util.ServiceNameSubProcess_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.Token" Name="tim.now.notificationmanager.util.Token" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="callProcess" serviceName="tim.now.notificationmanager.util.Token">
      <Inputs Id="b9b63200-909f-4ba0-93c9-70565b43891ctim.now.notificationmanager_tim.now.notificationmanager.util.Token_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.util.VisualizzazioneNotifiche" Name="tim.now.notificationmanager.util.VisualizzazioneNotifiche" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="VisualizzazioneNotificheOperation" serviceName="VisualizzazioneNotifichePortType">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.util.VisualizzazioneNotifiche_VisualizzazioneNotificheOperation_Request" Name="Request" isDefault="true">
        <informations Name="Input" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/VisualizzazioneNotifiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/VisualizzazioneNotifiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tim.com/NOW/xsd/VisualizzazioneNotifiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:Request">
            <parameters Name="tns0:DatiNotifiche" isList="true">
              <parameters Name="tns0:IDNotifica" Value="48202" type="int" nameSpace="http://www.tim.com/NOW/xsd/VisualizzazioneNotifiche/"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.util.VisualizzazioneNotifiche_VisualizzazioneNotificheOperation_NewRequest" Name="NewRequest">
        <informations Name="Input" tnsName="tns:" nameSpaceValue="http://www.tim.com/NOW/wsdl/abstract/VisualizzazioneNotifiche/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tim.com/NOW/wsdl/abstract/VisualizzazioneNotifiche/"/>
          <nameSpaces prefix="tns0" nameSapce="http://www.tim.com/NOW/xsd/VisualizzazioneNotifiche/"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:Request">
            <parameters Name="tns0:DatiNotifiche" isList="true">
              <parameters Name="tns0:IDNotifica" Value="4444" type="int" nameSpace="http://www.tim.com/NOW/xsd/VisualizzazioneNotifiche/"/>
            </parameters>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.util.VisualizzazioneNotifiche_VisualizzazioneNotificheOperation_NewRequest" Name="NewRequest"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="tim.now.notificationmanager.xdsl.Notification_xdsl" Name="tim.now.notificationmanager.xdsl.Notification_xdsl" ModelType="BW" moduleName="tim.now.notificationmanager">
    <Operation Name="GenericNotification" serviceName="Notification_xdsl">
      <Inputs Id="tim.now.notificationmanager_tim.now.notificationmanager.xdsl.Notification_xdsl_GenericNotification_Request" Name="Request" isDefault="true"/>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
