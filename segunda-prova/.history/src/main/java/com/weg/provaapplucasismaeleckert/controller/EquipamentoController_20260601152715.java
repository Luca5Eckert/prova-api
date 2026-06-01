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
import com.weg.provaapplucasismaeleckert.dto.setor.CreateEquipamentoRequestDto;
import com.weg.provaapplucasismaeleckert.dto.setor.EquipamentoResponse;
import com.weg.provaapplucasismaeleckert.dto.setor.UpdateEquipamentoRequestDto;
import com.weg.provaapplucasismaeleckert.mapper.EquipamentoMapper;
import com.weg.provaapplucasismaeleckert.mapper.EquipamentoMapper;
import com.weg.provaapplucasismaeleckert.service.EquipamentoService;

@RestController
@RequestMapping("/api/setores")
public class EquipamentoController {

    private final EquipamentoService setorService;
    private final EquipamentoMapper equipamentoMapper;

    public EquipamentoController(EquipamentoService setorService, EquipamentoMapper equipamentoMapper, EquipamentoMapper equipamentoMapper) {
        this.setorService = setorService;
        this.equipamentoMapper = equipamentoMapper;
        this.equipamentoMapper = equipamentoMapper;
    }

    @PostMapping
    public ResponseEntity<EquipamentoResponse> create(
            @RequestBody CreateEquipamentoRequestDto request
    ) {
        var setor = setorService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(equipamentoMapper.toResponse(setor));
    }

    @GetMapping
    public ResponseEntity<List<EquipamentoResponse>> getAll() {
        var setores = setorService.getAll();

        var response = setores.stream()
                .map(equipamentoMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoResponse> getById(
            @PathVariable Long id
    ) {
        var setor = setorService.getById(id);

        return ResponseEntity.ok(equipamentoMapper.toResponse(setor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id
    ) {
        setorService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoResponse> updateById(
            @PathVariable Long id,
            @RequestBody UpdateEquipamentoRequestDto request
    ) {
        var setor = setorService.update(id, request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(equipamentoMapper.toResponse(setor));
    }

    @GetMapping("/{id}/equipamentos")
    public ResponseEntity<List<EquipamentoResponse>> getEquipamentoById(@PathVariable Long id) {
        var equipamentos = setorService.getAllEquipamentoByEquipamentoId(id);

        var response = equipamentos.stream()
                .map(equipamentoMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

}
