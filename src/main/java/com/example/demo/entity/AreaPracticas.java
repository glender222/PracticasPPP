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
@Table(name = "area_practicas")
public class AreaPracticas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    private Long id;

    @Column(name = "nombre", length = 320)
    private String nombre;

    @Column(name = "descripcion", length = 320)
    private String descripcion;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "area_practicas")
	@JsonIgnore
	private Set<PPP> practicas;
}
