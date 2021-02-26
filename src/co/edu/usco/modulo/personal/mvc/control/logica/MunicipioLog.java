/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.MunicipioDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class MunicipioLog {

	
	/**
	 * @param obj
	 * @return
	 */
	public static Object getLista(Object obj) {
		ConexionDB db=new MunicipioDB();
		return db.getAll(obj);
	}

	/**
	 * @param obj
	 * @return
	 */
	public static Object getObject(Object obj) {
		ConexionDB db=new MunicipioDB();
		return db.getObject(obj);
	}
}
