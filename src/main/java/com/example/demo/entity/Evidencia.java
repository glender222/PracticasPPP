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
@Table(name = "evidencia")
public class Evidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evidencia")
    private Long id;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "evidencia")
	@JsonIgnore
	private Set<Programacion> programacion;
    @ManyToOne
    @JoinColumn(name = "id_rubro", nullable = false)
    @JsonIgnore
    private Rubros rubros;
    @Column(name = "peso")
    private Integer peso;

    @Column(name = "nota")
    private Integer nota;

    @Column(name = "recomendaciones", length = 2500)
    private String recomendaciones;
}
