package nivel3;

public class Decoracion implements IProducto{

	private String nombre;
	private String material;
	private double precio;

	@Override
	public void setCaracteristicas() {
		this.nombre = Utiles.pedirAtributo("nombre");
		this.material = Utiles.pedirAtributo("material");
		this.precio = Utiles.pedirDouble("precio");
	}

	@Override
	public String toString() {
		return "Decoracion [nombre=" + nombre + ", material=" + material + ", precio=" + precio + "]";
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String getAtributo() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	@Override
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String getTipo() {
		return "Decoracion";
	}
	
	
	

}
