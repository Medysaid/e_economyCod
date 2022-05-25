package com.project.sobsuza.model;

import lombok.Data;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Student {
    private @Id String regNumber;
    private String fullName;
    private String level;
    private String email;
    private int courseId;
}
