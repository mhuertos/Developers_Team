package nivel1;

public class ObjetoDecoracion extends Producto{
	private String nombre;
	private String material;
	private double precio;
	
	public ObjetoDecoracion(String nombre, String material, double precio) {
		if(material.equalsIgnoreCase("Fusta") || material.equalsIgnoreCase("Plastic")) {
			this.material = material;
		}else {
			System.out.println("Aquest no es un material esperat.");
		}
		this.precio = precio;
		this.nombre = nombre;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
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
		return "ObjetoDecoracion [nombre=" + nombre + ", material=" + material + ", precio=" + precio + "]";
	}
	
}
