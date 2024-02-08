package com.example;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Curso;
import com.example.entities.Estudiante;
import com.example.entities.Genero;
import com.example.entities.Horario;
import com.example.entities.Telefono;
import com.example.services.CorreoService;
import com.example.services.CursoService;
import com.example.services.EstudianteService;
import com.example.services.TelefonoService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class CrudEstudiantesApplication implements CommandLineRunner {

	private final EstudianteService estudianteService;
	private final CursoService cursoService;
	private final TelefonoService telefonoService;
	private final CorreoService correoService;

	public static void main(String[] args) {
		SpringApplication.run(CrudEstudiantesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Primero: creamos los cursos
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

		cursoService.persistirCurso(curso1);
		cursoService.persistirCurso(curso2);
		cursoService.persistirCurso(curso3);

		Estudiante est1 = Estudiante.builder()
				.nombre("E1")
				.apellidos("AE1")
				.genero(Genero.HOMBRE)
				.fechaMatricula(LocalDate.of(2000, Month.JANUARY, 12))
				.asignaturasMatriculadas(2)
				.foto(null)
				.build();


		Estudiante est2 = Estudiante.builder()
				.nombre("E2")
				.apellidos("AE2")
				.genero(Genero.MUJER)
				.fechaMatricula(LocalDate.of(2000, Month.APRIL, 12))
				.asignaturasMatriculadas(4)
				.foto(null)
				.build();

		Estudiante est3 = Estudiante.builder()
				.nombre("E3")
				.apellidos("AE3")
				.genero(Genero.OTRO)
				.fechaMatricula(LocalDate.of(1900, Month.MARCH, 12))
				.asignaturasMatriculadas(2)
				.foto(null)
				.build();

		estudianteService.persistirEstudiante(est1);
		estudianteService.persistirEstudiante(est2);
		estudianteService.persistirEstudiante(est3);


		//telefonos
		Telefono telefono1Est1= Telefono.builder()
				.telefono("675458")
				.estudiante(estudianteService.dameUnEstudiante(1))
				.build();

		Telefono telefono2Est1= Telefono.builder()
				.telefono("5458")
				.estudiante(estudianteService.dameUnEstudiante(1))
				.build();

		Telefono telefono3Est1= Telefono.builder()
				.telefono("68888")
				.estudiante(estudianteService.dameUnEstudiante(1))
				.build();
		
		telefonoService.persistirTelefono(1, telefono1Est1);
		telefonoService.persistirTelefono(1, telefono2Est1);
		telefonoService.persistirTelefono(1, telefono3Est1);


	}


}