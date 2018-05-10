/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PersonaHistoriaAcademica implements Serializable {
	private int pha_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
//	private per_codigo;//int] NOT NULL,
	private Persona persona = new Persona();
	private Date pha_fecha_inicio;//datetime] NULL,
	private Date pha_fecha_fin;//datetime] NULL,
//	private ine_codigo;//int] NOT NULL,
	private Institucion_educativaOb institucion= new Institucion_educativaOb();
	//private pha_ciudad;//int] NULL,
	private MunicipioOb municipio= new MunicipioOb();
	private String pha_titulo;//varchar](120) NULL,
//	private nia_codigo;//int] NOT NULL,
	private nivel_academicoOb nivel_academico= new nivel_academicoOb();
	private char pha_horas;//char](10) NULL,
	private float pha_puntos;//float] NULL,
	private String pha_documento;//varchar](150) NULL,
	private int pha_estado;//int] NULL,
	private char sippa_doccedula;//char](11) NULL,
	private char sippa_nivcodigo;//char](3) NULL,
	private char sippa_arecodigo;//char](3) NULL,
	private Date sippa_titfecha;//datetime] NULL,
	private Date pha_marca_migracion;//datetime] NULL,
	private Date pha_puntos_fecha;//datetime] NULL,
	private float pha_puntos_ajuste;//float] NULL,
	private String pha_puntos_descripcion;//varchar](2000) NULL,
	private int pha_duracion_anos;//tinyint] NULL,
	private Date pha_fecha_titulo;//datetime] NULL,
	private int pha_convalidado;//int] NULL,
//	private pha_mod_codigo;//int] NULL,
	private ModalidadOb modalidad= new ModalidadOb();
	
	/**
	 * @return the pha_codigo
	 */
	public int getPha_codigo() {
		return pha_codigo;
	}
	/**
	 * @param pha_codigo the pha_codigo to set
	 */
	public void setPha_codigo(int pha_codigo) {
		this.pha_codigo = pha_codigo;
	}
	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}
	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	/**
	 * @return the pha_fecha_inicio
	 */
	public Date getPha_fecha_inicio() {
		return pha_fecha_inicio;
	}
	/**
	 * @param pha_fecha_inicio the pha_fecha_inicio to set
	 */
	public void setPha_fecha_inicio(Date pha_fecha_inicio) {
		this.pha_fecha_inicio = pha_fecha_inicio;
	}
	/**
	 * @return the pha_fecha_fin
	 */
	public Date getPha_fecha_fin() {
		return pha_fecha_fin;
	}
	/**
	 * @param pha_fecha_fin the pha_fecha_fin to set
	 */
	public void setPha_fecha_fin(Date pha_fecha_fin) {
		this.pha_fecha_fin =pha_fecha_fin;
	}
	/**
	 * @return the institucion
	 */
	public Institucion_educativaOb getInstitucion() {
		return institucion;
	}
	/**
	 * @param institucion the institucion to set
	 */
	public void setInstitucion(Institucion_educativaOb institucion) {
		this.institucion = institucion;
	}
	/**
	 * @return the municipio
	 */
	public MunicipioOb getMunicipio() {
		return municipio;
	}
	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(MunicipioOb municipio) {
		this.municipio = municipio;
	}
	/**
	 * @return the pha_titulo
	 */
	public String getPha_titulo() {
		return pha_titulo;
	}
	/**
	 * @param pha_titulo the pha_titulo to set
	 */
	public void setPha_titulo(String pha_titulo) {
		this.pha_titulo = pha_titulo;
	}
	/**
	 * @return the nivel_academico
	 */
	public nivel_academicoOb getNivel_academico() {
		return nivel_academico;
	}
	/**
	 * @param nivel_academico the nivel_academico to set
	 */
	public void setNivel_academico(nivel_academicoOb nivel_academico) {
		this.nivel_academico = nivel_academico;
	}
	/**
	 * @return the pha_horas
	 */
	public char getPha_horas() {
		return pha_horas;
	}
	/**
	 * @param pha_horas the pha_horas to set
	 */
	public void setPha_horas(char pha_horas) {
		this.pha_horas = pha_horas;
	}
	/**
	 * @return the pha_puntos
	 */
	public float getPha_puntos() {
		return pha_puntos;
	}
	/**
	 * @param pha_puntos the pha_puntos to set
	 */
	public void setPha_puntos(float pha_puntos) {
		this.pha_puntos = pha_puntos;
	}
	/**
	 * @return the pha_documento
	 */
	public String getPha_documento() {
		return pha_documento;
	}
	/**
	 * @param pha_documento the pha_documento to set
	 */
	public void setPha_documento(String pha_documento) {
		this.pha_documento = pha_documento;
	}
	/**
	 * @return the pha_estado
	 */
	public int getPha_estado() {
		return pha_estado;
	}
	/**
	 * @param pha_estado the pha_estado to set
	 */
	public void setPha_estado(int pha_estado) {
		this.pha_estado = pha_estado;
	}
	/**
	 * @return the sippa_doccedula
	 */
	public char getSippa_doccedula() {
		return sippa_doccedula;
	}
	/**
	 * @param sippa_doccedula the sippa_doccedula to set
	 */
	public void setSippa_doccedula(char sippa_doccedula) {
		this.sippa_doccedula = sippa_doccedula;
	}
	/**
	 * @return the sippa_nivcodigo
	 */
	public char getSippa_nivcodigo() {
		return sippa_nivcodigo;
	}
	/**
	 * @param sippa_nivcodigo the sippa_nivcodigo to set
	 */
	public void setSippa_nivcodigo(char sippa_nivcodigo) {
		this.sippa_nivcodigo = sippa_nivcodigo;
	}
	/**
	 * @return the sippa_arecodigo
	 */
	public char getSippa_arecodigo() {
		return sippa_arecodigo;
	}
	/**
	 * @param sippa_arecodigo the sippa_arecodigo to set
	 */
	public void setSippa_arecodigo(char sippa_arecodigo) {
		this.sippa_arecodigo = sippa_arecodigo;
	}
	/**
	 * @return the sippa_titfecha
	 */
	public Date getSippa_titfecha() {
		return sippa_titfecha;
	}
	/**
	 * @param sippa_titfecha the sippa_titfecha to set
	 */
	public void setSippa_titfecha(Date sippa_titfecha) {
		this.sippa_titfecha = sippa_titfecha;
	}
	/**
	 * @return the pha_marca_migracion
	 */
	public Date getPha_marca_migracion() {
		return pha_marca_migracion;
	}
	/**
	 * @param pha_marca_migracion the pha_marca_migracion to set
	 */
	public void setPha_marca_migracion(Date pha_marca_migracion) {
		this.pha_marca_migracion = pha_marca_migracion;
	}
	/**
	 * @return the pha_puntos_fecha
	 */
	public Date getPha_puntos_fecha() {
		return pha_puntos_fecha;
	}
	/**
	 * @param pha_puntos_fecha the pha_puntos_fecha to set
	 */
	public void setPha_puntos_fecha(Date pha_puntos_fecha) {
		this.pha_puntos_fecha = pha_puntos_fecha;
	}
	/**
	 * @return the pha_puntos_ajuste
	 */
	public float getPha_puntos_ajuste() {
		return pha_puntos_ajuste;
	}
	/**
	 * @param pha_puntos_ajuste the pha_puntos_ajuste to set
	 */
	public void setPha_puntos_ajuste(float pha_puntos_ajuste) {
		this.pha_puntos_ajuste = pha_puntos_ajuste;
	}
	/**
	 * @return the pha_puntos_descripcion
	 */
	public String getPha_puntos_descripcion() {
		return pha_puntos_descripcion;
	}
	/**
	 * @param pha_puntos_descripcion the pha_puntos_descripcion to set
	 */
	public void setPha_puntos_descripcion(String pha_puntos_descripcion) {
		this.pha_puntos_descripcion = pha_puntos_descripcion;
	}
	/**
	 * @return the pha_duracion_anos
	 */
	public int getPha_duracion_anos() {
		return pha_duracion_anos;
	}
	/**
	 * @param pha_duracion_anos the pha_duracion_anos to set
	 */
	public void setPha_duracion_anos(int pha_duracion_anos) {
		this.pha_duracion_anos = pha_duracion_anos;
	}
	/**
	 * @return the pha_fecha_titulo
	 */
	public Date getPha_fecha_titulo() {
		return pha_fecha_titulo;
	}
	/**
	 * @param pha_fecha_titulo the pha_fecha_titulo to set
	 */
	public void setPha_fecha_titulo(Date pha_fecha_titulo) {
		this.pha_fecha_titulo = pha_fecha_titulo;
	}
	/**
	 * @return the pha_convalidado
	 */
	public int getPha_convalidado() {
		return pha_convalidado;
	}
	/**
	 * @param pha_convalidado the pha_convalidado to set
	 */
	public void setPha_convalidado(int pha_convalidado) {
		this.pha_convalidado = pha_convalidado;
	}
	/**
	 * @return the modalidad
	 */
	public ModalidadOb getModalidad() {
		return modalidad;
	}
	/**
	 * @param modalidad the modalidad to set
	 */
	public void setModalidad(ModalidadOb modalidad) {
		this.modalidad = modalidad;
	}
	
	
	
	
	
}
