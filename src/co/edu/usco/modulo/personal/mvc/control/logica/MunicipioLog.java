/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.MunicipioDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class MunicipioLog {

	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new MunicipioDB();
		return db.getAll(obj);
	}

}
