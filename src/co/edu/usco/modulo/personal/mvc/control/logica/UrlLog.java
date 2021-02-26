package co.edu.usco.modulo.personal.mvc.control.logica;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.UrlDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;

public class UrlLog {

	public static Object getObject(Object obj){
		ConexionDB db= new UrlDB();
		return db.getObject(obj);
	}
}
