package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "directoras")
public class Directora {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "Firma")
	private String Firma;
	
	@Column(name = "Sello")
	private String Sello;
	
	@ManyToOne
	@JoinColumn(name="id_EP", referencedColumnName = "id", nullable = false)
	@JsonIgnore
	private EscuelaProfesional escuelaProfesional;
	
	@OneToOne
	@JoinColumn(name = "idpersona", referencedColumnName = "id", nullable = false)
	@JsonIgnore
	private Persona persona;


}

