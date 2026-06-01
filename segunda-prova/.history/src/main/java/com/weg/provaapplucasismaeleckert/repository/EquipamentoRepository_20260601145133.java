package com.weg.provaapplucasismaeleckert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.weg.provaapplucasismaeleckert.model.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long>{
    
    @Query(
        value="""
                SELECT 
                """;
    )
}
