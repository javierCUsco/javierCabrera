/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PaisOb implements Serializable {
	private int pai_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String pai_acronimo;//char](2) NOT NULL,
	private String pai_nombre;//varchar](100) NOT NULL,
	private int sippa_pai_codigo;//int] NULL,
	private String dane_codigo;//char](10) NULL,
	private int pai_codigo_hecaa;//int] NULL,
	/**
	 * @return the pai_codigo
	 */
	public int getPai_codigo() {
		return pai_codigo;
	}
	/**
	 * @param pai_codigo the pai_codigo to set
	 */
	public void setPai_codigo(int pai_codigo) {
		this.pai_codigo = pai_codigo;
	}
	/**
	 * @return the pai_acronimo
	 */
	public String getPai_acronimo() {
		return pai_acronimo;
	}
	/**
	 * @param pai_acronimo the pai_acronimo to set
	 */
	public void setPai_acronimo(String pai_acronimo) {
		this.pai_acronimo = pai_acronimo;
	}
	/**
	 * @return the pai_nombre
	 */
	public String getPai_nombre() {
		return pai_nombre;
	}
	/**
	 * @param pai_nombre the pai_nombre to set
	 */
	public void setPai_nombre(String pai_nombre) {
		this.pai_nombre = pai_nombre;
	}
	/**
	 * @return the sippa_pai_codigo
	 */
	public int getSippa_pai_codigo() {
		return sippa_pai_codigo;
	}
	/**
	 * @param sippa_pai_codigo the sippa_pai_codigo to set
	 */
	public void setSippa_pai_codigo(int sippa_pai_codigo) {
		this.sippa_pai_codigo = sippa_pai_codigo;
	}
	/**
	 * @return the dane_codigo
	 */
	public String getDane_codigo() {
		return dane_codigo;
	}
	/**
	 * @param dane_codigo the dane_codigo to set
	 */
	public void setDane_codigo(String dane_codigo) {
		this.dane_codigo = dane_codigo;
	}
	/**
	 * @return the pai_codigo_hecaa
	 */
	public int getPai_codigo_hecaa() {
		return pai_codigo_hecaa;
	}
	/**
	 * @param pai_codigo_hecaa the pai_codigo_hecaa to set
	 */
	public void setPai_codigo_hecaa(int pai_codigo_hecaa) {
		this.pai_codigo_hecaa = pai_codigo_hecaa;
	}
	
	
}
