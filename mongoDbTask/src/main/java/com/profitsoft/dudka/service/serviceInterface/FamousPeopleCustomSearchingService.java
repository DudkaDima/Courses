package com.profitsoft.dudka.service.serviceInterface;

import com.profitsoft.dudka.dto.FamousPeopleSearchByNameDto;
import com.profitsoft.dudka.dto.PopularPeopleDto;
import com.profitsoft.dudka.model.FamousPeople;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FamousPeopleCustomSearchingService {

    List<FamousPeople> searchPeopleByFullName(FamousPeopleSearchByNameDto searchDto);

    void setUpDataBaseFromUploadedFile(MultipartFile multipartFile);
    List<PopularPeopleDto> findPeopleByIsPepTrue();
}
