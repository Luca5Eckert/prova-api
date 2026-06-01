package com.weg.provaapplucasismaeleckert.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weg.provaapplucasismaeleckert.service.SetorService;

@RestController
@RequestMapping("/api/setores")
public class SetorController {
    
    private final SetorService setorService;

    public SetorController(SetorService setorService){
        this.setorService = setorService;
    }

    @Post


}
