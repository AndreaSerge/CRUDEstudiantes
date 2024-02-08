package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Curso;
import com.example.entities.Horario;

@Repository // hay bean
public interface CursoDao extends JpaRepository<Curso,Integer> {

    List<Curso> findByHorario(Horario horario);
}
