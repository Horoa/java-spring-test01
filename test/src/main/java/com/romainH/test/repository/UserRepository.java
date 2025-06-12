package com.romainH.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.romainH.test.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
