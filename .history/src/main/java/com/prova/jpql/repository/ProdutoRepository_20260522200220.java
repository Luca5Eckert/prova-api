package com.prova.jpql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prova.jpql.model.Produto;
import com.prova.jpql.projection.RelatorioProjection;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(
            value = """
            SELECT p.nome AS nomeProduto, p.preco AS preco,
c.nome AS nomeCategoria
FROM produto p
JOIN categoria c ON p.categoria_id = c.id
            """,
            nativeQuery = true
    )
    RelatorioProjection getRelatorioProjetion();

}
