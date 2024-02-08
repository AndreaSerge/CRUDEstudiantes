package com.example.controllers;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.services.CursoService;
import com.example.services.EstudianteService;

import lombok.RequiredArgsConstructor;

@Controller // Para que está clase sepa que es un controller
@RequestMapping("/") // Recibe peticiones que acaben en /
@RequiredArgsConstructor
public class MainController {

    // Inyectar las dependencias
    private final EstudianteService estudianteService;
    private final CursoService cursoService;
    private final Logger LOG = Logger.getLogger("MainController");

    // Método que va a devolver en la vista todos los empleados en una tabla
    // Construir ensamblar la vista: renderizar
    // Este método se corresponde con el ModelAndView del diagrama de Spring MVC
    // A este método le vamos a enviar una petición por GET (hacer una petición http por la URL)
    // Eso llega al servidor que se está ejecutando en el puerto ejecutandose por GET
    // Lo espero también por GET, usando @GetMapping, que debe indicar como termina
    // URL: http//blablabla/all

      @GetMapping("/all")
    public String dameEstudiantes(Model model){
        model.addAttribute("estudiantes",
        estudianteService.dameTodosLosEstudiantes());
        return "views/listadoEstudiantes";
    }

}
