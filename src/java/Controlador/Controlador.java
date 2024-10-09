package Controlador;

import Modelo.Entidad;
import Modelo.EntidadDAO;
import Modelo.Muestra;
import Modelo.MuestraDAO;
import Modelo.Solicitante;
import Modelo.SolicitanteDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.OutputStream;

public class Controlador extends HttpServlet {

    Usuario us = new Usuario();
    UsuarioDAO udao = new UsuarioDAO();
    Muestra mu = new Muestra();
    MuestraDAO mdao = new MuestraDAO();
    Entidad en = new Entidad();
    EntidadDAO eDAO = new EntidadDAO();
    Solicitante so = new Solicitante();
    SolicitanteDAO sDAO = new SolicitanteDAO();
    int idfilam;
    int idfila;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Inicio")) {
            request.getRequestDispatcher("Inicio.jsp").forward(request, response);

        }
        if (menu.equals("BandejaLab")) {
            List<Usuario> usuarios = new UsuarioDAO().obtenerUsuariosPorRol(3, "Activo");

            switch (accion) {

                case "listar":
                    List lista = mdao.listarm();
                    request.setAttribute("muestras", lista);
                    request.getRequestDispatcher("RegistroSolicitudyMuestra.jsp").forward(request, response);

                    break;

                case "Nuevo":
                    request.setAttribute("usuarios", usuarios);
                    String fechaActual = sDAO.obtenerFechaActual();
                    request.setAttribute("fechaActual", fechaActual);
                    request.getRequestDispatcher("NuevaSolicitudyMuestra.jsp").forward(request, response);

                    break;

                case "buscarPro":
                    request.setAttribute("usuarios", usuarios);
                    String nitEntidad = request.getParameter("txtnitpro");
                    Entidad enti = eDAO.buscarPorNit(nitEntidad);
                    request.setAttribute("entidad", enti);
                    if (enti != null) {
                    } else {
                        request.setAttribute("mensaje", "El proveedor no existe");
                        request.setAttribute("mensajeTipo", "error");

                    }
                    request.getRequestDispatcher("NuevaSolicitudyMuestra.jsp").forward(request, response);

                    break;

                case "buscarSoli":
                    request.setAttribute("usuarios", usuarios);
                    String nitSolicitanteb = request.getParameter("txtnitsoli");
                    Solicitante Soli = sDAO.buscarPorNit(nitSolicitanteb);
                    request.setAttribute("solicitante", Soli);
                    if (Soli != null) {
                    } else {
                        request.setAttribute("mensaje", "El Solicitante no existe");
                        request.setAttribute("mensajeTipo", "error");

                    }

                    request.getRequestDispatcher("NuevaSolicitudyMuestra.jsp").forward(request, response);

                    break;

                case "Agregar":
                    String tipoSolicitud = request.getParameter("txttiposoli");
                    String tipoEntidad = request.getParameter("txttipoenti");
                    Date fechaSolicitud = Date.valueOf(request.getParameter("txtfechasoli"));
                    String tipoDocumento = request.getParameter("txttipodocu");
                    String numeroDocumento = request.getParameter("txtnodocu");
                    String nitProveedor = request.getParameter("txtnitpro");
                    String nombreProveedor = request.getParameter("txtnombrepro");
                    String correoproveedor = request.getParameter("txtcorreopro");
                    String correoSolicitante = request.getParameter("txtcorreosoli");
                    String direccionProveedor = request.getParameter("txtdirepro");
                    String telefonoProveedor = request.getParameter("txttelpro");
                    String nitSolicitante = request.getParameter("txtnitsoli");
                    String nombreSolicitante = request.getParameter("txtnombresoli");
                    String noMuestra = request.getParameter("txtnomuestra");
                    String descripcionProducto = request.getParameter("txtdesprodu");
                    String analistaAsisgnado = request.getParameter("usuarioSeleccionado");
                    String estadoSolicitud = request.getParameter("txtestadosolicitud");

                    mu.setTipoSolicitud(tipoSolicitud);
                    mu.setTipoEntidad(tipoEntidad);
                    mu.setFechaSolicitud(fechaSolicitud);
                    mu.setTipoDocumento(tipoDocumento);
                    mu.setNumeroDocumento(numeroDocumento);
                    mu.setNitProveedor(nitProveedor);
                    mu.setNombreProveedor(nombreProveedor);
                    mu.setCorreoproveedor(correoproveedor);
                    mu.setCorreoSolicitante(correoSolicitante);
                    mu.setDireccionProveedor(direccionProveedor);
                    mu.setTelefonoProveedor(telefonoProveedor);
                    mu.setNitSolicitante(nitSolicitante);
                    mu.setNombreSolicitante(nombreSolicitante);
                    mu.setNoMuestra(noMuestra);
                    mu.setDescripcionProducto(descripcionProducto);
                    mu.setAnalistaAsignado(analistaAsisgnado);
                    mu.setEstadoSolicitud(estadoSolicitud);
                    boolean agregado = mdao.Agregarm(mu);
                    request.setAttribute("agregado", agregado);
                    if (agregado) {
                        generarPDF(response, mu);
                        request.getRequestDispatcher("Controlador?menu=BandejaLab&accion=listar").forward(request, response);
                    }
                    request.getRequestDispatcher("Controlador?menu=BandejaLab&accion=listar").forward(request, response);
                    break;
                case "edit":
                    idfilam = Integer.parseInt(request.getParameter("idSolicitud"));
                    Muestra mus = mdao.listarIdm(idfilam);
                    request.setAttribute("muestra", mus);
                    request.getRequestDispatcher("DetalleSolicitudyMuestra.jsp").forward(request, response);
                    break;
                case "eliminar":
                    idfilam = Integer.parseInt(request.getParameter("idSolicitud"));
                    mdao.eliminarm(idfilam);
                    request.getRequestDispatcher("Controlador?menu=BandejaLab&accion=listar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();

            }

            request.getRequestDispatcher("RegistroSolicitudyMuestra.jsp").forward(request, response);
        }

        if (menu.equals("ManteCata")) {
            EntidadDAO entidadDAO = new EntidadDAO();
            List<String> tiposEntidades = entidadDAO.obtenerTiposEntidades();
            switch (accion) {

                case "Guardar":
                    int idEntidad = Integer.parseInt(request.getParameter("txtidenti"));
                    String nitEntidad = request.getParameter("txtnitenti");
                    String nombreEntidad = request.getParameter("txtnombreenti");
                    String tipoEntidad = request.getParameter("tipoEntidad");
                    String correoEntidad = request.getParameter("txtcorreoenti");
                    String direccionEntidad = request.getParameter("txtdireenti");
                    String telefonoEntidad = request.getParameter("txttelenti");

                    en.setIdEntidad(idEntidad);
                    en.setNitEntidad(nitEntidad);
                    en.setNombreEntidad(nombreEntidad);
                    en.setTipoEntidad(tipoEntidad);
                    en.setCorreoEntidad(correoEntidad);
                    en.setDireccionEntidad(direccionEntidad);
                    en.setTelefonoEntidad(telefonoEntidad);
                    String mensaje = entidadDAO.buscarYCopiarRegistro(en);

                    if (mensaje == "Entidad agregada exitosamente.") {
                        request.setAttribute("mensaje", "Se agrego la entidad " + tipoEntidad + " con éxito.");
                        request.setAttribute("mensajeTipo", "exito");
                    } else if (mensaje == "El registro ya existe en las entidades.") {
                        request.setAttribute("mensaje", "Por favor verifique, la Entidad ya se encuentra registrada. ");
                        request.setAttribute("mensajeTipo", "error");
                    } else {
                        request.setAttribute("mensaje", "La entidad no existe.");
                        request.setAttribute("mensajeTipo", "error");

                    }

                    request.getRequestDispatcher("BusquedaMantenimientoCatalogos.jsp").forward(request, response);

                    break;

                case "buscarPro":
                    String nitEntidad1 = request.getParameter("txtnitenti");
                    Entidad enti = eDAO.buscarPorNitN(nitEntidad1);
                    if (enti != null) {
                        request.setAttribute("entidad", enti);
                        request.setAttribute("habilitarGuardar", true);
                    } else {
                        request.setAttribute("mensaje", "Por favor Verifique, Entidad no Encontrada");
                        request.setAttribute("mensajeTipo", "error");
                        request.setAttribute("habilitarGuardar", false);
                    }
                    request.getRequestDispatcher("BusquedaMantenimientoCatalogos.jsp").forward(request, response);

                    break;

                case "ver":

                    request.setAttribute("tiposEntidades", tiposEntidades);
                    request.getRequestDispatcher("MantenimientoCatalogos.jsp").forward(request, response);

                    break;

                case "Listar Entidades":
                    request.setAttribute("tiposEntidades", tiposEntidades);
                    String tipoEntidadSeleccionado = request.getParameter("tipoEntidad");
                    List<Entidad> entidades = entidadDAO.listarEntidadesPorTipo(tipoEntidadSeleccionado);
                    request.setAttribute("entidades", entidades);
                    request.getRequestDispatcher("MantenimientoCatalogos.jsp").forward(request, response);
                    break;

                case "eliminar":
                    int idEntidad1 = Integer.parseInt(request.getParameter("idEntidad"));
                    entidadDAO.eliminarEntidad(idEntidad1);
                    request.getRequestDispatcher("Controlador?menu=ManteCata&accion=Listar Entidades").forward(request, response);
                    break;

                default:
                    throw new AssertionError();

            }
            request.getRequestDispatcher("MantenimientoCatalogos.jsp").forward(request, response);

        }

        if (menu.equals("Servicios")) {
            request.getRequestDispatcher("Servicios.jsp").forward(request, response);

        }

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);

        }

        if (menu.equals("Usuarios")) {
            switch (accion) {

                case "Nuevo":
                    request.getRequestDispatcher("AgregarUsuarios.jsp").forward(request, response);
                    break;

                case "listar":
                    List lista = udao.listar();
                    request.setAttribute("usuarios", lista);

                    break;

                case "Agregar":
                    String login = request.getParameter("txtlogin");
                    String nit_persona = request.getParameter("txtnit");
                    String primer_nombre = request.getParameter("txtpnombre");
                    String segundo_nombre = request.getParameter("txtsnombre");
                    String primer_apellido = request.getParameter("txtpapellido");
                    String segundo_apellido = request.getParameter("txtsapellido");
                    String puesto = request.getParameter("txtpuesto");
                    String rol = request.getParameter("txtrol");
                    String password = request.getParameter("txtpassword");
                    String estado = request.getParameter("txtestado");
                    us.setLogin(login);
                    us.setNit_persona(nit_persona);
                    us.setPrimer_nombre(primer_nombre);
                    us.setSegundo_nombre(segundo_nombre);
                    us.setPrimer_apellido(primer_apellido);
                    us.setSegundo_apellido(segundo_apellido);
                    us.setPuesto(puesto);
                    us.setRol(rol);
                    us.setPassword(password);
                    us.setEstado(estado);
                    String mensaje = udao.Agregar(us);

                    if (mensaje == "Usuario agregado exitosamente.") {
                        request.setAttribute("mensaje", "Usuario agregado exitosamente.");
                        request.setAttribute("mensajeTipo", "exito");
                    } else if (mensaje == "El Usuario ya existe en el sistema.") {
                        request.setAttribute("mensaje", "El Usuario ya existe en el sistema.");
                        request.setAttribute("mensajeTipo", "error");
                    } else {
                        request.setAttribute("mensaje", "La entidad no existe.");
                        request.setAttribute("mensajeTipo", "error");

                    }
                    request.getRequestDispatcher("AgregarUsuarios.jsp").forward(request, response);
                    break;
                case "edit":
                    idfila = Integer.parseInt(request.getParameter("nit_persona"));
                    Usuario u = udao.listarId(idfila);
                    request.setAttribute("usuario", u);
                    request.setAttribute("editMode", true);
                    request.getRequestDispatcher("EditarUsuarios.jsp").forward(request, response);

                    break;
                case "Actualizar":

                    String nit_persona1 = request.getParameter("txtnit");
                    String rol1 = request.getParameter("txtrol");
                    String estado1 = request.getParameter("txtestado");
                    us.setNit_persona(nit_persona1);
                    us.setRol(rol1);
                    us.setEstado(estado1);
                    boolean edit = udao.edit(us);
                    if (edit == true) {
                        request.setAttribute("mensaje", "Usuario actualizado exitosamente.");
                        request.setAttribute("mensajeTipo", "exito");
                    } else {
                        request.setAttribute("mensaje", "El Usuario no se actualizo.");
                        request.setAttribute("mensajeTipo", "error");
                    }
                    request.getRequestDispatcher("EditarUsuarios.jsp").forward(request, response);
                    break;
                case "buscarPro":
                    String nitPersona = request.getParameter("txtnit");
                    Usuario usuario = udao.buscarPorNitN(nitPersona);
                    if (usuario != null) {
                        request.setAttribute("usuario", usuario);
                    } else {
                        request.setAttribute("mensaje", "El Usuario no existe");
                        request.setAttribute("mensajeTipo", "error");

                    }
                    request.getRequestDispatcher("AgregarUsuarios.jsp").forward(request, response);

                    break;

                case "eliminar":
                    idfila = Integer.parseInt(request.getParameter("nit_persona"));
                    udao.eliminar(idfila);
                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=listar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();

            }
            request.getRequestDispatcher("Usuarios.jsp").forward(request, response);

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void generarPDF(HttpServletResponse response, Muestra mu) throws IOException {
        // Establece el tipo de contenido a PDF
        response.setContentType("application/pdf");

        // Especifica que el contenido será descargable
        response.setHeader("Content-Disposition", "attachment; filename=etiqueta_muestra.pdf");

        // Generar el PDF
        try (OutputStream out = response.getOutputStream()) {
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Agregar contenido al PDF
            document.add(new Paragraph("Etiqueta de Muestra Generada"));
            document.add(new Paragraph("Contenido estático para probar el PDF."));

            // Cerrar el documento
            document.close();
            // Aquí no es necesario cerrar el OutputStream explícitamente, ya que se está manejando
            // dentro del try-with-resources y se cerrará automáticamente.

            System.out.println("PDF generado y enviado al cliente.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
