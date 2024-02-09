package com.example.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // convierte la clase en una entidad de Hibernate
@Table(name= "estudiantes") // anotación para crear una tabla
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
// Serializable convertir de objeto a un flujo
public class Estudiante implements Serializable {

     private static final long serialVersionUID = 1L; // el serializado

    @Id // es la primaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Hago que el ID sea autoincremental
    private int id;

    private String nombre;
    private String apellidos;

    // Como quiero que guarde los campos de tipo enum: llamar en String
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // campos de tipo LocalDate
    private LocalDate fechaMatricula;
    
    private int asignaturasMatriculadas;
    private String foto;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "estudiante")
    private List<Correo> correos;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "estudiante")
    private List<Telefono> telefonos;

    // estudiante tiene un curso. Relacion Estudiante-Curso
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Curso curso;
}
