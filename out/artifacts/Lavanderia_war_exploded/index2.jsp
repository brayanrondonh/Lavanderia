<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="es">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <script src="resources/js/modernizr.js"></script>
    <link rel="stylesheet" type="text/css" href="resources/css/normalize.css">
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="resources/css/estilos.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>JavaLav!</title>
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


        <section id="menu-principal">
            <div class="container">
                <div class="row justify-content-around align-items-center">
                    <div class="col py-3">
                        <a href="#" class="menu-principal">
                            <div class="card card-menu-principal">
                                <img src="resources/img/laundry-saloon-567951_1920.jpg" class="card-img-top img-fluid" alt="...">
                                <p class="titulo_centrado uno"></p>
                            </div>
                        </a>
                        <div class="car-body text-center my-2">
                            <a href="cajeros" class="card-tittle h4 p-2">Cajero</a>
                        </div>
                    </div>
                    <div class="col py-3">
                        <a href="#" class="menu-principal">
                            <div class="card card-menu-principal">
                                <img src="resources/img/laundry-saloon-567951_1920.jpg" class="card-img-top img-fluid" alt="...">
                                <p class="titulo_centrado dos"></p>
                            </div>
                        </a>
                        <div class="car-body text-center my-2">
                            <a href="clientes" class="card-tittle h4 p-2">Clientes</a>
                        </div>
                    </div>
                    <div class="col py-3">
                        <a href="#" class="menu-principal">
                            <div class="card card-menu-principal">
                                <img src="resources/img/laundry-saloon-567951_1920.jpg" class="card-img-top img-fluid" alt="...">
                                <p class="titulo_centrado tres"></p>
                            </div>
                        </a>
                        <div class="car-body text-center my-2">
                            <a href="tipoLavados" class="card-tittle h4 p-2">Tipo de Lavado</a>
                        </div>
                    </div>
                    <div class="col py-3">
                        <a href="#" class="menu-principal">
                            <div class="card card-menu-principal">
                                <img src="resources/img/laundry-saloon-567951_1920.jpg" class="card-img-top img-fluid" alt="...">
                                <p class="titulo_centrado cuatro"></p>
                            </div>
                        </a>
                        <div class="car-body text-center my-2">
                            <a href="lavados" class="card-tittle h4 p-2">Lavado</a>
                        </div>
                    </div>
                    <div class="col py-3">
                        <a href="#" class="menu-principal">
                            <div class="card card-menu-principal">
                                <img src="resources/img/laundry-saloon-567951_1920.jpg" class="card-img-top img-fluid" alt="...">
                                <p class="titulo_centrado cuatro"></p>
                            </div>
                        </a>
                        <div class="car-body text-center my-2">
                            <a href="#" class="card-tittle h4 p-2">Factura</a>
                        </div>
                    </div>
                </div>
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
<script src="resources/js/funciones.js"></script>
</body>
</html>