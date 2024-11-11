package com.example.demo.entity;

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
@Table(name = "logs")
public class Log {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLinea")
    @SequenceGenerator(name = "seqLinea", allocationSize = 1, sequenceName = "SEQ_LINEA")
    
    private Long id;

    @Column(name = "nombre", length = 250)
    private String nombre;

    @Column(name = "estado", length = 1)
    private String estado;
    
    @ManyToOne
	@JoinColumn(name="id_usuario", nullable = false)
	@JsonIgnore
	private Usuario usuario;
}

