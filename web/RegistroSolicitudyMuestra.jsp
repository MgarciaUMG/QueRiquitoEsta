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

            #formulario-solicitud {
                display: none; 
            }

        </style>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

    </head>
    <body>

        <div class="container mt-4" id="formulario-solicitud">
            <div class="card-body">
                <form action="Controlador?menu=BandejaLab" method="POST">
                    <div class="form-row">
                        <div class="form-group">
                            <label>ID Solicitud</label>
                            <input type="text" value="" name="txtidsoli" class="form-control" readonly>
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
                            <input type="text" value="${entidad.getTipoEntidad()}" name="txttipoenti" class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Fecha de Solicitud</label>
                            <input type="date" id="fechaSolicitud" name="txtfechasoli" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Tipo de Documento</label>
                            <select class="form-control" name="txttipodocu" id="opcionesdocu">
                                <option value="NumerodeExpediente" >Número de Expediente</option>
                                <option value="HojadeTramite" >Hoja de Trámite</option>
                                <option value="Memorandum">Memorándum</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Nit Proveedor</label>
                            <input type="text" value="${entidad.getNitEntidad()}" name="txtnitpro" class="form-control" id="nitProveedor">
                            <input type="submit" name="accion" value="buscarPro" class="btn btn-info" id="btnbuscarPro">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Nit Proveedor</label>
                            <input type="text" value="" name="txtnitpro2" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre Proveedor</label>
                            <input type="text" value="${entidad.getNombreEntidad()}" name="txtnombrepro" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Correo Proveedor</label>
                            <input type="text" value="" name="txtcorreopro" class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Correo del Solicitante</label>
                            <input type="text" value="" name="txtcorreosoli" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Dirección Proveedor</label>
                            <input type="text" value="" name="txtdirepro" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Telefono Proveedor</label>
                            <input type="text" value="" name="txttelpro" class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Nit Solicitante</label>
                            <input type="text" value="" name="txtnitsoli" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre Solicitante</label>
                            <input type="text" value="" name="txtnombresoli" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Numero Muestra</label>
                            <input type="text" value="" name="txtnomuestra" class="form-control"  id="nomuestra">
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Descripción del Producto</label>
                        <input type="text" value="" name="txtdesprodu" class="form-control">
                    </div>
            </div>


            <input type="submit" name="accion" value="Agregar" class="btn btn-info" id="btnAgregar">
            </form>
        </div>

        <div>
            <div class="container mt-4">
                <h1 class="text-center">Muestras</h1>
                <div class="container mt-4 text-center">
                    <div class="d-flex justify-content-start">
                        <button class="btn btn-primary" id="nuevaSolicitudBtn">Nueva Solicitud</button>
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
                                <td class="text-center">
                                    <a class="btn btn-info" href="Controlador?menu=BandejaLab&accion=edit&idSolicitud=${mu.getIdSolicitud()}">
                                        <i class="fas fa-eye"></i> Ver y Editar
                                    </a>
                                    <a class="btn btn-danger" href="Controlador?menu=BandejaLab&accion=eliminar&idSolicitud=${mu.getIdSolicitud()}">Remove</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <c:if test="${not empty agregado}">
            <script>
                $(document).ready(function () {
                    if (${agregado}) { // Si el valor es true
                        $('form')[0].reset();  // Limpiar el formulario
                        $('#formulario-solicitud').slideUp(); // Opcional: ocultar el formulario
                    }
                });
            </script>
        </c:if>

        <script>
            window.onload = function () {
                var fechaSolicitudInput = document.getElementById("fechaSolicitud");
                var hoy = new Date();
                var año = hoy.getFullYear();
                var mes = ("0" + (hoy.getMonth() + 1)).slice(-2);
                var dia = ("0" + hoy.getDate()).slice(-2);
                fechaSolicitudInput.value = año + "-" + mes + "-" + dia;
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
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script>
        <script>

            $(document).ready(function () {
                $('#nuevaSolicitudBtn').click(function () {
                    $('#formulario-solicitud').slideToggle();
                });

                $('#buscarProveedorBtn').click(function (event) {
                    event.stopPropagation(); // Evita que el evento de clic se propague
                    // Aquí puedes agregar la lógica para buscar el proveedor
                    // Por ejemplo, puedes hacer una llamada AJAX para buscar el proveedor
                    alert("Buscar Proveedor clickeado"); // Esto es solo un ejemplo
                });

            });
        </script>
    </body>
</html>