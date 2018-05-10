/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.ModalidadDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class ModalidadLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new ModalidadDB();
		return db.getAll(obj);
	}

}
