package com.kubocode.turnero.service;


import com.kubocode.turnero.model.Turno;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ITurnoService {
    public Turno nuevoTurno(String categoria);
    public Optional<Turno> getTurnoActual();
    public Optional<Turno> avanzarTurno();
}
