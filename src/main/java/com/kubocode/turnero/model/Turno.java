package com.kubocode.turnero.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Turno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    private String estado; // "abierto", "atendido"

    private Boolean preferente;

    private LocalDateTime fechaCreacion;

    private Integer puesto;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario atendidoPor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getPreferente() {
        return preferente;
    }

    public void setPreferente(Boolean preferente) {
        this.preferente = preferente;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getPuesto() {
        return puesto;
    }

    public void setPuesto(Integer puesto) {
        this.puesto = puesto;
    }

    public Usuario getAtendidoPor() {
        return atendidoPor;
    }

    public void setAtendidoPor(Usuario atendidoPor) {
        this.atendidoPor = atendidoPor;
    }

    public Turno(Long id, String numero, Categoria categoria, String estado, Boolean preferente, LocalDateTime fechaCreacion, Integer puesto, Usuario atendidoPor) {
        this.id = id;
        this.numero = numero;
        this.categoria = categoria;
        this.estado = estado;
        this.preferente = preferente;
        this.fechaCreacion = fechaCreacion;
        this.puesto = puesto;
        this.atendidoPor = atendidoPor;
    }

    public Turno() {
    }
}


