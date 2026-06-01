package com.prova.jpql.repository;

import java.util.Optional;

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
            JOIN FETCH c.produtos p
            WHERE c.id = :categoriaId
            """)
    Optional<Categoria> findByIdWithProdutos(@Param("categoriaId") Long categoriaId);
}
