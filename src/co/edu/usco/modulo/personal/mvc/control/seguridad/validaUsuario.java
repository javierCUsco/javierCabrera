/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.seguridad;

import javax.servlet.http.HttpServletRequest;

import co.edu.usco.modulo.personal.mvc.control.logica.novedadDocente.ParametroNovedadDocenteLog;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;

/**
 * @author Ing. Javier cabrera Lasso
 * @version 2.0
 */
public class validaUsuario {
/**
 * @param request
 * @return {@link Mensaje}
 */
public static Object getEs_usuario(HttpServletRequest request ){
	String msm="No es usuario Autorizado";
	boolean es= false;
	if ( request.isUserInRole("CARRERA_ADTIVA_ADMIN") || request.isUserInRole("CARRERA_ADTIVA_USER") || request.isUserInRole("USUARIO_SIPPA_PERSONAL") || request.isUserInRole("ADMON_PROGRAMACION_ACADEMICA") || request.isUserInRole("SECRETARIA") || request.isUserInRole("PERSONAL_ADMON")){   
//	es= true;
//	}
//	if ( request.isUserInRole("PENSIONADO_ADMIN") || request.isUserInRole("PENSIONADO_USER")){   
		es= true;
		}
	Mensaje mensaje=new Mensaje(es, msm, null,null);
	return mensaje;
}
/**
 * @param request
 * @return
 */
public static Object getEstadoModulo(HttpServletRequest request ){
	String msm="No es usuario Autorizado";
	boolean es= false;
	Mensaje mensaje=new Mensaje(es, msm, null,null);
	if ( request.isUserInRole("SECRETARIA")){  
		
		mensaje= (Mensaje) ParametroNovedadDocenteLog.getEstadoModulo(null);
		
	}
	if ( request.isUserInRole("ADMON_PROGRAMACION_ACADEMICA")){  

		mensaje.setValido(true);
		mensaje.setMsm("");
		
	}
	
	return mensaje;
}
}
