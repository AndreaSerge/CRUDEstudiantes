package com.example.services;

import java.util.List;
import com.example.entities.Estudiante;

public interface EstudianteService {

    // Método que me devuelve todos los estudiantes
    public List<Estudiante> dameTodosLosEstudiantes();

    // Método que me devuelve un estudiante por ID
    public Estudiante dameUnEstudiante(int idEstudiante);

    // Método que elimine un estudiante por ID y no devuelva nada
    public void eliminarEstudiante(int idEstudiante);

    // Método para guardar(persistir) un estudian
    public void persistirEstudiante(Estudiante estudiante);

    // Método para actualizar el estudiante
    public void actualizarEstudiante(Estudiante estudiante);

}
