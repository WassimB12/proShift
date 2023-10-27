package com.example.gestionprojetms.controller;

import com.example.gestionprojetms.model.Projet;
import com.example.gestionprojetms.service.IProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/projets")
public class ProjetController {

    private final IProjetService projetService;

    @Autowired
    public ProjetController(IProjetService projetService) {
        this.projetService = projetService;
    }


    @GetMapping
    public ResponseEntity<List<Projet>> getAllProjets() {
        List<Projet> projets = projetService.getAllProjets();
        if (projets.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(projets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjetById(@PathVariable Long id) {
        Optional<Projet> projet = projetService.getProjetById(id);
        return projet.map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }



    @PostMapping
    public ResponseEntity<String> createProjet(@RequestBody Projet projet) {
        Projet createdProjet = projetService.createProjet(projet);
        if (createdProjet == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Échec de la création du projet.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProjet(@PathVariable Long id, @RequestBody Projet updatedProjet) {
        updatedProjet.setId(id);
        Projet projet = projetService.updateProjet(updatedProjet);
        if (projet == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projet non trouvé.");
        }
        return ResponseEntity.ok().build();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProjet(@PathVariable Long id) {
        projetService.deleteProjet(id);
        return ResponseEntity.ok().build();
    }
}
