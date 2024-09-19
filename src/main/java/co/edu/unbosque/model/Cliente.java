package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nombre;
    private String email;
    private String membresia;

    // Constructor
    public Cliente(int id, String nombre, String email, String membresia) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.membresia = membresia;
    }

    public Cliente(String nombre2, String email2, String password, String string, ArrayList arrayList) {
		// TODO Auto-generated constructor stub
	}

	// Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getMembresia() {
        return membresia;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMembresia(String membresia) {
        this.membresia = membresia;
    }

	public List<Producto> getHistorialCompras() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		
	}
}

