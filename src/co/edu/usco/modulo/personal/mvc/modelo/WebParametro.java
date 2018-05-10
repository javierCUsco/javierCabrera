/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class WebParametro implements Serializable {
	private int wep_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String wep_nombre;//varchar](100) NOT NULL,
	private String wep_valor;//varchar](500) NOT NULL,
	private String wep_descripcion;//varchar](500) NULL,
	
	
	/**
	 * 
	 */
	public WebParametro() {
	}

	/**
	 * 
	 */
	public WebParametro(String wep_nombre) {
		this.wep_nombre=wep_nombre;
	}

	public WebParametro(int wep_codigo,String wep_nombre,String wep_valor,String wep_descripcion) {
		this.wep_codigo=wep_codigo;
		this.wep_nombre=wep_nombre;
		this.wep_valor=wep_valor;
		this.wep_descripcion=wep_descripcion;
	}
	
	/**
	 * @return the wep_codigo
	 */
	public int getWep_codigo() {
		return wep_codigo;
	}
	
	/**
	 * @param wep_codigo the wep_codigo to set
	 */
	public void setWep_codigo(int wep_codigo) {
		this.wep_codigo = wep_codigo;
	}
	/**
	 * @return the wep_nombre
	 */
	public String getWep_nombre() {
		return wep_nombre;
	}
	/**
	 * @param wep_nombre the wep_nombre to set
	 */
	public void setWep_nombre(String wep_nombre) {
		this.wep_nombre = wep_nombre;
	}
	/**
	 * @return the wep_valor
	 */
	public String getWep_valor() {
		return wep_valor;
	}
	/**
	 * @param wep_valor the wep_valor to set
	 */
	public void setWep_valor(String wep_valor) {
		this.wep_valor = wep_valor;
	}
	/**
	 * @return the wep_descripcion
	 */
	public String getWep_descripcion() {
		return wep_descripcion;
	}
	/**
	 * @param wep_descripcion the wep_descripcion to set
	 */
	public void setWep_descripcion(String wep_descripcion) {
		this.wep_descripcion = wep_descripcion;
	}
	
	
}
