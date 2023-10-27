package com.example.gestionuserms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MembreEntreprise {
    @Id
    private String cin;
    private String name;
    private String lastName;
    private String role;
}
