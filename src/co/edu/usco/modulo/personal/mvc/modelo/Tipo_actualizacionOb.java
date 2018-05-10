/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Tipo_actualizacionOb implements Serializable {
	private int tia_codigo;// int] IDENTITY(1,1) NOT NULL,
	private String tia_nombre;// varchar](50) NULL,
	private int tia_estado;// int] NULL,

	public Tipo_actualizacionOb() {

	}

	public Tipo_actualizacionOb(String tia_nombre, int tia_estado) {
		this.tia_nombre = tia_nombre;
		this.tia_estado = tia_estado;

	}

	public Tipo_actualizacionOb(int tia_codigo, String tia_nombre, int tia_estado) {
		this.tia_codigo = tia_codigo;
		this.tia_nombre = tia_nombre;
		this.tia_estado = tia_estado;

	}

	/**
	 * @return the tia_codigo
	 */
	public int getTia_codigo() {
		return tia_codigo;
	}

	/**
	 * @param tia_codigo
	 *            the tia_codigo to set
	 */
	public void setTia_codigo(int tia_codigo) {
		this.tia_codigo = tia_codigo;
	}

	/**
	 * @return the tia_nombre
	 */
	public String getTia_nombre() {
		return tia_nombre;
	}

	/**
	 * @param tia_nombre
	 *            the tia_nombre to set
	 */
	public void setTia_nombre(String tia_nombre) {
		this.tia_nombre = tia_nombre;
	}

	/**
	 * @return the tia_estado
	 */
	public int getTia_estado() {
		return tia_estado;
	}

	/**
	 * @param tia_estado
	 *            the tia_estado to set
	 */
	public void setTia_estado(int tia_estado) {
		this.tia_estado = tia_estado;
	}

}
