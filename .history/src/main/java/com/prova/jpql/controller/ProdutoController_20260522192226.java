package com.prova.jpql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prova.jpql.mapper.ProdutoMapper;
import com.prova.jpql.service.ProdutoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    
    private ProdutoService produtoService;

    private ProdutoMapper produtoMapper;

    pub

}
