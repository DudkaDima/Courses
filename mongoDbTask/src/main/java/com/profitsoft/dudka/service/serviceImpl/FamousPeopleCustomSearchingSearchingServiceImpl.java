package com.profitsoft.dudka.service.serviceImpl;

import com.profitsoft.dudka.dto.FamousPeopleInfoByIsPepTrueDto;
import com.profitsoft.dudka.dto.FamousPeopleSearchByNameDto;
import com.profitsoft.dudka.dto.PopularPeopleDto;
import com.profitsoft.dudka.model.FamousPeople;
import com.profitsoft.dudka.repository.FamousPeopleCustomSearchingRepository;
import com.profitsoft.dudka.service.serviceInterface.FamousPeopleCustomSearchingService;
import com.profitsoft.dudka.service.serviceInterface.ParsingDataFileProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
@Transactional
public class FamousPeopleCustomSearchingSearchingServiceImpl implements FamousPeopleCustomSearchingService {

    private final FamousPeopleCustomSearchingRepository famousPeopleCustomSearchingRepository;
    private final ParsingDataFileProcessService parsingDataFileProcessService;

    @Autowired
    public FamousPeopleCustomSearchingSearchingServiceImpl(FamousPeopleCustomSearchingRepository famousPeopleCustomSearchingRepository, ParsingDataFileProcessService parsingDataFileProcessService) {
        this.famousPeopleCustomSearchingRepository = famousPeopleCustomSearchingRepository;
        this.parsingDataFileProcessService = parsingDataFileProcessService;
    }
    @Override
    public void setUpDataBaseFromUploadedFile(MultipartFile multipartFile){
        famousPeopleCustomSearchingRepository.saveAll(parsingDataFileProcessService.parseJsonContent(multipartFile));
    }
    @Override
    public List<FamousPeople> searchPeopleByFullName(FamousPeopleSearchByNameDto searchDto) {
        return famousPeopleCustomSearchingRepository.search(searchDto);
    }

    @Override
    public List<PopularPeopleDto> findPeopleByIsPepTrue() {
       return famousPeopleCustomSearchingRepository.findPeopleByIsPepTrue();
    }

    private FamousPeopleInfoByIsPepTrueDto toInfoDto(FamousPeople famousPeopleData){
        return FamousPeopleInfoByIsPepTrueDto.builder()
                .fullName(famousPeopleData.getFullName())
                .isPep(famousPeopleData.isPep())
                .died(famousPeopleData.isDied())
                .build();
    }
}
