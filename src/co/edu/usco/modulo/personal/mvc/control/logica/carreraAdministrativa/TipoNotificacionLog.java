/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.carreraAdministrativa.Tipo_notificacionDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class TipoNotificacionLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new Tipo_notificacionDB();
		return db.getAll(obj);
	}
}
