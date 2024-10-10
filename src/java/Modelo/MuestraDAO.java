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
                mu.setAnalistaAsignado(rs.getString("analista_Asignado"));
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
        // Configurar la respuesta
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=\"documento.pdf\"");

        // Crear un documento PDF
        try (OutputStream outputStream = response.getOutputStream()) {
            // Crear un PdfWriter
            PdfWriter writer = new PdfWriter(outputStream);
            // Crear un PdfDocument
            PdfDocument pdf = new PdfDocument(writer);
            // Crear un documento para añadir contenido
            Document document = new Document(pdf);

            // Crear una tabla con dos columnas
            Table table = new Table(UnitValue.createPercentArray(new float[]{1, 1}))
                    .useAllAvailableWidth();

            // Celda izquierda con contenido
            // Celda derecha con el título
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
                    .add("Número de Muestra\n")
                    .add("\n")// Primera línea
                    .add("Porción de Muestra\n")
                    .add("\n")
                    .add("Nombre del Proveedor\n")
                    .add("\n")
                    .add("NIT del Proveedor\n")
                    .add("\n")
                    .add("Número de Expediente\n")
                    .add("\n")
                    .add("Nombre Analista");

            cellDerecha.add(contenido);
            table.addCell(cellDerecha);

            // Añadir la tabla al documento
            document.add(table);
            document.close();
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores en la consola
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
                // Obtiene el ID máximo y le suma 1
                siguienteId = rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja la excepción como desees
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

    public static void enviarCorreo(String destinatario, String asunto, String mensaje) {
        // Configuración de las propiedades de la conexión
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com"); // Cambia por el servidor SMTP
        propiedades.put("mail.smtp.port", "587"); // Cambia por el puerto que uses

        // Autenticación
        String usuario = "noreplyqueriquitoesta@gmail.com"; // Cambia por tu correo electrónico
        String clave = "neutmgjuzdymkqol"; // Cambia por tu contraseña

        Session session = Session.getInstance(propiedades, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, clave);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport.send(message);
            System.out.println("Correo enviado con éxito.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
