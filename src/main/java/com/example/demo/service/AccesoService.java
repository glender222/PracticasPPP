package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Acceso;



public interface AccesoService {
	Acceso create(Acceso c);
	Acceso update(Acceso c);
	void delete(Long id);
	Acceso read(Long id);
	List<Acceso> readAll();
}
