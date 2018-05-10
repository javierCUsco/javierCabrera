/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.carreraAdministrativa.Tipo_actualizacionDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class TipoActualizacionLog {
	public static Object getLista(Object obj) {
		conexion db=new Tipo_actualizacionDB();
		return db.getAll(obj);
	}
}
