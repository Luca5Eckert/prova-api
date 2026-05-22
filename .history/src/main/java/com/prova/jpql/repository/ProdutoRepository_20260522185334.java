package com.prova.jpql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import com.prova.jpql.model.Produto;
import com.prova.jpql.projection.RelatorioProjection;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @NativeQuery("""
            SELECT
                p.nome as nomeProduto
                p.preco as preco
                c.nome as nomeCategoria
            FROM
                Produto p
            JOIN
                Categoria c ON p.categoria_id = c.id
            """
    ) 
    RelatorioProjection getRelatorioProjetion();

    @Q
    List<Produto> findByCategoriaId(Long id);

}
