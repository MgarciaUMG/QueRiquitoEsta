<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Botones Centrados</title>
        <style>
            .btn-custom {
                width: 100%;
                height: auto;
                padding: 20px;
                font-size: 18px;
                margin-bottom: 85px;
                margin-top: 85px;
                
            }
            .button-container {
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
            }
        </style>
    </head>
    <body>
        <div class="container button-container">
            <div class="row justify-content-center">
                <div class="col-md-4 mb-5 mx-5">
                    <button class="btn btn-primary btn-custom">Bandeja Almacenamiento</button>
                </div>
                <div class="col-md-4 mb-5 mx-5">
                    <button class="btn btn-primary btn-custom">Bandeja Laboratorio</button>
                </div>
                <div class="col-md-4 mb-5 mx-5">
                    <button class="btn btn-primary btn-custom">Bandeja Analista</button>
                </div>
                <div class="col-md-4 mb-5 mx-5">
                    <button class="btn btn-primary btn-custom">Botón 4</button>
                </div>
                <div class="col-md-4 mb-5 mx-5">
                    <button class="btn btn-primary btn-custom">Botón 5</button>
                </div>
                <div class="col-md-4 mb-5 mx-5">
                    <button class="btn btn-primary btn-custom">Botón 6</button>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>