/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.Institucion_educativaDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Institucion_educativaLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new Institucion_educativaDB();
		return db.getAll(obj);
	}
}
