package com.prova.jpql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prova.jpql.model.Produto;
import com.prova.jpql.projection.RelatorioProjection;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(
        value=
    ) 
    RelatorioProjection getRelatorioProjetion();

    @Query("""
            SELECT p
            FROM Produto p
            WHERE p.categoria.id = :categoriaId
            """
    )
    List<Produto> findByCategoriaId(@Param("categoriaId") Long categoriaId);

}
