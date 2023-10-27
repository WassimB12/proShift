package com.esprit.demandeemploi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffreEmploiRepository extends JpaRepository<OffreEmploiModel,Integer> {
List<OffreEmploiModel> findAll();
}
