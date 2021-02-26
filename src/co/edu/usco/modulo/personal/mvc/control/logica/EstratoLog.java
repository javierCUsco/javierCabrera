/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import java.util.LinkedList;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.EstratoDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class EstratoLog {
	
	/**
	 * @param combo
	 * @return
	 */
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		ConexionDB db=new EstratoDB();
		Mensaje mensaje= new Mensaje();
		mensaje.setResultado(db.getAll(obj));
		return mensaje;
	}

//	public static Object getLista(Object obj) {
//		// TODO Auto-generated method stub
//		 LinkedList<Estrato> lista = new LinkedList<Estrato>();
//		 for(int i=1;i<=10; i++){
//			 Estrato elemento= new Estrato();
//			 elemento.setCodigo(i);
//			 elemento.setNombre(""+i);
//			 lista.add(elemento);
//		 }
//		 EstratoLog
//		 return lista;
//	}
}
