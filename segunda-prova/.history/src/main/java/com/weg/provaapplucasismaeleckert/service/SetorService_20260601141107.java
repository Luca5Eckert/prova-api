package com.weg.provaapplucasismaeleckert.service;

import org.springframework.stereotype.Service;

import com.weg.provaapplucasismaeleckert.dto.setor.CreateSetorRequestDto;
import com.weg.provaapplucasismaeleckert.model.Setor;
import com.weg.provaapplucasismaeleckert.repository.SetorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SetorService {

    private SetorRepository setorRepository;

    public Setor create(CreateSetorRequestDto request) {
        if (setorRepository.existsByNome(request.nome())) {
            throw new RuntimeException("Setor já existente");
        }

        var setor = Setor.builder()
                .nome(nome)
                .build();

        setorRepository.save(setor);
    }

}
