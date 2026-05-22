package com.prova.jpql.dto.produto.response;

import java.math.BigDecimal;

public record ProdutoResponse(
    String nome,
    String descricao,
    BigDecimal preco,
    String 
) {
    
}
