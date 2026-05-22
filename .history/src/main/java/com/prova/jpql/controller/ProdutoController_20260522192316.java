package com.prova.jpql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prova.jpql.dto.produto.request.CreateProdutoRequestDto;
import com.prova.jpql.dto.produto.response.ProdutoResponse;
import com.prova.jpql.mapper.ProdutoMapper;
import com.prova.jpql.service.ProdutoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    
    private ProdutoService produtoService;

    private ProdutoMapper produtoMapper;

    @PostMapping
    public ResponseEntity<ProdutoResponse> create(
        @RequestBody CreateProdutoRequestDto request
    ){
        var produto = produtoService.
    }

}
