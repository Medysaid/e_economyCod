package com.project.sobsuza.model;

import lombok.Data;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Users {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) int userId;
    private String fullName;
    private String userName;
    private String password;
    private String email;
    private int role;
}
