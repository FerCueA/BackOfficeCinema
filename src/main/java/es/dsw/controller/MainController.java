package es.dsw.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.dsw.connections.MySqlConnection;
import es.dsw.dao.UsuarioDAO;
import jakarta.servlet.http.HttpSession;
import es.dsw.models.Usuario;

@Controller
public class MainController {

	@GetMapping("/home")
	public String index() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/loginprocess")
	public String loginprocess(
		@RequestParam String username, 
		@RequestParam String password, 
		Model model,
		HttpSession session) {

		try {
		
			MySqlConnection MySql = new MySqlConnection();
			MySql.open();

			UsuarioDAO usuarioDAO = new UsuarioDAO(MySql.getConnection());
			List<Usuario> usuarios = usuarioDAO.getAllUsuarios();

			for (Usuario usuario : usuarios) {
				if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
					session.setAttribute("usuario", usuario);
					return "redirect:/home";
				}
			}

			return "login";

		} catch (Exception e) {

			return "login";
		}
	}

}
