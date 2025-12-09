package es.dsw.dao;

import es.dsw.connections.MySqlConnection;
import es.dsw.models.Rol;
import java.sql.*;
import java.util.ArrayList;


public class RolDAO {

    private MySqlConnection objMySQLConnection;

    public RolDAO() {
        objMySQLConnection = new MySqlConnection();
    }

    // Obtener los roles de un usuario por su ID
    public ArrayList<String> obtenerRolByUserId(int userId) throws SQLException {

        ArrayList<String> idRol = new ArrayList<>();
        objMySQLConnection.open();

        if (!objMySQLConnection.isError()) {
            String sql = "SELECT r.ROLCODE_RF FROM ROL_FILM r " +
                        "INNER JOIN USERROL_FILM ur ON r.IDROL_RF = ur.IDROL_URF " +
                        "WHERE ur.IDUSER_URF = " + userId;
            
            ResultSet objResultSet = objMySQLConnection.executeSelect(sql);

            try {
                while (objResultSet.next()) {
                    idRol.add(objResultSet.getString("ROLCODE_RF"));
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener los roles del usuario: " + e.getMessage());
            }
        }

        objMySQLConnection.close();
        return idRol;
    }

    // Obtener todos los roles disponibles
    public ArrayList<Rol> obtenerTodosLosRoles() throws SQLException {
        ArrayList<Rol> listaRoles = new ArrayList<>();
        objMySQLConnection.open();

        if (!objMySQLConnection.isError()) {
            String sql = "SELECT IDROL_RF, ROLCODE_RF, ROLNAME_RF FROM ROL_FILM";
            ResultSet objResultSet = objMySQLConnection.executeSelect(sql);

            try {
                while (objResultSet.next()) {
                    Rol rol = new Rol();
                    rol.setIdRol(objResultSet.getInt("IDROL_RF"));
                    rol.setRolCode(objResultSet.getString("ROLCODE_RF"));
                    rol.setRolName(objResultSet.getString("ROLNAME_RF"));
                    listaRoles.add(rol);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener todos los roles: " + e.getMessage());
            }
        }

        objMySQLConnection.close();
        return listaRoles;
    }
}
