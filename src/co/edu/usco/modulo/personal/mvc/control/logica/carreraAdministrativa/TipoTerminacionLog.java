/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.carreraAdministrativa.TipoTerminacionDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class TipoTerminacionLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		ConexionDB db=new TipoTerminacionDB();
		return db.getAll(obj);
	}
}
