/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa;

import java.io.Serializable;

import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.Tipo_comisionOb;
import co.edu.usco.modulo.personal.mvc.modelo.UaaCargo;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Comision implements Serializable {
	
	private int com_codigo;//int] IDENTITY(1,1) NOT NULL,
	private Persona persona;//int] NULL,
	private Tipo_comisionOb tipoContrato;//int] NULL,
	private String com_acto_adtivo;//varchar](50) NULL,
	private String com_fecha_inicio_acto_adtivo;//date] NULL,
	private String com_fecha_fin_acto_adtivo;//date] NULL,
	private UaaCargo uaaCargo;//int] NULL,
	
	
	
	/**
	 * @return the com_codigo
	 */
	public int getCom_codigo() {
		return com_codigo;
	}
	/**
	 * @param com_codigo the com_codigo to set
	 */
	public void setCom_codigo(int com_codigo) {
		this.com_codigo = com_codigo;
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
	 * @return the tipoContrato
	 */
	public Tipo_comisionOb getTipoContrato() {
		return tipoContrato;
	}
	/**
	 * @param tipoContrato the tipoContrato to set
	 */
	public void setTipoContrato(Tipo_comisionOb tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	/**
	 * @return the com_acto_adtivo
	 */
	public String getCom_acto_adtivo() {
		return com_acto_adtivo;
	}
	/**
	 * @param com_acto_adtivo the com_acto_adtivo to set
	 */
	public void setCom_acto_adtivo(String com_acto_adtivo) {
		this.com_acto_adtivo = com_acto_adtivo;
	}
	/**
	 * @return the com_fecha_inicio_acto_adtivo
	 */
	public String getCom_fecha_inicio_acto_adtivo() {
		return com_fecha_inicio_acto_adtivo;
	}
	/**
	 * @param com_fecha_inicio_acto_adtivo the com_fecha_inicio_acto_adtivo to set
	 */
	public void setCom_fecha_inicio_acto_adtivo(String com_fecha_inicio_acto_adtivo) {
		this.com_fecha_inicio_acto_adtivo = com_fecha_inicio_acto_adtivo;
	}
	/**
	 * @return the com_fecha_fin_acto_adtivo
	 */
	public String getCom_fecha_fin_acto_adtivo() {
		return com_fecha_fin_acto_adtivo;
	}
	/**
	 * @param com_fecha_fin_acto_adtivo the com_fecha_fin_acto_adtivo to set
	 */
	public void setCom_fecha_fin_acto_adtivo(String com_fecha_fin_acto_adtivo) {
		this.com_fecha_fin_acto_adtivo = com_fecha_fin_acto_adtivo;
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
	
	
	
}
