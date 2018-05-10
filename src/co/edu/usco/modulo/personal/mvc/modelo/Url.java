/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

import co.edu.usco.modulo.personal.mvc.control.herramientas.Transformacion;


/**
 * @author ING_JAVIER
 *
 */
@SuppressWarnings("serial")
public class Url implements Serializable{
	private String url ;
	private String basedato;
	/**
	 * 
	 */
	public Url() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		Transformacion hex = new Transformacion();
		return hex.transHexa(this.url, 2);
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		Transformacion hex = new Transformacion();
		this.url = hex.transHexa(url, 1);
	}
	/**
	 * @return the basedato
	 */
	public String getBasedato() {
		Transformacion hex = new Transformacion();
		return hex.transHexa(this.basedato, 2);
	}
	/**
	 * @param basedato the basedato to set
	 */
	public void setBasedato(String basedato) {
		Transformacion hex = new Transformacion();
		this.basedato = hex.transHexa(basedato,1);
	}

}
