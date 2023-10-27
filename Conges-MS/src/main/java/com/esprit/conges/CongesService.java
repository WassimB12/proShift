package com.esprit.conges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongesService {

    @Autowired
   public CongeRepository congeRepository;

    public CongesModel save(CongesModel conge) {	return congeRepository.save(conge);
    }

    public List<CongesModel> findAll() {
        return congeRepository.findAll();
    }

    public CongesModel findById(int id) {
        return congeRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        congeRepository.deleteById(id);
    }



    public CongesModel updateConge(CongesModel conge) {
        CongesModel existingconge = congeRepository.findById(conge.getId()).orElse(null);

        if (existingconge != null) {
            existingconge.setDatedeconge(conge.getDatedeconge());
            existingconge.setDureeduconge(conge.getDureeduconge());
            existingconge.setMotifdureport(conge.getMotifdureport());


            return congeRepository.save(existingconge);
        }

        return null;
    }

}
