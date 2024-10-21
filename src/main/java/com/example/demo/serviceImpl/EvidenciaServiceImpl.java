package com.example.demo.serviceImpl;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EvidenciaDao;
import com.example.demo.entity.Evidencia;
import com.example.demo.service.EvidenciaService;


@Service
public class EvidenciaServiceImpl implements EvidenciaService {

	@Autowired
	private EvidenciaDao dao;
	
	@Override
	public Evidencia create(Evidencia c) {
		// TODO Auto-generated method stub
		return dao.create(c);
	}

	@Override
	public Evidencia update(Evidencia c) {
		// TODO Auto-generated method stub
		return dao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Evidencia read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Evidencia> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
