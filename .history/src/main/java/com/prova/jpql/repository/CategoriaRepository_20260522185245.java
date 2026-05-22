package com.prova.jpql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prova.jpql.model.Categoria;
import com.prova.jpql.model.Produto;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    boolean existsNome(String nome);

    @Query("""
            
            """;)
    List<Produto> findProdutoByCategoria(Long id);
}
