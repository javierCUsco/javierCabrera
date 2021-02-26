/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.util.Date;

import co.edu.usco.modulo.personal.mvc.modelo.sgd.Documento;


/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PersonaHistoriaLaboral  {
	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private Date fechaInicio;//datetime] NULL,
	private Date fechaFin;//datetime] NULL,
	private String empresa;//varchar](200) NULL,
	private String empresaDireccion;//nchar](10) NULL,
	private String empresaTelefono;//nchar](10) NULL,
	private Municipio municipio= new Municipio();//int] NULL,
	private HistoriaLaboralTipo historiaLaboralTipo= new HistoriaLaboralTipo();//int] NOT NULL,
	private Dedicacion dedicacion= new Dedicacion();//int] NOT NULL,
	private Vinculacion vinculacion= new Vinculacion();//int] NOT NULL,
	private String cargo;//nvarchar](100) NULL,
	private String descripcion;//nvarchar](250) NULL,
	private float puntos;//float] NULL,
	//private String documento;
	private Date puntosFecha;//datetime] NULL,
	private boolean valido;//] [int] NULL,
	private String grupo;//] [varchar](255) NULL,
	private String CvLac;//] [varchar](255) NULL,
	private String GrupLac;//] [varchar](255) NULL,
	private Documento documento= new Documento();
	private boolean documentoValido;
	private boolean documentoRechazado;
	private String observacion;
	
	
	
	/**
	 * 
	 */
	public PersonaHistoriaLaboral() {
	}
	/**
	 * @param codigo
	 * @param persona
	 * @param fechaInicio
	 * @param fechaFin
	 * @param empresa
	 * @param empresaDireccion
	 * @param empresaTelefono
	 * @param municipio
	 * @param historiaLaboralTipo
	 * @param dedicacion
	 * @param vinculacion
	 * @param cargo
	 * @param descripcion
	 * @param puntos
	 * @param documento
	 * @param puntosFecha
	 * @param archivo
	 * @param doc_codigo
	 * @param valido
	 * @param grupo
	 * @param cvLac
	 * @param grupLac
	 * @param documentoSgd
	 */
	public PersonaHistoriaLaboral(int codigo,  Date fechaInicio, Date fechaFin, String empresa,
			String empresaDireccion, String empresaTelefono, Municipio municipio,
			HistoriaLaboralTipo historiaLaboralTipo, Dedicacion dedicacion, Vinculacion vinculacion, String cargo,
			String descripcion, float puntos, Date puntosFecha, 
			boolean valido, String grupo, String cvLac, String grupLac,Documento documento,boolean documentoValido,boolean documentoRechazado) {//, Documento documentoSgd) {
		this.codigo = codigo;
		
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.empresa = empresa;
		this.empresaDireccion = empresaDireccion;
		this.empresaTelefono = empresaTelefono;
		this.municipio = municipio;
		this.historiaLaboralTipo = historiaLaboralTipo;
		this.dedicacion = dedicacion;
		this.vinculacion = vinculacion;
		this.cargo = cargo;
		this.descripcion = descripcion;
		this.puntos = puntos;
		this.puntosFecha = puntosFecha;
		this.valido = valido;
		this.grupo = grupo;
		CvLac = cvLac;
		GrupLac = grupLac;
		this.documento = documento;
		this.documentoValido=documentoValido;
		this.documentoRechazado=documentoRechazado;
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
//	/**
//	 * @return the persona
//	 */
//	public Persona getPersona() {
//		return persona;
//	}
//	/**
//	 * @param persona the persona to set
//	 */
//	public void setPersona(Persona persona) {
//		this.persona = persona;
//	}
	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}
	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	/**
	 * @return the empresaDireccion
	 */
	public String getEmpresaDireccion() {
		return empresaDireccion;
	}
	/**
	 * @param empresaDireccion the empresaDireccion to set
	 */
	public void setEmpresaDireccion(String empresaDireccion) {
		this.empresaDireccion = empresaDireccion;
	}
	/**
	 * @return the empresaTelefono
	 */
	public String getEmpresaTelefono() {
		return empresaTelefono;
	}
	/**
	 * @param empresaTelefono the empresaTelefono to set
	 */
	public void setEmpresaTelefono(String empresaTelefono) {
		this.empresaTelefono = empresaTelefono;
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
	 * @return the historiaLaboralTipo
	 */
	public HistoriaLaboralTipo getHistoriaLaboralTipo() {
		return historiaLaboralTipo;
	}
	/**
	 * @param historiaLaboralTipo the historiaLaboralTipo to set
	 */
	public void setHistoriaLaboralTipo(HistoriaLaboralTipo historiaLaboralTipo) {
		this.historiaLaboralTipo = historiaLaboralTipo;
	}
	/**
	 * @return the dedicacion
	 */
	public Dedicacion getDedicacion() {
		return dedicacion;
	}
	/**
	 * @param dedicacion the dedicacion to set
	 */
	public void setDedicacion(Dedicacion dedicacion) {
		this.dedicacion = dedicacion;
	}
	/**
	 * @return the vinculacion
	 */
	public Vinculacion getVinculacion() {
		return vinculacion;
	}
	/**
	 * @param vinculacion the vinculacion to set
	 */
	public void setVinculacion(Vinculacion vinculacion) {
		this.vinculacion = vinculacion;
	}
	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}
	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the puntos
	 */
	public float getPuntos() {
		return puntos;
	}
	/**
	 * @param puntos the puntos to set
	 */
	public void setPuntos(float puntos) {
		this.puntos = puntos;
	}
	/**
	 * @return the documento
	 */
	public Documento getDocumento() {
		return documento;
	}
	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	/**
	 * @return the puntosFecha
	 */
	public Date getPuntosFecha() {
		return puntosFecha;
	}
	/**
	 * @param puntosFecha the puntosFecha to set
	 */
	public void setPuntosFecha(Date puntosFecha) {
		this.puntosFecha = puntosFecha;
	}
	/**
	 * @return the valido
	 */
	public boolean getValido() {
		return valido;
	}
	/**
	 * @param valido the valido to set
	 */
	public void setValido(boolean valido) {
		this.valido = valido;
	}
	/**
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}
	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	/**
	 * @return the cvLac
	 */
	public String getCvLac() {
		return CvLac;
	}
	/**
	 * @param cvLac the cvLac to set
	 */
	public void setCvLac(String cvLac) {
		CvLac = cvLac;
	}
	/**
	 * @return the grupLac
	 */
	public String getGrupLac() {
		return GrupLac;
	}
	/**
	 * @param grupLac the grupLac to set
	 */
	public void setGrupLac(String grupLac) {
		GrupLac = grupLac;
	}
	
	/**
	 * @return the documentoValido
	 */
	public boolean isDocumentoValido() {
		return documentoValido;
	}
	/**
	 * @param documentoValido the documentoValido to set
	 */
	public void setDocumentoValido(boolean documentoValido) {
		this.documentoValido = documentoValido;
	}
	
	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}
	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	/**
	 * @return the documentoRechazado
	 */
	public boolean isDocumentoRechazado() {
		return documentoRechazado;
	}
	/**
	 * @param documentoRechazado the documentoRechazado to set
	 */
	public void setDocumentoRechazado(boolean documentoRechazado) {
		this.documentoRechazado = documentoRechazado;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonaHistoriaLaboral [codigo=" + codigo  + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", empresa=" + empresa + ", empresaDireccion=" + empresaDireccion
				+ ", empresaTelefono=" + empresaTelefono + ", municipio=" + municipio + ", historiaLaboralTipo="
				+ historiaLaboralTipo + ", dedicacion=" + dedicacion + ", vinculacion=" + vinculacion + ", cargo="
				+ cargo + ", descripcion=" + descripcion + ", puntos=" + puntos + ", puntosFecha=" + puntosFecha
				+ ", valido=" + valido + ", grupo=" + grupo + ", CvLac=" + CvLac + ", GrupLac=" + GrupLac
				+ ", documento=" + documento + ", documentoValido=" + documentoValido + ", documentoRechazado="
				+ documentoRechazado + ", observacion=" + observacion + "]";
	}
	
	
	
	
	
}
