package com.esprit.conges;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/conges")
public class CongeController {
    @Autowired
    CongesService congesService;

    @GetMapping("/conges")
    public List<CongesModel> getAllConges() {
        return congesService.findAll();
    }

    @PostMapping
    public ResponseEntity<CongesModel> createConges(@RequestBody CongesModel conge ) {
        CongesModel savedconge = congesService.save(conge);
        return new ResponseEntity<>(savedconge, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConge(@PathVariable int id) {
        congesService.deleteById(id);
        return ResponseEntity.ok("Conge with ID " + id + " deleted successfully.");
    }


    @PutMapping("/{id}")
    public ResponseEntity<CongesModel> updateConge(@PathVariable int id, @RequestBody CongesModel conge) {
        conge.setId(id);
        CongesModel updatedConge = congesService.updateConge(conge);
        if (updatedConge != null) {
            return ResponseEntity.ok(updatedConge);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CongesModel> getcongeById(@PathVariable int id) {
        CongesModel conge = congesService.findById(id);
        if (conge != null) {
            return ResponseEntity.ok(conge);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
