package com.prova.jpql.service;

import org.springframework.stereotype.Service;

import com.prova.jpql.repository.ProdutoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProdutoService {
    
    private ProdutoRepository produtoRepository;

    

}
