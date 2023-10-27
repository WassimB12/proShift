package com.esprit.freelancer;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.HttpStatus;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "freelancers")
public class FreelancersController {


    @Autowired
    private FreelancersServiceImpl freelancersService;

    @Autowired
    private FreelancersRepository freelancerRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private static final String ADMIN_EMAIL = "admin@example.com";
    private static final String ADMIN_PASSWORD = "adminpassword";
    @PostMapping("/loginadmin")
    public ResponseEntity<Map<String, Object>> loginAdministrator(@RequestBody FreelancersModel client) {
        System.out.println("in login-admin" + client);
        HashMap<String, Object> response = new HashMap<>();

        // Check if client, email, and mdp are not null
        if (client != null && client.getEmail() != null && client.getMdp() != null) {
            // Vérifier les identifiants statiques
            if (client.getEmail().equals(ADMIN_EMAIL) && client.getMdp().equals(ADMIN_PASSWORD)) {
                String token = Jwts.builder()
                        .claim("data", client)
                        .signWith(SignatureAlgorithm.HS256, "SECRET")
                        .compact();
                response.put("token", token);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        }

        // Si les identifiants ne correspondent pas ou sont null
        response.put("message", "Invalid credentials");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }



    @PostMapping("/add")
    public ResponseEntity<FreelancersModel> createFreelance(@RequestBody FreelancersModel Freelancers) {
        FreelancersModel savedFreelance = freelancersService.save(Freelancers);
        return new ResponseEntity<>(savedFreelance, HttpStatus.CREATED);
    }

    @GetMapping(value = "view")
    public ResponseEntity<List<FreelancersModel>> list() {
        List<FreelancersModel> freelancersList = freelancersService.getList();
        return ResponseEntity.ok(freelancersList);
    }

    @GetMapping(value = "/edit/{freelancerId}")
    public ResponseEntity<FreelancersModel> edit(@PathVariable Integer freelancerId) {
        FreelancersModel freelancer = freelancersService.findByFreelancerId(freelancerId);
        if (freelancer != null) {
            return ResponseEntity.ok(freelancer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<FreelancersModel> updateFreelance(@PathVariable int id, @RequestBody FreelancersModel freelance) {
        freelance.setFreelancerId(id);
        FreelancersModel updatedFreelance = freelancersService.updateFreelance(freelance);
        if (updatedFreelance != null) {
            return ResponseEntity.ok(updatedFreelance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping(value = "/delete/{freelancerId}")
    public ResponseEntity<String> delete(@PathVariable Integer freelancerId) {
        if (freelancerId != null) {
            try {
                freelancersService.deleteByFreelancerId(freelancerId);
                return ResponseEntity.ok("Freelancer Information successfully deleted");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la suppression du freelance");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginfrrelancer(@RequestBody FreelancersModel client) {
        System.out.println("in login-admin"+client);
        HashMap<String, Object> response = new HashMap<>();

        FreelancersModel userFromDB = freelancerRepo.findByEmail(client.getEmail());
        System.out.println("userFromDB+admin"+userFromDB);
        if (userFromDB == null) {
            response.put("message", "Admin not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            boolean compare = this.bCryptPasswordEncoder.matches(client.getMdp(), userFromDB.getMdp());
            System.out.println("compare"+compare);
            if (!compare) {
                response.put("message", "admin not found !");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }else
            {
                String token = Jwts.builder()
                        .claim("data", userFromDB)
                        .signWith(SignatureAlgorithm.HS256, "SECRET")
                        .compact();
                response.put("token", token);
                System.out.println("hhh");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }

        }
    }



    @PostMapping(path = "register")
    public ResponseEntity<FreelancersModel> addClient(@RequestBody FreelancersModel client) {
        client.setMdp(this.bCryptPasswordEncoder.encode(client.getMdp()));
        FreelancersModel savedUser = freelancerRepo.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
