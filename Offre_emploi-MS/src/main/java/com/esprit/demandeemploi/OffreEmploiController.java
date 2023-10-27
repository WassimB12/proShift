package com.esprit.demandeemploi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200" )
@RestController
@RequestMapping("/OffreEmploi")
public class OffreEmploiController {

    @Autowired
    OffreEmploiService offreEmploiService;


 @GetMapping
    public List<OffreEmploiModel> getAllOffre(){
     return offreEmploiService.findAll();
 }
 @PostMapping
 public ResponseEntity<OffreEmploiModel>createOffre(@RequestBody OffreEmploiModel offre){
     OffreEmploiModel savedOffre =offreEmploiService.save(offre);
     return new ResponseEntity<>(savedOffre,HttpStatus.CREATED);
 }



 @GetMapping("/{id}")
 public ResponseEntity<OffreEmploiModel>getOffreById(@PathVariable int id){
     OffreEmploiModel offre =offreEmploiService.findById(id);
     if (offre !=null){
         return ResponseEntity.ok(offre);
     }else {
         return ResponseEntity.notFound().build();
     }
 }

 @PutMapping("/{id}")
 public ResponseEntity<OffreEmploiModel> updateOffre(@PathVariable int id,@RequestBody OffreEmploiModel offre){
     offre.setId(id);
     OffreEmploiModel updateOffre =offreEmploiService.updateOffre(offre);
     if (updateOffre != null){
         return ResponseEntity.ok(updateOffre);
     }else {
         return ResponseEntity.notFound().build();
     }
 }

@DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
     offreEmploiService.deleteById(id);
     return ResponseEntity.ok("this offfre with ID "+ id +"deleted successfully.");
  }
}
