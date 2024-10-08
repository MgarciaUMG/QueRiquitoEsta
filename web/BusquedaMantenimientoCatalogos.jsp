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

        <div id="mensajeDiv" style="display:none; padding: 10px; margin-bottom: 15px;">
            <span id="mensajeTexto"></span>
        </div>


        <div>
            <div class="container mt-4">
                <h1 class="text-center">Agregar Entidad</h1>

                <div class="container mt-4" id="busqueda-entidad">
                    <div class="card-body">
                        <form action="Controlador?menu=ManteCata" method="POST">
                            <div class="form-row">
                                <div class="form-group">
                                    <label>Nit Entidad</label>
                                    <input type="hidden" name="txtidenti" value="${entidad.getIdEntidad()}" class="form-control">
                                    <input type="hidden" name="txtcorreoenti" value="${entidad.getCorreoEntidad()}" class="form-control">
                                    <input type="hidden" name="txtdireenti" value="${entidad.getDireccionEntidad()}" class="form-control">
                                    <input type="hidden" name="txttelenti" value="${entidad.getTelefonoEntidad()}" class="form-control">
                                    <input type="text" name="txtnitenti" value="${entidad.getNitEntidad()}" placeholder="Ingrese Nit Entidad" class="form-control" required="">
                                </div>
                                <div class="form-group">
                                    <label>Nombre Entidad</label>
                                    <input type="text" name="txtnombreenti" value="${entidad.getNombreEntidad()}" placeholder=" " class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Tipo Entidad</label>
                                    <select class="form-control" id="tipoEntidad" name="tipoEntidad">
                                        <option value="" disabled selected>Seleccione un tipo de entidad</option>
                                        <option value="Publica">Pública</option>
                                        <option value="Privada">Privada</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" name="accion" value="buscarPro" class="btn btn-primary" id="btnbuscarEnti" onclick="habilitarGuardar()">Buscar Entidad</button>
                                <button type="submit" name="accion" value="Guardar" class="btn btn-primary" id="btnguardarEnti" ${habilitarGuardar ? '' : 'disabled'}>Guardar Entidad</button>
                                <a href="Controlador?menu=ManteCata&accion=Listar Entidades" class="btn btn-primary" id="cancelarEntidadBtn">Cancelar</a>
                            </div>
                        </form>
                    </div>
                </div>


            </div>
        </div>

        <c:if test="${not empty mensaje}">
            <script>
                mostrarMensaje("${mensaje}", "${mensajeTipo}"); // Llama a la función para mostrar el mensaje
            </script>
        </c:if>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script>
        <script>
                function habilitarGuardar() {
                    document.getElementById('btnguardarEnti').disabled = false;
                }
        </script>
    </body>
</html>