package com.weg.provaapplucasismaeleckert.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weg.provaapplucasismaeleckert.dto.equipamento.EquipamentoResponse;
import com.weg.provaapplucasismaeleckert.dto.equipamento.CreateEquipamentoRequestDto;
import com.weg.provaapplucasismaeleckert.dto.equipamento.EquipamentoResponse;
import com.weg.provaapplucasismaeleckert.dto.equipamento.UpdateEquipamentoRequestDto;
import com.weg.provaapplucasismaeleckert.mapper.EquipamentoMapper;
import com.weg.provaapplucasismaeleckert.mapper.EquipamentoMapper;
import com.weg.provaapplucasismaeleckert.projection.RelatorioProjection;
import com.weg.provaapplucasismaeleckert.service.EquipamentoService;

@RestController
@RequestMapping("/api/equipamentoes")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;
    private final EquipamentoMapper equipamentoMapper;

    public EquipamentoController(EquipamentoService equipamentoService, EquipamentoMapper equipamentoMapper) {
        this.equipamentoService = equipamentoService;
        this.equipamentoMapper = equipamentoMapper;
    }

    @PostMapping
    public ResponseEntity<EquipamentoResponse> create(
            @RequestBody CreateEquipamentoRequestDto request
    ) {
        var equipamento = equipamentoService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(equipamentoMapper.toResponse(equipamento));
    }

    @GetMapping
    public ResponseEntity<List<EquipamentoResponse>> getAll() {
        var equipamentoes = equipamentoService.getAll();

        var response = equipamentoes.stream()
                .map(equipamentoMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoResponse> getById(
            @PathVariable Long id
    ) {
        var equipamento = equipamentoService.getById(id);

        return ResponseEntity.ok(equipamentoMapper.toResponse(equipamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id
    ) {
        equipamentoService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoResponse> updateById(
            @PathVariable Long id,
            @RequestBody UpdateEquipamentoRequestDto request
    ) {
        var equipamento = equipamentoService.update(id, request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(equipamentoMapper.toResponse(equipamento));
    }

    @GetMapping("/relatorio")
    public ResponseEntity<RelatorioProjection> getRelatorio() {
        var equipamentos = equipamentoService.getRelatorio();

        var response = equipamentos.stream()
                .map(equipamentoMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

}
