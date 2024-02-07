package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Estudiante;

// interface generica <para quien quiere generar esos, tipo de dato objeto>
// objeto porque (la genericidad no trabaja con datos primitivos)

@Repository // indica donde se va a crear el bean Para todas las entidades que yo le indique. Genera todo el DAO para la clase Estudiante
public interface EstudianteDao extends JpaRepository<Estudiante, Integer> {

    List<Estudiante> findByNombre(String nombre);
}
