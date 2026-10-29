package com.nttdata.tim.now.web.controller.filenotifiche;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.filenotifiche.MigrazioneUllSluManagerBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;
import com.nttdata.tim.now.data.bean.notifica.StatoFileMigrazioneUllSluBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.base.ResultDTO;
import com.nttdata.tim.now.data.dto.notifica.DettaglioFileULLSLUOutputDTO;
import com.nttdata.tim.now.data.dto.notifica.LavorazioneULLSLUInputDTO;
import com.nttdata.tim.now.data.dto.notifica.LavorazioneULLSLUOutputDTO;
import com.nttdata.tim.now.data.enumeration.ResultCodeEnum;
import com.nttdata.tim.now.web.bind.annotation.JsonDeleteMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MigrazioneUllSluController extends GenericController {

    @Autowired
    private MigrazioneUllSluManagerBL migrazioneUllSluManagerBL;

    @JsonGetMapping("/migrazione-ull-slu/files")
    public GenericListBean<StatoFileMigrazioneUllSluBean> getUploadedFiles(HttpSession session) throws BusinessLayerException {
        UserBean currentUser = getCurrentUser(session);
        return ensureListBeanResult(migrazioneUllSluManagerBL.getUploadedFiles(currentUser.getCodiceProfilo()));
    }

    @JsonGetMapping("/dettagliofileullslu")
    public DettaglioFileULLSLUOutputDTO getDettaglioFile(
            @RequestParam(value = "nomeFile", required = false) String nomeFile,
            @RequestParam(value = "idFile", required = false) String idFile,
            HttpSession session) throws BusinessLayerException {
        UserBean currentUser = getCurrentUser(session);
        return migrazioneUllSluManagerBL.getDettaglioFile(nomeFile, idFile, currentUser.getCodiceProfilo());
    }

    @JsonPostMapping("/migrazione-ull-slu/files/{nomeFile}/check")
    public ESBResultDTO checkFile(@PathVariable String nomeFile, HttpSession session) throws BusinessLayerException {
        UserBean currentUser = getCurrentUser(session);
        return migrazioneUllSluManagerBL.checkFile(nomeFile, currentUser.getCodiceProfilo());
    }

    @JsonDeleteMapping("/migrazione-ull-slu/files/{nomeFile}")
    public EmptyBean deleteFile(@PathVariable String nomeFile, HttpSession session) throws BusinessLayerException {
        UserBean currentUser = getCurrentUser(session);
        migrazioneUllSluManagerBL.deleteFile(nomeFile, currentUser.getCodiceProfilo());
        return getSuccessEmptyBean();
    }

    @JsonPostMapping("/avvialavorazioneullslu")
    public LavorazioneULLSLUOutputDTO startProcessing(@RequestBody LavorazioneULLSLUInputDTO input, HttpSession session) throws BusinessLayerException {
        UserBean currentUser = getCurrentUser(session);
        return migrazioneUllSluManagerBL.startProcessing(input.getNomeFile(), currentUser.getCodiceProfilo());
    }

    @JsonPostMapping("/migrazione-ull-slu/upload")
    public ESBResultDTO uploadFile(@RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
        if (file.isEmpty()) {
            ESBResultDTO result = new ESBResultDTO();
            ResultDTO resultDto = new ResultDTO();
            resultDto.setCode(ResultCodeEnum.VALIDATION_ERROR.getCode());
            resultDto.setDetails("Selezionare un file non vuoto");
            resultDto.setSeverity("ERROR");
            result.setResult(resultDto);
            return result;
        }
        try {
            // Ottenere l'utente dalla sessione
            UserBean currentUser = getCurrentUser(session);
            String idOperatore = currentUser != null ? currentUser.getUserId() : "";
            FileScaricatoBean uploadedFile = new FileScaricatoBean();
            uploadedFile.setName(file.getOriginalFilename());
            uploadedFile.setSize(file.getSize());
            uploadedFile.setMime(file.getContentType());
            uploadedFile.setFileData(file.getBytes());
            return migrazioneUllSluManagerBL.uploadFile(uploadedFile, idOperatore, currentUser.getCodiceProfilo());
        } catch (BusinessLayerException e) {
            ESBResultDTO result = new ESBResultDTO();
            ResultDTO resultDto = new ResultDTO();
            resultDto.setCode(ResultCodeEnum.VALIDATION_ERROR.getCode());
            resultDto.setDetails(e.getMessage());
            resultDto.setSeverity("ERROR");
            result.setResult(resultDto);
            return result;
        }
    }
}