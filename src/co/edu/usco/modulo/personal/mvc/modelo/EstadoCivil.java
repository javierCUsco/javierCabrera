/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class EstadoCivil {
	private int codigo;//char](1) NOT NULL,
	private String nombre;//char](50) NULL,
	private int sippaEscCodigo;//int] NULL,
	private String SNIESCodigo;//varchar](2) NULL,
	private int codigoHecaa;//int] NULL,
	
	
	
	/**
	 * 
	 */
	public EstadoCivil() {
	}
	/**
	 * @param codigo
	 * @param esc_nombre
	 * @param sippaEscCodigo
	 * @param sNIESCodigo
	 * @param codigoHecaa
	 */
	public EstadoCivil(int codigo, String nombre, int sippaEscCodigo, String sNIESCodigo, int codigoHecaa) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.sippaEscCodigo = sippaEscCodigo;
		SNIESCodigo = sNIESCodigo;
		this.codigoHecaa = codigoHecaa;
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
	 * @return the esc_nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param esc_nombre the esc_nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the sippaEscCodigo
	 */
	public int getSippaEscCodigo() {
		return sippaEscCodigo;
	}
	/**
	 * @param sippaEscCodigo the sippaEscCodigo to set
	 */
	public void setSippaEscCodigo(int sippaEscCodigo) {
		this.sippaEscCodigo = sippaEscCodigo;
	}
	/**
	 * @return the sNIESCodigo
	 */
	public String getSNIESCodigo() {
		return SNIESCodigo;
	}
	/**
	 * @param sNIESCodigo the sNIESCodigo to set
	 */
	public void setSNIESCodigo(String sNIESCodigo) {
		SNIESCodigo = sNIESCodigo;
	}
	/**
	 * @return the codigoHecaa
	 */
	public int getCodigoHecaa() {
		return codigoHecaa;
	}
	/**
	 * @param codigoHecaa the codigoHecaa to set
	 */
	public void setCodigoHecaa(int codigoHecaa) {
		this.codigoHecaa = codigoHecaa;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EstadoCivil [codigo=" + codigo + ", nombre=" + nombre + ", sippaEscCodigo=" + sippaEscCodigo
				+ ", SNIESCodigo=" + SNIESCodigo + ", codigoHecaa=" + codigoHecaa + "]";
	}
	
	
	
	
}
