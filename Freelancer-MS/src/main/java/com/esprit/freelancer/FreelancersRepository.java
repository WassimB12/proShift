 package com.esprit.freelancer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreelancersRepository extends JpaRepository<FreelancersModel, Integer>{

	FreelancersModel findByEmail(String email);

	FreelancersModel findByFreelancerId(Integer freelancerId);
}
