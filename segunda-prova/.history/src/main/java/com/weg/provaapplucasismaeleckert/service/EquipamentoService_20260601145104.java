package com.weg.provaapplucasismaeleckert.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.provaapplucasismaeleckert.dto.equipamento.CreateEquipamentoRequestDto;
import com.weg.provaapplucasismaeleckert.dto.equipamento.UpdateEquipamentoRequestDto;
import com.weg.provaapplucasismaeleckert.model.Equipamento;
import com.weg.provaapplucasismaeleckert.model.Setor;
import com.weg.provaapplucasismaeleckert.projection.RelatorioProjection;
import com.weg.provaapplucasismaeleckert.repository.EquipamentoRepository;
import com.weg.provaapplucasismaeleckert.repository.SetorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipamentoService {

    private EquipamentoRepository equipamentoRepository;
    private SetorRepository setorRepository;

    public Equipamento create(CreateEquipamentoRequestDto request) {
        Setor setor = setorRepository.findById(request.setorId())
                .orElseThrow(() -> new RuntimeException("Setor não existe já existente"));

        var equipamento = Equipamento.builder()
                .nome(request.nome())
                .numeroSerie(request.numeroSerie())
                .valor(request.valor())
                .dataAquisicao(LocalDate.now())
                .setor(setor)
                .build();

        return equipamentoRepository.save(equipamento);
    }

    public Equipamento update(Long id, UpdateEquipamentoRequestDto request) {
        Equipamento equipamento = equipamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado pelo id"));

        Setor setor = setorRepository.findById(request.setorId())
                .orElseThrow(() -> new RuntimeException("Setor não existe já existente"));

        equipamento.update(
            request.nome(),
            request.numeroSerie(),
            request.valor(),
            setor
        );

        return equipamentoRepository.save(equipamento);
    }

    public List<Equipamento> getAll() {
        return equipamentoRepository.findAll();
    }

    public Equipamento getById(Long id) {
        return equipamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado pelo id"));
    }

    public void deleteById(Long id) {
        equipamentoRepository.deleteById(id);
    }

    public RelatorioProjection getRelatorio(){
        return
    }

}
