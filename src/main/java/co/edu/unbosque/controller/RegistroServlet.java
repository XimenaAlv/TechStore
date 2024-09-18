package co.edu.unbosque.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import co.edu.unbosque.model.Cliente;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Crear un nuevo objeto Cliente
        Cliente nuevoCliente = new Cliente(nombre, email, password, "Regular", new ArrayList<>());

        // Guardar el cliente en un archivo binario
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientes.bin", true))) {
            oos.writeObject(nuevoCliente);
        }

        // Redirigir al usuario a la página de inicio de sesión
        response.sendRedirect("Login.jsp");
    }
}
