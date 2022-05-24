package com.project.sobsuza.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Course {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) int courseId;
    private String courseName;
    private String courseCode;
}
