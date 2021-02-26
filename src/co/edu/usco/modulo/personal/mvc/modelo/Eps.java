/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Eps {
	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String nombre;//varchar](150) NOT NULL,
	private String numeroAfiliacionEps;
	private boolean estado;
	
	
	
	/**
	 * 
	 */
	public Eps() {
	}
	/**
	 * @param codigo
	 * @param nombre
	 * @param numeroAfiliacionEps
	 */
	public Eps(int codigo, String nombre, String numeroAfiliacionEps) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.numeroAfiliacionEps = numeroAfiliacionEps;
	}
	
	
	
	/**
	 * @param codigo
	 * @param nombre
	 * @param numeroAfiliacionEps
	 * @param estado
	 */
	public Eps(int codigo, String nombre, String numeroAfiliacionEps, boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.numeroAfiliacionEps = numeroAfiliacionEps;
		this.estado = estado;
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
	 * @return the numeroAfiliacionEps
	 */
	public String getNumeroAfiliacionEps() {
		return numeroAfiliacionEps;
	}
	/**
	 * @param numeroAfiliacionEps the numeroAfiliacionEps to set
	 */
	public void setNumeroAfiliacionEps(String numeroAfiliacionEps) {
		this.numeroAfiliacionEps = numeroAfiliacionEps;
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
		return "Eps [codigo=" + codigo + ", nombre=" + nombre + ", numeroAfiliacionEps=" + numeroAfiliacionEps
				+ ", estado=" + estado + "]";
	}
	
	
	
	
	
	
	
	
}
