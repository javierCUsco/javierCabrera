/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Genero {

	private String sniesCodigo;
	private String codigo;
	private String nombre;
	
	
	/**
	 * 
	 */
	public Genero() {
	}
	/**
	 * @param sniesCodigo
	 * @param codigo
	 * @param nombre
	 */
	public Genero(String sniesCodigo, String codigo, String nombre) {
		this.sniesCodigo = sniesCodigo;
		this.codigo = codigo;
		this.nombre = nombre;
	}
	/**
	 * @return the sniesCodigo
	 */
	public String getSniesCodigo() {
		return sniesCodigo;
	}
	/**
	 * @param sniesCodigo the sniesCodigo to set
	 */
	public void setSniesCodigo(String sniesCodigo) {
		this.sniesCodigo = sniesCodigo;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Genero [sniesCodigo=" + sniesCodigo + ", codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
