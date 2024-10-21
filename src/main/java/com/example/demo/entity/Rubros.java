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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rubro")
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
