package es.dsw.dao;

import es.dsw.connections.MySqlConnection;
import es.dsw.models.Usuario;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {

    // Creamos y establecemos el objeto de conexion a la base de datos
    private MySqlConnection objMySQLConnection;

    public UsuarioDAO() {
        objMySQLConnection = new MySqlConnection();
    }

    // Funcion para obtener todos los usuarios de la base de datos
    public ArrayList<Usuario> getAllUsuarios() throws SQLException {

        ArrayList<Usuario> objListaUsuarios = new ArrayList<Usuario>();
        objMySQLConnection.open();

        if (!objMySQLConnection.isError()) {

            String sql = "SELECT IDUSER_USF, USERNAME_USF, PASSWORD_USF, EMAIL_USF FROM USER_FILM";
            ResultSet objResultSet = objMySQLConnection.executeSelect(sql);

            try {
                while (objResultSet.next()) {
                    Usuario objUsuario = new Usuario();

                    objUsuario.setIdUser(objResultSet.getInt("IDUSER_USF"));
                    objUsuario.setUsername(objResultSet.getString("USERNAME_USF"));
                    objUsuario.setPassword(objResultSet.getString("PASSWORD_USF"));
                    objUsuario.setEmail(objResultSet.getString("EMAIL_USF"));

                    objListaUsuarios.add(objUsuario);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener los usuarios: " + e.getMessage());
            }
        }

        objMySQLConnection.close();
        return objListaUsuarios;
    }

    // Funcion para obtener los datos completos por su nombre de usuario
    public Usuario getUsuarioByUsername(String username) throws SQLException {

        Usuario usuario = null;
        objMySQLConnection.open();

        if (!objMySQLConnection.isError()) {

            String sql = "SELECT IDUSER_USF, USERNAME_USF, PASSWORD_USF, NAME_USF, FIRSTSURNAME_USF, SECOUNDSURNAME_USF, EMAIL_USF " +
                         "FROM USER_FILM WHERE USERNAME_USF = '" + username + "'";
            ResultSet objResultSet = objMySQLConnection.executeSelect(sql);

            try {
                if (objResultSet.next()) {
                    usuario = new Usuario();

                    usuario.setIdUser(objResultSet.getInt("IDUSER_USF"));
                    usuario.setUsername(objResultSet.getString("USERNAME_USF"));
                    usuario.setPassword(objResultSet.getString("PASSWORD_USF"));
                    usuario.setName(objResultSet.getString("NAME_USF"));
                    usuario.setFirstSurname(objResultSet.getString("FIRSTSURNAME_USF"));
                    usuario.setSecondSurname(objResultSet.getString("SECOUNDSURNAME_USF"));
                    usuario.setEmail(objResultSet.getString("EMAIL_USF"));
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener el usuario por nombre de usuario: " + e.getMessage());
            }
        }

        objMySQLConnection.close();
        return usuario;
    }
}
