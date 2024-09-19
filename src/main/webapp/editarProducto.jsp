<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="co.edu.unbosque.model.Producto" %>
<%@ page import="co.edu.unbosque.model.ProductoDAO" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Producto</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Editar Producto</h2>
        <% 
            // Obtener el ID del producto de la solicitud
            String idProducto = request.getParameter("idProducto");
            if (idProducto != null && !idProducto.isEmpty()) {
                // Obtener el objeto Producto desde la base de datos usando el DAO
                ProductoDAO productoDAO = new ProductoDAO();
                Producto producto = productoDAO.obtenerProductoPorId(Integer.parseInt(idProducto));
                if (producto != null) {
        %>
        <form action="actualizarProducto" method="post">
            <input type="hidden" name="idProducto" value="<%= producto.getId() %>">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="<%= producto.getNombre() %>" required>
            </div>
            <div class="form-group">
                <label for="descripcion">Descripción:</label>
                <textarea class="form-control" id="descripcion" name="descripcion" rows="3" required><%= producto.getDescripcion() %></textarea>
            </div>
            <div class="form-group">
                <label for="precio">Precio:</label>
                <input type="number" class="form-control" id="precio" name="precio" value="<%= producto.getPrecio() %>" step="0.01" required>
            </div>
            <button type="submit" class="btn btn-primary">Actualizar Producto</button>
        </form>
        <% 
                } else {
                    out.println("<p>Producto no encontrado.</p>");
                }
            } else {
                out.println("<p>ID del producto no válido.</p>");
            }
        %>
    </div>
</body>
</html>
