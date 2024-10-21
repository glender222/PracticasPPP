package com.example.demo.daoImpl;


import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.EvidenciaDao;
import com.example.demo.entity.Evidencia;
import com.example.demo.repository.EvidenciaRepository;


@Component
public class EvidenciaDaoImpl implements EvidenciaDao {

	@Autowired
	private EvidenciaRepository evidenciaRepository;
	
	@Override
	public Evidencia create(Evidencia c) {
		// TODO Auto-generated method stub
		return evidenciaRepository.save(c);
	}

	@Override
	public Evidencia update(Evidencia c) {
		// TODO Auto-generated method stub
		return evidenciaRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		evidenciaRepository.deleteById(id);
	}

	@Override
	public Evidencia read(Long id) {
		// TODO Auto-generated method stub
		return evidenciaRepository.findById(id).get();
	}

	@Override
	public List<Evidencia> readAll() {
		// TODO Auto-generated method stub
		return evidenciaRepository.findAll();
	}

}

