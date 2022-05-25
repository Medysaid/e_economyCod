package com.project.sobsuza.model;

import lombok.Data;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
@Data
public class FinalWork {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) int finalWorkId;
    private String regNumber;
    private int documentId;
    private int supervisorId;
    private String docType;
    private LocalDate submittedDate;
}
