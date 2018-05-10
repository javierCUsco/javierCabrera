/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class loginLog {
	public static Object login(Object user) {

		return UsuarioLog.esusuario(user, null);
	
	}

	public static Object getObject(Usuario user) {
		// TODO Auto-generated method stub
		return UsuarioLog.getUsuario(user, null);
		
	}
}
