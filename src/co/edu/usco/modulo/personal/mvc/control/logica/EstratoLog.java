/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import java.util.LinkedList;

import co.edu.usco.modulo.personal.mvc.modelo.EstratoOb;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class EstratoLog {

	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		 LinkedList<EstratoOb> lista = new LinkedList<EstratoOb>();
		 for(int i=1;i<=10; i++){
			 EstratoOb elemento= new EstratoOb();
			 elemento.setEst_codigo(i);
			 elemento.setEst_nombre(""+i);
			 lista.add(elemento);
		 }
		 return lista;
	}
}
