package com.prova.jpql.service;

import org.springframework.stereotype.Service;

import com.prova.jpql.dto.categoria.request.CreateCategoriaRequestDto;
import com.prova.jpql.model.Categoria;
import com.prova.jpql.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public Categoria create(CreateCategoriaRequestDto request) {
        Categoria categoria = Categoria.builder()
                .nome(request.nome())
                .produtos(List.of())
                .build();
    }

}
