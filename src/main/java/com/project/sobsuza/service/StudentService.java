package com.project.sobsuza.service;

import com.project.sobsuza.dto.StudentRequestDto;
import com.project.sobsuza.dto.StudentResponseDto;
import com.project.sobsuza.model.Student;
import com.project.sobsuza.repository.StudentRepository;
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
public class StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


    public Boolean add(StudentRequestDto studentRequestDto){
        Student student=modelMapper.map(studentRequestDto,Student.class);
        studentRepository.save(student);
        return Boolean.TRUE;
    }

    public List get(){
        List list=new ArrayList<>();
        StudentResponseDto studentResponseDto=null;
        for (Student student:studentRepository.findAll()){
            studentResponseDto=modelMapper.map(student,StudentResponseDto.class);
            list.add(studentResponseDto);
        }
        return list;
    }

    public StudentResponseDto getById(String Id){
        Optional<Student> getById=studentRepository.findById(Id);
        if (!getById.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not exist");
        }
        StudentResponseDto studentResponseDto=modelMapper.map(getById.get(),StudentResponseDto.class);
        return studentResponseDto;
    }
    public Boolean edit(String Id,StudentRequestDto studentRequestDto){
        Student student=modelMapper.map(studentRequestDto,Student.class);
        student.setRegNumber(Id);;
        studentRepository.save(student);
        return Boolean.TRUE;
    }

    public Boolean getByDelete(String Id){
        Optional<Student> getById=studentRepository.findById(Id);
        if (!getById.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not exist");
        }
       studentRepository.deleteById(Id);
        return Boolean.TRUE;
    }
}
