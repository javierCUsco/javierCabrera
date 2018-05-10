/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import java.util.LinkedList;

import co.edu.usco.modulo.personal.mvc.modelo.GeneroOb;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class GeneroLog {

	public static Object getLista(Object combo) {
		// TODO Auto-generated method stub
		 LinkedList<GeneroOb> lista = new LinkedList<GeneroOb>();
		 GeneroOb elemento= new GeneroOb();
		 elemento.setGen_codigo('M');
		 elemento.setGen_nombre("MASCULINO");
		 lista.add(elemento);
		 elemento= new GeneroOb();
		 elemento.setGen_codigo('F');
		 elemento.setGen_nombre("FEMENINO");
		 lista.add(elemento);
		 return lista;
	}

}
