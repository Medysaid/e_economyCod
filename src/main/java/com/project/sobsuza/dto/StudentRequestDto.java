package com.project.sobsuza.dto;

import lombok.Data;




@Data
public class StudentRequestDto {
    private String regNumber;
    private String fullName;
    private String level;
    private String email;
    private int courseId;
}
