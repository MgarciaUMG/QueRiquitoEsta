package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import static com.itextpdf.kernel.pdf.PdfName.Table;
import com.itextpdf.kernel.pdf.action.PdfAction;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class MuestraDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listarm() {
        ArrayList<Muestra> list = new ArrayList<>();
        String sql = "SELECT rsm.*, us.primer_nombre, us.primer_apellido "
                + "FROM registro_solicitudmuestra rsm "
                + "LEFT JOIN usuarios_sistema us ON rsm.analista_Asignado = us.id_usuario";
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
                String analistaAsignado = rs.getString("primer_nombre") + " " + rs.getString("primer_apellido");
                mu.setAnalistaAsignado(analistaAsignado);
                mu.setEstadoSolicitud(rs.getString("estado_Solicitud"));
                list.add(mu);
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

    public boolean Agregarm(Muestra mu) {
        String sql = "insert into registro_solicitudmuestra(tipo_Solicitud, tipo_Entidad, fecha_Solicitud, tipo_Documento, numero_Documento, nit_Proveedor, nombre_Proveedor, correo_proveedor, correo_Solicitante, direccion_Proveedor, telefono_Proveedor, nit_Solicitante, nombre_Solicitante, no_Muestra, descripcion_Producto, analista_Asignado, estado_Solicitud, id_Solicitud)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            ps.setString(16, mu.getAnalistaAsignado());
            ps.setString(17, mu.getEstadoSolicitud());
            ps.setInt(18, mu.getIdSolicitud());
            ps.executeUpdate();
            return true;
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
        return false;
    }

    public boolean eliminarm(int IdSolicitud) {
        String sql = "delete from registro_solicitudmuestra where id_Solicitud=" + IdSolicitud;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
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
        return false;
    }

    public Muestra listarIdm(int IdSolicitud) {
        Muestra mu = new Muestra();
        String sql = "SELECT rsm.*, us.primer_nombre, us.primer_apellido "
                + "FROM registro_solicitudmuestra rsm "
                + "LEFT JOIN usuarios_sistema us ON rsm.analista_Asignado = us.id_usuario "
                + "WHERE rsm.id_Solicitud = " + IdSolicitud;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
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
                String analistaAsignado = rs.getString("primer_nombre") + " " + rs.getString("primer_apellido");
                mu.setAnalistaAsignado(analistaAsignado);
                mu.setEstadoSolicitud(rs.getString("estado_Solicitud"));

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
        return mu;
    }

    public void generarPDF(HttpServletResponse response, Muestra mu) {

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=\"documento.pdf\"");

        try (OutputStream outputStream = response.getOutputStream()) {

            PdfWriter writer = new PdfWriter(outputStream);

            PdfDocument pdf = new PdfDocument(writer);

            Document document = new Document(pdf);

            Table table = new Table(UnitValue.createPercentArray(new float[]{1, 1}))
                    .useAllAvailableWidth();

            Cell cellIzquierda = new Cell();
            Paragraph titulo = new Paragraph("LABORATORIO DE INSPECCION\nDE CALIDAD ALIMENTOS ‘QUE RIQUIDO ESTÁ’")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold()
                    .setFontSize(14);
            cellIzquierda.add(titulo);
            table.addCell(cellIzquierda);

            Cell cellDerecha = new Cell();
            Paragraph contenido = new Paragraph()
                    .setTextAlignment(TextAlignment.CENTER)
                    .add("Número de Muestra: \n" + mu.getNoMuestra())
                    .add("\n")
                    .add("Nombre del Proveedor: \n" + mu.getNombreProveedor())
                    .add("\n")
                    .add("NIT del Proveedor: \n" + mu.getNitProveedor())
                    .add("\n")
                    .add("Número de Expediente: \n" + mu.getNumeroDocumento())
                    .add("\n")
                    .add("Nombre Analista: " + mu.getAnalistaAsignado());

            cellDerecha.add(contenido);
            table.addCell(cellDerecha);

            document.add(table);
            document.close();
        } catch (IOException e) {
            e.printStackTrace(); //
        }
    }

    public int obtenerCorrelativo() {
        int siguienteId = 1;
        String sql = "SELECT MAX(id_Solicitud) FROM registro_solicitudmuestra";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                siguienteId = rs.getInt(1) + 1;
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
        return siguienteId;
    }

    public static void enviarCorreo(Muestra mu, String Canalista) {
        String destinatariosoli = mu.getCorreoSolicitante();
        String asuntosoli = "Muestra Generada";
        String asuntoana = "Muestra para Análisis";
        String mensajeana = "<div style='border: 1px solid black; padding: 10px;'>"
                + "<p style='text-align: right;'>Fecha: " + mu.getFechaSolicitud() + "</p>"
                + "<p>Se le informa que la solicitud de Muestras o porción de muestra para la gestión de <b>\"" + mu.getTipoSolicitud() + "\"</b>,"
                + " Número de Muestra <b>\"" + mu.getNoMuestra() + "\"</b> le fue asignada con éxito, Expediente del: <b>\"" + mu.getTipoDocumento() + "\"</b>,"
                + " Número: <b>\"" + mu.getNumeroDocumento() + "\"</b>, se envía este aviso para seguimiento desde su bandeja.</p>"
                + "<br><br>"
                + "<p><i>** Esta es una correspondencia autogenerada por el Sistema Muestras. Por favor <b>NO RESPONDA</b> a este correo.</i></p>"
                + "</div>";

        String mensajesoli = "<div style='border: 1px solid black; padding: 10px;'>"
                + "<p style='text-align: right;'>Fecha: " + mu.getFechaSolicitud() + "</p>"
                + "<p>Se le informa que la solicitud de Muestras para la gestión de <b>\"" + mu.getTipoSolicitud() + "\"</b>,"
                + " Número de Muestra <b>\"" + mu.getNoMuestra() + "\"</b> fue registrada, Expediente del: <b>\"" + mu.getTipoDocumento() + "\"</b>,"
                + " Número: <b>\"" + mu.getNumeroDocumento() + "\"</b>, se envía este aviso para seguimiento.</p>"
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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Canalista));
            message.setSubject(asuntoana);
            message.setContent(mensajeana, "text/html");
            Message message1 = new MimeMessage(session);
            message1.setFrom(new InternetAddress(usuario));
            message1.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatariosoli));
            message1.setSubject(asuntosoli);
            message1.setContent(mensajesoli, "text/html");

            Transport.send(message);
            Transport.send(message1);
            System.out.println("Correo enviado con éxito.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
