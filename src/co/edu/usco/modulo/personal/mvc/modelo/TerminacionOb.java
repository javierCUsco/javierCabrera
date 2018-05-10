/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

import co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa.CarreraAdministrativa;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class TerminacionOb implements Serializable {
	
	private int caat_codigo;//int] IDENTITY(1,1) NOT NULL,
	private CarreraAdministrativa carreraAdministrativa;//int] NULL,
	private TipoTerminacion tipoTerminacion;//int] NULL,
	private String caat_acto_administrativo;//varchar](50) NULL,
	private String caat_fecha_acto_administrativo;//date] NULL,
	private int tin_codigo;//int] NULL,
	
	
	/**
	 * @return the caat_codigo
	 */
	public int getCaat_codigo() {
		return caat_codigo;
	}
	/**
	 * @param caat_codigo the caat_codigo to set
	 */
	public void setCaat_codigo(int caat_codigo) {
		this.caat_codigo = caat_codigo;
	}
	/**
	 * @return the carreraAdministrativa
	 */
	public CarreraAdministrativa getCarreraAdministrativa() {
		return carreraAdministrativa;
	}
	/**
	 * @param carreraAdministrativa the carreraAdministrativa to set
	 */
	public void setCarreraAdministrativa(CarreraAdministrativa carreraAdministrativa) {
		this.carreraAdministrativa = carreraAdministrativa;
	}
	/**
	 * @return the tipoTerminacion
	 */
	public TipoTerminacion getTipoTerminacion() {
		return tipoTerminacion;
	}
	/**
	 * @param tipoTerminacion the tipoTerminacion to set
	 */
	public void setTipoTerminacion(TipoTerminacion tipoTerminacion) {
		this.tipoTerminacion = tipoTerminacion;
	}
	/**
	 * @return the caat_acto_administrativo
	 */
	public String getCaat_acto_administrativo() {
		return caat_acto_administrativo;
	}
	/**
	 * @param caat_acto_administrativo the caat_acto_administrativo to set
	 */
	public void setCaat_acto_administrativo(String caat_acto_administrativo) {
		this.caat_acto_administrativo = caat_acto_administrativo;
	}
	/**
	 * @return the caat_fecha_acto_administrativo
	 */
	public String getCaat_fecha_acto_administrativo() {
		return caat_fecha_acto_administrativo;
	}
	/**
	 * @param caat_fecha_acto_administrativo the caat_fecha_acto_administrativo to set
	 */
	public void setCaat_fecha_acto_administrativo(String caat_fecha_acto_administrativo) {
		this.caat_fecha_acto_administrativo = caat_fecha_acto_administrativo;
	}
	/**
	 * @return the tin_codigo
	 */
	public int getTin_codigo() {
		return tin_codigo;
	}
	/**
	 * @param tin_codigo the tin_codigo to set
	 */
	public void setTin_codigo(int tin_codigo) {
		this.tin_codigo = tin_codigo;
	}
	
	
	
	
}
