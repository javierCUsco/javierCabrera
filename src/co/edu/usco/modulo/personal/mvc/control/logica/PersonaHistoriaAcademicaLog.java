/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.junit.experimental.theories.Theories;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.PersonaHistoriaAcademicaDB;
import co.edu.usco.modulo.personal.mvc.control.herramientas.EnviaCorreo;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.PersonaHistoriaAcademica;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PersonaHistoriaAcademicaLog   extends HttpServlet{
	static ConexionDB db = null;
	static String inforrmacion="";
	/**
	 * @param obj
	 * @return {@link Object}
	 */
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		ConexionDB db=new PersonaHistoriaAcademicaDB();
		Mensaje mensaje= new Mensaje();
		mensaje.setResultado(db.getAll(obj));
		return mensaje;
	}

	/**
	 * @param obj
	 * @return
	 */
	public static Object getElemento(Object obj) {
		ConexionDB db=new PersonaHistoriaAcademicaDB();
		Mensaje mensaje= new Mensaje();
		mensaje.setResultado( db.getObject(obj));
		return mensaje;
	}

	/**
	 * @param request
	 * @param obj
	 * @return {@link Mensaje}
	 */
	public static Object newObject(  Object obj) {
		db = new PersonaHistoriaAcademicaDB();
		//System.out.println("en historia academica");
		
		Object param[] = (Object[]) obj;
		Mensaje mensaje =new Mensaje();
		if (param[2].toString().equals("3")) {
			Persona persona = (Persona) param[0];
			boolean correo=setcorreo(persona,param[1]);
			if(correo) {
			mensaje= new Mensaje();
			mensaje.setMsm("Se envio un mesaje a el usuaro.");
			mensaje.setResultado(persona);
			mensaje.setValido(true);
			}else {
				mensaje= new Mensaje();
				mensaje.setMsm("No Se envio un mesaje a el usuario.");
				mensaje.setResultado(persona);
				mensaje.setValido(false);
			}
		}
		else {
			 mensaje = (Mensaje) getvalidaDatos( obj);
		if (mensaje.isValido()) {
			if (param[2].toString().equals("1")) {
//				 param[] = (Object[]) obj;
				Persona persona = (Persona) mensaje.getResultado();
//				PersonaHistoriaAcademica personaHistoriaAcademica2 = new PersonaHistoriaAcademica();
//				personaHistoriaAcademica2.setTitulo(personaHistoriaAcademica.getTitulo());
//				param[0] = personaHistoriaAcademica2;
//				mensaje.setValido(db.esObject(obj));
//				if (mensaje.isValido()) {
					param[0] = persona;
					param[2] = 0;
					int resultado = (int) db.setObject(param);
					if (resultado >= 1) {
						//enviaCorreo.setEmail(personaHistoriaAcademica.getPersona().getEmailInterno());
						mensaje.setValido(true);
						mensaje.setMsm("se ha guardado el registro..");
						persona.getHistoriaAcademica().setObservacion("Se ha realizado una inserción en la historia académica, de nivel académico "+persona.getHistoriaAcademica().getNivelAcademico().getNombre()+", titulo obtenido "+persona.getHistoriaAcademica().getTitulo()
					    +"<br>"+persona.getHistoriaAcademica().getObservacion());     
//						enviaCorreo.setAccion("realizado una inserción en la historia académica, de nivel académico "+personaHistoriaAcademica.getNivelAcademico().getNombre()+", titulo obtenido "+personaHistoriaAcademica.getTitulo()
//						+"<br>"+personaHistoriaAcademica.getObservacion());
//						enviaCorreo.setInformacion(inforrmacion);
//						enviaCorreo.setUsuario(personaHistoriaAcademica.getPersona().getApellido()+" "+personaHistoriaAcademica.getPersona().getApellido2()+" "+personaHistoriaAcademica.getPersona().getNombre()+" "+personaHistoriaAcademica.getPersona().getNombre2()+", documento de identificación "+personaHistoriaAcademica.getPersona().getIdentificacion());
//						enviaCorreo.setText("");
//						enviaCorreo.enviarCorreo("");
						boolean correo=setcorreo( persona,param[1]);
					} else {
						mensaje.setValido(false);
						mensaje.setMsm("Error no se ha guardado el registro..");
					}
				
			}
			if (param[2].toString().equals("2")) {

//				db = new PersonaHistoriaAcademicaDB();

//				 param[] = (Object[]) obj;
				Persona persona = (Persona) mensaje.getResultado();
//				PersonaHistoriaAcademica personaHistoriaAcademica2 = new PersonaHistoriaAcademica();
//				personaHistoriaAcademica2.setCodigo(personaHistoriaAcademica.getCodigo());
//				param[0] = personaHistoriaAcademica2;
//
//				mensaje.setValido(db.esObject(obj));
//				if (!mensaje.isValido()) {
					param[0] = persona;
					param[2] = 1;
					int resultado = (int) db.setObject(param);
					if (resultado == 1) {
//						enviaCorreo.setEmail(personaHistoriaAcademica.getPersona().getEmailInterno());
						mensaje.setValido(true);
						mensaje.setMsm("se ha guardado el registro..");
//						enviaCorreo.setAccion("realizado una actualización de la historia académica, de nivel académico "+personaHistoriaAcademica.getNivelAcademico().getNombre()+", titulo optenido "+personaHistoriaAcademica.getTitulo());
//						enviaCorreo.setInformacion(inforrmacion);
//						enviaCorreo.setUsuario(personaHistoriaAcademica.getPersona().getApellido()+" "+personaHistoriaAcademica.getPersona().getApellido2()+" "+personaHistoriaAcademica.getPersona().getNombre()+" "+personaHistoriaAcademica.getPersona().getNombre2()+", documento de identificación "+personaHistoriaAcademica.getPersona().getIdentificacion()
//								+"<br>"+personaHistoriaAcademica.getObservacion());
//						enviaCorreo.setText("");
//						enviaCorreo.enviarCorreo("");
						persona.getHistoriaAcademica().setObservacion("Se ha realizado la actualización de la historia académica, de nivel académico "+persona.getHistoriaAcademica().getNivelAcademico().getNombre()+", titulo optenido "+persona.getHistoriaAcademica().getTitulo()+" "+persona.getHistoriaAcademica().getObservacion());
						boolean correo=setcorreo( persona,param[1]);
					} else {
						mensaje.setValido(false);
						mensaje.setMsm("Error no se ha guardado el registro..");
					}
				
			}
		}
		}
		return mensaje;
		
	}
