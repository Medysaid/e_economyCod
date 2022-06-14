package com.project.sobsuza.controler;

import com.project.sobsuza.dto.DocumentRequestDto;
import com.project.sobsuza.service.DocumentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("document")
@CrossOrigin
@RestController
@Data
public class DocumentController {
    @Autowired
    private final DocumentService documentService;

    @PostMapping("/")
    public ResponseEntity post(@RequestBody DocumentRequestDto documentRequestDto){
        return ResponseEntity.ok().body(documentService.add(documentRequestDto));
    }
    @GetMapping("/")
    public ResponseEntity get(){
        return ResponseEntity.ok().body(documentService.get());
    }

    @GetMapping("/{Id}")
    public ResponseEntity getById(@PathVariable("id") int Id){
        return ResponseEntity.ok().body(documentService.getById(Id));
    }
    @PutMapping("/{Id}")
    public ResponseEntity edit(@PathVariable("id") int Id,DocumentRequestDto documentRequestDto){
        return ResponseEntity.ok().body(documentService.edit(Id,documentRequestDto));
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity delete(@PathVariable("id") int Id){

        return ResponseEntity.ok().body(documentService.getByDelete(Id));
    }
}
