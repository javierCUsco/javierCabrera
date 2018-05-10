/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Historia_laboral_tipoOb implements Serializable {
	private int hlt_codigo=0;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String hlt_nombre="";//varchar](50) NOT NULL,
	
	public Historia_laboral_tipoOb(int hlt_codigo,String hlt_nombre){
		this.hlt_codigo=hlt_codigo;
		this.hlt_nombre=hlt_nombre;
	}
	
	public Historia_laboral_tipoOb() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the hlt_codigo
	 */
	public int getHlt_codigo() {
		return hlt_codigo;
	}
	/**
	 * @param hlt_codigo the hlt_codigo to set
	 */
	public void setHlt_codigo(int hlt_codigo) {
		this.hlt_codigo = hlt_codigo;
	}
	/**
	 * @return the hlt_nombre
	 */
	public String getHlt_nombre() {
		return hlt_nombre;
	}
	/**
	 * @param hlt_nombre the hlt_nombre to set
	 */
	public void setHlt_nombre(String hlt_nombre) {
		this.hlt_nombre = hlt_nombre;
	}
	
	
}
