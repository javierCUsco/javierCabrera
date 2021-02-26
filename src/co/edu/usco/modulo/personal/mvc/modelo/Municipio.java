/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Municipio implements Serializable {
	private int  codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String id;//char](5) NULL,
	private String nombre;//varchar](100) NOT NULL,
	private Departamento departamento= new Departamento();//int] NOT NULL,
	private int sippaMunCodigo;//int] NULL,
	private String SNIESCodigo;//char](5) NULL,
	private String daneCodigo;//char](10) NULL,
	
	
	
	/**
	 * 
	 */
	public Municipio() {
	}
	
	
	
	/**
	 * @param codigo
	 * @param id
	 * @param nombre
	 * @param departamento
	 * @param sippaMunCodigo
	 * @param sNIESCodigo
	 * @param daneCodigo
	 */
	public Municipio(int codigo, String id, String nombre, Departamento departamento, int sippaMunCodigo,
			String sNIESCodigo, String daneCodigo) {
		this.codigo = codigo;
		this.id = id;
		this.nombre = nombre;
		this.departamento = departamento;
		this.sippaMunCodigo = sippaMunCodigo;
		SNIESCodigo = sNIESCodigo;
		this.daneCodigo = daneCodigo;
	}



	/**
	 * @param codigo
	 * @param nombre
	 */
	public Municipio(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
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
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the departamento
	 */
	public Departamento getDepartamento() {
		return departamento;
	}
	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	/**
	 * @return the sippaMunCodigo
	 */
	public int getSippaMunCodigo() {
		return sippaMunCodigo;
	}
	/**
	 * @param sippaMunCodigo the sippaMunCodigo to set
	 */
	public void setSippaMunCodigo(int sippaMunCodigo) {
		this.sippaMunCodigo = sippaMunCodigo;
	}
	/**
	 * @return the sNIESCodigo
	 */
	public String getSNIESCodigo() {
		return SNIESCodigo;
	}
	/**
	 * @param sNIESCodigo the sNIESCodigo to set
	 */
	public void setSNIESCodigo(String sNIESCodigo) {
		SNIESCodigo = sNIESCodigo;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Municipio [codigo=" + codigo + ", id=" + id + ", nombre=" + nombre + ", departamento=" + departamento
				+ ", sippaMunCodigo=" + sippaMunCodigo + ", SNIESCodigo=" + SNIESCodigo + ", daneCodigo=" + daneCodigo
				+ "]";
	}
	
	
	
	
}
