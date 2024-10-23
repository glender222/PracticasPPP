package com.example.demo.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Data
@Table(name = "practicantes")
public class Practicante {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPracticante")
    @SequenceGenerator(name = "seqPracticante", allocationSize = 1, sequenceName = "SEQ_PRACTICANTE")
    private Long id;

    @Column(name = "codigo", length = 100)
    private String codigo;

    @Column(name = "año_estudio", length = 10)
    private String añoEstudio;
	
    @OneToOne
	@JoinColumn(name = "id_persona", referencedColumnName = "id", nullable = false)
    @JsonIgnore
	private Persona persona;
	 @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "practicante")
		@JsonIgnore
		private Set<Practicante_EP> practicante_EP;
}
