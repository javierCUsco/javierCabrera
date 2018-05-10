/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class LNX_naturalezaOb implements Serializable {
	private int nat_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String nat_nombre;//char](20) NULL,
	private String nat_acronimo;//char](1) NULL,
	/**
	 * @return the nat_codigo
	 */
	public int getNat_codigo() {
		return nat_codigo;
	}
	/**
	 * @param nat_codigo the nat_codigo to set
	 */
	public void setNat_codigo(int nat_codigo) {
		this.nat_codigo = nat_codigo;
	}
	/**
	 * @return the nat_nombre
	 */
	public String getNat_nombre() {
		return nat_nombre;
	}
	/**
	 * @param nat_nombre the nat_nombre to set
	 */
	public void setNat_nombre(String nat_nombre) {
		this.nat_nombre = nat_nombre;
	}
	/**
	 * @return the nat_acronimo
	 */
	public String getNat_acronimo() {
		return nat_acronimo;
	}
	/**
	 * @param nat_acronimo the nat_acronimo to set
	 */
	public void setNat_acronimo(String nat_acronimo) {
		this.nat_acronimo = nat_acronimo;
	}
	
	
}
