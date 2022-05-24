package com.project.sobsuza.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table
@Data
public class Supervisor {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) int supervisorId;
    private int phoneNumber;
    private String name;
    private String email;
}
