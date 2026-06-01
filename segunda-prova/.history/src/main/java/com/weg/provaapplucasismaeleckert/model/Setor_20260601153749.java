package com.weg.provaapplucasismaeleckert.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Setor {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy="setor", orphanRemoval=true, fetch=FetchType.LAZY)
    private List<Equipamento> equipamentos;

    public void update(String nome){
        if(nome.isBlank()) return;
        this.nome = nome;
    }

}
