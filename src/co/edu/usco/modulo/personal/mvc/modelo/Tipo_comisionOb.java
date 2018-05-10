/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Tipo_comisionOb implements Serializable {

	
	private int tic_codigo;//int] IDENTITY(1,1) NOT NULL,
	private String tic_nombre;//varchar](50) NULL,
	private int tic_estado;//int] NULL,
	
	public Tipo_comisionOb() {
		// TODO Auto-generated constructor stub
	}
	public Tipo_comisionOb(String tic_nombre,int tic_estado) {

		this.tic_nombre=tic_nombre;
		this.tic_estado=tic_estado;

	}
	public Tipo_comisionOb(int tic_codigo,String tic_nombre,int tic_estado) {
		this.tic_codigo=tic_codigo;
		this.tic_nombre=tic_nombre;
		this.tic_estado=tic_estado;

	}
	
	/**
	 * @return the tic_codigo
	 */
	public int getTic_codigo() {
		return tic_codigo;
	}
	/**
	 * @param tic_codigo the tic_codigo to set
	 */
	public void setTic_codigo(int tic_codigo) {
		this.tic_codigo = tic_codigo;
	}
	/**
	 * @return the tic_nombre
	 */
	public String getTic_nombre() {
		return tic_nombre;
	}
	/**
	 * @param tic_nombre the tic_nombre to set
	 */
	public void setTic_nombre(String tic_nombre) {
		this.tic_nombre = tic_nombre;
	}
	/**
	 * @return the tic_estado
	 */
	public int getTic_estado() {
		return tic_estado;
	}
	/**
	 * @param tic_estado the tic_estado to set
	 */
	public void setTic_estado(int tic_estado) {
		this.tic_estado = tic_estado;
	}
	
	
	
	
}
