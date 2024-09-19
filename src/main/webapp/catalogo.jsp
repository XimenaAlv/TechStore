<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="co.edu.unbosque.model.Producto" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Catálogo de Productos - TechStore</title>
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
                    <a class="nav-link" href="index.jsp">Salir</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container mt-5">
        <h2>Catálogo de Productos</h2>
        <form action="CatalogoServlet" method="get">
            <div class="form-group">
                <label for="categoria">Filtrar por Categoría:</label>
                <select class="form-control" id="categoria" name="categoria">
                    <option value="todos">Todos</option>
                    <option value="telefonos">Teléfonos</option>
                    <option value="laptops">Laptops</option>
                    <option value="televisores">Televisores</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Filtrar</button>
        </form>
        
        <div class="row mt-4">
            <% 
                // Simulación de productos obtenidos del servlet
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
                        <a href="ProductoServlet?id=<%= producto.getId() %>" class="btn btn-primary">Ver Detalles</a>
                    </div>
                </div>
            </div>
            <% 
                    }
                } 
            %>
        </div>
    </div>
</body>
</html>
