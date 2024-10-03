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

        <div class="container mt-4" id="formulario-solicitud">
            <div class="card-body">
                <form action="Controlador?menu=BandejaLab" method="POST">
                    <div class="form-row">
                        <div class="form-group">
                            <label>ID Solicitud</label>
                            <input type="text" value="${muestra.getIdSolicitud()}" name="txtidsoli" class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label>Tipo de Solicitud</label>
                            <select class="form-control" name="txttiposoli" id="opcionessoli" onchange="habilitarnoMuestra()">
                                <option value="ConNumerodeMuestra" ${muestra.getTipoSolicitud().equals("ConNumerodeMuestra") ? "selected" : ""}>Con Numero de Muestra</option>
                                <option value="MuestraParaAnalisis" ${muestra.getTipoSolicitud().equals("MuestraParaAnalisis") ? "selected" : ""}>Muestra Para Análisis</option>
                                <option value="SolicitudSinMuestra" ${muestra.getTipoSolicitud().equals("SolicitudSinMuestra") ? "selected" : ""}>Solicitud sin Muestra</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Tipo de Entidad</label>
                            <select class="form-control" name="txttipoenti" id="opcionesenti">
                                <option value="Publica" ${muestra.getTipoEntidad().equals("Publica") ? "selected" : ""}>Publica</option>
                                <option value="Privada" ${muestra.getTipoEntidad().equals("Privada") ? "selected" : ""}>Privada</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Fecha de Solicitud</label>
                            <input type="text" value="${muestra.getFechaSolicitud()}" name="txtfechasoli" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Tipo de Documento</label>
                            <select class="form-control" name="txttipodocu" id="opcionesdocu">
                                <option value="NumerodeExpediente" ${muestra.getTipoDocumento().equals("NumerodeExpediente") ? "selected" : ""}>Número de Expediente</option>
                                <option value="HojadeTramite" ${muestra.getTipoDocumento().equals("HojadeTramite") ? "selected" : ""}>Hoja de Trámite</option>
                                <option value="Memorandum" ${muestra.getTipoDocumento().equals("Memorandum") ? "selected" : ""}>Memorándum</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Numero de Documento</label>
                            <input type="text" value="${muestra.getNumeroDocumento()}"name="txtnodocu" class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Nit Proveedor</label>
                            <input type="text" value="${muestra.getNitProveedor()}" name="txtnitpro" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre Proveedor</label>
                            <input type="text" value="${muestra.getNombreProveedor()}" name="txtnombrepro" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Correo Proveedor</label>
                            <input type="text" value="${muestra.getCorreoproveedor()}" name="txtcorreopro" class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Correo del Solicitante</label>
                            <input type="text" value="${muestra.getCorreoSolicitante()}" name="txtcorreosoli" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Dirección Proveedor</label>
                            <input type="text" value="${muestra.getDireccionProveedor()}" name="txtdirepro" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Telefono Proveedor</label>
                            <input type="text" value="${muestra.getTelefonoProveedor()}" name="txttelpro" class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Nit Solicitante</label>
                            <input type="text" value="${muestra.getNitSolicitante()}" name="txtnitsoli" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre Solicitante</label>
                            <input type="text" value="${muestra.getNombreSolicitante()}" name="txtnombresoli" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Numero Muestra</label>
                            <input type="text" value="${muestra.getNoMuestra()}" name="txtnomuestra" class="form-control"  id="nomuestra">
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Descripción del Producto</label>
                        <input type="text" value="${muestra.getDescripcionProducto()}" name="txtdesprodu" class="form-control">
                    </div>
            </div>


            <input type="submit" name="accion" value="Actualizar" id="btnActualizar" class="btn btn-success">
            <button type="submit" name="accion" value="listar" id="btnRegresar" class="btn btn-info">Regresar</button>
            </form>
        </div>


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
    </body>
</html>