package com.example.demo.entity;

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
@Table(name = "representante")
public class Representante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrep")
    private Long id;

    @Column(name = "cargo", length = 215)
    private String cargo;

    @Column(name = "estado", length = 1)
    private String estado;

    @OneToOne
	@JoinColumn(name = "idpersona", referencedColumnName = "id", nullable = false)
	@JsonIgnore
	private Persona persona;

    @ManyToOne
    @JoinColumn(name ="id_empresa", referencedColumnName ="id", nullable = false)
    @JsonIgnore
    private Empresa empresa;
    
}
