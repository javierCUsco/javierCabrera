/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.DepartamantoDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class DepartamentoLog {

	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		ConexionDB db=new DepartamantoDB();
		return db.getAll(obj);
	}

}
