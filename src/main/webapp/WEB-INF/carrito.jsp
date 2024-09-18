<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="co.edu.unbosque.model.Producto" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carrito de Compras - TechStore</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Carrito de Compras</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Producto</th>
                    <th>Cantidad</th>
                    <th>Precio</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");
                    if (carrito != null) {
                        double total = 0;
                        for (Producto producto : carrito) {
                            double subtotal = producto.getPrecio() * producto.getCantidad();
                            total += subtotal;
                %>
                <tr>
                    <td><%= producto.getNombre() %></td>
                    <td><%= producto.getCantidad() %></td>
                    <td>$<%= producto.getPrecio() %></td>
                    <td>$<%= subtotal %></td>
                </tr>
                <% 
                        }
                %>
                <tr>
                    <td colspan="3">Total</td>
                    <td>$<%= total %></td>
                </tr>
                <% 
                    }
                %>
            </tbody>
        </table>
        <a href="ProcesarCompraServlet" class="btn btn-success">Proceder con la Compra</a>
    </div>
</body>
</html>
