package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Usuario validar(String login, String password) {
        Usuario us = new Usuario();
        String sql = "select * from usuarios_sistema where login=? and password=?";
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
        return us;
    }

    public List listar() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "select * from usuarios_sistema";
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
        return list;
    }

    public String Agregar(Usuario us) {
        String sqlBuscars = "SELECT * FROM usuarios_sistema WHERE nit_persona = ?";
        String sql = "insert into usuarios_sistema(nit_persona, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, puesto, rol, password, estado)values(?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sqlBuscars);
            ps.setString(1, us.getNit_persona());
            rs = ps.executeQuery();

            if (rs.next()) {
                return "El Usuario ya existe en el sistema.";
            } else {
                ps = con.prepareStatement(sql);
                ps.setString(1, us.getNit_persona());
                ps.setString(2, us.getPrimer_nombre());
                ps.setString(3, us.getSegundo_nombre());
                ps.setString(4, us.getPrimer_apellido());
                ps.setString(5, us.getSegundo_apellido());
                ps.setString(6, us.getPuesto());
                ps.setString(7, us.getRol());
                ps.setString(8, us.getPassword());
                ps.setString(9, us.getEstado());
                ps.executeUpdate();
                return "Usuario agregado exitosamente.";
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

    public boolean edit(Usuario us) {
        String sql = "update usuarios_sistema set rol=?, estado=? where nit_persona=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getRol());
            ps.setString(2, us.getEstado());
            ps.setString(3, us.getNit_persona());
            ps.executeUpdate();
            return true;
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
        return false;
    }

    public boolean eliminar(int Nit_persona) {
        String sql = "delete from usuarios where nit_persona=" + Nit_persona;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
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
        return false;
    }

    public Usuario listarId(int Nit_persona) {
        Usuario us = new Usuario();
        String sql = "select * from usuarios_sistema where nit_persona=" + Nit_persona;
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
        return us;
    }

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

    public Usuario buscarPorNitN(String nitPersona) {
        String sql = "SELECT * FROM usuarios WHERE nit_persona = ?";
        Usuario usuario = null;

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nitPersona);
            rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setLogin(rs.getString("login"));
                usuario.setNit_persona(rs.getString("nit_persona"));
                usuario.setPrimer_nombre(rs.getString("primer_nombre"));
                usuario.setSegundo_nombre(rs.getString("segundo_nombre"));
                usuario.setPrimer_apellido(rs.getString("primer_apellido"));
                usuario.setSegundo_apellido(rs.getString("segundo_apellido"));
                usuario.setPuesto(rs.getString("puesto"));
                usuario.setRol(rs.getString("rol"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEstado(rs.getString("estado"));
            } else {

                return usuario;
            }
        } catch (SQLException e) {
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
        return usuario;
    }

    public List<Usuario> obtenerUsuariosPorRol(int rol, String estado) {
        String sql1 = "SELECT primer_nombre, primer_apellido FROM usuarios_sistema WHERE rol = ? AND estado = ?";
        List<Usuario> listaUsuarios = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql1);
            ps.setInt(1, rol);
            ps.setString(2, estado);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setPrimer_nombre(rs.getString("primer_nombre"));
                usuario.setPrimer_apellido(rs.getString("primer_apellido"));
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierra los recursos
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
        return listaUsuarios;
    }

}
