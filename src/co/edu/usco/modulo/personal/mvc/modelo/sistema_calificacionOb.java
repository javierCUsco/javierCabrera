/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author Ingeniero Javier cabrera
 *
 */
public class sistema_calificacionOb implements Serializable {
	private int cal_codigo;//int] IDENTITY(1,1) NOT NULL,
	private int cal_sistema;//int] NULL,
	private sistemaOb sistema= new sistemaOb();
	private int cal_puntaje;//varchar](5) NULL,
	private String cal_observacion;//varchar](max) NULL,
	private String cal_fecha;//date] NULL,
	private int cal_usuario;//int] NULL,
	private String cal_estado;//varchar](1) NULL,
	public int getCal_codigo() {
		return cal_codigo;
	}
	public void setCal_codigo(int cal_codigo) {
		this.cal_codigo = cal_codigo;
	}
	public int getCal_sistema() {
		return cal_sistema;
	}
	public void setCal_sistema(int cal_sistema) {
		this.cal_sistema = cal_sistema;
	}
	public sistemaOb getSistema() {
		return sistema;
	}
	public void setSistema(sistemaOb sistema) {
		this.sistema = sistema;
	}
	
	public int getCal_puntaje() {
		return cal_puntaje;
	}
	public void setCal_puntaje(int cal_puntaje) {
		this.cal_puntaje = cal_puntaje;
	}
	public String getCal_observacion() {
		return cal_observacion;
	}
	public void setCal_observacion(String cal_observacion) {
		this.cal_observacion = cal_observacion;
	}
	public String getCal_fecha() {
		return cal_fecha;
	}
	public void setCal_fecha(String cal_fecha) {
		this.cal_fecha = cal_fecha;
	}
	public int getCal_usuario() {
		return cal_usuario;
	}
	public void setCal_usuario(int cal_usuario) {
		this.cal_usuario = cal_usuario;
	}
	public String getCal_estado() {
		return cal_estado;
	}
	public void setCal_estado(String cal_estado) {
		this.cal_estado = cal_estado;
	}
	
	
	
	

}
