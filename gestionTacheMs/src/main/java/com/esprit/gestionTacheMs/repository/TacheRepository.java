package com.esprit.gestionTacheMs.repository;


import com.esprit.gestionTacheMs.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Tache, Long> {
}
