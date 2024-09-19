<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmación de Compra</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">TechStore</a>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="perfil.jsp">Gestion Cuenta</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="catalogo.jsp">Volver al Catálogo</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container mt-5">
    <h2>Confirmación de Compra</h2>
    <div class="alert alert-info" role="alert">
        <%= session.getAttribute("mensajeCompra") %>
    </div>
</div>
</body>
</html>
