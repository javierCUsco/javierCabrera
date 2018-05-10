/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.TipoProceso;
import co.edu.usco.modulo.personal.mvc.modelo.UaaCargo;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class CarreraAdministrativa implements Serializable {

	private int caa_codigo;//int] IDENTITY(1,1) NOT NULL,
	private Persona persona= new Persona();//int] NULL,
	private TipoProceso tipoPorceso= new TipoProceso();//int] NULL,
	private String caa_acto_adtivo;//varchar](50) NULL,
	private Date caa_fecha_acto_adtivo;//date] NULL,
	private UaaCargo uaa_cargo= new UaaCargo();//int] NULL,
	private String caa_numero_convocatoria;//varchar](25) NULL,
	private Date caa_fecha_convocatoria;//date] NULL,
	private String caa_resolucion_elegibles;//varchar](50) NULL,
	private Date caa_fecha_resolucion_elegibles;//date] NULL,
	private String caa_numero_acta_posesion;//varchar](25) NULL,
	private Date caa_fecha_acta_posesion;//date] NULL,
	private int caa_estado;//int] NULL,
	private String caa_observacion;
	private List<CarreraAdministrativaActualizacion> CarreraAdministrativaActualizaciones ;
	/**
	 * 
	 */
	public CarreraAdministrativa() {
	}
	/**
	 * @param persona
	 * @param tipoPorceso
	 * @param caa_acto_adtivo
	 * @param caa_fecha_acto_adtivo
	 * @param uaa_cargo
	 * @param caa_numero_convocatoria
	 * @param caa_fecha_convocatoria
	 * @param caa_resolucion_elegibles
	 * @param caa_fecha_resolucion_elegibles
	 * @param caa_numero_acta_posesion
	 * @param caa_fecha_acta_posesion
	 * @param caa_estado
	 * @param caa_observacion
	 * @param carreraAdministrativaActualizaciones
	 */
	public CarreraAdministrativa(Persona persona, TipoProceso tipoPorceso, String caa_acto_adtivo,
			Date caa_fecha_acto_adtivo, UaaCargo uaa_cargo, String caa_numero_convocatoria, Date caa_fecha_convocatoria,
			String caa_resolucion_elegibles, Date caa_fecha_resolucion_elegibles, String caa_numero_acta_posesion,
			Date caa_fecha_acta_posesion, int caa_estado, String caa_observacion,
			List<CarreraAdministrativaActualizacion> carreraAdministrativaActualizaciones) {
		this.persona = persona;
		this.tipoPorceso = tipoPorceso;
		this.caa_acto_adtivo = caa_acto_adtivo;
		this.caa_fecha_acto_adtivo = caa_fecha_acto_adtivo;
		this.uaa_cargo = uaa_cargo;
		this.caa_numero_convocatoria = caa_numero_convocatoria;
		this.caa_fecha_convocatoria = caa_fecha_convocatoria;
		this.caa_resolucion_elegibles = caa_resolucion_elegibles;
		this.caa_fecha_resolucion_elegibles = caa_fecha_resolucion_elegibles;
		this.caa_numero_acta_posesion = caa_numero_acta_posesion;
		this.caa_fecha_acta_posesion = caa_fecha_acta_posesion;
		this.caa_estado = caa_estado;
		this.caa_observacion = caa_observacion;
		CarreraAdministrativaActualizaciones = carreraAdministrativaActualizaciones;
	}
	/**
	 * @param caa_codigo
	 * @param persona
	 * @param tipoPorceso
	 * @param caa_acto_adtivo
	 * @param caa_fecha_acto_adtivo
	 * @param uaa_cargo
	 * @param caa_numero_convocatoria
	 * @param caa_fecha_convocatoria
	 * @param caa_resolucion_elegibles
	 * @param caa_fecha_resolucion_elegibles
	 * @param caa_numero_acta_posesion
	 * @param caa_fecha_acta_posesion
	 * @param caa_estado
	 * @param caa_observacion
	 * @param carreraAdministrativaActualizaciones
	 */
	public CarreraAdministrativa(int caa_codigo, Persona persona, TipoProceso tipoPorceso, String caa_acto_adtivo,
			Date caa_fecha_acto_adtivo, UaaCargo uaa_cargo, String caa_numero_convocatoria, Date caa_fecha_convocatoria,
			String caa_resolucion_elegibles, Date caa_fecha_resolucion_elegibles, String caa_numero_acta_posesion,
			Date caa_fecha_acta_posesion, int caa_estado, String caa_observacion,
			List<CarreraAdministrativaActualizacion> carreraAdministrativaActualizaciones) {
		this.caa_codigo = caa_codigo;
		this.persona = persona;
		this.tipoPorceso = tipoPorceso;
		this.caa_acto_adtivo = caa_acto_adtivo;
		this.caa_fecha_acto_adtivo = caa_fecha_acto_adtivo;
		this.uaa_cargo = uaa_cargo;
		this.caa_numero_convocatoria = caa_numero_convocatoria;
		this.caa_fecha_convocatoria = caa_fecha_convocatoria;
		this.caa_resolucion_elegibles = caa_resolucion_elegibles;
		this.caa_fecha_resolucion_elegibles = caa_fecha_resolucion_elegibles;
		this.caa_numero_acta_posesion = caa_numero_acta_posesion;
		this.caa_fecha_acta_posesion = caa_fecha_acta_posesion;
		this.caa_estado = caa_estado;
		this.caa_observacion = caa_observacion;
		CarreraAdministrativaActualizaciones = carreraAdministrativaActualizaciones;
	}
	/**
	 * @return the caa_codigo
	 */
	public int getCaa_codigo() {
		return caa_codigo;
	}
	/**
	 * @param caa_codigo the caa_codigo to set
	 */
	public void setCaa_codigo(int caa_codigo) {
		this.caa_codigo = caa_codigo;
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
	public TipoProceso getTipoPorceso() {
		return tipoPorceso;
	}
	/**
	 * @param tipoPorceso the tipoPorceso to set
	 */
	public void setTipoPorceso(TipoProceso tipoPorceso) {
		this.tipoPorceso = tipoPorceso;
	}
	/**
	 * @return the caa_acto_adtivo
	 */
	public String getCaa_acto_adtivo() {
		return caa_acto_adtivo;
	}
	/**
	 * @param caa_acto_adtivo the caa_acto_adtivo to set
	 */
	public void setCaa_acto_adtivo(String caa_acto_adtivo) {
		this.caa_acto_adtivo = caa_acto_adtivo;
	}
	/**
	 * @return the caa_fecha_acto_adtivo
	 */
	public Date getCaa_fecha_acto_adtivo() {
		return caa_fecha_acto_adtivo;
	}
	/**
	 * @param caa_fecha_acto_adtivo the caa_fecha_acto_adtivo to set
	 */
	public void setCaa_fecha_acto_adtivo(Date caa_fecha_acto_adtivo) {
		this.caa_fecha_acto_adtivo = caa_fecha_acto_adtivo;
	}
	/**
	 * @return the uaa_cargo
	 */
	public UaaCargo getUaa_cargo() {
		return uaa_cargo;
	}
	/**
	 * @param uaa_cargo the uaa_cargo to set
	 */
	public void setUaa_cargo(UaaCargo uaa_cargo) {
		this.uaa_cargo = uaa_cargo;
	}
	/**
	 * @return the caa_numero_convocatoria
	 */
	public String getCaa_numero_convocatoria() {
		return caa_numero_convocatoria;
	}
	/**
	 * @param caa_numero_convocatoria the caa_numero_convocatoria to set
	 */
	public void setCaa_numero_convocatoria(String caa_numero_convocatoria) {
		this.caa_numero_convocatoria = caa_numero_convocatoria;
	}
	/**
	 * @return the caa_fecha_convocatoria
	 */
	public Date getCaa_fecha_convocatoria() {
		return caa_fecha_convocatoria;
	}
	/**
	 * @param caa_fecha_convocatoria the caa_fecha_convocatoria to set
	 */
	public void setCaa_fecha_convocatoria(Date caa_fecha_convocatoria) {
		this.caa_fecha_convocatoria = caa_fecha_convocatoria;
	}
	/**
	 * @return the caa_resolucion_elegibles
	 */
	public String getCaa_resolucion_elegibles() {
		return caa_resolucion_elegibles;
	}
	/**
	 * @param caa_resolucion_elegibles the caa_resolucion_elegibles to set
	 */
	public void setCaa_resolucion_elegibles(String caa_resolucion_elegibles) {
		this.caa_resolucion_elegibles = caa_resolucion_elegibles;
	}
	/**
	 * @return the caa_fecha_resolucion_elegibles
	 */
	public Date getCaa_fecha_resolucion_elegibles() {
		return caa_fecha_resolucion_elegibles;
	}
	/**
	 * @param caa_fecha_resolucion_elegibles the caa_fecha_resolucion_elegibles to set
	 */
	public void setCaa_fecha_resolucion_elegibles(Date caa_fecha_resolucion_elegibles) {
		this.caa_fecha_resolucion_elegibles = caa_fecha_resolucion_elegibles;
	}
	/**
	 * @return the caa_numero_acta_posesion
	 */
	public String getCaa_numero_acta_posesion() {
		return caa_numero_acta_posesion;
	}
	/**
	 * @param caa_numero_acta_posesion the caa_numero_acta_posesion to set
	 */
	public void setCaa_numero_acta_posesion(String caa_numero_acta_posesion) {
		this.caa_numero_acta_posesion = caa_numero_acta_posesion;
	}
	/**
	 * @return the caa_fecha_acta_posesion
	 */
	public Date getCaa_fecha_acta_posesion() {
		return caa_fecha_acta_posesion;
	}
	/**
	 * @param caa_fecha_acta_posesion the caa_fecha_acta_posesion to set
	 */
	public void setCaa_fecha_acta_posesion(Date caa_fecha_acta_posesion) {
		this.caa_fecha_acta_posesion = caa_fecha_acta_posesion;
	}
	/**
	 * @return the caa_estado
	 */
	public int getCaa_estado() {
		return caa_estado;
	}
	/**
	 * @param caa_estado the caa_estado to set
	 */
	public void setCaa_estado(int caa_estado) {
		this.caa_estado = caa_estado;
	}
	/**
	 * @return the caa_observacion
	 */
	public String getCaa_observacion() {
		return caa_observacion;
	}
	/**
	 * @param caa_observacion the caa_observacion to set
	 */
	public void setCaa_observacion(String caa_observacion) {
		this.caa_observacion = caa_observacion;
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
		return "CarreraAdministrativa [caa_codigo=" + caa_codigo + ", persona=" + persona + ", tipoPorceso="
				+ tipoPorceso + ", caa_acto_adtivo=" + caa_acto_adtivo + ", caa_fecha_acto_adtivo="
				+ caa_fecha_acto_adtivo + ", uaa_cargo=" + uaa_cargo + ", caa_numero_convocatoria="
				+ caa_numero_convocatoria + ", caa_fecha_convocatoria=" + caa_fecha_convocatoria
				+ ", caa_resolucion_elegibles=" + caa_resolucion_elegibles + ", caa_fecha_resolucion_elegibles="
				+ caa_fecha_resolucion_elegibles + ", caa_numero_acta_posesion=" + caa_numero_acta_posesion
				+ ", caa_fecha_acta_posesion=" + caa_fecha_acta_posesion + ", caa_estado=" + caa_estado
				+ ", caa_observacion=" + caa_observacion + ", CarreraAdministrativaActualizaciones="
				+ CarreraAdministrativaActualizaciones + "]";
	}
	
	
	
		

	
	
}
