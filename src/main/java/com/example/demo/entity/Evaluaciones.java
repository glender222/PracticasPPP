package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "evaluaciones")
public class Evaluaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nota_empresarial")
    private int notaEmpresarial;

    @Column(name = "nota_tutor")
    private int notaTutor;

    @Column(name = "recomendaciones")
    private String recomendaciones;
    
    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_evaluacion")
    private Date fechaEvaluacion;

    @ManyToOne
	@JoinColumn(name="id_detalleEvaluacion", nullable = false)
	private DetalleEvaluaciones detalleEvaluaciones ;
    
    @ManyToOne
	@JoinColumn(name="id_PPP", nullable = false)
	private PPP ppp ;
}
