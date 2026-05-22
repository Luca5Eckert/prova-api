package com.prova.jpql.service;

import org.springframework.stereotype.Service;

import com.prova.jpql.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    
    private CategoriaRepository categoriaRepository;

    

}
