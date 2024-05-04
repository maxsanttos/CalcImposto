package com.max.calcimposto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.max.calcimposto.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
