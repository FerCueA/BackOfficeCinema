package es.dsw.app;

import es.dsw.dao.UsuarioDAO;
import es.dsw.models.Usuario;
import es.dsw.connections.MySqlConnection;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            MySqlConnection mySql = new MySqlConnection();
            mySql.open();
            UsuarioDAO usuarioDAO = new UsuarioDAO(mySql.getConnection());
            Usuario usuario = usuarioDAO.getUsuarioByUsername(username);
            mySql.close();
            if (usuario == null) {
                throw new UsernameNotFoundException("Usuario no encontrado");
            }
            // Aquí puedes agregar roles si tu modelo Usuario los tiene
            return User.withUsername(usuario.getUsername())
                    .password(usuario.getPassword())
                    .roles("USER") // Cambia esto si tienes roles en la BD
                    .build();
        } catch (Exception e) {
            throw new UsernameNotFoundException("Error al acceder a la base de datos");
        }
    }
}
