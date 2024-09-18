package co.edu.unbosque.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import co.edu.unbosque.model.Producto;
import co.edu.unbosque.model.Cliente;

@WebServlet("/ProcesarCompraServlet")
public class ProcesarCompraServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        // Aplicar descuentos por membresía
        double total = 0;
        for (Producto producto : carrito) {
            double precioConDescuento = producto.getPrecio() * obtenerDescuento(cliente.getMembresia());
            total += precioConDescuento * producto.getCantidad();
        }

        // Verificar disponibilidad y actualizar inventario
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("productos.bin"))) {
            List<Producto> inventario = (List<Producto>) ois.readObject();

            for (Producto productoCarrito : carrito) {
                for (Producto productoInventario : inventario) {
                    if (productoInventario.getId() == productoCarrito.getId()) {
                        if (productoInventario.getDisponibilidad() < productoCarrito.getCantidad()) {
                            response.sendRedirect("Carrito.jsp?error=stock");
                            return;
                        }
                        productoInventario.setDisponibilidad(productoInventario.getDisponibilidad() - productoCarrito.getCantidad());
                    }
                }
            }

            // Guardar el inventario actualizado
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("productos.bin"))) {
                oos.writeObject(inventario);
            }

            // Actualizar el historial de compras del cliente
            cliente.getHistorialCompras().addAll(carrito);
            response.sendRedirect("Confirmacion.jsp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private double obtenerDescuento(String membresia) {
        switch (membresia) {
            case "Plata": return 0.95;
            case "Oro": return 0.90;
            case "Platino": return 0.85;
            default: return 1.0;
        }
    }
}
