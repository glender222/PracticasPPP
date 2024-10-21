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
@Table(name = "accesos")
public class Acceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="titulo")
	private String titulo;
	@Column(name="icono")
	private String icono;
	@Column(name="link")
	private String link;
	@Column(name="estado",length = 1)
	private char estado;
    
    @ManyToMany
	@JoinTable(
			name="Rol_Acceso",
			joinColumns = @JoinColumn(name="id_acceso", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="id_rol", referencedColumnName = "id")
			)
    @JsonIgnore
	private Set<Rol> roles;
}
