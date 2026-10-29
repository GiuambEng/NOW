package com.nttdata.tim.now.core.service.filenotifiche;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.nttdata.tim.now.adapters.esb.filenotifiche.MigrazioneUllSluRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.notifica.StatoFileMigrazioneUllSluBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.notifica.DettaglioFileULLSLUOutputDTO;
import com.nttdata.tim.now.data.dto.notifica.LavorazioneULLSLUOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

public class MigrazioneUllSluManagerBLTest {

    private static final String NOME_FILE = "MIGRAZIONE_ULL_SLU_20260911_01.csv";
    private static final String TIPO_PROFILO = "PROFILO_TEST";
    private static final String ID_FILE = "ID_FILE_TEST";
    private static final String MESI_CONFIGURATI = "6";

    private MigrazioneUllSluManagerBL manager;
    private MigrazioneUllSluRESTClient restClient;

    @Before
    public void setUp() {
        manager = new MigrazioneUllSluManagerBL();
        restClient = mock(MigrazioneUllSluRESTClient.class);
        ReflectionTestUtils.setField(manager, "migrazioneUllSluRestClient", restClient);
    }

    @Test
    public void checkFileInviaNomeFileEProfiloAlServizio() throws Exception {
        ESBResultDTO expected = new ESBResultDTO();
        when(restClient.checkFile(NOME_FILE, TIPO_PROFILO)).thenReturn(expected);

        ESBResultDTO actual = manager.checkFile(NOME_FILE, TIPO_PROFILO);

        assertSame(expected, actual);
        verify(restClient).checkFile(NOME_FILE, TIPO_PROFILO);
    }

    @Test
    public void checkFilePropagaErroreDiIntegrazioneComeErroreBusiness() throws Exception {
        IntegrationLayerException integrationException = new IntegrationLayerException("Servizio non disponibile");
        when(restClient.checkFile(NOME_FILE, TIPO_PROFILO)).thenThrow(integrationException);

        try {
            manager.checkFile(NOME_FILE, TIPO_PROFILO);
            fail("L'errore del servizio deve essere convertito in BusinessLayerException");
        } catch (BusinessLayerException expected) {
            assertEquals("Servizio non disponibile", expected.getMessage());
            assertSame(integrationException, expected.getCause());
        }
    }

    @Test
    public void getDettaglioFileInviaParametriSenzaMesi() throws Exception {
        DettaglioFileULLSLUOutputDTO expected = new DettaglioFileULLSLUOutputDTO();
        when(restClient.getDettaglioFile(NOME_FILE, ID_FILE, TIPO_PROFILO)).thenReturn(expected);

        DettaglioFileULLSLUOutputDTO actual = manager.getDettaglioFile(NOME_FILE, ID_FILE, TIPO_PROFILO);

        assertSame(expected, actual);
        verify(restClient).getDettaglioFile(NOME_FILE, ID_FILE, TIPO_PROFILO);
    }

    @Test
    public void getDettaglioFilePropagaErroreDiIntegrazioneComeErroreBusiness() throws Exception {
        IntegrationLayerException integrationException = new IntegrationLayerException("Servizio dettaglio non disponibile");
        when(restClient.getDettaglioFile(NOME_FILE, ID_FILE, TIPO_PROFILO)).thenThrow(integrationException);

        try {
            manager.getDettaglioFile(NOME_FILE, ID_FILE, TIPO_PROFILO);
            fail("L'errore del servizio deve essere convertito in BusinessLayerException");
        } catch (BusinessLayerException expected) {
            assertEquals("Servizio dettaglio non disponibile", expected.getMessage());
            assertSame(integrationException, expected.getCause());
        }
    }

    @Test
    public void getUploadedFilesUsaMesiConfigurato() throws Exception {
        List<StatoFileMigrazioneUllSluBean> expectedList = Collections.emptyList();
        ReflectionTestUtils.setField(manager, "statoMesi", MESI_CONFIGURATI);
        when(restClient.getUploadedFiles(MESI_CONFIGURATI, TIPO_PROFILO)).thenReturn(expectedList);

        GenericListBean<StatoFileMigrazioneUllSluBean> actual = manager.getUploadedFiles(TIPO_PROFILO);

        assertSame(expectedList, actual.getData());
        verify(restClient).getUploadedFiles(MESI_CONFIGURATI, TIPO_PROFILO);
    }

    @Test
    public void getUploadedFilesPropagaErroreDiIntegrazioneComeErroreBusiness() throws Exception {
        IntegrationLayerException integrationException = new IntegrationLayerException("Servizio upload status non disponibile");
        ReflectionTestUtils.setField(manager, "statoMesi", MESI_CONFIGURATI);
        when(restClient.getUploadedFiles(MESI_CONFIGURATI, TIPO_PROFILO)).thenThrow(integrationException);

        try {
            manager.getUploadedFiles(TIPO_PROFILO);
            fail("L'errore del servizio deve essere convertito in BusinessLayerException");
        } catch (BusinessLayerException expected) {
            assertEquals("Servizio upload status non disponibile", expected.getMessage());
            assertSame(integrationException, expected.getCause());
        }
    }

    @Test
    public void startProcessingInviaNomeFileEProfiloAlServizio() throws Exception {
        LavorazioneULLSLUOutputDTO expected = new LavorazioneULLSLUOutputDTO();
        when(restClient.startProcessing(NOME_FILE, TIPO_PROFILO)).thenReturn(expected);

        LavorazioneULLSLUOutputDTO actual = manager.startProcessing(NOME_FILE, TIPO_PROFILO);

        assertSame(expected, actual);
        verify(restClient).startProcessing(NOME_FILE, TIPO_PROFILO);
    }

    @Test
    public void startProcessingPropagaErroreDiIntegrazioneComeErroreBusiness() throws Exception {
        IntegrationLayerException integrationException = new IntegrationLayerException("Servizio avvio non disponibile");
        when(restClient.startProcessing(NOME_FILE, TIPO_PROFILO)).thenThrow(integrationException);

        try {
            manager.startProcessing(NOME_FILE, TIPO_PROFILO);
            fail("L'errore del servizio deve essere convertito in BusinessLayerException");
        } catch (BusinessLayerException expected) {
            assertEquals("Servizio avvio non disponibile", expected.getMessage());
            assertSame(integrationException, expected.getCause());
        }
    }

}