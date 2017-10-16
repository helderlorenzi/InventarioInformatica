package com.fatec.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.gestao.model.Equipamento;

public interface Equipamentos extends JpaRepository<Equipamento, Long> {

}
