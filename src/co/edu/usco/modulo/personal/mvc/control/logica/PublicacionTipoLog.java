/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.PublicacionTipoDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PublicacionTipoLog {

	/**
	 * 
	 */
	public PublicacionTipoLog() {
		// TODO Auto-generated constructor stub
	}

	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		ConexionDB db=new PublicacionTipoDB();
		return db.getAll(obj);
	}

	
}
