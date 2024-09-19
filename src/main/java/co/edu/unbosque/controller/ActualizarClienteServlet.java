package co.edu.unbosque.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import co.edu.unbosque.model.Cliente;

@WebServlet("/ActualizarClienteServlet")
public class ActualizarClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el cliente de la sesión
        Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
        
        // Actualizar los datos del cliente
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        cliente.setNombre(nombre);
        cliente.setEmail(email);
        cliente.setPassword(password);

        // Guardar los cambios en la sesión
        request.getSession().setAttribute("cliente", cliente);
        
        // Redirigir nuevamente al perfil
        response.sendRedirect("perfil.jsp");
    }
}
