package com.prova.jpql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prova.jpql.mapper.CategoriaMapper;
import com.prova.jpql.service.CategoriaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private CategoriaService categoriaService;
    private CategoriaMapper mapper;


    
}
