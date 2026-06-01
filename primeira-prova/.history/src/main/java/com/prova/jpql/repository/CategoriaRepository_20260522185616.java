package com.prova.jpql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prova.jpql.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    boolean existsNome(String nome);


    @Query("""
            SELECT c
            FROM Categoria c
            JOIN FETCH Produto p
            WHERE c.id = :categoriaId
            """;)
    Categoria findByIdWithProdutos(@Param())
}
