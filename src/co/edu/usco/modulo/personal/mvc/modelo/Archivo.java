/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author Maritza
 *
 */
public class Archivo implements Serializable {

	/**
	 * @return the cambio
	 */
	public boolean isCambio() {
		return cambio;
	}
	/**
	 * @param cambio the cambio to set
	 */
	public void setCambio(boolean cambio) {
		this.cambio = cambio;
	}
	private String url_repositorio="";
	private String ph_archivo="";//varchar](255) NULL,
	private String ph_archivo_md5="";//varchar](255) NULL,
	private String ph_content_type="";//varchar](255) NULL,
	private boolean cambio=false;
	/**
	 * @return the url_repositorio
	 */
	public String getUrl_repositorio() {
		return url_repositorio;
	}
	/**
	 * @param url_repositorio the url_repositorio to set
	 */
	public void setUrl_repositorio(String url_repositorio) {
		this.url_repositorio = url_repositorio;
	}
	/**
	 * @return the pha_archivo
	 */
	public String getPh_archivo() {
		return ph_archivo;
	}
	/**
	 * @param pha_archivo the pha_archivo to set
	 */
	public void setPh_archivo(String pha_archivo) {
		this.ph_archivo = pha_archivo;
	}
	/**
	 * @return the pha_archivo_md5
	 */
	public String getPh_archivo_md5() {
		return ph_archivo_md5;
	}
	/**
	 * @param pha_archivo_md5 the pha_archivo_md5 to set
	 */
	public void setPh_archivo_md5(String pha_archivo_md5) {
		this.ph_archivo_md5 = pha_archivo_md5;
	}
	/**
	 * @return the pha_content_type
	 */
	public String getPh_content_type() {
		return ph_content_type;
	}
	/**
	 * @param pha_content_type the pha_content_type to set
	 */
	public void setPh_content_type(String pha_content_type) {
		this.ph_content_type = pha_content_type;
	}
	
	
	
}
