package nivel3;

public class FactoryProductos {
	public IProducto getProducto(String tipoProducto) {
		if(tipoProducto.equalsIgnoreCase("Arbol")){
			return new Arbol();
		}else if(tipoProducto.equalsIgnoreCase("Flor")){
			return new Flor();
		}else if(tipoProducto.equalsIgnoreCase("Decoracion")) {
			return new Decoracion();
		}else {
			System.out.println("No corresponde a un producto.");
		}
		return null;
	}
}
