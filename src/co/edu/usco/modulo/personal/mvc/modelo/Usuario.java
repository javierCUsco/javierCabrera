/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


import co.edu.usco.modulo.personal.mvc.control.herramientas.Transformacion;

/**
 * @author ING_JAVIER
 *
 */
public class Usuario extends Admin {

	
	private String nombre;
	private String clave;
	private boolean https=false;
	private Persona persona= new Persona();
	private String nombreencriptado;
	private String token;
	private String autorizacion;
	private boolean estado;
	
	
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
		Transformacion hex = new Transformacion();
		this.nombreencriptado = hex.transHexa(nombreencriptado, 1);
		
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
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}



	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}



	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}



	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}



	/**
	 * @return the autorizacion
	 */
	public String getAutorizacion() {
		return autorizacion;
	}



	/**
	 * @param autorizacion the autorizacion to set
	 */
	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", clave=" + clave + ", https=" + https + ", persona=" + persona
				+ ", nombreencriptado=" + nombreencriptado + ", token=" + token + ", autorizacion=" + autorizacion
				+ ", estado=" + estado + "]";
	}








	

}
