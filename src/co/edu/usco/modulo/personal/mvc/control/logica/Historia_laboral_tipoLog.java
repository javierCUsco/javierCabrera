/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.Historia_laboral_tipoDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Historia_laboral_tipoLog {

	public static Object getLista(Object obj) {
		conexion db= new Historia_laboral_tipoDB();
		return db.getAll(obj);
	}
	
	
}
