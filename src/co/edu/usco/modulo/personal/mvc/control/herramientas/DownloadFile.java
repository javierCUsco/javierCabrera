package co.edu.usco.modulo.personal.mvc.control.herramientas;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.logica.WebParametroLog;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.WebParametro;
import co.edu.usco.seguridad.Path;

/**
 * Servlet implementation class DownloadFile
 */
@WebServlet("/DownloadFile")
public class DownloadFile extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static Logger LOGGER = null;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public DownloadFile() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		// response.getWriter().append("Served at:
//		// ").append(request.getContextPath());
//
//		getFile(request, response);
//	}
//
//	protected void getFile(HttpServletRequest request, HttpServletResponse response) {
//		LOGGER = Logger.getLogger(getClass().getName());
//		// BaseDato basedato = new BaseDato();
//		LOGGER.info("1 en load filePart inicio ");
//		try {
//			Persona persona = new Persona();
//			String requestedFile = request.getParameter("file");
//			if (requestedFile == null) {
//				response.sendError(404);
//				return;
//			}
//			persona.getArchivo().setArchivoMd5(requestedFile);
//			persona.setCodigo(Integer.parseInt(request.getParameter("per_codigo")));
//			File file = null;
//			WebParametro paramtro = (WebParametro) WebParametroLog.getObject(null);
//			persona.getArchivo().setRepositorio(paramtro.getValor());
//			String url = (Path.getDirectorio(persona, file.separator) + file.separator	+ persona.getArchivo().getArchivoMd5());
//
//			System.out.println(request.getServletPath());
//
//			System.out.println(url);
//			file = new File(url);
//
//			if (!file.exists()) {
//				response.sendError(404);
//				return;
//			}
//			
//			ServletContext context = getServletConfig().getServletContext();
//			String contentType = getServletContext().getMimeType(file.getName());
//			System.out.println(file);
//			if (contentType == null) {
//				contentType = "application/octet-stream";
//			}
//			System.out.println("pasa 1");
//			// temporal
//			contentType = "application/pdf";
//
//			response.reset();
////			response.setBufferSize(10240);
//			response.setContentType(contentType);
//			
//			response.setHeader("Content-Disposition", "inline; filename=" + persona.getArchivo().getArchivo());
//			response.setHeader("Content-Length", String.valueOf(file.length()));
//			System.out.println("pasa 1");
//
//			BufferedInputStream input = null;
//			BufferedOutputStream output = null;
//
//			try {
//				input = new BufferedInputStream(new FileInputStream(file), 10240);
//				output = new BufferedOutputStream(response.getOutputStream(), 10240);
//
//				byte[] buffer = new byte[10240];
//				int length;
//				while ((length = input.read(buffer)) > 0) {
//					output.write(buffer, 0, length);
//				}
//			} finally {
//				output.close();
//				input.close();
//			}
//			System.out.println("pasa 2");
//
//		} catch (FileNotFoundException fne) {
//			// writer.println("You either did not specify a file to upload or
//			// are " + "trying to upload a file to a protected or nonexistent "
//			// + "location.");
//			// writer.println("<br/> ERROR: " + fne.getMessage());
//
//			LOGGER.error("Problems during file upload. Error: {0}" + fne.getMessage());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
