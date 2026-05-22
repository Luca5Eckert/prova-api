package com.prova.jpql.dto.produto.request;

public record CreateProdutoRequestDto(
    String nome;
    String descricao
    BigDecimal preco;
    Long categoriaId;
) {

    
    
}
