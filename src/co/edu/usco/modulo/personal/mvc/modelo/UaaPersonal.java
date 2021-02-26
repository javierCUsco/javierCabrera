/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.util.Date;


/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class UaaPersonal {
	
	
	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private Uaa uaa= new Uaa();//int] NOT NULL,
	private Persona persona= new Persona();//int] NOT NULL,
	private Date fechaInicio;//datetime] NOT NULL,
	private Date fechaFin;//datetime] NULL,
	private Cargo cargo= new Cargo();//int] NULL,
	private Vinculacion vinculacion= new Vinculacion();//int] NOT NULL,
	private Dedicacion dedicacion= new Dedicacion();//int] NULL,
	private String resolucion;//varchar](100) NULL,
	private boolean estado;//smallint] NULL,
//	private int esvCodigo;//int] NULL,
	private Escalafon escalafon= new Escalafon();
	private double escValor;//money] NULL,
	private String sippaPuntos;//varchar](500) NULL,
	private String sippaPoccedula;//char](11) NULL,
	private String sippaVincodigo;//char](3) NULL,
	private String sippaCalcodigo;//char](6) NULL,
	private String sippaDedcodigo;//char](1) NULL,
	private int codigoAnterior;//int] NULL,
	private UaaCargo uaaCargo= new UaaCargo();//int] NULL,
	private String plantaEncargo;//char](1) NULL,
	private int uacOcupado;//int] NULL,
	private int dependenciaEjerce;//int] NULL,
	private int codRegistro;//bigint] NULL,
	private String idCarnet;//varchar](45) NULL,
	private Sede sede= new Sede();//int] NULL,
	private String observacion;//nvarchar](max) NULL,
	private String imagenContrato;//varchar](45) NULL,
	private Agenda agenda= new Agenda();
	private DocentePuntos docentePuntos= new DocentePuntos();
	private DocenteEscalafon docenteEscalafon= new DocenteEscalafon();
	
	/**
	 * 
	 */
	public UaaPersonal() {
	}
	
	
	/**
	 * @param codigo
	 */
	public UaaPersonal(int codigo) {
		this.codigo = codigo;
	}

		
	

	/**
	 * @param codigo
	 * @param uaa
	 * @param persona
	 * @param fechaInicio
	 * @param fechaFin
	 * @param cargo
	 * @param vinculacion
	 * @param dedicacion
	 * @param resolucion
	 * @param estado
	 * @param escalafon
	 * @param escValor
	 * @param sede
	 * @param observacion
	 */
	public UaaPersonal(int codigo, Uaa uaa, Persona persona, Date fechaInicio, Date fechaFin, Cargo cargo,
			Vinculacion vinculacion, Dedicacion dedicacion, String resolucion, boolean estado, Escalafon escalafon,
			double escValor, Sede sede, String observacion, String imagenContrato) {
		this.codigo = codigo;
		this.uaa = uaa;
		this.persona = persona;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cargo = cargo;
		this.vinculacion = vinculacion;
		this.dedicacion = dedicacion;
		this.resolucion = resolucion;
		this.estado = estado;
		this.escalafon = escalafon;
		this.escValor = escValor;
		this.sede = sede;
		this.observacion = observacion;
		this.imagenContrato=imagenContrato;
	}


	/**
	 * @param codigo
	 * @param uaa
	 * @param persona
	 * @param fechaInicio
	 * @param fechaFin
	 * @param cargo
	 * @param vinculacion
	 * @param dedicacion
	 * @param resolucion
	 * @param estado
	 * @param escValor
	 * @param codigoAnterior
	 * @param uaaCargo
	 * @param plantaEncargo
	 * @param uacOcupado
	 * @param dependenciaEjerce
	 * @param sede
	 * @param observacion
	 */
	public UaaPersonal(int codigo, Uaa uaa, Persona persona, Date fechaInicio, Date fechaFin, Cargo cargo,
			Vinculacion vinculacion, Dedicacion dedicacion, String resolucion, boolean estado, Escalafon escalafon,
			double escValor, int codigoAnterior, UaaCargo uaaCargo, String plantaEncargo, int uacOcupado,
			int dependenciaEjerce, Sede sede, String observacion) {
		this.codigo = codigo;
		this.uaa = uaa;
		this.persona = persona;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cargo = cargo;
		this.vinculacion = vinculacion;
		this.dedicacion = dedicacion;
		this.resolucion = resolucion;
		this.estado = estado;
		this.escalafon = escalafon;
		this.escValor = escValor;
		this.codigoAnterior = codigoAnterior;
		this.uaaCargo = uaaCargo;
		this.plantaEncargo = plantaEncargo;
		this.uacOcupado = uacOcupado;
		this.dependenciaEjerce = dependenciaEjerce;
		this.sede = sede;
		this.observacion = observacion;
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
	 * @return the uaa
	 */
	public Uaa getUaa() {
		return uaa;
	}
	/**
	 * @param uaa the uaa to set
	 */
	public void setUaa(Uaa uaa) {
		this.uaa = uaa;
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
	 * @return the cargo
	 */
	public Cargo getCargo() {
		return cargo;
	}
	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
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
	 * @return the resolucion
	 */
	public String getResolucion() {
		return resolucion;
	}
	/**
	 * @param resolucion the resolucion to set
	 */
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
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
	 * @return the escalafon
	 */
	public Escalafon getEscalafon() {
		return escalafon;
	}


	/**
	 * @param escalafon the escalafon to set
	 */
	public void setEscalafon(Escalafon escalafon) {
		this.escalafon = escalafon;
	}
	
	/**
	 * @return the escValor
	 */
	public double getEscValor() {
		return escValor;
	}
	/**
	 * @param escValor the escValor to set
	 */
	public void setEscValor(double escValor) {
		this.escValor = escValor;
	}
	/**
	 * @return the sippaPuntos
	 */
	public String getSippaPuntos() {
		return sippaPuntos;
	}
	/**
	 * @param sippaPuntos the sippaPuntos to set
	 */
	public void setSippaPuntos(String sippaPuntos) {
		this.sippaPuntos = sippaPuntos;
	}
	/**
	 * @return the sippaPoccedula
	 */
	public String getSippaPoccedula() {
		return sippaPoccedula;
	}
	/**
	 * @param sippaPoccedula the sippaPoccedula to set
	 */
	public void setSippaPoccedula(String sippaPoccedula) {
		this.sippaPoccedula = sippaPoccedula;
	}
	/**
	 * @return the sippaVincodigo
	 */
	public String getSippaVincodigo() {
		return sippaVincodigo;
	}
	/**
	 * @param sippaVincodigo the sippaVincodigo to set
	 */
	public void setSippaVincodigo(String sippaVincodigo) {
		this.sippaVincodigo = sippaVincodigo;
	}
	/**
	 * @return the sippaCalcodigo
	 */
	public String getSippaCalcodigo() {
		return sippaCalcodigo;
	}
	/**
	 * @param sippaCalcodigo the sippaCalcodigo to set
	 */
	public void setSippaCalcodigo(String sippaCalcodigo) {
		this.sippaCalcodigo = sippaCalcodigo;
	}
	/**
	 * @return the sippaDedcodigo
	 */
	public String getSippaDedcodigo() {
		return sippaDedcodigo;
	}
	/**
	 * @param sippaDedcodigo the sippaDedcodigo to set
	 */
	public void setSippaDedcodigo(String sippaDedcodigo) {
		this.sippaDedcodigo = sippaDedcodigo;
	}
	/**
	 * @return the codigoAnterior
	 */
	public int getCodigoAnterior() {
		return codigoAnterior;
	}
	/**
	 * @param codigoAnterior the codigoAnterior to set
	 */
	public void setCodigoAnterior(int codigoAnterior) {
		this.codigoAnterior = codigoAnterior;
	}
	/**
	 * @return the uaaCargo
	 */
	public UaaCargo getUaaCargo() {
		return uaaCargo;
	}
	/**
	 * @param uaaCargo the uaaCargo to set
	 */
	public void setUaaCargo(UaaCargo uaaCargo) {
		this.uaaCargo = uaaCargo;
	}
	/**
	 * @return the plantaEncargo
	 */
	public String getPlantaEncargo() {
		return plantaEncargo;
	}
	/**
	 * @param plantaEncargo the plantaEncargo to set
	 */
	public void setPlantaEncargo(String plantaEncargo) {
		this.plantaEncargo = plantaEncargo;
	}
	/**
	 * @return the uacOcupado
	 */
	public int getUacOcupado() {
		return uacOcupado;
	}
	/**
	 * @param uacOcupado the uacOcupado to set
	 */
	public void setUacOcupado(int uacOcupado) {
		this.uacOcupado = uacOcupado;
	}
	/**
	 * @return the dependenciaEjerce
	 */
	public int getDependenciaEjerce() {
		return dependenciaEjerce;
	}
	/**
	 * @param dependenciaEjerce the dependenciaEjerce to set
	 */
	public void setDependenciaEjerce(int dependenciaEjerce) {
		this.dependenciaEjerce = dependenciaEjerce;
	}
	/**
	 * @return the codRegistro
	 */
	public int getCodRegistro() {
		return codRegistro;
	}
	/**
	 * @param codRegistro the codRegistro to set
	 */
	public void setCodRegistro(int codRegistro) {
		this.codRegistro = codRegistro;
	}
	/**
	 * @return the idCarnet
	 */
	public String getIdCarnet() {
		return idCarnet;
	}
	/**
	 * @param idCarnet the idCarnet to set
	 */
	public void setIdCarnet(String idCarnet) {
		this.idCarnet = idCarnet;
	}
	/**
	 * @return the sede
	 */
	public Sede getSede() {
		return sede;
	}
	/**
	 * @param sede the sede to set
	 */
	public void setSede(Sede sede) {
		this.sede = sede;
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
	 * @return the imagenContrato
	 */
	public String getImagenContrato() {
		return imagenContrato;
	}


	/**
	 * @param imagenContrato the imagenContrato to set
	 */
	public void setImagenContrato(String imagenContrato) {
		this.imagenContrato = imagenContrato;
	}


	/**
	 * @return the agenda
	 */
	public Agenda getAgenda() {
		return agenda;
	}


	/**
	 * @param agenda the agenda to set
	 */
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}


	/**
	 * @return the docentePuntos
	 */
	public DocentePuntos getDocentePuntos() {
		return docentePuntos;
	}


	/**
	 * @param docentePuntos the docentePuntos to set
	 */
	public void setDocentePuntos(DocentePuntos docentePuntos) {
		this.docentePuntos = docentePuntos;
	}



	/**
	 * @return the docenteEscalafon
	 */
	public DocenteEscalafon getDocenteEscalafon() {
		return docenteEscalafon;
	}


	/**
	 * @param docenteEscalafon the docenteEscalafon to set
	 */
	public void setDocenteEscalafon(DocenteEscalafon docenteEscalafon) {
		this.docenteEscalafon = docenteEscalafon;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UaaPersonal [codigo=" + codigo + ", uaa=" + uaa + ", persona=" + persona + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + ", cargo=" + cargo + ", vinculacion=" + vinculacion
				+ ", dedicacion=" + dedicacion + ", resolucion=" + resolucion + ", estado=" + estado + ", escalafon="
				+ escalafon + ", escValor=" + escValor + ", sippaPuntos=" + sippaPuntos + ", sippaPoccedula="
				+ sippaPoccedula + ", sippaVincodigo=" + sippaVincodigo + ", sippaCalcodigo=" + sippaCalcodigo
				+ ", sippaDedcodigo=" + sippaDedcodigo + ", codigoAnterior=" + codigoAnterior + ", uaaCargo=" + uaaCargo
				+ ", plantaEncargo=" + plantaEncargo + ", uacOcupado=" + uacOcupado + ", dependenciaEjerce="
				+ dependenciaEjerce + ", codRegistro=" + codRegistro + ", idCarnet=" + idCarnet + ", sede=" + sede
				+ ", observacion=" + observacion + ", imagenContrato=" + imagenContrato + ", agenda=" + agenda
				+ ", docentePuntos=" + docentePuntos + ", docenteEscalafon=" + docenteEscalafon + "]";
	}



	

	
}
