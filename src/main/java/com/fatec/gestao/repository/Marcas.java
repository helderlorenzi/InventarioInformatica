package com.fatec.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.gestao.model.Marca;

public interface Marcas extends JpaRepository<Marca, Long> {

}
