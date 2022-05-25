package com.project.sobsuza.dto;

import lombok.Data;

import javax.persistence.Id;
@Data
public class StudentResponseDto {
    private String regNumber;
    private String fullName;
    private String level;
    private String email;
    private int courseId;
}
