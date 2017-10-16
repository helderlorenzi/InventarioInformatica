package com.fatec.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.gestao.model.Switcher;

public interface Switches extends JpaRepository<Switcher, Long> {

}
