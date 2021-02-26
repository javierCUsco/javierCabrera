/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author ING_JAVIER
 *
 */
@SuppressWarnings("serial")
public class Modalidad implements Serializable{

	private int codigo;//tinyint] IDENTITY(1,1) NOT NULL,
	private String nombre;//varchar](50) NULL,
	private String sippaModCodigo;//char](1) NULL,
	private int hecaaCodigo;
	
	/**
	 * 
	 */
	public Modalidad() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codigo
	 * @param nombre
	 * @param sippaModCodigo
	 * @param hecaaCodigo
	 */
	public Modalidad(int codigo, String nombre, String sippaModCodigo, int hecaaCodigo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.sippaModCodigo = sippaModCodigo;
		this.hecaaCodigo = hecaaCodigo;
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the sippaModCodigo
	 */
	public String getSippaModCodigo() {
		return sippaModCodigo;
	}

	/**
	 * @param sippaModCodigo the sippaModCodigo to set
	 */
	public void setSippaModCodigo(String sippaModCodigo) {
		this.sippaModCodigo = sippaModCodigo;
	}

	/**
	 * @return the hecaaCodigo
	 */
	public int getHecaaCodigo() {
		return hecaaCodigo;
	}

	/**
	 * @param hecaaCodigo the hecaaCodigo to set
	 */
	public void setHecaaCodigo(int hecaaCodigo) {
		this.hecaaCodigo = hecaaCodigo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Modalidad [codigo=" + codigo + ", nombre=" + nombre + ", sippaModCodigo=" + sippaModCodigo
				+ ", hecaaCodigo=" + hecaaCodigo + "]";
	}


}
