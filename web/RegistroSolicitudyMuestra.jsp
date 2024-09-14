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
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Usuarios" method="POST">
                        <div class="form-group">
                            <label>ID Solicitud</label>
                            <input type="text" value="${usuario.getNit_persona()}" name="txtidsoli" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Tipo de Solicitud</label>
                            <select class="form-control" name="txttiposoli" id="opcionessoli" onchange="habilitarnoMuestra()">
                                <option value="ConNumerodeMuestra">Con Numero de Muestra</option>
                                <option value="MuestraParaAnalisis">Muestra Para Análisis</option>
                                <option value="SolicitudSinMuestra">Solicitud sin Muestra</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Tipo de Entidad</label>
                            <select class="form-control" name="txttipoenti" id="opcionesenti">
                                <option value="Publica">Publica</option>
                                <option value="Privada">Privada</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Fecha de Solicitud</label>
                            <input type="text" value="${usuario.getSegundo_nombre()}" name="txtfechasoli" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Tipo de Documento</label>
                            <select class="form-control" name="txttipodocu" id="opcionesdocu">
                                <option value="NumerodeExpediente">Número de Expediente</option>
                                <option value="HojadeTramite">Hoja de Trámite</option>
                                <option value="Memorandum">Memorándum</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Numero de Documento</label>
                            <input type="text" value="${usuario.getSegundo_apellido()}"name="txtnodocu" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nit Proveedor</label>
                            <input type="text" value="${usuario.getPuesto()}" name="txtnitpro" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre Proveedor</label>
                            <input type="text" value="${usuario.getPuesto()}" name="txtnombrepro" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Correo Proveedor</label>
                            <input type="text" value="${usuario.getPuesto()}" name="txtcorreopro" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Correo del Solicitante</label>
                            <input type="text" value="${usuario.getPuesto()}" name="txtcorreosoli" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Dirección Proveedor</label>
                            <input type="text" value="${usuario.getPuesto()}" name="txtdirepro" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Telefono Proveedor</label>
                            <input type="text" value="${usuario.getPuesto()}" name="txttelpro" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nit Solicitante</label>
                            <input type="text" value="${usuario.getPuesto()}" name="txtnitsoli" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre Solicitante</label>
                            <input type="text" value="${usuario.getPuesto()}" name="txtnombresoli" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Numero Muestra</label>
                            <input type="text" value="${usuario.getPuesto()}" name="txtnomuestra" class="form-control"  id="nomuestra">
                        </div>
                        <div class="form-group">
                            <label>Descripción del Producto</label>
                            <input type="text" value="${usuario.getPuesto()}" name="txtdesprodu" class="form-control">
                        </div>


                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" id="btnActualizar" class="btn btn-success"
                               <% if (request.getAttribute("editMode") == null || !(Boolean) request.getAttribute("editMode")) { %>
                               disabled
                               <% }%>
                               >
                    </form>
                </div>
            </div>
            <div class="container mt-4">
                <h1 class="text-center">Muestras</h1>
                <br><br>
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
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="us" items="${muestras}">
                            <tr>
                                <td class="text-center">${us.getLogin()}</td>
                                <td class="text-center">${us.getNit_persona()}</td>
                                <td class="text-center">${us.getPrimer_nombre()}</td>
                                <td class="text-center">${us.getSegundo_nombre()}</td>
                                <td class="text-center">${us.getPrimer_apellido()}</td>
                                <td class="text-center">${us.getSegundo_apellido()}</td>
                                <td class="text-center">${us.getPuesto()}</td>
                                <td class="text-center">${us.getRol()}</td>
                                <td class="text-center">${us.getPassword()}</td>

                                <td>${us.getEstado()}</td>
                                <td class="text-center">
                                    <a class="btn btn-info" href="Controlador?menu=Usuarios&accion=edit&nit_persona=${us.getNit_persona()}" onclick="habilitarActualizar()">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Usuarios&accion=eliminar&nit_persona=${us.getNit_persona()}">Remove</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>



        <script>
            function habilitarActualizar() {
                document.getElementById("btnActualizar").disabled = false;
            }
        </script>
        <script>
            function habilitarnoMuestra() {
                var seleccion = document.getElementById("opcionessoli").value;
                var campoNumeroMuestra = document.getElementById("nomuestra");

                if (seleccion === "ConNumerodeMuestra") {
                    campoNumeroMuestra.disabled = false;
                } else {
                    campoNumeroMuestra.disabled = true;
                }
            }
        </script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>