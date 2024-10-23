package com.example.demo.entity;


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
@Table(name = "rubros")
public class Rubros {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRubros")
    @SequenceGenerator(name = "seqRubros", allocationSize = 1, sequenceName = "SEQ_RUBROS")
    private Long id;


    @Column(name = "nota")
    private Integer nota;
    

    @ManyToOne
    @JoinColumn(name = "programacion_id", nullable = false)
    @JsonIgnore
    private Programacion programacion;


    @ManyToOne
    @JoinColumn(name = "tipo_id", nullable = false)
    @JsonIgnore
    private Tipo tipo;


}
