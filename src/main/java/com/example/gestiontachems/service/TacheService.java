package com.example.gestiontachems.service;


import com.example.gestiontachems.model.Tache;
import com.example.gestiontachems.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TacheService implements ITacheService {

    private final TacheRepository tacheRepository;

    @Autowired
    public TacheService(TacheRepository tacheRepository) {
        this.tacheRepository = tacheRepository;
    }

    @Override
    public Tache createTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public List<Tache> getAllTaches() {
        return tacheRepository.findAll();
    }

    @Override
    public Tache getTacheById(Long id) {
        Optional<Tache> optionalTache = tacheRepository.findById(id);
        return optionalTache.orElse(null);
    }

    @Override
    public Tache updateTache(Tache tache) {
        Tache tache1 = tacheRepository.findById(tache.getId()).get();
        LocalDateTime currentDate = LocalDateTime.now();

        if (tache.isDone() == true && tache1.isDone() == false) {
            tache.setDateFin(currentDate); // Task marked as done, set dateFin to the current date
        } else if (tache.isDone() == false && tache1.isDone() == true) {
            tache.setDateFin(null); // Task marked as not done, set dateFin to null
        }

        return tacheRepository.save(tache);
    }

    @Override
    public void deleteTache(Long id) {

        tacheRepository.deleteById(id);
    }


}
