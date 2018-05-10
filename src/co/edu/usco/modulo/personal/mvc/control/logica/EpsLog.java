/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.EpsDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class EpsLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new EpsDB();
		return db.getAll(obj);
	}

}
