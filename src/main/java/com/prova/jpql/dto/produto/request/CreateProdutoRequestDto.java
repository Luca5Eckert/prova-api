package com.prova.jpql.dto.produto.request;

import java.math.BigDecimal;

public record CreateProdutoRequestDto(
    String nome,
    String descricao,
    BigDecimal preco,
    Long categoriaId
) {
}
