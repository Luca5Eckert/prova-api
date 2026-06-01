package com.weg.provaapplucasismaeleckert.dto.equipamento;

import java.math.BigDecimal;

public record EquipamentoResponse(
    Long id,
    String nome,
    String numeroSerie,
    BigDecimal valor,
        Long setorId
) {
    
}
