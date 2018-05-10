/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.UsuarioDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author Javier cabrera
 *
 */
public class UsuarioLog {

	public static Object esusuario(Object user,Object parametro) {
		conexion db= new UsuarioDB();
		Object param[]={user,parametro};
		boolean dato=(Boolean) db.esObject(param);
		
		String msm="";

		if(dato==false){
			
			msm= "usuario o clave invalida..";
		}
		Mensaje memsaje= new Mensaje(dato,msm, null);
		return memsaje; 
		
	}

	public static Object getUsuario(Usuario user, Object parametro) {
		conexion db= new UsuarioDB();
		Object param[]={user,parametro};
		return db.getObject(param);
	}

}
