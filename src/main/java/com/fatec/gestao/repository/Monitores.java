package com.fatec.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.gestao.model.Monitor;

public interface Monitores extends JpaRepository<Monitor, Long> {

}
