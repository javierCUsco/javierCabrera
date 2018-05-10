package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.UrlDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;

public class UrlLog {

	public static Object getObject(Object obj){
		conexion db= new UrlDB();
		return db.getObject(obj);
	}
}
