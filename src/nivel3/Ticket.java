package nivel3;

public class Ticket {
	
	private Conexion conexion = new Conexion();
	
	public void update(String nombreProducto){
		conexion.a�adirVenta(nombreProducto);
	}
	
	public void getFacturaci�nTotal() {
		System.out.println("El total recaudado suma: "+conexion.sumarFacturacion());
	}
	
	public void verTotalTicket() {
		conexion.mostrarDocumentos(null, "Ticket");
	}
}
