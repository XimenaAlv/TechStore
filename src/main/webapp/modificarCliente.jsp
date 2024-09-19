<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="co.edu.unbosque.model.Cliente" %>
<%@ page import="co.edu.unbosque.model.ClienteDAO" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Cliente</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Modificar Cliente</h2>
        <% 
            // Obtener el ID del cliente de la solicitud
            String idCliente = request.getParameter("idCliente");
            if (idCliente != null && !idCliente.isEmpty()) {
                // Obtener el objeto Cliente desde la base de datos usando el DAO
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = clienteDAO.obtenerClientePorId(Integer.parseInt(idCliente));
                if (cliente != null) {
        %>
        <form action="actualizarCliente" method="post">
            <input type="hidden" name="idCliente" value="<%= cliente.getId() %>">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="<%= cliente.getNombre() %>" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="<%= cliente.getEmail() %>" required>
            </div>
            <div class="form-group">
                <label for="membresia">Membresía:</label>
                <select class="form-control" id="membresia" name="membresia" required>
                    <option value="Básico" <%= "Básico".equals(cliente.getMembresia()) ? "selected" : "" %>>Básico</option>
                    <option value="Premium" <%= "Premium".equals(cliente.getMembresia()) ? "selected" : "" %>>Premium</option>
                    <!-- Agrega más opciones si es necesario -->
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Actualizar Cliente</button>
        </form>
        <% 
                } else {
                    out.println("<p>Cliente no encontrado.</p>");
                }
            } else {
                out.println("<p>ID del cliente no válido.</p>");
            }
        %>
    </div>
</body>
