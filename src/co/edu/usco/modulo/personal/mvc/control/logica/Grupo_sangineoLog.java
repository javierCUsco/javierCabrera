/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.Grupo_sangineoDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

/**
 * @author Ingeniero Javier
 *
 */
public class Grupo_sangineoLog {

	/**
	 * 
	 */
	public Grupo_sangineoLog() {
		// TODO Auto-generated constructor stub
	}
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new Grupo_sangineoDB();
		return db.getAll(obj);
	}


}
