package es.dsw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping("/nuevo")
    public String nuevoUsuario() {
        return "home";
    }

    @GetMapping("/listar")
    public String listarUsuarios() {
        return "home";
    }
}
