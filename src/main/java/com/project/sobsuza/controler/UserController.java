package com.project.sobsuza.controler;

import com.project.sobsuza.dto.SupervisorRequestDto;
import com.project.sobsuza.dto.UserRequestDto;
import com.project.sobsuza.dto.UserResponseDto;
import com.project.sobsuza.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@CrossOrigin
@RestController
@Data
public class UserController {
    @Autowired
    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity post(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok().body(userService.add(userRequestDto));
    }

    @GetMapping("/")
    public ResponseEntity get(){
        return ResponseEntity.ok().body(userService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") int Id){

        return ResponseEntity.ok().body(userService.getById(Id));
    }

    @PutMapping("{id}")
    public ResponseEntity edit(@PathVariable("id") int Id, UserRequestDto userRequestDto){
        return ResponseEntity.ok().body(userService.edit(Id,userRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int Id){
        return ResponseEntity.ok().body(userService.deleteById(Id));
    }
}
