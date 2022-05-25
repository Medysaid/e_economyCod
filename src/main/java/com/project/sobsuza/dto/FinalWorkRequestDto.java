package com.project.sobsuza.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class FinalWorkRequestDto {
    private String regNumber;
    private int documentId;
    private int supervisorId;
    private String docType;
    private LocalDate submittedDate;
}
