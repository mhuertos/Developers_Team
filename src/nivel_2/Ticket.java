package nivel_2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Ticket {
	
	private final String NOMBRE_TABLA = "ticket";
	
	public void updateTicket(IProducto producto, Connection cn) {
		String insertQuery = "INSERT INTO "+NOMBRE_TABLA+" VALUES "+getInsertQuery(producto);

		try {
			Statement stm = cn.createStatement();
			int rs = stm.executeUpdate(insertQuery);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getInsertQuery(IProducto p) {
		return "("+"default, '"+p.getNombre()+"', "+p.getPrecio()+")";
	}
	
	

}
