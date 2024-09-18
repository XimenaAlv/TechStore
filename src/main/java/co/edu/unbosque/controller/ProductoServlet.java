package co.edu.unbosque.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.List;

import co.edu.unbosque.model.Producto;

@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L; 
    @SuppressWarnings("unchecked")
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        // Leer los productos desde el archivo binario
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("productos.bin"))) {
            List<Producto> productos = (List<Producto>) ois.readObject();
            Producto productoSeleccionado = null;

            // Buscar el producto por ID
            for (Producto producto : productos) {
                if (producto.getId() == id) {
                    productoSeleccionado = producto;
                    break;
                }
            }

            // Enviar los detalles del producto a la página JSP
            request.setAttribute("producto", productoSeleccionado);
            request.getRequestDispatcher("ProductoDetalle.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
