/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.UsuarioDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionUscoDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author Javier cabrera
 *
 */
public class UsuarioLog {

	/**
	 * @param user
	 * @param parametro
	 * @return
	 */
	public static Object esusuario(Object user,Object parametro) {
		ConexionDB db= new UsuarioDB();
		Object param[]={user,parametro};
		boolean dato=(Boolean) db.esObject(param);
		
		String msm="";

		if(dato==false){
			
			msm= "usuario o clave invalida..";
		}
		Mensaje memsaje= new Mensaje(dato,msm, null,null);
		return memsaje; 
		
	}

	/**
	 * @param user
	 * @param parametro
	 * @return
	 */
	public static Object getUsuario(Usuario user, Object parametro) {
		ConexionDB db= new UsuarioDB();
		Object param[]={user,parametro};
		return db.getObject(param);
	}

	/**
	 * @param obj
	 * @return
	 */
	public static boolean getJefes(Object obj) {
		ConexionUscoDB db= new UsuarioDB();
		int total= Integer.parseInt(String.valueOf(db.getTotal(obj)));
		boolean si=true;
		if(total==0) {
			si=false;
		}System.out.println(si);
		return si;
	}

	public static Mensaje validaUsuario(Object parametro) {
		ConexionDB db= new UsuarioDB();
		Mensaje mensaje= new Mensaje();
		mensaje.setValido((Boolean) db.esObject(parametro));
		
		return mensaje;
	}
}
