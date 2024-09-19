<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="co.edu.unbosque.model.Cliente, java.util.ArrayList, java.util.List"%>
<%@ page import="co.edu.unbosque.model.Producto" %>
<%@ page session="true" %>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil de Cliente</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<%
    Cliente cliente = (Cliente) session.getAttribute("cliente");

	List<Producto> historialCompras = new ArrayList<>();
	
	historialCompras.add( new Producto(001,"Televisor LG 51", 600000, "Televisores",1));

	cliente = new Cliente ("Ximena", "alvarez@gmail.com", "123456789", "Oro", historialCompras);

    if (cliente == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Definir el descuento basado en la membresía
    double descuento = 0;
    String membresia = cliente.getMembresia();

    switch (membresia) {
        case "Plata":
            descuento = 0.05; // 5% descuento
            break;
        case "Oro":
            descuento = 0.10; // 10% descuento
            break;
        case "Platino":
            descuento = 0.15; // 15% descuento
            break;
        default:
            descuento = 0.0; // Regular (sin descuento)
    }
%>

<div class="container mt-5">
    <h2>Perfil de Cliente</h2>
    <div class="card">
        <div class="card-body">
            <form action="ActualizarClienteServlet" method="POST">
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="<%= cliente.getNombre() %>" required>
                </div>
                <div class="form-group">
                    <label for="email">Correo Electrónico:</label>
                    <input type="email" class="form-control" id="email" name="email" value="<%= cliente.getEmail() %>" required>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña:</label>
                    <input type="password" class="form-control" id="password" name="password" value="<%= cliente.getPassword() %>" required>
                </div>
                <div class="form-group">
                    <label for="membresia">Membresía:</label>
                    <input type="text" class="form-control" id="membresia" name="membresia" value="<%= cliente.getMembresia() %>" readonly>
                </div>
                <button type="submit" class="btn btn-primary">Actualizar Información</button>
            </form>
        </div>
    </div>

    <h3 class="mt-5">Historial de Compras</h3>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Producto</th>
                <th>Precio</th>
                <th>Categoría</th>
                <th>Descuento Aplicado</th>
                <th>Precio Final</th>
            </tr>
        </thead>
        <tbody>
            <% 
                double totalCompras = 0;
                for (Producto producto : cliente.getHistorialCompras()) {
                    double precioDescuento = producto.getPrecio() * (1 - descuento);
                    totalCompras += precioDescuento;
            %>
            <tr>
                <td><%= producto.getNombre() %></td>
                <td>$<%= producto.getPrecio() %></td>
                <td><%= producto.getCategoria() %></td>
                <td><%= (descuento * 100) %>%</td>
                <td>$<%= precioDescuento %></td>
            </tr>
            <% } %>
        </tbody>
    </table>

    <h4>Total de compras con descuento: $<%= totalCompras %></h4>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
