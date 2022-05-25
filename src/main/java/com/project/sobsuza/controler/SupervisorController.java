package com.project.sobsuza.controler;

import com.project.sobsuza.dto.SupervisorRequestDto;
import com.project.sobsuza.service.SupervisorService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping ("supervisor")
@CrossOrigin
@RestController
@Data

public class SupervisorController {
  @Autowired
  private final SupervisorService supervisorService;
  @PostMapping ("/")
  public ResponseEntity post(@RequestBody SupervisorRequestDto supervisorRequestDto){
    return ResponseEntity.ok().body(supervisorService.add(supervisorRequestDto));
  }
  @GetMapping("/")
  public ResponseEntity get(){
    return ResponseEntity.ok().body(supervisorService.get());
  }
  @GetMapping("/{Id}")
  public ResponseEntity getById(int Id){
    return ResponseEntity.ok().body(supervisorService.getById(Id));
  }
  @PutMapping("/{Id}")
  public ResponseEntity edit(int Id,SupervisorRequestDto supervisorRequestDto){
    return ResponseEntity.ok().body(supervisorService.edit(Id,supervisorRequestDto));
  }
  @DeleteMapping("/{Id}")
  public ResponseEntity delete(int Id){
    return ResponseEntity.ok().body(supervisorService.getByDelete(Id));
  }

}
