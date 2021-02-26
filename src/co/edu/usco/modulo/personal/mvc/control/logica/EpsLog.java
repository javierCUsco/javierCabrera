/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.EpsDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class EpsLog {
	public static Object getLista(Object obj) {
		ConexionDB db=new EpsDB();
		Mensaje mensaje= new Mensaje();
		mensaje.setResultado(db.getAll(obj));
		return mensaje;
	}

}
