package co.edu.usco.modulo.personal.mvc.control.frontal;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Session;
import co.edu.usco.modulo.personal.mvc.control.logica.FechaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.PersonaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.UaaPersonalLog;
import co.edu.usco.modulo.personal.mvc.control.logica.pensionado.PensionadoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.pensionado.TipoPensionLog;
import co.edu.usco.modulo.personal.mvc.modelo.UaaPersonal;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.pensionado.Pensionado;

/**
 * Servlet implementation class serverPensionado
 */
@WebServlet("/serverPensionado")
public class serverPensionado extends HttpServlet {
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

	private Object proceso(int opt, HttpServletRequest request) throws ServletException, IOException {
		Object resultado = null;
		if (Session.esSession(request)) {

			if (opt == 1) {
				resultado = PensionadoLog.newObject(request);
			}
			if(opt==3){
				resultado	=PersonaLog.updateObject(request);
			}

		}
		return resultado;
		// TODO Auto-generated method stub

	}

	/**
	 * @param tipo
	 * @param request
	 * @return
	 */
	public static Object getElemento(int tipo, HttpServletRequest request) {

		Object combo = null;
		if (Session.esSession(request)) {

			Usuario usuadmin = (Usuario) request.getSession().getAttribute("usuario");
//System.out.println("llega");
			if (tipo == 1) {
				combo = TipoPensionLog.getLista(usuadmin);
			}
			if (tipo == 2) {
				Object param[] = { null, usuadmin };
				combo = PensionadoLog.getLista(param);
			}
			if (tipo == 3) {
				Pensionado pensionado= new Pensionado();
				pensionado.getUaa_personal().getPersona().setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
				pensionado.getUaa_personal().setUap_codigo(Integer.parseInt(request.getParameter("uap_codigo")));
				pensionado.setPen_codigo(Integer.parseInt(request.getParameter("pen_codigo")));
				Object param[] = { pensionado, usuadmin };
				combo = PensionadoLog.getObject(param);
			}
			if (tipo == 4) {
				UaaPersonal uaaPersonal= new UaaPersonal();
				uaaPersonal.getPersona().setPer_nombre(request.getParameter("per_nombre"));
				Object param[] = { uaaPersonal, usuadmin };
				combo=UaaPersonalLog.getLista(param);
			}
			if (tipo == 5) {
				UaaPersonal uaaPersonal= new UaaPersonal();
				uaaPersonal.getPersona().setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
				uaaPersonal.setUap_codigo(Integer.parseInt(request.getParameter("uap_codigo")));
				Object param[] = { uaaPersonal, usuadmin };
				combo=UaaPersonalLog.getObject(param);
			}
			if (tipo == 6) {
				combo=FechaLog.tiempoLaborado(request);
			}

		}
		return combo;
	}

}
