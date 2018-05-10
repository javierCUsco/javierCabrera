/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.Estado_civilDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Estado_civilLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new Estado_civilDB();
		return db.getAll(obj);
	}

}
