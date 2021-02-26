package co.edu.usco.modulo.personal.mvc.control.frontal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import co.edu.usco.modulo.personal.mvc.control.herramientas.HttpClient;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Session;
import co.edu.usco.modulo.personal.mvc.control.herramientas.TokenLog;
import co.edu.usco.modulo.personal.mvc.control.logica.AdminLog;
import co.edu.usco.modulo.personal.mvc.control.logica.UrlLog;
import co.edu.usco.modulo.personal.mvc.control.logica.WebParametroLog;
import co.edu.usco.modulo.personal.mvc.control.logica.loginLog;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Resultado;
import co.edu.usco.modulo.personal.mvc.modelo.Url;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.WebParametro;

/**
 * Servlet implementation class frontEnd
 */
@WebServlet("/entrada")
public class frontEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(getClass().getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String metodo = request.getParameter("metodo");
		log.info("metodo(   )     " + metodo);
		Mensaje mensaje = new Mensaje();
		String front = "pages/home.jsp";
		Usuario user = new Usuario();
		WebParametro parametro = new WebParametro("TOKEN_URL_AUTENTICACION");


		if (metodo != null) {
			if (metodo.equals("login")) {

				
				user.setNombre(request.getUserPrincipal().getName());
				user.setClave2(request.getParameter("password"));

				
				Usuario persona = (Usuario) loginLog.getObject(user);
				user= Session.getUser(request);
				user.setClave2(request.getParameter("password"));
				user.setUrl((Url) UrlLog.getObject(persona));

//				persona.setNombre(user.getNombre());
//				persona.setNombreencriptado(hex.transHexa(user.getNombreencriptado(),2));
//				persona.setClave2(hex.transHexa(user.getClave2(),2));
				log.info(user);
				mensaje = (Mensaje) AdminLog.getValidaUsuarioAdmin(user);
				log.info("<--     " + mensaje + " -->");
				
				Session.setSession(request, user);
				if (!mensaje.isValido()) {
					int opcion = 1;
					if (request.getSession().getAttribute("opcion") != null) {
						String valor = String.valueOf(request.getSession().getAttribute("opcion"));
						opcion = Integer.parseInt(valor);
						opcion++;
					}
					request.getSession().setAttribute("opcion", opcion);
					mensaje.setMsm(mensaje.getMsm() + ", intentos " + opcion);
					request.getSession().setAttribute("mensaje", mensaje);
					if (opcion <= 5) {
						response.sendRedirect("pages/segundaclave.jsp");
						// response.sendRedirect("pages/segundaclave.jsp");
					} else {
						response.sendRedirect("index.jsp");
					}

					return;
				}else {
					response.sendRedirect(front);
				}
			}
			if (metodo.equals("token")) {
				parametro = (WebParametro) WebParametroLog.getObject(parametro);
				
				user.setNombre(request.getUserPrincipal().getName());
				// user.setClave(request.getParameter("password"));
				user.setModulo(Integer.parseInt(String.valueOf(request.getSession().getAttribute("modulo"))));
				 Usuario persona = (Usuario)loginLog.getObject(user);
				 user.setPersona(persona.getPersona());
				mensaje = (Mensaje) AdminLog.getObject(user);
				

				log.info("mensaje " + mensaje);
				user = (Usuario) mensaje.getResultado();

				String ipAddress = request.getHeader("X-FORWARDED-FOR");
				if (ipAddress == null) {
					ipAddress = request.getRemoteAddr();
				}

				user.setIp(ipAddress);
				user.setAutorizacion(String.valueOf(TokenLog.getToken(user)));
				log.info("" + mensaje);
				try {
					ObjectMapper objectMapper = new ObjectMapper();
					Resultado resultado = null;
					String jsonString = (String) HttpClient.generarCodigo("" + user.getUid(), user.getIp(),
							"" + user.getModulo(), user.getAutorizacion(), parametro.getValor().trim());
					resultado = objectMapper.readValue(jsonString, Resultado.class);
					user.getToken();
					
					request.getSession().setAttribute("token", "token");
					mensaje.setMsm(resultado.getMensaje());
					Session.setSession(request, user);

					request.getSession().setAttribute("resultadoToken", mensaje);
					response.sendRedirect("pages/validaToken.jsp");
				} catch (Exception e) {
					log.error("<--     " + e + " -->");
					;
				}
			}
			if (metodo.equals("validaToken")) {
				
				parametro = (WebParametro) WebParametroLog.getObject(parametro);
				
				user = (Usuario) Session.getUser(request);
				log.info("user " + user);
				
				try {
					Resultado resultado = new Resultado();
					ObjectMapper objectMapper = new ObjectMapper();
					String jsonString = (String) HttpClient.validarCodigo("" + user.getUid(), user.getIp(),
							"" + user.getModulo(), user.getAutorizacion(), request.getParameter("token"),
							parametro.getValor());
					resultado = objectMapper.readValue(jsonString, Resultado.class);
					user.setToken(resultado.getMensaje());
					
					log.info("resultado " + resultado);

					Session.setSession(request, user);

					if (resultado.isEstado()) {
						request.getSession().removeAttribute("token");
						request.getSession().removeAttribute("errores");
						request.getSession().removeAttribute("mensaje");
						response.sendRedirect("pages/segundaclave.jsp");
					} else {
						
						int opcion = 1;
						if (request.getSession().getAttribute("errores") != null) {
							String valor = String.valueOf(request.getSession().getAttribute("errores"));
							opcion = Integer.parseInt(valor);
							opcion++;
						}
						request.getSession().setAttribute("errores", opcion);
						mensaje.setMsm(mensaje.getMsm() + ", intentos " + resultado.getConsola());
						request.getSession().setAttribute("mensaje", mensaje);
						if (opcion <= 3) {
							response.sendRedirect("pages/validaToken.jsp");
							// response.sendRedirect("pages/segundaclave.jsp");
						} else {
							response.sendRedirect("index.jsp");
						}
						//request.getSession().removeAttribute("token");
						return;
						
						
						
						
						
					}
				} catch (Exception e) {
					log.error("<--     " + e + " -->" + mensaje);
				}
			} else {
				request.getSession().removeAttribute("opcion");
				request.getSession().removeAttribute("mensaje");
			}

			// response.sendRedirect(front);

		}

	}
}
