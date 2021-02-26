/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica.pensionado;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.pensionado.TipoPensionDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;

/**
 * @author ING. JAVIER CABRERA LASSO
 *
 */
public class TipoPensionLog {

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static Object getLista(Object obj) {
		ConexionDB db = new TipoPensionDB();
		return db.getAll(obj);
	}

}
