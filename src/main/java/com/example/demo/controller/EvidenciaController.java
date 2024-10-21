package com.example.demo.controller;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Evidencia;
import com.example.demo.service.EvidenciaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/evidencias")
@CrossOrigin(origins = "http://localhost:4200/")
public class EvidenciaController {
	@Autowired
	private EvidenciaService evidenciaService;
	
	@GetMapping
	public ResponseEntity<List<Evidencia>> readAll(){
		try {
			List<Evidencia> Evidencias = evidenciaService.readAll();
			if(Evidencias.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Evidencias, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping
	public ResponseEntity<Evidencia> crear(@Valid @RequestBody Evidencia cat){
		try {
			Evidencia c = evidenciaService.create(cat);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Evidencia> getEvidenciaId(@PathVariable("id") Long id){
		try {
			Evidencia c = evidenciaService.read(id);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Evidencia> delEvidencia(@PathVariable("id") Long id){
		try {
			evidenciaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEvidencia(@PathVariable("id") Long id, @Valid @RequestBody Evidencia cat){

			Evidencia c = evidenciaService.read(id);
			if(c.getId()>0) {
				return new ResponseEntity<>(evidenciaService.update(cat), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}		
		
	}
}
