package es.dsw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/roles")
public class RolController {

    @GetMapping("/nuevo")
    public String nuevoRol() {
        return "home";
    }

    @GetMapping("/listar")
    public String listarRoles() {
        return "home";
    }
}
