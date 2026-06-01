package com.weg.provaapplucasismaeleckert.dto.equipamento;

import java.math.BigDecimal;

public record CreateEquipamentoRequestDto(
        String nome,
        String numeroSerie,
        BigDecimal valor,
        Long setorId
) {

}
