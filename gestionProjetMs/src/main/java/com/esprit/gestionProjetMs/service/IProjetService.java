package com.esprit.gestionProjetMs.service;


import com.esprit.gestionProjetMs.model.Projet;

import java.util.List;
import java.util.Optional;

public interface IProjetService {
    List<Projet> getAllProjets();
    Optional<Projet> getProjetById(Long id);
    Projet createProjet(Projet projet);
    Projet updateProjet( Projet updatedProjet);
    void deleteProjet(Long id);

}
