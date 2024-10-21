package com.example.demo.service;

import java.util.List;
 

import com.example.demo.entity.Evidencia;


public interface EvidenciaService {
	Evidencia create(Evidencia c);
	Evidencia update(Evidencia c);
	void delete(Long id);
	Evidencia read(Long id);
	List<Evidencia> readAll();
}
