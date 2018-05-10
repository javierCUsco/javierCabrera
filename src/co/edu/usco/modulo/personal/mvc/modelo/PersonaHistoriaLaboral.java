/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;
import java.util.Date;

import co.edu.usco.modulo.personal.mvc.control.logica.Historia_laboral_tipoLog;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PersonaHistoriaLaboral implements Serializable {
	private int phl_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private Persona persona = new Persona();//int] NULL,
	private Date phl_fecha_inicio;//datetime] NULL,
	private Date phl_fecha_fin;//datetime] NULL,
	private String phl_empresa;//varchar](200) NULL,
	private String phl_empresa_direccion;//nchar](10) NULL,
	private String phl_empresa_telefono;//nchar](10) NULL,
	private MunicipioOb municipio= new MunicipioOb();//int] NULL,
	private String ocupacion_cargo;//char](10) NULL,
	private Historia_laboral_tipoOb tipo= new Historia_laboral_tipoOb();//int] NOT NULL,
	private Dedicacion dedicacion= new Dedicacion();//int] NOT NULL,
	private Vinculacion vinculacion= new Vinculacion();//int] NOT NULL,
	private String phl_cargo;//nvarchar](100) NULL,
	private String phl_descripcion;//nvarchar](250) NULL,
	private String phl_puntos;//float] NULL,
	private String phl_puntos_fecha;//datetime] NULL,
	private Archivo archivo = new Archivo();
	/**
	 * @return the phl_codigo
	 */
	public int getPhl_codigo() {
		return phl_codigo;
	}
	/**
	 * @param phl_codigo the phl_codigo to set
	 */
	public void setPhl_codigo(int phl_codigo) {
		this.phl_codigo = phl_codigo;
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
	 * @return the phl_fecha_inicio
	 */
	public Date getPhl_fecha_inicio() {
		return phl_fecha_inicio;
	}
	/**
	 * @param phl_fecha_inicio the phl_fecha_inicio to set
	 */
	public void setPhl_fecha_inicio(Date phl_fecha_inicio) {
		this.phl_fecha_inicio = phl_fecha_inicio;
	}
	/**
	 * @return the phl_fecha_fin
	 */
	public Date getPhl_fecha_fin() {
		return phl_fecha_fin;
	}
	/**
	 * @param phl_fecha_fin the phl_fecha_fin to set
	 */
	public void setPhl_fecha_fin(Date phl_fecha_fin) {
		this.phl_fecha_fin = phl_fecha_fin;
	}
	/**
	 * @return the phl_empresa
	 */
	public String getPhl_empresa() {
		return phl_empresa;
	}
	/**
	 * @param phl_empresa the phl_empresa to set
	 */
	public void setPhl_empresa(String phl_empresa) {
		this.phl_empresa = phl_empresa;
	}
	/**
	 * @return the phl_empresa_direccion
	 */
	public String getPhl_empresa_direccion() {
		return phl_empresa_direccion;
	}
	/**
	 * @param phl_empresa_direccion the phl_empresa_direccion to set
	 */
	public void setPhl_empresa_direccion(String phl_empresa_direccion) {
		this.phl_empresa_direccion = phl_empresa_direccion;
	}
	/**
	 * @return the phl_empresa_telefono
	 */
	public String getPhl_empresa_telefono() {
		return phl_empresa_telefono;
	}
	/**
	 * @param phl_empresa_telefono the phl_empresa_telefono to set
	 */
	public void setPhl_empresa_telefono(String phl_empresa_telefono) {
		this.phl_empresa_telefono = phl_empresa_telefono;
	}
	
	/**
	 * @return the municipio
	 */
	public MunicipioOb getMunicipio() {
		return municipio;
	}
	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(MunicipioOb municipio) {
		this.municipio = municipio;
	}
	/**
	 * @return the ocupacion_cargo
	 */
	public String getOcupacion_cargo() {
		return ocupacion_cargo;
	}
	/**
	 * @param ocupacion_cargo the ocupacion_cargo to set
	 */
	public void setOcupacion_cargo(String ocupacion_cargo) {
		this.ocupacion_cargo = ocupacion_cargo;
	}
	
	/**
	 * @return the tipo
	 */
	public Historia_laboral_tipoOb getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Historia_laboral_tipoOb tipo) {
		this.tipo = tipo;
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
	 * @return the phl_cargo
	 */
	public String getPhl_cargo() {
		return phl_cargo;
	}
	/**
	 * @param phl_cargo the phl_cargo to set
	 */
	public void setPhl_cargo(String phl_cargo) {
		this.phl_cargo = phl_cargo;
	}
	/**
	 * @return the phl_descripcion
	 */
	public String getPhl_descripcion() {
		return phl_descripcion;
	}
	/**
	 * @param phl_descripcion the phl_descripcion to set
	 */
	public void setPhl_descripcion(String phl_descripcion) {
		this.phl_descripcion = phl_descripcion;
	}
	/**
	 * @return the phl_puntos
	 */
	public String getPhl_puntos() {
		return phl_puntos;
	}
	/**
	 * @param phl_puntos the phl_puntos to set
	 */
	public void setPhl_puntos(String phl_puntos) {
		this.phl_puntos = phl_puntos;
	}
	/**
	 * @return the phl_puntos_fecha
	 */
	public String getPhl_puntos_fecha() {
		return phl_puntos_fecha;
	}
	/**
	 * @param phl_puntos_fecha the phl_puntos_fecha to set
	 */
	public void setPhl_puntos_fecha(String phl_puntos_fecha) {
		this.phl_puntos_fecha = phl_puntos_fecha;
	}
	/**
	 * @return the archivo
	 */
	public Archivo getArchivo() {
		return archivo;
	}
	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}
	
	
	
}
