package com.weg.provaapplucasismaeleckert.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.provaapplucasismaeleckert.dto.equipamento.CreateEquipamentoRequestDto;
import com.weg.provaapplucasismaeleckert.dto.equipamento.UpdateEquipamentoRequestDto;
import com.weg.provaapplucasismaeleckert.model.Equipamento;
import com.weg.provaapplucasismaeleckert.repository.EquipamentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipamentoService {

    private EquipamentoRepository EquipamentoRepository;

    public Equipamento create(CreateEquipamentoRequestDto request) {
        if (EquipamentoRepository.existsByNome(request.nome())) {
            throw new RuntimeException("Equipamento já existente");
        }

        var Equipamento = Equipamento.builder()
                .nome(request.nome())
                .build();

        return EquipamentoRepository.save(Equipamento);
    }
    
    public Equipamento update(Long id, UpdateEquipamentoRequestDto request){
        Equipamento Equipamento = EquipamentoRepository.findByIdWithEquipamento(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado pelo id"));

        if(Equipamento.getNome().equals(request.nome())) return Equipamento;
        if (EquipamentoRepository.existsByNome(request.nome())) {
            throw new RuntimeException("Equipamento já existente");
        }

        Equipamento.update(request.nome());

        return EquipamentoRepository.save(Equipamento);
    }

    public List<Equipamento> getAll() {
        return EquipamentoRepository.findAll();
    }

    public Equipamento getById(Long id) {
        return EquipamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado pelo id"));
    }

    public List<Equipamento> getAllEquipamentoByEquipamentoId(Long id){
        Equipamento Equipamento = EquipamentoRepository.findByIdWithEquipamento(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado pelo id"));

        return Equipamento.getEquipamentos();
    }

    public void deleteById(Long id){
        EquipamentoRepository.deleteById(id);
    }

}
