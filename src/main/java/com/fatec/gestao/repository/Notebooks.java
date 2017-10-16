package com.fatec.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.gestao.model.Notebook;

public interface Notebooks extends JpaRepository<Notebook, Long> {

}
