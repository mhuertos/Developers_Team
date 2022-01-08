package nivel1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stock {
	
	List<Producto> products = new ArrayList<Producto>();
	
	public void addToStock(Producto p) {
		products.add(p);
	}
	
	//Eliminar una existencia d'un producte:
	public void removeToStock(Producto p) {
		Iterator <Producto> mi_it = products.listIterator(0);
		while(mi_it.hasNext()) {
			if(mi_it.next().equals(p)) {
				mi_it.remove();
			}
		}
	}
	
	//Comprovar existencia producto en Stock
	public boolean productOnStock(Producto p) {
		if(products.contains(p)) {
			return true;
		}else {
			return false;
		}
	}
	
	//Devuelve una lista con todos los objetos en Stock
	public void getStock() {
		for(Producto p: products) {
			System.out.println(p.toString());
		}
	}
	
	public double getSumaPreus() {
		double suma = 0;
		for(Producto p:products) {
			suma += p.getPrecio();
		}
		return suma;
	}

}
