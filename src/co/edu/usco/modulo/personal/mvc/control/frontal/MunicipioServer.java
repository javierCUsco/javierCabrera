package co.edu.usco.modulo.personal.mvc.control.frontal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import co.edu.usco.modulo.personal.mvc.control.herramientas.Session;
import co.edu.usco.modulo.personal.mvc.control.logica.DepartamentoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.MunicipioLog;
import co.edu.usco.modulo.personal.mvc.control.logica.PaisLog;
import co.edu.usco.modulo.personal.mvc.modelo.Departamento;
import co.edu.usco.modulo.personal.mvc.modelo.Municipio;
import co.edu.usco.modulo.personal.mvc.modelo.Pais;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * Servlet implementation class munserver
 */
@WebServlet("/munserver")
public class MunicipioServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ObjectMapper objectMapper = new ObjectMapper();
		int opt=0;//Integer.parseInt(request.getParameter("tipo"));
		String json = objectMapper.writeValueAsString(getElemento(opt, request));
		
		out.print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

	
	
	 public static Object getElemento(int tipo,HttpServletRequest request){
//		 System.out.println("llega al servidor "+tipo);
	    	Object resultado= null;
//	    	if (Session.esSession(request)) {
		    	Usuario usuadmin = (Usuario) request.getSession().getAttribute("usuario");
//		    	if(tipo==1){
//		    		resultado=PaisLog.getLista(resultado);
//		    	}
//	
//		    	if(tipo==2){
//		    		Pais pais= new Pais();
//		    		pais.setCodigo(Integer.parseInt(request.getParameter("pai_codigo")));
//		    		Object [] param={pais};
//		    		resultado=DepartamentoLog.getLista(param);
//		    	}
//		    	if(tipo==3){
//		    		Departamento departamento= new Departamento();
//		    		departamento.setCodigo(Integer.parseInt(request.getParameter("dep_codigo")));
//		    		departamento.getPais().setCodigo(Integer.parseInt(request.getParameter("pai_codigo")));
//		    		Object [] param={departamento};
//		    		resultado=MunicipioLog.getLista(param);
//		    	}
//		    	
//		    	if(tipo==4){
		    		Municipio municipio= new Municipio();
		    		if(request.getParameter("nombre")!=null) {
		    			municipio.setNombre(request.getParameter("nombre"));
		    		}else {
		    			municipio.setNombre("");
		    		}
		    			
		    		Object [] param={municipio,usuadmin};
		    		resultado=MunicipioLog.getLista(param);
//		    	}
//
//	    	}
	    return resultado;
	    }
}
