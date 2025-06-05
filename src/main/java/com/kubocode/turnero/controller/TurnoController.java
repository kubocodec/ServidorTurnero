package com.kubocode.turnero.controller;

import com.kubocode.turnero.model.Turno;
import com.kubocode.turnero.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping
    public ResponseEntity<Turno> crearTurno(@RequestParam String categoria) {
        return ResponseEntity.ok(turnoService.nuevoTurno(categoria));
    }

    @GetMapping("/actual")
    public ResponseEntity<Turno> turnoActual() {
        return turnoService.getTurnoActual()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PutMapping("/next")
    public ResponseEntity<Turno> siguienteTurno() {
        return turnoService.avanzarTurno()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }
}