private static boolean setcorreo( Persona persona, Object param) {
	EnviaCorreo enviaCorreo= new EnviaCorreo();
	if(param==null) {
		enviaCorreo.setEmail("talentohumano@usco.edu.co");
//		enviaCorreo.setEmail("javier.cabrera@usco.edu.co");
	}else {
		enviaCorreo.setEmail(persona.getEmailInterno());
	}
	enviaCorreo.setAccion(""+persona.getHistoriaAcademica().getObservacion());
	enviaCorreo.setInformacion(inforrmacion);
	enviaCorreo.setUsuario(persona.getApellido()+" "+persona.getApellido2()+" "+persona.getNombre()+" "+persona.getNombre2()+", documento de identificación "+persona.getIdentificacion());
	enviaCorreo.setText("");
	return enviaCorreo.enviarCorreo("");
		
	}

/**
 * 
 */
	private static Object getvalidaDatos( Object obj) {

		Mensaje mensaje = new Mensaje();
		mensaje.setValido(true);
		Mensaje mensaje2 = null;
		Object param[] = (Object[]) obj;
		String fechaServidor = String.valueOf(FechaLog.getFechaServidor());
		Persona persona=(Persona) param[0];
	System.out.println("validando");
		if(persona==null) {
			mensaje.setMsm(", debe seleccionar una persona");
			mensaje.setValido(false);
		}
		if(persona.getHistoriaAcademica().getModalidad()==null) {
			mensaje.setMsm(mensaje.getMsm()+", debe seleccionar la modalidad de estudio");
			mensaje.setValido(false);
		}
		if(persona.getHistoriaAcademica().getNivelAcademico()==null) {
			mensaje.setMsm(mensaje.getMsm()+", debe seleccionar El nivel academico");
			mensaje.setValido(false);
		}
		if(persona.getHistoriaAcademica().getInstitucionEducativa()==null) {
			mensaje.setMsm(mensaje.getMsm()+", debe seleccionar la institucion educativa en la que realizo los estudios");
			mensaje.setValido(false);
		}
		if(persona.getHistoriaAcademica().getInstitucionEducativa()!=null) {
			if(persona.getHistoriaAcademica().getInstitucionEducativa().getCodigo()==8809) {
				inforrmacion="En la base de datos no se encuentra la institución educariva  "+persona.getHistoriaAcademica().getOtraInstitucionEducativa()+" donde realizo los estudios por favor solicite su creación en el centro de tecnología y actualice le la información del usuario<br>";
			}if(persona.getHistoriaAcademica().getInstitucionEducativa().getCodigo()==8809 && (persona.getHistoriaAcademica().getOtraInstitucionEducativa()==null || persona.getHistoriaAcademica().getOtraInstitucionEducativa().length()<=3)) {
				mensaje.setMsm(mensaje.getMsm()+", el campo otra institucion educativa es obligatorio");
				mensaje.setValido(false);
			}
		}
		if(persona.getHistoriaAcademica().getTitulo()==null) {
			mensaje.setMsm(mensaje.getMsm()+", debe digitar el titulo optenido");
			mensaje.setValido(false);
		}
		
		if (persona.getHistoriaAcademica().getFechaInicio() != null) {

			mensaje2 = Fecha.getValidaFechas(Fecha.getDate(fechaServidor), persona.getHistoriaAcademica().getFechaInicio(),
					"error en la fecha de inicio no puede ser superio a la fecha actual");
			if (!mensaje2.isValido()) {
				mensaje.setMsm(mensaje.getMsm()+", error en la fecha de inicio"+mensaje2.getMsm());
				mensaje.setValido(false);
			}
			System.out.println("---->"+persona);
			mensaje2=Fecha.getValidaFechas_edad(persona.getHistoriaAcademica().getFechaInicio(), persona.getFechaNacimiento(), " edad no valida para realizar estudios superiores");
			if (!mensaje2.isValido()) {
				mensaje.setMsm(mensaje.getMsm()+", error en la fecha de inicio "+mensaje2.getMsm());
				mensaje.setValido(false);
			}
		} else {
			mensaje.setMsm(mensaje.getMsm()+", Debe digitar la fecha de inicio");
			mensaje.setValido(false);
		}
		
		if (persona.getHistoriaAcademica().getFechaFin() != null) {

			mensaje2 = Fecha.getValidaFechas(Fecha.getDate(fechaServidor), persona.getHistoriaAcademica().getFechaFin(),
					"error en la fecha de fin no puede ser superio a la fecha actual");
			if (mensaje2.isValido()) {
				mensaje2 = Fecha.getValidaFechas(persona.getHistoriaAcademica().getFechaInicio(), persona.getHistoriaAcademica().getFechaFin(),
						"error en la fecha de fin no puede ser superior a la fecha de inicio");
			}else {
				mensaje.setMsm(mensaje.getMsm()+", error en la fecha de fin"+mensaje2.getMsm());
				mensaje.setValido(false);
			}
		} else {
			mensaje.setMsm(mensaje.getMsm()+", Debe digitar la fecha de inicio");
			mensaje.setValido(false);
		}
		
		
		if (persona.getHistoriaAcademica().getFechaTitulo() != null) {

			mensaje2 = Fecha.getValidaFechas(Fecha.getDate(fechaServidor), persona.getHistoriaAcademica().getFechaTitulo(),
					"error en la fecha de fin no puede ser superio a la fecha actual");
			if (mensaje2.isValido()) {
				mensaje2 = Fecha.getValidaFechas(persona.getHistoriaAcademica().getFechaInicio(), persona.getHistoriaAcademica().getFechaTitulo(),
						"error en la fecha de Titulo no puede ser superior a la fecha de inicio");
			}else {
				mensaje.setMsm(mensaje.getMsm()+", error en la fecha de Titulo"+mensaje2.getMsm());
				mensaje.setValido(false);
			}
		} else {
			mensaje.setMsm(mensaje.getMsm()+", Debe digitar la fecha de Titulo");
			mensaje.setValido(false);
		}
		if(persona.getHistoriaAcademica().getMunicipio()!=null) {
			if(persona.getHistoriaAcademica().getMunicipio().getCodigo()==1124 || persona.getHistoriaAcademica().getMunicipio().getCodigo()==1121 ) {
				inforrmacion=inforrmacion+" En la base de datos no se encuentra la ciudad   "+persona.getHistoriaAcademica().getOtroMunicipio()+"  donde resealizo los estudios por favor solicite su creacion en el centro de tecnologia y actualicelo en la informacion del usuario <br>";
			}
			if(persona.getHistoriaAcademica().getMunicipio().getCodigo()==1124 || persona.getHistoriaAcademica().getMunicipio().getCodigo()==1121 &&(persona.getHistoriaAcademica().getOtroMunicipio()==null || persona.getHistoriaAcademica().getOtroMunicipio().length()<=3)) {
				mensaje.setMsm(mensaje.getMsm()+", el campo otro lugar de estudio es obligatorio");
				mensaje.setValido(false);
			}
			if(persona.getHistoriaAcademica().getMunicipio().getDepartamento().getPais().getCodigo()!=21 && !persona.getHistoriaAcademica().isConvalidado()) {
				if(persona.getHistoriaAcademica().getMunicipio().getDepartamento().getPais().getCodigo()!=21 && !persona.getHistoriaAcademica().isConvalidado() && persona.getHistoriaAcademica().getDocumento()==null) {
					mensaje.setMsm(mensaje.getMsm()+", debe digitar el numero de la convalidacion");
					mensaje.setValido(false);
				}
			}
		}else {
			mensaje.setMsm(mensaje.getMsm()+", debe seleccionar la ciudad en la que realizo los estudios");
			mensaje.setValido(false);
		}
		if(persona.getHistoriaAcademica().getDocumentosgd().getDocumentoTipo()==null) {
			mensaje.setMsm(mensaje.getMsm()+", el debe seleccionar el tipo de documento");
			mensaje.setValido(false);
		}
			
		
	
		mensaje.setResultado(persona);
	System.out.println(mensaje);
		return mensaje;
		
	}
	
	
	
//	public static Date DeStringADate(String fecha){
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        String strFecha = fecha;
//        Date fechaDate =  new Date(Long.parseLong(fecha));
//		            System.out.println(fechaDate.toString());
//		return fechaDate;
//    }
	
}
