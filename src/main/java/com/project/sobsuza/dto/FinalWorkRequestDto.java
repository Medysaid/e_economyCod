package com.project.sobsuza.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class FinalWorkRequestDto {
    private String regNumber;
    private MultipartFile document;
    private String topic;
    private String description;
    private int supervisorId;
    private String docType;
    private String submittedDate;
}
