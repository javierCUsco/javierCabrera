/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.GeneroDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class GeneroLog {

	/**
	 * @param combo
	 * @return
	 */
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		ConexionDB db=new GeneroDB();
		Mensaje mensaje= new Mensaje();
		mensaje.setResultado(db.getAll(obj));
		return mensaje;
	}

}
