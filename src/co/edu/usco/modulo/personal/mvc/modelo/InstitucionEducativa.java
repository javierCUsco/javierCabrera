/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class InstitucionEducativa {
	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private InstitucionEducativaTipo institucionEducativaTipo= new InstitucionEducativaTipo();
	private String nombre;//varchar](150) NOT NULL,
	private Municipio municipio= new Municipio();
	private Jornada jornada= new Jornada();
	private String nivel;//varchar](50) NULL,
	private int incCodigo;//int] NULL,
	private String insCodigo;//char](5) NULL,,
	private String codigoHecaa;//varchar](30) NULL,
	
	
	
	
	/**
	 * 
	 */
	public InstitucionEducativa() {
	}
	
	
	/**
	 * @param codigo
	 * @param institucionEducativaTipo 
	 * @param nombre
	 * @param municipio
	 * @param jornada
	 * @param nivel
	 * @param incCodigo 
	 * @param insCodigo 
	 * @param codigoHecaa
	 */
	public InstitucionEducativa(int codigo, InstitucionEducativaTipo institucionEducativaTipo, String nombre,
			Municipio municipio, Jornada jornada, String nivel, int incCodigo, String insCodigo,
			String codigoHecaa) {
		this.codigo = codigo;
		this.institucionEducativaTipo = institucionEducativaTipo;
		this.nombre = nombre;
		this.municipio = municipio;
		this.jornada = jornada;
		this.nivel = nivel;
		this.incCodigo = incCodigo;
		this.insCodigo = insCodigo;
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
	 * @return the tipoInstitucion
	 */
	public InstitucionEducativaTipo getInstitucionEducativaTipo() {
		return institucionEducativaTipo;
	}
	/**
	 * @param tipoInstitucion the tipoInstitucion to set
	 */
	public void setInstitucionEducativaTipo(InstitucionEducativaTipo institucionEducativaTipo) {
		this.institucionEducativaTipo = institucionEducativaTipo;
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
	 * @return the jornada
	 */
	public Jornada getJornada() {
		return jornada;
	}
	/**
	 * @param jornada the jornada to set
	 */
	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}
	/**
	 * @return the nivel
	 */
	public String getNivel() {
		return nivel;
	}
	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	/**
	 * @return the inc_codigo
	 */
	public int getIncCodigo() {
		return incCodigo;
	}
	/**
	 * @param inc_codigo the inc_codigo to set
	 */
	public void setIncCodigo(int inc_codigo) {
		this.incCodigo = inc_codigo;
	}
	/**
	 * @return the inscodigo
	 */
	public String getInsCodigo() {
		return insCodigo;
	}
	/**
	 * @param inscodigo the inscodigo to set
	 */
	public void setInsCodigo(String insCodigo) {
		this.insCodigo = insCodigo;
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
		return "InstitucionEducativa [codigo=" + codigo + ", InstitucionEducativaTipo=" + institucionEducativaTipo + ", nombre=" + nombre
				+ ", municipio=" + municipio + ", jornada=" + jornada + ", nivel=" + nivel
				+ ", incCodigo=" + incCodigo + ", insCodigo=" + insCodigo + ", codigoHecaa=" + codigoHecaa + "]";
	}

	
	
	
}
