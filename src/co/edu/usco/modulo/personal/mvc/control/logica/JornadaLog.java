/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.JornadaDB;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.ModalidadDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class JornadaLog {

	/**
	 * 
	 */
	public JornadaLog() {
		// TODO Auto-generated constructor stub
	}

	public static Object getLista(Object obj) {
		ConexionDB db=new JornadaDB();
		Mensaje mensaje= new Mensaje();
		mensaje.setResultado(db.getAll(obj));
		return mensaje;
	}

}
