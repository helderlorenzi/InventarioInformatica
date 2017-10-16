package com.fatec.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.gestao.model.Servidor;

public interface Servidores extends JpaRepository<Servidor, Long> {

}
