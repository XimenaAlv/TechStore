package co.edu.unbosque.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private static final String FILE_PATH = "clientes.dat";

    // Guardar la lista de clientes en un archivo binario
    private void guardarClientes(List<Cliente> clientes) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(clientes);
        }
    }

    // Cargar la lista de clientes desde un archivo binario
    @SuppressWarnings("unchecked")
    private List<Cliente> cargarClientes() throws IOException, ClassNotFoundException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Cliente>) ois.readObject();
        }
    }

    // Obtener un cliente por ID
    public Cliente obtenerClientePorId(int id) throws IOException, ClassNotFoundException {
        List<Cliente> clientes = cargarClientes();
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    // Obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() throws IOException, ClassNotFoundException {
        return cargarClientes();
    }

    // Agregar un nuevo cliente
    public void agregarCliente(Cliente cliente) throws IOException, ClassNotFoundException {
        List<Cliente> clientes = cargarClientes();
        clientes.add(cliente);
        guardarClientes(clientes);
    }

    // Actualizar un cliente existente
    public void actualizarCliente(Cliente cliente) throws IOException, ClassNotFoundException {
        List<Cliente> clientes = cargarClientes();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == cliente.getId()) {
                clientes.set(i, cliente);
                guardarClientes(clientes);
                return;
            }
        }
    }

    // Eliminar un cliente por ID
    public void eliminarCliente(int id) throws IOException, ClassNotFoundException {
        List<Cliente> clientes = cargarClientes();
        clientes.removeIf(cliente -> cliente.getId() == id);
        guardarClientes(clientes);
    }
}
