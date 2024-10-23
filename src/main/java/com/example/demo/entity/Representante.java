package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
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
@Table(name = "representante")
public class Representante {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRepresentante")
    @SequenceGenerator(name = "seqRepresentante", allocationSize = 1, sequenceName = "SEQ_REPRESENTANTE")
    private Long id;

    @Column(name = "cargo", length = 215)
    private String cargo;

    @Column(name = "estado", length = 1)
    private String estado;

    @OneToOne
	@JoinColumn(name = "id_persona", referencedColumnName = "id", nullable = false)
	@JsonIgnore
	private Persona persona;

    @ManyToOne
    @JoinColumn(name ="id_empresa", referencedColumnName ="id", nullable = false)
    @JsonIgnore
    private Empresa empresa;
    
}
