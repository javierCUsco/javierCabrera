package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.Web_parametroDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

public class Wep_parametroLog {

	public static Object getObject(Object obj){
		conexion db= new Web_parametroDB();
		return db.getObject(obj);
	}
}
