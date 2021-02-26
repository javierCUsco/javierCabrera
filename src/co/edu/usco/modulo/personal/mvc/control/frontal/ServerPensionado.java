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
import co.edu.usco.modulo.personal.mvc.control.logica.FechaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.GrupoSangineoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.PersonaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.UaaPersonalLog;
import co.edu.usco.modulo.personal.mvc.control.logica.pensionado.PensionadoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.pensionado.TipoPensionLog;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.UaaPersonal;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.pensionado.Pensionado;

/**
 * Servlet implementation class serverPensionado
 */
@WebServlet("/serverPensionado")
public class ServerPensionado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ObjectMapper objectMapper = new ObjectMapper();
		if(request.getParameter("tipo")!=null) {
			response.setContentType("application/json");
			}else {
				response.setContentType("text/html");
			}
		String json = "";
		if (Session.esSession(request)) {
			
			int opt = Integer.parseInt(request.getParameter("tipo"));
			json = objectMapper.writeValueAsString(getElemento(opt, request));
	
		
		}else{
			Mensaje mensaje=new Mensaje(false, "se cerro la session debe loguearse", null,null);
			json= objectMapper.writeValueAsString(mensaje);
		}	
		out.print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ObjectMapper objectMapper = new ObjectMapper();
		response.setContentType("application/json");
		String json ="";
		if (Session.esSession(request)) {
			
			int opt = Integer.parseInt(request.getParameter("tipo"));
			json= objectMapper.writeValueAsString(proceso(opt, request));
			
	}else{
		Mensaje mensaje=new Mensaje(false, "se cerro la session debe loguearse", null,null);
		json= objectMapper.writeValueAsString(mensaje);
	}
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
				pensionado.getUaa_personal().getPersona().setCodigo(Integer.parseInt(request.getParameter("per_codigo")));
				pensionado.getUaa_personal().setCodigo(Integer.parseInt(request.getParameter("uap_codigo")));
				pensionado.setPen_codigo(Integer.parseInt(request.getParameter("pen_codigo")));
				Object param[] = { pensionado, usuadmin };
				combo = PensionadoLog.getObject(param);
			}
			if (tipo == 4) {
				UaaPersonal uaaPersonal= new UaaPersonal();
				uaaPersonal.getPersona().setNombre(request.getParameter("per_nombre"));
				Object param[] = { uaaPersonal, usuadmin };
				combo=UaaPersonalLog.getDocentes(param);
			}
			if (tipo == 5) {
				UaaPersonal uaaPersonal= new UaaPersonal();
				uaaPersonal.getPersona().setCodigo(Integer.parseInt(request.getParameter("per_codigo")));
				uaaPersonal.setCodigo(Integer.parseInt(request.getParameter("uap_codigo")));
				Object param[] = { uaaPersonal, usuadmin };
				combo=UaaPersonalLog.getObject(param);
			}
			if (tipo == 6) {
				combo=FechaLog.tiempoLaborado(request);
			}
			if (tipo == 7) {
				Object param[] = { null, usuadmin };
				combo=GrupoSangineoLog.getLista(param);
			}

		}
		return combo;
	}

}
