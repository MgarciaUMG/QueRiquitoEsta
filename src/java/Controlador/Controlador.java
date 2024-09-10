package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controlador extends HttpServlet {

    Usuario us = new Usuario();
    UsuarioDAO udao = new UsuarioDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);

        }
        
        if (menu.equals("BandejaAnalista")) {
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
                    us.setLogin(login);
                    us.setNit_persona(nit_persona);
                    us.setPrimer_nombre(primer_nombre);
                    us.setSegundo_nombre(segundo_nombre);
                    us.setPrimer_apellido(primer_apellido);
                    us.setSegundo_apellido(segundo_apellido);
                    us.setPuesto(puesto);
                    us.setRol(rol);
                    us.setPassword(password);
                    udao.Agregar(us);
                    request.getRequestDispatcher("Controlador?menu=BandejaAnalista&accion=listar").forward(request, response);
                    break;
                case "edit":
                    

                    break;
                case "eliminar":

                    break;

                default:
                    throw new AssertionError();

            }
            request.getRequestDispatcher("BandejaAnalista.jsp").forward(request, response);

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
