package com.exemple.gestionUserMs.service;


import com.exemple.gestionUserMs.repository.UserRepository;
import com.exemple.gestionUserMs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService implements IUserService {


    private final UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User signup(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Override
    public List<User> findAllUser() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    @Override
    public List<User> findUserByRole(User.ERole role) {
        List<User> users= new ArrayList<>();
        userRepository.findUserByRole(role).forEach(users::add);
        return users;
    }

    @Override
    public User blockUser(String idUser) {
        User user =userRepository.findById(idUser).orElse(null);
        user.setBlocked(true);

        return userRepository.save(user);
    }

    @Override
    public User unBlockUser(String idUser) {
        User user =userRepository.findById(idUser).orElse(null);
        user.setBlocked(false);

        return userRepository.save(user);
    }

    @Override
    public User checkin(String idUser) {
        User user =userRepository.findById(idUser).orElse(null);
        user.setCheckin(new Date());

        return userRepository.save(user);
    }

    @Override
    public User checkOut(String idUser){
        User user =userRepository.findById(idUser).orElse(null);
        user.setCheckin(null);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User user1 = userRepository.findById(user.getId()).orElse(null);


        if (user1 != null) {
            if (user.getUsername() != null) {
                user1.setUsername(user.getUsername());
            }

            if (user.getEmail() != null) {
                user1.setEmail(user.getEmail());
            }

            if (user.getPassword() != null) {
                user1.setPassword(user.getPassword());
            }

            if (user.getRole() != null) {
                user1.setRole(user.getRole());
            }


            if (user.getCin() != null) {
                user1.setCin(user.getCin());
            }


           user1.setStatut(user.isStatut());


            if (user.getResetPasswordToken() != null) {
                user1.setResetPasswordToken(user.getResetPasswordToken());
            }

            if (user.getVerificationCode() != null) {
                user1.setVerificationCode(user.getVerificationCode());
            }

            user1.setBlocked(user.isBlocked());

            if (user.getMatricule() != null) {
                user1.setMatricule(user.getMatricule());
            }

            if (user.getNom() != null) {
                user1.setNom(user.getNom());
            }

            if (user.getPrenom() != null) {
                user1.setPrenom(user.getPrenom());
            }

            if (user.getDateNaissance() != null) {
                user1.setDateNaissance(user.getDateNaissance());
            }

            if (user.getNumTelephone() != null) {
                user1.setNumTelephone(user.getNumTelephone());
            }

            if (user.getAdresse() != null) {
                user1.setAdresse(user.getAdresse());
            }

            if (user.getDateEmbauche() != null) {
                user1.setDateEmbauche(user.getDateEmbauche());
            }

            if (user.getUrgenceNom() != null) {
                user1.setUrgenceNom(user.getUrgenceNom());
            }

            if (user.getUrgenceNum() != null) {
                user1.setUrgenceNum(user.getUrgenceNum());
            }

            if (user.getCongeSolde() != null) {
                user1.setCongeSolde(user.getCongeSolde());
            }

            if (user.getCheckin() != null) {
                user1.setCheckin(user.getCheckin());
            }

            if (user.isApproved() != user1.isApproved()) {
                user1.setApproved(user.isApproved());
            }

            if (user.getPoste() != null) {
                user1.setPoste(user.getPoste());
            }

            if (user.getEtatCivil() != null) {
                user1.setEtatCivil(user.getEtatCivil());
            }

            if (user.getDepartement() != null) {
                user1.setDepartement(user.getDepartement());
            }

            // Set other properties accordingly


            return userRepository.save(user1);
        }
        return null; // Handle case when user1 is not found
    }

    @Override
    public User findUserbyId(String idUser) {
        return userRepository.findById(idUser).orElse(null);
    }

    @Override
    public void removeUser(String idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public boolean changePassword(String verificationCode, String newPassword) {
        User user = userRepository.findByResetPasswordToken(verificationCode);

        if (user == null) {
            return false;
        } else {
            user.setResetPasswordToken(null);
            user.setPassword(newPassword);
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public boolean changePasswordByUser(String id ,String password, String newPassword) {
        User user = userRepository.findById(id).get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return false;
        }

        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return true;
    }

    @Override
    public User findByUsername(String username){
        return  userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<User> findUsersByDepartement(User.Departement departement) {
        return userRepository.findUsersByDepartement(departement);
    }





}
