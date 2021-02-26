/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.LNX_naturalezaDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class LNXNaturalezaLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		ConexionDB db=new LNX_naturalezaDB();
		return db.getAll(obj);
	}

}
