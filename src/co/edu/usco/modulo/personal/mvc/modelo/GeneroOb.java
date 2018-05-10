/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class GeneroOb implements Serializable {

	private char gen_codigo;
	private String gen_nombre;
	/**
	 * @return the gen_codigo
	 */
	public char getGen_codigo() {
		return gen_codigo;
	}
	/**
	 * @param gen_codigo the gen_codigo to set
	 */
	public void setGen_codigo(char gen_codigo) {
		this.gen_codigo = gen_codigo;
	}
	/**
	 * @return the gen_nombre
	 */
	public String getGen_nombre() {
		return gen_nombre;
	}
	/**
	 * @param gen_nombre the gen_nombre to set
	 */
	public void setGen_nombre(String gen_nombre) {
		this.gen_nombre = gen_nombre;
	}
	
}
