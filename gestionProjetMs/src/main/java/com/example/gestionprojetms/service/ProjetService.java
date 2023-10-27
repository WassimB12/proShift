package com.example.gestionprojetms.service;


import com.example.gestionprojetms.model.Projet;
import com.example.gestionprojetms.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetService implements IProjetService {

    private final ProjetRepository projetRepository;

    @Autowired
    public ProjetService(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    @Override
    public List<Projet> getAllProjets() {
        return projetRepository.findAll();
    }

    @Override
    public Optional<Projet> getProjetById(Long id) {
        return projetRepository.findById(id);
    }

    @Override
    public Projet createProjet(Projet projet) {
        projet.setDateCreation(new Date());
        return projetRepository.save(projet);
    }

    @Override
    public Projet updateProjet(Projet updatedProjet) {
        System.out.println(updatedProjet.toString());
        Optional<Projet> existingProjet = projetRepository.findById(updatedProjet.getId());
        if (existingProjet.isPresent()) {
            Projet projet = existingProjet.get();
            projet.setNom(updatedProjet.getNom());
            projet.setDateFinEstimee(updatedProjet.getDateFinEstimee());
            projet.setDateFin(updatedProjet.getDateFin());
            projet.setDateDebut(updatedProjet.getDateDebut());
            projet.setDescription(updatedProjet.getDescription());
            if (projet.getEtat().equals(Projet.Etat.ENCOURS) && updatedProjet.getEtat().equals(Projet.Etat.ANNULEE) || updatedProjet.getEtat().equals(Projet.Etat.TERMINER)) {
                projet.setEtat(Projet.Etat.TERMINER);
                projet.setDateFin(new Date());
            } else if ((projet.getEtat().equals(Projet.Etat.ANNULEE) || projet.getEtat().equals(Projet.Etat.TERMINER)) &&
                    updatedProjet.getEtat().equals(Projet.Etat.ENCOURS)) {
                projet.setEtat(Projet.Etat.ENCOURS);
                projet.setDateFin(null);
            } else {
                projet.setEtat(updatedProjet.getEtat());
            }

            return projetRepository.save(projet);
        }
        return null;
    }



    @Override
    public void deleteProjet(Long id) {
            projetRepository.deleteById(id);
        }



}
