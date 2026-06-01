package com.weg.provaapplucasismaeleckert.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Equipamento {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String numeroSerie;

    private BigDecimal valor;

    private LocalDate dataAquisicao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="setor_id")
    private Setor setor;

    public void update(String nome, String numeroSerie, BigDecimal valor, Setor setor) {
        this.nome = nome;
        this.numeroSerie = numeroSerie;
        this.valor = valor;
        this.setor = setor;
    }
    

}
