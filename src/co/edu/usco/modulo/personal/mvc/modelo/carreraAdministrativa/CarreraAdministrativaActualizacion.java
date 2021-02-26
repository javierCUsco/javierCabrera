/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa;

import java.io.Serializable;
import java.util.Date;

import co.edu.usco.modulo.personal.mvc.modelo.UaaCargo;


/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class CarreraAdministrativaActualizacion implements Serializable {

	private int codigo;// int IDENTITY(1,1) NOT NULL,
	private CarreraAdministrativa caa =new CarreraAdministrativa();// NULL,
	private TipoActualizacion tipoActualizacion=new TipoActualizacion();// int NULL,
	private String actoAdministrativo;// varchar(50) NULL,
	private Date fechaActoAdministrativo;// date NULL,
	private String observacion;
	private UaaCargo uaaCargo= new UaaCargo();// uac_codigo int NULL,
	
	
	
	/**
	 * 
	 */
	public CarreraAdministrativaActualizacion() {

	}



	/**
	 * @param codigo
	 * @param caa
	 * @param tipoActualizacion
	 * @param actoAdministrativo
	 * @param fechaActoAdministrativo
	 * @param observacion
	 * @param uaaCargo
	 */
	public CarreraAdministrativaActualizacion(int codigo, CarreraAdministrativa caa,
			TipoActualizacion tipoActualizacion, String actoAdministrativo, Date fechaActoAdministrativo,
			String observacion, UaaCargo uaaCargo) {
		this.codigo = codigo;
		this.caa = caa;
		this.tipoActualizacion = tipoActualizacion;
		this.actoAdministrativo = actoAdministrativo;
		this.fechaActoAdministrativo = fechaActoAdministrativo;
		this.observacion = observacion;
		this.uaaCargo = uaaCargo;
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
	public TipoActualizacion getTipoActualizacion() {
		return tipoActualizacion;
	}



	/**
	 * @param tipoActualizacion the tipoActualizacion to set
	 */
	public void setTipoActualizacion(TipoActualizacion tipoActualizacion) {
		this.tipoActualizacion = tipoActualizacion;
	}



	/**
	 * @return the actoAdministrativo
	 */
	public String getActoAdministrativo() {
		return actoAdministrativo;
	}



	/**
	 * @param actoAdministrativo the actoAdministrativo to set
	 */
	public void setActoAdministrativo(String actoAdministrativo) {
		this.actoAdministrativo = actoAdministrativo;
	}



	/**
	 * @return the fechaActoAdministrativo
	 */
	public Date getFechaActoAdministrativo() {
		return fechaActoAdministrativo;
	}



	/**
	 * @param fechaActoAdministrativo the fechaActoAdministrativo to set
	 */
	public void setFechaActoAdministrativo(Date fechaActoAdministrativo) {
		this.fechaActoAdministrativo = fechaActoAdministrativo;
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



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CarreraAdministrativaActualizacion [codigo=" + codigo + ", caa=" + caa + ", tipoActualizacion="
				+ tipoActualizacion + ", actoAdministrativo=" + actoAdministrativo + ", fechaActoAdministrativo="
				+ fechaActoAdministrativo + ", observacion=" + observacion + ", uaaCargo=" + uaaCargo + "]";
	}


	

	
}
