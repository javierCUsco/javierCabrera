/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.seguridad;

import javax.servlet.http.HttpServletRequest;

import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;

/**
 * @author Ing. Javier cabrera Lasso
 * @version 2.0
 */
public class validaUsuario {
public static Object getEs_usuario(HttpServletRequest request ){
	String msm="No es usuario Autorizado";
	boolean es= false;
	if ( request.isUserInRole("CARRERA_ADTIVA_ADMIN") || request.isUserInRole("CARRERA_ADTIVA_USER") || request.isUserInRole("USUARIO_SIPPA_PERSONAL")){   
	es= true;
	}
	Mensaje mensaje=new Mensaje(es, msm, null);
	return mensaje;
}
}
