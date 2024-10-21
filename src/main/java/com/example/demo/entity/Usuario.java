package com.example.demo.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "usuario", length = 50)
    private String usuario;

    @Column(name = "clave", length = 150)
    private String clave;

    @Column(name = "codigo_recuperacion", length = 150)
    private String codigoRecuperacion;
    
    @ManyToMany
	@JoinTable(
			name="Usuario.rol",
			joinColumns = @JoinColumn(name="id_usuario", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="id_rol", referencedColumnName = "id")
			)
    @JsonIgnore
	private Set<Rol> roles;
    
    @OneToOne
	@JoinColumn(name = "idpersona", referencedColumnName = "id", nullable = false)
    @JsonIgnore
	private Persona persona;
}