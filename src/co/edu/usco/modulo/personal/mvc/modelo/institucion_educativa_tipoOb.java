/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class institucion_educativa_tipoOb implements Serializable {
	private int iet_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String iet_nombre;//varchar](50) NOT NULL,
	/**
	 * @return the iet_codigo
	 */
	public int getIet_codigo() {
		return iet_codigo;
	}
	/**
	 * @param iet_codigo the iet_codigo to set
	 */
	public void setIet_codigo(int iet_codigo) {
		this.iet_codigo = iet_codigo;
	}
	/**
	 * @return the iet_nombre
	 */
	public String getIet_nombre() {
		return iet_nombre;
	}
	/**
	 * @param iet_nombre the iet_nombre to set
	 */
	public void setIet_nombre(String iet_nombre) {
		this.iet_nombre = iet_nombre;
	}
	
}
