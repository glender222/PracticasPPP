package com.example.demo.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "programacion")
public class Programacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprogramacion")
    private Long id;

    @Column(name = "semana")
    private Integer semana;

    @Column(name = "fecha_evaluacion")
    private Date fechaEvaluacion;

    @Column(name = "link", length = 250)
    private String link;
    @ManyToOne
    @JoinColumn(name = "id_evidencia", nullable = false)
    @JsonIgnore
    private Evidencia evidencia;
}
