/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class InstitucionEducativaTipo {
	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String nombre;//varchar](50) NOT NULL,
	
	/**
	 * 
	 */
	public InstitucionEducativaTipo() {
	}
	/**
	 * @param codigo
	 * @param nombre
	 */
	public InstitucionEducativaTipo(int codigo, String nombre) {
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
		return "InstitucionEducativaTipo [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
	
}
