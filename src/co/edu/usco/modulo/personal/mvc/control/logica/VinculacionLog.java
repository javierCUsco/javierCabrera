/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.VinculacionDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class VinculacionLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new VinculacionDB();
		return db.getAll(obj);
	}

}
