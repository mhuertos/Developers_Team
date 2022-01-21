package nivel3;

import java.util.Iterator;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Conexion {
	
	MongoClient client = MongoClients.create();
	MongoDatabase database = client.getDatabase("Floristeria");
		
	public void insertarProducto(IProducto producto) {
		Document document = new Document();
		document.put("nombre", producto.getNombre());
		document.put("atributo", producto.getAtributo());
		document.put("precio", producto.getPrecio());
		document.put("tipo", producto.getTipo());
		MongoCollection<Document> collection = database.getCollection("Producto");
		collection.insertOne(document);
	}
	
	public boolean existeDocumento(String nombreProducto) {
		boolean existe = false;
		MongoCollection<Document> collection = database.getCollection("Producto");
		Document findDocument = new Document("nombre", nombreProducto);
		FindIterable<Document> document =  collection.find(findDocument);
		if(document.first() != null){
			existe = true;
		}
		return existe;
	}
	
	//Función copiada de mostrarDocumentos,para no alterarla:
	public void mostrarDocumentos(String tipoDocumento, String nombreColeccion) {
		MongoCollection<Document> collection = database.getCollection(nombreColeccion);
		Iterable<Document> resultDocuments = devuelveIterable(tipoDocumento, collection);
		Iterator<Document> it = resultDocuments.iterator();
		if(it.hasNext()) {
			while(it.hasNext()) {
				System.out.println(it.next().toString());
			}
		}else {
			System.out.println("No hay resultados para "+tipoDocumento);
		}
	}
	
	public Iterable<Document> devuelveIterable(String tipoDocumento, MongoCollection<Document> c) {
		Iterable<Document> resultDocuments;
		if(tipoDocumento == null) {
			resultDocuments = c.find();
		}else {
			Document findDocument = new Document("tipo", tipoDocumento);
			resultDocuments = c.find(findDocument);
		}
		return resultDocuments;
	}
	
	public void añadirVenta(String nombreProducto) {
		MongoCollection<Document> collectionProducto = database.getCollection("Producto");
		
		Document documentoProducto = new Document("nombre", nombreProducto);
		Document documentoEncontrado = collectionProducto.findOneAndDelete(documentoProducto);
		
		Document documentoTicket = new Document("nombre", nombreProducto);
		documentoTicket.append("atributo", documentoEncontrado.getString("atributo"));
		documentoTicket.append("precio", documentoEncontrado.getDouble("precio"));
		documentoTicket.append("tipo", documentoEncontrado.getString("tipo"));	
		
		MongoCollection<Document> collectionTicket = database.getCollection("Ticket");
		collectionTicket.insertOne(documentoTicket);
	}
	
	public double sumarFacturacion() {
		double sumatorio = 0.0;
		MongoCollection<Document> collection = database.getCollection("Ticket");
		Iterable<Document> resultDocuments = collection.find();
		Iterator<Document> it = resultDocuments.iterator();
		if(it.hasNext()) {
			while(it.hasNext()) {
				sumatorio += it.next().getDouble("precio");
			}
		}
		return sumatorio;
	}
}
