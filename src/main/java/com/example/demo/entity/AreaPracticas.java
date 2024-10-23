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
@Table(name = "area_practicas")
public class AreaPracticas {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAreaPracticas")
    @SequenceGenerator(name = "seqAreaPracticas", allocationSize = 1, sequenceName = "SEQ_AREA_PRACTICAS")
    private Long id;

    @Column(name = "nombre", length = 320)
    private String nombre;

    @Column(name = "descripcion", length = 320)
    private String descripcion;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "area_practicas")
	@JsonIgnore
	private Set<PPP> practicas;
}
