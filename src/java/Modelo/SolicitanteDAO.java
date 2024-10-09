package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SolicitanteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Solicitante buscarPorNit(String nitSolicitanteb) {
        String sql = "SELECT * FROM solicitante_sistema WHERE nit_Solicitante = ?";
        Solicitante solicitante = null;

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nitSolicitanteb);
            rs = ps.executeQuery();

            if (rs.next()) {
                solicitante = new Solicitante();
                solicitante.setIdSolicitante(rs.getInt("id_Solicitante"));
                solicitante.setNombreSolicitante(rs.getString("nombre_Solicitante"));
                solicitante.setNitSolicitante(rs.getString("nit_Solicitante"));
                solicitante.setCorreoSolicitante(rs.getString("correo_Solicitante"));
            } else {

                return solicitante;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return solicitante;
    }

    public String obtenerFechaActual() {
        String fechaActual = null;
        String sql1 = "SELECT CURDATE() AS fecha_actual";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery();

            if (rs.next()) {
                fechaActual = rs.getString("fecha_actual"); // Obtener la fecha formateada
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fechaActual; // Retorna la fecha actual
    }

}
