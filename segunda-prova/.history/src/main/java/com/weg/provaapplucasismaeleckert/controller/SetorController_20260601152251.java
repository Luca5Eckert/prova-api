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
import com.weg.provaapplucasismaeleckert.dto.setor.CreateSetorRequestDto;
import com.weg.provaapplucasismaeleckert.dto.setor.SetorResponse;
import com.weg.provaapplucasismaeleckert.dto.setor.UpdateSetorRequestDto;
import com.weg.provaapplucasismaeleckert.mapper.EquipamentoMapper;
import com.weg.provaapplucasismaeleckert.mapper.SetorMapper;
import com.weg.provaapplucasismaeleckert.service.SetorService;

@RestController
@RequestMapping("/api/setores")
public class SetorController {

    private final SetorService setorService;

    private final SetorMapper setorMapper;
    private final EquipamentoMapper equipamentoMapper;

    public SetorController(SetorService setorService, SetorMapper setorMapper, EquipamentoMapper equipamentoMapper) {
        this.setorService = setorService;
        this.setorMapper = setorMapper;
        this.equipamentoMapper = equipamentoMapper;
    }

    @PostMapping
    public ResponseEntity<SetorResponse> create(
            @RequestBody CreateSetorRequestDto request
    ) {
        var setor = setorService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(setorMapper.toResponse(setor));
    }

    @GetMapping
    public ResponseEntity<List<SetorResponse>> getAll() {
        var setores = setorService.getAll();

        var response = setores.stream()
                .map(setorMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SetorResponse> getById(
            @PathVariable Long id
    ) {
        var setor = setorService.getById(id);

        return ResponseEntity.ok(setorMapper.toResponse(setor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id
    ) {
        setorService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SetorResponse> updateById(
            @PathVariable Long id,
            @RequestBody UpdateSetorRequestDto request
    ) {
        var setor = setorService.update(id, request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(setorMapper.toResponse(setor));
    }

    @GetMapping("/{id}/equipamentos")
    public ResponseEntity<List<EquipamentoResponse>> getEquipamentoById(@PathVariable Long id){
        var equipamentos = setorService.getAllEquipamentoBySetorId(id);

        var res
    }

}
