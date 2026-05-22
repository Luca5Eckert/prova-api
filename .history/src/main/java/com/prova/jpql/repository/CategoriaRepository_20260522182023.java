package com.prova.jpql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.jpql.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
