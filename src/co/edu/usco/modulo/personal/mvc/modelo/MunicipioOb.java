/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class MunicipioOb implements Serializable {
	private int  mun_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String mun_id;//char](5) NULL,
	private String mun_nombre;//varchar](100) NOT NULL,
	private DepartamentoOb departamento= new DepartamentoOb();//int] NOT NULL,
	private int sippa_mun_codigo;//int] NULL,
	private String SNIES_codigo;//char](5) NULL,
	private String dane_codigo;//char](10) NULL,
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
	 * @return the mun_id
	 */
	public String getMun_id() {
		return mun_id;
	}
	/**
	 * @param mun_id the mun_id to set
	 */
	public void setMun_id(String mun_id) {
		this.mun_id = mun_id;
	}
	/**
	 * @return the mun_nombre
	 */
	public String getMun_nombre() {
		return mun_nombre;
	}
	/**
	 * @param mun_nombre the mun_nombre to set
	 */
	public void setMun_nombre(String mun_nombre) {
		this.mun_nombre = mun_nombre;
	}
	/**
	 * @return the departamento
	 */
	public DepartamentoOb getDepartamento() {
		return departamento;
	}
	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(DepartamentoOb departamento) {
		this.departamento = departamento;
	}
	/**
	 * @return the sippa_mun_codigo
	 */
	public int getSippa_mun_codigo() {
		return sippa_mun_codigo;
	}
	/**
	 * @param sippa_mun_codigo the sippa_mun_codigo to set
	 */
	public void setSippa_mun_codigo(int sippa_mun_codigo) {
		this.sippa_mun_codigo = sippa_mun_codigo;
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
