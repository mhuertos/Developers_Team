package nivel3;

import java.util.Scanner;

public class Utiles {
	
	private static Scanner sc = new Scanner(System.in);
	
	
	public static String pedirAtributo(String atributo){
		System.out.println("Por favor introduce "+ atributo+": ");
		String caracteristica = "";
		while(caracteristica.isEmpty()) {
			caracteristica = sc.next();
			sc.nextLine();
		}
		return caracteristica;
	}
	
	public static double pedirDouble(String atributo) {
		System.out.println("Por favor introduce "+ atributo+": ");
		double precio = 0.0;
		boolean valorValid = false;
		while(!valorValid) {
			if(sc.hasNextDouble()) {
				precio = sc.nextDouble();
				valorValid = true;
			}else {
				System.out.println("Eso no es un valor válido");
			}
			sc.nextLine();
		}
		return precio;
	}
	
	public static int pedirEntero() {
		System.out.print("> ");
		int num = 0;
		do {
			if(sc.hasNextInt()) {
				num = sc.nextInt();
			}else {
				System.out.println("Por favor, introduce un número correcto");
			}
			sc.nextLine();
		}while(num == 0);
		return num;
	}

}
