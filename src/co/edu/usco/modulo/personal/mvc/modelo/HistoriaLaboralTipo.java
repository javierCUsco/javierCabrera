/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class HistoriaLaboralTipo {
	private int codigo=0;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String nombre="";//varchar](50) NOT NULL,
	private boolean capEstado;
	
	/**
	 * 
	 */
	public HistoriaLaboralTipo() {
	}
	
	

	/**
	 * @param codigo
	 * @param nombre
	 * @param capEstado
	 */
	public HistoriaLaboralTipo(int codigo, String nombre, boolean capEstado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.capEstado = capEstado;
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
	 * @return the capEstado
	 */
	public boolean getCapEstado() {
		return capEstado;
	}

	/**
	 * @param capEstado the capEstado to set
	 */
	public void setCapEstado(boolean capEstado) {
		this.capEstado = capEstado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HistoriaLaboralTipo [codigo=" + codigo + ", nombre=" + nombre + ", capEstado=" + capEstado + "]";
	}
	
	
	
}
