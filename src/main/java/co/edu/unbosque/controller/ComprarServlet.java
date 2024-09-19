package co.edu.unbosque.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import co.edu.unbosque.model.Producto;

public class ComprarServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        // Obtener el carrito de compras de la sesión
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        if (carrito != null && !carrito.isEmpty()) {
            // Lógica de procesamiento de compra:


            // Ejemplo: Guardar el historial de compras del cliente
            List<Producto> historialCompras = (List<Producto>) session.getAttribute("historialCompras");
            if (historialCompras == null) {
                historialCompras = new ArrayList<>();
                session.setAttribute("historialCompras", historialCompras);
            }

            // Añadir todos los productos del carrito al historial de compras
            historialCompras.addAll(carrito);

            // Simulación: Vaciar el carrito después de la compra
            session.setAttribute("carrito", null);

            // Mensaje de éxito
            session.setAttribute("mensajeCompra", "Compra realizada con éxito. ¡Gracias por tu compra!");
        } else {
            // Si el carrito está vacío, mostrar un mensaje de error
            session.setAttribute("mensajeCompra", "El carrito está vacío, no se pudo realizar la compra.");
        }

        // Redirigir a la página de confirmación o resumen de compra
        response.sendRedirect("confirmacionCompra.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
