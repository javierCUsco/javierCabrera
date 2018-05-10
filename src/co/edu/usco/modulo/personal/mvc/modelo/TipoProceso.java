/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class TipoProceso implements Serializable {
	private int tip_codigo;//int] IDENTITY(1,1) NOT NULL,
	private String tip_nombre;//varchar](100) NULL,
	private int tip_estado;//int] NULL,
	
	
	
	public TipoProceso() {
	
	}
	public TipoProceso(String tip_nombre, int tip_estado) {

		this.tip_nombre = tip_nombre;
		this.tip_estado = tip_estado;
	}

	public TipoProceso(int tip_codigo, String tip_nombre, int tip_estado) {
	
		this.tip_codigo = tip_codigo;
		this.tip_nombre = tip_nombre;
		this.tip_estado = tip_estado;
	}
	
	

	/**
	 * @return the tip_codigo
	 */
	public int getTip_codigo() {
		return tip_codigo;
	}
	/**
	 * @param tip_codigo the tip_codigo to set
	 */
	public void setTip_codigo(int tip_codigo) {
		this.tip_codigo = tip_codigo;
	}
	/**
	 * @return the tip_nombre
	 */
	public String getTip_nombre() {
		return tip_nombre;
	}
	/**
	 * @param tip_nombre the tip_nombre to set
	 */
	public void setTip_nombre(String tip_nombre) {
		this.tip_nombre = tip_nombre;
	}
	/**
	 * @return the tip_estado
	 */
	public int getTip_estado() {
		return tip_estado;
	}
	/**
	 * @param tip_estado the tip_estado to set
	 */
	public void setTip_estado(int tip_estado) {
		this.tip_estado = tip_estado;
	}
	
	
	
	
}
