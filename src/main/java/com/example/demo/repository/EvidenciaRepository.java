package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Evidencia;

@Repository
public interface EvidenciaRepository extends JpaRepository<Evidencia, Long>{

}
