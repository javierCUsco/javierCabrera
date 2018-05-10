/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.LNX_regimenDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class LNX_regimenLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new LNX_regimenDB();
		return db.getAll(obj);
	}

}
