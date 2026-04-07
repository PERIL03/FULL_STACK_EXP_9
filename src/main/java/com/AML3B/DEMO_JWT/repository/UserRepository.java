package com.AML3B.DEMO_JWT.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.AML3B.DEMO_JWT.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}