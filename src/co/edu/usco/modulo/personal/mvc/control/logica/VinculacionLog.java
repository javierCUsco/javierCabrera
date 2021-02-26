/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import javax.servlet.http.HttpServletRequest;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.PersonaDB;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.VinculacionDB;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.seguridad.seguridad;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class VinculacionLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		ConexionDB db=new VinculacionDB();
		Mensaje mensaje= new Mensaje();
		mensaje.setResultado(db.getAll(obj));
		return mensaje;
	}
}
