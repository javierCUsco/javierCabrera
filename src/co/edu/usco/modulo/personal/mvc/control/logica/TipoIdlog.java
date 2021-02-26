/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.TipoIdDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class TipoIdlog {

	/**
	 * 
	 */
	public TipoIdlog() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param obj
	 * @return
	 */
	public static Object getLista(Object obj) {
		ConexionDB db=new TipoIdDB();
		Mensaje mensaje= new Mensaje();
		mensaje.setResultado(db.getAll(obj));
		return mensaje;
	}

	
}
