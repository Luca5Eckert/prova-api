package com.prova.jpql.mapper;

import org.springframework.stereotype.Component;

import com.prova.jpql.dto.produto.response.ProdutoResponse;
import com.prova.jpql.model.Produto;

@Component
public class ProdutoMapper {
    
    public ProdutoResponse toResponse(Produto produto){
        return new ProdutoResponse(
            produto.getNome(),
            produto.getDescricao(),
            produto.getPreco()
            produto.getDataCadastro(),

        );
    }
}
