package nivel1;

public class Main {

	public static void main(String[] args) {
		
		//Floristeria
		Floristeria miFloristeria = Floristeria.getInstancia("Flor & Deco");
		
		//Arboles
		Arbol arbol_1 = new Arbol("Nogal", 5.00, 500);
		Arbol arbol_2 = new Arbol("Cerezo", 4.20, 100);
		Arbol arbol_3 = new Arbol("Manzano", 2.89, 250);
		
		//Flores
		Flor flor_1 = new Flor("Rosa", "rojo", 6.30);
		Flor flor_2 = new Flor("Amapola", "blanco", 12.00);
		Flor flor_3 = new Flor("Margarita", "amarillo", 3.00);
		
		//ObjetosDeco
		ObjetoDecoracion obj_1 = new ObjetoDecoracion("Lámpara", "fusta", 20.95);
		ObjetoDecoracion obj_2 = new ObjetoDecoracion("Cabeza Buda", "plastic", 12.50);
		ObjetoDecoracion obj_3 = new ObjetoDecoracion("cesta", "plastic", 14.95);
		
		
		//Añadir arboles:
		miFloristeria.addToStockArboles(arbol_1);
		miFloristeria.addToStockArboles(arbol_2);
		miFloristeria.addToStockArboles(arbol_3);
		
		//Añadir flores:
		miFloristeria.addToStockFlores(flor_1);
		miFloristeria.addToStockFlores(flor_2);
		miFloristeria.addToStockFlores(flor_3);
		
		//Añadir decoración:
		miFloristeria.addToStockDecoracion(obj_1);
		miFloristeria.addToStockDecoracion(obj_2);
		miFloristeria.addToStockDecoracion(obj_3);
		
		Arbol arbol_4 = new Arbol("Peral", 3.23, 340.00);
		Arbol arbol_5 = new Arbol("Peral", 3.23, 340.00);
		miFloristeria.addToStockArboles(arbol_4);
		miFloristeria.addToStockArboles(arbol_5);
		
		/*Consultat stock
		miFloristeria.printStock();
		miFloristeria.printStockArboles();
		miFloristeria.printStockFlores();
		miFloristeria.printStockDecoracion();*/
		
		/*Eliminación stock
		miFloristeria.printStockArboles();
		miFloristeria.removeArbol(arbol_4);
		miFloristeria.printStockArboles();
		miFloristeria.printStock();*/
		
		
		//Printar valor total de la floristeria
		miFloristeria.getInversio();
		
		//Printar el valor recaudat per vendes
		miFloristeria.venderArboles(arbol_1);
		miFloristeria.venderArboles(arbol_1);
		miFloristeria.getRecaudació();
		
		//Printar el total de vendes
		miFloristeria.getTicket();
		
		
		
	}

}
