<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="co.edu.unbosque.model.Producto" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carrito de Compras</title>
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
                <a class="nav-link" href="#">Salir</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container mt-5">
    <h2>Carrito de Compras</h2>
    <div class="row mt-4">
        <% 
            // Obtener la lista de productos del carrito desde la sesión
            List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");
            double total = 0.0;

            if (carrito != null && !carrito.isEmpty()) {
        %>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Producto</th>
                    <th>Precio</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
                <% for (Producto producto : carrito) { 
                    total += producto.getPrecio(); %>
                <tr>
                    <td><%= producto.getNombre() %></td>
                    <td>$<%= producto.getPrecio() %></td>
                    <td>
                        <a href="CarritoServlet?action=remove&id=<%= producto.getId() %>" class="btn btn-danger">Eliminar</a>
                    </td>
                </tr>
                <% } %>
                <tr>
                    <td><strong>Total:</strong></td>
                    <td><strong>$<%= total %></strong></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
        <a href="ComprarServlet" class="btn btn-success">Proceder a la Compra</a>
        <% 
            } else { 
        %>
        <p>No hay productos en el carrito.</p>
        <% 
            } 
        %>
    </div>
</div>
</body>
</html>
