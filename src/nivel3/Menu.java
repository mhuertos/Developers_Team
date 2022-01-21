package nivel3;

public class Menu {
	
	public static final String WELCOME = "Bienvenido al gestor de tu floristería\n";
	public static final String ESCOGE = "Indica el número de la opción deseada: ";
	public static String[] mainMenuOpt = {"1- Añadir a Stock", "2- Mostrar Stock", 
										  "3- Vender", "4- Comprovar Ticket", "5- Salir"};
	
	public static String[] tipoObjeto = {"1- Flor", "2- Árbol", "3- Objeto de decoración"};
	public static String[] tipoStock = {"1- Flor", "2- Árbol", "3- Objeto de decoración",
										"4- General"};
	public static String[] opcionTicket = {"1- Ver ticket","2- Ver recaudación total"};

	public static Ticket ticket = new Ticket();
	
	public static void mostrarMenu(String[] menu) {
		System.out.println(ESCOGE);
		for(String s: menu) {
			System.out.println(s);
		}
	}
	
	public static void mainMenu() {
		mostrarMenu(mainMenuOpt);
	}
	
		
	public static String escogeTipoObjeto() {
		mostrarMenu(tipoObjeto);
		String s = "";
		while(s.isEmpty()) {
			switch(Utiles.pedirEntero()) {
				case 1:
					s = "Flor";
					break;
				case 2:
					s = "Arbol";
					break;
				case 3:
					s = "Decoracion";
					break;
				default:
					System.out.println("No has marcado un número de la lista");
			}
		}
		return s;
	}
	
	public static String escogeTipoStock() {
		mostrarMenu(tipoStock);
		String s = "";
		int opcion = Utiles.pedirEntero();
		do {
			switch(opcion) {
				case 1:
					s = "Flor";
					break;
				case 2:
					s = "Arbol";
					break;
				case 3:
					s = "Decoracion";
					break;
				case 4:
					s = null;
					break;
				default:
					System.out.println("No has marcado un número de la lista");
			}
		}while(opcion < 1 || opcion > tipoStock.length);
		return s;
	}
	
	
	public static void menuTicket() {
		mostrarMenu(opcionTicket);
		int opcion = Utiles.pedirEntero();
		switch(opcion) {
			case 1:
				ticket.verTotalTicket();
				break;
			case 2:
				ticket.getFacturaciónTotal();
				break;
			default:
				System.out.println("No has marcado un número de la lista");
		}
	}
}
