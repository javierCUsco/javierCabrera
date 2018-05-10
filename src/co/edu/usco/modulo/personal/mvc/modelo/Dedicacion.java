/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author ING. JAVIER CABRERA LASSO
 *
 */
public class Dedicacion implements Serializable {
	private int ded_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String ded_nombre;//varchar](50) NOT NULL,
	private int ded_orden_snies;//smallint] NULL,
	private String sippa_dedcodigo;//char](1) NULL,
	private String ded_codigo_hecaa;//smallint] NULL,
	
	
	
	
	
	public Dedicacion(int ded_codigo, String ded_nombre, int ded_orden_snies, String sippa_dedcodigo,
			String ded_codigo_hecaa) {
		super();
		this.ded_codigo = ded_codigo;
		this.ded_nombre = ded_nombre;
		this.ded_orden_snies = ded_orden_snies;
		this.sippa_dedcodigo = sippa_dedcodigo;
		this.ded_codigo_hecaa = ded_codigo_hecaa;
	}



	public Dedicacion(int ded_codigo,String ded_nombre){
		this.ded_codigo=ded_codigo;
		this.ded_nombre=ded_nombre;
		
	}
	
	
	
	public Dedicacion(){
		
	}
	/**
	 * @return the ded_codigo
	 */
	public int getDed_codigo() {
		return ded_codigo;
	}
	/**
	 * @param ded_codigo the ded_codigo to set
	 */
	public void setDed_codigo(int ded_codigo) {
		this.ded_codigo = ded_codigo;
	}
	/**
	 * @return the ded_nombre
	 */
	public String getDed_nombre() {
		return ded_nombre;
	}
	/**
	 * @param ded_nombre the ded_nombre to set
	 */
	public void setDed_nombre(String ded_nombre) {
		this.ded_nombre = ded_nombre;
	}
	/**
	 * @return the ded_orden_snies
	 */
	public int getDed_orden_snies() {
		return ded_orden_snies;
	}
	/**
	 * @param ded_orden_snies the ded_orden_snies to set
	 */
	public void setDed_orden_snies(int ded_orden_snies) {
		this.ded_orden_snies = ded_orden_snies;
	}
	/**
	 * @return the sippa_dedcodigo
	 */
	public String getSippa_dedcodigo() {
		return sippa_dedcodigo;
	}
	/**
	 * @param sippa_dedcodigo the sippa_dedcodigo to set
	 */
	public void setSippa_dedcodigo(String sippa_dedcodigo) {
		this.sippa_dedcodigo = sippa_dedcodigo;
	}
	/**
	 * @return the ded_codigo_hecaa
	 */
	public String getDed_codigo_hecaa() {
		return ded_codigo_hecaa;
	}
	/**
	 * @param ded_codigo_hecaa the ded_codigo_hecaa to set
	 */
	public void setDed_codigo_hecaa(String ded_codigo_hecaa) {
		this.ded_codigo_hecaa = ded_codigo_hecaa;
	}
	
	
}
