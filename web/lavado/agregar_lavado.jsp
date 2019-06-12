<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Lavado</title>
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
                        <strong>Agregar Lavado</strong>
                    </div>
                </div>
            </div>
        </div>


        <section id="formularios" class="mx-auto">
            <div class="container">

                <form action="../lavados" method="post">

                    <div id="wrapGeneral">


                        <div class="form-group">
                            <label for="peso">Peso</label>
                            <div class="form-inline">
                                <input type="hidden" name="accion" value="agregar">
                                <input type="number" name="peso" class="form-control mr-5 w-75 cl" aria-describedby="dniHelp" placeholder="Ingresa el peso" onchange="suma()" min="0" max="100" value="0" step="0.01">
                                <button type="button" onclick="suma()" name="add" id="add" class="btn btn-primary">+</button>
                            </div>
                        </div>

                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="inputGroupSelect01">Tipo de Lavado</label>
                            </div>
                            <select class="custom-select" id="inputGroupSelect01">
                                <option selected>Choose...</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>

                        <div id="wrapInput">
                        </div>

                    </div>



                    <div class="form-group">
                        <label for="importe">Importe</label>
                        <input type="text" name="importe" class="form-control" aria-describedby="dniHelp" placeholder="Ingresa el nombre">
                    </div>
                    <div class="form-group">
                        <label for="igv">IGV</label>
                        <input type="text" name="igv" class="form-control" aria-describedby="dniHelp" placeholder="Ingresa el nombre">
                    </div>
                    <div class="form-group">
                        <label for="total">Total</label>
                        <input type="number" name="total" id="sumaAll" class="form-control" aria-describedby="totalHelp" placeholder="Total">
                    </div>
                    <div class="form-group">
                        <label for="">¿Pedido Pagado?</label>
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
                        <div class="row justify-content-end mr-1" id="botones">
                            <button type="reset" class="btn btn-secondary mr-1">Limpiar</button>
                            <button type="submit" class="btn btn-primary">Enviar</button>
                        </div>
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

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <script>
            $(document).ready(function(){
                var i=1;
                $('#add').click(function(){
                    i++;
                    $('#wrapGeneral').append('<div id="wrapInput'+i+'"><div class="form-group"><label for="peso">Peso</label><div class="form-inline"><input type="number" name="peso" class="form-control mr-5 w-75 cl" aria-describedby="pesoHelp" placeholder="Ingresa el peso" onchange="suma()" min="0" max="100" step="0.01"><button type="button" onclick="suma()" name="remove" id="'+i+'" class="btn btn-danger btn_remove">x</button></div></div><div class="input-group mb-3"><div class="input-group-prepend"><label class="input-group-text" for="inputGroupSelect01">Tipo de Lavado</label></div><select class="custom-select" id="inputGroupSelect01"><option selected>Choose...</option><option value="1">One</option><option value="2">Two</option><option value="3">Three</option></select></div></div>');
                });


                $(document).on('click', '.btn_remove', function(){
                    var button_id = $(this).attr("id");
                    $("#wrapInput"+button_id).remove();
                });
            });

            function suma() {
                setTimeout(()=>{
                    var add=0;
                $('.cl').each(function(i,el) {
                    if (!isNaN($(this).val())) {
                        add += Number($(this).val());
                    }
                });
                $('#sumaAll').val(add);
            },1)
            };
        </script>
</body>
</html>
