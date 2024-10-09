package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntidadDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public String buscarYCopiarRegistro(Entidad en) {
        String sqlBuscars = "SELECT * FROM entidad_sistema WHERE nit_Entidads = ?";
        String sqlCopiars = "INSERT INTO entidad_sistema (id_Entidads, nombre_Entidads, nit_Entidads, tipo_Entidads, correo_Entidads, direccion_Entidads, telefono_Entidads) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sqlBuscars);
            ps.setString(1, en.getNitEntidad());
            rs = ps.executeQuery();

            if (rs.next()) {
                return "El registro ya existe en las entidades.";
            } else {
                ps = con.prepareStatement(sqlCopiars);
                ps.setInt(1, en.getIdEntidad());
                ps.setString(2, en.getNombreEntidad());
                ps.setString(3, en.getNitEntidad());
                ps.setString(4, en.getTipoEntidad());
                ps.setString(5, en.getCorreoEntidad());
                ps.setString(6, en.getDireccionEntidad());
                ps.setString(7, en.getTelefonoEntidad());
                ps.executeUpdate();
                return "Entidad agregada exitosamente.";

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
        return entidades;
    }

    public void eliminarEntidad(int idEntidad) {
        String sql = "DELETE FROM entidad_sistema WHERE id_Entidads = ?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEntidad);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
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
    }

    public Entidad buscarPorNit(String nitEntidad) {
        String sql = "SELECT * FROM entidad_sistema WHERE nit_Entidads = ?";
        Entidad entidad = null;

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nitEntidad);
            rs = ps.executeQuery();

            if (rs.next()) {
                entidad = new Entidad();
                entidad.setIdEntidad(rs.getInt("id_Entidads"));
                entidad.setNombreEntidad(rs.getString("nombre_Entidads"));
                entidad.setNitEntidad(rs.getString("nit_Entidads"));
                entidad.setTipoEntidad(rs.getString("tipo_Entidads"));
                entidad.setCorreoEntidad(rs.getString("correo_Entidads"));
                entidad.setDireccionEntidad(rs.getString("direccion_Entidads"));
                entidad.setTelefonoEntidad(rs.getString("telefono_Entidads"));
            } else {

                return entidad;
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
        return entidad;
    }

    public Entidad buscarPorNitN(String nitEntidad) {
        String sql = "SELECT * FROM entidad_global WHERE nit_Entidadg = ?";
        Entidad entidad = null;

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nitEntidad);
            rs = ps.executeQuery();

            if (rs.next()) {
                entidad = new Entidad();
                entidad.setIdEntidad(rs.getInt("id_Entidadg"));
                entidad.setNombreEntidad(rs.getString("nombre_Entidadg"));
                entidad.setNitEntidad(rs.getString("nit_Entidadg"));
                entidad.setTipoEntidad(rs.getString("tipo_Entidadg"));
                entidad.setCorreoEntidad(rs.getString("correo_Entidadg"));
                entidad.setDireccionEntidad(rs.getString("direccion_Entidadg"));
                entidad.setTelefonoEntidad(rs.getString("telefono_Entidadg"));
            } else {

                return entidad;
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
        return entidad;
    }

}
