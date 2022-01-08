package nivel1;

//Crearemos la clase siguiendo un patr�n Singleton
public class Floristeria implements Venta{
	
	private static Floristeria floristeria;
	@SuppressWarnings("unused")
	private String nombre;
	
	private StockFlores stockflores = new StockFlores();
	private StockArboles stockarboles = new StockArboles();
	private StockDecoracion stockdecoracion = new StockDecoracion();
	private Stock stock = new Stock();
	
	private Ticket ticket = new Ticket();
	
	private Floristeria(String nombre) {
		this.nombre = nombre;
	}
	
	public static Floristeria getInstancia(String nombre) {
		if(floristeria == null) {
			floristeria = new Floristeria(nombre);
		}
		return floristeria;
	}
	
	public void addToStockFlores(Flor flor) {
		stockflores.addToStock(flor);
	}
	
	public void printStockFlores() {
		stockflores.getStock();
	}
	
	
	public void addToStockArboles(Arbol arbol) {
		stockarboles.addToStock(arbol);
	}
	
	public void printStockArboles() {
		stockarboles.getStock();
	}

	
	public void addToStockDecoracion(ObjetoDecoracion objeto) {
		stockdecoracion.addToStock(objeto);
	}
	
	public void printStockDecoracion() {
		stockdecoracion.getStock();
	}

	public void printStock() {
		System.out.println("�rboles: "); stockarboles.getStock();
		System.out.println("\nFlores: "); stockflores.getStock();
		System.out.println("\nDecoraci�n: "); stockdecoracion.getStock();
	}
	
	public void getRecaudaci�() {
		ticket.getTotalRecaudat();
	}
	
	public void getInversio() {
		double suma = stockarboles.getSumaPreus() + stockflores.getSumaPreus() + stockdecoracion.getSumaPreus();
		System.out.println("La flor�ster�a ha invertit un total de: "+suma);
	}
	
	
	public void removeArbol(Arbol arbol) {
		stockarboles.removeToStock(arbol);
		
	}
	
	public void removeFlor(Flor flor) {
		stockflores.removeToStock(flor);
		
	}
	
	public void removeDecoracion(ObjetoDecoracion obj) {
		stockdecoracion.removeToStock(obj);
		
	}
	
	
	@Override
	public void venderArboles(Arbol producto){
		if(stockarboles.productOnStock(producto)) {
			stockarboles.removeToStock(producto);
			ticket.update(producto);
		}else {
			System.out.println("No hay existencias.");
		}	
	}
	
	@Override
	public void venderFlores(Flor flor) {
		if(stockflores.productOnStock(flor)) {
			stockflores.removeToStock(flor);
			ticket.update(flor);
		}else {
			System.out.println("No hay existencias.");
		}	
	}
	
	@Override
	public void venderObjetoDecoracion(ObjetoDecoracion objeto) {
		if(stockdecoracion.productOnStock(objeto)) {
			stockdecoracion.removeToStock(objeto);
			ticket.update(objeto);
		}else {
			System.out.println("No hay existencias.");
		}	
	}
	
	public void getTicket() {
		ticket.mostraTicket();
	}
}
