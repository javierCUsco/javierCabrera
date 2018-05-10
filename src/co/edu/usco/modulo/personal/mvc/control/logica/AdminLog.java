/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import java.sql.Connection;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.AdminDB;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author ING_JAVIER
 *
 */
public class AdminLog {

	public static Object getObject(Object obj) {
		conexion db = new AdminDB();
		Mensaje msm = new Mensaje(false, "no es adminstrador ", null);
		Usuario user = (Usuario) db.getObject(obj);
		Conexion consegura = new Conexion();
		Connection connection = null;
		connection = consegura.getconn_admin(user);
		if (connection != null) {
			msm.setMsm("");
			msm.setValido(true);
			msm.setResultado(user);
		}
		return msm;
	}

}
