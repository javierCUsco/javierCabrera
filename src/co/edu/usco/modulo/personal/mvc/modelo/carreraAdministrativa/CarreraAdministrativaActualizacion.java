/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa;

import java.io.Serializable;
import java.util.Date;

import co.edu.usco.modulo.personal.mvc.modelo.Tipo_actualizacionOb;
import co.edu.usco.modulo.personal.mvc.modelo.UaaCargo;


/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class CarreraAdministrativaActualizacion implements Serializable {

	private int caaa_codigo;// int IDENTITY(1,1) NOT NULL,
	private CarreraAdministrativa caa =new CarreraAdministrativa();// NULL,
	private Tipo_actualizacionOb tipoActualizacion= new Tipo_actualizacionOb();// int NULL,
	private String caaa_acto_administrativo;// varchar(50) NULL,
	private Date caaa_fecha_acto_administrativo;// date NULL,
	private String caaa_observacion;
	private UaaCargo uaa_cargo= new UaaCargo();// uac_codigo int NULL,
	
	
	
	public CarreraAdministrativaActualizacion() {

	}



	/**
	 * @param caa
	 * @param tipoActualizacion
	 * @param caaa_acto_administrativo
	 * @param caaa_fecha_acto_administrativo
	 * @param caaa_observacion
	 * @param uaa_cargo
	 */
	public CarreraAdministrativaActualizacion(CarreraAdministrativa caa, Tipo_actualizacionOb tipoActualizacion,
			String caaa_acto_administrativo, Date caaa_fecha_acto_administrativo, String caaa_observacion,
			UaaCargo uaa_cargo) {
		this.caa = caa;
		this.tipoActualizacion = tipoActualizacion;
		this.caaa_acto_administrativo = caaa_acto_administrativo;
		this.caaa_fecha_acto_administrativo = caaa_fecha_acto_administrativo;
		this.caaa_observacion = caaa_observacion;
		this.uaa_cargo = uaa_cargo;
	}



	/**
	 * @param caaa_codigo
	 * @param caa
	 * @param tipoActualizacion
	 * @param caaa_acto_administrativo
	 * @param caaa_fecha_acto_administrativo
	 * @param caaa_observacion
	 * @param uaa_cargo
	 */
	public CarreraAdministrativaActualizacion(int caaa_codigo, CarreraAdministrativa caa,
			Tipo_actualizacionOb tipoActualizacion, String caaa_acto_administrativo,
			Date caaa_fecha_acto_administrativo, String caaa_observacion, UaaCargo uaa_cargo) {
		this.caaa_codigo = caaa_codigo;
		this.caa = caa;
		this.tipoActualizacion = tipoActualizacion;
		this.caaa_acto_administrativo = caaa_acto_administrativo;
		this.caaa_fecha_acto_administrativo = caaa_fecha_acto_administrativo;
		this.caaa_observacion = caaa_observacion;
		this.uaa_cargo = uaa_cargo;
	}



	/**
	 * @return the caaa_codigo
	 */
	public int getCaaa_codigo() {
		return caaa_codigo;
	}



	/**
	 * @param caaa_codigo the caaa_codigo to set
	 */
	public void setCaaa_codigo(int caaa_codigo) {
		this.caaa_codigo = caaa_codigo;
	}



	/**
	 * @return the caa
	 */
	public CarreraAdministrativa getCaa() {
		return caa;
	}



	/**
	 * @param caa the caa to set
	 */
	public void setCaa(CarreraAdministrativa caa) {
		this.caa = caa;
	}



	/**
	 * @return the tipoActualizacion
	 */
	public Tipo_actualizacionOb getTipoActualizacion() {
		return tipoActualizacion;
	}



	/**
	 * @param tipoActualizacion the tipoActualizacion to set
	 */
	public void setTipoActualizacion(Tipo_actualizacionOb tipoActualizacion) {
		this.tipoActualizacion = tipoActualizacion;
	}



	/**
	 * @return the caaa_acto_administrativo
	 */
	public String getCaaa_acto_administrativo() {
		return caaa_acto_administrativo;
	}



	/**
	 * @param caaa_acto_administrativo the caaa_acto_administrativo to set
	 */
	public void setCaaa_acto_administrativo(String caaa_acto_administrativo) {
		this.caaa_acto_administrativo = caaa_acto_administrativo;
	}



	/**
	 * @return the caaa_fecha_acto_administrativo
	 */
	public Date getCaaa_fecha_acto_administrativo() {
		return caaa_fecha_acto_administrativo;
	}



	/**
	 * @param caaa_fecha_acto_administrativo the caaa_fecha_acto_administrativo to set
	 */
	public void setCaaa_fecha_acto_administrativo(Date caaa_fecha_acto_administrativo) {
		this.caaa_fecha_acto_administrativo = caaa_fecha_acto_administrativo;
	}



	/**
	 * @return the caaa_observacion
	 */
	public String getCaaa_observacion() {
		return caaa_observacion;
	}



	/**
	 * @param caaa_observacion the caaa_observacion to set
	 */
	public void setCaaa_observacion(String caaa_observacion) {
		this.caaa_observacion = caaa_observacion;
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



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CarreraAdministrativaActualizacion [caaa_codigo=" + caaa_codigo + ", caa=" + caa
				+ ", tipoActualizacion=" + tipoActualizacion + ", caaa_acto_administrativo=" + caaa_acto_administrativo
				+ ", caaa_fecha_acto_administrativo=" + caaa_fecha_acto_administrativo + ", caaa_observacion="
				+ caaa_observacion + ", uaa_cargo=" + uaa_cargo + "]";
	}
	
	
}
