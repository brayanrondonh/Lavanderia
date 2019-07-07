<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <script src="resources/js/modernizr.js"></script>
    <link rel="stylesheet" type="text/css" href="resources/css/normalize.css">
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="resources/css/estilos.css">
</head>
<body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="index.jsp">LavaJava</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto"><!-- CENTRAR TEXTO CON CSS -->
                        <li class="nav-item">
                            <a href="#" class="nav-link ">Usuario</a>
                        </li>
                        <li class="nav-item cerrar-sesion">
                            <a href="#" class="nav-link btn btn-outline-warning">Cerrar Sesión</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="container">
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="alert alert-primary text-center titulo-etiqueta w-sm">
                        <strong>Cliente</strong>
                    </div>
                </div>
            </div>
        </div>


        <section id="formularios" class="mx-auto">
            <div class="container">

                <form action="lavados" method="post">
                    <div class="form-group">
                        <input type="hidden" name="accion" value="actualizar">
                        <input type="hidden" name="id" value="${lavado.id_lavado}">
                    </div>
                    <div class="form-group">
                        <label for="peso">Peso</label>
                        <input type="text" name="peso" class="form-control" aria-describedby="dniHelp" placeholder="Ingresa el nombre" value="">
                    </div>
                    <div class="form-group">
                        <label for="importe">Importe</label>
                        <input type="text" name="importe" class="form-control" aria-describedby="dniHelp" placeholder="Ingresa el nombre" value="${lavado.importe}">
                    </div>
                    <div class="form-group">
                        <label for="igv">IGV</label>
                        <input type="text" name="igv" class="form-control" aria-describedby="dniHelp" placeholder="Ingresa el nombre" value="${lavado.igv}">
                    </div>
                    <div class="form-group">
                        <label for="total">Total</label>
                        <input type="text" name="total" class="form-control" aria-describedby="dniHelp" placeholder="Ingresa el nombre" value="${lavado.total}">
                    </div>
                    <div class="form-group">
                        <label for="cliente">Cliente</label>
                        <input type="text" name="cliente" class="form-control" aria-describedby="dniHelp" placeholder="Datos del Cliente" value="${lavado.id_cliente}">
                    </div>
                    <div class="form-group">
                        <label for="tipo">Tipo de Lavado</label>
                        <input type="text" name="tipo" class="form-control" aria-describedby="dniHelp" placeholder="Tipo de Lavado" value="${lavado.id_tipoLavado}">
                    </div>
                    <div class="form-group">
                        <label for="cajero">Cajero</label>
                        <input type="text" name="cajero" class="form-control" aria-describedby="dniHelp" placeholder="Datos del Cajero" value="${lavado.id_cajero}">
                    </div>
                    <div class="form-group">
                        <label for="fecha">Fecha</label>
                        <input type="text" name="fecha" class="form-control" aria-describedby="dniHelp" placeholder="Ingresa el nombre" value="${lavado.tiempo}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="">¿Pedido Pagado?</label>
                        <c:choose>

                            <c:when test="${lavado.cancelado == true}">
                                <div class="form-check">
                                    <label class="form-check-label" for="radio1">
                                        <input type="radio" class="form-check-input" id="radio1" name="cancelado" value="false">No
                                    </label>
                                </div>
                                <div class="form-check">
                                    <label class="form-check-label" for="radio2">
                                        <input type="radio" class="form-check-input" id="radio2" name="cancelado" value="true" checked>Si
                                    </label>
                                </div>
                            </c:when>

                            <c:when test="${lavado.cancelado == false}">
                                <div class="form-check">
                                    <label class="form-check-label" for="radio1">
                                        <input type="radio" class="form-check-input" id="radio1" name="cancelado" value="false" checked>No
                                    </label>
                                </div>
                                <div class="form-check">
                                    <label class="form-check-label" for="radio2">
                                        <input type="radio" class="form-check-input" id="radio2" name="cancelado" value="true">Si
                                    </label>
                                </div>
                            </c:when>
                        </c:choose>
                    </div>
                    <div class="row justify-content-end mr-1" id="botones">
                        <button type="submit" name="eliminar" value="eliminar" class="btn btn-outline-danger mr-1">Eliminar</button>
                        <button type="submit" name="modificar" value="modificar" class="btn btn-primary">Actualizar</button>
                    </div>
                </form>
            </div>
        </section>


        <footer id="pie-pagina" class="mt-5 bg-dark">
            <div class="container">
                <div class="row justify-content-around align-items-center bg-dark">
                    <div class="col-6 mt-4 text-footer">
                        <h6>Contacto:</h6>
                        <p>brayanrondon@gmail.com</p>
                    </div>
                    <div class="col-6 mt-4 text-footer">
                        <p class="text-center">Lavanderia Java &copy</p>
                        <p class="text-center">Todos los derechos reservados</p>
                    </div>
                </div>
            </div>
        </footer>


        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="../resources/js/funciones.js"></script>
</body>
</html>
