package co.edu.unbosque.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import co.edu.unbosque.model.Cliente;

public class ClienteServlet extends HttpServlet {

    private List<Cliente> clientes;

    @Override
    public void init() throws ServletException {
        clientes = new ArrayList<>();
        getServletContext().setAttribute("clientes", clientes);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String email = request.getParameter("email");
            String membresia = request.getParameter("membresia");

            for (Cliente cliente : clientes) {
                if (cliente.getId() == id) {
                    cliente.setNombre(nombre);
                    cliente.setEmail(email);
                    cliente.setMembresia(membresia);
                    break;
                }
            }

            getServletContext().setAttribute("clientes", clientes);
        }

        response.sendRedirect("admin.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
