package com.project.sobsuza.controler;

import com.project.sobsuza.dto.FinalWorkRequestDto;
import com.project.sobsuza.service.FinalWorkService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;

@CrossOrigin
@RestController
@RequestMapping("finalWork")
@Data
public class FinalWorkController {
    @Autowired
    private final FinalWorkService finalWorkService;

    @PostMapping("/")
    public ResponseEntity post(@RequestBody FinalWorkRequestDto finalWorkRequestDto) throws Exception{
        return ResponseEntity.ok().body(finalWorkService.add(finalWorkRequestDto));
    }

    @GetMapping("/")
    public ResponseEntity get(){
        return ResponseEntity.ok().body(finalWorkService.get());
    }

    @GetMapping("/{Id}")
    public ResponseEntity getById(@PathVariable("id") int Id){
        return ResponseEntity.ok().body(finalWorkService.geById(Id));
    }

    @PutMapping("/{Id}")
    public ResponseEntity edit(@PathVariable("id") int Id,FinalWorkRequestDto finalWorkRequestDto){
        return ResponseEntity.ok().body(finalWorkService.edit(Id,finalWorkRequestDto));
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity delete(@PathVariable("id") int Id){
        return ResponseEntity.ok().body(finalWorkService.deleteById(Id));
    }

}
