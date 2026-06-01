package com.prova.jpql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.jpql.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
