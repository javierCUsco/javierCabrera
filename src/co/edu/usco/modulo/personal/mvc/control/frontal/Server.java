package co.edu.usco.modulo.personal.mvc.control.frontal;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.itextpdf.text.log.SysoLogger;

import co.edu.usco.modulo.personal.mvc.control.herramientas.Session;
import co.edu.usco.modulo.personal.mvc.control.herramientas.TokenLog;
import co.edu.usco.modulo.personal.mvc.control.logica.CargoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.DedicacionLog;
import co.edu.usco.modulo.personal.mvc.control.logica.DocenteEscalafonLog;
import co.edu.usco.modulo.personal.mvc.control.logica.EpsLog;
import co.edu.usco.modulo.personal.mvc.control.logica.EscalafonLog;
import co.edu.usco.modulo.personal.mvc.control.logica.EstadoCivilLog;
import co.edu.usco.modulo.personal.mvc.control.logica.EstratoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.GeneroLog;
import co.edu.usco.modulo.personal.mvc.control.logica.GrupoSangineoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.HistoriaLaboralTipoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.InstitucionEducativaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.JornadaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.LNXNaturalezaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.LNX_regimenLog;
import co.edu.usco.modulo.personal.mvc.control.logica.ModalidadLog;
import co.edu.usco.modulo.personal.mvc.control.logica.NivelAcademicoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.PeriodoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.PersonaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.SedeLog;
import co.edu.usco.modulo.personal.mvc.control.logica.PersonaHistoriaAcademicaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.PersonaHistoriaLaboralLog;
import co.edu.usco.modulo.personal.mvc.control.logica.TipoIdlog;
import co.edu.usco.modulo.personal.mvc.control.logica.UaaCargoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.UaaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.UaaPersonalLog;
import co.edu.usco.modulo.personal.mvc.control.logica.VinculacionLog;
import co.edu.usco.modulo.personal.mvc.control.logica.WebParametroLog;
import co.edu.usco.modulo.personal.mvc.control.logica.sgd.DocumentoLog;
import co.edu.usco.modulo.personal.mvc.control.logica.sgd.DocumentoTipoLog;
import co.edu.usco.modulo.personal.mvc.modelo.Cargo;
import co.edu.usco.modulo.personal.mvc.modelo.DocenteEscalafon;
import co.edu.usco.modulo.personal.mvc.modelo.InstitucionEducativa;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.PersonaHistoriaAcademica;
import co.edu.usco.modulo.personal.mvc.modelo.PersonaHistoriaLaboral;
import co.edu.usco.modulo.personal.mvc.modelo.Sede;
import co.edu.usco.modulo.personal.mvc.modelo.Uaa;
import co.edu.usco.modulo.personal.mvc.modelo.UaaCargo;
import co.edu.usco.modulo.personal.mvc.modelo.UaaPersonal;
import co.edu.usco.modulo.personal.mvc.modelo.UaaTipo;
import co.edu.usco.modulo.personal.mvc.modelo.Url;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.Vinculacion;
import co.edu.usco.modulo.personal.mvc.modelo.WebParametro;
import co.edu.usco.modulo.personal.mvc.modelo.sgd.Documento;
import co.edu.usco.modulo.personal.mvc.modelo.sgd.DocumentoTipo;

/**
 * Servlet implementation class server
 */
