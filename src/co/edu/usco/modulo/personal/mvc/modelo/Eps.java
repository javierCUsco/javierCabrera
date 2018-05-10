/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Eps implements Serializable {
	private int eps_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String eps_nombre;//varchar](150) NOT NULL,
	private String per_numero_afiliacion_eps;
	/**
	 * @return the eps_codigo
	 */
	public int getEps_codigo() {
		return eps_codigo;
	}
	/**
	 * @param eps_codigo the eps_codigo to set
	 */
	public void setEps_codigo(int eps_codigo) {
		this.eps_codigo = eps_codigo;
	}
	/**
	 * @return the eps_nombre
	 */
	public String getEps_nombre() {
		return eps_nombre;
	}
	/**
	 * @param eps_nombre the eps_nombre to set
	 */
	public void setEps_nombre(String eps_nombre) {
		this.eps_nombre = eps_nombre;
	}
	/**
	 * @return the per_numero_afiliacion_eps
	 */
	public String getPer_numero_afiliacion_eps() {
		return per_numero_afiliacion_eps;
	}
	/**
	 * @param per_numero_afiliacion_eps the per_numero_afiliacion_eps to set
	 */
	public void setPer_numero_afiliacion_eps(String per_numero_afiliacion_eps) {
		this.per_numero_afiliacion_eps = per_numero_afiliacion_eps;
	}
	
	
}
