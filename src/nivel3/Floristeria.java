package nivel3;

public class Floristeria {
	private String nombre;
	private static Floristeria floristeria;
	private static Ticket ticket = new Ticket();
	private FactoryProductos factory = new FactoryProductos();
	private Conexion conexion = new Conexion();
	
	private Floristeria(String nombre) {
		this.nombre = nombre;
	}
	
	public static Floristeria getInstancia(String nombre) {
		if(floristeria == null) {
			return new Floristeria(nombre);
		}else {
			return floristeria;
		}
	}
	
	public void addStock(String tipoProducto){
		IProducto producto = factory.getProducto(tipoProducto);
		if (producto instanceof IProducto){
			producto.setCaracteristicas();
			conexion.insertarProducto(producto);
			System.out.println("Se ha añadido un "+producto.toString());
		}
	}
	
	public void mostrarStock(String tipoProducto) {
		System.out.println("Existencias de "+tipoProducto+": ");
		conexion.mostrarDocumentos(tipoProducto, "Producto");
	}

	
	public void sell(String nombreProducto) {
		if(conexion.existeDocumento(nombreProducto)) {
			ticket.update(nombreProducto);
		}else {
			System.out.println("No quedan unidades.");
		}
	}
	
	
	
	
	
	
}
