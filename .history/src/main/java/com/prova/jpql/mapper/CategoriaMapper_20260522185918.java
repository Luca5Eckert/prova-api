package com.prova.jpql.mapper;

import org.springframework.stereotype.Component;

import com.prova.jpql.dto.categoria.response.CategoriaResponse;
import com.prova.jpql.model.Categoria;

@Component
public class CategoriaMapper {
    
    public CategoriaResponse toResponse(Categoria categoria){
        return new CategoriaResponse(
            categoria.
        )
    }

}
