<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <div class="container-fluid">
                <div class="d-flex w-100"> 
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Inicio" target="myFrame">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <div class="ml-auto">
                                <div class="dropdown">
                                    <button style="margin-left: 10px; border: none;" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Servicios
                                    </button>
                                    <div class="dropdown-menu text-center">
                                        <a class="dropdown-item" href="Controlador?menu=Visualizar&accion=Nuevo" target="myFrame">Visualización de solicitudes</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="Controlador?menu=BandejaLab&accion=listar" target="myFrame">Bandeja Laboratorio</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="Controlador?menu=ManteCata&accion=Listar Entidades" target="myFrame">Mantenimiento Catalogos</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="Controlador?menu=Reasignar&accion=Nuevo" target="myFrame">Reasignación de Solicitudes</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="Controlador?menu=Usuarios&accion=listar" target="myFrame">Mantenimiento Usuarios</a>
                                    </div>
                                </div>
                            </div>
                        </li>
                       <!-- <li class="nav-item">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Usuarios&accion=listar" target="myFrame">Administración</a>
                        </li>-->
                    </ul>
                    <div class="ml-auto">
                        <div class="dropdown">
                            <button style="border: none;" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ${usuario.getPrimer_nombre()} ${usuario.getPrimer_apellido()}
                            </button>
                            <div class="dropdown-menu text-center">
                                <a class="dropdown-item" href="#">
                                    <img src="imagenes/user.png" alt="60" width="60"/>
                                </a>
                                <a class="dropdown-item" href="#">${usuario.getLogin()}</a>
                                <a class="dropdown-item" href="#">
                                    <c:choose>
                                        <c:when test="${usuario.getRol() == '1'}">Administrador</c:when>
                                        <c:when test="${usuario.getRol() == '2'}">Registro Muestras</c:when>
                                        <c:when test="${usuario.getRol() == '3'}">Analista de Laboratorio</c:when>
                                        <c:when test="${usuario.getRol() == '4'}">Almacenamiento de Muestra</c:when>
                                        <c:when test="${usuario.getRol() == '5'}">Supervisor de Laboratorio</c:when>
                                        <c:when test="${usuario.getRol() == '6'}">Jefe Unidad Laboratorio</c:when>
                                        <c:when test="${usuario.getRol() == '7'}">Laboratorio Externo</c:when>
                                        <c:when test="${usuario.getRol() == '8'}">Reportes</c:when>
                                        <c:when test="${usuario.getRol() == '9'}">Visualización de Documentos</c:when>
                                        <c:otherwise>Rol no asignado</c:otherwise>
                                    </c:choose>
                                </a>
                                <div class="dropdown-divider"></div>
                                <form accion="Validar" method="POST">
                                    <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </nav>

        <div class="m-4" style="height: 870px;">

            <iframe name="myFrame" style="height: 100%; width: 100%; border: none" 
                    srcdoc='<img src="imagenes/logo1.png" alt="Imagen por defecto" style="max-width: 100%; max-height: 100%; display: block; margin: auto;">'>
            </iframe>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
