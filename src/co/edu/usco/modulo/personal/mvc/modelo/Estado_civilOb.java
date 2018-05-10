/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Estado_civilOb implements Serializable {
	private int esc_codigo;//char](1) NOT NULL,
	private String esc_nombre;//char](50) NULL,
	private int sippa_esc_codigo;//int] NULL,
	private String SNIES_codigo;//varchar](2) NULL,
	private int esc_codigo_hecaa;//int] NULL,
	/**
	 * @return the esc_codigo
	 */
	public int getEsc_codigo() {
		return esc_codigo;
	}
	/**
	 * @param esc_codigo the esc_codigo to set
	 */
	public void setEsc_codigo(int esc_codigo) {
		this.esc_codigo = esc_codigo;
	}
	/**
	 * @return the esc_nombre
	 */
	public String getEsc_nombre() {
		return esc_nombre;
	}
	/**
	 * @param esc_nombre the esc_nombre to set
	 */
	public void setEsc_nombre(String esc_nombre) {
		this.esc_nombre = esc_nombre;
	}
	/**
	 * @return the sippa_esc_codigo
	 */
	public int getSippa_esc_codigo() {
		return sippa_esc_codigo;
	}
	/**
	 * @param sippa_esc_codigo the sippa_esc_codigo to set
	 */
	public void setSippa_esc_codigo(int sippa_esc_codigo) {
		this.sippa_esc_codigo = sippa_esc_codigo;
	}
	/**
	 * @return the sNIES_codigo
	 */
	public String getSNIES_codigo() {
		return SNIES_codigo;
	}
	/**
	 * @param sNIES_codigo the sNIES_codigo to set
	 */
	public void setSNIES_codigo(String sNIES_codigo) {
		SNIES_codigo = sNIES_codigo;
	}
	/**
	 * @return the esc_codigo_hecaa
	 */
	public int getEsc_codigo_hecaa() {
		return esc_codigo_hecaa;
	}
	/**
	 * @param esc_codigo_hecaa the esc_codigo_hecaa to set
	 */
	public void setEsc_codigo_hecaa(int esc_codigo_hecaa) {
		this.esc_codigo_hecaa = esc_codigo_hecaa;
	}
	
	
	
}
