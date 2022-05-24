package com.project.sobsuza.service;

import com.project.sobsuza.dto.SupervisorRequestDto;
import com.project.sobsuza.model.Supervisor;
import com.project.sobsuza.repository.SupervisorRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Data
public class SupervisorService {
    private final SupervisorRepository supervisorRepository;

    private final ModelMapper modelMapper;


    // insert data (create)
    public Boolean add(SupervisorRequestDto supervisorRequestDto){
        Supervisor supervisor = modelMapper.map(supervisorRequestDto,Supervisor.class);
        supervisorRepository.save(supervisor);
        return Boolean.TRUE;

    }
}
