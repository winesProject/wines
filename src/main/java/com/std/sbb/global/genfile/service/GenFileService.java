package com.std.sbb.global.genfile.service;

import com.std.sbb.global.genfile.entity.GenFile;
import com.std.sbb.global.genfile.repository.GenFileRepository;
import com.std.sbb.global.standard.utill.Ut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GenFileService {
    private final GenFileRepository genFileRepository;

    @Transactional
    public GenFile save(String relTypeCode, Long relId, String typeCode, String type2Code, int fileNo, MultipartFile multipartFile) {
        if (relId == null) {
            // relId가 null인 경우 처리
            throw new IllegalArgumentException("relId cannot be null");
        }

        if (multipartFile == null || multipartFile.isEmpty()) {
            // 이미지 파일이 null이거나 비어있는 경우 처리
            throw new IllegalArgumentException("MultipartFile cannot be null or empty");
        }

        String originFileName = multipartFile.getOriginalFilename();
        String fileExt = Ut.file.getExt(originFileName);
        String fileExtTypeCode = Ut.file.getFileExtTypeCodeFromFileExt(fileExt);
        String fileExtType2Code = Ut.file.getFileExtType2CodeFromFileExt(fileExt);
        int fileSize = (int) multipartFile.getSize();
        String fileDir = getCurrentDirName(relTypeCode);

        GenFile genFile = GenFile.builder()
                .relTypeCode(relTypeCode)
                .relId(relId)
                .typeCode(typeCode)
                .type2Code(type2Code)
                .fileExtTypeCode(fileExtTypeCode)
                .fileExtType2Code(fileExtType2Code)
                .originFileName(originFileName)
                .fileSize(fileSize)
                .fileNo(fileNo)
                .fileExt(fileExt)
                .fileDir(fileDir)
                .build();

        genFileRepository.save(genFile);

        return genFile;
    }

    private String getCurrentDirName(String relTypeCode) {
        return relTypeCode + "/" + Ut.date.getCurrentDateFormatted("yyyy_MM_dd");
    }
}
