package com.prova.jpql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prova.jpql.dto.categoria.request.CreateCategoriaRequestDto;
import com.prova.jpql.dto.categoria.response.CategoriaResponse;
import com.prova.jpql.mapper.CategoriaMapper;
import com.prova.jpql.service.CategoriaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private CategoriaService categoriaService;
    private CategoriaMapper mapper;

    @PostMapping
    public ResponseEntity<CategoriaResponse> create(
        @RequestBody CreateCategoriaRequestDto request
    ){
        var categoria = categoriaService.create(request);
        var response = mapper.toResponse(categoria);

        return ResponseEntity.
        
    }
    
}
