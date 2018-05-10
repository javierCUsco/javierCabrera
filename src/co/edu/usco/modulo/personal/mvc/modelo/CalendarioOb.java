/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;


/**
 * clase calendarioOb objeto de tipo calendatio
 * @author ING_JAVIER
 * @version 10/06/2014 1
 */
@SuppressWarnings("serial")
public class CalendarioOb implements Serializable{

	
	private int cal_codigo;// int;// IDENTITY(1,1) NOT NULL,
	//private int per_codigo;// int;// NOT NULL,
	private periodoOb periodo= new periodoOb();
	private String cal_nombre;// varchar;//(30) NULL,
	private String cal_fecha;// datetime;// NULL,
	private String cal_documento;// varchar;//(10) NULL,
	
	/**
	 * 
	 */
	public CalendarioOb() {
		// TODO Auto-generated constructor stub
	}

	
	public CalendarioOb(periodoOb periodo) {
		this.periodo= periodo;
	}

	
	/**
	 * @return the cal_codigo
	 */
	public int getCal_codigo() {
		return cal_codigo;
	}

	/**
	 * @param cal_codigo the cal_codigo to set
	 */
	public void setCal_codigo(int cal_codigo) {
		this.cal_codigo = cal_codigo;
	}

	
	
	

	/**
	 * @return the periodo
	 */
	public periodoOb getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(periodoOb periodo) {
		this.periodo = periodo;
	}

	/**
	 * @return the cal_nombre
	 */
	public String getCal_nombre() {
		return cal_nombre;
	}

	/**
	 * @param cal_nombre the cal_nombre to set
	 */
	public void setCal_nombre(String cal_nombre) {
		this.cal_nombre = cal_nombre;
	}

	/**
	 * @return the cal_fecha
	 */
	public String getCal_fecha() {
		return cal_fecha;
	}

	/**
	 * @param cal_fecha the cal_fecha to set
	 */
	public void setCal_fecha(String cal_fecha) {
		this.cal_fecha = cal_fecha;
	}

	/**
	 * @return the cal_documento
	 */
	public String getCal_documento() {
		return cal_documento;
	}

	/**
	 * @param cal_documento the cal_documento to set
	 */
	public void setCal_documento(String cal_documento) {
		this.cal_documento = cal_documento;
	}

	
	
}
