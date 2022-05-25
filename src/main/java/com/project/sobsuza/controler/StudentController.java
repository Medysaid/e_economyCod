package com.project.sobsuza.controler;

import com.project.sobsuza.dto.StudentRequestDto;
import com.project.sobsuza.service.StudentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("student")
@Data
@RestController
public class StudentController {
    @Autowired
    private final StudentService studentService;

    @PostMapping("/")
    public ResponseEntity post(@RequestBody StudentRequestDto studentRequestDto){
        return ResponseEntity.ok().body(studentService.add(studentRequestDto));
    }
    @GetMapping("/")
    public ResponseEntity get(){
        return ResponseEntity.ok().body(studentService.get());
    }
    @GetMapping("/{Id}")
    public ResponseEntity getById(String Id){
        return ResponseEntity.ok().body(studentService.getById(Id));
    }
    @PutMapping("/{Id}")
    public ResponseEntity edit(String Id,StudentRequestDto studentRequestDto){
        return ResponseEntity.ok().body(studentService.edit(Id,studentRequestDto));
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity delete(String Id){
        return ResponseEntity.ok().body(studentService.getByDelete(Id));
    }

}
