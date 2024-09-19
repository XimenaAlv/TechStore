<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="co.edu.unbosque.model.Producto" %>
<%@ page import="co.edu.unbosque.model.Cliente" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administracion - TechStore</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">TechStore</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="catalogo.jsp">Volver al Catálogo</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="logout.jsp">Cerrar Sesión</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container mt-5">
        <h2>Panel de Administración</h2>

        <!-- Sección para gestionar productos -->
        <h3>Gestión de Productos</h3>
        <form action="ProductoServlet" method="post">
            <input type="hidden" name="action" value="add">
            <div class="form-group">
                <label for="nombre">Nombre del Producto</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>
            <div class="form-group">
                <label for="precio">Precio</label>
                <input type="number" class="form-control" id="precio" name="precio" required>
            </div>
            <div class="form-group">
                <label for="disponibilidad">Disponibilidad</label>
                <input type="number" class="form-control" id="disponibilidad" name="disponibilidad" required>
            </div>
            <div class="form-group">
                <label for="imagen">URL de la Imagen</label>
                <input type="text" class="form-control" id="imagen" name="imagen" required>
            </div>
            <button type="submit" class="btn btn-primary">Agregar Producto</button>
        </form>

        <!-- Listado de productos -->
        <h4>Lista de Productos</h4>
        <div class="row">
            <% 
                List<Producto> productos = (List<Producto>) request.getAttribute("productos");
                if (productos != null) {
                    for (Producto producto : productos) {
            %>
            <div class="col-md-4">
                <div class="card mb-4">
                    <img class="card-img-top" src="<%= producto.getImagen() %>" alt="Producto">
                    <div class="card-body">
                        <h5 class="card-title"><%= producto.getNombre() %></h5>
                        <p class="card-text">Precio: $<%= producto.getPrecio() %></p>
                        <p class="card-text">Disponibilidad: <%= producto.getDisponibilidad() %></p>
                        <form action="ProductoServlet" method="post" style="display: inline-block;">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="id" value="<%= producto.getId() %>">
                            <button type="submit" class="btn btn-danger">Eliminar</button>
                        </form>
                        <a href="editarProducto.jsp?id=<%= producto.getId() %>" class="btn btn-warning">Modificar</a>
                    </div>
                </div>
            </div>
            <% 
                    }
                } 
            %>
        </div>

        <!-- Sección para gestionar clientes -->
        <h3>Gestión de Clientes</h3>
        <h4>Lista de Clientes</h4>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Nivel de Membresía</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
                    if (clientes != null) {
                        for (Cliente cliente : clientes) {
                %>
                <tr>
                    <td><%= cliente.getNombre() %></td>
                    <td><%= cliente.getEmail() %></td>
                    <td><%= cliente.getMembresia() %></td>
                    <td>
                        <a href="editarCliente.jsp?id=<%= cliente.getId() %>" class="btn btn-warning">Modificar</a>
                    </td>
                </tr>
                <% 
                        }
                    } 
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
