package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EntidadDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public String buscarYCopiarRegistro(String nitEntidad) {
        String sqlBuscars = "SELECT * FROM entidad_sistema WHERE nit_Entidads = ?";
        String sqlBuscarg = "SELECT * FROM entidad_global WHERE nit_Entidadg = ?";
        String sqlCopiars = "INSERT INTO entidad_sistema (id_Entidads, nombre_Entidads, nit_Entidads, tipo_Entidads) VALUES (?, ?, ?, ?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sqlBuscars);
            ps.setString(1, nitEntidad);
            rs = ps.executeQuery();

            if (rs.next()) {
                return "El registro ya existe en las entidades.";
            } else {
                ps = con.prepareStatement(sqlBuscarg);
                ps.setString(1, nitEntidad);
                rs = ps.executeQuery();

                if (rs.next()) {
                    ps = con.prepareStatement(sqlCopiars);
                    ps.setInt(1, rs.getInt("id_Entidadg"));
                    ps.setString(2, rs.getString("nombre_Entidadg"));
                    ps.setString(3, rs.getString("nit_Entidadg"));
                    ps.setString(4, rs.getString("tipo_Entidadg"));
                    ps.executeUpdate();
                    return "Entidad agregada exitosamente.";
                } else {
                    return "La entidad no existe.";

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error al procesar la solicitud.";

    }

    public List<String> obtenerTiposEntidades() {

        List<String> tiposEntidades = new ArrayList<>();
        String sql = "SELECT DISTINCT tipo_Entidads FROM entidad_sistema";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                tiposEntidades.add(rs.getString("tipo_Entidads"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tiposEntidades;
    }

    public List<Entidad> listarEntidadesPorTipo(String tipoEntidad) {
        List<Entidad> entidades = new ArrayList<>();
        String sql = "SELECT * FROM entidad_sistema WHERE tipo_Entidads = ?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoEntidad);
            rs = ps.executeQuery();

            while (rs.next()) {
                Entidad entidad = new Entidad();
                entidad.setIdEntidad(rs.getInt("id_Entidads"));
                entidad.setNombreEntidad(rs.getString("nombre_Entidads"));
                entidad.setNitEntidad(rs.getString("nit_Entidads"));
                entidad.setTipoEntidad(rs.getString("tipo_Entidads"));
                entidades.add(entidad);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entidades;
    }

}
