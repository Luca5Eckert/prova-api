package com.prova.jpql.dto.produto.request;

import java.math.BigDecimal;

public record UpdateProdutoRequestDto(
    String nome,
    String descricao,
    BigDecimal preco,
    Categoria
) {
    
}
