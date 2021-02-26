/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.herramientas;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ING_JAVIER
 * @version 001
 * @see
 * @serial
 */
public class https {

	/**
	 * <h1>esseguro: </h1> metodo que sirve para validar que se esta utilizando el protocolo de seguridad, un certificado
	 * @param request
	 * @return
	 */
	public static boolean esseguro(HttpServletRequest request) {
		if(request.isSecure()){
			return true;
		}
		return false;
	}

}
