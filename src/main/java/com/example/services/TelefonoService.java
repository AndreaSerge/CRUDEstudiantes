package com.example.services;

import java.util.List;

import com.example.entities.Telefono;

public interface TelefonoService {

      // Método que me devuelve todos los télefonos
    public List<Telefono> telefonos(int idEstudiante);

    // Método que borre los télefonos correspondientes a un estudiante
    public void eliminarTelefonos(int idEstudiante);

    // Método que guarde(persistir) télefono. Necesita el estudiante para el que quiero persistir
    public void persistirTelefono(int idEstudiante, Telefono telefono);


}
