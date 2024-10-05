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

        <div>
            <div class="container mt-4">
                <h1 class="text-center">Entidades</h1>
                <form action="Controlador?menu=ManteCata" method="POST">
                    <div class="container mt-4 text-center">
                        <div>
                            <label>Tipo de Entidad</label>
                            <select class="form-control" id="tipoEntidad" name="tipoEntidad">
                                <c:forEach var="tipo" items="${tiposEntidades}">
                                    <option value="${tipo}">${tipo}</option>
                                </c:forEach>
                            </select>
                            <br>
                            <input type="submit" name="accion" value="Listar Entidades" class="btn btn-primary" id="btnlistarEnti">
                        </div>
                    </div>
                </form>

                <a href="BusquedaMantenimientoCatalogos.jsp" class="btn btn-primary" id="agregarEntidadBtn">Agregar Entidad</a>
                <br>
                <br>
                <label for="filtro">Filtrar entidades:</label>
                <input type="text" id="filtro" onkeyup="filtrarTabla()" placeholder="Buscar por nombre o tipo..." class="form-control">

                <table id="tablaEntidades" class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="text-center">Id Entidad</th>
                            <th class="text-center">Nombre Entidad</th>
                            <th class="text-center">Nit Entidad</th>
                            <th class="text-center">Tipo Entidad</th>
                            <th class="text-center">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="entidad" items="${entidades}">
                            <tr>
                                <td class="text-center">${entidad.idEntidad}</td>
                                <td class="text-center">${entidad.nombreEntidad}</td>
                                <td class="text-center">${entidad.nitEntidad}</td>
                                <td class="text-center">${entidad.tipoEntidad}</td>
                                <td class="text-center">
                                    <a class="btn btn-danger" href="Controlador?menu=ManteCata&accion=eliminar&idEntidad=${entidad.idEntidad}">Remove</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <script>
            function filtrarTabla() {
                // Obtener el valor del input de filtro
                const filtro = document.getElementById("filtro").value.toLowerCase();
                // Obtener la tabla y las filas
                const tabla = document.getElementById("tablaEntidades");
                const filas = tabla.getElementsByTagName("tr");

                // Iterar a través de todas las filas de la tabla
                for (let i = 1; i < filas.length; i++) { // Comienza en 1 para omitir la fila de encabezado
                    const celdas = filas[i].getElementsByTagName("td");
                    let encontrado = false;

                    // Iterar a través de todas las celdas de la fila
                    for (let j = 0; j < celdas.length; j++) {
                        if (celdas[j].innerText.toLowerCase().includes(filtro)) {
                            encontrado = true;
                            break;
                        }
                    }

                    // Mostrar o esconder la fila en función del filtro
                    filas[i].style.display = encontrado ? "" : "none";
                }
            }
        </script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script>
    </body>
</html>