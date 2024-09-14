package Controlador;

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

                    break;

                case "Agregar":
                    int idSolicitud = Integer.parseInt(request.getParameter("txt"));
                    String tipoSolicitud = request.getParameter("txt");
                    String tipoEntidad = request.getParameter("txt");
                    Date fechaSolicitud = Date.valueOf(request.getParameter("txt"));
                    String tipoDocumento = request.getParameter("txt");
                    String numeroDocumento = request.getParameter("txt");
                    String nitProveedor = request.getParameter("txt");
                    String nombreProveedor = request.getParameter("txt");
                    String correoproveedor = request.getParameter("txt");
                    String correoSolicitante = request.getParameter("txt");
                    String direccionProveedor = request.getParameter("txt");
                    String telefonoProveedor = request.getParameter("txt");
                    String nitSolicitante = request.getParameter("txt");
                    String nombreSolicitante = request.getParameter("txt");
                    String noMuestra = request.getParameter("txt");
                    String descripcionProducto = request.getParameter("txt");

                    mu.setIdSolicitud(idSolicitud);
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
                    mdao.Agregarm(mu);
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

            request.getRequestDispatcher("RegistroSolicitudyMuestra.jsp").forward(request, response);

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
