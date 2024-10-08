<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.UsuarioDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Que Riquito Está</title>
    </head>
    <body>
        <div class="container mt-4">
            <h1 class="text-center">Usuarios</h1>
            <br><br>
            <a class="btn btn-primary" href="Controlador?menu=Usuarios&accion=Nuevo">Agregar Usuario</a>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Login</th>
                        <th class="text-center">Nit</th>
                        <th class="text-center">Primer Nombre</th>
                        <th class="text-center">Segundo Nombre</th>
                        <th class="text-center">Primer Apellido</th>
                        <th class="text-center">Segundo Apellido</th>
                        <th class="text-center">Puesto</th>
                        <th class="text-center">Rol</th>
                        <th class="text-center">Estado</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="us" items="${usuarios}">
                        <tr>
                            <td class="text-center">${us.getLogin()}</td>
                            <td class="text-center">${us.getNit_persona()}</td>
                            <td class="text-center">${us.getPrimer_nombre()}</td>
                            <td class="text-center">${us.getSegundo_nombre()}</td>
                            <td class="text-center">${us.getPrimer_apellido()}</td>
                            <td class="text-center">${us.getSegundo_apellido()}</td>
                            <td class="text-center">${us.getPuesto()}</td>
                            <td class="text-center">
                                <c:choose>
                                    <c:when test="${us.getRol() == '1'}">Administrador</c:when>
                                    <c:when test="${us.getRol() == '2'}">Registro Muestras</c:when>
                                    <c:when test="${us.getRol() == '3'}">Analista de Laboratorio</c:when>
                                    <c:when test="${us.getRol() == '4'}">Almacenamiento de Muestra</c:when>
                                    <c:when test="${us.getRol() == '5'}">Supervisor de Laboratorio</c:when>
                                    <c:when test="${us.getRol() == '6'}">Jefe Unidad Laboratorio</c:when>
                                    <c:when test="${us.getRol() == '7'}">Laboratorio Externo</c:when>
                                    <c:when test="${us.getRol() == '8'}">Reportes</c:when>
                                    <c:when test="${us.getRol() == '9'}">Visualización de Documentos</c:when>
                                    <c:otherwise>Rol desconocido</c:otherwise>
                                </c:choose>
                            </td>
                            <td class="text-center">${us.getEstado()}</td>
                            <td class="text-center">
                                <a class="btn btn-info" href="Controlador?menu=Usuarios&accion=edit&nit_persona=${us.getNit_persona()}" >Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Usuarios&accion=eliminar&nit_persona=${us.getNit_persona()}">Remove</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>




        <script>
            function habilitarActualizar() {
                document.getElementById("btnActualizar").disabled = false;
            }
        </script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
