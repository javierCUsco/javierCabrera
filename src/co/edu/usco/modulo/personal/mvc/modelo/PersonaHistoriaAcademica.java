/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;
import java.util.Date;

import co.edu.usco.modulo.personal.mvc.modelo.sgd.Documento;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PersonaHistoriaAcademica implements Serializable {
	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	//private Persona persona = new Persona();
	private Date fechaInicio;//datetime] NULL,
	private Date fechaFin;//datetime] NULL,
	private InstitucionEducativa institucionEducativa= new InstitucionEducativa();
	private String otraInstitucionEducativa;
	private Municipio municipio= new Municipio();
	private String otroMunicipio;
	private String titulo;//varchar](120) NULL,
	private NivelAcademico nivelAcademico= new NivelAcademico();
	private String horas;//char](10) NULL,
	private float puntos;//float] NULL,
	private String documento;//varchar](150) NULL,
	private boolean estado;//int] NULL,
	private String sippaDoccedula;//char](11) NULL,
	private String sippaNivcodigo;//char](3) NULL,
	private String sippaArecodigo;//char](3) NULL,
	private Date sippaTitfecha;//datetime] NULL,
	private Date marcaMigracion;//datetime] NULL,
//	private Date puntosFecha;//datetime] NULL,
	private float puntosAjuste;//float] NULL,
	private String puntosDescripcion;//varchar](2000) NULL,
	private int duracionAnos;//tinyint] NULL,
	private Date fechaTitulo;//datetime] NULL,
	private boolean convalidado;//int] NULL,
	private Modalidad modalidad= new Modalidad();
	private boolean valido;
	private boolean documentoValido;
	private boolean documentoRechazado;
	private Documento documentosgd = new Documento();
	private String observacion;
	
	
	/**
	 * 
	 */
	public PersonaHistoriaAcademica() {
	}
	/**
	 * @param codigo
	 * @param persona
	 * @param fechaInicio
	 * @param fechaFin
	 * @param institucion
	 * @param otraInstitucionEducativa
	 * @param municipio
	 * @param otroMunicipio
	 * @param titulo
	 * @param nivelAcademico
	 * @param horas
	 * @param puntos
	 * @param documento
	 * @param estado
	 * @param sippaDoccedula
	 * @param sippaNivcodigo
	 * @param sippaArecodigo
	 * @param sippaTitfecha
	 * @param marcaMigracion
	 * @param puntosAjuste
	 * @param puntosDescripcion
	 * @param duracionAnos
	 * @param fechaTitulo
	 * @param convalidado
	 * @param modalidad
	 * @param valido
	 * @param documentosgd
	 */
	public PersonaHistoriaAcademica(int codigo,  Date fechaInicio, Date fechaFin,
			InstitucionEducativa institucion, Municipio municipio,
			 String titulo, NivelAcademico nivelAcademico, String horas, float puntos,
			String documento, boolean estado, String sippaDoccedula, String sippaNivcodigo, String sippaArecodigo,
			Date sippaTitfecha, Date marcaMigracion, float puntosAjuste, String puntosDescripcion, int duracionAnos,
			Date fechaTitulo, boolean convalidado, Modalidad modalidad, boolean valido, Documento documentosgd,boolean documentoValido,boolean documentoRechazado) {
		this.codigo = codigo;
		//this.persona = persona;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.institucionEducativa = institucion;
		this.municipio = municipio;
		this.titulo = titulo;
		this.nivelAcademico = nivelAcademico;
		this.horas = horas;
		this.puntos = puntos;
		this.documento = documento;
		this.estado = estado;
		this.sippaDoccedula = sippaDoccedula;
		this.sippaNivcodigo = sippaNivcodigo;
		this.sippaArecodigo = sippaArecodigo;
		this.sippaTitfecha = sippaTitfecha;
		this.marcaMigracion = marcaMigracion;
		this.puntosAjuste = puntosAjuste;
		this.puntosDescripcion = puntosDescripcion;
		this.duracionAnos = duracionAnos;
		this.fechaTitulo = fechaTitulo;
		this.convalidado = convalidado;
		this.modalidad = modalidad;
		this.valido = valido;
		this.documentosgd = documentosgd;
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
	 * @return the institucion
	 */
	public InstitucionEducativa getInstitucionEducativa() {
		return institucionEducativa;
	}
	/**
	 * @param institucion the institucion to set
	 */
	public void setInstitucionEducativa(InstitucionEducativa institucion) {
		this.institucionEducativa = institucion;
	}
	/**
	 * @return the otraInstitucionEducativa
	 */
	public String getOtraInstitucionEducativa() {
		return otraInstitucionEducativa;
	}
	/**
	 * @param otraInstitucionEducativa the otraInstitucionEducativa to set
	 */
	public void setOtraInstitucionEducativa(String otraInstitucionEducativa) {
		this.otraInstitucionEducativa = otraInstitucionEducativa;
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
	 * @return the otroMunicipio
	 */
	public String getOtroMunicipio() {
		return otroMunicipio;
	}
	/**
	 * @param otroMunicipio the otroMunicipio to set
	 */
	public void setOtroMunicipio(String otroMunicipio) {
		this.otroMunicipio = otroMunicipio;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the nivelAcademico
	 */
	public NivelAcademico getNivelAcademico() {
		return nivelAcademico;
	}
	/**
	 * @param nivelAcademico the nivelAcademico to set
	 */
	public void setNivelAcademico(NivelAcademico nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}
	/**
	 * @return the horas
	 */
	public String getHoras() {
		return horas;
	}
	/**
	 * @param horas the horas to set
	 */
	public void setHoras(String horas) {
		this.horas = horas;
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
	public String getDocumento() {
		return documento;
	}
	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	/**
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	/**
	 * @return the sippaDoccedula
	 */
	public String getSippaDoccedula() {
		return sippaDoccedula;
	}
	/**
	 * @param sippaDoccedula the sippaDoccedula to set
	 */
	public void setSippaDoccedula(String sippaDoccedula) {
		this.sippaDoccedula = sippaDoccedula;
	}
	/**
	 * @return the sippaNivcodigo
	 */
	public String getSippaNivcodigo() {
		return sippaNivcodigo;
	}
	/**
	 * @param sippaNivcodigo the sippaNivcodigo to set
	 */
	public void setSippaNivcodigo(String sippaNivcodigo) {
		this.sippaNivcodigo = sippaNivcodigo;
	}
	/**
	 * @return the sippaArecodigo
	 */
	public String getSippaArecodigo() {
		return sippaArecodigo;
	}
	/**
	 * @param sippaArecodigo the sippaArecodigo to set
	 */
	public void setSippaArecodigo(String sippaArecodigo) {
		this.sippaArecodigo = sippaArecodigo;
	}
	/**
	 * @return the sippaTitfecha
	 */
	public Date getSippaTitfecha() {
		return sippaTitfecha;
	}
	/**
	 * @param sippaTitfecha the sippaTitfecha to set
	 */
	public void setSippaTitfecha(Date sippaTitfecha) {
		this.sippaTitfecha = sippaTitfecha;
	}
	/**
	 * @return the marcaMigracion
	 */
	public Date getMarcaMigracion() {
		return marcaMigracion;
	}
	/**
	 * @param marcaMigracion the marcaMigracion to set
	 */
	public void setMarcaMigracion(Date marcaMigracion) {
		this.marcaMigracion = marcaMigracion;
	}
	/**
	 * @return the puntosAjuste
	 */
	public float getPuntosAjuste() {
		return puntosAjuste;
	}
	/**
	 * @param puntosAjuste the puntosAjuste to set
	 */
	public void setPuntosAjuste(float puntosAjuste) {
		this.puntosAjuste = puntosAjuste;
	}
	/**
	 * @return the puntosDescripcion
	 */
	public String getPuntosDescripcion() {
		return puntosDescripcion;
	}
	/**
	 * @param puntosDescripcion the puntosDescripcion to set
	 */
	public void setPuntosDescripcion(String puntosDescripcion) {
		this.puntosDescripcion = puntosDescripcion;
	}
	/**
	 * @return the duracionAnos
	 */
	public int getDuracionAnos() {
		return duracionAnos;
	}
	/**
	 * @param duracionAnos the duracionAnos to set
	 */
	public void setDuracionAnos(int duracionAnos) {
		this.duracionAnos = duracionAnos;
	}
	/**
	 * @return the fechaTitulo
	 */
	public Date getFechaTitulo() {
		return fechaTitulo;
	}
	/**
	 * @param fechaTitulo the fechaTitulo to set
	 */
	public void setFechaTitulo(Date fechaTitulo) {
		this.fechaTitulo = fechaTitulo;
	}
	/**
	 * @return the convalidado
	 */
	public boolean isConvalidado() {
		return convalidado;
	}
	/**
	 * @param convalidado the convalidado to set
	 */
	public void setConvalidado(boolean convalidado) {
		this.convalidado = convalidado;
	}
	/**
	 * @return the modalidad
	 */
	public Modalidad getModalidad() {
		return modalidad;
	}
	/**
	 * @param modalidad the modalidad to set
	 */
	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}
	/**
	 * @return the valido
	 */
	public boolean isValido() {
		return valido;
	}
	/**
	 * @param valido the valido to set
	 */
	public void setValido(boolean valido) {
		this.valido = valido;
	}
	/**
	 * @return the documentosgd
	 */
	public Documento getDocumentosgd() {
		return documentosgd;
	}
	/**
	 * @param documentosgd the documentosgd to set
	 */
	public void setDocumentosgd(Documento documentosgd) {
		this.documentosgd = documentosgd;
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
		return "PersonaHistoriaAcademica [codigo=" + codigo + ", persona="  + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", institucionEducativa=" + institucionEducativa
				+ ", otraInstitucionEducativa=" + otraInstitucionEducativa + ", municipio=" + municipio
				+ ", otroMunicipio=" + otroMunicipio + ", titulo=" + titulo + ", nivelAcademico=" + nivelAcademico
				+ ", horas=" + horas + ", puntos=" + puntos + ", documento=" + documento + ", estado=" + estado
				+ ", sippaDoccedula=" + sippaDoccedula + ", sippaNivcodigo=" + sippaNivcodigo + ", sippaArecodigo="
				+ sippaArecodigo + ", sippaTitfecha=" + sippaTitfecha + ", marcaMigracion=" + marcaMigracion
				+ ", puntosAjuste=" + puntosAjuste + ", puntosDescripcion=" + puntosDescripcion + ", duracionAnos="
				+ duracionAnos + ", fechaTitulo=" + fechaTitulo + ", convalidado=" + convalidado + ", modalidad="
				+ modalidad + ", valido=" + valido + ", documentoValido=" + documentoValido + ", documentoRechazado="
				+ documentoRechazado + ", documentosgd=" + documentosgd + ", observacion=" + observacion + "]";
	}
	
	
	
	
}
