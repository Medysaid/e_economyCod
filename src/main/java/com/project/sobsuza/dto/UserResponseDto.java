package com.project.sobsuza.dto;

import lombok.Data;


@Data
public class UserResponseDto {
    private int userId;
    private String fullName;
    private String userName;
    private String password;
    private String email;
    private int role;
}
