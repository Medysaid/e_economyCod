package com.project.sobsuza.service;

import com.project.sobsuza.dto.FinalWorkRequestDto;
import com.project.sobsuza.dto.FinalWorkResponseDto;
import com.project.sobsuza.model.Document;
import com.project.sobsuza.model.FinalWork;
import com.project.sobsuza.repository.DocumentRepository;
import com.project.sobsuza.repository.FinalWorkRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Id;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Data
public class FinalWorkService {
    private final FinalWorkRepository finalWorkRepository;
    private final ModelMapper modelMapper;
    private final DocumentRepository documentRepository;
    private final Path root = Paths.get("upload");
    public Boolean add(FinalWorkRequestDto finalWorkRequestDto)throws Exception{
        Random rand = new Random(); //instance of random class
        int upperbound = 100;
        Document document = new Document();
        //generate random values from 0-24
        int int_random = rand.nextInt(upperbound);
        FinalWork finalWork=modelMapper.map(finalWorkRequestDto,FinalWork.class);
        try {
            //file name
            String fileName=finalWorkRequestDto.getDocument().getOriginalFilename();
            //tunachukuwa extension
            String ext=fileName.substring(finalWorkRequestDto.getDocument().getOriginalFilename().lastIndexOf(".")+1);
            //take file to the upload folder
            Files.copy(finalWorkRequestDto.getDocument().getInputStream(),this.root.resolve(String.valueOf(int_random)+"."+ext));
            document.setDocumentType(finalWorkRequestDto.getDocType());
            document.setDocumentName("/upload/"+String.valueOf(int_random)+"."+ext);
            document.setRegNumber(finalWorkRequestDto.getRegNumber());
            document.setUploadedDate(LocalDate.now());
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
        documentRepository.save(document);
        finalWork.setDocumentId(document.getDocumentId());
        finalWork.setSubmittedDate(LocalDate.parse(finalWorkRequestDto.getSubmittedDate()));
        finalWorkRepository.save(finalWork);
        return Boolean.TRUE;
    }

    public List get(){
        List list=new ArrayList<>();
        FinalWorkResponseDto finalWorkResponseDto=null;
        for (FinalWork finalWork:finalWorkRepository.findAll()){
         finalWorkResponseDto=modelMapper.map(finalWork,FinalWorkResponseDto.class);
         list.add(finalWorkResponseDto);
        }
        return list;
    }

    public FinalWorkResponseDto geById(int Id){
        Optional<FinalWork> getById=finalWorkRepository.findById(Id);
        if (!getById.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found");
        }
        FinalWorkResponseDto finalWorkResponseDto=modelMapper.map(getById.get(),FinalWorkResponseDto.class);
        return finalWorkResponseDto;
    }
    public Boolean edit(int Id,FinalWorkRequestDto finalWorkRequestDto){
        FinalWork finalWork=modelMapper.map(finalWorkRequestDto,FinalWork.class);
        finalWork.setFinalWorkId(Id);
        finalWorkRepository.save(finalWork);
        return Boolean.TRUE;
    }

    public Boolean deleteById(int Id){
        Optional<FinalWork> getById=finalWorkRepository.findById(Id);
        if (!getById.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found");
        }
        finalWorkRepository.deleteById(Id);
        return Boolean.TRUE;
    }


}
