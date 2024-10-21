package com.example.demo.entity;

import java.util.Date;

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
@Table(name = "documentacion")
public class Documentacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documentacion")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", nullable = false)
    @JsonIgnore
    private TipoDocumento tipo_documento;
    @ManyToOne
    @JoinColumn(name = "idppp", nullable = false)
    @JsonIgnore
    private PPP practicas;
    @Column(name = "url", length = 2500)
    private String url;

    @Column(name = "estado", length = 1)
    private String estado;

    @Column(name = "fecha_generada")
    private Date fechaGenerada;
}
