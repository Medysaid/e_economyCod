package com.project.sobsuza.controler;

import com.project.sobsuza.dto.CourseRequestDto;
import com.project.sobsuza.service.CourseService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("course")
@RestController
@Data
public class CourseController {
    @Autowired
    private final CourseService courseService;

    @PostMapping("/")
    public ResponseEntity post(CourseRequestDto courseRequestDto){
        return ResponseEntity.ok().body(courseService.add(courseRequestDto));
    }
    @GetMapping("/")
    public ResponseEntity get(){
        return ResponseEntity.ok().body(courseService.get());
    }
    @GetMapping("/{id}")
    public ResponseEntity getById(int id){
        return ResponseEntity.ok().body(courseService.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity edt(int id,CourseRequestDto courseRequestDto){
        return ResponseEntity.ok().body(courseService.edit(id,courseRequestDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(int id){
        return ResponseEntity.ok().body(courseService.getByDelete(id));
    }


}
