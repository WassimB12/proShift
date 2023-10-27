package com.esprit.demandeemploi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreEmploiService {
    @Autowired
    OffreEmploiRepository OffreEmploiRepository;
    public  OffreEmploiModel save(OffreEmploiModel offre ){
        return OffreEmploiRepository.save(offre); }

    public List<OffreEmploiModel>findAll(){
        return OffreEmploiRepository.findAll();
    }
    public  OffreEmploiModel findById(int id){
        return OffreEmploiRepository.findById(id).orElse(null);
    }
    public void deleteById(int id) {
        OffreEmploiRepository.deleteById(id);
    }
    public OffreEmploiModel updateOffre (OffreEmploiModel offre){
        OffreEmploiModel existingOffre=OffreEmploiRepository.findById(offre.getId()).orElse(null);
        if (existingOffre !=null){
            existingOffre.setTitre(offre.getTitre());
            existingOffre.setTypeEmploi(offre.getTypeEmploi());
            existingOffre.setAdressMail(offre.getAdressMail());
            existingOffre.setDatePublication(offre.getDatePublication());
            existingOffre.setCompetanceRequise(offre.getCompetanceRequise());
            existingOffre.setStatut(offre.getStatut());

            return OffreEmploiRepository.save(existingOffre);
        }
        return null ;
    }

}
