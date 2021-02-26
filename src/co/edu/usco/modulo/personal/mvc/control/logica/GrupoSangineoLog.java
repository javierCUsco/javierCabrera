/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.GrupoSanguineoDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;

/**
 * @author Ingeniero Javier
 *
 */
public class GrupoSangineoLog {

	/**
	 * 
	 */
	public GrupoSangineoLog() {
		// TODO Auto-generated constructor stub
	}
	public static Object getLista(Object obj) {
		
		Mensaje mensaje= new Mensaje();
		ConexionDB db=new GrupoSanguineoDB();
		mensaje.setResultado(db.getAll(obj));
		return mensaje;
	}


}
