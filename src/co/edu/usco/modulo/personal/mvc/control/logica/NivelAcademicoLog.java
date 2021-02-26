/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.NivelAcademicoDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class NivelAcademicoLog {

	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
				ConexionDB db=new NivelAcademicoDB();
				Mensaje mensaje= new Mensaje();
				mensaje.setResultado(db.getAll(obj));
				System.out.print(mensaje);
				return mensaje;
	}

}
