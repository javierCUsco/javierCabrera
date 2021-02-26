/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import java.sql.Connection;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.AdminDB;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.Url;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author ING_JAVIER
 *
 */
public class AdminLog {

	public static Object getObject(Object obj) {
		ConexionDB db = new AdminDB();
		Mensaje msm = new Mensaje(false, "Error en la segunda clave ", null,null);
		Usuario user = (Usuario) db.getObject(obj);
		msm.setResultado(user);
//		Conexion consegura = new Conexion();
//		Connection connection = null;
//		connection = consegura.getconn_admin(user);
//		if (connection != null) {
//			msm.setMsm("");
//			msm.setValido(true);
//			msm.setResultado(user);
//		}
//		System.out.println(msm);
		return msm;
	}
	
	public static Object getValidaUsuarioAdmin(Object obj) {
		ConexionDB db = new AdminDB();
		Mensaje msm = new Mensaje(false, "Error en la segunda clave ", null,null);
		Usuario user = (Usuario) db.getObject(obj);
		
		AdminDB admin= new AdminDB();
		user=admin.getClaveReal(user);
		user.setUrl((Url) UrlLog.getObject(obj));
		try {
		Conexion consegura = new Conexion();
		Connection connection = null;
		connection = consegura.getconn_admin(user);
		System.out.println(msm);
		if (connection != null) {
			msm.setMsm("");
			msm.setValido(true);
			Object datos[]= {user.getPersona(),null};
			Mensaje mensaje= (Mensaje)PersonaLog.getObject(datos);
			user.getPersona().setApellido(((Persona) mensaje.getResultado()).getApellido());
			user.getPersona().setApellido2(((Persona) mensaje.getResultado()).getApellido2());
			user.getPersona().setNombre(((Persona) mensaje.getResultado()).getNombre());
			user.getPersona().setNombre2(((Persona) mensaje.getResultado()).getNombre2());
			msm.setResultado(user);
		}
		connection.close();
		}catch (Exception e) {
			System.out.println("error al validar usuario real  "+e);
		}
		System.out.println(msm);
		return msm;
	}

}
