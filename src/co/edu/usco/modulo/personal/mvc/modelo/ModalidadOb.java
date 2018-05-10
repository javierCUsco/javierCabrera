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
public class ModalidadOb implements Serializable{

	private int mod_codigo;//tinyint] IDENTITY(1,1) NOT NULL,
	private String mod_nombre;//varchar](50) NULL,
	private String sippa_mod_codigo;//char](1) NULL,
	private int hecaa_codigo;
	
	/**
	 * 
	 */
	public ModalidadOb() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the mod_codigo
	 */
	public int getMod_codigo() {
		return mod_codigo;
	}


	/**
	 * @param mod_codigo the mod_codigo to set
	 */
	public void setMod_codigo(int mod_codigo) {
		this.mod_codigo = mod_codigo;
	}


	/**
	 * @return the mod_nombre
	 */
	public String getMod_nombre() {
		return mod_nombre;
	}


	/**
	 * @param mod_nombre the mod_nombre to set
	 */
	public void setMod_nombre(String mod_nombre) {
		this.mod_nombre = mod_nombre;
	}


	/**
	 * @return the sippa_mod_codigo
	 */
	public String getSippa_mod_codigo() {
		return sippa_mod_codigo;
	}


	/**
	 * @param sippa_mod_codigo the sippa_mod_codigo to set
	 */
	public void setSippa_mod_codigo(String sippa_mod_codigo) {
		this.sippa_mod_codigo = sippa_mod_codigo;
	}


	/**
	 * @return the hecaa_codigo
	 */
	public int getHecaa_codigo() {
		return hecaa_codigo;
	}


	/**
	 * @param hecaa_codigo the hecaa_codigo to set
	 */
	public void setHecaa_codigo(int hecaa_codigo) {
		this.hecaa_codigo = hecaa_codigo;
	}
	
	

}
