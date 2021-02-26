/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.InstitucionEducativaDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class InstitucionEducativaLog {
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		ConexionDB db=new InstitucionEducativaDB();
		Mensaje mensaje= new Mensaje();
		mensaje.setResultado(db.getAll(obj));
		System.out.print(mensaje);
		return mensaje;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static Object getObject(Object obj) {
		// TODO Auto-generated method stub
		ConexionDB db=new InstitucionEducativaDB();
		return db.getObject(obj);
	}
}
