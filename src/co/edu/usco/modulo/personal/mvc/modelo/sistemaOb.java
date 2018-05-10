/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author Ingeniero Javier Cabrera
 *
 */
public class sistemaOb implements Serializable {
	private int sis_codigo;//int] IDENTITY(1,1) NOT NULL,
	private String sis_nombre;//varchar](max) NULL,
	private int sis_responsable_uid;//int] NULL,
	private String sis_estado;//varchar](1) NULL,
	
	public int getSis_codigo() {
		return sis_codigo;
	}
	public void setSis_codigo(int sis_codigo) {
		this.sis_codigo = sis_codigo;
	}
	public String getSis_nombre() {
		return sis_nombre;
	}
	public void setSis_nombre(String sis_nombre) {
		this.sis_nombre = sis_nombre;
	}
	public int getSis_responsable_uid() {
		return sis_responsable_uid;
	}
	public void setSis_responsable_uid(int sis_responsable_uid) {
		this.sis_responsable_uid = sis_responsable_uid;
	}
	public String getSis_estado() {
		return sis_estado;
	}
	public void setSis_estado(String sis_estado) {
		this.sis_estado = sis_estado;
	}
	
	
}
