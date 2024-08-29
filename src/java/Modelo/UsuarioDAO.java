package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Usuario validar(String login, String password) {
        Usuario us = new Usuario();
        String sql = "select * from usuarios where login=? and password=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, password);
            rs=ps.executeQuery();
            while (rs.next()) {
                us.setLogin(rs.getString("login"));
                us.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {

        }
        return us;

    }

}
