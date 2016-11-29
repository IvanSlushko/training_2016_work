package com.ivanslushko.training.services.impl;

import org.springframework.stereotype.Service;

import com.ivanslushko.training.services.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Override
	public boolean validateUserPassword(String username, String password) {
		// TODO DAO query
		return username.equals("validuser") && password.equals("validpassword");
	}

}
