package nivel3;

public class Flor implements IProducto{

	private String nombre;
	private String color;
	private double precio;

	@Override
	public void setCaracteristicas() {
		this.nombre = Utiles.pedirAtributo("nombre");
		this.color = Utiles.pedirAtributo("color");
		this.precio = Utiles.pedirDouble("precio");
	}

	@Override
	public String toString() {
		return "Flor [nombre=" + nombre + ", color=" + color + ", precio=" + precio + "]";
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String getAtributo() {
		return color;
	}

	@Override
	public double getPrecio() {
		return precio;
	}

	@Override
	public String getTipo() {
		return "Flor";
	}
}
