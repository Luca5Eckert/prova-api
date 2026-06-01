package com.prova.jpql.mapper;

import org.springframework.stereotype.Component;

import com.prova.jpql.dto.produto.response.ProdutoResponse;

@Component
public class ProdutoMapper {
    
    public ProdutoResponse toResponse(Produto produto){
        return new ProdutoResponse(
            , null, null, null, null)
    }
}
