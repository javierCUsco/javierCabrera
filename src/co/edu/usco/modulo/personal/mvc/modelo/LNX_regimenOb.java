/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class LNX_regimenOb {
	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String nombre;//char](30) NULL,
	private String acronimo;//char](1) NULL,
	
	
	
	/**
	 * 
	 */
	public LNX_regimenOb() {
	}
	/**
	 * @param codigo
	 * @param nombre
	 * @param acronimo
	 */
	public LNX_regimenOb(int codigo, String nombre, String acronimo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.acronimo = acronimo;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LNX_regimenOb [codigo=" + codigo + ", nombre=" + nombre + ", acronimo=" + acronimo + "]";
	}
	
	
}
