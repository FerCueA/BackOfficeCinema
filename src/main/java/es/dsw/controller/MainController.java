package es.dsw.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login(
            @CookieValue(value = "ultimoAcceso", defaultValue = "") String ultimoAcceso, Model model) {

        if (!ultimoAcceso.isEmpty()) {
            model.addAttribute("ultimoAcceso", ultimoAcceso);
        } else {
            model.addAttribute("ultimoAcceso", "Es tu primera vez por aquí");
        }
        return "login";
    }

    @GetMapping("/home")
    public String index(HttpServletResponse response) {

        LocalDateTime objTiempo = LocalDateTime.now();
        DateTimeFormatter objFormato = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH:mm:ss");
        String tiempoFormateado = objTiempo.format(objFormato);

        Cookie objCookie = new Cookie("ultimoAcceso", tiempoFormateado);
        objCookie.setMaxAge(7 * 24 * 60 * 60);
       
        response.addCookie(objCookie);

        return "home";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}
