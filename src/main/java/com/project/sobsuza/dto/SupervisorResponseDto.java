package com.project.sobsuza.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
public class SupervisorResponseDto {
    private int supervisorId;
    private int phoneNumber;
    private String name;
    private String email;
}
