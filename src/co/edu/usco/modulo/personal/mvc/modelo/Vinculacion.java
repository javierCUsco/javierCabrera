/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author ING. JAVIER CABRERA LASSO
 *
 */
public class Vinculacion {
	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String nombre;//varchar](50) NOT NULL,
	private int horasYear;//int] NULL,
	private int clase;//int] NULL,
	private String sippaVinCodigo;//char](3) NULL,
	private int vinContratacion;//char](3) NULL,
	private String externa;//varchar](1) NULL,
	
	
	
	
	/**
	 * 
	 */
	public Vinculacion() {
		
	}
	
	

	/**
	 * @param codigo
	 */
	public Vinculacion(int codigo) {
		this.codigo = codigo;
	}



	/**
	 * @param codigo
	 * @param nombre
	 * @param horasYear
	 * @param clase
	 * @param sippaVinCodigo
	 * @param contratacion
	 */
	public Vinculacion(int codigo, String nombre, int horasYear, int clase, String sippaVinCodigo, int vinContratacion,
			String externa) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.horasYear = horasYear;
		this.clase = clase;
		this.sippaVinCodigo = sippaVinCodigo;
		this.vinContratacion=vinContratacion;
		this.externa = externa;
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
	 * @return the horasYear
	 */
	public int getHorasYear() {
		return horasYear;
	}


	/**
	 * @param horasYear the horasYear to set
	 */
	public void setHorasYear(int horasYear) {
		this.horasYear = horasYear;
	}


	/**
	 * @return the clase
	 */
	public int getClase() {
		return clase;
	}


	/**
	 * @param clase the clase to set
	 */
	public void setClase(int clase) {
		this.clase = clase;
	}


	/**
	 * @return the sippaVinCodigo
	 */
	public String getSippaVinCodigo() {
		return sippaVinCodigo;
	}


	/**
	 * @param sippaVinCodigo the sippaVinCodigo to set
	 */
	public void setSippaVinCodigo(String sippaVinCodigo) {
		this.sippaVinCodigo = sippaVinCodigo;
	}


	/**
	 * @return the contratacion
	 */
	public String getExterna() {
		return externa;
	}


	/**
	 * @param contratacion the contratacion to set
	 */
	public void setExterna(String externa) {
		this.externa = externa;
	}



	/**
	 * @return the vinContratacion
	 */
	public int getVinContratacion() {
		return vinContratacion;
	}



	/**
	 * @param vinContratacion the vinContratacion to set
	 */
	public void setVinContratacion(int vinContratacion) {
		this.vinContratacion = vinContratacion;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vinculacion [codigo=" + codigo + ", nombre=" + nombre + ", horasYear=" + horasYear + ", clase=" + clase
				+ ", sippaVinCodigo=" + sippaVinCodigo + ", vinContratacion=" + vinContratacion + ", externa=" + externa
				+ "]";
	}
	



	
}
