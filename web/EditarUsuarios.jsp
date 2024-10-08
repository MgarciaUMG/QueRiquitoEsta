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

        <h1 class="text-center">Agregar Usuario</h1>
        <div class="container mt-4" id="formulario-Usuarios">
            <div class="card-body">
                <form action="Controlador?menu=Usuarios" method="POST">
                    <div class="form-row">
                        <div class="form-group">
                            <label>Nit</label>
                            <input type="text" value="${usuario.getNit_persona()}" name="txtnit" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>Primer Nombre</label>
                            <input type="text" value="${usuario.getPrimer_nombre()}" name="txtpnombre" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>Segundo Nombre</label>
                            <input type="text" value="${usuario.getSegundo_nombre()}" name="txtsnombre" class="form-control" readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Primer Apellido</label>
                            <input type="text" value="${usuario.getPrimer_apellido()}" name="txtpapellido" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>Segundo Apellido</label>
                            <input type="text" value="${usuario.getSegundo_apellido()}"name="txtsapellido" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>Puesto</label>
                            <input type="text" value="${usuario.getPuesto()}" name="txtpuesto" class="form-control" readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Rol</label>
                            <select class="form-control" name="txtrol" id="opciones">
                                <option value="" disabled selected>Seleccione un Rol</option>
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
                            <input type="password" value="${usuario.getPassword()}" name="txtpassword" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <select class="form-control" name="txtestado" id="opciones">
                                <option value="" disabled selected>Seleccione un Estado</option>
                                <option value="Activo" ${usuario.getEstado().equals("Activo") ? "selected" : ""}>Activo</option>
                                <option value="Inactivo" ${usuario.getEstado().equals("Inactivo") ? "selected" : ""}>Inactivo</option>
                            </select>
                        </div>
                    </div>

                    
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-primary">
                    <button type="submit" name="accion" value="listar" class="btn btn-primary">Regresar</button>
                </form>
            </div>
        </div>

        <c:if test="${not empty mensaje}">
            <script>
                mostrarMensaje("${mensaje}", "${mensajeTipo}"); // Llama a la función para mostrar el mensaje
            </script>
        </c:if>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
