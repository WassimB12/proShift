package com.esprit.equipe.service;


import com.esprit.equipe.model.Equipe;
import com.esprit.equipe.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EquipeService implements IEquipeService {
    private final EquipeRepository equipeRepository;
    @Autowired
    public EquipeService(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }
    @Override
    public Optional<Equipe> getEquipeById(Long id) {
        return equipeRepository.findById(id);
    }

    @Override
    public Equipe createEquipe(Equipe equipe) {
        equipe.setDateCreation(new Date());
        equipeRepository.save(equipe);

        return equipe;
    }

    @Override
    public Equipe updateEquipe( Equipe updatedEquipe) {
        Optional<Equipe> existingEquipe = equipeRepository.findById(updatedEquipe.getId());
        if (existingEquipe.isPresent()) {
            Equipe equipe = existingEquipe.get();
            equipe.setName(updatedEquipe.getName());
            return equipeRepository.save(equipe);
        }
        return null;
    }

    @Override
    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);
    }
}
