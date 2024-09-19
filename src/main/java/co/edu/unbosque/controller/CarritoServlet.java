package co.edu.unbosque.controller;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import co.edu.unbosque.model.Producto;

public class CarritoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        // Obtener el carrito de compras de la sesión
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<>();
            session.setAttribute("carrito", carrito);
        }

        String action = request.getParameter("action");
        String id = request.getParameter("id");

        if (action != null && id != null) {
            Producto producto = obtenerProductoPorId(Integer.parseInt(id)); // Supongamos que este método existe para obtener un producto por ID

            if (action.equals("add")) {
                // Agregar producto al carrito
                carrito.add(producto);
            } else if (action.equals("remove")) {
                // Eliminar producto del carrito
                carrito.removeIf(p -> p.getId() == Integer.parseInt(id));
            }
        }
        
        // Redirigir al catálogo o al carrito dependiendo de la acción
        if (action != null && action.equals("add")) {
            response.sendRedirect("catalogo.jsp");
        } else {
            response.sendRedirect("verCarrito.jsp");
        }
    }

    private Producto obtenerProductoPorId(int id) {
        // Aquí iría la lógica para obtener el producto desde la base de datos o lista.
        // Ejemplo simulado:
        return new Producto(id, "Producto " + id, 100.0, "Descripción", 10);
    }
}
