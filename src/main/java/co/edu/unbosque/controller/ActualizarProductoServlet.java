package co.edu.unbosque.controller;

import co.edu.unbosque.model.Producto;
import co.edu.unbosque.model.ProductoDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/actualizarProducto")
public class ActualizarProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtener los parámetros del formulario
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            double precio = Double.parseDouble(request.getParameter("precio"));

            // Crear un objeto Producto con los nuevos datos
            Producto producto = new Producto(idProducto, nombre, descripcion, precio);

            // Crear el DAO y actualizar el producto en la base de datos
            ProductoDAO productoDAO = new ProductoDAO();
            productoDAO.actualizarProducto(producto);

            // Redirigir a la página de gestión de productos
            response.sendRedirect("gestionarProductos.jsp");
        } catch (NumberFormatException e) {
            // Manejar excepciones de formato numérico
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        } catch (Exception e) {
            // Manejar otras excepciones
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
