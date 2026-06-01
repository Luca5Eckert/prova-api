package com.weg.provaapplucasismaeleckert.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.provaapplucasismaeleckert.dto.equipamento.CreateEquipamentoRequestDto;
import com.weg.provaapplucasismaeleckert.dto.equipamento.UpdateEquipamentoRequestDto;
import com.weg.provaapplucasismaeleckert.model.Equipamento;
import com.weg.provaapplucasismaeleckert.repository.EquipamentoRepository;
import com.weg.provaapplucasismaeleckert.repository.SetorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipamentoService {

    private EquipamentoRepository equipamentoRepository;
    private SetorRepository setorRepository;

    public Equipamento create(CreateEquipamentoRequestDto request) {
        Setor setor = setorRepository.fin

        var equipamento = Equipamento.builder()
                .nome(request.nome())
                .build();

        return equipamentoRepository.save(equipamento);
    }
    
    public Equipamento update(Long id, UpdateEquipamentoRequestDto request){
        Equipamento equipamento = equipamentoRepository.findByIdWithEquipamento(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado pelo id"));

        if(equipamento.getNome().equals(request.nome())) return Equipamento;
        if (equipamentoRepository.existsByNome(request.nome())) {
            throw new RuntimeException("Equipamento já existente");
        }

        equipamento.update(request.nome());

        return equipamentoRepository.save(equipamento);
    }

    public List<Equipamento> getAll() {
        return equipamentoRepository.findAll();
    }

    public Equipamento getById(Long id) {
        return equipamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado pelo id"));
    }


    public void deleteById(Long id){
        equipamentoRepository.deleteById(id);
    }

}
