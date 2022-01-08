package nivel1;

public class Flor extends Producto{
	private String nombre;
	private String color;
	private double precio;
	
	public Flor(String nombre, String color, double precio) {
		this.color = color;
		this.precio = precio;
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPreu(double precio) {
		this.precio = precio;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Flor [nombre=" + nombre + ", color=" + color + ", precio=" + precio + "]";
	}
}
