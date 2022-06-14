package com.project.sobsuza.model;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
@Data
public class Document {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) int documentId;
    private String documentType;
    private String documentName;
    private String regNumber;
    private LocalDate uploadedDate;

}
