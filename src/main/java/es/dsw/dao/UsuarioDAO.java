package es.dsw.dao;

import es.dsw.connections.MySqlConnection;
import es.dsw.models.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    private Usuario mapUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUser(rs.getInt("IDUSER_USF"));
        usuario.setUsername(rs.getString("USERNAME_USF"));
        usuario.setPassword(rs.getString("PASSWORD_USF"));
        usuario.setName(rs.getString("NAME_USF"));
        usuario.setFirstSurname(rs.getString("FIRSTSURNAME_USF"));
        usuario.setSecondSurname(rs.getString("SECOUNDSURNAME_USF"));
        usuario.setEmail(rs.getString("EMAIL_USF"));
        usuario.setActiveRow(rs.getBoolean("S_ACTIVEROW_USF"));
        usuario.setInsertDate(rs.getTimestamp("S_INSERTDATE_USF"));
        usuario.setUpdateDate(rs.getTimestamp("S_UPDATEDATE_USF"));
        return usuario;
    }

    public List<Usuario> getAllUsuarios() throws SQLException {

        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USER_FILM";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                usuarios.add(mapUsuario(rs));
            }
        }

        return usuarios;
    }

    public String getUserId(int idUser) {
        String username = null;
        MySqlConnection conexion = new MySqlConnection("db_filmcinema");
        conexion.open();
        if (conexion.isError()) {
            System.out.println("ERROR al abrir conexión: " + conexion.msgError());
            return null;
        }
        String sql = "SELECT USERNAME_USF AS USERNAME FROM USER_FILM WHERE IDUSER_USF = " + idUser;
        ResultSet rs = conexion.executeSelect(sql);
        try {
            if (rs != null && rs.next()) {
                username = rs.getString("USERNAME");
            }
        } catch (Exception e) {
            System.out.println("ERROR leyendo título de película: " + e.getMessage());
        }
        conexion.close();
        return username;
    }

    public Usuario getUsuarioByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM USER_FILM WHERE USERNAME_USF = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapUsuario(rs);
                }
            }
        }
        return null;
    }

}
