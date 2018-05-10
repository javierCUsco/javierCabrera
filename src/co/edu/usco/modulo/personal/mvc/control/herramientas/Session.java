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

	public static void setSession(HttpServletRequest request, Usuario user) {
		if(user!=null){
			request.getSession().setAttribute("usuario", user);
			request.getSession().setAttribute("activo", "true");
		}
		
	}

}
