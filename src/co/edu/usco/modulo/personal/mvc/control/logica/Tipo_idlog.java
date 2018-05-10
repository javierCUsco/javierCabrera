/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.Tipo_idDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Tipo_idlog {

	/**
	 * 
	 */
	public Tipo_idlog() {
		// TODO Auto-generated constructor stub
	}

	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new Tipo_idDB();
		return db.getAll(obj);
	}

	
}
