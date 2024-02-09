package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Correo;
import com.example.entities.Curso;
import com.example.entities.Estudiante;
import com.example.entities.Genero;
import com.example.entities.Horario;
import com.example.entities.Telefono;
import com.example.services.EstudianteService;


import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class CrudEstudiantesApplication implements CommandLineRunner {

	private final EstudianteService estudianteService;

	public static void main(String[] args) {
		SpringApplication.run(CrudEstudiantesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Add cursos
		Curso curso1 = Curso.builder()
				.descripcion("Matemáticas")
				.horario(Horario.DIURNO)
				.build();

		Curso curso2 = Curso.builder()
				.descripcion("Inglés")
				.horario(Horario.NOCTURNO)
				.build();

		Curso curso3 = Curso.builder()
				.descripcion("Artes")
				.horario(Horario.DIURNO)
				.build();

		// Add estudiantes
		Estudiante est1 = Estudiante.builder()
				.nombre("Estudiante1")
				.apellidos("Apellido1")
				.genero(Genero.HOMBRE)
				.fechaMatricula(LocalDate.of(2000, Month.JANUARY, 12))
				.asignaturasMatriculadas(2)
				.foto(null)
				.curso(curso1)
				.build();

		Estudiante est2 = Estudiante.builder()
				.nombre("Estudiante2")
				.apellidos("Apellido2")
				.genero(Genero.MUJER)
				.fechaMatricula(LocalDate.of(2000, Month.APRIL, 12))
				.asignaturasMatriculadas(4)
				.foto(null)
				.curso(curso2)
				.build();

		Estudiante est3 = Estudiante.builder()
				.nombre("Estudiante3")
				.apellidos("Apellido3")
				.genero(Genero.OTRO)
				.fechaMatricula(LocalDate.of(1900, Month.MARCH, 12))
				.asignaturasMatriculadas(2)
				.foto(null)
				.curso(curso3)
				.build();

		// Add telefonos
		List<Telefono> telefonosEstudiante1 = new ArrayList<>(); 
		
		Telefono telefono1Est1= Telefono.builder()
				.telefono("675458")
				.estudiante(est1)
				.build();

		Telefono telefono2Est1= Telefono.builder()
				.telefono("5458")
				.estudiante(est1)
				.build();

		Telefono telefono3Est1= Telefono.builder()
				.telefono("68888")
				.estudiante(est1)
				.build();
		
		telefonosEstudiante1.add(telefono1Est1);
		telefonosEstudiante1.add(telefono2Est1);
		telefonosEstudiante1.add(telefono3Est1);	
		est1.setTelefonos(telefonosEstudiante1);

		List<Telefono> telefonosEstudiante2 = new ArrayList<>(); 

		Telefono telefono1Est2= Telefono.builder()
				.telefono("675458")
				.estudiante(est2)
				.build();

		telefonosEstudiante2.add(telefono1Est2);	
		est2.setTelefonos(telefonosEstudiante2);

		List<Telefono> telefonosEstudiante3 = new ArrayList<>(); 

		Telefono telefono1Est3= Telefono.builder()
				.telefono("999999958")
				.estudiante(est3)
				.build();
		
		Telefono telefono2Est3= Telefono.builder()
				.telefono("22222229958")
				.estudiante(est3)
				.build();

		telefonosEstudiante3.add(telefono1Est3);
		telefonosEstudiante3.add(telefono2Est3);	
		est3.setTelefonos(telefonosEstudiante3);
		
		// Add correos
		
		List<Correo> correosEstudiante1 = new ArrayList<>(); 

		Correo correo1Est1 = Correo.builder()
				.correo("andrea@serge.com")
				.estudiante(est1)
				.build();

		correosEstudiante1.add(correo1Est1);	
		est1.setCorreos(correosEstudiante1);

		List<Correo> correosEstudiante2 = new ArrayList<>(); 

		Correo correo1Est2 = Correo.builder()
				.correo("jjjjj@serge.com")
				.estudiante(est2)
				.build();

		Correo correo2Est2 = Correo.builder()
				.correo("ggggg@serge.com")
				.estudiante(est2)
				.build();
		
		correosEstudiante2.add(correo1Est2);	
		correosEstudiante2.add(correo2Est2);	
		est2.setCorreos(correosEstudiante2);

		List<Correo> correosEstudiante3 = new ArrayList<>(); 

		Correo correo1Est3 = Correo.builder()
				.correo("hhhhhhhhhj@serge.com")
				.estudiante(est3)
				.build();

		Correo correo2Est3 = Correo.builder()
				.correo("ddddddddd@serge.com")
				.estudiante(est3)
				.build();
		
		correosEstudiante3.add(correo1Est3);	
		correosEstudiante3.add(correo2Est3);	
		est3.setCorreos(correosEstudiante3);

		estudianteService.persistirEstudiante(est1);
		estudianteService.persistirEstudiante(est2);
		estudianteService.persistirEstudiante(est3);

	}


}