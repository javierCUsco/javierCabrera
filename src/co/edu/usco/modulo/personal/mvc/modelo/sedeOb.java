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
public class sedeOb implements Serializable{

	private int sed_codigo;//int] IDENTITY(1,1) NOT NULL,
	private String sed_nombre;//varchar](50) NOT NULL,
	private int mun_codigo;//int] NOT NULL,
	private int sippa_sed_codigo;//int] NULL,
	private int sed_estado;//varchar](1) NULL,
	
	
	
	
	public sedeOb(int sed_codigo, String sed_nombre, int mun_codigo, int sippa_sed_codigo, int sed_estado) {
		this.sed_codigo = sed_codigo;
		this.sed_nombre = sed_nombre;
		this.mun_codigo = mun_codigo;
		this.sippa_sed_codigo = sippa_sed_codigo;
		this.sed_estado = sed_estado;
	}

	/**
	 * 
	 */
	public sedeOb() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the sed_codigo
	 */
	public int getSed_codigo() {
		return sed_codigo;
	}

	/**
	 * @param sed_codigo the sed_codigo to set
	 */
	public void setSed_codigo(int sed_codigo) {
		this.sed_codigo = sed_codigo;
	}

	/**
	 * @return the sed_nombre
	 */
	public String getSed_nombre() {
		return sed_nombre;
	}

	/**
	 * @param sed_nombre the sed_nombre to set
	 */
	public void setSed_nombre(String sed_nombre) {
		this.sed_nombre = sed_nombre;
	}

	/**
	 * @return the mun_codigo
	 */
	public int getMun_codigo() {
		return mun_codigo;
	}

	/**
	 * @param mun_codigo the mun_codigo to set
	 */
	public void setMun_codigo(int mun_codigo) {
		this.mun_codigo = mun_codigo;
	}

	/**
	 * @return the sippa_sed_codigo
	 */
	public int getSippa_sed_codigo() {
		return sippa_sed_codigo;
	}

	/**
	 * @param sippa_sed_codigo the sippa_sed_codigo to set
	 */
	public void setSippa_sed_codigo(int sippa_sed_codigo) {
		this.sippa_sed_codigo = sippa_sed_codigo;
	}

	/**
	 * @return the sed_estado
	 */
	public int getSed_estado() {
		return sed_estado;
	}

	/**
	 * @param sed_estado the sed_estado to set
	 */
	public void setSed_estado(int sed_estado) {
		this.sed_estado = sed_estado;
	}

	
	
}
