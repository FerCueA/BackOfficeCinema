package es.dsw.controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import es.dsw.dao.RolDAO;
import es.dsw.dao.UsuarioDAO;
import es.dsw.models.Usuario;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login(
            @CookieValue(value = "ultimoAcceso", defaultValue = "") String ultimoAcceso, Model objModel) {

        if (!ultimoAcceso.isEmpty()) {
            objModel.addAttribute("ultimoAcceso", ultimoAcceso);
        } else {
            objModel.addAttribute("ultimoAcceso", "Es tu primera vez por aquí");
        }
        return "login";
    }

    @GetMapping("/home")
    public String index(HttpServletResponse response, Authentication objAuthentication, Model objModel) {

        // Cookie con el último acceso con tiempo actual
        LocalDateTime objTiempo = LocalDateTime.now();
        DateTimeFormatter objFormato = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH:mm:ss");
        String tiempoFormateado = objTiempo.format(objFormato);

        Cookie objCookie = new Cookie("ultimoAcceso", tiempoFormateado);
        // Establecer la cookie para que dure 7 días , podemos ponerlo como multiplicacion o el total en seundos
        objCookie.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(objCookie);

        // Cargar datos del usuario
        String username = objAuthentication.getName();

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.getUsuarioByUsername(username);

            if (usuario != null) {
                objModel.addAttribute("nombre", usuario.getName());
                objModel.addAttribute("primerApellido", usuario.getFirstSurname());
                objModel.addAttribute("segundoApellido", usuario.getSecondSurname() != null ? usuario.getSecondSurname() : "");
                objModel.addAttribute("username", usuario.getUsername());

                // Obtener los roles del usuario
                RolDAO rolDAO = new RolDAO();
                // si un unsuario tiene varios tipos de roles, tengo que agregarlos en un arraylist de String
                ArrayList<String> todosLosRoles = rolDAO.obtenerRolByUserId(usuario.getIdUser());
                // luego serpado por comas los roles de dicho usuario
                String rolesSeparados = String.join(", ", todosLosRoles);

                objModel.addAttribute("roles", rolesSeparados);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
           
        }

        return "home";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}
