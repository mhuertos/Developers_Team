package nivel_2;

public class Flor implements IProducto{
	
	private String nombre;
	private double precio;
	private String color;
	public static final String NOMBRE_TABLA = "flor";
	
	public Flor(String nombre, String color, double precio) {
		this.nombre = nombre;
		this.color = color;
		this.precio = precio;
	}
	

	@Override
	public String getNombre() {
		return nombre;
	}
	
	
	public String getColor() {
		return color;
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
		return "(default, '"+this.getNombre()+"', '"+this.getColor()+"', "+this.getPrecio()+")";
	}
	
	



	
	
	
	
}
