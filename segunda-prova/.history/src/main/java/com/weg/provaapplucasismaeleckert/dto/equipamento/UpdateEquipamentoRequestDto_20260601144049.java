package com.weg.provaapplucasismaeleckert.dto.equipamento;

import java.math.BigDecimal;

public record UpdateEquipamentoRequestDto(
        String nome,
        String numeroSerie,
        BigDecimal valor,
        Long setorId
        ) {

}
