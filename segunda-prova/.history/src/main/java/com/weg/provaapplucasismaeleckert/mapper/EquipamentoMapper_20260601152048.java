package com.weg.provaapplucasismaeleckert.mapper;

import org.springframework.stereotype.Component;

import com.weg.provaapplucasismaeleckert.dto.equipamento.EquipamentoResponse;
import com.weg.provaapplucasismaeleckert.model.Equipamento;

@Component
public class EquipamentoMapper {
    
    public EquipamentoResponse toResponse(Equipamento equipamento){
        return new EquipamentoResponse(
            equipamento.getId(),
            equipamento.getNome(),
            equipamento.getNumeroSerie(),
            equipamento.getValor(),
            equipamento.
        );
    }
}
