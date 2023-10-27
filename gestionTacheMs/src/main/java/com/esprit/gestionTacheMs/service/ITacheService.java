package com.esprit.gestionTacheMs.service;


import com.esprit.gestionTacheMs.model.Tache;

import java.util.List;

public interface ITacheService {
    Tache createTache(Tache tache);
    List<Tache> getAllTaches();
    Tache getTacheById(Long id);
    Tache updateTache(Tache tache);
    void deleteTache(Long id);
}
