package com.example.gestiontachems.service;


import com.example.gestiontachems.model.Tache;

import java.util.List;

public interface ITacheService {
    Tache createTache(Tache tache);
    List<Tache> getAllTaches();
    Tache getTacheById(Long id);
    Tache updateTache(Tache tache);
    void deleteTache(Long id);
}
