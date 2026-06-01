package com.weg.provaapplucasismaeleckert.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weg.provaapplucasismaeleckert.dto.setor.CreateSetorRequestDto;
import com.weg.provaapplucasismaeleckert.dto.setor.SetorResponse;
import com.weg.provaapplucasismaeleckert.mapper.SetorMapper;
import com.weg.provaapplucasismaeleckert.service.SetorService;

@RestController
@RequestMapping("/api/setores")
public class SetorController {
    
    private final SetorService setorService;
    private final SetorMapper sensorMappere;

    public SetorController(SetorService setorService){
        this.setorService = setorService;
    }

    @PostMapping
    public ResponseEntity<SetorResponse> create(
        @RequestBody CreateSetorRequestDto request
    ){
        var setor = setorService.create(request);

        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body();
    }


}
