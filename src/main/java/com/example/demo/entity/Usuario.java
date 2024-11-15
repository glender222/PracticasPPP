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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Data
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUsuarios")
    @SequenceGenerator(name = "seqUsuarios", allocationSize = 1, sequenceName = "SEQ_USUARIOS")
    private Long id;

    @Column(name = "usuario", length = 50)
    private String usuario;

    @Column(name = "password", length = 150)
    private String clave;

    @Column(name = "estado", length = 150)
    private String estado;
    
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
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "usuario")
   	@JsonIgnore
   	private Set<Log> logs;
}
