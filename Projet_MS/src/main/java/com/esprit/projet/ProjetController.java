package tn.esprit.freelancers.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/projets")
public class ProjetController {

    @Autowired
     ProjetService projetService;

    @PostMapping
    public ResponseEntity<ProjetModel> createProjet(@RequestBody ProjetModel projet) {
        ProjetModel savedProjet = projetService.save(projet);
        return new ResponseEntity<>(savedProjet, HttpStatus.CREATED);
    }


    @GetMapping("/projets")
    public List<ProjetModel> getAllProjets() {
        return projetService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProjet(@PathVariable int id) {
        projetService.deleteById(id);
        return ResponseEntity.ok("Projet with ID " + id + " deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetModel> updateProjet(@PathVariable int id, @RequestBody ProjetModel projet) {
        projet.setId(id);
        ProjetModel updatedProjet = projetService.updateProjet(projet);
        if (updatedProjet != null) {
            return ResponseEntity.ok(updatedProjet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetModel> getProjetById(@PathVariable int id) {
        ProjetModel projet = projetService.findById(id);
        if (projet != null) {
            return ResponseEntity.ok(projet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}






