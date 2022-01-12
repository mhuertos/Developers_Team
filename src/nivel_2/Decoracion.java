package nivel_2;

public class Decoracion implements IProducto{
	private String nombre;
	private double precio;
	private String material;
	public static final String NOMBRE_TABLA = "objeto_deco";
	
	public Decoracion(String nombre, String material, double precio) {
		this.nombre = nombre;
		if (material.equalsIgnoreCase("Fusta") || (material.equalsIgnoreCase("plastic"))){
			this.material = material;
		}else {
			System.out.println("Material incorrecte.");
			this.material = null;
		}
		this.precio = precio;
	}

	@Override
	public String getNombre() {
		return nombre;
	}
	
	public String getMaterial() {
		return material;
	}

	@Override
	public double getPrecio() {
		return precio;
	}

	@Override
	public String getNombreTabla() {
		return NOMBRE_TABLA;
	}

	@Override
	public String getInsertQuery() {
		return "(default, '"+this.getNombre()+"', '"+this.getMaterial()+"', "+this.getPrecio()+")";
	}

	
	
	
	
	
	
}
