package com.prova.jpql.dto.produto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProdutoResponse(
    String nome,
    String descricao,
    BigDecimal preco,
    LocalDate dataCadastro,
    Long categoriaId 
) {
    
}
