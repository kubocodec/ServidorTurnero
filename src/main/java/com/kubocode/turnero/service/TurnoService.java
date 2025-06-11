package com.kubocode.turnero.service;

import com.kubocode.turnero.model.Turno;
import com.kubocode.turnero.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private TurnoRepository turnoRepository;

    @Override
    public Turno guardarTurno(Turno turno) {
        turno.setEstado("abierto");
        turno.setFechaCreacion(LocalDateTime.now());
        return turnoRepository.save(turno);
    }

    @Override
    public List<Turno> obtenerTurnosAbiertosPorPreferencia(boolean preferente) {
        return turnoRepository.findByEstado("abierto")
                .stream()
                .filter(t -> Objects.equals(t.getPreferente(), preferente))
                .collect(Collectors.toList());
    }

    @Override
    public Turno avanzarSiguienteTurno(Long categoriaId, boolean preferente) {
        List<Turno> turnos = turnoRepository.findByCategoriaIdAndPreferenteAndEstadoOrderByFechaCreacionAsc(
                categoriaId, preferente, "abierto"
        );

        if (!turnos.isEmpty()) {
            Turno siguiente = turnos.get(0);
            siguiente.setEstado("en_atencion");
            return turnoRepository.save(siguiente);
        }
        return null;
    }

    @Override
    public Map<String, Long> contarTurnosPorCategoria() {
        List<Turno> turnos = turnoRepository.findByEstado("abierto");
        return turnos.stream()
                .collect(Collectors.groupingBy(t -> t.getCategoria().getNombre(), Collectors.counting()));
    }

    @Override
    public List<Turno> obtenerUltimosTurnosAtendidos(int limite) {
        return turnoRepository.findTop5ByEstadoOrderByFechaCreacionDesc("atendido");
    }
}
