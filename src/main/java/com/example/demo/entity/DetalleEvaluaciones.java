package com.example.demo.entity;

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
@Table(name = "detalle_evaluaciones")
public class DetalleEvaluaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idEvaluacion;

    @Column(name = "rubros")
    private int rubros;

    @Column(name = "nota_transversal")
    private int notaTransversal;
    
    @Column(name = "url")
    private int url;
    
    @Column(name = "estado")
    private int estado; 
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "detalleEvaluaciones")
	@JsonIgnore
	private Set<Evaluaciones> evaluaciones;
}
