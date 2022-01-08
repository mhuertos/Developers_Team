package nivel1;

import java.util.ArrayList;

public class Ticket {
	
	private static double totalRecaudat = 0;
	private static ArrayList<Producto> ticket = new ArrayList<>();
	
	public void update(Producto p) {
		ticket.add(p);
		totalRecaudat += p.getPrecio();
	}
	
	public void mostraTicket(){
		System.out.println("Ticket compuesto por: ");
		for(Producto p: ticket) {
			System.out.println(p.toString());
		}
	}
	
	public void getTotalRecaudat() {
		System.out.println("S'ha recauidat un total de: "+totalRecaudat);
	}

}
