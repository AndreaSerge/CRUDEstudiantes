package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Estudiante;
import com.example.entities.Telefono;

@Repository

public interface TelefonoDao extends JpaRepository<Telefono, Integer>{
   
    // Creo este método para buscar telefono por id del estudiante
    // Esto porque los necesito despues en telefonoServiceImpl
    List<Telefono> findByEstudiante(Estudiante estudiante);
    
    // Borrame por estudiante
    void deleteByEstudiante(Estudiante estudiante);

}
