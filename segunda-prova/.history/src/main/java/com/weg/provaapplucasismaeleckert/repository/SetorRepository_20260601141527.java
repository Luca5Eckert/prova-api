package com.weg.provaapplucasismaeleckert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.weg.provaapplucasismaeleckert.model.Setor;

public interface SetorRepository extends JpaRepository<Setor, Long> {

    boolean existsByNome(String nome);

    @Query(
            """
                SELECT s
                FROM Setor s
                JOIN FETCH s.equipamentos
                WHERE id = :id
                """
    )
    public Setor

}
