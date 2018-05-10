/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author ING_JAVIER
 *
 */
@SuppressWarnings("serial")
public class JornadaOb implements Serializable{
	
	private int jor_codigo;
	private String jor_nombre;
	private int sippa_jor_codigo;

	/**
	 * 
	 */
	public JornadaOb() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the jor_codigo
	 */
	public int getJor_codigo() {
		return jor_codigo;
	}

	/**
	 * @param jor_codigo the jor_codigo to set
	 */
	public void setJor_codigo(int jor_codigo) {
		this.jor_codigo = jor_codigo;
	}

	/**
	 * @return the jor_nombre
	 */
	public String getJor_nombre() {
		return jor_nombre;
	}

	/**
	 * @param jor_nombre the jor_nombre to set
	 */
	public void setJor_nombre(String jor_nombre) {
		this.jor_nombre = jor_nombre;
	}

	/**
	 * @return the sippa_jor_codigo
	 */
	public int getSippa_jor_codigo() {
		return sippa_jor_codigo;
	}

	/**
	 * @param sippa_jor_codigo the sippa_jor_codigo to set
	 */
	public void setSippa_jor_codigo(int sippa_jor_codigo) {
		this.sippa_jor_codigo = sippa_jor_codigo;
	}

	
	
}
