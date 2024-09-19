package co.edu.unbosque.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import co.edu.unbosque.model.Producto;

public class ProductoServlet extends HttpServlet {

    private List<Producto> productos;

    @Override
    public void init() throws ServletException {
        productos = new ArrayList<>();
        getServletContext().setAttribute("productos", productos); // Guardar en contexto
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String nombre = request.getParameter("nombre");
            double precio = Double.parseDouble(request.getParameter("precio"));
            int disponibilidad = Integer.parseInt(request.getParameter("disponibilidad"));
            String imagen = request.getParameter("imagen");

            Producto nuevoProducto = new Producto(nombre, precio, disponibilidad, imagen);
            productos.add(nuevoProducto);
            request.getServletContext().setAttribute("productos", productos);

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            productos.removeIf(p -> p.getId() == id);
            request.getServletContext().setAttribute("productos", productos);
        }

        response.sendRedirect("admin.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
