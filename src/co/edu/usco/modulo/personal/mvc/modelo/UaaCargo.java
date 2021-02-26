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
	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private Uaa uaa= new Uaa();//int] NULL,
	private Cargo cargo = new Cargo();//int] NULL,
	private Vinculacion vinculacion= new Vinculacion();//int] NULL,
	private Dedicacion dedicacion= new Dedicacion();//int] NULL,
	private String codigoPlanta;//nvarchar](4) NULL,
	private int grado;//int] NULL,
	
	

	public UaaCargo() {
		
	}



	/**
	 * @param codigo
	 * @param uaa
	 * @param cargo
	 * @param vinculacion
	 * @param dedicacion
	 * @param codigoPlanta
	 * @param grado
	 */
	public UaaCargo(int codigo, Uaa uaa, Cargo cargo, Vinculacion vinculacion, Dedicacion dedicacion,
			String codigoPlanta, int grado) {
		this.codigo = codigo;
		this.uaa = uaa;
		this.cargo = cargo;
		this.vinculacion = vinculacion;
		this.dedicacion = dedicacion;
		this.codigoPlanta = codigoPlanta;
		this.grado = grado;
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
	 * @return the codigoPlanta
	 */
	public String getCodigoPlanta() {
		return codigoPlanta;
	}



	/**
	 * @param codigoPlanta the codigoPlanta to set
	 */
	public void setCodigoPlanta(String codigoPlanta) {
		this.codigoPlanta = codigoPlanta;
	}



	/**
	 * @return the grado
	 */
	public int getGrado() {
		return grado;
	}



	/**
	 * @param grado the grado to set
	 */
	public void setGrado(int grado) {
		this.grado = grado;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UaaCargo [codigo=" + codigo + ", uaa=" + uaa + ", cargo=" + cargo + ", vinculacion=" + vinculacion
				+ ", dedicacion=" + dedicacion + ", codigoPlanta=" + codigoPlanta + ", grado=" + grado + "]";
	}
	
	
	
	
	
}
