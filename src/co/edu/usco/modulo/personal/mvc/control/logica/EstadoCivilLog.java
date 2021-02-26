/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.Estado_civilDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class EstadoCivilLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		Mensaje mensaje= new Mensaje();
		ConexionDB db=new Estado_civilDB();
		mensaje.setResultado(db.getAll(obj));
		return mensaje;
	}

}
