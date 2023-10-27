package com.esprit.equipe.repository;


import com.esprit.equipe.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
   List<Demande> findDemandesByUserId(Long userId);
}
