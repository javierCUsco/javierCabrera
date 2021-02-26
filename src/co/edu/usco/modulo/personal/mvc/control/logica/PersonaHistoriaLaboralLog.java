/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.PersonaHistoriaLaboralDB;
import co.edu.usco.modulo.personal.mvc.control.herramientas.EnviaCorreo;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.PersonaHistoriaAcademica;
import co.edu.usco.modulo.personal.mvc.modelo.PersonaHistoriaLaboral;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PersonaHistoriaLaboralLog {
	static ConexionDB db = null;
	static String inforrmacion="";
	/**
	 * @param obj
	 * @return
	 */
	public static Object getLista(Object obj) {
		db=new PersonaHistoriaLaboralDB();
		Mensaje mensaje= new Mensaje();
		mensaje.setResultado(db.getAll(obj));
		return mensaje;
	}

	/**
	 * @param obj
	 * @return
	 */
	public static Object getElemento(Object obj) {
	 db=new PersonaHistoriaLaboralDB();
	 Mensaje mensaje= new Mensaje();
	 mensaje.setResultado(db.getObject(obj));
		return mensaje;
	}

	/**
	 * @param request
	 * @param obj
	 * @return {@link Mensaje}
	 */
	public static Object newObject( Object obj) {
		System.out.println("llega ");
		db = new PersonaHistoriaLaboralDB();
		EnviaCorreo enviaCorreo= new EnviaCorreo();
		Object param[] = (Object[]) obj;
		
		System.out.println("llega 1");
		Mensaje mensaje =new Mensaje();
		if (param[2].toString().equals("3")) {
			Persona persona= (Persona) param[0];
			boolean correo=enviaCorreo.enviarCorreo("");
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
			//Object param[] = (Object[]) obj;
			if (String.valueOf(param[2]).equals("1")) {
				Persona persona = (Persona) mensaje.getResultado();

					param[0] = persona;
					param[2] = 0;
					int resultado = (int) db.setObject(param);
					if (resultado >= 1) {						
						mensaje.setValido(true);
						mensaje.setMsm("se ha guardado el registro..");
//						enviaCorreo.setAccion("realizado la inserción de una nueva experiencia labora externa de la hoja de vida con la empresa "+personaHistoriaLaboral.getEmpresa()+", cargo "+personaHistoriaLaboral.getCargo());
//						enviaCorreo.setInformacion(inforrmacion);
//						enviaCorreo.setUsuario(personaHistoriaLaboral.getPersona().getApellido()+" "+personaHistoriaLaboral.getPersona().getApellido2()+" "+personaHistoriaLaboral.getPersona().getNombre()+" "+personaHistoriaLaboral.getPersona().getNombre2()+", documento de identificación "+personaHistoriaLaboral.getPersona().getIdentificacion());
//						enviaCorreo.setText("");
//						enviaCorreo.enviarCorreo("");
						persona.getHistoriaLaboral().setObservacion("Se ha realizado la inserción de una nueva experiencia labora externa de la hoja de vida con la empresa "+persona.getHistoriaLaboral().getEmpresa()+", cargo "+persona.getHistoriaLaboral().getCargo()+" "+persona.getHistoriaLaboral().getObservacion());
						setcorreo(persona, param[1]);
					} else {
						mensaje.setValido(false);
						mensaje.setMsm("Error no se ha guardado el registro..");
					}
				
			}
			if (String.valueOf(param[2]).equals("2")) {
				System.out.println("llega updaye "+String.valueOf(param[2]));
				Persona persona = (Persona) mensaje.getResultado();

					param[0] = persona;
					param[2] = 1;
					int resultado = (int) db.setObject(param);
					if (resultado == 1) {
						mensaje.setValido(true);
//						if(param[1]==null) {
//							enviaCorreo.setEmail("talentohumano@usco.edu.co");
//						}else {
//							enviaCorreo.setEmail(personaHistoriaLaboral.getPersona().getEmailInterno());
//						}
						mensaje.setMsm("se ha guardado el registro..");
//						enviaCorreo.setAccion("realizado la actualizacionexperiencia labora de la hoja de vida con la empresa "+personaHistoriaLaboral.getEmpresa()+", cargo "+personaHistoriaLaboral.getCargo());
//						enviaCorreo.setInformacion(inforrmacion);
//						enviaCorreo.setUsuario(personaHistoriaLaboral.getPersona().getApellido()+" "+personaHistoriaLaboral.getPersona().getApellido2()+" "+personaHistoriaLaboral.getPersona().getNombre()+" "+personaHistoriaLaboral.getPersona().getNombre2()+", documento de identificación "+personaHistoriaLaboral.getPersona().getIdentificacion());
//						enviaCorreo.setText("");
//						enviaCorreo.enviarCorreo("");
						persona.getHistoriaLaboral().setObservacion("Se ha realizado la actualización experiencia laboral de la hoja de vida con la empresa "+persona.getHistoriaLaboral().getEmpresa()+", cargo "+persona.getHistoriaLaboral().getCargo()+" "+persona.getHistoriaLaboral().getObservacion());
						setcorreo(persona, param[1]);
					} else {
						mensaje.setValido(false);
						mensaje.setMsm("Error no se ha guardado el registro..");
					}
				
			}
		}
		}
		System.out.println(mensaje);
		return mensaje;
		
	}
	private static boolean setcorreo( Persona persona, Object param) {
		EnviaCorreo enviaCorreo= new EnviaCorreo();
		if(param==null) {
		enviaCorreo.setEmail("talentohumano@usco.edu.co");
//			enviaCorreo.setEmail("javier.cabrera@usco.edu.co");
		}else {
			enviaCorreo.setEmail(persona.getEmailInterno());
		}
		enviaCorreo.setAccion(" "+persona.getHistoriaLaboral().getObservacion());
		enviaCorreo.setInformacion(inforrmacion);
		enviaCorreo.setUsuario(persona.getApellido()+" "+persona.getApellido2()+" "+persona.getNombre()+" "+persona.getNombre2()+", documento de identificación "+persona.getIdentificacion());
		enviaCorreo.setText("");
		return enviaCorreo.enviarCorreo("");
			
		}
	private static Object getvalidaDatos( Object obj) {

		Mensaje mensaje = new Mensaje();
		mensaje.setValido(true);
		Mensaje mensaje2 = null;
		Object param[] = (Object[]) obj;
		String fechaServidor = String.valueOf(FechaLog.getFechaServidor());
		Persona persona=(Persona) param[0];
	
		if(persona==null) {
			mensaje.setMsm(", debe seleccionar una persona");
			mensaje.setValido(false);
		}
		if(persona.getHistoriaLaboral().getHistoriaLaboralTipo()==null) {
			mensaje.setMsm(mensaje.getMsm()+", debe seleccionar el tipo de historia laboral");
			mensaje.setValido(false);
		}
		if(persona.getHistoriaLaboral().getMunicipio()==null) {
			mensaje.setMsm(mensaje.getMsm()+", debe seleccionar el lugar en desempeño la atividad");
			mensaje.setValido(false);
		}
		
		if(persona.getHistoriaLaboral().getEmpresa()==null) {
			mensaje.setMsm(mensaje.getMsm()+", debe ingresar el nombre de la empresa donde laboro");
			mensaje.setValido(false);
		}else {
			StringTokenizer str= new StringTokenizer(persona.getHistoriaLaboral().getEmpresa());
			while (str.hasMoreElements()) {
				String token = (String) str.nextElement();
				if(token.compareToIgnoreCase("surcolombiana")==0) {
					mensaje.setMsm(mensaje.getMsm()+", no puede agregar empleos que haya tenido con la universidad surcolombiana, estos ya esta registrados en nuestra base de datos");
					mensaje.setValido(false);
				}
				
			}
			
		}
		if(persona.getHistoriaLaboral().getEmpresaDireccion()==null) {
			mensaje.setMsm(mensaje.getMsm()+", debe ingresar la direccion de la empresa en que laboro");
			mensaje.setValido(false);
		}
		if(persona.getHistoriaLaboral().getEmpresaTelefono()==null) {
			mensaje.setMsm(mensaje.getMsm()+", debe ingresar la telefono de la empresa en que laboro");
			mensaje.setValido(false);
		}
	
		if (persona.getHistoriaLaboral().getDescripcion() == null) {
			mensaje.setMsm(mensaje.getMsm()+", ingrese una brebe descrición de sus funciones");
			mensaje.setValido(false);
		}
		
		if (persona.getHistoriaLaboral().getFechaInicio() != null) {

			mensaje2 = Fecha.getValidaFechas(Fecha.getDate(fechaServidor), persona.getHistoriaLaboral().getFechaInicio(),
					"error en la fecha de inicio no puede ser superio a la fecha actual");
			if (!mensaje2.isValido()) {
				mensaje.setMsm(mensaje.getMsm()+", error en la fecha de inicio "+mensaje2.getMsm());
				mensaje.setValido(false);
			}
			mensaje2=Fecha.getValidaFechas_edad(persona.getHistoriaLaboral().getFechaInicio(), persona.getFechaNacimiento(), "edad no valida para realizar ninguntrabajo");
			if (!mensaje2.isValido()) {
				mensaje.setMsm(mensaje.getMsm()+", error en la fecha de inicio "+mensaje2.getMsm());
				mensaje.setValido(false);
			}
		} else {
			mensaje.setMsm(mensaje.getMsm()+", Debe digitar la fecha de inicio");
			mensaje.setValido(false);
		}
		
		if (persona.getHistoriaLaboral().getFechaFin() != null) {

			mensaje2 = Fecha.getValidaFechas(Fecha.getDate(fechaServidor), persona.getHistoriaLaboral().getFechaFin(),
					"error en la fecha de fin no puede ser superio a la fecha actual");
			if (mensaje2.isValido()) {
				mensaje2 = Fecha.getValidaFechas(persona.getHistoriaLaboral().getFechaFin(), persona.getHistoriaLaboral().getFechaInicio(),
						"error en la fecha de fin no puede ser superior a la fecha de inicio");
			}else {
				mensaje.setMsm(mensaje.getMsm()+", error en la fecha de fin "+mensaje2.getMsm());
				mensaje.setValido(false);
			}
		} else {
			mensaje.setMsm(mensaje.getMsm()+", Debe digitar la fecha de inicio");
			mensaje.setValido(false);
		}
		
		if (persona.getHistoriaLaboral().getVinculacion() == null) {
				mensaje.setMsm(mensaje.getMsm()+", error en la fecha de Titulo"+mensaje2.getMsm());
				mensaje.setValido(false);
		}
		if (persona.getHistoriaLaboral().getDedicacion() == null) {
			mensaje.setMsm(mensaje.getMsm()+", error en la fecha de Titulo"+mensaje2.getMsm());
			mensaje.setValido(false);
		}
		if(persona.getHistoriaLaboral().getDocumento()==null) {
			mensaje.setMsm(mensaje.getMsm()+", error debe seleccionar el tipo de documento"+mensaje2.getMsm());
			mensaje.setValido(false);
		}
		
		mensaje.setResultado(persona);
	System.out.println(mensaje);
		return mensaje;
		
	}

	
}
