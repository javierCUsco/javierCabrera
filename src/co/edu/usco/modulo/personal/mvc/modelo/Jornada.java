/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author ING_JAVIER
 *
 */
public class Jornada {
	
	private int codigo;
	private String nombre;
	private int sippaJorCodigo;
	
	
	
	/**
	 * 
	 */
	public Jornada() {
	}
	/**
	 * @param codigo
	 * @param nombre
	 * @param sippaJorCodigo
	 */
	public Jornada(int codigo, String nombre, int sippaJorCodigo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.sippaJorCodigo = sippaJorCodigo;
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
	 * @return the sippaJorCodigo
	 */
	public int getSippaJorCodigo() {
		return sippaJorCodigo;
	}
	/**
	 * @param sippaJorCodigo the sippaJorCodigo to set
	 */
	public void setSippaJorCodigo(int sippaJorCodigo) {
		this.sippaJorCodigo = sippaJorCodigo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Jornada [codigo=" + codigo + ", nombre=" + nombre + ", sippaJorCodigo=" + sippaJorCodigo + "]";
	}

	
}
