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

        <div class="container mt-4" id="formulario-nuevasolicitud">
            <div class="card-body">
                <form action="Controlador?menu=BandejaLab" method="POST">
                    <div class="form-row">
                        <div class="form-group">
                            <label>ID Solicitud</label>
                            <input type="text" value="" name="txtidsoli" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>Nit Proveedor</label>
                            <input type="text" value="${entidad != null ? entidad.getNitEntidad() : param.txtnitpro}" name="txtnitpro" class="form-control" id="nitProveedor">
                            <button type="submit" name="accion" value="buscarPro" class="btn btn-info" id="btnbuscarPro">Buscar Proveedor</button>
                        </div>
                        <div class="form-group">
                            <label>Tipo de Entidad</label>
                            <input type="text" value="${entidad != null ? entidad.getTipoEntidad() : param.txttipoenti}" name="txttipoenti" class="form-control" readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Nombre Proveedor</label>
                            <input type="text" value="${entidad != null ? entidad.getNombreEntidad() : param.txtnombrepro}" name="txtnombrepro" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>Correo Proveedor</label>
                            <input type="text" value="${entidad != null ? entidad.getCorreoEntidad() : param.txtcorreopro}" name="txtcorreopro" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>Dirección Proveedor</label>
                            <input type="text" value="${entidad != null ? entidad.getDireccionEntidad() : param.txtdirepro}" name="txtdirepro" class="form-control" readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Telefono Proveedor</label>
                            <input type="text" value="${entidad != null ? entidad.getTelefonoEntidad() : param.txttelpro}" name="txttelpro" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>Fecha de Solicitud</label>
                            <input type="date" value="${fechaActual != null ? fechaActual : param.txtfechasoli}" id="fechaSolicitud" name="txtfechasoli" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>Nit Solicitante</label>
                            <input type="text" value="${solicitante != null ? solicitante.getNitSolicitante() : param.txtnitsoli}" name="txtnitsoli" class="form-control">
                            <button type="submit" name="accion" value="buscarSoli" class="btn btn-info" id="btnbuscarPro">Buscar Solicitante</button>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Correo del Solicitante</label>
                            <input type="text" value="${solicitante != null ? solicitante.getCorreoSolicitante() : param.txtcorreosoli}" name="txtcorreosoli" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre Solicitante</label>
                            <input type="text" value="${solicitante != null ? solicitante.getNombreSolicitante() : param.txtnombresoli}" name="txtnombresoli" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>Tipo de Documento</label>
                            <select class="form-control" name="txttipodocu" id="opcionesdocu">
                                <option value="" disabled ${empty param.txttipodocu ? 'selected' : ''}>Seleccione un tipo de Documento</option>
                                <option value="NumerodeExpediente" ${param.txttipodocu == 'NumerodeExpediente' ? 'selected' : ''}>Número de Expediente</option>
                                <option value="HojadeTramite" ${param.txttipodocu == 'HojadeTramite' ? 'selected' : ''}>Hoja de Trámite</option>
                                <option value="Memorandum" ${param.txttipodocu == 'Memorandum' ? 'selected' : ''}>Memorándum</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">

                        <div class="form-group">
                            <label>Numero de Documento</label>
                            <input type="text" value="${param.txtnodocu}" name="txtnodocu" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Tipo de Solicitud</label>
                            <select class="form-control" name="txttiposoli" id="opcionessoli" onchange="habilitarnoMuestra()">
                                <option value="" disabled ${empty param.txttipodocu ? 'selected' : ''}>Seleccione un tipo de Solicitud</option>
                                <option value="ConNumerodeMuestra" ${param.txttiposoli == 'ConNumerodeMuestra' ? 'selected' : ''}>Con Numero de Muestra</option>
                                <option value="MuestraParaAnalisis" ${param.txttiposoli == 'MuestraParaAnalisis' ? 'selected' : ''}>Muestra Para Análisis</option>
                                <option value="SolicitudSinMuestra" ${param.txttiposoli == 'SolicitudSinMuestra' ? 'selected' : ''}>Solicitud sin Muestra</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Numero Muestra</label>
                            <input type="text" value="${param.txtnomuestra}" name="txtnomuestra" class="form-control" id="nomuestra">
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Descripción del Producto</label>
                        <input type="text" value="${param.txtdesprodu}" name="txtdesprodu" class="form-control">
                    </div>
            </div>






            <input type="button" name="accion" value="Continuar" class="btn btn-primary" id="btnContinuar" onclick="validarFormulario()">


            <div class="form-group mt-3">
                <label>Seleccionar Analista para la Solicitud</label>
                <select id="usuarios" name="usuarioSeleccionado" class="form-control" disabled>
                    <option value="" disabled ${empty param.usuarioSeleccionado ? 'selected' : ''}>Seleccione un usuario</option>
                    <c:forEach var="usuario" items="${usuarios}">
                        <option value="${usuario.getPrimer_nombre()} ${usuario.getPrimer_apellido()}">
                            ${usuario.getPrimer_nombre()} ${usuario.getPrimer_apellido()}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <input type="submit" name="accion" value="Agregar" class="btn btn-primary" id="btnAgregar">



            </form>
        </div>
        <c:if test="${not empty mensaje}">
            <script>
                mostrarMensaje("${mensaje}", "${mensajeTipo}"); // Llama a la función para mostrar el mensaje
            </script>
        </c:if>
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

            function validarFormulario() {
                var nitProveedor = document.getElementById("nitProveedor").value.trim();
                var nitSolicitante = document.getElementsByName("txtnitsoli")[0].value.trim();
                var tipoDocumento = document.getElementById("opcionesdocu").value;
                var noDocumento = document.getElementsByName("txtnodocu")[0].value.trim();
                var tipoSolicitud = document.getElementById("opcionessoli").value;
                var descripcionProducto = document.getElementsByName("txtdesprodu")[0].value.trim();

                var mensajeError = "";


                if (!nitProveedor) {
                    mensajeError += "El NIT del proveedor es requerido. \n";
                }


                if (!nitSolicitante) {
                    mensajeError += "El NIT del solicitante es requerido. \n";
                }


                if (!noDocumento) {
                    mensajeError += "El Numero de documento es requerido. \n";
                }

                if (!tipoDocumento) {
                    mensajeError += "El tipo de documento es requerido. \n";
                }


                if (!tipoSolicitud) {
                    mensajeError += "El tipo de solicitud es requerido. \n";
                }


                if (!descripcionProducto) {
                    mensajeError += "La descripción del producto es requerida. \n"; // Agrega el mensaje de error
                }


                if (mensajeError) {
                    mostrarMensaje(mensajeError.trim(), "error");
                    return;
                }


                document.getElementById("usuarios").disabled = false;
            }



        </script>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script>
    </body>
</html>