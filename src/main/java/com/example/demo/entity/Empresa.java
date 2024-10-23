package com.example.demo.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Data
@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmpresa")
    @SequenceGenerator(name = "seqEmpresa", allocationSize = 1, sequenceName = "SEQ_EMPRESA")
    
    private Long id;

    @NotNull @Column(name = "razon_social", length = 250)
    private String razonSocial;

    @NotNull @Column(name = "direccion", length = 100)
    private String direccion;

    @NotNull @Column(name = "ruc", length = 11)
    private String ruc;

    @NotNull @Column(name = "estado", length = 1)
    private String estado;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "empresa")
    @JsonIgnore
    private Set<Representante> representantes;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "empresa")
    @JsonIgnore
    private Set<PPP> practicas;
}
