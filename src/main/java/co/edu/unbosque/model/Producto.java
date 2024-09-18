package co.edu.unbosque.model;

import java.io.Serializable;

public class Producto implements Serializable {
    // Añadir serialVersionUID para evitar el warning
    private static final long serialVersionUID = 1L;

    private int id;
    private String nombre;
    private double precio;
    private String categoria;
    private int disponibilidad;
    @SuppressWarnings("unused")
	private String imagen;

    // Constructor 
    public Producto(int id, String nombre, double precio, String categoria, int disponibilidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.disponibilidad = disponibilidad;
    }
    public String getImagen() {
        String imagen = null;
		return imagen;
    }
    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDisponibilidad(double d) {
        this.disponibilidad = (int) d;
    }

    // Método toString para mostrar información del producto
    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + 
               ", categoría=" + categoria + ", disponibilidad=" + disponibilidad + "]";
    }

	public double getCantidad() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}
