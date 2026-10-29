package com.nttdata.tim.now.core.service.filenotifiche;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.filenotifiche.MigrazioneUllSluRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;
import com.nttdata.tim.now.data.bean.notifica.StatoFileMigrazioneUllSluBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.file.InputUploadULLSLUDTO;
import com.nttdata.tim.now.data.dto.notifica.DettaglioFileULLSLUOutputDTO;
import com.nttdata.tim.now.data.dto.notifica.LavorazioneULLSLUOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MigrazioneUllSluManagerBL {

    @Value("${migrazione.ullslu.max.records}")
    private int maxRecords;

    @Value("${migrazione.ullslu.stato.mesi:6}")
    private String statoMesi;

    @Autowired
    private MigrazioneUllSluRESTClient migrazioneUllSluRestClient;

    // Regex per il formato: MIGRAZIONE_ULL_SLU_[<CLLI>_]<aaaammgg>_<XX>.csv (CLLI opzionale)
    private static final Pattern FILE_NAME_PATTERN = Pattern.compile(
            "^MIGRAZIONE_ULL_SLU_(?:[A-Za-z0-9]+_)?\\d{8}_\\d{2}\\.csv$",
            Pattern.CASE_INSENSITIVE
    );

    public ESBResultDTO uploadFile(FileScaricatoBean uploadedFile, String idOperatore, String tipoProfilo) throws BusinessLayerException {
        validateCsvFile(uploadedFile);
        try {
            int records = countRecords(uploadedFile.getFileData());
            if (records > maxRecords) {
                throw new BusinessLayerException("Il file contiene " + records + " record, oltre il limite configurato di " + maxRecords);
            }
            // if (migrazioneUllSluRestClient.isFileAlreadyUploaded(uploadedFile.getName(), tipoProfilo)) {
            //     throw new BusinessLayerException("E' gia stato caricato un file con nome " + uploadedFile.getName());
            // }
            
            // Costruire l'input per il servizio TIBCO
            InputUploadULLSLUDTO input = new InputUploadULLSLUDTO();
            input.setNomeFile(uploadedFile.getName());
            input.setContenutoFile(uploadedFile.getFileData());
            input.setIdOperatore(idOperatore);
            
            // Chiamare il servizio TIBCO e ritornare il risultato
            return migrazioneUllSluRestClient.uploadFile(input, tipoProfilo);
        } catch (IntegrationLayerException e) {
            throw new BusinessLayerException(e.getMessage(), e);
        } catch (IOException e) {
            throw new BusinessLayerException("Impossibile leggere il file " + uploadedFile.getName(), e);
        }
    }

    public GenericListBean<StatoFileMigrazioneUllSluBean> getUploadedFiles(String tipoProfilo) throws BusinessLayerException {
        GenericListBean<StatoFileMigrazioneUllSluBean> result = new GenericListBean<StatoFileMigrazioneUllSluBean>();
        try {
            result.setData(migrazioneUllSluRestClient.getUploadedFiles(statoMesi, tipoProfilo));
        } catch (IntegrationLayerException e) {
            throw new BusinessLayerException(e.getMessage(), e);
        }
        return result;
    }

    public DettaglioFileULLSLUOutputDTO getDettaglioFile(String nomeFile, String idFile, String tipoProfilo) throws BusinessLayerException {
        try {
            return migrazioneUllSluRestClient.getDettaglioFile(nomeFile, idFile, tipoProfilo);
        } catch (IntegrationLayerException e) {
            throw new BusinessLayerException(e.getMessage(), e);
        }
    }

    public ESBResultDTO checkFile(String nomeFile, String tipoProfilo) throws BusinessLayerException {
        try {
            return migrazioneUllSluRestClient.checkFile(nomeFile, tipoProfilo);
        } catch (IntegrationLayerException e) {
            throw new BusinessLayerException(e.getMessage(), e);
        }
    }

    public void deleteFile(String nomeFile, String tipoProfilo) throws BusinessLayerException {
        try {
            migrazioneUllSluRestClient.deleteFile(nomeFile, tipoProfilo);
        } catch (IntegrationLayerException e) {
            throw new BusinessLayerException(e.getMessage(), e);
        }
    }

    public LavorazioneULLSLUOutputDTO startProcessing(String nomeFile, String tipoProfilo) throws BusinessLayerException {
        try {
            return migrazioneUllSluRestClient.startProcessing(nomeFile, tipoProfilo);
        } catch (IntegrationLayerException e) {
            throw new BusinessLayerException(e.getMessage(), e);
        }
    }

    private void validateCsvFile(FileScaricatoBean uploadedFile) throws BusinessLayerException {
        String fileName = uploadedFile.getName();
        
        // Validare l'estensione .csv
        if (fileName == null || !fileName.toLowerCase().endsWith(".csv")) {
            throw new BusinessLayerException("Il file selezionato deve essere in formato CSV");
        }
        
        // Validare il formato del nome file
        if (!FILE_NAME_PATTERN.matcher(fileName).matches()) {
            throw new BusinessLayerException(
                    "Il nome del file non rispetta il formato previsto. " +
                    "Formato atteso: MIGRAZIONE_ULL_SLU_[<CLLI>_]<aaaammgg>_<XX>.csv "
            );
        }
    }

    private int countRecords(byte[] fileData) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new ByteArrayInputStream(fileData), StandardCharsets.UTF_8))) {
            int lines = 0;
            while (reader.readLine() != null) {
                lines++;
            }
            return lines == 0 ? 0 : lines - 1;
        }
    }
}