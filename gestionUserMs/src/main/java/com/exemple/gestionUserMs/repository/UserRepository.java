package com.exemple.gestionUserMs.repository;

import com.exemple.gestionUserMs.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findUserByRole(User.ERole role);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    User findByVerificationCode(String code);
    User findByEmail(String email);
    boolean existsByCin(String cin);
    User findByResetPasswordToken(String token);
    List<User> findUsersByDepartement(User.Departement departement);

}
