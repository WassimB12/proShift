package com.esprit.gestionProjetMs.repository;


import com.esprit.gestionProjetMs.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet, Long> {

}
