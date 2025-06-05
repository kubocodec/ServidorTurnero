package com.kubocode.turnero.service;

import com.kubocode.turnero.model.Turno;
import com.kubocode.turnero.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TurnoService implements ITurnoService{

    @Autowired
    TurnoRepository turnoRepository;

    @Override
    public Turno nuevoTurno(String categoria) {
        int ultimo = turnoRepository.findTopByOrderByNumeroDesc()
                .map(Turno::getNumero)
                .orElse(0);
        Turno t = new Turno();
        t.setNumero(ultimo + 1);
        t.setCategoria(categoria);
        return turnoRepository.save(t);
    }

    @Override
    public Optional<Turno> getTurnoActual() {
        return turnoRepository.findFirstByAtendidoFalseOrderByIdAsc();
    }

    @Override
    public Optional<Turno> avanzarTurno() {
        Optional<Turno> turno = getTurnoActual();
        turno.ifPresent(t -> {
            t.setAtendido(true);
            turnoRepository.save(t);
        });
        return getTurnoActual();
    }
}
