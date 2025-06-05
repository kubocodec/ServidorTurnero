package com.kubocode.turnero.repository;

import com.kubocode.turnero.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    Optional<Turno> findFirstByAtendidoFalseOrderByIdAsc();
    Optional<Turno> findTopByOrderByNumeroDesc();
}
