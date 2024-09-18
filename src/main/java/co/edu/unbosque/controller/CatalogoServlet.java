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
import java.util.stream.Collectors;

import co.edu.unbosque.model.Producto;

@WebServlet("/CatalogoServlet")
public class CatalogoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoria = request.getParameter("categoria");

        // Leer los productos desde el archivo binario
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("productos.bin"))) {
            List<Producto> productos = (List<Producto>) ois.readObject();

            // Filtrar por categoría si es necesario
            if (!"todos".equals(categoria)) {
                productos = productos.stream()
                        .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                        .collect(Collectors.toList());
            }

            request.setAttribute("productos", productos);
            request.getRequestDispatcher("Catalogo.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
