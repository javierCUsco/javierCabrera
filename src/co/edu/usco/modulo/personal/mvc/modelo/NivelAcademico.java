/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author Maritza
 *
 */
public class NivelAcademico {

	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String nombre;//varchar](50) NULL,
	private int orden;//tinyint] NULL,
	private int forCodigo;//tinyint] NULL,
	private String sniesCodigo;//char](2) NULL,
	private int sippaNiaCodigo;//int] NULL,
	private int sippaNivCodigo;//char](3) NULL,

	private int codigoMpHecaa;//int] NULL,
	private int codigoNedHecaa;//int] NULL,
	private int codigoNeHecaa;//int] NULL,
	private NivelAcademicoTipo nivelAcademicoTipo= new NivelAcademicoTipo(); 
	private int capPuntos;//int] NULL,
	private int capPuntosAdicionales;//int] NULL,
	private int capMaximo;//int] NULL,
	private int capPuntos_xano;//int] NULL,
	private int capDescripcion;//int] NULL,
	private boolean estado;//varchar](1) NOT NULL,
	private boolean capEstado;
	

	
	/**
	 * 
	 */
	public NivelAcademico() {
	}
	/**
	 * @param codigo
	 * @param nombre
	 * @param orden
	 * @param forCodigo
	 * @param sniesCodigo
	 * @param sippaNiaCodigo
	 * @param sippaNivCodigo
	 * @param codigoMpHecaa
	 * @param codigoNedHecaa
	 * @param codigoNeHecaa
	 * @param nivelAcademicoTipo
	 * @param capPuntos
	 * @param capPuntosAdicionales
	 * @param capMaximo
	 * @param capPuntos_xano
	 * @param capDescripcion
	 * @param estado
	 */
	public NivelAcademico(int codigo, String nombre, int orden, int forCodigo, String sniesCodigo, int sippaNiaCodigo,
			int sippaNivCodigo, int codigoMpHecaa, int codigoNedHecaa, int codigoNeHecaa,
			NivelAcademicoTipo nivelAcademicoTipo, int capPuntos, int capPuntosAdicionales, int capMaximo,
			int capPuntos_xano, int capDescripcion, boolean estado, boolean capEstado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.orden = orden;
		this.forCodigo = forCodigo;
		this.sniesCodigo = sniesCodigo;
		this.sippaNiaCodigo = sippaNiaCodigo;
		this.sippaNivCodigo = sippaNivCodigo;
		this.codigoMpHecaa = codigoMpHecaa;
		this.codigoNedHecaa = codigoNedHecaa;
		this.codigoNeHecaa = codigoNeHecaa;
		this.nivelAcademicoTipo = nivelAcademicoTipo;
		this.capPuntos = capPuntos;
		this.capPuntosAdicionales = capPuntosAdicionales;
		this.capMaximo = capMaximo;
		this.capPuntos_xano = capPuntos_xano;
		this.capDescripcion = capDescripcion;
		this.estado = estado;
		this.capEstado = this.capEstado;
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
	 * @return the orden
	 */
	public int getOrden() {
		return orden;
	}
	/**
	 * @param orden the orden to set
	 */
	public void setOrden(int orden) {
		this.orden = orden;
	}
	/**
	 * @return the forCodigo
	 */
	public int getForCodigo() {
		return forCodigo;
	}
	/**
	 * @param forCodigo the forCodigo to set
	 */
	public void setForCodigo(int forCodigo) {
		this.forCodigo = forCodigo;
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
	 * @return the sippaNiaCodigo
	 */
	public int getSippaNiaCodigo() {
		return sippaNiaCodigo;
	}
	/**
	 * @param sippaNiaCodigo the sippaNiaCodigo to set
	 */
	public void setSippaNiaCodigo(int sippaNiaCodigo) {
		this.sippaNiaCodigo = sippaNiaCodigo;
	}
	/**
	 * @return the sippaNivCodigo
	 */
	public int getSippaNivCodigo() {
		return sippaNivCodigo;
	}
	/**
	 * @param sippaNivCodigo the sippaNivCodigo to set
	 */
	public void setSippaNivCodigo(int sippaNivCodigo) {
		this.sippaNivCodigo = sippaNivCodigo;
	}
	/**
	 * @return the codigoMpHecaa
	 */
	public int getCodigoMpHecaa() {
		return codigoMpHecaa;
	}
	/**
	 * @param codigoMpHecaa the codigoMpHecaa to set
	 */
	public void setCodigoMpHecaa(int codigoMpHecaa) {
		this.codigoMpHecaa = codigoMpHecaa;
	}
	/**
	 * @return the codigoNedHecaa
	 */
	public int getCodigoNedHecaa() {
		return codigoNedHecaa;
	}
	/**
	 * @param codigoNedHecaa the codigoNedHecaa to set
	 */
	public void setCodigoNedHecaa(int codigoNedHecaa) {
		this.codigoNedHecaa = codigoNedHecaa;
	}
	/**
	 * @return the codigoNeHecaa
	 */
	public int getCodigoNeHecaa() {
		return codigoNeHecaa;
	}
	/**
	 * @param codigoNeHecaa the codigoNeHecaa to set
	 */
	public void setCodigoNeHecaa(int codigoNeHecaa) {
		this.codigoNeHecaa = codigoNeHecaa;
	}
	/**
	 * @return the nivelAcademicoTipo
	 */
	public NivelAcademicoTipo getNivelAcademicoTipo() {
		return nivelAcademicoTipo;
	}
	/**
	 * @param nivelAcademicoTipo the nivelAcademicoTipo to set
	 */
	public void setNivelAcademicoTipo(NivelAcademicoTipo nivelAcademicoTipo) {
		this.nivelAcademicoTipo = nivelAcademicoTipo;
	}
	/**
	 * @return the capPuntos
	 */
	public int getCapPuntos() {
		return capPuntos;
	}
	/**
	 * @param capPuntos the capPuntos to set
	 */
	public void setCapPuntos(int capPuntos) {
		this.capPuntos = capPuntos;
	}
	/**
	 * @return the capPuntosAdicionales
	 */
	public int getCapPuntosAdicionales() {
		return capPuntosAdicionales;
	}
	/**
	 * @param capPuntosAdicionales the capPuntosAdicionales to set
	 */
	public void setCapPuntosAdicionales(int capPuntosAdicionales) {
		this.capPuntosAdicionales = capPuntosAdicionales;
	}
	/**
	 * @return the capMaximo
	 */
	public int getCapMaximo() {
		return capMaximo;
	}
	/**
	 * @param capMaximo the capMaximo to set
	 */
	public void setCapMaximo(int capMaximo) {
		this.capMaximo = capMaximo;
	}
	/**
	 * @return the capPuntos_xano
	 */
	public int getCapPuntos_xano() {
		return capPuntos_xano;
	}
	/**
	 * @param capPuntos_xano the capPuntos_xano to set
	 */
	public void setCapPuntos_xano(int capPuntos_xano) {
		this.capPuntos_xano = capPuntos_xano;
	}
	/**
	 * @return the capDescripcion
	 */
	public int getCapDescripcion() {
		return capDescripcion;
	}
	/**
	 * @param capDescripcion the capDescripcion to set
	 */
	public void setCapDescripcion(int capDescripcion) {
		this.capDescripcion = capDescripcion;
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
	 * @return the capEstado
	 */
	public boolean isCapEstado() {
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
		return "NivelAcademico [codigo=" + codigo + ", nombre=" + nombre + ", orden=" + orden + ", forCodigo="
				+ forCodigo + ", sniesCodigo=" + sniesCodigo + ", sippaNiaCodigo=" + sippaNiaCodigo
				+ ", sippaNivCodigo=" + sippaNivCodigo + ", codigoMpHecaa=" + codigoMpHecaa + ", codigoNedHecaa="
				+ codigoNedHecaa + ", codigoNeHecaa=" + codigoNeHecaa + ", nivelAcademicoTipo=" + nivelAcademicoTipo
				+ ", capPuntos=" + capPuntos + ", capPuntosAdicionales=" + capPuntosAdicionales + ", capMaximo="
				+ capMaximo + ", capPuntos_xano=" + capPuntos_xano + ", capDescripcion=" + capDescripcion + ", estado="
				+ estado + ", capEstado=" + capEstado + "]";
	}
		
	
	
}
