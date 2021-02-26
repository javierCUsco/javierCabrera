/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author ING_JAVIER
 *
 */
public class Sede {

	private int codigo;//int] IDENTITY(1,1) NOT NULL,
	private String nombre;//varchar](50) NOT NULL,
	private Municipio municipio=new Municipio();
	private int sippaSedCodigo;//int] NULL,
	private boolean estado;//varchar](1) NULL,
	
	
	/**
	 * 
	 */
	public Sede() {
	}
	/**
	 * @param codigo
	 * @param nombre
	 * @param municipio
	 * @param sippaSedCodigo
	 * @param estado
	 */
	public Sede(int codigo, String nombre, Municipio municipio, int sippaSedCodigo, boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.municipio = municipio;
		this.sippaSedCodigo = sippaSedCodigo;
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
	 * @return the municipio
	 */
	public Municipio getMunicipio() {
		return municipio;
	}
	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	/**
	 * @return the sippaSedCodigo
	 */
	public int getSippaSedCodigo() {
		return sippaSedCodigo;
	}
	/**
	 * @param sippaSedCodigo the sippaSedCodigo to set
	 */
	public void setSippaSedCodigo(int sippaSedCodigo) {
		this.sippaSedCodigo = sippaSedCodigo;
	}
	/**
	 * @return the estado
	 */
	public boolean getEstado() {
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
		return "Sede [codigo=" + codigo + ", nombre=" + nombre + ", municipio=" + municipio + ", sippaSedCodigo="
				+ sippaSedCodigo + ", estado=" + estado + "]";
	}
	
	
	
	
	
}
