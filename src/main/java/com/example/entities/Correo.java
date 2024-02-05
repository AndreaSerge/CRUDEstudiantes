package com.example.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Le indico que es una entidad
@Table(name = "correos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Correo implements Serializable {
    
    private static final long serialVersionUID = 1L; // el serializado

    @Id // la PrimaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String correo;

    // Cada estudiante va a tener muchos telefonos
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Estudiante estudiante; // genera la relación, crea un campo para relacionar las dos tablas

}
