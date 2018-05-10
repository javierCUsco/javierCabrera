/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.carreraAdministrativa.Tipo_terminacionDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class TipoTerminacionLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new Tipo_terminacionDB();
		return db.getAll(obj);
	}
}
