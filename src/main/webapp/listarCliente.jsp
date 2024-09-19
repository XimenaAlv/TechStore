<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ page import="co.edu.unbosque.model.Cliente, java.util.ArrayList, java.util.List"%>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestionar Clientes</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Gestionar Clientes</h2>
        <!-- Aquí deberías recuperar la lista de clientes desde la base de datos -->
        <!-- Este es un ejemplo estático -->
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Membresía</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%-- Supongamos que tienes una lista de clientes en una variable llamada clientes --%>
                <% List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes"); %>
                <% for (Cliente cliente : clientes) { %>
                    <tr>
                        <td><%= cliente.getId() %></td>
                        <td><%= cliente.getNombre() %></td>
                        <td><%= cliente.getEmail() %></td>
                        <td><%= cliente.getMembresia() %></td>
                        <td>
                            <a href="modificarCliente.jsp?idCliente=<%= cliente.getId() %>" class="btn btn-warning btn-sm">Modificar</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
