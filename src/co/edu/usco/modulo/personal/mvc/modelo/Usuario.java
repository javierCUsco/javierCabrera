/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

import co.edu.usco.modulo.personal.mvc.control.herramientas.Transformacion;

/**
 * @author ING_JAVIER
 *
 */
@SuppressWarnings("serial")
public class Usuario extends AdminOb implements Serializable{

	
	private String nombre;
	private String clave;
	private String cod_factura;
	private boolean https=false;
	private Persona persona= new Persona();
	private CalendarioOb calendario= new CalendarioOb(); 
	private String nombreencriptado;
	/**
	 * @return the nombreencriptado
	 */
	public String getNombreencriptado() {
		return nombreencriptado;
	}



	/**
	 * @param nombreencriptado the nombreencriptado to set
	 */
	public void setNombreencriptado(String nombreencriptado) {
		this.nombreencriptado = nombreencriptado;
	}
	//private liquidacionOb liquidacion= new liquidacionOb();
	//private facturaOb factura= new facturaOb();
	/**
	 * 
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	


	public void setNew_persona(){
		persona= new Persona();
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
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}
	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		Transformacion hex = new Transformacion();
		this.clave = hex.transHexa(clave, 1);
	}
	/**
	 * @return the cod_factura
	 */
	public String getCod_factura() {
		return cod_factura;
	}
	/**
	 * @param cod_factura the cod_factura to set
	 */
	public void setCod_factura(String cod_factura) {
		this.cod_factura = cod_factura;
	}
	/**
	 * @return the https
	 */
	public boolean isHttps() {
		return https;
	}
	/**
	 * @param https the https to set
	 */
	public void setHttps(boolean https) {
		this.https = https;
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
	 * @return the calendario
	 */
	public CalendarioOb getCalendario() {
		return calendario;
	}


	/**
	 * @param calendario the calendario to set
	 */
	public void setCalendario(CalendarioOb calendario) {
		this.calendario = calendario;
	}

}
