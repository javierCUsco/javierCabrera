/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class EstratoOb implements Serializable {

	private int est_codigo;
	private String est_nombre;
	/**
	 * @return the est_codigo
	 */
	public int getEst_codigo() {
		return est_codigo;
	}
	/**
	 * @param est_codigo the est_codigo to set
	 */
	public void setEst_codigo(int est_codigo) {
		this.est_codigo = est_codigo;
	}
	/**
	 * @return the est_nombre
	 */
	public String getEst_nombre() {
		return est_nombre;
	}
	/**
	 * @param est_nombre the est_nombre to set
	 */
	public void setEst_nombre(String est_nombre) {
		this.est_nombre = est_nombre;
	}
	
}
