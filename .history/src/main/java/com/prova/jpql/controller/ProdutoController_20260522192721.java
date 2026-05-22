package com.prova.jpql.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    ) {
        var produto = produtoService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(produtoMapper.toResponse(produto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> getAll() {
        var produtos = produtoService.getAll();

        var response = produtos.stream()
                .map(produtoMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> getById(@PathVariable Long id){
        var produto = produtoService.getById(id);

        return ResponseEntity.ok(produtoMapper.toResponse(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> updateById(
        @PathVariable Long id,
        @RequestBody Update
    ){

    }

}
