package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Curso;

@Repository // hay bean
public interface CursoDao extends JpaRepository<Curso,Integer> {

}
