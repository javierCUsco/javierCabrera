/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.Publicacion_tipoDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Publicacion_tipo_log {

	/**
	 * 
	 */
	public Publicacion_tipo_log() {
		// TODO Auto-generated constructor stub
	}

	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new Publicacion_tipoDB();
		return db.getAll(obj);
	}

	
}
