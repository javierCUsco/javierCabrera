/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import java.util.List;

import co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa.CarreraAdministrativaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa.CarreraAdministrativaAtualizacionLog;
import co.edu.usco.modulo.personal.mvc.modelo.PersonaHistoriaAcademica;
import co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa.CarreraAdministrativa;
import co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa.CarreraAdministrativaActualizacion;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class ReporteLog {

	public static Object getObject(Object[] param) {
		
		CarreraAdministrativa carreraAdministrativa=(CarreraAdministrativa) param[0];
		carreraAdministrativa= (CarreraAdministrativa) CarreraAdministrativaLog.getObject(param);
		
		CarreraAdministrativaActualizacion carreraAdministrativaActualizacion = new CarreraAdministrativaActualizacion();
		carreraAdministrativaActualizacion.getCaa().getPersona().setCodigo(carreraAdministrativa.getPersona().getCodigo());
		carreraAdministrativaActualizacion.getCaa().setCodigo(carreraAdministrativa.getCodigo());

		 param[0] =  carreraAdministrativaActualizacion;
		 
		 carreraAdministrativa.setCarreraAdministrativaActualizaciones((List<CarreraAdministrativaActualizacion>)CarreraAdministrativaAtualizacionLog.getLista(param));
//		 PersonaHistoriaAcademica pha= new PersonaHistoriaAcademica();
//		 pha.setPersona(carreraAdministrativa.getPersona());
//		 param[0] =  pha;
		// carreraAdministrativa.getPersona().setHistoriaAcademica((List<PersonaHistoriaAcademica>) PersonaHistoriaAcademicaLog.getLista(param));
		return carreraAdministrativa;
	}
	
}
