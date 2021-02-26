/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author ING. JAVIER CABRERA LASSO
 *
 */
public class Cargo {
	private int codigo;//int] IDENTITY(0,1) NOT FOR REPLICATION NOT NULL,
	private String nombre;//varchar](50) NOT NULL,
	private String id;//varchar](4) NULL,
	private int  tmp;//int] NULL,
	
	
	
	/**
	 * 
	 */
	public Cargo() {
	}
	/**
	 * @param codigo
	 * @param nombre
	 * @param id
	 * @param tmp
	 */
	public Cargo(int codigo, String nombre, String id, int tmp) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.id = id;
		this.tmp = tmp;
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
	/**
	 * @return the tmp
	 */
	public int getTmp() {
		return tmp;
	}
	/**
	 * @param tmp the tmp to set
	 */
	public void setTmp(int tmp) {
		this.tmp = tmp;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cargo [codigo=" + codigo + ", nombre=" + nombre + ", id=" + id + ", tmp=" + tmp + "]";
	}
	
	
	
	
}
