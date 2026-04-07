package com.AML3B.DEMO_JWT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AML3B.DEMO_JWT.repository.UserRepository;
import com.AML3B.DEMO_JWT.security.JwtUtil;

@Service
public class AuthService {
	@Autowired
    UserRepository repo;

    @Autowired
    JwtUtil jwtUtil;

    public String login(String username, String password) {

        var user = repo.findByUsername(username);

        if(user != null && user.getPassword().equals(password)) {
            return jwtUtil.generateToken(username);
        }

        return "Invalid Credentials";
    }
}