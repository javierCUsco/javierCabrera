/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Estrato {

	private String codigo;
	private String descripcion;
	private String sniesCodigo;
	private boolean estado;
	
	
	
	/**
	 * 
	 */
	public Estrato() {
	}
	/**
	 * @param codigo
	 * @param descripcion
	 * @param sniesCodigo
	 * @param estado
	 */
	public Estrato(String codigo, String descripcion, String sniesCodigo, boolean estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.sniesCodigo = sniesCodigo;
		this.estado = estado;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Estrato [codigo=" + codigo + ", descripcion=" + descripcion + ", sniesCodigo=" + sniesCodigo
				+ ", estado=" + estado + "]";
	}
	
	
	
}
