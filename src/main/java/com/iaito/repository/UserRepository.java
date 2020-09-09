package com.iaito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findUserByUsername(String username);
}
