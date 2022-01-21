package nivel3;

public class Ticket {
	
	private Conexion conexion = new Conexion();
	
	public void update(String nombreProducto){
		conexion.añadirVenta(nombreProducto);
	}
	
	public void getFacturaciónTotal() {
		System.out.println("El total recaudado suma: "+conexion.sumarFacturacion());
	}
	
	public void verTotalTicket() {
		conexion.mostrarDocumentos(null, "Ticket");
	}
}
