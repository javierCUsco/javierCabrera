/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica.pensionado;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.pensionado.Tipo_pensionDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

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
		conexion db = new Tipo_pensionDB();
		return db.getAll(obj);
	}

}
