package com.example.demo.dao;

import java.util.List;


import com.example.demo.entity.Evidencia;


public interface EvidenciaDao {
	Evidencia create(Evidencia c);
	Evidencia update(Evidencia c);
	void delete(Long id);
	Evidencia read(Long id);
	List<Evidencia> readAll();
}
