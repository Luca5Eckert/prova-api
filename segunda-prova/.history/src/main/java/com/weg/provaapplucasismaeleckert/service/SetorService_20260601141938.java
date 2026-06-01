package com.weg.provaapplucasismaeleckert.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.provaapplucasismaeleckert.dto.setor.CreateSetorRequestDto;
import com.weg.provaapplucasismaeleckert.dto.setor.UpdateSetorRequestDto;
import com.weg.provaapplucasismaeleckert.model.Equipamento;
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
                .nome(request.nome())
                .build();

        return setorRepository.save(setor);
    }
    
    public Setor update(UpdateSetorRequestDto request){
        Setor setor = setorRepository.findByIdWithEquipamento(id)
                .orElseThrow(() -> new RuntimeException("Setor não encontrado pelo id"));

        if(setor.getNome().equals(request.nome())) return setor;
        if (setorRepository.existsByNome(request.nome())) {
            throw new RuntimeException("Setor já existente");
        }

        setor.update(request.nome());

        return setor

    }

    public List<Setor> getAll() {
        return setorRepository.findAll();
    }

    public Setor getById(Long id) {
        return setorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Setor não encontrado pelo id"));
    }

    public List<Equipamento> getAllEquipamentoBySetorId(Long id){
        Setor setor = setorRepository.findByIdWithEquipamento(id)
                .orElseThrow(() -> new RuntimeException("Setor não encontrado pelo id"));

        return setor.getEquipamentos();
    }

    public void deleteById(Long id){
        setorRepository.deleteById(id);
    }

}
