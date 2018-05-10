package co.edu.usco.modulo.personal.mvc.control.frontal;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import co.edu.usco.modulo.personal.mvc.control.herramientas.Session;
import co.edu.usco.modulo.personal.mvc.control.logica.DedicacionLog;
import co.edu.usco.modulo.personal.mvc.control.logica.EpsLog;
import co.edu.usco.modulo.personal.mvc.control.logica.Estado_civilLog;
import co.edu.usco.modulo.personal.mvc.control.logica.EstratoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.GeneroLog;
import co.edu.usco.modulo.personal.mvc.control.logica.Grupo_sangineoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.Historia_laboral_tipoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.Institucion_educativaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.LNX_naturalezaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.LNX_regimenLog;
import co.edu.usco.modulo.personal.mvc.control.logica.ModalidadLog;
import co.edu.usco.modulo.personal.mvc.control.logica.PersonaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.Persona_historia_academicaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.Persona_historia_laboralLog;
import co.edu.usco.modulo.personal.mvc.control.logica.Tipo_idlog;
import co.edu.usco.modulo.personal.mvc.control.logica.VinculacionLog;
import co.edu.usco.modulo.personal.mvc.modelo.Institucion_educativaOb;
import co.edu.usco.modulo.personal.mvc.modelo.PersonaHistoriaAcademica;
import co.edu.usco.modulo.personal.mvc.modelo.PersonaHistoriaLaboral;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.control.logica.NivelAcademicoLog;

/**
 * Servlet implementation class server
 */
@WebServlet(name = "server", urlPatterns = { "/upload" })
@MultipartConfig
public class server extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ObjectMapper objectMapper = new ObjectMapper();
		// DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		//
		// objectMapper.setDateFormat(df);
		response.setContentType("application/json");
		int opt = Integer.parseInt(request.getParameter("tipo"));
		String json = objectMapper.writeValueAsString(getElemento(opt, request));

		out.print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		// System.out.println("llega al servidor");
		ObjectMapper objectMapper = new ObjectMapper();
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");

		objectMapper.setDateFormat(df);

		int opt = Integer.parseInt(request.getParameter("tipo"));
		String json = objectMapper.writeValueAsString(proceso(opt, request));

		out.print(json);

	}

	private Object proceso(int opt, HttpServletRequest request) {
		Object resultado = null;
		if (Session.esSession(request)) {

			Usuario usuadmin = (Usuario) request.getSession().getAttribute("usuario");
			if (opt == 1) {
				PersonaLog.newObject(request);

			}
			if (opt == 3) {
				resultado = Persona_historia_academicaLog.newObject(request);

			}
			if (opt == 4) {
				resultado = Persona_historia_academicaLog.newObject(request);

			}
			if (opt == 5) {
				resultado = Persona_historia_laboralLog.newObject(request);

			}
			if (opt == 6) {
				resultado = Persona_historia_laboralLog.newObject(request);

			}
		}
		return resultado;
		// TODO Auto-generated method stub

	}

	public static Object getElemento(int tipo, HttpServletRequest request) {

		Object combo = null;
		if (Session.esSession(request)) {

			Usuario usuadmin = (Usuario) request.getSession().getAttribute("usuario");
			if (tipo == 1) {
				combo = Tipo_idlog.getLista(combo);
			}
			if (tipo == 2) {
				combo = Grupo_sangineoLog.getLista(combo);
			}
			if (tipo == 3) {
				combo = GeneroLog.getLista(combo);
			}
			if (tipo == 4) {
				combo = EstratoLog.getLista(combo);
			}
			if (tipo == 5) {
				combo = Estado_civilLog.getLista(combo);
			}
			if (tipo == 6) {
				combo = LNX_naturalezaLog.getLista(combo);
			}
			if (tipo == 7) {
				combo = LNX_regimenLog.getLista(combo);
			}
			if (tipo == 8) {
				combo = EpsLog.getLista(combo);
			}
			if (tipo == 9) {
				combo = NivelAcademicoLog.getLista(combo);
			}
			if (tipo == 10) {
				combo = EpsLog.getLista(combo);
			}
			if (tipo == 11) {
				combo = EpsLog.getLista(combo);
			}
			if (tipo == 12) {
				Institucion_educativaOb institucion = new Institucion_educativaOb();
				institucion.setIne_nombre(request.getParameter("ine_nombre"));
				combo = Institucion_educativaLog.getLista(institucion);
			}
			if (tipo == 13) {
				combo = ModalidadLog.getLista(combo);
			}
			if (tipo == 14) {
				PersonaHistoriaAcademica pha = new PersonaHistoriaAcademica();

				if (request.getParameter("per_codigo") != null && request.getParameter("per_codigo").length() > 0) {
					pha.getPersona().setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
				}
				Object datos[] = { pha };
				combo = Persona_historia_academicaLog.getLista(datos);
			}
			if (tipo == 15) {
				PersonaHistoriaAcademica pha = new PersonaHistoriaAcademica();

				if (request.getParameter("per_codigo") != null && request.getParameter("per_codigo").length() > 0) {
					pha.getPersona().setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
				}
				if (request.getParameter("pha_codigo") != null && request.getParameter("pha_codigo").length() > 0) {
					pha.setPha_codigo(Integer.parseInt(request.getParameter("pha_codigo")));
				}
				Object datos[] = { pha };
				combo = Persona_historia_academicaLog.getElemento(datos);
			}
			if (tipo == 16) {
				combo = Historia_laboral_tipoLog.getLista(combo);
			}
			if (tipo == 17) {
				combo = VinculacionLog.getLista(combo);
			}
			if (tipo == 18) {
				combo = DedicacionLog.getLista(combo);
			}
			if (tipo == 19) {
				PersonaHistoriaLaboral phl = new PersonaHistoriaLaboral();

				if (request.getParameter("per_codigo") != null && request.getParameter("per_codigo").length() > 0) {
					phl.getPersona().setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
				}
				Object datos[] = { phl };
				combo = Persona_historia_laboralLog.getLista(datos);
			}
			if (tipo == 20) {
				PersonaHistoriaLaboral phl = new PersonaHistoriaLaboral();

				if (request.getParameter("per_codigo") != null && request.getParameter("per_codigo").length() > 0) {
					phl.getPersona().setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
				}
				if (request.getParameter("phl_codigo") != null && request.getParameter("phl_codigo").length() > 0) {
					phl.setPhl_codigo(Integer.parseInt(request.getParameter("phl_codigo")));
				}
				Object datos[] = { phl };
				combo = Persona_historia_laboralLog.getElemento(datos);
			}
			
		}
		return combo;
	}
}
