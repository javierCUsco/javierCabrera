/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.PersonaDB;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.carreraAdministrativa.CarreraAdministrativaDB;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.carreraAdministrativa.PersonaCarreraAdministrativaDB;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa.CarreraAdministrativa;
import co.edu.usco.modulo.personal.mvc.modelo.pensionado.Pensionado;
import co.edu.usco.seguridad.seguridad;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PersonaLog {
	static ConexionDB db = null;

	/**
	 * metodo que permite recibir el objeto enviado {@link Persona} que se va a
	 * insertar a la base de datos o que se le va a realizar una actualizacio, este
	 * modo llama el metodo validarDatos
	 * 
	 * @param request
	 * @param obj
	 *            parametro de tipo {@link Object} que comtiene la informacion
	 * @return {@link Mensaje}
	 */
	public static Object newObject( Object obj) { 
	Mensaje mensaje = (Mensaje) getvalidaDatos( obj);
	Object param[] = (Object[]) obj;
	
	if (mensaje.isValido()) {
		if (param[2].toString().equals("1")) {

			db = new PersonaDB();
			
			Persona persona = (Persona) mensaje.getResultado();
			Persona personatem = new Persona();
			personatem.setIdentificacion(persona.getIdentificacion());
			param[0] = personatem;
			mensaje.setValido(db.esObject(obj));
			if (mensaje.isValido()) {
				param[0] = persona;
				param[2] = 0;
				int resultado = (int) db.setObject(param);
				if (resultado == 1) {
					mensaje.setValido(true);
					mensaje.setMsm("se ha guardado el registro..");
				} else {
					mensaje.setValido(false);
					mensaje.setMsm("Error no se ha guardado el registro..");
				}
			} else {

			}
		}
		if (param[2].toString().equals("2")) {
			db = new PersonaDB();
			System.out.println("en up data ");
			//Object param[] = (Object[]) obj;
			Persona persona = (Persona) mensaje.getResultado();
			Persona personatem = new Persona();
			personatem.setCodigo(persona.getCodigo());
			personatem.setIdentificacion(persona.getIdentificacion());
			param[0] = personatem;
			//System.out.println("en up data "+(Usuario)param[1] );
			mensaje.setValido(db.esObject(obj));
			if (!mensaje.isValido()) {
				param[0] = persona;
				param[2] = 1;
				int resultado = (int) db.setObject(param);
				if (resultado == 1) {
					mensaje.setValido(true);
					mensaje.setMsm("se ha actualizado el registro..");
				} else {
					mensaje.setValido(false);
					mensaje.setMsm("Error no se ha actualizado el registro..");
				}
			} else {

			}
		}
	}

	return mensaje;
	}

	/**
	 * 
	 * @param request
	 * @param obj
	 * @return
	 */
	private static Object getvalidaDatos( Object obj) {

		Mensaje mensaje = new Mensaje();
		mensaje.setValido(true);
		Mensaje mensaje2 = null;
		Object param[] = (Object[]) obj;
		Persona persona = (Persona) param[0];
		String fechaServidor = String.valueOf(FechaLog.getFechaServidor());
		if (persona.getTipoId() == null) {
			mensaje.setMsm(", Debe seleccionar el tipo de identificacion");
			mensaje.setValido(false);
		}
		if (persona.getIdentificacion() == null || persona.getIdentificacion().equals(" ")) {
			mensaje.setMsm(", Debe digitar el numero de identificacion");
			mensaje.setValido(false);
		}
		if (persona.getIdentificacion().length() < 7) {
			mensaje.setMsm(", El numero de identificacion no puede ser menor de 7 digitos");
			mensaje.setValido(false);
		}
		if (persona.getGenero() == null) {
			mensaje.setMsm(", El campo genero es obligatorio");
			mensaje.setValido(false);
		}
		if (persona.getGenero() != null) {
			if (persona.getGenero().getCodigo() == "M"
					&& (persona.getLibretaMilitar() == null || persona.getLibretaMilitar().trim().length()<=0)) {
				mensaje.setMsm(", la libreta militar es obligatoria");
				mensaje.setValido(false);
			}
		}
		if (persona.getLugarExpedicion() == null) {
			mensaje.setMsm(", Debe seleccionar el Lugar de expedicion del documento de identificacion");
			mensaje.setValido(false);
		}
		if (persona.getFechaExpedicion() != null) {
			mensaje2 = Fecha.getValidaFechas(Fecha.getDate(fechaServidor), persona.getFechaExpedicion(),"fecha de expedicion");
			if (!mensaje2.isValido()) {
				mensaje.setMsm(", error en la fecha de expedicion del documento de identificacion");
				mensaje.setValido(false);
			}
		} else {
			mensaje.setMsm(", Debe digitar la fecha de expedicion del documento de identificacion ");
			mensaje.setValido(false);
		}

		if (persona.getGrupoSanguineo() == null) {
			mensaje.setMsm(", Debe seleccionar el grupo sanguineo");
			mensaje.setValido(false);
		}
		if (persona.getEstrato() == null) {
			mensaje.setMsm(", Debe seleccionar el estraro ");
			mensaje.setValido(false);
		}
		if (persona.getGenero() == null) {
			mensaje.setMsm(", Debe seleccionar el genero ");
			mensaje.setValido(false);
		}
		if (persona.getEstadoCivil() == null) {
			mensaje.setMsm(", Debe seleccionar el Lugar de expedicion del documento de identificacion ");
			mensaje.setValido(false);
		}

		if (persona.getLugarNacimiento() == null) {
			mensaje.setMsm(", Debe seleccionar el Lugar de expedicion del documento de identificacion ");
			mensaje.setValido(false);
		}
		if (persona.getFechaNacimiento() != null) {

			mensaje2 = Fecha.getValidaFechas(Fecha.getDate(fechaServidor), persona.getFechaNacimiento(),
					"error en la fecha de nacimiento");
			if (!mensaje2.isValido()) {
				mensaje.setMsm(", error en la fecha de nacimiento");
				mensaje.setValido(false);
			}
		} else {
			mensaje.setMsm(", Debe digitar la fecha de nacimiento");
			mensaje.setValido(false);
		}
		// if(persona.getLugarResidencia()==null ) {
		// mensaje.setMsm(", Debe seleccionar el Lugar de expedicion del documento de
		// identificacion");
		// mensaje.setValido(false);
		// }
		mensaje2 = (Mensaje) seguridad.esCorreo(persona.getEmail(), "correo ");
		if (persona.getEmail() == null || !mensaje2.isValido()) {
			mensaje.setMsm("" + mensaje2.getMsm());
			mensaje.setValido(false);
		}

		if (persona.getEmailInterno() == null || persona.getEmailInterno().equals(" correo ")
				|| persona.getEmailInterno().length() < 3) {
//			mensaje.setMsm("" + mensaje2.getMsm());
//			mensaje.setValido(false);
		}

		if (persona.getApellido() == null || persona.getApellido().equals(" ") || persona.getApellido().length() < 3) {
			mensaje.setMsm("el primer apellido es obligatoria");
			mensaje.setValido(false);
		}
		if (persona.getApellido2() != null) {
			if (!persona.getApellido2().trim().equals("") && persona.getApellido2().length() < 3) {
				mensaje.setMsm("el segundo apellido debe tener mas de 3 caracteres");
				mensaje.setValido(false);
			}
		}else {
			persona.setApellido2("");
		}
		if (persona.getNombre() == null || persona.getNombre().equals(" ") || persona.getNombre().length() < 3) {
			mensaje.setMsm("el primer nombre es obligatoria");
			mensaje.setValido(false);
		}
		if (persona.getNombre2() != null) {
			if (persona.getNombre2().equals(" ") || persona.getNombre2().length() < 3) {
				mensaje.setMsm("el segundo nombre debe tener mas de 3 caracteres");
				mensaje.setValido(false);
			}
		}else {
			persona.setNombre2("");
		}
		mensaje.setResultado(persona);
		System.out.println("llega  sale  " + mensaje);
		return mensaje;

	}

	/**
	 * @param param
	 * @return
	 */
	public static Object setPersonaConvocatoria(Object param) {
		db = new PersonaDB();
		if (!db.esObject(param)) {
			Object datos[] = { null, param, 0 };
			db.setObject(param);
		}
		return null;
	}

	/**
	 * @param Obj
	 * @return
	 */
	public static Object getLista(Object Obj) {
		db = new PersonaDB();
		return db.getAll(Obj);
	}

	/**
	 * @param Obj
	 * @return
	 */
	public static Object getObject(Object Obj) {
		db = new PersonaDB();
		Mensaje mensaje = new Mensaje();
		mensaje.setResultado(db.getObject(Obj));
		return mensaje;
	}

	/**
	 * @param Obj
	 * @return
	 */
	public static Object getListaCaa(Object Obj) {
		db = new PersonaCarreraAdministrativaDB();
		return db.getAll(Obj);
	}

	/**
	 * @param Obj
	 * @return
	 */
	public static Object getObjectCaa(Object Obj) {
		Mensaje mensaje = new Mensaje();

		db = new PersonaCarreraAdministrativaDB();
		mensaje.setResultado(db.getObject(Obj));
		Object param[] = (Object[]) Obj;
		CarreraAdministrativa carreraAdministrativa = new CarreraAdministrativa();
		carreraAdministrativa.setPersona((Persona) param[0]);
		param[0] = carreraAdministrativa;
		db = new CarreraAdministrativaDB();
		mensaje.setValido((boolean) db.esObject(param));

		return mensaje;
	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static Object updateObject(HttpServletRequest request) throws IOException {
		db = new PersonaDB();

		Mensaje mensaje = (Mensaje) getvalidaDatosUpdate(request);

		Object parametro[] = { mensaje.getResultado(), request.getSession().getAttribute("usuario"), 2 };

		if (mensaje.isValido()) {
			if (db.esObject(mensaje.getResultado())) {
				int resultado = (int) db.setObject(parametro);
				Persona persona = (Persona) mensaje.getResultado();
				if (resultado >= 0) {
					mensaje.setValido(true);
					mensaje.setMsm("los datos de " + persona.getNombre() + " " + persona.getApellido()
							+ " se ha guardado con exito..");
				} else {
					mensaje.setValido(false);
					mensaje.setMsm("Error los datos personales de " + persona.getNombre() + " " + persona.getApellido()
							+ " no se han guardado ..");
				}
			} else {
				mensaje.setValido(false);
				mensaje.setMsm("no es un pensionado..");
			}
		}
		return mensaje;

	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	private static Object getvalidaDatosUpdate(HttpServletRequest request) throws IOException {

		Mensaje mensaje = new Mensaje(true, "", null, request.getSession().getAttribute("usuario"));

		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			e.printStackTrace();

		}

		ObjectMapper mapper = new ObjectMapper();

		Pensionado pensionado = mapper.readValue(jb.toString(), Pensionado.class);
		if (pensionado.getUaa_personal().getPersona().getCodigo() == 0) {
			mensaje.setMsm(mensaje.getMsm() + "debe seleccionar una persona ");
			mensaje.setValido(false);
		}
		if (pensionado.getUaa_personal().getPersona().getBarrio() == null
				|| pensionado.getUaa_personal().getPersona().getBarrio().length() <= 5) {
			mensaje.setMsm(mensaje.getMsm() + "debe digitar el barrio de recidencia ");
			mensaje.setValido(false);
		}
		if (pensionado.getUaa_personal().getPersona().getDireccionResidencia() == null
				|| pensionado.getUaa_personal().getPersona().getDireccionResidencia().length() <= 5) {
			mensaje.setMsm(mensaje.getMsm() + "debe digitar la dirección de recidencia ");
			mensaje.setValido(false);
		}
		if (pensionado.getUaa_personal().getPersona().getTelefonoFijo() == null
				|| pensionado.getUaa_personal().getPersona().getTelefonoFijo().length() <= 6) {
			mensaje.setMsm(mensaje.getMsm()
					+ "debe digitar el telefono fijo o el digitado no corresponde a un numero telefonico fijo valido. ");
			mensaje.setValido(false);
		}
		if (pensionado.getUaa_personal().getPersona().getTelefonoMovil() == null
				|| pensionado.getUaa_personal().getPersona().getTelefonoMovil().length() <= 9) {
			mensaje.setMsm(mensaje.getMsm()
					+ "debe digitar el teléfono celular o el digitado no corresponde a un numero telefonico celular valido. ");
			mensaje.setValido(false);
		}
		if (pensionado.getUaa_personal().getPersona().getGrupoSanguineo() == null
				|| pensionado.getUaa_personal().getPersona().getGrupoSanguineo().getCodigo() <= 1) {
			mensaje.setMsm(mensaje.getMsm() + "El grupo sanguineo es obligatorio. ");
			mensaje.setValido(false);
		}
		// if(pensionado.getUaa_personal().getPersona().getPer_email()==null ||
		// pensionado.getUaa_personal().getPersona().getPer_email().length()<=3) {
		// mensaje.setMsm(mensaje.getMsm()+"debe seleccionar una persona ");
		// mensaje.setValido(false);
		//
		// }else{
		// Mensaje msm=(Mensaje)
		// seguridad.esCorreo(pensionado.getUaa_personal().getPersona().getPer_email(),
		// "este correo ");
		// if(!msm.isValido()){
		// mensaje.setMsm(mensaje.getMsm()+"no corresponde a un correo valido ");
		// mensaje.setValido(false);
		// }
		// }

		mensaje.setResultado(pensionado.getUaa_personal().getPersona());
		return mensaje;
	}

	public static Object getPersonasVinculadas(Object obj) {
		ConexionDB db = new PersonaDB();
		Mensaje mensaje = new Mensaje();
		mensaje.setResultado(db.getAll(obj));
		return mensaje;
	}
}
