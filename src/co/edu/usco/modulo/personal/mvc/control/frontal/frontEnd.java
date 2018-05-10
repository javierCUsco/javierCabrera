package co.edu.usco.modulo.personal.mvc.control.frontal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.herramientas.Session;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Transformacion;
import co.edu.usco.modulo.personal.mvc.control.logica.AdminLog;
import co.edu.usco.modulo.personal.mvc.control.logica.UrlLog;
import co.edu.usco.modulo.personal.mvc.control.logica.loginLog;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Url;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * Servlet implementation class frontEnd
 */
@WebServlet("/frontEnd")
public class frontEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(getClass().getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();
//		ObjectMapper objectMapper = new ObjectMapper();
//		String json = objectMapper.writeValueAsString(processRequest(request,response));
//		
//		out.print(json);
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String metodo = request.getParameter("tipo");
		log.info("metodo(   )     " + metodo);
		Mensaje mensaje =new Mensaje();
		String front="pages/home.jsp";
		Usuario user = new Usuario();
		if (metodo != null && metodo.equals("login")) {
			response.setContentType("text/xml");
			
			user.setNombre(request.getParameter("user"));
			user.setNombreencriptado(request.getParameter("usencrip"));
			user.setClave(request.getParameter("clave1"));
			user.setClave2(request.getParameter("clave2"));
			 mensaje = (Mensaje) loginLog.login(user);
			log.info("respuesta(   )     " + mensaje.getMsm());
			if (!mensaje.isValido()) {
				response.sendRedirect(front);
				
				return;
			} 

		}
		Transformacion hex = new Transformacion();

		Usuario persona = (Usuario) loginLog.getObject(user);
		persona.setUrl((Url) UrlLog.getObject(persona));
		persona.setNombre(user.getNombre());
		persona.setNombreencriptado(user.getNombreencriptado());
		persona.setClave(hex.transHexa(user.getClave(),2));
		persona.setClave2(user.getClave2());
		log.info("respuesta(   )     " + user.getNombre());
		
		mensaje= (Mensaje) AdminLog.getObject(persona);
		if(!mensaje.isValido()){
			response.sendRedirect(front);
			
			return;
		}
		Session.setSession(request, persona);
		response.sendRedirect("j_security_check?j_username=" + user.getNombreencriptado() + "&j_password=" + user.getClave());
		
		
//		return mensaje;
	}

}
