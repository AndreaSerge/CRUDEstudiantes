package com.example.services;

import java.util.List;

import com.example.entities.Curso;
import com.example.entities.Estudiante;
import com.example.entities.Horario;

public interface CursoService {
      // Método que me devuelve una lista de cursos
      public List<Curso> dameLosCursos();

      // Método que da un departamento según el id del estudiante
      public Curso dameUnCurso(int idCurso);
  
      //Método que guarda un curso
      public void persistirCurso(Curso curso);

      // Método que da estudiante por horario
      public List<Estudiante> dameEstudiantesPorHorario(Horario horario);
  
}
