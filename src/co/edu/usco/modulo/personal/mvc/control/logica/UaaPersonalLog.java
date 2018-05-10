/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import java.util.List;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.UaaPersonalDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.UaaPersonal;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class UaaPersonalLog {
	static conexion db=null;
	public static Object getLista(Object object) {
		 db= new UaaPersonalDB();
		 List<UaaPersonal> lista=(List<UaaPersonal>) db.getAll(object);
		 if(lista==null || lista.size()==0){
			 UaaPersonal uaaPersonal= new UaaPersonal();
			 uaaPersonal.getPersona().setPer_nombre("No se encontro vinculacion por favor comicarse con talento humano");
			 lista.add(uaaPersonal);
		 }
		 return lista; 	
	}
	
	public static Object getObject(Object object) {
		db= new UaaPersonalDB();
		return db.getObject(object);
		
	}

}
