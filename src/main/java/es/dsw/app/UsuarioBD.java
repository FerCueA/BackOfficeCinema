package es.dsw.app;

import es.dsw.dao.RolDAO;
import es.dsw.dao.UsuarioDAO;
import es.dsw.models.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

// Utilizamos esta clase auxular para conectar la BD con el proyecto
@Service
public class UsuarioBD implements UserDetailsService {

    /**
     * Spring Security llama a este método automáticamente cuando alguien intenta hacer login.
     * Usa un método de UserDetailsService que trae por defecto Spring Security con el nombre de loadUserByUsername.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {

            // Usamos UsuarioDAO para buscar el usuario en la BD
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.getUsuarioByUsername(username);

            // Si no existe el usuario, lanzamos excepción
            if (usuario == null) {
                throw new UsernameNotFoundException("Usuario no encontrado: " + username);
            }

            // Usamos RolDAO para obtener los roles del usuario desde la BD
            RolDAO rolDAO = new RolDAO();
            ArrayList<String> roles = rolDAO.obtenerRolByUserId(usuario.getIdUser());
            
            // Convertimos el ArrayList a un array de String para Spring Security
            String[] arrayRoles = roles.toArray(new String[0]);

            // Convertimos el objeto Usuario al formato que Spring Security necesita
            return User.withUsername(usuario.getUsername())
                    .password(usuario.getPassword()) // Spring compara esta password con la ingresada
                    .roles(arrayRoles) // Asignamos los roles desde la tabla ROL_FILM
                    .build();

        } catch (Exception e) {
            throw new UsernameNotFoundException("Error al buscar usuario: " + e.getMessage());
        }
    }
}
