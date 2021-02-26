package co.edu.usco.modulo.personal.mvc.control.herramientas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import co.edu.usco.modulo.personal.mvc.modelo.Usuario;


public class Session {

	
	public static boolean esSession(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession personasession = request.getSession(true);
		boolean hay =false;
		if(personasession  !=null){
			if((Usuario)personasession .getAttribute("usuario")!=null){
				hay=true;
			}
		}
		return hay;
	}

	public static Usuario getUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession personasession = request.getSession(true);
		Usuario user =null;
		if(personasession  !=null){
			if((Usuario)personasession .getAttribute("usuario")!=null){
				user=(Usuario)personasession .getAttribute("usuario");
			}
		}
		return user;
	}

	public static Usuario getAdministrador(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession personasession = request.getSession(true);
		Usuario user =null;
		if(personasession  !=null){
			if((Usuario)personasession .getAttribute("administrador")!=null){
				user=(Usuario)personasession .getAttribute("administrador");
			}
		}
		return user;
	}
	
	public static boolean validaInicioSession(HttpServletRequest request) {
		HttpSession usuario = request.getSession(true);
		if(usuario.getAttribute("activo")!=null) {
			return true;
		}
		return false;
	}
	
	/**
	 * @param request
	 * @param user
	 */
	public static void setSessionAdministrador(HttpServletRequest request, Usuario user) {
		HttpSession personasession = request.getSession(true);
		if(user!=null) {
			if(personasession.getAttribute("administrador")!=null) {
				personasession.removeAttribute("administrador");
			}
			personasession.setAttribute("administrador", user);
			personasession.setAttribute("activo", "true");
		}
//		if(user!=null){
//			if(request.getSession().getAttribute("usuario")!=null) {
//				request.getSession().removeAttribute("usuario");
//			}
//			request.getSession().setAttribute("usuario", user);
//			request.getSession().setAttribute("activo", "true");
//		}
		
	}
	
	/**
	 * @param request
	 * @param user
	 */
	public static void setSession(HttpServletRequest request, Usuario user) {
		HttpSession personasession = request.getSession(true);
		if(user!=null) {
			if(personasession.getAttribute("usuario")!=null) {
				personasession.removeAttribute("usuario");
			}
			personasession.setAttribute("usuario", user);
			personasession.setAttribute("activo", "true");
		}
//		if(user!=null){
//			if(request.getSession().getAttribute("usuario")!=null) {
//				request.getSession().removeAttribute("usuario");
//			}
//			request.getSession().setAttribute("usuario", user);
//			request.getSession().setAttribute("activo", "true");
//		}
		
	}

}
