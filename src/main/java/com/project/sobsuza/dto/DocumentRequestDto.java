package com.project.sobsuza.dto;


import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Data
public class DocumentRequestDto {
    private String documentType;
    private String documentName;
    private LocalDate uploadedDate;

}