@WebServlet(name = "server", urlPatterns = { "/upload" })
@MultipartConfig
public class Server extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger imp;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ObjectMapper objectMapper = new ObjectMapper();
		if(request.getParameter("param")!=null) {
			response.setContentType("application/json");
			}else {
				response.setContentType("text/html");
			}
		String json = objectMapper.writeValueAsString(getElemento(request));

		out.print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter();//.append("Served at: ").append(request.getContextPath());
		response.setStatus(HttpServletResponse.SC_OK);
		ObjectMapper objectMapper = new ObjectMapper();
		PrintWriter out = response.getWriter();
		if(request.getParameter("param")!=null) {
		response.setContentType("application/json");
		}else {
			response.setContentType("text/html");
		}
		String json = "";
		json = objectMapper.writeValueAsString(getProceso(request));
		out.print(json);
	}

	private Object getProceso( HttpServletRequest request) throws ServletException {
		System.out.println("llega getProceso "+request.getParameter("param"));
		int opt=0;
		imp = Logger.getLogger(getClass().getName());
		Object resultado = null;
		String mentodo = request.getParameter("param");
		//if (Session.esSession(request)) {
			ObjectMapper mapper = new ObjectMapper();
			StringBuffer jb = new StringBuffer();
			String line = null;
			try {
				BufferedReader reader = request.getReader();
				while ((line = reader.readLine()) != null)
					jb.append(line);
			} catch (Exception e) {
				e.printStackTrace();

			}
		
			try {
			//Usuario usuadmin = new Usuario();//(Usuario) request.getSession().getAttribute("usuario");
			Usuario usuadmin=Session.getAdministrador(request);

			if (mentodo.equals("personas")) {
				Persona persona = new Persona();
				persona.setApellido("");
				persona.setNombre("");
				persona.setIdentificacion("");
				if(jb!=null) {
					persona = mapper.readValue(jb.toString(), Persona.class);
				}
				//uaaPersonal.setPersona(persona);
				Object param[] = { persona, null,1};
				resultado = PersonaLog.getPersonasVinculadas(param);
			}
			if (mentodo.equals("setPersona")) {
				Persona persona = mapper.readValue(jb.toString(), Persona.class);
				int update=0;
				if(request.getParameter("update")!=null) {
					update=Integer.parseInt(request.getParameter("update"));
				}
				Object param[] = { persona, usuadmin,update };
				resultado=PersonaLog.newObject( param);

			}
			if (mentodo.equals("setPersonaHistoriaAcademica")) {
				
				Persona personaHistoriaAcademica = mapper.readValue(jb.toString(),	Persona.class);
				int update=0;
				if(request.getParameter("update")!=null) {
					update=Integer.parseInt(request.getParameter("update"));
				}
				Object param[] = { personaHistoriaAcademica, usuadmin, update };
				// PersonaHistoriaAcademicaLog.newObject(request,param);
				resultado = PersonaHistoriaAcademicaLog.newObject( param);

			}
			if (mentodo.equals("setPersonaHistoriaLaboral")) {

				Persona personaHistoriaLaboral = mapper.readValue(jb.toString(),
						Persona.class);
				int update=0;
				if(request.getParameter("update")!=null) {
					update=Integer.parseInt(request.getParameter("update"));
				}
				Object param[] = { personaHistoriaLaboral, usuadmin, update };
				resultado = PersonaHistoriaLaboralLog.newObject( param);
			}

			if (mentodo.equals("setUaaPersonal")) {
				UaaPersonal uaaPersonal = mapper.readValue(jb.toString(),UaaPersonal.class);
				
				int update=0;
				if(request.getParameter("update")!=null) {
					update=Integer.parseInt(request.getParameter("update"));
				}
				Object param[] = { uaaPersonal, usuadmin, update };
				resultado = UaaPersonalLog.newObject( param);
				 System.out.println("sale del ser server "+resultado);
			}
			
			if (mentodo.equals("setEscalafonDocente")) {
				DocenteEscalafon docenteEscalafon = mapper.readValue(jb.toString(),
						DocenteEscalafon.class);
				int update=0;
				if(request.getParameter("update")!=null) {
					update=Integer.parseInt(request.getParameter("update"));
				}
				Object param[] = { docenteEscalafon, usuadmin, update };
				resultado = DocenteEscalafonLog.newObject( param);
			}

			if (mentodo.equals("setUaaPersonalAdmin")) {
				UaaPersonal uaaPersonal = mapper.readValue(jb.toString(),UaaPersonal.class);
				
				int update=0;
				if(request.getParameter("update")!=null) {
					update=Integer.parseInt(request.getParameter("update"));
				}
				Object param[] = { uaaPersonal, usuadmin, update };
				resultado = UaaPersonalLog.newObjectAdministrativo( param);
			}

			
			if (opt == 7) {
				Persona persona = mapper.readValue(jb.toString(), Persona.class);
				Object param[] = { persona, usuadmin };
				resultado = PersonaLog.getLista(param);
			}
			if (opt == 8) {
				Persona persona = mapper.readValue(jb.toString(), Persona.class);

				Object param[] = { persona, usuadmin };
				resultado = PersonaLog.getObject(param);
				request.getSession().setAttribute("dato", resultado);
				// imp.info("sale "+resultado);
			}

			
			if (opt == 20) {

				PersonaHistoriaLaboral personaHistoriaLaboral = mapper.readValue(jb.toString(),
						PersonaHistoriaLaboral.class);
				Object param[] = { personaHistoriaLaboral, usuadmin, 0 };
				resultado = PersonaHistoriaLaboralLog.getElemento(param);
			}
			if (opt == 21) {

				Documento documento = mapper.readValue(jb.toString(), Documento.class);
				Object param[] = { documento, usuadmin, 0 };
				resultado = PersonaHistoriaLaboralLog.getElemento(param);
			}
			if (opt == 23) {
				Uaa uaa = mapper.readValue(jb.toString(), Uaa.class);
				// UaaTipo uaaTipo= new UaaTipo();
				// uaaTipo.setCodigo(1);
				// uaa.setUaaTipo(uaaTipo);
				uaa.setNombre("");

				Object datos[] = { uaa, usuadmin };
				resultado = UaaLog.getLista(datos);
				//System.out.println("sale "+resultado);
			}
			}catch (IOException e) {
				System.out.println("error "+e+"\n"+jb.toString());
			}
		//}
		return resultado;
		// TODO Auto-generated method stub

	}

	/**
	 * @param request
	 * @return
	 */
	public static Object getElemento(HttpServletRequest request) {
		int tipo = 0;
		String mentodo = request.getParameter("param");
		//System.out.println("metodos  "+mentodo);
		Object parametro = null;
		// if (Session.esSession(request)) {

		Usuario usuadmin = (Usuario) request.getSession().getAttribute("usuarioAdmin");
		System.out.println("usuario --"+Session.getUser(request));
		System.out.println("usuario request ---"+request.getSession().getAttribute("usuario"));
		Usuario usuarioSesion= new Usuario();
		usuarioSesion=Session.getUser(request);
//		System.out.println("metodos JAVIER -->> "+parametro);
		
		if (mentodo.equals("parametro")) {
			WebParametro webParametro= new WebParametro("SGD_URL_SUBIDA_ARCHIVOS");
			
			
			//uaaPersonal.setPersona(persona);
			Mensaje mensaje= new Mensaje();
			mensaje.setResultado( WebParametroLog.getObject(webParametro));
			System.out.println("mensaje  "+mensaje);
			parametro = mensaje;
		}
		if (mentodo.equals("tiposId")) {
			parametro = TipoIdlog.getLista(parametro);
		}
		if (mentodo.equals("gruposSangineo")) {
			parametro = GrupoSangineoLog.getLista(parametro);
		}
		if (mentodo.equals("estratos")) {
			parametro = EstratoLog.getLista(parametro);
		}
		if (mentodo.equals("documentosTipo")) {
			DocumentoTipo documentoTipo= new DocumentoTipo();
			documentoTipo.setCodigo(Integer.parseInt(request.getParameter("codigo")));
			Object datos[] = { documentoTipo, usuadmin };
			parametro = DocumentoTipoLog.getLista(datos);
		}
		if (mentodo.equals("estadosCivil")) {
			parametro = EstadoCivilLog.getLista(parametro);
		}
		if (mentodo.equals("tokenDocumento")) {
			Usuario usuario= new Usuario();
			usuario.setPersona(new Persona(Integer.parseInt(request.getParameter("codigo"))));
			usuario.setUaa(new Uaa(Integer.parseInt(request.getParameter("dependencia"))));
			usuario.setModulo(Integer.parseInt(request.getParameter("modulo")));
			Object datos[] = { usuario, 0 };
			parametro = TokenLog.getTokenDocumento(datos);
		}
		if (mentodo.equals("tokenVerDocumento")) {
			Usuario usuario= new Usuario();
			usuario.setPersona(new Persona(Integer.parseInt(request.getParameter("codigo"))));
			
			Object datos[] = { usuario, 1 };
			parametro = TokenLog.getTokenDocumento(datos);
		}
		if (tipo == 6) {
			parametro = LNXNaturalezaLog.getLista(parametro);
		}
		if (tipo == 7) {
			parametro = LNX_regimenLog.getLista(parametro);
		}
		if (mentodo.equals("persona")) {
			Persona persona= null;
			if(request.getParameter("codigo")!=null) {
				 persona= new Persona(Integer.parseInt(request.getParameter("codigo")));
				 if(usuarioSesion!=null) {
					 if(persona.getCodigo()!=usuarioSesion.getPersona().getCodigo()) {
						 System.out.println("erro esta intentando meter otro codigo "+usuarioSesion.getPersona());
					 	persona.setCodigo(usuarioSesion.getPersona().getCodigo());
					 }
				 }
			}
			if(request.getParameter("identificacion")!=null) {
				 persona= new Persona();
				 persona.setIdentificacion(request.getParameter("identificacion"));
			}
			Object datos[] = { persona, usuadmin };
			parametro = PersonaLog.getObject(datos);
		}
		if (mentodo.equals("epss")) {
			parametro = EpsLog.getLista(parametro);
		}
		if (mentodo.equals("sedes")) {
			Sede sede= new Sede();
			
			boolean estado=false;
			if(request.getParameter("estado").equals("1")) {
				estado=true;
			}
			sede.setEstado(estado);
			Object datos[] = { sede, usuadmin };
			parametro = SedeLog.getLista(datos);
		}
		
		if (mentodo.equals("cargos")) {
			parametro = CargoLog.getLista(parametro);
		}
		if (mentodo.equals("escalafones")) {
			parametro = EscalafonLog.getLista(parametro);
		}
		if (mentodo.equals("escalafonesDocente")) {
			Persona persona= new Persona(Integer.parseInt(request.getParameter("codigo")));
			Object datos[] = { persona, usuadmin };
			parametro = DocenteEscalafonLog.getLista(datos);
		}
		if (mentodo.equals("escalafonDocente")) {
			Persona persona= new Persona(Integer.parseInt(request.getParameter("codigo")));
			DocenteEscalafon docenEscalafon = new DocenteEscalafon();
			docenEscalafon.setCodigo(Integer.parseInt(request.getParameter("id")));
			docenEscalafon.setPersona(persona);
			Object datos[] = { docenEscalafon, usuadmin };
			parametro = DocenteEscalafonLog.getObject(datos);
		}
		if (mentodo.equals("generos")) {
			parametro = GeneroLog.getLista(parametro);
		}
		if (mentodo.equals("institucionesEducativas")) {
			InstitucionEducativa institucion = new InstitucionEducativa();
			institucion.setNombre(request.getParameter("ine_nombre"));
			institucion.setNivel(request.getParameter("ine_nivel"));
			parametro = InstitucionEducativaLog.getLista(institucion);
		}
		if (mentodo.equals("modalidades")) {
			parametro = ModalidadLog.getLista(parametro);
		}
		if (mentodo.equals("jornadas")) {
			parametro = JornadaLog.getLista(parametro);
		}
		if (mentodo.equals("periodos")) {
			Object datos[]= {"","",1};
			parametro = PeriodoLog.getLista(datos);
		}
		if (mentodo.equals("nivelesAcademicos")) {
			parametro = NivelAcademicoLog.getLista(parametro);
		}
		if (mentodo.equals("vinculaciones")) {
			Vinculacion vinculacion= new  Vinculacion();
			if(request.getParameter("clase")!=null) {
				vinculacion.setClase(Integer.parseInt(request.getParameter("clase")));
			}
			Object datos[] = { vinculacion, usuadmin,0 };
			parametro = VinculacionLog.getLista(datos);
		}
		if (mentodo.equals("asignacion")) {
			Vinculacion vinculacion= new  Vinculacion();
			if(request.getParameter("clase")!=null) {
				vinculacion.setClase(Integer.parseInt(request.getParameter("clase")));
			}
			Object datos[] = { vinculacion, usuadmin,1 };
			parametro = VinculacionLog.getLista(datos);
		}
		if (mentodo.equals("dedicaciones")) {
			parametro = DedicacionLog.getLista(parametro);
		}
		if (mentodo.equals("historiaLaboralTipos")) {
			parametro = HistoriaLaboralTipoLog.getLista(parametro);
		}
		if (mentodo.equals("personaHistoriasAcademicas")) {
			Persona persona = new Persona();
			if (request.getParameter("codigo") != null && request.getParameter("codigo").length() > 0) {
				persona.setCodigo(Integer.parseInt(request.getParameter("codigo")));
			}
			Object datos[] = { persona, usuadmin };
			parametro = PersonaHistoriaAcademicaLog.getLista(datos);
		}
		if (mentodo.equals("uaaPersonals")) {
			UaaPersonal uaaPersonal = new UaaPersonal();
			
			if (request.getParameter("codigo") != null && request.getParameter("codigo").length() > 0) {
				uaaPersonal.setPersona(new Persona(Integer.parseInt(request.getParameter("codigo"))));
			}
			if (request.getParameter("vinculacion") != null && request.getParameter("vinculacion").length() > 0) {
				uaaPersonal.setVinculacion(new Vinculacion(Integer.parseInt(request.getParameter("vinculacion"))));
			}
			if (request.getParameter("cargo") != null && request.getParameter("cargo").length() > 0) {
				Cargo cargo = new Cargo(); 
				cargo.setCodigo(Integer.parseInt(request.getParameter("cargo")));
				uaaPersonal.setCargo(cargo);
			}
			Object datos[] = { uaaPersonal, usuadmin,1 };
			parametro = UaaPersonalLog.getPersonasVinculadas(datos);
		}
		if (mentodo.equals("uaasCargo")) {
			UaaCargo uaaCargo = new UaaCargo();
			System.out.println(request.getParameter("nombre"));
			//if (request.getParameter("nombre") != null && request.getParameter("nomnbre").length() > 0) {
				System.out.println(request.getParameter("nombre"));
				Uaa uaa= new Uaa();
				System.out.println(request.getParameter("nombre"));
				uaa.setNombre(request.getParameter("nombre"));
				System.out.println(request.getParameter("nombre"));
				uaaCargo.setUaa(uaa);
				System.out.println(request.getParameter("nombre"));
			//}
			System.out.println(uaaCargo);
			
			Object datos[] = { uaaCargo, usuadmin,1 };
			parametro = UaaCargoLog.getLista(datos);
		}
		if (mentodo.equals("uaaPersonal")) {System.out.println(" entra "+mentodo);
			UaaPersonal uaaPersonal = new UaaPersonal();
			
			if (request.getParameter("codigo") != null && request.getParameter("codigo").length() > 0) {
				uaaPersonal.setPersona(new Persona(Integer.parseInt(request.getParameter("codigo"))));
			}
			if (request.getParameter("id") != null && request.getParameter("id").length() > 0) {
				uaaPersonal.setCodigo(Integer.parseInt(request.getParameter("id")));
			}
			
			Object datos[] = { uaaPersonal, usuadmin,1 };
			parametro = UaaPersonalLog.getObject(datos);
		}
		
		if (mentodo.equals("personaHistoriaAcademica")) {
			System.out.println("entra");
			Persona persona =new	Persona(Integer.parseInt(request.getParameter("per_codigo")));
		
			persona.setHistoriaAcademica(new PersonaHistoriaAcademica());
			persona.getHistoriaAcademica().setCodigo(Integer.parseInt(request.getParameter("codigo")));
			//personaHistoriaAcademica.setPersona();
			Object param[] = { persona, usuadmin, 0 };
			parametro = PersonaHistoriaAcademicaLog.getElemento(param);
		}
		if (mentodo.equals("personaHistoriasLaborales")) {
			Persona persona = new Persona();
			if (request.getParameter("codigo") != null && request.getParameter("codigo").length() > 0) {
				persona.setCodigo(Integer.parseInt(request.getParameter("codigo")));
			}
			Object datos[] = { persona, usuadmin };
			parametro = PersonaHistoriaLaboralLog.getLista(datos);
		}
		if (mentodo.equals("personaHistoriaLaboral")) {

			PersonaHistoriaLaboral historiaLaboral =new	PersonaHistoriaLaboral();
			
			historiaLaboral.setCodigo(Integer.parseInt(request.getParameter("codigo")));
			Persona persona=new Persona(Integer.parseInt(request.getParameter("per_codigo")));
			persona.setHistoriaLaboral(historiaLaboral);
			System.out.println(persona);
			Object param[] = { persona, usuadmin, 0 };
			parametro = PersonaHistoriaLaboralLog.getElemento(param);
		}
		
		
		if (tipo == 16) {
			Object datos[] = { null, usuadmin };
			parametro = HistoriaLaboralTipoLog.getLista(datos);
		}
		if (tipo == 17) {
			parametro = VinculacionLog.getLista(parametro);
		}
		if (tipo == 18) {
			parametro = DedicacionLog.getLista(parametro);
		}
		if (tipo == 19) {
			PersonaHistoriaLaboral personaHistoriaLaboral = new PersonaHistoriaLaboral();

			if (request.getParameter("per_codigo") != null && request.getParameter("per_codigo").length() > 0) {
			//	personaHistoriaLaboral.getPersona().setCodigo(Integer.parseInt(request.getParameter("per_codigo")));
			}
			Object datos[] = { personaHistoriaLaboral, usuadmin };
			parametro = PersonaHistoriaLaboralLog.getLista(datos);
		}

		if (tipo == 21) {
			Object datos[] = { null, usuadmin };
			parametro = CargoLog.getLista(datos);
		}
		if (tipo == 22) {
			Documento documento = new Documento();

			if (request.getParameter("per_codigo") != null && request.getParameter("per_codigo").length() > 0) {
				UaaPersonal uaaPersonal = new UaaPersonal();
				uaaPersonal.setPersona(new Persona(Integer.parseInt(request.getParameter("per_codigo"))));
				//documento.setPropietario(uaaPersonal);
			}
			Object datos[] = { documento, usuadmin };
			parametro = DocumentoLog.getLista(datos);
		}

		if (mentodo.equals("uaas")) {
			Uaa uaa = new Uaa();
			UaaTipo uaaTipo = new UaaTipo();
			//uaaTipo.setCodigo(-1);
			
			if (request.getParameter("codigo") != null) {
				uaaTipo.setCodigo(Integer.parseInt(request.getParameter("codigo") ));
			}
			uaa.setUaaTipo(uaaTipo);
			uaa.setNombre(request.getParameter("nombre"));
			Object datos[] = { uaa, usuadmin };
			parametro = UaaLog.getLista(datos);
			// System.out.println(combo);
		}

		
		if (tipo == 23) {
			Uaa uaa = new Uaa();
			UaaTipo uaaTipo = new UaaTipo();
			uaaTipo.setCodigo(1);
			uaa.setUaaTipo(uaaTipo);
			if (request.getParameter("nombre") != null) {
				uaa.setNombre(request.getParameter("nombre"));
			} else {
				uaa.setNombre("");
			}

			Object datos[] = { uaa, usuadmin };
			parametro = UaaLog.getLista(datos);
			// System.out.println(combo);
		}

		// }
		return parametro;
	}
}
