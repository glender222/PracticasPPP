package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Usuario;


public interface UsuarioService {
	Usuario create(Usuario c);
	Usuario update(Usuario c);
	void delete(Long id);
	Usuario read(Long id);
	List<Usuario> readAll();
}