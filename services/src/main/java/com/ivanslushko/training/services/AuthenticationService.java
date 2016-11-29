package com.ivanslushko.training.services;

public interface AuthenticationService {

    boolean validateUserPassword(String username, String password);
}
