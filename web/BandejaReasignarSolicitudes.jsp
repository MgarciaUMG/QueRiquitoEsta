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

            .input-error {
                border: 2px solid red; /* Resaltar borde en rojo */
            }
        </style>
        <script>
            function mostrarMensaje(mensaje, tipo) {
                var mensajeDiv = document.getElementById("mensajeDiv");
                var mensajeTexto = document.getElementById("mensajeTexto");

                mensajeTexto.innerText = mensaje; // Asigna el mensaje al div

                // Cambia el estilo del div según el tipo de mensaje
                if (tipo === "exito") {
                    mensajeDiv.style.display = "block"; // Muestra el div
                    mensajeDiv.style.border = "1px solid green";
                    mensajeDiv.style.backgroundColor = "#d4edda"; // Verde claro
                    mensajeDiv.style.color = "#155724"; // Texto verde oscuro
                } else if (tipo === "error") {
                    mensajeDiv.style.display = "block"; // Muestra el div
                    mensajeDiv.style.border = "1px solid red";
                    mensajeDiv.style.backgroundColor = "#f8d7da"; // Rojo claro
                    mensajeDiv.style.color = "#721c24"; // Texto rojo oscuro
                }
            }
        </script>

    </head>
    <body>
        <div id="mensajeDiv" style="${not empty mensaje ? 'display:block;' : 'display:none;'}; padding: 10px; margin-bottom: 15px;" class="${mensajeTipo == 'error' ? 'alert alert-danger' : 'alert alert-success'}">
            <span id="mensajeTexto">${mensaje}</span>
        </div>

        <div>
            <div class="container mt-4">
                <h1 class="text-center">Reasignar Solicitudes</h1>
                <form action="Controlador?menu=Reasignar" method="POST">
                    <div class="form-row">
                        <div class="form-group">
                            <label>Numero de Muestra</label>
                            <input type="text" value="" name="txtnomuestra" class="form-control" id="nomuestra">
                            <br>
                            <button type="submit" name="accion" value="BuscarMuestra" class="btn btn-info" id="btnnomuestra">Buscar</button>
                        </div>
                    </div>
                </form>
                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="text-center">Id Muestra</th>
                            <th class="text-center">Nombre del Proveedor</th>
                            <th class="text-center">Nit del Proveedor</th>
                            <th class="text-center">Nit del Solicitante</th>
                            <th class="text-center">Nombre del Solicitante</th>
                            <th class="text-center" style="width: 400px;">Analista</th>
                            <th class="text-center">Estado</th>
                            <th class="text-center">Tipo de Solicitud</th>
                            <!--<th class="text-center">Rol</th>-->
                            <th class="text-center">Acciones</th>


                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="text-center">${muestra.getIdSolicitud()}</td>
                            <td class="text-center">${muestra.getNombreProveedor()}</td>
                            <td class="text-center">${muestra.getNitProveedor()}</td>
                            <td class="text-center">${muestra.getNitSolicitante()}</td>
                            <td class="text-center">${muestra.getNombreSolicitante()}</td>
                            <td class="text-center">

                                <form method="POST" action="Controlador?menu=Reasignar&accion=actualizaranalista">
                                    <input type="hidden" name="idSolicitud" value="${muestra.getIdSolicitud()}">
                                    <input type="hidden" name="txtmotivo" value="${motivo != null ? motivo : param.txtmotivo}"/>
                                    <input type="hidden" name="txtestado" value="${estado != null ? estado : param.txtestado}">
                                    <div class="form-group">
                                        <label>Analista Actual</label>
                                        <input type="text" id="idanalista" value="${muestra.getAnalistaAsignado()}" name="txtidanalista" class="form-control" readonly>
                                        <label>Nuevo Analista</label>
                                        <select id="usuarios" name="usuarioSeleccionado" class="form-control" onchange="asignarCorreo()">
                                            <option value="" disabled ${empty param.usuarioSeleccionado ? 'selected' : ''}>Seleccione un usuario</option>
                                            <c:forEach var="usuario" items="${usuarios}">
                                                <option value="${usuario.getIdpersona()}" data-correo="${usuario.getCorreo()}" data-ana="${usuario.getPrimer_nombre()} ${usuario.getPrimer_apellido()}">
                                                    ${usuario.getPrimer_nombre()} ${usuario.getPrimer_apellido()}
                                                </option>
                                            </c:forEach>
                                        </select>
                                        <input type="hidden" name="CorreonA" id="correoInput" value="">
                                        <input type="hidden" name="NuevoA" id="NanalistaInput" value="">
                                    </div>
                                    <button type="submit" class="btn btn-success mt-2">Reasignar</button>
                                </form>
                            </td>
                            <td class="text-center">${muestra.getEstadoSolicitud()}</td>
                            <td class="text-center">${muestra.getTipoSolicitud()}</td>
                            <!--<td class="text-center">Analista de Laboratorio</td>-->
                            <td class="text-center">
                                <a class="btn btn-primary" href="Controlador?menu=Reasignar&accion=Nuevo">Nueva Solicitud</a>
                                <br><br>
                                <a class="btn btn-primary" href="Controlador?menu=Reasignar&accion=edit&idSolicitud=${muestra.getIdSolicitud()}">
                                    <i class="fas fa-eye"></i> Ver
                                </a>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <input type="hidden" name="nitusuario" value="${usuario.getNit_persona()}">
                <a class="btn btn-primary" href="Controlador?menu=Inicio">Regresar</a>
            </div>
        </div>
        <c:if test="${not empty mensaje}">
            <script>
                mostrarMensaje("${mensaje}", "${mensajeTipo}"); // Llama a la función para mostrar el mensaje
            </script>
        </c:if>
        <script>
            function asignarCorreo() {
                var selectElement = document.getElementById("usuarios");
                var correoInput = document.getElementById("correoInput");
                var analistaInput = document.getElementById("NanalistaInput");

                // Obtener la opción seleccionada
                var selectedOption = selectElement.options[selectElement.selectedIndex];

                // Verificar que se haya seleccionado una opción válida
                if (selectedOption && selectedOption.dataset.correo) {
                    // Asignar el correo al input
                    correoInput.value = selectedOption.dataset.correo;
                    analistaInput.value = selectedOption.dataset.ana;
                } else {
                    // Si no hay una opción válida, limpiar el input
                    correoInput.value = '';
                    analistaInput.value = '';
                }
            }
        </script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script>
    </body>
</html>