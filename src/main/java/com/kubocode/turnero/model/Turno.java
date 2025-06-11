package com.kubocode.turnero.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Turno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    private String estado; // "abierto", "en_atencion", "atendido"

    private Boolean preferente;

    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario atendidoPor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getAtendidoPor() {
        return atendidoPor;
    }

    public void setAtendidoPor(Usuario atendidoPor) {
        this.atendidoPor = atendidoPor;
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

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Boolean getPreferente() {
        return preferente;
    }

    public void setPreferente(Boolean preferente) {
        this.preferente = preferente;
    }

    public Turno() {
    }

    public Turno(Long id, Usuario atendidoPor, Categoria categoria, String estado, LocalDateTime fechaCreacion, Integer numero, Boolean preferente) {
        this.id = id;
        this.atendidoPor = atendidoPor;
        this.categoria = categoria;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.numero = numero;
        this.preferente = preferente;
    }
}


