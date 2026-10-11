package com.jfservices.jfservices_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer estrelas;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "prestador_id")
    private Prestador prestador;

    public Avaliacao() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getEstrelas() { return estrelas; }
    public void setEstrelas(Integer estrelas) { this.estrelas = estrelas; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public Prestador getPrestador() { return prestador; }
    public void setPrestador(Prestador prestador) { this.prestador = prestador; }
}
