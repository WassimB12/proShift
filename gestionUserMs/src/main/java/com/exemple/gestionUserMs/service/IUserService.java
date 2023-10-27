package com.exemple.gestionUserMs.service;

import com.exemple.gestionUserMs.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAllUser();
    List<User> findUserByRole(User.ERole role);
    User blockUser(String idUser);
    User unBlockUser(String idUser);
    User updateUser (User user);
    User findUserbyId(String idUser);
    public User checkin(String idUser);
    public User checkOut(String idUser);
    void removeUser(String idUser);
    boolean changePassword(String verificationCode, String newPassword);
    boolean changePasswordByUser(String id , String password , String newPassword);
    User findByUsername(String username);
    List<User> findUsersByDepartement(User.Departement departement);


}
