package com.prova.jpql.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prova.jpql.dto.categoria.request.CreateCategoriaRequestDto;
import com.prova.jpql.dto.categoria.request.UpdateCategoriaRequestDto;
import com.prova.jpql.dto.categoria.response.CategoriaResponse;
import com.prova.jpql.dto.produto.response.ProdutoResponse;
import com.prova.jpql.mapper.CategoriaMapper;
import com.prova.jpql.mapper.ProdutoMapper;
import com.prova.jpql.service.CategoriaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private CategoriaService categoriaService;

    private CategoriaMapper categoriaMapper;
    private ProdutoMapper produtoMapper;

    @PostMapping
    public ResponseEntity<CategoriaResponse> create(
            @RequestBody CreateCategoriaRequestDto request
    ) {
        var categoria = categoriaService.create(request);
        var response = categoriaMapper.toResponse(categoria);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> getAll() {
        var categorias = categoriaService.getAll();
        var response = categorias.stream()
                .map(categoriaMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> getById(@PathVariable Long id){
        var categoria = categoriaService.getById(id);

        return ResponseEntity.ok(categoriaMapper.toResponse(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse> updateById(@PathVariable Long id, UpdateCategoriaRequestDto request){
        var categoria = categoriaService.updateById(id, request);

        return ResponseEntity.ok(categoriaMapper.toResponse(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        categoriaService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/produtos")
    public ResponseEntity<ProdutoResponse> getProdutosByCategoria(@PathVariable Long id){
        var produtos = categoriaService.getProdutosByCategoria(id);
        var response = produtos.stream()
        .map(mapper)
        
    } 

}
