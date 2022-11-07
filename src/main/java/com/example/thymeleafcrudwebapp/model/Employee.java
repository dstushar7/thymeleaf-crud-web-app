package com.example.thymeleafcrudwebapp.model;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "employees") // Table name determined explicitly, otherwise class name will be taken
public class Employee {

    @Id // Primary key indicator
    @GeneratedValue(strategy = GenerationType.IDENTITY) // How values will be generated
    private long id;

    @Column(name = "first_name") // If column name needs to be fixed, we set it, otherwise will take variable name
    private String firstName;

    private String lastName;
    private String email;
}