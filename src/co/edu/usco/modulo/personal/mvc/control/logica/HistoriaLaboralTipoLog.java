/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.HistoriaLaboralTipoDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class HistoriaLaboralTipoLog {

	/**
	 * @param obj
	 * @return {@link Object}
	 */
	public static Object getLista(Object obj) {
		ConexionDB db = new HistoriaLaboralTipoDB();
		Mensaje mensaje = new Mensaje();
		mensaje.setResultado(db.getAll(obj));
		return mensaje;
	}

}
