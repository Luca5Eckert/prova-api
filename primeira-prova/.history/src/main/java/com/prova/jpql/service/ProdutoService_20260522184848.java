package com.prova.jpql.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prova.jpql.dto.produto.request.CreateProdutoRequestDto;
import com.prova.jpql.dto.produto.request.UpdateProdutoRequestDto;
import com.prova.jpql.model.Categoria;
import com.prova.jpql.model.Produto;
import com.prova.jpql.projection.RelatorioProjection;
import com.prova.jpql.repository.CategoriaRepository;
import com.prova.jpql.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    private CategoriaRepository categoriaRepository;

    public Produto create(CreateProdutoRequestDto request) {
        Categoria categoria = categoriaRepository.findById(request.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        var produto = Produto.builder()
                .nome(request.nome())
                .descricao(request.descricao())
                .categoria(categoria)
                .dataCadastro(LocalDate.now())
                .build();

        produtoRepository.save(produto);

        return produto;
    }

    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Produto getById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto updateById(Long id, UpdateProdutoRequestDto request) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Categoria categoria = categoriaRepository.findById(request.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        produto.update(
                request.nome(),
                request.descricao(),
                request.preco(),
                categoria
        );

        produtoRepository.save(produto);

        return produto;
    }

    public RelatorioProjection getRelatorio()



}
