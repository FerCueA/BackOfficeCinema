package es.dsw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    @GetMapping("/nueva")
    public String nuevaPelicula() {
        return "home";
    }

    @GetMapping("/listar")
    public String listarPeliculas() {
        return "home";
    }
}
