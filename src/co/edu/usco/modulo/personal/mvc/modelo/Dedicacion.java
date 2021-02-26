/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author ING. JAVIER CABRERA LASSO
 *
 */
public class Dedicacion {
	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String nombre;//varchar](50) NOT NULL,
	private int ordenSnies;//smallint] NULL,
	private String sippaDedCodigo;//char](1) NULL,
	private String codigoHecaa;//smallint] NULL,
	
	
	
	/**
	 * 
	 */
	public Dedicacion() {
	}
	/**
	 * @param codigo
	 * @param nombre
	 * @param ordenSnies
	 * @param sippaDedCodigo
	 * @param codigoHecaa
	 */
	public Dedicacion(int codigo, String nombre, int ordenSnies, String sippaDedCodigo, String codigoHecaa) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ordenSnies = ordenSnies;
		this.sippaDedCodigo = sippaDedCodigo;
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
	 * @return the ordenSnies
	 */
	public int getOrdenSnies() {
		return ordenSnies;
	}
	/**
	 * @param ordenSnies the ordenSnies to set
	 */
	public void setOrdenSnies(int ordenSnies) {
		this.ordenSnies = ordenSnies;
	}
	/**
	 * @return the sippaDedCodigo
	 */
	public String getSippaDedCodigo() {
		return sippaDedCodigo;
	}
	/**
	 * @param sippaDedCodigo the sippaDedCodigo to set
	 */
	public void setSippaDedCodigo(String sippaDedCodigo) {
		this.sippaDedCodigo = sippaDedCodigo;
	}
	/**
	 * @return the codigoHecaa
	 */
	public String getCodigoHecaa() {
		return codigoHecaa;
	}
	/**
	 * @param codigoHecaa the codigoHecaa to set
	 */
	public void setCodigoHecaa(String codigoHecaa) {
		this.codigoHecaa = codigoHecaa;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dedicacion [codigo=" + codigo + ", nombre=" + nombre + ", ordenSnies=" + ordenSnies
				+ ", sippaDedCodigo=" + sippaDedCodigo + ", codigoHecaa=" + codigoHecaa + "]";
	}
	
	
	
	
	
}
