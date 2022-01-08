package nivel1;

public class Arbol extends Producto{
	private String nombre;
	private double altura;
	private double precio;
	
	public Arbol(String nombre, double altura, double precio) {
		this.altura = altura;
		this.precio = precio;
		this.nombre = nombre;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Arbol [nombre=" + nombre + ", altura=" + altura + ", precio=" + precio + "]";
	}
	
	

}
