package com.profitsoft.dudka.service.serviceInterface;

import com.profitsoft.dudka.model.FamousPeople;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ParsingDataFileProcessService {

    List<FamousPeople> parseJsonContent(MultipartFile file);

    String storeZipFileContent(MultipartFile file);

    String unZipFileToJson(String fileToUnzip);

    void deleteFile(String filePath) throws IOException;
}
