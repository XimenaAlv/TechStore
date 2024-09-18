package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.List;

public class Cliente implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
    private String email;
    private String password;
    private String membresia;
    private List<Producto> historialCompras;

    public Cliente(String nombre, String email, String password, String membresia, List<Producto> historialCompras) {
        this.setNombre(nombre);
        this.setEmail(email);
        this.setPassword(password);
        this.setMembresia(membresia);
        this.setHistorialCompras(historialCompras);
    }
    // Getters y setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMembresia() {
		return membresia;
	}

	public void setMembresia(String membresia) {
		this.membresia = membresia;
	}

	public List<Producto> getHistorialCompras() {
		return historialCompras;
	}

	public void setHistorialCompras(List<Producto> historialCompras) {
		this.historialCompras = historialCompras;
	}
    
}
