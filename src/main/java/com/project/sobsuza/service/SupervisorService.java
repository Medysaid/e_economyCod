package com.project.sobsuza.service;

import com.project.sobsuza.dto.SupervisorRequestDto;
import com.project.sobsuza.dto.SupervisorResponseDto;
import com.project.sobsuza.model.Supervisor;
import com.project.sobsuza.repository.SupervisorRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    // retriev
    public List get(){
        List list  =new ArrayList<>();
        SupervisorResponseDto supervisorResponseDto = null;
        for (Supervisor supervisor:supervisorRepository.findAll()){
            supervisorResponseDto=modelMapper.map(supervisor,SupervisorResponseDto.class);
            list.add(supervisorResponseDto);
        }
        return list;
    }
    //get by id
    public SupervisorResponseDto getById(int id){
        Optional<Supervisor> getById = supervisorRepository.findById(id);
        if (!getById.isPresent()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"not exist");
        }
        SupervisorResponseDto supervisorResponseDto=modelMapper.map(getById.get(),SupervisorResponseDto.class);
        return supervisorResponseDto;
    }

    // update
    public  Boolean edit(int Id,SupervisorRequestDto supervisorRequestDto){
        Supervisor supervisor=modelMapper.map(supervisorRequestDto,Supervisor.class);
        supervisor.setSupervisorId(Id);
        supervisorRepository.save(supervisor);
        return Boolean.TRUE;
    }
    //delete
    public Boolean getByDelete(int Id){
        Optional<Supervisor> getById=supervisorRepository.findById(Id);
        if (!getById.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not exist");
        }
        supervisorRepository.deleteById(Id);
        return Boolean.TRUE;
    }
}
