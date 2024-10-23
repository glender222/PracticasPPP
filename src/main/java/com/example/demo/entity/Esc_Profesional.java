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
@Table(name = "escuela_profesionales")
public class Esc_Profesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "carrera", length = 30)
    private String carrera;
    
    @ManyToOne
	@JoinColumn(name="id_facultad", nullable = false)
	private Facultad facultad;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "esc_Profesional")
	@JsonIgnore
	private Set<Directora> directoras;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "esc_Profesional")
	@JsonIgnore
	private Set<Tutores> tutores;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "esc_Profesional")
	@JsonIgnore
	private Set<Practicante_EP> practicante_EPs;
}
