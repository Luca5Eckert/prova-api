package com.prova.jpql.service;

import org.springframework.stereotype.Service;

import com.prova.jpql.dto.produto.request.CreateProdutoRequestDto;
import com.prova.jpql.model.Produto;
import com.prova.jpql.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    
    private ProdutoRepository produtoRepository;

    public Produto create(CreateProdutoRequestDto request){
        if(request.)
    }

}
