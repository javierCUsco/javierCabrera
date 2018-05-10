/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.Uaa_cargoDB;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.VinculacionDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.UaaCargo;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Uaa_cargoLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new Uaa_cargoDB();
		return db.getAll(obj);
	}

	public static Object getObject(Object obj) {
		conexion db=new Uaa_cargoDB();
		return db.getObject(obj);
	}
}
