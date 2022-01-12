package nivel_2;

import java.util.Scanner;
public class UserExperience {
	
	private final String PEDIR_ELECCION = "\nEscoge una opción introduciendo el número: ";
	private final String[] MAIN_MENU_OPT = {"1. Añadir producto a Stock", "2. Mostrar productos en Stock",
											"3. Vender producto", "4. Consultar facturacion", 
											"5. Salir de la aplicación"};
	private final String[] STOCK_MENU_OPT = {"1. Stock de flores", "2. Stock de árboles", 
											"3. Stock de objetos de decoración", "4. Stock general"};
	private final String[] PRODUCT_MENU_OPT = {"1. Flor", "2. Árbol", "3. Objeto de decoración"};
	
	private final String[] TICKET_MENU = {"1. Mostrar Ticket de ventas", "2. Mostrar facturación total"};
	
	private final String INVALID_OPTION = "No es una opción válida.";
	private final String UNEXPECTED_VALUE = "No es un valor válido";
	
	private Scanner sc = new Scanner(System.in);
	private final String HEAD = "Bienvenido al gestor de floristería";
	Floristeria mf = Floristeria.getInstancia(null);
	
	public void start() {
		System.out.println(HEAD);
		boolean salir = false;
		while(!salir) {
			mostrarMenu(MAIN_MENU_OPT);
			switch(askOptionNumberBetween(MAIN_MENU_OPT.length)) {
				case 1: 
					subMenuAddProduct();
					break;
				case 2: 
					escogeTipoStock();
					break;
				case 3:
					venderObjeto();
					break;
				case 4: 
					consultaDatos();
					break;
				case 5: 
					salir = true;
					System.out.println("¡Hasta pronto!");
					break;
			}
		}
	}
	
	
	public void mostrarMenu(String[] opciones) {
		System.out.println(PEDIR_ELECCION);
		for(String s: opciones) {
			System.out.println(s);
		}
	}
	
	
	public void escogeTipoStock() {
		mostrarMenu(STOCK_MENU_OPT);
		int opcio = askOptionNumberBetween(STOCK_MENU_OPT.length);
		switch(opcio) {
			case 1: 
				mf.mostrarStockFlores();
				break;
			case 2:
				mf.mostrarStockArboles();
				break;
			case 3: 
				mf.mostrarStockDeco();
				break;
			case 4:
				mf.mostrarStockTotal();
				break;
		}
	}
	
	public void subMenuAddProduct() {
		System.out.println("\nIndica el producto que quieres añadir a stock: ");
		mostrarMenu(PRODUCT_MENU_OPT);
		int opcion = askOptionNumberBetween(PRODUCT_MENU_OPT.length);
		switch(opcion) {
			case 1:
				mf.addToStock(crearFlor());
				break;
			case 2:
				mf.addToStock(crearArbol());
				break;
			case 3:
				mf.addToStock(crearObjetoDeco());
				break;
		}
	}
	
	private IProducto crearFlor() {
		System.out.print("Nombre: ");
		String nombre = pedirString();
		System.out.print("\nColor: ");
		String color = pedirString();
		System.out.print("\nPrecio: ");
		double precio = pedirDouble();
		Flor f = new Flor(nombre, color, precio);
		return f;
	}
	
	private IProducto crearArbol() {
		System.out.print("Nombre: ");
		String nombre = pedirString();
		System.out.print("\nAltura: ");
		String altura = pedirString();
		System.out.print("\nPrecio: ");
		double precio = pedirDouble();
		Arbol a = new Arbol(nombre, altura, precio);
		return a;
	}
	
	private IProducto crearObjetoDeco() {
		System.out.print("Nombre: ");
		String nombre = pedirString();
		System.out.print("\nMaterial: ");
		String material = pedirString();
		System.out.print("\nPrecio: ");
		double precio = pedirDouble();
		Decoracion o = new Decoracion(nombre, material, precio);
		return o;
	}
	
	private void venderObjeto() {
		System.out.println("\nIndica el producto que quieres vender: ");
		mostrarMenu(PRODUCT_MENU_OPT);
		int opcio = askOptionNumberBetween(PRODUCT_MENU_OPT.length);
		switch(opcio) {
			case 1:
				mf.mostrarStockFlores();
				mf.vender(crearFlor());
				break;
			case 2:
				mf.mostrarStockArboles();
				mf.vender(crearArbol());
				break;
			case 3:
				mf.mostrarStockDeco();
				mf.vender(crearObjetoDeco());
				break;
		}
	}
	
	
	public int askOptionNumberBetween(int numOpciones) {
		int opcion = 0;
		boolean valorCorrecto = false;
		System.out.println("Por favor introduce un número según la opción escogida: ");
		while(!valorCorrecto) {
			System.out.print("> ");
			if(sc.hasNextInt()) {
				opcion = sc.nextInt();
				if((opcion > 0)&&(opcion <= numOpciones)) {
					valorCorrecto = true;
				}else {
					System.out.println(INVALID_OPTION);
				}
			}else {
				System.out.println(UNEXPECTED_VALUE);
				sc.nextLine();
			}
		}
		sc.nextLine();
		return opcion;
	}
	
	public String pedirString() {
		String s;
		do {
			s = sc.nextLine();
		}while(s.isEmpty());
		//sc.nextLine();
		return s;
	}
	
	public double pedirDouble() {
		double d = 0;
		do {
			if(sc.hasNextDouble()) {
				d = sc.nextDouble();
			}else {
				System.out.println(UNEXPECTED_VALUE);
				sc.nextLine();
			}
		}while(d == 0);	
		return d;
	}
	
	public void consultaDatos() {
		mostrarMenu(TICKET_MENU);
		switch(askOptionNumberBetween(TICKET_MENU.length)) {
			case 1: 
				mf.mostrarFacturacion();
				break;
			case 2:
				mf.returnTotalFacturado();
				break;
		}
	}

}
