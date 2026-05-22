package com.prova.jpql.service;

import org.springframework.stereotype.Service;

import com.prova.jpql.dto.produto.request.CreateProdutoRequestDto;
import com.prova.jpql.model.Produto;
import com.prova.jpql.repository.CategoriaRepository;
import com.prova.jpql.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    
    private ProdutoRepository produtoRepository;
    private CategoriaRepository categoriaRepository;

    public Produto create(CreateProdutoRequestDto request){
        if(!categoriaRepository.existsById(request.categoriaId())){
            throw new RuntimeException("Categoria não encontrada");
        }

        var produto = Produto.builder()
        .nome(request.nome())
        .descricao(request.descricao())
        .categoria(categoria)

    }

}
