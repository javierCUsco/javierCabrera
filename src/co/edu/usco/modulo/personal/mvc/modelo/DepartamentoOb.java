/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class DepartamentoOb implements Serializable {
	private int dep_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String dep_id;//char](2) NULL,
	private String dep_nombre;//varchar](100) NOT NULL,
	private PaisOb pais= new PaisOb();//int] NOT NULL,
	private int sippa_dep_codigo;//int] NULL,
	private String dane_codigo;//char](10) NULL,
	/**
	 * @return the dep_codigo
	 */
	public int getDep_codigo() {
		return dep_codigo;
	}
	/**
	 * @param dep_codigo the dep_codigo to set
	 */
	public void setDep_codigo(int dep_codigo) {
		this.dep_codigo = dep_codigo;
	}
	/**
	 * @return the dep_id
	 */
	public String getDep_id() {
		return dep_id;
	}
	/**
	 * @param dep_id the dep_id to set
	 */
	public void setDep_id(String dep_id) {
		this.dep_id = dep_id;
	}
	/**
	 * @return the dep_nombre
	 */
	public String getDep_nombre() {
		return dep_nombre;
	}
	/**
	 * @param dep_nombre the dep_nombre to set
	 */
	public void setDep_nombre(String dep_nombre) {
		this.dep_nombre = dep_nombre;
	}
	/**
	 * @return the pais
	 */
	public PaisOb getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(PaisOb pais) {
		this.pais = pais;
	}
	/**
	 * @return the sippa_dep_codigo
	 */
	public int getSippa_dep_codigo() {
		return sippa_dep_codigo;
	}
	/**
	 * @param sippa_dep_codigo the sippa_dep_codigo to set
	 */
	public void setSippa_dep_codigo(int sippa_dep_codigo) {
		this.sippa_dep_codigo = sippa_dep_codigo;
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
	
	
}
