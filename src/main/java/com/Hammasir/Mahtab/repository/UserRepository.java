package com.Hammasir.Mahtab.repository;

import com.Hammasir.Mahtab.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
