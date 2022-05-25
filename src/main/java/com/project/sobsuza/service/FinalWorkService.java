package com.project.sobsuza.service;

import com.project.sobsuza.dto.FinalWorkRequestDto;
import com.project.sobsuza.dto.FinalWorkResponseDto;
import com.project.sobsuza.model.FinalWork;
import com.project.sobsuza.repository.FinalWorkRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class FinalWorkService {
    private final FinalWorkRepository finalWorkRepository;
    private final ModelMapper modelMapper;

    public Boolean add(FinalWorkRequestDto finalWorkRequestDto){
        FinalWork finalWork=modelMapper.map(finalWorkRequestDto,FinalWork.class);
        finalWorkRepository.save(finalWork);
        return Boolean.TRUE;
    }

    public List get(Id){
        List list=new ArrayList<>();
        FinalWorkResponseDto finalWorkResponseDto=null;
        for (FinalWork finalWork:finalWorkRepository.findAll()){
         finalWorkResponseDto=modelMapper.map(finalWork,FinalWorkResponseDto.class);
         list.add(finalWorkResponseDto);
        }
        return list;
    }


}
