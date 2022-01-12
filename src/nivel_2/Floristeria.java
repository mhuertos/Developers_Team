package nivel_2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexionBD.Conexion;

public class Floristeria {
	
	private static Floristeria instancia;
	private String nombre;
	private Ticket ticket = new Ticket();
	private static Conexion conexion = new Conexion();
	private static Connection cn = conexion.conectar();
	
	
	private Floristeria(String nombre) {
		this.nombre = nombre;
	}
	
	public static Floristeria getInstancia(String nombre) {
		if(instancia == null) {
			return new Floristeria(nombre);
		}
		return instancia;
	}
	
	public void addToStock(IProducto producto) {
		String insertQuery = "INSERT INTO "+ producto.getNombreTabla()+" VALUES "+producto.getInsertQuery();
		try {
			Statement stm = cn.createStatement();
			int rs = stm.executeUpdate(insertQuery);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Inserción completada correctamente.");
	}
	
	public void removeToStock(IProducto producto) {
		if(consultaExistencias(producto)) {
			eliminacion(producto);
			System.out.println("Producto eliminado correctamente.");
		}else {
			System.out.println("No quedan más productos del tipo: "+producto.getNombre());
		}
	}
	
	
	
	public void mostrarStockFlores() {
		mostrarProductos(Flor.NOMBRE_TABLA);
	}
	
	public void mostrarStockArboles() {
		mostrarProductos(Arbol.NOMBRE_TABLA);
	}

	public void mostrarStockDeco() {
		mostrarProductos(Decoracion.NOMBRE_TABLA);
	}
	
	public void mostrarStockTotal() {
		mostrarStockArboles();
		mostrarStockDeco();
		mostrarStockFlores();
	}
	
	public void vender(IProducto producto) {
		if(consultaExistencias(producto)) {
			ticket.updateTicket(producto, cn);
			eliminacion(producto);
			System.out.println("Venta hecha correctamente.");
		}else {
			System.out.println("Lo siento, no quedan más unidades de este producto.");
		}
	}
	
	private boolean consultaExistencias(IProducto producto) {
		String query = "SELECT count(*) FROM "+
						producto.getNombreTabla()+
						" WHERE nombre = '"+producto.getNombre()+"'";
		boolean exists = false;

		try {
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			rs.next();
			if(rs.getInt(1) != 0) {
				exists = true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return exists;
	}
	
	private void eliminacion(IProducto producto) {
		String deleteQuery = "DELETE FROM "+producto.getNombreTabla()+" WHERE nombre = '"+producto.getNombre()+"' LIMIT 1";
		try {
			Statement stm = cn.createStatement();
			int rs = stm.executeUpdate(deleteQuery);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void mostrarProductos(String tabla) {
		String query = "SELECT * FROM "+tabla;
		
		try {
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDouble(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mostrarFacturacion() {
		String query = "SELECT * FROM ticket";
		try {
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void returnTotalFacturado() {
		double totalFactura = 0;
		String query = "SELECT sum(precio) FROM ticket";
		try {
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			rs.next();
			totalFactura = rs.getDouble(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Se ha facturado: "+totalFactura+" euros.");
	}
	
}
