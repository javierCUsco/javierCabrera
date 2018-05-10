/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Grupo_sangineoOb implements Serializable {

	private int grs_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String grs_nombre;//varchar](50) NOT NULL,
	private int sippa_grs_codigo;//tinyint] NULL,
	/**
	 * @return the grs_codigo
	 */
	public int getGrs_codigo() {
		return grs_codigo;
	}
	/**
	 * @param grs_codigo the grs_codigo to set
	 */
	public void setGrs_codigo(int grs_codigo) {
		this.grs_codigo = grs_codigo;
	}
	/**
	 * @return the grs_nombre
	 */
	public String getGrs_nombre() {
		return grs_nombre;
	}
	/**
	 * @param grs_nombre the grs_nombre to set
	 */
	public void setGrs_nombre(String grs_nombre) {
		this.grs_nombre = grs_nombre;
	}
	/**
	 * @return the sippa_grs_codigo
	 */
	public int getSippa_grs_codigo() {
		return sippa_grs_codigo;
	}
	/**
	 * @param sippa_grs_codigo the sippa_grs_codigo to set
	 */
	public void setSippa_grs_codigo(int sippa_grs_codigo) {
		this.sippa_grs_codigo = sippa_grs_codigo;
	}
	
	
	
}
