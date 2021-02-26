/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.carreraAdministrativa.TipoNotificacionDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class TipoNotificacionLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		ConexionDB db=new TipoNotificacionDB();
		return db.getAll(obj);
	}
}
