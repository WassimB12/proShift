package tn.esprit.freelancers.projet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<ProjetModel, Integer> {
    //ProjetModel findByProjetId(int id);
    List<ProjetModel> findAll();
}
