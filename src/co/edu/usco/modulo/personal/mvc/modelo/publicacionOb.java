/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class publicacionOb implements Serializable {

	private int pub_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String pub_fecha;//datetime] NULL,
	private publicacion_tipoOb publicacion_tipo= new publicacion_tipoOb();//int] NULL,
	private String pub_nombre;//char](150) NULL,
	private String pub_descripcion;//varchar](300) NULL,
	private String sippa_pubcodigo;//char](5) NULL,
	
	/**
	 * 
	 */
	public publicacionOb() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the pub_codigo
	 */
	public int getPub_codigo() {
		return pub_codigo;
	}

	/**
	 * @param pub_codigo the pub_codigo to set
	 */
	public void setPub_codigo(int pub_codigo) {
		this.pub_codigo = pub_codigo;
	}

	/**
	 * @return the pub_fecha
	 */
	public String getPub_fecha() {
		return pub_fecha;
	}

	/**
	 * @param pub_fecha the pub_fecha to set
	 */
	public void setPub_fecha(String pub_fecha) {
		this.pub_fecha = pub_fecha;
	}

	/**
	 * @return the publicacion_tipo
	 */
	public publicacion_tipoOb getPublicacion_tipo() {
		return publicacion_tipo;
	}

	/**
	 * @param publicacion_tipo the publicacion_tipo to set
	 */
	public void setPublicacion_tipo(publicacion_tipoOb publicacion_tipo) {
		this.publicacion_tipo = publicacion_tipo;
	}

	/**
	 * @return the pub_nombre
	 */
	public String getPub_nombre() {
		return pub_nombre;
	}

	/**
	 * @param pub_nombre the pub_nombre to set
	 */
	public void setPub_nombre(String pub_nombre) {
		this.pub_nombre = pub_nombre;
	}

	/**
	 * @return the pub_descripcion
	 */
	public String getPub_descripcion() {
		return pub_descripcion;
	}

	/**
	 * @param pub_descripcion the pub_descripcion to set
	 */
	public void setPub_descripcion(String pub_descripcion) {
		this.pub_descripcion = pub_descripcion;
	}

	/**
	 * @return the sippa_pubcodigo
	 */
	public String getSippa_pubcodigo() {
		return sippa_pubcodigo;
	}

	/**
	 * @param sippa_pubcodigo the sippa_pubcodigo to set
	 */
	public void setSippa_pubcodigo(String sippa_pubcodigo) {
		this.sippa_pubcodigo = sippa_pubcodigo;
	}
	
	

}
