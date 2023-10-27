package com.esprit.freelancer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class FreelancersServiceImpl {

	@Autowired
	private FreelancersRepository freelancerRepo;

	public FreelancersModel save(FreelancersModel freelancer) {	return freelancerRepo.save(freelancer);
	}
	public FreelancersModel updateFreelance(FreelancersModel freelance) {
		FreelancersModel existingFreelance = freelancerRepo.findByFreelancerId(freelance.getFreelancerId());

		if (existingFreelance != null) {
			existingFreelance.setName(freelance.getName());
			existingFreelance.setFamily_name(freelance.getFamily_name());
			existingFreelance.setGender(freelance.getGender());
			existingFreelance.setMdp(freelance.getMdp());
			existingFreelance.setAddress(freelance.getAddress());
			existingFreelance.setEmail(freelance.getEmail());


			return freelancerRepo.save(existingFreelance);
		}

		return null; // Or throw an exception if needed
	}
	public FreelancersModel findByEmail(String email) {
		return freelancerRepo.findByEmail(email);
	}

	public FreelancersModel findByFreelancerId(Integer freelancerId) {
		return freelancerRepo.findByFreelancerId(freelancerId);
	}

	public List<FreelancersModel> getList() {
		return freelancerRepo.findAll();
	}

	public void deleteByFreelancerId(Integer freelancerId) {
		FreelancersModel freelancer = freelancerRepo.findByFreelancerId(freelancerId);
		freelancerRepo.delete(freelancer);
	}


}
