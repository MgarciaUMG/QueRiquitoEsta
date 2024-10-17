package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
        String sql = "insert into usuarios_sistema(id_usuario, nit_persona, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, puesto, rol, password, estado, correo_Usuario)values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sqlBuscars);
            ps.setString(1, us.getNit_persona());
            rs = ps.executeQuery();

            if (rs.next()) {
                return "El Usuario ya existe en el sistema.";
            } else {
                ps = con.prepareStatement(sql);
                ps.setInt(1, us.getIdpersona());
                ps.setString(2, us.getNit_persona());
                ps.setString(3, us.getPrimer_nombre());
                ps.setString(4, us.getSegundo_nombre());
                ps.setString(5, us.getPrimer_apellido());
                ps.setString(6, us.getSegundo_apellido());
                ps.setString(7, us.getPuesto());
                ps.setString(8, us.getRol());
                ps.setString(9, us.getPassword());
                ps.setString(10, us.getEstado());
                ps.setString(11, us.getCorreo());
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
        String sql = "update usuarios_sistema set estado=?, motivo=? where nit_persona=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getEstado());
            ps.setString(2, us.getMotivo());
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
                us.setIdpersona(rs.getInt("id_usuario"));
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
                us.setCorreo(rs.getString("correo_Usuario"));
                us.setTrabajo(rs.getInt("carga_de_Trabajo"));

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
                usuario.setIdpersona(rs.getInt("id_usuario"));
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
                usuario.setCorreo(rs.getString("correo_Usuario"));
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
        String sql1 = "SELECT id_usuario, primer_nombre, primer_apellido, correo_Usuario FROM usuarios_sistema WHERE rol = ? AND estado = ?";
        List<Usuario> listaUsuarios = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql1);
            ps.setInt(1, rol);
            ps.setString(2, estado);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdpersona(rs.getInt("id_usuario"));
                usuario.setPrimer_nombre(rs.getString("primer_nombre"));
                usuario.setPrimer_apellido(rs.getString("primer_apellido"));
                usuario.setCorreo(rs.getString("correo_Usuario"));
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

    public static void enviarCorreo(Muestra mu, String correonA) {
        String asuntoana = "Muestra para Análisis";
        String mensajeana = "<div style='border: 1px solid black; padding: 10px;'>"
                + "<p style='text-align: right;'>Fecha: " + mu.getFechaSolicitud() + "</p>"
                + "<p>Se le informa que la solicitud de Muestras o porción de muestra para la gestión de <b>\"" + mu.getTipoSolicitud() + "\"</b>,"
                + " Número de Muestra <b>\"" + mu.getNoMuestra() + "\"</b> le fue asignada con éxito, Expediente del: <b>\"" + mu.getTipoDocumento() + "\"</b>,"
                + " Número: <b>\"" + mu.getNumeroDocumento() + "\"</b>, se envía este aviso para seguimiento desde su bandeja.</p>"
                + "<br><br>"
                + "<p><i>** Esta es una correspondencia autogenerada por el Sistema Muestras. Por favor <b>NO RESPONDA</b> a este correo.</i></p>"
                + "</div>";

        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");

        // Autenticación
        String usuario = "noreplyqueriquitoesta@gmail.com";
        String clave = "neutmgjuzdymkqol";

        Session session = Session.getInstance(propiedades, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, clave);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correonA));
            message.setSubject(asuntoana);
            message.setContent(mensajeana, "text/html");
            Transport.send(message);
            System.out.println("Correo enviado con éxito.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
