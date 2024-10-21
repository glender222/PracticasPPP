package com.example.demo.entity;

import java.util.Date;
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
@Table(name = "practicas")
public class PPP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idppp")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    @JsonIgnore
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name = "id_areap", nullable = true)
    @JsonIgnore
    private AreaPracticas area_practicas;
   
    @ManyToOne
    @JoinColumn(name = "idtutor", nullable = true)
    @JsonIgnore
    private Tutores tutores;
    @Column(name = "horas")
    private Integer horas;

    @ManyToOne
    @JoinColumn(name = "id_practicante_EP", nullable = false)
    @JsonIgnore
    private Practicante_EP practicante_EP;
    
    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Column(name = "modalidad", length = 215)
    private String modalidad;
    
    @ManyToOne
    @JoinColumn(name = "idlinea", nullable = true)
    @JsonIgnore
    private Linea linea;

    @Column(name = "estado", length = 1)
    private String estado;
    @ManyToOne
    @JoinColumn(name = "idpersona_supervisor", referencedColumnName = "id", nullable = true)
    @JsonIgnore
    private Persona persona;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "practicas")
	@JsonIgnore
	private Set<Rubros> rubros;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "practicas")
	@JsonIgnore
	private Set<Documentacion> documentacion;
}
