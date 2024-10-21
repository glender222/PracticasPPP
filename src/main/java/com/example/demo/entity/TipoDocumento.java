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
@Table(name = "tipo_documento")
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento")
    private Long id;

    @Column(name = "nombre_doc", length = 320)
    private String nombreDoc;

    @Column(name = "estado", length = 1)
    private String estado;

    @Column(name = "plantilla", length = 120)
    private String plantilla;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "tipo_documento")
	@JsonIgnore
	private Set<Documentacion> documentacion;
}
