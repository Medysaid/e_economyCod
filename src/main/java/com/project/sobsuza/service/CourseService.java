package com.project.sobsuza.service;

import com.project.sobsuza.dto.CourseRequestDto;
import com.project.sobsuza.dto.CourseResponseDto;
import com.project.sobsuza.model.Course;
import com.project.sobsuza.repository.CourseRepository;
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
public class CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    //insert Data
    public Boolean add(CourseRequestDto courseRequestDto){
        Course course = modelMapper.map(courseRequestDto,Course.class);
        courseRepository.save(course);
        return Boolean.TRUE;

//        Course course = new Course();
//        course.setCourseCode(courseRequestDto.getCourseCode());
//        course.setCourseCode(course.getCourseCode());
    }

    //get Data retrive
    public List get(){
        List list = new ArrayList<>();
        CourseResponseDto courseResponseDto=null;
        for(Course course:courseRepository.findAll()){
            courseResponseDto=modelMapper.map(course,CourseResponseDto.class);
            list.add(courseResponseDto);
        }
        return list;
    }

    // get by id
    public CourseResponseDto getById(int id){
        Optional<Course> getByid = courseRepository.findById(id);
        if(!getByid.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not Exist");
        }
        CourseResponseDto courseResponseDto=modelMapper.map(getByid.get(),CourseResponseDto.class);
        return courseResponseDto;
    }
    //edit
    public Boolean edit(int id,CourseRequestDto courseRequestDto){
        Course course = modelMapper.map(courseRequestDto,Course.class);
        course.setCourseId(id);
        courseRepository.save(course);
        return Boolean.TRUE;

//        Course course = new Course();
//        course.setCourseCode(courseRequestDto.getCourseCode());
//        course.setCourseCode(course.getCourseCode());

    }
    // get by id
    public Boolean getByDelete(int id){
        Optional<Course> getByid = courseRepository.findById(id);
        if(!getByid.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not Exist");
        }
        courseRepository.deleteById(id);
        return Boolean.TRUE;
    }

}
