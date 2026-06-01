package com.weg.provaapplucasismaeleckert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.weg.provaapplucasismaeleckert.model.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long>{
    
    @Query(
        value="""
            SELECT 
	        e.nome as nomeEquipamento,
            e.valor as valor,
            s.nome as nomeSetor
            FROM
	        equipamento e
JOIN
	setor s ON e.setor_id = s.id
                """;
    )

}
