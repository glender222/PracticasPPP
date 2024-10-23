package com.example.demo.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "facultad")
public class Facultad {

    @Id
    @Column(name = "id_facultad")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFacultad")
    @SequenceGenerator(name = "seqFacultad", allocationSize = 1, sequenceName = "SEQ_FACULTAD")
    
    private Long id;

    @Column(name = "facultad", length = 250)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_campus", nullable = false)
    @JsonIgnore
    private Campus campus;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "facultad")
    @JsonIgnore
    private Set<EscuelaProfesional> escuelas;
}
