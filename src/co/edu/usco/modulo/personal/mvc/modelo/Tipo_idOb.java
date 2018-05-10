/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Tipo_idOb implements Serializable {
	private int tii_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String tii_nombre;//varchar](50) NULL,
	private String tii_nombre_corto;//varchar](4) NULL,
	private String snies_codigo;//varchar](3) NULL,
	private char spadies_codigo;//char](1) NULL,
	private String observatorio_laboral;//char](2) NULL,
	private char linix_codigo;//char](1) NULL,
	private int tii_estado;//int] NULL,
	private int tii_num_caracteres;//int] NULL,
	private String tii_codigo_hecaa;//char](2) NULL,
	/**
	 * @return the tii_codigo
	 */
	public int getTii_codigo() {
		return tii_codigo;
	}
	/**
	 * @param tii_codigo the tii_codigo to set
	 */
	public void setTii_codigo(int tii_codigo) {
		this.tii_codigo = tii_codigo;
	}
	/**
	 * @return the tii_nombre
	 */
	public String getTii_nombre() {
		return tii_nombre;
	}
	/**
	 * @param tii_nombre the tii_nombre to set
	 */
	public void setTii_nombre(String tii_nombre) {
		this.tii_nombre = tii_nombre;
	}
	/**
	 * @return the tii_nombre_corto
	 */
	public String getTii_nombre_corto() {
		return tii_nombre_corto;
	}
	/**
	 * @param tii_nombre_corto the tii_nombre_corto to set
	 */
	public void setTii_nombre_corto(String tii_nombre_corto) {
		this.tii_nombre_corto = tii_nombre_corto;
	}
	/**
	 * @return the snies_codigo
	 */
	public String getSnies_codigo() {
		return snies_codigo;
	}
	/**
	 * @param snies_codigo the snies_codigo to set
	 */
	public void setSnies_codigo(String snies_codigo) {
		this.snies_codigo = snies_codigo;
	}
	/**
	 * @return the spadies_codigo
	 */
	public char getSpadies_codigo() {
		return spadies_codigo;
	}
	/**
	 * @param spadies_codigo the spadies_codigo to set
	 */
	public void setSpadies_codigo(char spadies_codigo) {
		this.spadies_codigo = spadies_codigo;
	}
	/**
	 * @return the observatorio_laboral
	 */
	public String getObservatorio_laboral() {
		return observatorio_laboral;
	}
	/**
	 * @param observatorio_laboral the observatorio_laboral to set
	 */
	public void setObservatorio_laboral(String observatorio_laboral) {
		this.observatorio_laboral = observatorio_laboral;
	}
	/**
	 * @return the linix_codigo
	 */
	public char getLinix_codigo() {
		return linix_codigo;
	}
	/**
	 * @param linix_codigo the linix_codigo to set
	 */
	public void setLinix_codigo(char linix_codigo) {
		this.linix_codigo = linix_codigo;
	}
	/**
	 * @return the tii_estado
	 */
	public int getTii_estado() {
		return tii_estado;
	}
	/**
	 * @param tii_estado the tii_estado to set
	 */
	public void setTii_estado(int tii_estado) {
		this.tii_estado = tii_estado;
	}
	/**
	 * @return the tii_num_caracteres
	 */
	public int getTii_num_caracteres() {
		return tii_num_caracteres;
	}
	/**
	 * @param tii_num_caracteres the tii_num_caracteres to set
	 */
	public void setTii_num_caracteres(int tii_num_caracteres) {
		this.tii_num_caracteres = tii_num_caracteres;
	}
	/**
	 * @return the tii_codigo_hecaa
	 */
	public String getTii_codigo_hecaa() {
		return tii_codigo_hecaa;
	}
	/**
	 * @param tii_codigo_hecaa the tii_codigo_hecaa to set
	 */
	public void setTii_codigo_hecaa(String tii_codigo_hecaa) {
		this.tii_codigo_hecaa = tii_codigo_hecaa;
	}
	
	
}
