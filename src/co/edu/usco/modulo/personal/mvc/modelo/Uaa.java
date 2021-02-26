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

	private int  codigo;//int] IDENTITY(1,1) NOT NULL,
	private   UaaTipo uaaTipo= new UaaTipo();//int] NOT NULL,
	private String nombre;//varchar](200) NOT NULL,
	private  int dependencia;//int] NULL,
	private String nombreCorto;//varchar](100) NULL,
	private String uaa_nombre_impresion;//varchar](20) NULL,
	private  String email;//varchar](50) NULL,
	private  String emailPqr;//varchar](50) NULL,
	private  String uaa_pagina;//varchar](50) NULL,
	private  String uaa_jefe;//varchar](50) NULL,
	private  Municipio municipio = new Municipio();//int] NULL,
	private  String uaa_telefono;//varchar](50) NULL,
	private  String uaa_fax;//varchar](50) NULL,
	private  String uaa_direccion;//varchar](50) NULL,
//	private  sippa_uaa_codigo;//int] NULL,
	private Sede sede= new Sede();
	private  String centroCostos;//char](3) NULL,
//	private  uaa_acronimo;//char](2) NULL,
	private  int estado;//int] NULL,
	
	
	
	/**
 * 
 */
public Uaa() {
}


	/**
	 * @param codigo
	 */
	public Uaa(int codigo) {
		this.codigo = codigo;
	}


	/**
	 * @param sede 
	 * @param nombreCorto 
	 * @param nombre 
	 * @param codigo 
	 * 
	 */
	public Uaa(int codigo, String nombre, String nombreCorto, Sede sede) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.nombreCorto=nombreCorto;
		this.sede=sede;
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
	 * @return the uaaTipo
	 */
	public UaaTipo getUaaTipo() {
		return uaaTipo;
	}

	/**
	 * @param uaaTipo the uaaTipo to set
	 */
	public void setUaaTipo(UaaTipo uaaTipo) {
		this.uaaTipo = uaaTipo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the dependencia
	 */
	public int getDependencia() {
		return dependencia;
	}

	/**
	 * @param dependencia the dependencia to set
	 */
	public void setDependencia(int dependencia) {
		this.dependencia = dependencia;
	}

	/**
	 * @return the nombreCorto
	 */
	public String getNombreCorto() {
		return nombreCorto;
	}

	/**
	 * @param nombreCorto the nombreCorto to set
	 */
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the emailPqr
	 */
	public String getEmailPqr() {
		return emailPqr;
	}

	/**
	 * @param emailPqr the emailPqr to set
	 */
	public void setEmailPqr(String emailPqr) {
		this.emailPqr = emailPqr;
	}

	/**
	 * @return the municipio
	 */
	public Municipio getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	/**
	 * @return the sede
	 */
	public Sede getSede() {
		return sede;
	}

	/**
	 * @param sede the sede to set
	 */
	public void setSede(Sede sede) {
		this.sede = sede;
	}

	/**
	 * @return the centroCostos
	 */
	public String getCentroCostos() {
		return centroCostos;
	}

	/**
	 * @param centroCostos the centroCostos to set
	 */
	public void setCentroCostos(String centroCostos) {
		this.centroCostos = centroCostos;
	}

	/**
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Uaa [codigo=" + codigo + ", uaaTipo=" + uaaTipo + ", nombre=" + nombre + ", dependencia=" + dependencia
				+ ", nombreCorto=" + nombreCorto + ", email=" + email + ", emailPqr=" + emailPqr + ", municipio="
				+ municipio + ", sede=" + sede + ", centroCostos=" + centroCostos + ", estado=" + estado + "]";
	}

	
	
	
}
