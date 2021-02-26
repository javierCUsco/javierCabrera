package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.WebParametroDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class WebParametroLog {

	/**
	 * @param obj
	 * @return
	 */
	public static Object getObject(Object obj){
		ConexionDB db= new WebParametroDB();
		return db.getObject(obj);
	}


	
}
