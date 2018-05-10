/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.PaisDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PaisLog {

	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new PaisDB();
		return db.getAll(obj);
	}

}
