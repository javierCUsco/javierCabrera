/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class TipoTerminacion implements Serializable {
	
	private int codigo;//int] IDENTITY(1,1) NOT NULL,
	private String nombre;//varchar](150) NULL,
	private int estado;//int] NULL,
	
	
	
	public TipoTerminacion() {
		
	}



	/**
	 * @param codigo
	 * @param nombre
	 * @param estado
	 */
	public TipoTerminacion(int codigo, String nombre, int estado) {
		this.codigo = codigo;
		this.nombre = nombre;
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
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}



	/**
	 * @param estado the estado to set
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TipoTerminacion [codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
	
	
	
	
}
