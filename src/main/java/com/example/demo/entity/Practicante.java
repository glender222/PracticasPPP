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
@Table(name = "practicantes")
public class Practicante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo", length = 100)
    private String codigo;

    @Column(name = "año_estudio", length = 10)
    private String añoEstudio;
	
    @OneToOne
	@JoinColumn(name = "idpersona", referencedColumnName = "id", nullable = false)
    @JsonIgnore
	private Persona persona;
	 @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "practicante")
		@JsonIgnore
		private Set<Practicante_EP> practicante_EP;
}
