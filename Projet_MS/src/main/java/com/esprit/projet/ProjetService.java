package tn.esprit.freelancers.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetService {

@Autowired
     ProjetRepository projetRepository;

    public ProjetModel save(ProjetModel projet) {	return projetRepository.save(projet);
    }



    public List<ProjetModel> findAll() {
        return projetRepository.findAll();
    }

    public ProjetModel findById(int id) {
        return projetRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        projetRepository.deleteById(id);
    }

    public ProjetModel updateProjet(ProjetModel projet) {
        ProjetModel existingProjet = projetRepository.findById(projet.getId()).orElse(null);

        if (existingProjet != null) {
            existingProjet.setNom(projet.getNom());
            existingProjet.setDescription(projet.getDescription());
            existingProjet.setBudget(projet.getBudget());
            existingProjet.setCompetencesRequises(projet.getCompetencesRequises());

            return projetRepository.save(existingProjet);
        }

        return null; // Or throw an exception if needed
    }
}
