/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class publicacion_tipoOb implements Serializable {

	private int put_codigo;//int] NOT NULL,
	private String put_nombre;//char](100) NOT NULL,
	private String sippa_tipcodigo;//char](2) NULL,
	
	/**
	 * 
	 */
	public publicacion_tipoOb() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the put_codigo
	 */
	public int getPut_codigo() {
		return put_codigo;
	}

	/**
	 * @param put_codigo the put_codigo to set
	 */
	public void setPut_codigo(int put_codigo) {
		this.put_codigo = put_codigo;
	}

	/**
	 * @return the put_nombre
	 */
	public String getPut_nombre() {
		return put_nombre;
	}

	/**
	 * @param put_nombre the put_nombre to set
	 */
	public void setPut_nombre(String put_nombre) {
		this.put_nombre = put_nombre;
	}

	/**
	 * @return the sippa_tipcodigo
	 */
	public String getSippa_tipcodigo() {
		return sippa_tipcodigo;
	}

	/**
	 * @param sippa_tipcodigo the sippa_tipcodigo to set
	 */
	public void setSippa_tipcodigo(String sippa_tipcodigo) {
		this.sippa_tipcodigo = sippa_tipcodigo;
	}
	
	

}
