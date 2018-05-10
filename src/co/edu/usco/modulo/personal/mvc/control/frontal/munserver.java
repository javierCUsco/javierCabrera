package co.edu.usco.modulo.personal.mvc.control.frontal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import co.edu.usco.modulo.personal.mvc.control.logica.DepartamentoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.MunicipioLog;
import co.edu.usco.modulo.personal.mvc.control.logica.PaisLog;
import co.edu.usco.modulo.personal.mvc.modelo.DepartamentoOb;
import co.edu.usco.modulo.personal.mvc.modelo.PaisOb;

/**
 * Servlet implementation class munserver
 */
@WebServlet("/munserver")
public class munserver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ObjectMapper objectMapper = new ObjectMapper();
		int opt=Integer.parseInt(request.getParameter("tipo"));
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
	    	Object combo= null;
	    	
	    	if(tipo==1){
	    		combo=PaisLog.getLista(combo);
	    	}

	    	if(tipo==2){
	    		PaisOb pais= new PaisOb();
	    		pais.setPai_codigo(Integer.parseInt(request.getParameter("pai_codigo")));
	    		Object [] param={pais};
	    		combo=DepartamentoLog.getLista(param);
	    	}
	    	if(tipo==3){
	    		DepartamentoOb departamento= new DepartamentoOb();
	    		departamento.setDep_codigo(Integer.parseInt(request.getParameter("dep_codigo")));
	    		departamento.getPais().setPai_codigo(Integer.parseInt(request.getParameter("pai_codigo")));
	    		Object [] param={departamento};
	    		combo=MunicipioLog.getLista(param);
	    	}
	    	

	    return combo;
	    }
}
