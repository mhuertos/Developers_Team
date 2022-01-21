package nivel3;

public class App {

	public static void main(String[] args) {
		
		Floristeria f1 = Floristeria.getInstancia("Joya de Barcelona");
		
		System.out.println(Menu.WELCOME);
		boolean exit = false;
		do {
			Menu.mainMenu(); 
			switch(Utiles.pedirEntero()) {
				case 1:
					f1.addStock(Menu.escogeTipoObjeto());
					break;
				case 2:
					f1.mostrarStock(Menu.escogeTipoStock());
					break;
				case 3:
					f1.sell(Utiles.pedirAtributo("nombre"));
					break;
				case 4:
					Menu.menuTicket();
					break;
				case 5:
					System.out.println("Adiós");
					exit = true;
					break;
				default:
					System.out.println("Opción incorrecta");	
			}
		}while(!exit);
	}
}
