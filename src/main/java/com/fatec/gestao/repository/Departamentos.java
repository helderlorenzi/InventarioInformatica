package com.fatec.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.gestao.model.Departamento;

public interface Departamentos extends JpaRepository<Departamento, Long> {

}
