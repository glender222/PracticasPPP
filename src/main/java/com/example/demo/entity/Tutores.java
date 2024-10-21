package com.example.demo.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tutores")
public class Tutores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "idpersona", referencedColumnName = "id", nullable = false)
	@JsonIgnore
	private Persona persona;


	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_linea", referencedColumnName = "id")
	@JsonIgnore
	private Linea linea;
	
	@ManyToOne
	@JoinColumn(name="id_EP", nullable = false)
	@JsonIgnore
	private EscuelaProfesional escuelaProfesional;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "tutores")
   	@JsonIgnore
   	private Set<PPP> practicas;
}

