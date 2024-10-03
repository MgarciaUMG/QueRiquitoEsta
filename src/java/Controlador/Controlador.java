package Controlador;

import Modelo.Entidad;
import Modelo.EntidadDAO;
import Modelo.Muestra;
import Modelo.MuestraDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controlador extends HttpServlet {

    Usuario us = new Usuario();
    UsuarioDAO udao = new UsuarioDAO();
    Muestra mu = new Muestra();
    MuestraDAO mdao = new MuestraDAO();
    Entidad en = new Entidad();
    EntidadDAO eDAO = new EntidadDAO();
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

            switch (accion) {

                case "listar":
                    List lista = mdao.listarm();
                    request.setAttribute("muestras", lista);
                    request.getRequestDispatcher("RegistroSolicitudyMuestra.jsp").forward(request, response);

                    break;

                case "buscarPro":
                    String nitEntidad = request.getParameter("txtnitpro");
                    Entidad enti = eDAO.buscarPorNit(nitEntidad);
                    request.setAttribute("entidad", enti);
                    request.getRequestDispatcher("Controlador?menu=BandejaLab&accion=listar").forward(request, response);
                    

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
                    boolean agregado = mdao.Agregarm(mu);
                    request.setAttribute("agregado", agregado);
                    request.getRequestDispatcher("Controlador?menu=BandejaLab&accion=listar").forward(request, response);
                    break;
                case "edit":
                    idfilam = Integer.parseInt(request.getParameter("idSolicitud"));
                    Muestra mus = mdao.listarIdm(idfilam);
                    request.setAttribute("muestra", mus);
                    request.getRequestDispatcher("DetalleSolicitudyMuestra.jsp").forward(request, response);
                    break;
                case "Actualizar":
                    int idSolicitud1 = Integer.parseInt(request.getParameter("txtidsoli"));
                    String tipoSolicitud1 = request.getParameter("txttiposoli");
                    String tipoEntidad1 = request.getParameter("txttipoenti");
                    Date fechaSolicitud1 = Date.valueOf(request.getParameter("txtfechasoli"));
                    String tipoDocumento1 = request.getParameter("txttipodocu");
                    String numeroDocumento1 = request.getParameter("txtnodocu");
                    String nitProveedor1 = request.getParameter("txtnitpro");
                    String nombreProveedor1 = request.getParameter("txtnombrepro");
                    String correoproveedor1 = request.getParameter("txtcorreopro");
                    String correoSolicitante1 = request.getParameter("txtcorreosoli");
                    String direccionProveedor1 = request.getParameter("txtdirepro");
                    String telefonoProveedor1 = request.getParameter("txttelpro");
                    String nitSolicitante1 = request.getParameter("txtnitsoli");
                    String nombreSolicitante1 = request.getParameter("txtnombresoli");
                    String noMuestra1 = request.getParameter("txtnomuestra");
                    String descripcionProducto1 = request.getParameter("txtdesprodu");
                    mu.setIdSolicitud(idSolicitud1);
                    mu.setTipoSolicitud(tipoSolicitud1);
                    mu.setTipoEntidad(tipoEntidad1);
                    mu.setFechaSolicitud(fechaSolicitud1);
                    mu.setTipoDocumento(tipoDocumento1);
                    mu.setNumeroDocumento(numeroDocumento1);
                    mu.setNitProveedor(nitProveedor1);
                    mu.setNombreProveedor(nombreProveedor1);
                    mu.setCorreoproveedor(correoproveedor1);
                    mu.setCorreoSolicitante(correoSolicitante1);
                    mu.setDireccionProveedor(direccionProveedor1);
                    mu.setTelefonoProveedor(telefonoProveedor1);
                    mu.setNitSolicitante(nitSolicitante1);
                    mu.setNombreSolicitante(nombreSolicitante1);
                    mu.setNoMuestra(noMuestra1);
                    mu.setDescripcionProducto(descripcionProducto1);
                    mdao.editm(mu);
                    request.getRequestDispatcher("Controlador?menu=BandejaLab&accion=listar").forward(request, response);
                    break;
                case "eliminar":
                    idfilam = Integer.parseInt(request.getParameter("idSolicitud"));
                    mdao.eliminarm(idfilam);
                    request.getRequestDispatcher("Controlador?menu=BandejaLab&accion=listar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();

            }

            // request.getRequestDispatcher("RegistroSolicitudyMuestra.jsp").forward(request, response);
        }

        if (menu.equals("ManteCata")) {
            EntidadDAO entidadDAO = new EntidadDAO();
            List<String> tiposEntidades = entidadDAO.obtenerTiposEntidades();
            switch (accion) {

                case "Buscar":
                    String nitEntidad = request.getParameter("txtnitenti");

                    String mensaje = entidadDAO.buscarYCopiarRegistro(nitEntidad);
                    if (mensaje == "Entidad agregada exitosamente.") {
                        request.setAttribute("mensaje", "Entidad agregada exitosamente.");
                        request.setAttribute("mensajeTipo", "exito");
                    } else if (mensaje == "El registro ya existe en las entidades.") {
                        request.setAttribute("mensaje", "El registro ya existe en las entidades.");
                        request.setAttribute("mensajeTipo", "error");
                    } else {
                        request.setAttribute("mensaje", "La entidad no existe.");
                        request.setAttribute("mensajeTipo", "error");

                    }

                    //request.setAttribute("tiposEntidades", tiposEntidades);
                    request.getRequestDispatcher("Controlador?menu=ManteCata&accion=Listar Entidades").forward(request, response);

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
                    int idEntidad = Integer.parseInt(request.getParameter("idEntidad"));
                    entidadDAO.eliminarEntidad(idEntidad);
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
                    udao.Agregar(us);
                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=listar").forward(request, response);
                    break;
                case "edit":
                    idfila = Integer.parseInt(request.getParameter("nit_persona"));
                    Usuario u = udao.listarId(idfila);
                    request.setAttribute("usuario", u);
                    request.setAttribute("editMode", true);
                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=listar").forward(request, response);
                    break;
                case "Actualizar":
                    String login1 = request.getParameter("txtlogin");
                    String nit_persona1 = request.getParameter("txtnit");
                    String primer_nombre1 = request.getParameter("txtpnombre");
                    String segundo_nombre1 = request.getParameter("txtsnombre");
                    String primer_apellido1 = request.getParameter("txtpapellido");
                    String segundo_apellido1 = request.getParameter("txtsapellido");
                    String puesto1 = request.getParameter("txtpuesto");
                    String rol1 = request.getParameter("txtrol");
                    String password1 = request.getParameter("txtpassword");
                    String estado1 = request.getParameter("txtestado");
                    us.setLogin(login1);
                    us.setNit_persona(String.valueOf(idfila));
                    us.setPrimer_nombre(primer_nombre1);
                    us.setSegundo_nombre(segundo_nombre1);
                    us.setPrimer_apellido(primer_apellido1);
                    us.setSegundo_apellido(segundo_apellido1);
                    us.setPuesto(puesto1);
                    us.setRol(rol1);
                    us.setPassword(password1);
                    us.setEstado(estado1);
                    udao.edit(us);
                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=listar").forward(request, response);
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

}
