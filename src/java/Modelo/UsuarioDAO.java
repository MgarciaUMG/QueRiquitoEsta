package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
            rs = ps.executeQuery();
            while (rs.next()) {
                us.setLogin(rs.getString("login"));
                us.setPassword(rs.getString("password"));
                us.setPrimer_nombre(rs.getString("primer_nombre"));
                us.setPrimer_apellido(rs.getString("primer_apellido"));
                us.setRol(rs.getString("rol"));

            }
        } catch (Exception e) {

        }
        return us;

    }

    public List listar() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "select * from usuarios";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario us = new Usuario();
                us.setLogin(rs.getString("login"));
                us.setNit_persona(rs.getString("nit_persona"));
                us.setPrimer_nombre(rs.getString("primer_nombre"));
                us.setSegundo_nombre(rs.getString("segundo_nombre"));
                us.setPrimer_apellido(rs.getString("primer_apellido"));
                us.setSegundo_apellido(rs.getString("segundo_apellido"));
                us.setPuesto(rs.getString("puesto"));
                us.setRol(rs.getString("rol"));
                us.setPassword(rs.getString("password"));
                us.setEstado(rs.getString("estado"));
                list.add(us);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public boolean Agregar(Usuario us) {
        String sql = "insert into usuarios(nit_persona, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, puesto, rol, password)values(?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNit_persona());
            ps.setString(2, us.getPrimer_nombre());
            ps.setString(3, us.getSegundo_nombre());
            ps.setString(4, us.getPrimer_apellido());
            ps.setString(5, us.getSegundo_apellido());
            ps.setString(6, us.getPuesto());
            ps.setString(7, us.getRol());
            ps.setString(8, us.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean edit(Usuario us) {
        String sql = "update usuarios set primer_nombre=?, segundo_nombre=?, primer_apellido=?, segundo_apellido=?, puesto=?, rol=?, password=?, estado=? where nit_persona=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getPrimer_nombre());
            ps.setString(2, us.getSegundo_nombre());
            ps.setString(3, us.getPrimer_apellido());
            ps.setString(4, us.getSegundo_apellido());
            ps.setString(5, us.getPuesto());
            ps.setString(6, us.getRol());
            ps.setString(7, us.getPassword());
            ps.setString(8, us.getEstado());
            ps.setString(9, us.getNit_persona());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean eliminar(int Nit_persona) {
        String sql = "delete from usuarios where nit_persona=" + Nit_persona;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public Usuario listarId(int Nit_persona) {
        Usuario us = new Usuario();
        String sql = "select * from usuarios where nit_persona=" + Nit_persona;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                us.setLogin(rs.getString("login"));
                us.setNit_persona(rs.getString("nit_persona"));
                us.setPrimer_nombre(rs.getString("primer_nombre"));
                us.setSegundo_nombre(rs.getString("segundo_nombre"));
                us.setPrimer_apellido(rs.getString("primer_apellido"));
                us.setSegundo_apellido(rs.getString("segundo_apellido"));
                us.setPuesto(rs.getString("puesto"));
                us.setRol(rs.getString("rol"));
                us.setPassword(rs.getString("password"));
                us.setEstado(rs.getString("estado"));

            }
        } catch (Exception e) {
        }
        return us;
    }

}
