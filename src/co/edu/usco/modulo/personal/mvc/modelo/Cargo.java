/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author ING. JAVIER CABRERA LASSO
 *
 */
public class Cargo implements Serializable {
	private int car_codigo;//int] IDENTITY(0,1) NOT FOR REPLICATION NOT NULL,
	private String car_nombre;//varchar](50) NOT NULL,
	private String car_id;//varchar](4) NULL,
	private int  car_tmp;//int] NULL,
	
	
	
	
	public Cargo() {
		
	}
	
	
	public Cargo(int car_codigo, String car_nombre, String car_id, int car_tmp) {
		this.car_codigo = car_codigo;
		this.car_nombre = car_nombre;
		this.car_id = car_id;
		this.car_tmp = car_tmp;
	}


	/**
	 * @return the car_codigo
	 */
	public int getCar_codigo() {
		return car_codigo;
	}
	/**
	 * @param car_codigo the car_codigo to set
	 */
	public void setCar_codigo(int car_codigo) {
		this.car_codigo = car_codigo;
	}
	/**
	 * @return the car_nombre
	 */
	public String getCar_nombre() {
		return car_nombre;
	}
	/**
	 * @param car_nombre the car_nombre to set
	 */
	public void setCar_nombre(String car_nombre) {
		this.car_nombre = car_nombre;
	}
	/**
	 * @return the car_id
	 */
	public String getCar_id() {
		return car_id;
	}
	/**
	 * @param car_id the car_id to set
	 */
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	/**
	 * @return the car_tmp
	 */
	public int getCar_tmp() {
		return car_tmp;
	}
	/**
	 * @param car_tmp the car_tmp to set
	 */
	public void setCar_tmp(int car_tmp) {
		this.car_tmp = car_tmp;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cargo [car_codigo=" + car_codigo + ", car_nombre=" + car_nombre + ", car_id=" + car_id + ", car_tmp="
				+ car_tmp + "]";
	}
	
}
