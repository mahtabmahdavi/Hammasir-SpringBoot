package com.Hammasir.Mahtab.repository;

import com.Hammasir.Mahtab.model.Menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

}
