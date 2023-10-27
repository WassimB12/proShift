package com.example.gestiontachems.repository;

import com.example.gestiontachems.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacheRepository extends JpaRepository<Tache, Long> {
}
