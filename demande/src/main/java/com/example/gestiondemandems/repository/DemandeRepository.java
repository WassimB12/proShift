package com.example.gestiondemandems.repository;

import com.example.gestiondemandems.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
   List<Demande> findDemandesByUserId(Long userId);
}
