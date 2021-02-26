/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class WebParametro  {
	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String nombre;//varchar](100) NOT NULL,
	private String valor;//varchar](500) NOT NULL,
	private String descripcion;//varchar](500) NULL,
	
	
	
	/**
	 * 
	 */
	public WebParametro() {
	}
	
	
	
	/**
	 * @param nombre
	 */
	public WebParametro(String nombre) {
		this.nombre = nombre;
	}



	/**
	 * @param codigo
	 * @param nombre
	 * @param valor
	 * @param descripcion
	 */
	public WebParametro(int codigo, String nombre, String valor, String descripcion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
		this.descripcion = descripcion;
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
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WebParametro [codigo=" + codigo + ", nombre=" + nombre + ", valor=" + valor + ", descripcion="
				+ descripcion + "]";
	}
	
	
}
