/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class GrupoSanguineo {

	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String nombre;//varchar](50) NOT NULL,
	private int sippaGrsCodigo;//tinyint] NULL,
	
	
	
	/**
	 * 
	 */
	public GrupoSanguineo() {
	}



/**
 * 
 * @param nombre
 */
	public GrupoSanguineo(String nombre, int sippaGrsCodigo) {
		this.nombre = nombre;
		this.sippaGrsCodigo = sippaGrsCodigo;
	}



	/**
	 * @param codigo
	 * @param nombre
	 * @param setSippaGrsCodigo
	 */
	public GrupoSanguineo(int codigo, String nombre, int sippaGrsCodigo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.sippaGrsCodigo = sippaGrsCodigo;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GrupoSangineoOb [codigo=" + codigo + ", nombre=" + nombre + ", sippaGrsCodigo=" + sippaGrsCodigo + "]";
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
	 * @return sippaGrsCodigo
	 */
	public int getSippaGrsCodigo() {
		return sippaGrsCodigo;
	}



	
	/**
	 * @param sippaGrsCodigo
	 */
	public void setSippaGrsCodigo(int sippaGrsCodigo) {
		this.sippaGrsCodigo = sippaGrsCodigo;
	}
	
}
