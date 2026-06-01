package com.weg.provaapplucasismaeleckert.mapper;

import org.springframework.stereotype.Component;

import com.weg.provaapplucasismaeleckert.dto.setor.SetorResponse;
import com.weg.provaapplucasismaeleckert.model.Setor;

@Component
public class SetorMapper {
    
    public SetorResponse toResponse(Setor setor){
        return new SetorResponse(
            setor.getId(),
            setor.getNome()
        );
    }

}
