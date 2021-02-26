/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Pais implements Serializable {
	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String acronimo;//char](2) NOT NULL,
	private String nombre;//varchar](100) NOT NULL,
	private int sippaPaiCodigo;//int] NULL,
	private String daneCodigo;//char](10) NULL,
	private int codigoHecaa;//int] NULL,
	
	
	/**
	 * 
	 */
	public Pais() {
	}
	
	
	
	
	/**
	 * @param codigo
	 * @param acronimo
	 * @param nombre
	 * @param sippaPaiCodigo
	 * @param daneCodigo
	 * @param codigoHecaa
	 */
	public Pais(int codigo, String acronimo, String nombre, int sippaPaiCodigo, String daneCodigo, int codigoHecaa) {
		this.codigo = codigo;
		this.acronimo = acronimo;
		this.nombre = nombre;
		this.sippaPaiCodigo = sippaPaiCodigo;
		this.daneCodigo = daneCodigo;
		this.codigoHecaa = codigoHecaa;
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
	 * @return the acronimo
	 */
	public String getAcronimo() {
		return acronimo;
	}
	/**
	 * @param acronimo the acronimo to set
	 */
	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
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
	 * @return the sippaPaiCodigo
	 */
	public int getSippaPaiCodigo() {
		return sippaPaiCodigo;
	}
	/**
	 * @param sippaPaiCodigo the sippaPaiCodigo to set
	 */
	public void setSippaPaiCodigo(int sippaPaiCodigo) {
		this.sippaPaiCodigo = sippaPaiCodigo;
	}
	/**
	 * @return the daneCodigo
	 */
	public String getDaneCodigo() {
		return daneCodigo;
	}
	/**
	 * @param daneCodigo the daneCodigo to set
	 */
	public void setDaneCodigo(String daneCodigo) {
		this.daneCodigo = daneCodigo;
	}
	/**
	 * @return the codigoHecaa
	 */
	public int getCodigoHecaa() {
		return codigoHecaa;
	}
	/**
	 * @param codigoHecaa the codigoHecaa to set
	 */
	public void setCodigoHecaa(int codigoHecaa) {
		this.codigoHecaa = codigoHecaa;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pais [codigo=" + codigo + ", acronimo=" + acronimo + ", nombre=" + nombre + ", sippaPaiCodigo="
				+ sippaPaiCodigo + ", daneCodigo=" + daneCodigo + ", codigoHecaa=" + codigoHecaa + "]";
	}
	
	
	
}
