package com.prova.jpql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prova.jpql.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    boolean existsByNome(String nome);

    @Query("""
            SELECT c
            FROM Categoria c
            JOIN FETCH ON Produto p
            WHERE c.id = :categoriaId
            """)
    Categoria findByIdWithProdutos(@Param("categoriaId") Long categoriaId);
}
