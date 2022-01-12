package nivel_2;

public class Arbol implements IProducto{
	private String nombre;
	private double precio;
	private String altura;
	public static final String NOMBRE_TABLA = "arbol";
	
	public Arbol(String nombre, String altura, double precio) {
		this.nombre = nombre;
		this.altura = altura;
		this.precio = precio;
	}

	@Override
	public String getNombre() {
		return nombre;
	}
	
	public String getAltura() {
		return altura;
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
		return "(default, '"+this.getNombre()+"', "+this.getAltura()+", "+this.getPrecio()+")";
	}

	
	
	
	
}
