/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Tipo_notificacionOb implements Serializable {
	private int tin_codigo;//int] IDENTITY(1,1) NOT NULL,
	private String tin_nombre;//varchar](50) NULL,
	private int tin_estado;//int] NULL,
	
	public Tipo_notificacionOb(){
		
	}
	public Tipo_notificacionOb( String tin_nombre,int tin_estado){
		this.tin_nombre=tin_nombre;
		this.tin_estado=tin_estado;
	}
	public Tipo_notificacionOb( int tin_codigo,String tin_nombre,int tin_estado){
		this.tin_codigo=tin_codigo;
		this.tin_nombre=tin_nombre;
		this.tin_estado=tin_estado;
	}
	/**
	 * @return the tin_codigo
	 */
	public int getTin_codigo() {
		return tin_codigo;
	}
	/**
	 * @param tin_codigo the tin_codigo to set
	 */
	public void setTin_codigo(int tin_codigo) {
		this.tin_codigo = tin_codigo;
	}
	/**
	 * @return the tin_nombre
	 */
	public String getTin_nombre() {
		return tin_nombre;
	}
	/**
	 * @param tin_nombre the tin_nombre to set
	 */
	public void setTin_nombre(String tin_nombre) {
		this.tin_nombre = tin_nombre;
	}
	/**
	 * @return the tin_estado
	 */
	public int getTin_estado() {
		return tin_estado;
	}
	/**
	 * @param tin_estado the tin_estado to set
	 */
	public void setTin_estado(int tin_estado) {
		this.tin_estado = tin_estado;
	}
	
	
	
}
