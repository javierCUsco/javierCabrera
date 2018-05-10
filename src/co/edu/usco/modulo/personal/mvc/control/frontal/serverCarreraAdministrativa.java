package co.edu.usco.modulo.personal.mvc.control.frontal;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Session;
import co.edu.usco.modulo.personal.mvc.control.logica.PersonaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.ReporteLog;
import co.edu.usco.modulo.personal.mvc.control.logica.Uaa_cargoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa.CarreraAdministrativaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa.CarreraAdministrativaAtualizacionLog;
import co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa.TipoActualizacionLog;
import co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa.TipoComisionLog;
import co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa.TipoProcesoLog;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.UaaCargo;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa.CarreraAdministrativa;
import co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa.CarreraAdministrativaActualizacion;

/**
 * Servlet implementation class serverCarreraAdministrativa
 */
@WebServlet("/serverCarreraAdministrativa")
public class serverCarreraAdministrativa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(Session.esSession(request)){
			PrintWriter out = response.getWriter();
			ObjectMapper objectMapper = new ObjectMapper();
			// DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			//
			// objectMapper.setDateFormat(df);
			response.setContentType("application/json");
			int opt = Integer.parseInt(request.getParameter("tipo"));
			String json = objectMapper.writeValueAsString(getElemento(opt, request));
	
			out.print(json);
		}else{
			response.sendError(404);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(Session.esSession(request)){
			PrintWriter out = response.getWriter();
			// System.out.println("llega al servidor");
			ObjectMapper objectMapper = new ObjectMapper();
			DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
	
			objectMapper.setDateFormat(df);
	
			int opt = Integer.parseInt(request.getParameter("tipo"));
			String json = objectMapper.writeValueAsString(proceso(opt, request));
	
			out.print(json);
		}else{
			response.sendError(404);
		}

	}

	private Object proceso(int opt, HttpServletRequest request) {
		Object resultado = null;
		if(Session.esSession(request)){

		
		if (opt == 1) {
			resultado = CarreraAdministrativaLog.newObject(request);

		}
		if (opt == 3) {
			resultado = CarreraAdministrativaAtualizacionLog.newObject(request);

		}
		// if (opt == 3) {
		// resultado=Persona_historia_academicaLog.newObject(request);
		//
		// }
		// if (opt == 4) {
		// resultado=Persona_historia_academicaLog.newObject(request);
		//
		// }
		// if (opt ==5) {
		// resultado=Persona_historia_laboralLog.newObject(request);
		//
		// }
		// if (opt == 6) {
		// resultado=Persona_historia_laboralLog.newObject(request);
		//
		// }
		}
		return resultado;
		// TODO Auto-generated method stub

	}

	public static Object getElemento(int tipo, HttpServletRequest request) {

		Object combo = null;
		if(Session.esSession(request)){

		Usuario usuadmin = (Usuario) request.getSession().getAttribute("usuario");
		
		if (tipo == 1) {
			combo = TipoProcesoLog.getLista(usuadmin);
		}
		if (tipo == 2) {
			combo = TipoActualizacionLog.getLista(usuadmin);
		}
		if (tipo == 3) {
			combo = TipoComisionLog.getLista(usuadmin);
		}
		if (tipo == 4) {
			UaaCargo uaa_cargo = new UaaCargo();
			uaa_cargo.getUaa().setUaa_nombre(request.getParameter("nombre"));
			Object param[] = { uaa_cargo, usuadmin };
			combo = Uaa_cargoLog.getLista(param);
		}
		if (tipo == 5) {
			UaaCargo uaa_cargo = new UaaCargo();
			uaa_cargo.setUac_codigo(Integer.parseInt(request.getParameter("uac_codigo")));
			uaa_cargo.getUaa().setUaa_nombre(request.getParameter("nombre"));
			Object param[] = { uaa_cargo, usuadmin };
			combo = Uaa_cargoLog.getObject(param);
		}
		if (tipo == 6) {
			Persona persona = new Persona();
			persona.setPer_nombre(request.getParameter("nombre"));

			Object param[] = { persona, usuadmin };
			combo = PersonaLog.getListaCaa(param);
		}
		if (tipo == 7) {
			Persona persona = new Persona();
			persona.setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));

			Object param[] = { persona, usuadmin };
			combo = PersonaLog.getObjectCaa(param);
		}
		if (tipo == 8) {
			CarreraAdministrativa persona = new CarreraAdministrativa();
			if (request.getParameter("per_codigo") != null) {
				persona.getPersona().setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
			}
			if (request.getParameter("per_nombre") != null) {
				persona.getPersona().setPer_nombre(request.getParameter("per_nombre"));
			}
			Object param[] = { persona, usuadmin };
			combo = CarreraAdministrativaLog.getLista(param);
		}
		if (tipo == 9) {
			CarreraAdministrativa carrera_administrativa = new CarreraAdministrativa();
			if (request.getParameter("per_codigo") != null) {
				carrera_administrativa.getPersona().setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
			}
			if (request.getParameter("caa_codigo") != null) {
				carrera_administrativa.setCaa_codigo(Integer.parseInt(request.getParameter("caa_codigo")));
			}
			Object param[] = { carrera_administrativa, usuadmin };
			combo = CarreraAdministrativaLog.getObject(param);
		}
		if (tipo == 10) {

			Object param[] = { null, usuadmin };
			combo = TipoActualizacionLog.getLista(usuadmin);
		}
		
		if (tipo == 11) {

			CarreraAdministrativaActualizacion carreraAdministrativaActualizacion = new CarreraAdministrativaActualizacion();
			if (request.getParameter("per_codigo") != null) {
				carreraAdministrativaActualizacion.getCaa().getPersona().setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
			}
			if (request.getParameter("caa_codigo") != null) {
				carreraAdministrativaActualizacion.getCaa().setCaa_codigo(Integer.parseInt(request.getParameter("caa_codigo")));
			}
			Object param[] = { carreraAdministrativaActualizacion, usuadmin };
			combo = CarreraAdministrativaAtualizacionLog.getLista(param);
		}
		if (tipo == 12) {

			CarreraAdministrativaActualizacion carrera_administrativa_actualizacion = new CarreraAdministrativaActualizacion();
			if (request.getParameter("per_codigo") != null) {
				carrera_administrativa_actualizacion.getCaa().getPersona().setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
			}
			if (request.getParameter("caaa_codigo") != null) {
				carrera_administrativa_actualizacion.setCaaa_codigo(Integer.parseInt(request.getParameter("caaa_codigo")));
			}
			if (request.getParameter("caa_codigo") != null) {
				carrera_administrativa_actualizacion.getCaa().setCaa_codigo(Integer.parseInt(request.getParameter("caa_codigo")));
			}
			Object param[] = { carrera_administrativa_actualizacion, usuadmin };
			combo = CarreraAdministrativaAtualizacionLog.getObject(param);
		}
		if (tipo == 13) {

			CarreraAdministrativa carrera_administrativa = new CarreraAdministrativa();
			if (request.getParameter("per_codigo") != null) {
				carrera_administrativa.getPersona().setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
			}
			if (request.getParameter("caa_codigo") != null) {
				carrera_administrativa.setCaa_codigo(Integer.parseInt(request.getParameter("caa_codigo")));
			}
			Object param[] = { carrera_administrativa, usuadmin };
			combo = ReporteLog.getObject(param);
			
		}
		
	}else{
		Mensaje msm= new Mensaje(false, "no", null);
		combo=(Object)msm;
	}
		return combo;
	}

}
