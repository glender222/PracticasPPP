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
@Table(name = "rubros")
public class Rubros {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRubros")
    @SequenceGenerator(name = "seqRubros", allocationSize = 1, sequenceName = "SEQ_RUBROS")
    private Long id;


    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "rubros")
	@JsonIgnore
	private Set<Evidencia> evidencia;

    @Column(name = "nombre", length = 250)
    private String nombre;

    @Column(name = "porcentaje")
    private Integer porcentaje;
    @ManyToOne
    @JoinColumn(name = "idppp", nullable = false)
    @JsonIgnore
    private PPP practicas;
}
