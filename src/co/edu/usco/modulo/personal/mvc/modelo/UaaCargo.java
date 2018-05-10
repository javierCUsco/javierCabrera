/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class UaaCargo implements Serializable {
	private int uac_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private Uaa uaa= new Uaa();//int] NULL,
	private Cargo cargo = new Cargo();//int] NULL,
	private Vinculacion vinculacion= new Vinculacion();//int] NULL,
	private Dedicacion dedicacion= new Dedicacion();//int] NULL,
	private String uac_codigoplanta;//nvarchar](4) NULL,
	private int uac_grado;//int] NULL,
	
	

	public UaaCargo() {
		
	}
	public UaaCargo( Uaa uaa, Cargo cargo, Vinculacion vinculacion, Dedicacion dedicacion,
			String uac_codigoplanta, int uac_grado) {
		this.uaa = uaa;
		this.cargo = cargo;
		this.vinculacion = vinculacion;
		this.dedicacion = dedicacion;
		this.uac_codigoplanta = uac_codigoplanta;
		this.uac_grado = uac_grado;
	}
	
	public UaaCargo(int uac_codigo, Uaa uaa, Cargo cargo, Vinculacion vinculacion, Dedicacion dedicacion,
			String uac_codigoplanta, int uac_grado) {
		this.uac_codigo = uac_codigo;
		this.uaa = uaa;
		this.cargo = cargo;
		this.vinculacion = vinculacion;
		this.dedicacion = dedicacion;
		this.uac_codigoplanta = uac_codigoplanta;
		this.uac_grado = uac_grado;
	}
	/**
	 * @return the uac_codigo
	 */
	public int getUac_codigo() {
		return uac_codigo;
	}
	/**
	 * @param uac_codigo the uac_codigo to set
	 */
	public void setUac_codigo(int uac_codigo) {
		this.uac_codigo = uac_codigo;
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
	 * @return the uac_codigoplanta
	 */
	public String getUac_codigoplanta() {
		return uac_codigoplanta;
	}
	/**
	 * @param uac_codigoplanta the uac_codigoplanta to set
	 */
	public void setUac_codigoplanta(String uac_codigoplanta) {
		this.uac_codigoplanta = uac_codigoplanta;
	}
	/**
	 * @return the uac_grado
	 */
	public int getUac_grado() {
		return uac_grado;
	}
	/**
	 * @param uac_grado the uac_grado to set
	 */
	public void setUac_grado(int uac_grado) {
		this.uac_grado = uac_grado;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UaaCargo [uac_codigo=" + uac_codigo + ", uaa=" + uaa + ", cargo=" + cargo + ", vinculacion="
				+ vinculacion + ", dedicacion=" + dedicacion + ", uac_codigoplanta=" + uac_codigoplanta + ", uac_grado="
				+ uac_grado + "]";
	}
	
	
}
