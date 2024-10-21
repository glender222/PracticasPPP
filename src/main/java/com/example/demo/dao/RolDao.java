package com.example.demo.dao;

import java.util.List;


import com.example.demo.entity.Rol;


public interface RolDao {
	Rol create(Rol c);
	Rol update(Rol c);
	void delete(Long id);
	Rol read(Long id);
	List<Rol> readAll();
}