/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class TipoTerminacion implements Serializable {
	
	private int tit_codigo;//int] IDENTITY(1,1) NOT NULL,
	private String tit_nombre;//varchar](150) NULL,
	private int tit_estado;//int] NULL,
	
	
	
	public TipoTerminacion() {
		
	}
	
	public TipoTerminacion(String tit_nombre, int tit_estado) {
	
		this.tit_codigo = tit_codigo;
		this.tit_nombre = tit_nombre;
		this.tit_estado = tit_estado;
	}

	public TipoTerminacion(int tit_codigo, String tit_nombre, int tit_estado) {
		
		this.tit_codigo = tit_codigo;
		this.tit_nombre = tit_nombre;
		this.tit_estado = tit_estado;
	}


	/**
	 * @return the tit_codigo
	 */
	public int getTit_codigo() {
		return tit_codigo;
	}
	/**
	 * @param tit_codigo the tit_codigo to set
	 */
	public void setTit_codigo(int tit_codigo) {
		this.tit_codigo = tit_codigo;
	}
	/**
	 * @return the tit_nombre
	 */
	public String getTit_nombre() {
		return tit_nombre;
	}
	/**
	 * @param tit_nombre the tit_nombre to set
	 */
	public void setTit_nombre(String tit_nombre) {
		this.tit_nombre = tit_nombre;
	}
	/**
	 * @return the tit_estado
	 */
	public int getTit_estado() {
		return tit_estado;
	}
	/**
	 * @param tit_estado the tit_estado to set
	 */
	public void setTit_estado(int tit_estado) {
		this.tit_estado = tit_estado;
	}
	
	
	
}
