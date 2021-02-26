/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class TipoId {
	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String nombre;//varchar](50) NULL,
	private String nombreCorto;//varchar](4) NULL,
	private String sniesCodigo;//varchar](3) NULL,
	private String spadiesCodigo;//char](1) NULL,
	private String observatorioLaboral;//char](2) NULL,-
	private String linixCodigo;//char](1) NULL,
	private boolean estado;//int] NULL,
	private int numCaracteres;//int] NULL,
	private String codigoHecaa;//char](2) NULL,
	
	
	/**
	 * 
	 */
	public TipoId() {
	}
	/**
	 * @param codigo
	 * @param nombre
	 * @param nombreCorto
	 * @param sniesCodigo
	 * @param spadiesCodigo
	 * @param observatorioLaboral
	 * @param linixCodigo
	 * @param estado
	 * @param numCaracteres
	 * @param codigoHecaa
	 */
	public TipoId(int codigo, String nombre, String nombreCorto, String sniesCodigo, String spadiesCodigo,
			String observatorioLaboral, String linixCodigo, boolean estado, int numCaracteres, String codigoHecaa) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.nombreCorto = nombreCorto;
		this.sniesCodigo = sniesCodigo;
		this.spadiesCodigo = spadiesCodigo;
		this.observatorioLaboral = observatorioLaboral;
		this.linixCodigo = linixCodigo;
		this.estado = estado;
		this.numCaracteres = numCaracteres;
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
	 * @return the nombreCorto
	 */
	public String getNombreCorto() {
		return nombreCorto;
	}
	/**
	 * @param nombreCorto the nombreCorto to set
	 */
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	/**
	 * @return the sniesCodigo
	 */
	public String getSniesCodigo() {
		return sniesCodigo;
	}
	/**
	 * @param sniesCodigo the sniesCodigo to set
	 */
	public void setSniesCodigo(String sniesCodigo) {
		this.sniesCodigo = sniesCodigo;
	}
	/**
	 * @return the spadiesCodigo
	 */
	public String getSpadiesCodigo() {
		return spadiesCodigo;
	}
	/**
	 * @param spadiesCodigo the spadiesCodigo to set
	 */
	public void setSpadiesCodigo(String spadiesCodigo) {
		this.spadiesCodigo = spadiesCodigo;
	}
	/**
	 * @return the observatorioLaboral
	 */
	public String getObservatorioLaboral() {
		return observatorioLaboral;
	}
	/**
	 * @param observatorioLaboral the observatorioLaboral to set
	 */
	public void setObservatorioLaboral(String observatorioLaboral) {
		this.observatorioLaboral = observatorioLaboral;
	}
	/**
	 * @return the linixCodigo
	 */
	public String getLinixCodigo() {
		return linixCodigo;
	}
	/**
	 * @param linixCodigo the linixCodigo to set
	 */
	public void setLinixCodigo(String linixCodigo) {
		this.linixCodigo = linixCodigo;
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
	/**
	 * @return the numCaracteres
	 */
	public int getNumCaracteres() {
		return numCaracteres;
	}
	/**
	 * @param numCaracteres the numCaracteres to set
	 */
	public void setNumCaracteres(int numCaracteres) {
		this.numCaracteres = numCaracteres;
	}
	/**
	 * @return the codigoHecaa
	 */
	public String getCodigoHecaa() {
		return codigoHecaa;
	}
	/**
	 * @param codigoHecaa the codigoHecaa to set
	 */
	public void setCodigoHecaa(String codigoHecaa) {
		this.codigoHecaa = codigoHecaa;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TipoId [codigo=" + codigo + ", nombre=" + nombre + ", nombreCorto=" + nombreCorto + ", sniesCodigo="
				+ sniesCodigo + ", spadiesCodigo=" + spadiesCodigo + ", observatorioLaboral=" + observatorioLaboral
				+ ", linixCodigo=" + linixCodigo + ", estado=" + estado + ", numCaracteres=" + numCaracteres
				+ ", codigoHecaa=" + codigoHecaa + "]";
	}
	
	
	
}
