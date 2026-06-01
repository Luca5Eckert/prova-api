package com.prova.jpql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prova.jpql.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    boolean existsByNome(String nome);

    @Query("""
            SELECT p
            FROM Categoria c
            JOIN FETCH c.produtos p
            WHERE c.id = :categoriaId
            """)
    List<Produto> findByIdWithProdutos(@Param("categoriaId") Long categoriaId);
}
