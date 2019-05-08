<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Tipo de Lavado</title>
</head>
<body>
    <form action="../tipolavado" method="post">
        <input type="hidden" name="accion" value="agregar">
        <label for="tipo">Tipo de Lavado
            <input type="text" name="tipo">
        </label>
        <label for="precio">Precio * KG
            <input type="number" name="precio" step="0.01">
        </label>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>
