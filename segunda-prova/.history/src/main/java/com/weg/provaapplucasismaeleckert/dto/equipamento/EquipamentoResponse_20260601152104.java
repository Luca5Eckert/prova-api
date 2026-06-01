package com.weg.provaapplucasismaeleckert.dto.equipamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EquipamentoResponse(
    Long id,
    String nome,
    String numeroSerie,
    BigDecimal valor,
    LocalDate dataAquisicao,
    Long setorId
) {
    
}
