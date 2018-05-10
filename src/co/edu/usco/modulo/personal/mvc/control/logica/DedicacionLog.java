/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.DedicacionDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class DedicacionLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new DedicacionDB();
		return db.getAll(obj);
	}

}
