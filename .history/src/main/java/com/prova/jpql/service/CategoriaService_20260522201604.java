package com.prova.jpql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prova.jpql.dto.categoria.request.CreateCategoriaRequestDto;
import com.prova.jpql.dto.categoria.request.UpdateCategoriaRequestDto;
import com.prova.jpql.model.Categoria;
import com.prova.jpql.model.Produto;
import com.prova.jpql.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria create(CreateCategoriaRequestDto request) {
        if (categoriaRepository.existsByNome(request.nome())) {
            throw new RuntimeException("Categoria com nome duplicado");
        }

        var categoria = Categoria.builder()
                .nome(request.nome())
                .produtos(new ArrayList<>())
                .build();

        categoriaRepository.save(categoria);

        return categoria;
    }

    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    public Categoria getById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public Categoria updateById(Long id, UpdateCategoriaRequestDto request) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        categoria.update(request.nome());

        categoriaRepository.save(categoria);

        return categoria;
    }

    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }

    public List<Produto> getProdutosByCategoria(Long id) {
        Categoria categoria = categoriaRepository.findByIdWithProdutos(id)

        return categoria.getProdutos();
    }

}
