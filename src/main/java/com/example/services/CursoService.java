package com.example.services;

import java.util.List;

import com.example.entities.Curso;
import com.example.entities.Estudiante;

public interface CursoService {
      // Método que me devuelve una lista de cursos
      public List<Curso> dameLosCursos();

      // Método que da un departamento según el id del estudiante
      public Curso dameUnCurso(int idEstudiante);
  
      //Método que guarda un curso
      public void persistirCurso(Estudiante estudiante);
  
}
