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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

    </head>
    <body>
        <div>
            <div class="container mt-4">
                <h1 class="text-center">Muestras</h1>
                <div class="container mt-4 text-center">
                    <div class="d-flex justify-content-start">
                        <a class="btn btn-primary" href="Controlador?menu=BandejaLab&accion=Nuevo">Nueva Solicitud</a>
                    </div>
                </div>

                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="text-center">Id Muestra</th>
                            <th class="text-center">Tipo de Solicitud</th>
                            <th class="text-center">Tipo de Entidad</th>
                            <th class="text-center">Fecha de Registro</th>
                            <th class="text-center">Nombre del Proveedor</th>
                            <th class="text-center">Numero de Muestra</th>
                            <th class="text-center">Descripción</th>
                            <th class="text-center">Analista</th>
                            <th class="text-center">Estado</th>
                            <th class="text-center">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="mu" items="${muestras}">
                            <tr>
                                <td class="text-center">${mu.getIdSolicitud()}</td>
                                <td class="text-center">${mu.getTipoSolicitud()}</td>
                                <td class="text-center">${mu.getTipoEntidad()}</td>
                                <td class="text-center">${mu.getFechaSolicitud()}</td>
                                <td class="text-center">${mu.getNombreProveedor()}</td>
                                <td class="text-center">${mu.getNoMuestra()}</td>
                                <td class="text-center">${mu.getDescripcionProducto()}</td>
                                <td class="text-center">${mu.getAnalistaAsignado()}</td>
                                <td class="text-center">${mu.getEstadoSolicitud()}</td>
                                <td class="text-center">
                                    <a class="btn btn-primary" href="Controlador?menu=BandejaLab&accion=edit&idSolicitud=${mu.getIdSolicitud()}">
                                        <i class="fas fa-eye"></i> Ver
                                    </a>
                                    <a class="btn btn-danger" href="Controlador?menu=BandejaLab&accion=eliminar&idSolicitud=${mu.getIdSolicitud()}">Remove</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script>
    </body>
</html>