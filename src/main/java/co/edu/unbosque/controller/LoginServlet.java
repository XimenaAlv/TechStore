package co.edu.unbosque.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.List;

import co.edu.unbosque.model.Cliente;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Leer los clientes desde el archivo binario
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clientes.bin"))) {
            List<Cliente> clientes = (List<Cliente>) ois.readObject();
            for (Cliente cliente : clientes) {
                if (cliente.getEmail().equals(email) && cliente.getPassword().equals(password)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("cliente", cliente);
                    response.sendRedirect("Catalogo.jsp");
                    return;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Si el inicio de sesión falla, redirigir al login con un mensaje de error
        response.sendRedirect("Login.jsp?error=1");
    }
}
