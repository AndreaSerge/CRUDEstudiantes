package com.example;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Correo;
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

		cursoService.persistirCurso(curso1);
		cursoService.persistirCurso(curso2);
		cursoService.persistirCurso(curso3);

		// Add estudiantes
		Estudiante est1 = Estudiante.builder()
				.nombre("Estudiante1")
				.apellidos("Apellido1")
				.genero(Genero.HOMBRE)
				.fechaMatricula(LocalDate.of(2000, Month.JANUARY, 12))
				.asignaturasMatriculadas(2)
				.foto(null)
				.curso(cursoService.dameUnCurso(1))
				.build();

		Estudiante est2 = Estudiante.builder()
				.nombre("Estudiante2")
				.apellidos("Apellido2")
				.genero(Genero.MUJER)
				.fechaMatricula(LocalDate.of(2000, Month.APRIL, 12))
				.asignaturasMatriculadas(4)
				.foto(null)
				.curso(cursoService.dameUnCurso(2))
				.build();

		Estudiante est3 = Estudiante.builder()
				.nombre("Estudiante3")
				.apellidos("Apellido3")
				.genero(Genero.OTRO)
				.fechaMatricula(LocalDate.of(1900, Month.MARCH, 12))
				.asignaturasMatriculadas(2)
				.foto(null)
				.curso(cursoService.dameUnCurso(3))
				.build();

		estudianteService.persistirEstudiante(est1);
		estudianteService.persistirEstudiante(est2);
		estudianteService.persistirEstudiante(est3);


		// Add telefonos
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

		Telefono telefono1Est2= Telefono.builder()
				.telefono("675458")
				.estudiante(estudianteService.dameUnEstudiante(2))
				.build();

		telefonoService.persistirTelefono(2, telefono1Est2);

		Telefono telefono1Est3= Telefono.builder()
				.telefono("999999958")
				.estudiante(estudianteService.dameUnEstudiante(3))
				.build();
		
		Telefono telefono2Est3= Telefono.builder()
				.telefono("22222229958")
				.estudiante(estudianteService.dameUnEstudiante(3))
				.build();

		telefonoService.persistirTelefono(3, telefono1Est3);
		telefonoService.persistirTelefono(3, telefono2Est3);

		
		// Add correos
		Correo correo1Est1 = Correo.builder()
				.correo("andrea@serge.com")
				.build();

		correoService.persistirCorreo(1, correo1Est1);

		Correo correo1Est2 = Correo.builder()
				.correo("jjjjj@serge.com")
				.build();

		Correo correo2Est2 = Correo.builder()
				.correo("ggggg@serge.com")
				.build();
		
		correoService.persistirCorreo(2, correo1Est2);
		correoService.persistirCorreo(2, correo2Est2);

	}


}