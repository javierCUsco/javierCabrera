/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Departamento {
	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String id;//char](2) NULL,
	private String nombre;//varchar](100) NOT NULL,
	private Pais pais= new Pais();//int] NOT NULL,
	private int sippaDepCodigo;//int] NULL,
	private String daneCodigo;//char](10) NULL,
	
	
	
	/**
	 * 
	 */
	public Departamento() {
	}
	
	
	
	/**
	 * @param codigo
	 * @param id
	 * @param nombre
	 * @param pais
	 * @param sippaDepCodigo
	 * @param daneCodigo
	 */
	public Departamento(int codigo, String id, String nombre, Pais pais, int sippaDepCodigo, String daneCodigo) {
		this.codigo = codigo;
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.sippaDepCodigo = sippaDepCodigo;
		this.daneCodigo = daneCodigo;
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
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	/**
	 * @return the sippaDepCodigo
	 */
	public int getSippaDepCodigo() {
		return sippaDepCodigo;
	}
	/**
	 * @param sippaDepCodigo the sippaDepCodigo to set
	 */
	public void setSippaDepCodigo(int sippaDepCodigo) {
		this.sippaDepCodigo = sippaDepCodigo;
	}
	/**
	 * @return the daneCodigo
	 */
	public String getDaneCodigo() {
		return daneCodigo;
	}
	/**
	 * @param daneCodigo the daneCodigo to set
	 */
	public void setDaneCodigo(String daneCodigo) {
		this.daneCodigo = daneCodigo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", id=" + id + ", nombre=" + nombre + ", pais=" + pais
				+ ", sippaDepCodigo=" + sippaDepCodigo + ", daneCodigo=" + daneCodigo + "]";
	}
	
	
	
	
}
