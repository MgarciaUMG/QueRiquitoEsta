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
        <style>

            .form-row {
                display: flex;
                flex-wrap: wrap;
                justify-content: space-between;
            }

            .form-group {
                flex: 0 0 32%; /* Cada div ocupará el 48% del ancho, con espacio entre ellos */
                margin-bottom: 15px;
            }
        </style>
    </head>
    <body>

        <div class="container mt-4" id="formulario-Usuarios">
            <div class="card-body">
                <form action="Controlador?menu=Usuarios" method="POST">
                    <div class="form-row">
                        <div class="form-group">
                            <label>Nit</label>
                            <input type="text" value="${usuario.getNit_persona()}" name="txtnit" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Primer Nombre</label>
                            <input type="text" value="${usuario.getPrimer_nombre()}" name="txtpnombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Segundo Nombre</label>
                            <input type="text" value="${usuario.getSegundo_nombre()}" name="txtsnombre" class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Primer Apellido</label>
                            <input type="text" value="${usuario.getPrimer_apellido()}" name="txtpapellido" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Segundo Apellido</label>
                            <input type="text" value="${usuario.getSegundo_apellido()}"name="txtsapellido" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Puesto</label>
                            <input type="text" value="${usuario.getPuesto()}" name="txtpuesto" class="form-control">
                        </div>
                    </div>
                    <!-- <div class="form-group">
                         <label>Rol</label>
                         <input type="text" value="" name="txtrol" class="form-control">
                     </div>-->
                    <div class="form-row">
                        <div class="form-group">
                            <label>Rol</label>
                            <select class="form-control" name="txtrol" id="opciones">
                                <option value="2" ${usuario.getRol().equals("2") ? "selected" : ""}>Registro Muestras</option>
                                <option value="3" ${usuario.getRol().equals("3") ? "selected" : ""}>Analista de Laboratorio</option>
                                <option value="4" ${usuario.getRol().equals("4") ? "selected" : ""}>Almacenamiento de Muestra</option>
                                <option value="5" ${usuario.getRol().equals("5") ? "selected" : ""}>Supervisor de Laboratorio</option>
                                <option value="6" ${usuario.getRol().equals("6") ? "selected" : ""}>Jefe Unidad Laboratorio</option>
                                <option value="7" ${usuario.getRol().equals("7") ? "selected" : ""}>Laboratorio Externo</option>
                                <option value="8" ${usuario.getRol().equals("8") ? "selected" : ""}>Reportes</option>
                                <option value="9" ${usuario.getRol().equals("9") ? "selected" : ""}>Visualización de Documentos</option>
                                <option value="1" ${usuario.getRol().equals("1") ? "selected" : ""}>Administrador</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" value="${usuario.getPassword()}" name="txtpassword" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <select class="form-control" name="txtestado" id="opciones">
                                <option value="Activo" ${usuario.getEstado().equals("Activo") ? "selected" : ""}>Activo</option>
                                <option value="Inactivo" ${usuario.getEstado().equals("Inactivo") ? "selected" : ""}>Inactivo</option>
                            </select>
                        </div>
                    </div>

                    <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success"
                           <% if (request.getAttribute("editMode") == null || !(Boolean) request.getAttribute("editMode")) { %>
                           disabled
                           <% }%>
                           >
                </form>
            </div>
        </div>
        <div class="container mt-4">
            <h1 class="text-center">Usuarios</h1>
            <br><br>
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
                            <td class="text-center">${us.getRol()}</td>
                            <td class="text-center">${us.getEstado()}</td>
                            <td class="text-center">
                                <a class="btn btn-info" href="Controlador?menu=Usuarios&accion=edit&nit_persona=${us.getNit_persona()}" onclick="habilitarActualizar()">Editar</a>
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
