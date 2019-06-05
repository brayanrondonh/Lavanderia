<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actualizar Factura</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <script src="resources/js/modernizr.js"></script>
    <link rel="stylesheet" type="text/css" href="../resources/css/normalize.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../resources/css/estilos.css">
</head>
<body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="#">LavaJava</a>
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
                        <strong>Factura</strong>
                    </div>
                </div>
            </div>
        </div>


        <section id="formularios" class="mx-auto">
            <div class="container">

                <form action="facturas" method="post">
                    <div class="form-group">
                        <input type="hidden" name="accion" value="actualizar">
                        <input type="hidden" name="id_factura" value="${factura.id_factura}">
                    </div>
                    <div class="form-group">
                        <label for="nombreEmpresa">Nombre de la Empresa</label>
                        <input type="text" name="nombreEmpresa" class="form-control" aria-describedby="dniHelp" placeholder="Ingresa el nombre" value="${factura.nombreEmpresa}">
                    </div>
                    <div class="form-group">
                        <label for="nombreComercial">Nombre Comercial</label>
                        <input type="text" name="nombreComercial" class="form-control" aria-describedby="dniHelp" placeholder="Ingresa el nombre" value="${factura.nombreComercial}">
                    </div>
                    <div class="form-group">
                        <label for="ruc">RUC</label>
                        <input type="text" name="ruc" class="form-control" aria-describedby="dniHelp" placeholder="Ingresa el nombre" value="${factura.ruc}">
                    </div>
                    <div class="form-group">
                        <label for="direccion">Dirección</label>
                        <input type="text" name="direccion" class="form-control" aria-describedby="dniHelp" placeholder="Ingresa el nombre" value="${factura.direccion}">
                    </div>
                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input type="text" name="telefono" class="form-control" aria-describedby="dniHelp" placeholder="Ingresa el nombre" value="${factura.telefono}">
                    </div>
                    <div class="form-group">
                        <label for="numeroOperacion">Numero de Operación</label>
                        <input type="text" name="numeroOperacion" class="form-control" aria-describedby="dniHelp" placeholder="Ingresa el nombre" value="${factura.num_operacion}">
                    </div>
                    <div class="form-group">
                        <label for="boleta">Numero de Boleta</label>
                        <input type="text" name="numeroBoleta" class="form-control" aria-describedby="dniHelp" placeholder="Ingresa el nombre" value="${factura.num_boleta}">
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
