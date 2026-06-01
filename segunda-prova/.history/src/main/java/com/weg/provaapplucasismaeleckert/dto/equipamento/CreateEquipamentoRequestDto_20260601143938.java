package com.weg.provaapplucasismaeleckert.dto.equipamento;

import java.math.BigDecimal;
import java.math.BigInteger;

public record CreateEquipamentoRequestDto(
        String nome,
        String numeroSerie,
        BigDecimal
        ) {

}
