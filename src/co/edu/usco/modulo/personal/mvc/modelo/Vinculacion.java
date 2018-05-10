/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author ING. JAVIER CABRERA LASSO
 *
 */
public class Vinculacion implements Serializable {
	private int vin_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String vin_nombre;//varchar](50) NOT NULL,
	private int vin_horas_year;//int] NULL,
	private int vin_clase;//int] NULL,
	private int sippa_vincodigo;//char](3) NULL,
	private String vin_contratacion;//varchar](1) NULL,
	
	
	
	
	public Vinculacion() {
		
	}
	
	
	public Vinculacion(int vin_codigo, String vin_nombre, int vin_horas_year, int vin_clase, int sippa_vincodigo,
			String vin_contratacion) {
		this.vin_codigo = vin_codigo;
		this.vin_nombre = vin_nombre;
		this.vin_horas_year = vin_horas_year;
		this.vin_clase = vin_clase;
		this.sippa_vincodigo = sippa_vincodigo;
		this.vin_contratacion = vin_contratacion;
	}


	/**
	 * @return the vin_codigo
	 */
	public int getVin_codigo() {
		return vin_codigo;
	}
	/**
	 * @param vin_codigo the vin_codigo to set
	 */
	public void setVin_codigo(int vin_codigo) {
		this.vin_codigo = vin_codigo;
	}
	/**
	 * @return the vin_nombre
	 */
	public String getVin_nombre() {
		return vin_nombre;
	}
	/**
	 * @param vin_nombre the vin_nombre to set
	 */
	public void setVin_nombre(String vin_nombre) {
		this.vin_nombre = vin_nombre;
	}
	/**
	 * @return the vin_horas_year
	 */
	public int getVin_horas_year() {
		return vin_horas_year;
	}
	/**
	 * @param vin_horas_year the vin_horas_year to set
	 */
	public void setVin_horas_year(int vin_horas_year) {
		this.vin_horas_year = vin_horas_year;
	}
	/**
	 * @return the vin_clase
	 */
	public int getVin_clase() {
		return vin_clase;
	}
	/**
	 * @param vin_clase the vin_clase to set
	 */
	public void setVin_clase(int vin_clase) {
		this.vin_clase = vin_clase;
	}
	/**
	 * @return the sippa_vincodigo
	 */
	public int getSippa_vincodigo() {
		return sippa_vincodigo;
	}
	/**
	 * @param sippa_vincodigo the sippa_vincodigo to set
	 */
	public void setSippa_vincodigo(int sippa_vincodigo) {
		this.sippa_vincodigo = sippa_vincodigo;
	}
	/**
	 * @return the vin_contratacion
	 */
	public String getVin_contratacion() {
		return vin_contratacion;
	}
	/**
	 * @param vin_contratacion the vin_contratacion to set
	 */
	public void setVin_contratacion(String vin_contratacion) {
		this.vin_contratacion = vin_contratacion;
	}
	
	
}
