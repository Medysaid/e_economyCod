package com.project.sobsuza.service;

import com.project.sobsuza.dto.UserRequestDto;
import com.project.sobsuza.dto.UserResponseDto;
import com.project.sobsuza.model.Users;
import com.project.sobsuza.repository.UserRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public Boolean add(UserRequestDto userRequestDto){
        Users user=modelMapper.map(userRequestDto, Users.class);
        userRepository.save(user);
        return Boolean.TRUE;
    }
    public List get(){
        List list=new ArrayList<>();
       UserResponseDto userResponseDto=null;
        for (Users user:userRepository.findAll()){
            userResponseDto=modelMapper.map(user,UserResponseDto.class);
            list.add(userResponseDto);
        }
        return list;
    }
    public UserResponseDto getById(int Id){
        Optional<Users> getById=userRepository.findById(Id);
        if (!getById.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found");
        }
        UserResponseDto userResponseDto=modelMapper.map(getById.get(),UserResponseDto.class);
        return new UserResponseDto();
    }

    public Boolean edit(int Id, UserRequestDto userResponseDto){
       Users user=modelMapper.map(userResponseDto, Users.class);
        user.setUserId(Id);
        userRepository.save(user);
        return Boolean.TRUE;
    }

    public Boolean deleteById(int Id){
        Optional<Users> getById=userRepository.findById(Id);
        if (!getById.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found");
        }
        userRepository.deleteById(Id);
        return Boolean.TRUE;
    }

}