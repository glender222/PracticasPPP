package com.example.demo.entity;

import java.util.Set;

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
@Table(name = "evidencia")
public class Evidencia {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEvidencia")
    @SequenceGenerator(name = "seqEvidencia", allocationSize = 1, sequenceName = "SEQ_EVIDENCIA")
    private Long id;





    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "evidencia")
	@JsonIgnore
	private Set<Programacion> programacion;
    @ManyToOne
    @JoinColumn(name = "id_rubro", nullable = false)
    @JsonIgnore
    private Rubros rubros;
    @Column(name = "peso")
    private Integer peso;

    @Column(name = "nota")
    private Integer nota;

    @Column(name = "recomendaciones", length = 2500)
    private String recomendaciones;
}
