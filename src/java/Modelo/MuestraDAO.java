package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MuestraDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listarm() {
        ArrayList<Muestra> list = new ArrayList<>();
        String sql = "select * from registro_solicitudmuestra";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Muestra mu = new Muestra();
                mu.setIdSolicitud(rs.getInt("id_Solicitud"));
                mu.setTipoSolicitud(rs.getString("tipo_Solicitud"));
                mu.setTipoEntidad(rs.getString("tipo_Entidad"));
                mu.setFechaSolicitud(rs.getDate("fecha_Solicitud"));
                mu.setTipoDocumento(rs.getString("tipo_Documento"));
                mu.setNumeroDocumento(rs.getString("numero_Documento"));
                mu.setNitProveedor(rs.getString("nit_Proveedor"));
                mu.setNombreProveedor(rs.getString("nombre_Proveedor"));
                mu.setCorreoproveedor(rs.getString("correo_proveedor"));
                mu.setCorreoSolicitante(rs.getString("correo_Solicitante"));
                mu.setDireccionProveedor(rs.getString("direccion_Proveedor"));
                mu.setTelefonoProveedor(rs.getString("telefono_Proveedor"));
                mu.setNitSolicitante(rs.getString("nit_Solicitante"));
                mu.setNombreSolicitante(rs.getString("nombre_Solicitante"));
                mu.setNoMuestra(rs.getString("no_Muestra"));
                mu.setDescripcionProducto(rs.getString("descripcion_Producto"));
                list.add(mu);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public boolean Agregarm(Muestra mu) {
        String sql = "insert into registro_solicitudmuestra(tipo_Solicitud, tipo_Entidad, fecha_Solicitud, tipo_Documento, numero_Documento, nit_Proveedor, nombre_Proveedor, correo_proveedor, correo_Solicitante, direccion_Proveedor, telefono_Proveedor, nit_Solicitante, nombre_Solicitante, no_Muestra, descripcion_Producto)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, mu.getTipoSolicitud());
            ps.setString(2, mu.getTipoEntidad());
            ps.setDate(3, mu.getFechaSolicitud());
            ps.setString(4, mu.getTipoDocumento());
            ps.setString(5, mu.getNumeroDocumento());
            ps.setString(6, mu.getNitProveedor());
            ps.setString(7, mu.getNombreProveedor());
            ps.setString(8, mu.getCorreoproveedor());
            ps.setString(9, mu.getCorreoSolicitante());
            ps.setString(10, mu.getDireccionProveedor());
            ps.setString(11, mu.getTelefonoProveedor());
            ps.setString(12, mu.getNitSolicitante());
            ps.setString(13, mu.getNombreSolicitante());
            ps.setString(14, mu.getNoMuestra());
            ps.setString(15, mu.getDescripcionProducto());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean editm(Muestra mu) {
        String sql = "update registro_solicitudmuestra set tipo_Solicitud=?, tipo_Entidad=?, fecha_Solicitud=?, tipo_Documento=?, numero_Documento=?, nit_Proveedor=?, nombre_Proveedor=?, correo_proveedor=?, correo_Solicitante=?, direccion_Proveedor=?, telefono_Proveedor=?, nit_Solicitante=?, nombre_Solicitante=?, no_Muestra=?, descripcion_Producto=? where id_Solicitud=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, mu.getTipoSolicitud());
            ps.setString(2, mu.getTipoEntidad());
            ps.setDate(3, mu.getFechaSolicitud());
            ps.setString(4, mu.getTipoDocumento());
            ps.setString(5, mu.getNumeroDocumento());
            ps.setString(6, mu.getNitProveedor());
            ps.setString(7, mu.getNombreProveedor());
            ps.setString(8, mu.getCorreoproveedor());
            ps.setString(9, mu.getCorreoSolicitante());
            ps.setString(10, mu.getDireccionProveedor());
            ps.setString(11, mu.getTelefonoProveedor());
            ps.setString(12, mu.getNitSolicitante());
            ps.setString(13, mu.getNombreSolicitante());
            ps.setString(14, mu.getNoMuestra());
            ps.setString(15, mu.getDescripcionProducto());
            ps.setInt(16, mu.getIdSolicitud());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean eliminarm(int IdSolicitud) {
        String sql = "delete from registro_solicitudmuestra where id_Solicitud=" + IdSolicitud;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public Muestra listarIdm(int IdSolicitud) {
        Muestra mu = new Muestra();
        String sql = "select * from registro_solicitudmuestra where id_Solicitud=" + IdSolicitud;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                mu.setIdSolicitud(rs.getInt("id_Solicitud"));
                mu.setTipoSolicitud(rs.getString("tipo_Solicitud"));
                mu.setTipoEntidad(rs.getString("tipo_Entidad"));
                mu.setFechaSolicitud(rs.getDate("fecha_Solicitud"));
                mu.setTipoDocumento(rs.getString("tipo_Documento"));
                mu.setNumeroDocumento(rs.getString("numero_Documento"));
                mu.setNitProveedor(rs.getString("nit_Proveedor"));
                mu.setNombreProveedor(rs.getString("nombre_Proveedor"));
                mu.setCorreoproveedor(rs.getString("correo_proveedor"));
                mu.setCorreoSolicitante(rs.getString("correo_Solicitante"));
                mu.setDireccionProveedor(rs.getString("direccion_Proveedor"));
                mu.setTelefonoProveedor(rs.getString("telefono_Proveedor"));
                mu.setNitSolicitante(rs.getString("nit_Solicitante"));
                mu.setNombreSolicitante(rs.getString("nombre_Solicitante"));
                mu.setNoMuestra(rs.getString("no_Muestra"));
                mu.setDescripcionProducto(rs.getString("descripcion_Producto"));

            }
        } catch (Exception e) {
        }
        return mu;
    }

}
