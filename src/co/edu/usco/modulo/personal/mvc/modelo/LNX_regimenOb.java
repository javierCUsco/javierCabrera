/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class LNX_regimenOb implements Serializable {
	private int reg_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String reg_nombre;//char](30) NULL,
	private String reg_acronimo;//char](1) NULL,
	/**
	 * @return the reg_codigo
	 */
	public int getReg_codigo() {
		return reg_codigo;
	}
	/**
	 * @param reg_codigo the reg_codigo to set
	 */
	public void setReg_codigo(int reg_codigo) {
		this.reg_codigo = reg_codigo;
	}
	/**
	 * @return the reg_nombre
	 */
	public String getReg_nombre() {
		return reg_nombre;
	}
	/**
	 * @param reg_nombre the reg_nombre to set
	 */
	public void setReg_nombre(String reg_nombre) {
		this.reg_nombre = reg_nombre;
	}
	/**
	 * @return the reg_acronimo
	 */
	public String getReg_acronimo() {
		return reg_acronimo;
	}
	/**
	 * @param reg_acronimo the reg_acronimo to set
	 */
	public void setReg_acronimo(String reg_acronimo) {
		this.reg_acronimo = reg_acronimo;
	}
	
	
}
