/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author ING_JAVIER
 *
 */
@SuppressWarnings("serial")
public class Uaa implements Serializable{

	private int  uaa_codigo;//int] IDENTITY(1,1) NOT NULL,
//	private  uat_codigo;//int] NOT NULL,
	private String uaa_nombre;//varchar](200) NOT NULL,
//	private  uaa_dependencia;//int] NULL,
	private String uaa_nombre_corto;//varchar](100) NULL,
//	private  uaa_nombre_impresion;//varchar](20) NULL,
//	private  uaa_email;//varchar](50) NULL,
//	private  uaa_email_pqr;//varchar](50) NULL,
//	private  uaa_pagina;//varchar](50) NULL,
//	private  uaa_jefe;//varchar](50) NULL,
//	private  mun_codigo;//int] NULL,
//	private  uaa_telefono;//varchar](50) NULL,
//	private  uaa_fax;//varchar](50) NULL,
//	private  uaa_direccion;//varchar](50) NULL,
//	private  sippa_uaa_codigo;//int] NULL,
	private int sed_codigo;//int] NULL,
	private sedeOb sede= new sedeOb();
//	private  uaa_centro_costos;//char](3) NULL,
//	private  uaa_acronimo;//char](2) NULL,
//	private  uaa_estado;//int] NULL,
	
	/**
	 * 
	 */
	public Uaa() {
		// TODO Auto-generated constructor stub
	}

	
	public Uaa(int uaa_codigo, String uaa_nombre, String uaa_nombre_corto,  sedeOb sede) {

	this.uaa_codigo = uaa_codigo;
	this.uaa_nombre = uaa_nombre;
	this.uaa_nombre_corto = uaa_nombre_corto;
	this.sede = sede;
}


	/**
	 * @return the uaa_codigo
	 */
	public int getUaa_codigo() {
		return uaa_codigo;
	}

	/**
	 * @param uaa_codigo the uaa_codigo to set
	 */
	public void setUaa_codigo(int uaa_codigo) {
		this.uaa_codigo = uaa_codigo;
	}

	/**
	 * @return the uaa_nombre
	 */
	public String getUaa_nombre() {
		return uaa_nombre;
	}

	/**
	 * @param uaa_nombre the uaa_nombre to set
	 */
	public void setUaa_nombre(String uaa_nombre) {
		this.uaa_nombre = uaa_nombre;
	}

	/**
	 * @return the uaa_nombre_corto
	 */
	public String getUaa_nombre_corto() {
		return uaa_nombre_corto;
	}

	/**
	 * @param uaa_nombre_corto the uaa_nombre_corto to set
	 */
	public void setUaa_nombre_corto(String uaa_nombre_corto) {
		this.uaa_nombre_corto = uaa_nombre_corto;
	}

	/**
	 * @return the sed_codigo
	 */
	public int getSed_codigo() {
		return sed_codigo;
	}

	/**
	 * @param sed_codigo the sed_codigo to set
	 */
	public void setSed_codigo(int sed_codigo) {
		this.sed_codigo = sed_codigo;
	}

	/**
	 * @return the sede
	 */
	public sedeOb getSede() {
		return sede;
	}

	/**
	 * @param sede the sede to set
	 */
	public void setSede(sedeOb sede) {
		this.sede = sede;
	}

	
	
}
