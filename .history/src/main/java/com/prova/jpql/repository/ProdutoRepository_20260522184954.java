package com.prova.jpql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import com.prova.jpql.model.Produto;
import com.prova.jpql.projection.RelatorioProjection;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    @NativeQuery("""
            SELECT
                p
            """;)
    RelatorioProjection getRelatorioProjetion();
    
}
