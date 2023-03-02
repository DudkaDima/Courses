package com.profitsoft.dudka.service.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.profitsoft.dudka.exception.FileSavingException;
import com.profitsoft.dudka.model.FamousPeople;
import com.profitsoft.dudka.service.serviceInterface.ParsingDataFileProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Service
public class ParsingDataFileProcessServiceImpl implements ParsingDataFileProcessService {


    private Path fileStorageLocation = Path.of("mongoDbTask/src/main/resources/temp");

    @Autowired
    public ParsingDataFileProcessServiceImpl() {
        fileStorageLocation.toAbsolutePath().normalize();
        try{
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException e) {
            throw new FileSavingException("Can`t create directory ", e);
        }
    }

    @Override
    public List<FamousPeople> parseJsonContent(MultipartFile file) {
        String jsonPath = storeZipFileContent(file);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<FamousPeople> famousPersonData = Arrays.asList(objectMapper.readValue
                    (new File(jsonPath), FamousPeople[].class));

            return famousPersonData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String storeZipFileContent(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
                throw new FileNotFoundException("Sorry! " +
                        "Filename contains invalid path sequence " + fileName);
            }
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation,
                    StandardCopyOption.REPLACE_EXISTING);
            return unZipFileToJson(String.valueOf(targetLocation));
        } catch (IOException ex) {
            throw new FileSavingException("Could not store file "
                    + fileName + ". Please try again!", ex);
        }
    }

    @Override
    public String unZipFileToJson(String fileToUnzip) {
        String jsonFilePath = fileToUnzip.substring(0, fileToUnzip.indexOf("."))
                .concat(".json");
        InputStream stream;
        try(ZipFile zipFile = new ZipFile(fileToUnzip)){
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while(entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                stream = zipFile.getInputStream(entry);
                Files.copy(stream, Path.of(jsonFilePath),
                        StandardCopyOption.REPLACE_EXISTING);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonFilePath;
    }

    @Override
    public void deleteFile(String filePath) throws IOException {
        File fileToDelete = new File(filePath);
        if(fileToDelete.delete()){
            Logger.getLogger(ParsingDataFileProcessServiceImpl.class.getName()).info("File " + fileToDelete + " deleted");
        } else {
            throw new IOException("Cannot delete file " + fileToDelete);
        }
    }
}
