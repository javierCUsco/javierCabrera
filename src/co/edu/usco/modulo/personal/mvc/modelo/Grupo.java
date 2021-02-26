/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author ING_JAVIER
 *
 */
public class Grupo {

	private int codigo;//] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String nombre;//] [varchar](100) NOT NULL,
	private String id;// [varchar;//](100) NULL,
	
	
	
	/**
	 * 
	 */
	public Grupo() {
	}
	/**
	 * @param codigo
	 * @param nombre
	 * @param id
	 */
	public Grupo(int codigo, String nombre, String id) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.id = id;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Grupo [codigo=" + codigo + ", nombre=" + nombre + ", id=" + id + "]";
	}
	
	
}
