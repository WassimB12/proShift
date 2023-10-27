package com.esprit.equipe.service;


import com.esprit.equipe.model.Equipe;

import java.util.List;
import java.util.Optional;

public interface IEquipeService {
    List<Equipe> getAllEquipes();

    Optional<Equipe> getEquipeById(Long id);

    Equipe createEquipe(Equipe equipe);

    Equipe updateEquipe(Equipe updatedEquipe);

    void deleteEquipe(Long id);
}
