package com.project.sobsuza.service;

import com.project.sobsuza.dto.DocumentRequestDto;
import com.project.sobsuza.dto.DocumentResponseDto;
import com.project.sobsuza.model.Document;
import com.project.sobsuza.repository.DocumentRepository;
import com.project.sobsuza.repository.SupervisorRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final ModelMapper modelMapper;

    public Boolean add(DocumentRequestDto documentRequestDto) {
        Document document = modelMapper.map(documentRequestDto, Document.class);
        documentRepository.save(document);
        return Boolean.TRUE;
    }

    public List get() {
        List list = new ArrayList<>();
        DocumentResponseDto documentResponseDto = null;
        for (Document document : documentRepository.findAll()) {
            documentResponseDto = modelMapper.map(document, DocumentResponseDto.class);
            list.add(documentResponseDto);
        }
        return list;
    }

    public DocumentResponseDto getById(int Id) {
        Optional<Document> getById = documentRepository.findById(Id);
        if (!getById.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not exist");
        }
        DocumentResponseDto documentResponseDto = modelMapper.map(getById.get(), DocumentResponseDto.class);
        return documentResponseDto;
    }

    public Boolean edit(int Id,DocumentRequestDto documentRequestDto){
        Document document=modelMapper.map(documentRequestDto,Document.class);
        document.setDocumentId(Id);
        documentRepository.save(document);
        return Boolean.TRUE;
    }

    public Boolean getByDelete(int Id){
        Optional<Document> getById=documentRepository.findById(Id);
        if (!getById.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not exist");
        }
        documentRepository.deleteById(Id);
        return Boolean.TRUE;
    }
}