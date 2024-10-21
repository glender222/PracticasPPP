package com.example.demo.service;

import java.util.List;
 

import com.example.demo.entity.Rol;


public interface RolService {
	Rol create(Rol c);
	Rol update(Rol c);
	void delete(Long id);
	Rol read(Long id);
	List<Rol> readAll();
}