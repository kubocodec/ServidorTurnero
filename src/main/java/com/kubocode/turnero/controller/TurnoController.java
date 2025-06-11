package com.kubocode.turnero.controller;

import com.kubocode.turnero.model.Turno;
import com.kubocode.turnero.service.ITurnoService;
import com.kubocode.turnero.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService turnoService;

    @PostMapping
    public Turno crearTurno(@RequestBody Turno turno) {
        return turnoService.guardarTurno(turno);
    }

    @GetMapping("/abiertos")
    public List<Turno> turnosPorPreferencia(@RequestParam boolean preferente) {
        return turnoService.obtenerTurnosAbiertosPorPreferencia(preferente);
    }

    @PostMapping("/siguiente")
    public Turno siguienteTurno(@RequestParam Long categoriaId, @RequestParam boolean preferente) {
        return turnoService.avanzarSiguienteTurno(categoriaId, preferente);
    }

    @GetMapping("/conteo")
    public Map<String, Long> conteoPorCategoria() {
        return turnoService.contarTurnosPorCategoria();
    }

    @GetMapping("/ultimos")
    public List<Turno> ultimosTurnos(@RequestParam(defaultValue = "5") int limite) {
        return turnoService.obtenerUltimosTurnosAtendidos(limite);
    }
}

