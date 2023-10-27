package com.example.gestionprojetms.repository;

import com.example.gestionprojetms.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProjetRepository extends JpaRepository<Projet, Long> {
        List<Projet> findProjetsByEquipeIsNull();
        List<Projet> findProjetsByEquipe_Id(Long id);
        List<Projet> findProjetsByEquipe_IdOrEquipeIsNull(Long id);
        List<Projet> findProjetsByChef_id(Long id);
}
