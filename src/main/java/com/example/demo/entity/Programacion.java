package com.example.demo.entity;

import java.util.Date;
import java.util.Set;

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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProgramacion")
    @SequenceGenerator(name = "seqProgramacion", allocationSize = 1, sequenceName = "SEQ_PROGRAMACION")
    private Long id;

    @Column(name = "semana")
    private Integer semana;

    @Column(name = "fecha_evaluacion")
    private Date fechaEvaluacion;

    @Column(name = "link", length = 250)
    private String link;


    // se tiene que borrar por que tiene un enlaze con evidencia
    // cosa que esta incorrecto 
  

    // tenemos que crear programacion con rubro uno a muchos

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "programacion")
	@JsonIgnore
	private Set<Rubros> rubros;






    // se tiene que crear ppp a programacion se recepciona

    @ManyToOne
    @JoinColumn(name = "idppp", nullable = false)
    @JsonIgnore
    private PPP ppp;




}
