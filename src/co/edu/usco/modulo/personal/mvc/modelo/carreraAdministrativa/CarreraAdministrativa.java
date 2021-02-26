/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.UaaCargo;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class CarreraAdministrativa implements Serializable {

	private int codigo;//int] IDENTITY(1,1) NOT NULL,
	private Persona persona= new Persona();//int] NULL,
	private TipoProceso tipoProceso= new TipoProceso();//int] NULL,
	private String actoAdtivo;//varchar](50) NULL,
	private Date fechaActoAdtivo;//date] NULL,
	private UaaCargo uaaCargo= new UaaCargo();//int] NULL,
	private String numeroConvocatoria;//varchar](25) NULL,
	private Date fechaConvocatoria;//date] NULL,
	private String resolucionElegibles;//varchar](50) NULL,
	private Date fechaResolucionElegibles;//date] NULL,
	private String numeroActaPosesion;//varchar](25) NULL,
	private Date fechaActaPosesion;//date] NULL,
	private int estado;//int] NULL,
	private String observacion;
	private List<CarreraAdministrativaActualizacion> CarreraAdministrativaActualizaciones ;
	/**
	 * 
	 */
	public CarreraAdministrativa() {
	}
	
	
	
	/**
	 * @param codigo
	 * @param persona
	 * @param tipoPorceso
	 * @param actoAdtivo
	 * @param fechaActoAdtivo
	 * @param uaaCargo
	 * @param numeroConvocatoria
	 * @param fechaConvocatoria
	 * @param resolucionElegibles
	 * @param fechaResolucionElegibles
	 * @param numeroActaPosesion
	 * @param fechaActaPosesion
	 * @param estado
	 * @param observacion
	 * @param carreraAdministrativaActualizaciones
	 */
	public CarreraAdministrativa(int codigo, Persona persona, TipoProceso tipoPorceso, String actoAdtivo,
			Date fechaActoAdtivo, UaaCargo uaaCargo, String numeroConvocatoria, Date fechaConvocatoria,
			String resolucionElegibles, Date fechaResolucionElegibles, String numeroActaPosesion,
			Date fechaActaPosesion, int estado, String observacion,
			List<CarreraAdministrativaActualizacion> carreraAdministrativaActualizaciones) {
		this.codigo = codigo;
		this.persona = persona;
		this.tipoProceso = tipoPorceso;
		this.actoAdtivo = actoAdtivo;
		this.fechaActoAdtivo = fechaActoAdtivo;
		this.uaaCargo = uaaCargo;
		this.numeroConvocatoria = numeroConvocatoria;
		this.fechaConvocatoria = fechaConvocatoria;
		this.resolucionElegibles = resolucionElegibles;
		this.fechaResolucionElegibles = fechaResolucionElegibles;
		this.numeroActaPosesion = numeroActaPosesion;
		this.fechaActaPosesion = fechaActaPosesion;
		this.estado = estado;
		this.observacion = observacion;
		CarreraAdministrativaActualizaciones = carreraAdministrativaActualizaciones;
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
	 * @return the tipoPorceso
	 */
	public TipoProceso getTipoProceso() {
		return tipoProceso;
	}
	/**
	 * @param tipoPorceso the tipoPorceso to set
	 */
	public void setTipoProceso(TipoProceso tipoProceso) {
		this.tipoProceso = tipoProceso;
	}
	/**
	 * @return the actoAdtivo
	 */
	public String getActoAdtivo() {
		return actoAdtivo;
	}
	/**
	 * @param actoAdtivo the actoAdtivo to set
	 */
	public void setActoAdtivo(String actoAdtivo) {
		this.actoAdtivo = actoAdtivo;
	}
	/**
	 * @return the fechaActoAdtivo
	 */
	public Date getFechaActoAdtivo() {
		return fechaActoAdtivo;
	}
	/**
	 * @param fechaActoAdtivo the fechaActoAdtivo to set
	 */
	public void setFechaActoAdtivo(Date fechaActoAdtivo) {
		this.fechaActoAdtivo = fechaActoAdtivo;
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
	 * @return the numeroConvocatoria
	 */
	public String getNumeroConvocatoria() {
		return numeroConvocatoria;
	}
	/**
	 * @param numeroConvocatoria the numeroConvocatoria to set
	 */
	public void setNumeroConvocatoria(String numeroConvocatoria) {
		this.numeroConvocatoria = numeroConvocatoria;
	}
	/**
	 * @return the fechaConvocatoria
	 */
	public Date getFechaConvocatoria() {
		return fechaConvocatoria;
	}
	/**
	 * @param fechaConvocatoria the fechaConvocatoria to set
	 */
	public void setFechaConvocatoria(Date fechaConvocatoria) {
		this.fechaConvocatoria = fechaConvocatoria;
	}
	/**
	 * @return the resolucionElegibles
	 */
	public String getResolucionElegibles() {
		return resolucionElegibles;
	}
	/**
	 * @param resolucionElegibles the resolucionElegibles to set
	 */
	public void setResolucionElegibles(String resolucionElegibles) {
		this.resolucionElegibles = resolucionElegibles;
	}
	/**
	 * @return the fechaResolucionElegibles
	 */
	public Date getFechaResolucionElegibles() {
		return fechaResolucionElegibles;
	}
	/**
	 * @param fechaResolucionElegibles the fechaResolucionElegibles to set
	 */
	public void setFechaResolucionElegibles(Date fechaResolucionElegibles) {
		this.fechaResolucionElegibles = fechaResolucionElegibles;
	}
	/**
	 * @return the numeroActaPosesion
	 */
	public String getNumeroActaPosesion() {
		return numeroActaPosesion;
	}
	/**
	 * @param numeroActaPosesion the numeroActaPosesion to set
	 */
	public void setNumeroActaPosesion(String numeroActaPosesion) {
		this.numeroActaPosesion = numeroActaPosesion;
	}
	/**
	 * @return the fechaActaPosesion
	 */
	public Date getFechaActaPosesion() {
		return fechaActaPosesion;
	}
	/**
	 * @param fechaActaPosesion the fechaActaPosesion to set
	 */
	public void setFechaActaPosesion(Date fechaActaPosesion) {
		this.fechaActaPosesion = fechaActaPosesion;
	}
	/**
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(int estado) {
		this.estado = estado;
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
	 * @return the carreraAdministrativaActualizaciones
	 */
	public List<CarreraAdministrativaActualizacion> getCarreraAdministrativaActualizaciones() {
		return CarreraAdministrativaActualizaciones;
	}
	/**
	 * @param carreraAdministrativaActualizaciones the carreraAdministrativaActualizaciones to set
	 */
	public void setCarreraAdministrativaActualizaciones(
			List<CarreraAdministrativaActualizacion> carreraAdministrativaActualizaciones) {
		CarreraAdministrativaActualizaciones = carreraAdministrativaActualizaciones;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CarreraAdministrativa [codigo=" + codigo + ", persona=" + persona + ", tipoPorceso=" + tipoProceso
				+ ", actoAdtivo=" + actoAdtivo + ", fechaActoAdtivo=" + fechaActoAdtivo + ", uaaCargo=" + uaaCargo
				+ ", numeroConvocatoria=" + numeroConvocatoria + ", fechaConvocatoria=" + fechaConvocatoria
				+ ", resolucionElegibles=" + resolucionElegibles + ", fechaResolucionElegibles="
				+ fechaResolucionElegibles + ", numeroActaPosesion=" + numeroActaPosesion + ", fechaActaPosesion="
				+ fechaActaPosesion + ", estado=" + estado + ", observacion=" + observacion
				+ ", CarreraAdministrativaActualizaciones=" + CarreraAdministrativaActualizaciones + "]";
	}
	
	
}
