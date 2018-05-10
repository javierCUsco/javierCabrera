/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author ING_JAVIER
 *
 */
@SuppressWarnings("serial")
public class Grupo implements Serializable{

	private int gru_codigo;//] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String gru_nombre;//] [varchar](100) NOT NULL,
	private String gru_id;// [varchar;//](100) NULL,
	/**
	 * 
	 */
	public Grupo() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the gru_codigo
	 */
	public int getGru_codigo() {
		return gru_codigo;
	}
	/**
	 * @param gru_codigo the gru_codigo to set
	 */
	public void setGru_codigo(int gru_codigo) {
		this.gru_codigo = gru_codigo;
	}
	/**
	 * @return the gru_nombre
	 */
	public String getGru_nombre() {
		return gru_nombre;
	}
	/**
	 * @param gru_nombre the gru_nombre to set
	 */
	public void setGru_nombre(String gru_nombre) {
		this.gru_nombre = gru_nombre;
	}
	/**
	 * @return the gru_id
	 */
	public String getGru_id() {
		return gru_id;
	}
	/**
	 * @param gru_id the gru_id to set
	 */
	public void setGru_id(String gru_id) {
		this.gru_id = gru_id;
	}
	

}
