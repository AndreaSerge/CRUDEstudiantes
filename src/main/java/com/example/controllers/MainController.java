package com.example.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entities.Correo;
import com.example.entities.Estudiante;
import com.example.entities.Telefono;
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

    // Cuando se recibe un parametro conjuntamente con la request
    // En la forma nueva, tengo un numero que guardaré en la URL
    @GetMapping("/detalles/{id}")
    public String detallesEstudiante(
        @PathVariable(name= "id") int idEstudiante, Model model) {
        LOG.info("ID Estudiante Recibido" + idEstudiante);
        model.addAttribute("estudiante",
            estudianteService.dameUnEstudiante(idEstudiante));
        return "views/estudianteDetalles";
    }

    @GetMapping("/frmAltaModificacion")
    public String formularioAltaModificacionEstudiante(Model model) {

    //Le paso al modelo un obejto vacio
    Estudiante estudiante = new Estudiante();

    model.addAttribute("estudiante", estudiante);

    //También para los cursos
    model.addAttribute("cursos",
        cursoService.dameLosCursos());
    
    return "views/frmAltaModificacionEstudiante";
    }

    @PostMapping("/persistir")
    @Transactional // todas las que necesitan modificación en la base de datos, es el autocommit
    public String persistirEstudiante(@ModelAttribute(name="estudiante") Estudiante estudiante,
    @RequestParam(name ="numerosTel", required = false) String telefonosRecibidos,
    @RequestParam(name = "direccionesCorreo", required = false) String correosRecibidos) {

        // Procesar los telefonos
        if(telefonosRecibidos != null) {
            String[] arrayTelefonos = telefonosRecibidos.split(";");
            List<String> numerosTelefonos = Arrays.asList(arrayTelefonos);

            List<Telefono> telefonos = new ArrayList<>();

            numerosTelefonos.stream()
                .forEach(numeroTelefono -> {
                    telefonos.add(
                    Telefono.builder()
                    .telefono(numeroTelefono)
                    .estudiante(estudiante)
                    .build());
                });
                estudiante.setTelefonos(telefonos);
        }

        // Procesar los correos
        if(correosRecibidos != null) {
            String[] arrayCorreos = correosRecibidos.split(";");
            List<String> direccionesDeCorreo = Arrays.asList(arrayCorreos);

            List<Correo> correos = new ArrayList<>();

            direccionesDeCorreo.stream()
                .forEach(direccionDeCorreo -> {
                    correos.add(Correo.builder()
                    .correo(direccionDeCorreo)
                    .estudiante(estudiante)
                    .build());
                });
                estudiante.setCorreos(correos);
        }

        estudianteService.persistirEstudiante(estudiante);

       return "redirect:/all";
    }



}
